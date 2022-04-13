import scala.concurrent.ExecutionContext.Implicits.global
import scala.io.Source
import java.sql.DriverManager
import java.sql.Connection
import java.sql.ResultSet
import java.sql._
import org.eclipse.jetty.util.log.Slf4jLog

object Main {
  
	def main(args: scala.Array[String]): Unit = {
		Db.start()
		printHelp(); println();
		update()
	}

	def update() : Unit = {
		
		var execute = true
		
		while (execute) {
		
			try {
			
				Console.println("Enter Command: help, mostRatings, topInGenre, topInYear, topWithRatings, exit")
				
				val input = scala.io.StdIn.readLine()
				
				println()

				if (input == null || input.isEmpty()) { Console.println("Command not recognized.") }

				else if (input == "quit" || input == "exit" || input == "stop") { execute = false }

				else if (input == "help") { printHelp(); }
				
				else if (input == "mostRatings") {
					var results = Db.result(s"SELECT COUNT(ratings.rating) AS votes, movies.title FROM movies JOIN ratings ON movies.movieid = ratings.movieid GROUP BY movies.title ORDER BY votes DESC LIMIT ${getInput("the number of results you want to display.")}");
					println("Movies with the most ratings:")
					Db.printResults(results, 2); println();
				}

				else if (input == "topInGenre") {
					var results = Db.result(s"SELECT count (ratings.rating) AS votes, AVG(ratings.rating) AS avgratings, movies.title FROM movies JOIN ratings ON movies.movieid = ratings.movieid WHERE movies.genre LIKE '%${getInput("a genre.")}%' GROUP BY movies.title ORDER BY avgratings DESC, votes DESC LIMIT ${getInput("the number of results you want to display.")}");
					println("Vote count, Average rating, and movie title for the top rated movies in your selected genre:")
					Db.printResults(results, 3); println();
				}

				else if (input == "topInYear") {
					var results = Db.result(s"SELECT movies.year, AVG(ratings.rating) AS avg_ratings, movies.title FROM movies JOIN ratings ON movies.movieid = ratings.movieid WHERE movies.year = ${getInput("the 4-digit release year.")} GROUP BY movies.title, movies.year ORDER BY avg_ratings DESC LIMIT ${getInput("the number of results you want to display.")}");
					println("Average rating, year, and movie title of the top movies:")
					Db.printResults(results, 3); println();
					// while (results.next()) {
					// 	try { println(s"${results.getFloat(2).toString()}, (${results.getString(1)}) ${results.getString(3)}") }
					// 	catch { case a: Any => println("Failed to print movie.") }
					// }
				}

				else if (input == "topWithRatings") {
					var requiredRatings = getInput("the minimum number of ratings required.");
					var resultCount = getInput("the number of results you want to display.");
					var results = Db.result(s"SELECT results.* FROM (SELECT AVG(ratings.rating) AS avgratings, COUNT(ratings.rating) AS votes, movies.title FROM movies JOIN ratings ON movies.movieid = ratings.movieid GROUP BY movies.title) results WHERE results.votes > $requiredRatings ORDER BY avgratings DESC LIMIT $resultCount");
					println(s"Top movies with at least $requiredRatings ratings:")
					Db.printResults(results, 3); println();
				}

				else { Console.println("Command not recognized.") }
			
			}
			catch {
				case a : Any => Console.println("An error occured. Try again.")
			}

		}

		Console.println("Application stopped.")

	}

	def getInput(argName: String) : String = {
		Console.println(s"Please enter $argName");
		val arg = scala.io.StdIn.readLine();
		if (arg == null || arg.isEmpty()) { 
			Console.println(s"Invalid $argName. Command failed.");
			return null;
		}
		return arg;
	}

	def printHelp() : Unit = {
		println()
		println("          help: Display information about each command.")
		println("   mostRatings: Display movies with the most ratings.")
		println("    topInGenre: Display top rated movies in a specific genre.")
		println("     topInYear: Display top rated movies in a specific year.")
		println("topWithRatings: Display top rated movies with at least a specific number of ratings.")
		println("          exit: Exit the application.")
		println()
	}

}

object Db {
  
	val driver = "org.apache.hive.jdbc.HiveDriver"

	var connection: Connection = null

	def start() : Unit = {
		
		println("Connecting to database.")
		
		try {
			Class.forName(driver)
			connection = DriverManager.getConnection("jdbc:hive2://174.103.197.148:10000/alex", "hive", "hive")
			else { println("Failed to connect to database.") }
		}
		catch {
			case a : Any => Console.println("An error occurred: " + a.toString())
			return	
		}

		println("Successfully connected to database.")

	}

	def query(sqlQuery: String): Unit = {
		val query = connection.createStatement()
		query.executeUpdate(sqlQuery)
	}

	def result(sqlQuery: String): ResultSet = {
		val query = connection.createStatement()
		return query.executeQuery(sqlQuery)
	}

	// prints all movies in the resultset, expects default movies table entry
	// {movieid int, title string, year int, genre string}
	def printMovies(results: ResultSet): Unit = {
		while (results.next()) {
			try { println(s"[${results.getInt(1)}] | ${results.getString(2)} (${results.getInt(3)}) | ${results.getString(4)}") }
			catch { case a: Any => println("Failed to print a movie.") }
		}
	}

	def printResults(results: ResultSet, columnCount: Int): Unit = {
		while (results.next()) {
			try { 
				
				var output = results.getString(1)
				
				if (output.matches("\\d\\.\\d\\d.*")) { output = output.substring(0, 4); }
				else if (output.matches("\\d\\.\\d")) { output = output.substring(0, 3) + "0"; }
				else if (output.matches("\\d\\d")) { output = "0" + output; }
				else if (output.matches("\\d")) { output = "00" + output; }
				else if (output.matches("\\\".*")) { 
					output = output.substring(1, output.length()); 
					if (output.last == '"') { output = output.substring(0, output.length()); }
				}

				var nextString = ""

				for (i <- 2 until (columnCount + 1)) {
					nextString = results.getString(i);
					if (nextString.matches("\\d\\.\\d\\d.*")) { nextString = nextString.substring(0, 4); }
					else if (nextString.matches("\\d\\.\\d")) { nextString = nextString.substring(0, 3) + "0"; }
					else if (nextString.matches("\\d\\d")) { nextString = "0" + nextString; }
					else if (nextString.matches("\\d")) { nextString = "00" + nextString; }
					else if (nextString.matches("\\\".*")) { 
						nextString = nextString.substring(1, nextString.length());
						if (nextString.last == '"') { nextString = nextString.substring(0, nextString.length()); }
					}
					output = output + ", " + nextString
				}
				println(output)
			}
			catch { case a: Any => println("Failed to print a result.") }
		}
	}



}