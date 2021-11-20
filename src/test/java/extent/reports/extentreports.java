package extent.reports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentreports {
	ExtentReports extend;

	@BeforeTest
	public void config() {
		String path = System.getProperty("usr.dir") + "\\reports\\index.html";
		ExtentSparkReporter report = new ExtentSparkReporter(path);
		report.config().setReportName("pramod report");
		report.config().setDocumentTitle("Rocky document");

		extend = new ExtentReports();
		extend.attachReporter(report);
		extend.setSystemInfo("Tester", "Pramod Rocky");

	}

	@Test
	public void login() {
		ExtentTest test=extend.createTest("My First Report");

		System.setProperty("webdriver.chrome.driver", "/home/pramodp/Downloads/selenium/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.getTitle());
		test.fail("fail this" );
		extend.flush();

	}
}
