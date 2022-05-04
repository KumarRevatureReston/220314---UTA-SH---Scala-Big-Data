import org.apache.spark.sql.DataFrame

spark.sql("use gold_team")

def averageWeeklySales() : DataFrame = { return spark.sql("SELECT dept, AVG(weekly_sales) as wavg FROM train GROUP BY dept ORDER BY wavg DESC") }

def storesHighestAverageSales() : DataFrame = { return spark.sql("SELECT sub.store, ROUND(SUM(sub.average),2) AS avg_wkly_sales FROM (SELECT store, dept, AVG(sales) AS average FROM public.train GROUP BY store, dept ORDER BY store DESC) AS sub GROUP BY store ORDER BY avg_wkly_sales DESC") }

def holidaySalesDifference() : DataFrame = { return spark.sql("SELECT COALESCE(a.dept, b.dept) dept, COALESCE(a.hol_avg) hol_avg, COALESCE(b.non_hol_avg) non_hol_avg, COALESCE(a.hol_avg - b.non_hol_avg) difference FROM (SELECT dept, AVG(weekly_sales) AS hol_avg FROM train WHERE is_holiday = TRUE GROUP BY dept) a FULL JOIN (SELECT dept, AVG(weekly_sales) AS non_hol_avg FROM train WHERE is_holiday = FALSE GROUP BY dept) b ON a.dept = b.dept ORDER BY dept") }

def bestMonthDepartments() : DataFrame = { return spark.sql("SELECT * FROM (SELECT AVG(weekly_sales) AS avg_sales, dept, EXTRACT(MONTH FROM DATE) AS  Month,  ROW_NUMBER() over( PARTITION BY dept ORDER BY avg(weeKly_sales) DESC) AS dept_rank  FROM train GROUP BY Month, dept ) AS subq WHERE dept_rank = 1") }

def topTenDepartments() : DataFrame = { return spark.sql("SELECT q2.yr, q2.rnk, q2.dpt, q2.avgs FROM  (SELECT q1.Dept AS dpt, q1.tyear AS yr, q1.avg_sales as avgs, rank() over (partition by q1.tyear order by q1.avg_sales desc) rnk FROM(SELECT Dept, EXTRACT(YEAR FROM Date) as tyear, CAST (AVG(Weekly_Sales) AS numeric(10,2)) AS avg_sales FROM train GROUP BY Dept, tyear ORDER BY Dept, tyear) q1 ) q2 WHERE q2.rnk <= 10 ORDER BY q2.yr, q2.rnk") }