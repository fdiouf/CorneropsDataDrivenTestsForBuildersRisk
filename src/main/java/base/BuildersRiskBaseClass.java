package base;
 
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.awt.Desktop;
import java.io.File;
import java.time.LocalDateTime;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import actiondriver.Action;
import actiondriver.ReusableMethods;
 
public class BuildersRiskBaseClass {
	
	public static Properties loc = new Properties();
	public static FileReader fr1;
	public static WebDriver driver;
	public static String screenshotSubFolderName;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	
	public Map<String, Object> vars;
	JavascriptExecutor js;
	public static Properties prop = new Properties();
	public static FileReader fr;


	@BeforeTest
//	@Parameters("browserName")
	public void setUp(ITestContext context) throws IOException {
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("autofill.profile_enabled", false);
		prefs.put("profile.password_manager_enabled", false);
		prefs.put("profile.default_content_setting_values.notifications", 2);
		options.setExperimentalOption("prefs", prefs);
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		options.addArguments("force-device-scale-factor=0.8");
		options.addArguments("high-dpi-support=0.8");

		if (driver == null) {
			FileReader fr = new FileReader(System.getProperty("user.dir")
					+ "\\src\\test\\resources\\buildersriskconfigfiles\\buildersriskconfig.properties");
			FileReader fr1 = new FileReader(System.getProperty("user.dir")
					+ "\\src\\test\\resources\\buildersriskconfigfiles\\buildersrisklocators.properties");
			prop.load(fr);
			loc.load(fr1);
		}
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.get(prop.getProperty("testurl"));
		} else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("testurl"));
		} else if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("testurl"));
		}
		Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
		String device = capabilities.getBrowserName() + " "
				+ capabilities.getBrowserVersion(); //.substring(0, capabilities.getBrowserVersion().indexOf("."))
//		String author = context.getCurrentXmlTest().getParameter("author");

		extentTest = extentReports.createTest(context.getName());
//		extentTest.assignAuthor(author);
		extentTest.assignDevice(device);

		Action.implicitWait(driver, 10);
		Action.pageLoadTimeOut(driver, 30);
		driver.get(prop.getProperty("testurl"));
		ReusableMethods.loginIsi();

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@BeforeSuite
	public void initializeExtentReports() {
		ExtentSparkReporter spakReporter_all = new ExtentSparkReporter("AllTest.html");
		spakReporter_all.config().setDocumentTitle("Simple Automation Report");
		spakReporter_all.config().setReportName("Automation Test Report");
		spakReporter_all.config().setTheme(Theme.STANDARD);
		extentReports = new ExtentReports();
		extentReports.attachReporter(spakReporter_all);
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
//		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
		extentReports.setSystemInfo("User", System.getProperty("user.home"));
		extentReports.setSystemInfo("ProjectName", "Cornerops");
		extentReports.setSystemInfo("Testers", "Carlos and Filinto");
 

	}

	@AfterSuite
	public void generateExtentReports() throws Exception {
		extentReports.flush();
		Desktop.getDesktop().browse(new File("AllTest.html").toURI());

	}

	@AfterMethod
	public void checkStatus(Method m, ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			String screenshotPath = null;
			screenshotPath = captureScreenshot(
					result.getTestContext().getName() + "_" + result.getMethod().getMethodName() + ".jpg");
			extentTest.addScreenCaptureFromPath(screenshotPath);
			extentTest.fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.pass(m.getName() + " is passed");
		}

	}

	public static String captureScreenshot(String fileName) {

		if (screenshotSubFolderName == null) {
			LocalDateTime myDateObj = LocalDateTime.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MMddyyyyHHmmss");

			screenshotSubFolderName = myDateObj.format(myFormatObj);
		}
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshots/" + screenshotSubFolderName + "/" + fileName);

		try {
			FileUtils.copyFile(sourceFile, destFile);
		} catch (IOException e) {

			e.printStackTrace();
		}
		System.out.println("\nScreenshot saved successfuly");
		return destFile.getAbsolutePath();
	}

}