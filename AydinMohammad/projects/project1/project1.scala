

import java.awt.BorderLayout
import java.awt.Dimension
import javax.swing.JFrame
import javax.swing.JScrollPane
import javax.swing.JTextArea
import javax.swing._;
import javax.swing.plaf.DimensionUIResource;
import java.awt._;
import java.awt.event._;
import java.util.ArrayList;
import java.awt.Color;
import scala.swing.MainFrame
import javax.swing.table.DefaultTableModel
import java.util.Vector
import java.util.Collection

import java.sql.DriverManager
import java.sql.Connection
import java.sql.Statement
import scala.io.StdIn.readLine
import scala.io.StdIn.readChar;
import scala.io.StdIn.readBoolean;




    class SwingExample extends JFrame {
	//jdbs connection
		var connection:Connection = null
		var statement:Statement=null;
    
	//Constant Values 
		val WIDTH=680;
		val HEIGHT=550;
			
		val LIGHTBLUE = new Color (204, 230, 255);
		val RADIOCOLOR = new Color(0,0,0)
		val FontType= "Arial";

		var pnlTitle = new JPanel();
		var pnlBody1 = new JPanel(new GridLayout(2,1));
		var pnlBody11 = new JPanel(new GridLayout(1,2))
		var pnlBody111 = new JPanel(new GridLayout(5,1));
		var pnlBody112 = new JPanel();
		var pnlBody12 = new JPanel();

		var pnlBody1111 = new JPanel()
		var pnlBody1112 = new JPanel()
		var pnlBody1113 = new JPanel()
		var pnlBody1114 = new JPanel()
		var pnlBody1115 = new JPanel()
		//create the list
		//Title
		var lblTitle = new JLabel("Hadoop and Scala");
		lblTitle.setFont(new Font("FontType",0,32));
		lblTitle.setForeground(new Color(0, 53, 102));
		
		//RadioButtons options
		var group = new ButtonGroup();
		var rbtQuery1 = new JRadioButton("TOP RATED ACTION AND COMEDY")
        var rbtQuery2 = new JRadioButton("HIGHEST RATED USER FOR THE YEAR")
        var rbtQuery3 = new JRadioButton("TOP 10 RANKING MOVIES FOR THE YEAR");
        var rbtQuery4 = new JRadioButton("TOP RATED MOVIES WITH 50 VIEWS")
        var rbtQuery5 = new JRadioButton("EXPLODED VIEW MOVIE");

		group.add(rbtQuery1)
		group.add(rbtQuery2)
		group.add(rbtQuery3)
		group.add(rbtQuery4)
		group.add(rbtQuery5)

		//Table result of queries
		var tblResult=new JTable()
		//Specific year for a query		
		var txtYear = new JTextField("1995",6);
		var txtYear1 = new JTextField("1995",6);

		//Buttons for exequte queires
		var btnExecute=new JButton("Execute");
		var btnclose = new JButton("Close");
        var scrPanel=new JScrollPane();
		scrPanel.setPreferredSize(new Dimension(500,200))
		
		//add elements to panels
		pnlBody1111.add(rbtQuery1)
		pnlBody1112.add(rbtQuery2);
		pnlBody1112.add(txtYear);
		pnlBody1113.add(rbtQuery3)
		pnlBody1113.add(txtYear1)
		pnlBody1114.add(rbtQuery4)
		pnlBody1115.add(rbtQuery5)

		pnlBody111.add(pnlBody1111)		
		pnlBody111.add(pnlBody1112)		
		pnlBody111.add(pnlBody1113)		
		pnlBody111.add(pnlBody1114)		
		pnlBody111.add(pnlBody1115)	

		pnlBody112.add(btnExecute)
		pnlBody112.add(btnclose)

		pnlBody11.add(pnlBody111)
		pnlBody11.add(pnlBody112)
		pnlBody12.add(scrPanel)
		//pnlBody13.add(tblResult)	
		
		
		// add panel to panel body
		pnlTitle.add(lblTitle);
			
		pnlBody1.add(pnlBody11);
		pnlBody1.add(pnlBody12)
	
	
    
	
	//Constructor
	    def Init(){
			val driver = "org.apache.hive.jdbc.HiveDriver"
			val url = "jdbc:hive2://localhost:10000/movielens"
			val username = "hive"
			val password = "mohammad.17"
			try {
				// make the connection
				connection = DriverManager.getConnection(url, username, password)
			} 
			catch {
				case e => e.printStackTrace
			}
			statement=connection.createStatement();

			setLayout(new BorderLayout());
			setSize(new Dimension(WIDTH, HEIGHT));
			setResizable(true);

			//Colors text and background
			rbtQuery1.setBackground(LIGHTBLUE)
			rbtQuery1.setForeground(RADIOCOLOR)
			rbtQuery2.setBackground(LIGHTBLUE)
			rbtQuery2.setForeground(RADIOCOLOR)
			rbtQuery3.setBackground(LIGHTBLUE)
			rbtQuery3.setForeground(RADIOCOLOR)
			rbtQuery4.setBackground(LIGHTBLUE)
			rbtQuery4.setForeground(RADIOCOLOR)
			rbtQuery5.setBackground(LIGHTBLUE)
			rbtQuery5.setForeground(RADIOCOLOR)
			
			
			this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			
			//call createPanel()
			guiFlWind();
			
			
			this.setVisible(true);
	    }
	def guiFlWind() {
		
		//panel declarations 
		

		// add panels to form
		add(pnlTitle, BorderLayout.NORTH);
		add(pnlBody1, BorderLayout.CENTER);
		pnlBody1111.setLayout(new BoxLayout(pnlBody1111,BoxLayout.Y_AXIS))
		pnlBody1112.setLayout(new FlowLayout())
		pnlBody1113.setLayout(new FlowLayout())
		pnlBody1114.setLayout(new BoxLayout(pnlBody1114,BoxLayout.Y_AXIS))
		pnlBody1115.setLayout(new BoxLayout(pnlBody1115,BoxLayout.Y_AXIS))

		// adding colors 
		pnlTitle.setBackground(LIGHTBLUE);
		pnlBody1.setBackground(LIGHTBLUE);
		pnlBody11.setBackground(LIGHTBLUE);
		pnlBody12.setBackground(LIGHTBLUE);
		pnlBody111.setBackground(LIGHTBLUE)
		pnlBody112.setBackground(LIGHTBLUE)

		pnlBody1111.setBackground(LIGHTBLUE)		
		pnlBody1112.setBackground(LIGHTBLUE)		
		pnlBody1113.setBackground(LIGHTBLUE)		
		pnlBody1114.setBackground(LIGHTBLUE)		
		pnlBody1115.setBackground(LIGHTBLUE)		
	
		//add listeners
		btnExecute.addActionListener(new ExecuteQuery());
		btnclose.addActionListener(new CloseWindow());

		//btnReserve.addActionListener(new ButtonReserve());
	}

	//functions for queries
    def question1()
    {
      var query = "SELECT movieid,title,COUNT(rating) count_rat FROM (SELECT r.movieid as movieid,userid,rating,title,genres FROM ratings r INNER JOIN movies m ON r.movieid=m.movieid WHERE array_contains(genres,'Comedy') AND array_contains(genres,'Action')) m GROUP BY movieid,title ORDER BY count_rat DESC LIMIT 1";
      executeQuery(query)
    }
    def question2()
    {
      var year=txtYear.getText();
      var query="SELECT u.userid, u.age, x.avg from users u join (SELECT r.userid,avg(rating) avg FROM (SELECT r.movieid,userid,rating,title FROM ratings r INNER JOIN movies m ON r.movieid=m.movieid WHERE title LIKE '%"+year+"%') r GROUP BY (r.userid) ORDER BY avg DESC LIMIT 1)x WHERE u.userid = x.userid";
      if(year!="")
	  	executeQuery(query);
    }
    def question3()
    {
	  var year=txtYear1.getText();	
      var query="SELECT DISTINCT title,avg_rat FROM(SELECT movieid,AVG(rating) as avg_rat FROM ratings GROUP BY movieid) AS avg_mov INNER JOIN movies ON avg_mov.movieid=movies.movieid WHERE title LIKE('%("+year+"%') ORDER BY avg_rat DESC LIMIT 10";
      executeQuery(query);
    }
    def question4()
    {
      var query="SELECT DISTINCT title FROM(SELECT t.movieid,avg(rating) as avg_rat FROM(SELECT COUNT(*) as count,movieid FROM ratings GROUP BY movieid HAVING count>50)t INNER JOIN ratings ON ratings.movieid=t.movieid GROUP BY t.movieid ORDER BY avg_rat DESC)q INNER JOIN movies ON movies.movieid=q.movieid LIMIT 25";
      executeQuery(query);
    }
    def question5()
    {
      var query="SELECT movieid,title,genre FROM movies LATERAL VIEW EXPLODE(genres) genres_set AS genre LIMIT 10";
      executeQuery(query);
    }

	//function to execute queries
    def executeQuery(query:String)
    {
      var resultSet = statement.executeQuery(query);
      var metadata= resultSet.getMetaData();
      var columnCount=metadata.getColumnCount();
	  var tableModel = new DefaultTableModel()

	  //Add headers to the table				
      for (i <- 1 to columnCount)
      {  
		tableModel.addColumn(metadata.getColumnName(i))
      }
	  //Add result rows from queries to the table
      while(resultSet.next)
      {
	    var vector=new java.util.Vector[String]
	    for (i <- 1 to columnCount) {
			vector.add(resultSet.getString(i))
        }
		tableModel.addRow(vector)
      }
	  //Update table
	  tblResult=new JTable(tableModel)
	  scrPanel=new JScrollPane(tblResult);
	  scrPanel.setPreferredSize(new Dimension(400,100))
	  pnlBody12.removeAll();
	  pnlBody12.add(scrPanel)
	  pnlBody1.updateUI()
    }

	//Button Execute Function
    class ExecuteQuery extends ActionListener
	{
		def actionPerformed(e:ActionEvent) {
			// TODO Auto-generated method stub
			if(rbtQuery1.isSelected())
			{
				question1();
			}
			if(rbtQuery2.isSelected())
			{
				question2();
			}
			if(rbtQuery3.isSelected())
			{
				question3();
			}
			if(rbtQuery4.isSelected())
			{
				question4();
			}
			if(rbtQuery5.isSelected())
			{
				question5();
			}
		}
		
	}
    
	//Button Close function
    class CloseWindow extends ActionListener
	{
		def actionPerformed(e:ActionEvent) {
			// TODO Auto-generated method stub
			dispose();
		}
		
	}
}

//Main object 
object MySwing
{
    def main(args:Array[String])
    {
      var MyWindow=new SwingExample();
      MyWindow.Init()
    }
}