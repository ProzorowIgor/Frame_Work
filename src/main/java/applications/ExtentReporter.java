package applications;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.Reporter;

public class ExtentReporter {
    private static Reporter instance = null;
    public ExtentReports extents;
    public ExtentTest test;
    ExtentSparkReporter spark;


    private ExtentReporter(){
       // extents = new ExtentReports("target/Spark.html");
        spark = new ExtentSparkReporter(System.getProperty("user.dir") + "Report.html");
    }

    synchronized public static Reporter getInstance(){
        if(instance == null) {
            instance = new Reporter();
            return instance;
        }
        else {
            return instance;
        }
    }



}
