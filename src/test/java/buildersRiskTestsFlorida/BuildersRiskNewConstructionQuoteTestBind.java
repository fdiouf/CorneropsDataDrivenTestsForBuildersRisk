package buildersRiskTestsFlorida;														// THIS TEST RUNS FOR 2 MINUTES AND 14 SECONDS

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import actiondriver.Action;
import actiondriver.ReusableMethods;
import base.BuildersRiskBaseClass;
import utilities.XLUtility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@SuppressWarnings("unused")
public class BuildersRiskNewConstructionQuoteTestBind extends BuildersRiskBaseClass {
	
	@AfterMethod
	public void restart() throws IOException {
		driver.get(prop.getProperty("testurl"));
		ReusableMethods.loginIsi();
	}

	@DataProvider(name = "NewConstructionData")
	public String[][] getData() throws IOException {
		// Get data from Excel
		String path = ".\\src\\main\\resources\\data\\BuilderRiskData.xlsx";
		XLUtility xlutil = new XLUtility(path);

		int totalrows = xlutil.getRowCount("FLNewConstructionPolicyDataBIND");
		int totalcols = xlutil.getCellCount("FLNewConstructionPolicyDataBIND", 1);

		String loginData[][] = new String[totalrows][totalcols];

		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				loginData[i - 1][j] = xlutil.getCellData("FLNewConstructionPolicyDataBIND", i, j);
			}
		}
		return loginData;
	}

	@Test(dataProvider = "NewConstructionData", description = "Builders Risk Start Quote Walkthrough", enabled = true, priority = 0)
	public void buildersRiskNewPolicy(String newquotestate, String newquotepolicytype, String newquoteaddress,
			String newquoteaddress2, String newquotecity, String newquotezipcode, String agentcode,
			String buildersprojecttype, String builderspolicyterm, String buildersapplicantphone,
			String buildersapplicantemail, String buildersapplicanttype, String buildersnametype,
			String buildersfirstname, String buildersmiddlename, String builderslastname, String builderssuffixname,
			String buildersbusinessname, String buildersdbaname, String buildersstructure,
			String buildersmailingaddress, String buildersmailingaddress2, String buildersmailingcity,
			String buildersmailingstate, String buildersmailingzip, String buildersmailingzip4,
			String builderslocationzip4, String builderscounty, String builderscoastdistance,
			String builderscoastdistanceunit, String builderswindpool, String buildersterritory,
			String builderssinkholedistance, String builderssinkholedistanceunits, String buildersprotectionclass,
			String buildersfirestation, String buildersfirehydrant, String builderscompletedvalue,
			String buildersdeductible, String builderswindhaildeductible, String buildersconstructioncostlimit,
			String builderspropertytransitlimit, String builderssoftcostlimit, String buildersstructuretype,
			String buildersconstructionyear, String builderselectricalyear, String buildersroofingyear,
			String buildersplumbingyear, String buildershvacyear, String builderssquarefootage, String buildersroofmaterial,
			String buildersconstructiontype, String builderspriorinscarrier, String buildersnumberofstories,
			String builderspriorinsenddate, String builderspriorinspremium, String buildersinteresttype,
			String buildersinterestname, String buildersinterestaddress, String buildersinterestaddress2,
			String buildersinterestcity, String buildersintereststate, String buildersinterestzip,
			String buildersinterestzip4, String buildersloannumber, String builderstinsuredtype,
			String builderstinsuredfirstname, String builderstinsuredmiddlename, String builderstinsuredlastname,
			String builderstinsuredaddress, String builderstinsuredaddress2, String builderstinsuredcity,
			String builderstinsuredstate, String builderstinsuredzip, String builderslegalname,
			String buildersconstructionstarted, String buildersconstructionstartdate, String builderspercentcomplete,
			String builderscrimescore, String builderscrimetext, String builderssecuritydesc,
			String builderssecuritypoints, String buildersjudgementrate, String buildersjudgementreason)
			throws InterruptedException, ParseException {

		ReusableMethods.switchToFLInternal();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath(loc.getProperty("topmenustart"))).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(loc.getProperty("topmenustartanewquote"))).click();
		driver.switchTo().frame(0);
		if(!newquotestate.equalsIgnoreCase("Florida")) {
			Assert.fail("RAN FLORIDA TEST WITH TEXAS ADDRESS");
			driver.quit();
		}
		driver.findElement(By.xpath(loc.getProperty("newquotestate"))).click();
		driver.findElement(By.xpath(loc.getProperty("newquotestate"))).sendKeys(newquotestate);
	    driver.findElement(By.xpath(loc.getProperty("newquotestate"))).click();
		driver.findElement(By.xpath(loc.getProperty("newquotepolicytype"))).click();
		driver.findElement(By.xpath(loc.getProperty("newquoteaddress"))).click();
		driver.findElement(By.xpath(loc.getProperty("newquoteaddress"))).sendKeys(newquoteaddress);
		driver.findElement(By.xpath(loc.getProperty("newquoteaddress2"))).click();
		driver.findElement(By.xpath(loc.getProperty("newquoteaddress2"))).sendKeys(newquoteaddress2);
		driver.findElement(By.xpath(loc.getProperty("newquotecity"))).click();
		driver.findElement(By.xpath(loc.getProperty("newquotecity"))).sendKeys(newquotecity);
		driver.findElement(By.xpath(loc.getProperty("newquotezipcode"))).click();
		driver.findElement(By.xpath(loc.getProperty("newquotezipcode"))).sendKeys(newquotezipcode);
		driver.findElement(By.xpath(loc.getProperty("buildersstartquote"))).click();
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			Thread.sleep(1000);
		}
		driver.findElement(By.xpath(loc.getProperty("buildersstartquote"))).click();
		driver.findElement(By.xpath(loc.getProperty("agentlookup"))).click();
		Thread.sleep(5000);
		WebElement agCode = driver.findElement(By.id(loc.getProperty("agentcode")));
		driver.findElement(By.id(loc.getProperty("agentcode"))).click();
		driver.findElement(By.id(loc.getProperty("agentcode"))).sendKeys(agentcode);
		new Actions(driver).moveToElement(agCode).keyDown(Keys.SHIFT).click().keyUp(Keys.SHIFT).build().perform();
		Thread.sleep(5000);
		try {
			Thread.sleep(1000);driver.findElement(By.xpath(loc.getProperty("firstagentshown"))).click();
		} catch (Exception e) {
			driver.findElement(By.id(loc.getProperty("agentcode"))).click();
			driver.findElement(By.id(loc.getProperty("agentcode"))).clear();
			driver.findElement(By.id(loc.getProperty("agentcode"))).sendKeys(agentcode);
			new Actions(driver).moveToElement(agCode).keyDown(Keys.SHIFT).click().keyUp(Keys.SHIFT).build().perform();
			Thread.sleep(5000);
			Thread.sleep(1000);driver.findElement(By.xpath(loc.getProperty("firstagentshown"))).click();
		}
		driver.findElement(By.xpath(loc.getProperty("effectivedate"))).click();
		driver.findElement(By.id(loc.getProperty("buildersprojecttype"))).click();
		driver.findElement(By.id(loc.getProperty("buildersprojecttype"))).sendKeys(buildersprojecttype);
		driver.findElement(By.id(loc.getProperty("builderspolicyterm"))).click();
		driver.findElement(By.id(loc.getProperty("builderspolicyterm"))).sendKeys(builderspolicyterm);
		driver.findElement(By.id(loc.getProperty("buildersprequalificationallno"))).click();
		driver.findElement(By.cssSelector(loc.getProperty("builderscoveragebtn"))).click();
		Thread.sleep(1000);
		driver.findElement(By.id(loc.getProperty("buildersapplicantphone"))).click();
		driver.findElement(By.id(loc.getProperty("buildersapplicantphone"))).sendKeys(buildersapplicantphone);
		driver.findElement(By.id(loc.getProperty("buildersapplicantemail"))).sendKeys(buildersapplicantemail);
		Select applicanttype = new Select(driver.findElement(By.id(loc.getProperty("buildersapplicanttype"))));
		applicanttype.selectByVisibleText(buildersapplicanttype);
		if (buildersnametype.equalsIgnoreCase("Business")) {
			driver.findElement(By.xpath(loc.getProperty("buildersbusinessrdbtn"))).click();
			;
			Thread.sleep(500);
			driver.findElement(By.id(loc.getProperty("buildersbusinessname"))).click();
			driver.findElement(By.id(loc.getProperty("buildersbusinessname"))).sendKeys(buildersbusinessname);
			driver.findElement(By.id(loc.getProperty("buildersdbaname"))).click();
			driver.findElement(By.id(loc.getProperty("buildersdbaname"))).sendKeys(buildersdbaname);
			Select businesstype = new Select(driver.findElement(By.id(loc.getProperty("buildersstructure"))));
			businesstype.selectByVisibleText(buildersstructure);
		} else {
			if (buildersnametype.equalsIgnoreCase("Individual")) {
				driver.findElement(By.xpath(loc.getProperty("buildersindividualrdbtn"))).click();
				;
				Thread.sleep(500);
				driver.findElement(By.id(loc.getProperty("buildersfirstname"))).click();
				driver.findElement(By.id(loc.getProperty("buildersfirstname"))).sendKeys(buildersfirstname);
				driver.findElement(By.id(loc.getProperty("buildersmiddlename"))).sendKeys(buildersmiddlename);
				driver.findElement(By.id(loc.getProperty("builderslastname"))).sendKeys(builderslastname);
				driver.findElement(By.id(loc.getProperty("builderssuffixname"))).sendKeys(builderssuffixname);
			} else {
				Assert.fail("INVALID BUSINESS NAME TYPE: ONLY BUSINESS OR INDIVIDUAL AVAILABLE");
				driver.quit();
			}
		}
		driver.findElement(By.id(loc.getProperty("buildersmailingaddress"))).click();
		driver.findElement(By.id(loc.getProperty("buildersmailingaddress"))).sendKeys(buildersmailingaddress);
		driver.findElement(By.id(loc.getProperty("buildersmailingaddress2"))).click();
		driver.findElement(By.id(loc.getProperty("buildersmailingaddress2"))).sendKeys(buildersmailingaddress2);
		driver.findElement(By.id(loc.getProperty("buildersmailingcity"))).click();
		driver.findElement(By.id(loc.getProperty("buildersmailingcity"))).sendKeys(buildersmailingcity);
		driver.findElement(By.id(loc.getProperty("buildersmailingstate"))).click();
		driver.findElement(By.id(loc.getProperty("buildersmailingstate"))).sendKeys(buildersmailingstate);
		driver.findElement(By.id(loc.getProperty("buildersmailingzip"))).click();
		driver.findElement(By.id(loc.getProperty("buildersmailingzip"))).sendKeys(buildersmailingzip);
		driver.findElement(By.id(loc.getProperty("buildersmailingzip4"))).click();
		driver.findElement(By.id(loc.getProperty("buildersmailingzip4"))).sendKeys(buildersmailingzip4);
		Thread.sleep(5000);
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			System.out.print("\nNo alert shown for address");
		}
		driver.findElement(By.id(loc.getProperty("builderslocationaddress"))).click();
		driver.findElement(By.id(loc.getProperty("builderslocationaddress2"))).click();
		driver.findElement(By.id(loc.getProperty("builderslocationcity"))).click();
		driver.findElement(By.id(loc.getProperty("builderslocationstate"))).click();
		driver.findElement(By.id(loc.getProperty("builderslocationzip"))).click();
		driver.findElement(By.id(loc.getProperty("builderslocationzip4"))).click();
		driver.findElement(By.id(loc.getProperty("builderslocationzip4"))).sendKeys(builderslocationzip4);
		Thread.sleep(5000);
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			System.out.print("\nNo alert shown for address");
		}
		Thread.sleep(1000);
		try {
			driver.findElement(By.xpath(loc.getProperty("buildershazardhubbtn"))).click();
			Thread.sleep(5000);
		} catch (Exception e) {
			Thread.sleep(1000);
		}
		Select buildercounty = new Select(driver.findElement(By.id(loc.getProperty("builderscounty"))));
		driver.findElement(By.id(loc.getProperty("builderscounty"))).click();
		Thread.sleep(5000);
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			System.out.print("\nNo alert shown for address");
		}
		buildercounty.selectByVisibleText(builderscounty);
		if(!builderswindpool.equals("")) {
			driver.findElement(By.id(loc.getProperty("builderswindpool"))).click();
			driver.findElement(By.id(loc.getProperty("builderswindpool"))).sendKeys(builderswindpool);
		}
		if(!builderscoastdistance.equals("")) {
			driver.findElement(By.id(loc.getProperty("builderscoastdistance"))).click();
			driver.findElement(By.id(loc.getProperty("builderscoastdistance"))).clear();
			driver.findElement(By.id(loc.getProperty("builderscoastdistance"))).sendKeys(builderscoastdistance);
		}
		Select builderterritory = new Select(driver.findElement(By.id(loc.getProperty("buildersterritory"))));
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			System.out.print("\nNo alert shown for address");
		}
		if(!buildersprotectionclass.equals("")) {
			driver.findElement(By.id(loc.getProperty("buildersprotectionclass"))).click();
			driver.findElement(By.id(loc.getProperty("buildersprotectionclass"))).sendKeys(buildersprotectionclass);
		}		
		driver.findElement(By.id(loc.getProperty("buildersfirestation"))).click();
		Thread.sleep(5000);
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			System.out.print("\nNo alert shown for address");
		}
		if(!buildersfirestation.equals("")) {
			driver.findElement(By.id(loc.getProperty("buildersfirestation"))).click();
			driver.findElement(By.id(loc.getProperty("buildersfirestation"))).clear();
			driver.findElement(By.id(loc.getProperty("buildersfirestation"))).sendKeys(buildersfirestation);
		}
		if(!buildersfirehydrant.equals("")) {
			driver.findElement(By.id(loc.getProperty("buildersfirehydrant"))).click();
			driver.findElement(By.id(loc.getProperty("buildersfirehydrant"))).sendKeys(buildersfirehydrant);
		}
		if(!buildersterritory.equals("")) {
			driver.findElement(By.id(loc.getProperty("buildersterritory"))).click();
			builderterritory.selectByVisibleText(buildersterritory);
			driver.findElement(By.id(loc.getProperty("buildersterritory"))).click();
		}
		driver.findElement(By.xpath(loc.getProperty("builderslongitude"))).click();
		new Actions(driver).keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(500);
		for(int i=0; i<2; i++) {
			driver.findElement(By.id(loc.getProperty("builderscompletedvalue"))).click();
			driver.findElement(By.id(loc.getProperty("builderscompletedvalue"))).clear();
			driver.findElement(By.id(loc.getProperty("builderscompletedvalue"))).sendKeys(builderscompletedvalue);
		}
		driver.findElement(By.id(loc.getProperty("buildersdeductible"))).click();
		Select aop = new Select(driver.findElement(By.id(loc.getProperty("buildersdeductible"))));
		aop.selectByValue(buildersdeductible);
		driver.findElement(By.id(loc.getProperty("buildersdeductible"))).click();
		String windhail = builderswindhaildeductible;
		if(builderswindhaildeductible.equals("1000")){
			windhail = "$1,000";
		}
		else if(builderswindhaildeductible.equals("2500")){
			windhail = "$2,500";
		}
		else if(builderswindhaildeductible.equals("5000")){
			windhail = "$5,000";
		}
		else if(builderswindhaildeductible.equals("10000")){
			windhail = "$10,000";
		}
		driver.findElement(By.id(loc.getProperty("builderswindhaildeductible"))).click();
		driver.findElement(By.id(loc.getProperty("builderswindhaildeductible"))).sendKeys(windhail);
		driver.findElement(By.id(loc.getProperty("builderswindhaildeductible"))).click();
		driver.findElement(By.id(loc.getProperty("builderspcoverride"))).click();
		driver.findElement(By.id(loc.getProperty("buildersterritoryoverride"))).click();
		driver.findElement(By.id(loc.getProperty("buildersterritoryoverride"))).click();
		Select constructioncostlimit = new Select(driver.findElement(By.id(loc.getProperty("buildersconstructioncostlimit"))));
		driver.findElement(By.id(loc.getProperty("buildersconstructioncostlimit"))).click();
		constructioncostlimit.selectByVisibleText(buildersconstructioncostlimit);
		Select propertytransitlimit = new Select(driver.findElement(By.id(loc.getProperty("builderspropertytransitlimit"))));
		driver.findElement(By.id(loc.getProperty("builderspropertytransitlimit"))).click();
		propertytransitlimit.selectByVisibleText(builderspropertytransitlimit);
		Select softcostlimit = new Select(driver.findElement(By.id(loc.getProperty("builderssoftcostlimit"))));
		driver.findElement(By.id(loc.getProperty("builderssoftcostlimit"))).click();
		softcostlimit.selectByVisibleText(builderssoftcostlimit);
		driver.findElement(By.xpath(loc.getProperty("buildersterrorism"))).click();
		driver.findElement(By.cssSelector(loc.getProperty("buildersratingbtn"))).click();
		Action.fluentWait(driver, null, 0);
		driver.findElement(By.cssSelector(loc.getProperty("buildersgeneralbtn"))).click();
		driver.findElement(By.id(loc.getProperty("buildersstructuretype"))).click();
		driver.findElement(By.id(loc.getProperty("buildersstructuretype"))).sendKeys(buildersstructuretype);
		if (!buildersprojecttype.equalsIgnoreCase("New Construction")) {
			driver.findElement(By.id(loc.getProperty("buildersconstructionyear"))).click();
			driver.findElement(By.id(loc.getProperty("buildersconstructionyear"))).sendKeys(buildersconstructionyear);
			driver.findElement(By.id(loc.getProperty("builderselectricalyear"))).click();
			driver.findElement(By.id(loc.getProperty("builderselectricalyear"))).sendKeys(builderselectricalyear);
			driver.findElement(By.id(loc.getProperty("buildersroofingyear"))).click();
			driver.findElement(By.id(loc.getProperty("buildersroofingyear"))).sendKeys(buildersroofingyear);
			driver.findElement(By.id(loc.getProperty("buildersplumbingyear"))).click();
			driver.findElement(By.id(loc.getProperty("buildersplumbingyear"))).sendKeys(buildersplumbingyear);
			driver.findElement(By.id(loc.getProperty("buildershvacyear"))).click();
			driver.findElement(By.id(loc.getProperty("buildershvacyear"))).sendKeys(buildershvacyear);
		}
		driver.findElement(By.id(loc.getProperty("builderssquarefootage"))).click();
		driver.findElement(By.id(loc.getProperty("builderssquarefootage"))).sendKeys(builderssquarefootage);
		driver.findElement(By.id(loc.getProperty("buildersnumberofstories"))).click();
		driver.findElement(By.id(loc.getProperty("buildersnumberofstories"))).sendKeys(buildersnumberofstories);
		if (!builderspriorinscarrier.equals("")) {
			driver.findElement(By.xpath(loc.getProperty("buildersaddpriorinsurance"))).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath(loc.getProperty("builderspriorinscarrier"))).click();
			driver.findElement(By.xpath(loc.getProperty("builderspriorinscarrier"))).sendKeys(builderspriorinscarrier);
			driver.findElement(By.id(loc.getProperty("buildersconstructiontype"))).click();
			driver.findElement(By.id(loc.getProperty("buildersconstructiontype"))).sendKeys(buildersconstructiontype);
			String dateInputString = builderspriorinsenddate;
		    SimpleDateFormat sdfIn = new SimpleDateFormat( "MM/dd/yyyy" );
		    SimpleDateFormat sdfOut = new SimpleDateFormat( "MMddyyyy" );
		    String outputdate = sdfOut.format( sdfIn.parse( dateInputString ) );
		    outputdate = outputdate.substring(0,4)+"2"+outputdate.substring(5);
		    driver.findElement(By.id(loc.getProperty("builderspriorinsenddateSTAGE"))).click();
		    driver.findElement(By.id(loc.getProperty("builderspriorinsenddateSTAGE"))).clear();
		    driver.findElement(By.id(loc.getProperty("builderspriorinsenddateSTAGE"))).sendKeys(outputdate);
			driver.findElement(By.id(loc.getProperty("builderspriorinspremium"))).click();
			driver.findElement(By.id(loc.getProperty("builderspriorinspremium"))).sendKeys(builderspriorinspremium);
		}
		else {
			driver.findElement(By.id(loc.getProperty("buildersconstructiontype"))).click();
			driver.findElement(By.id(loc.getProperty("buildersconstructiontype"))).sendKeys(buildersconstructiontype);
		}
		if(buildersconstructiontype.equalsIgnoreCase("Other")) {
			driver.findElement(By.id(loc.getProperty("buildersconstructiontype"))).click();
			driver.findElement(By.id(loc.getProperty("buildersconstructiondesc"))).click();
			driver.findElement(By.id(loc.getProperty("buildersconstructiondesc"))).sendKeys("TEST");
		}
		if(buildersstructuretype.equalsIgnoreCase("Other")) {
			driver.findElement(By.id(loc.getProperty("buildersconstructiontype"))).click();
			driver.findElement(By.id(loc.getProperty("buildersstructuredesc"))).click();
			driver.findElement(By.id(loc.getProperty("buildersstructuredesc"))).sendKeys("TEST");
		}
		driver.findElement(By.id(loc.getProperty("buildersroofmaterial"))).click();
		driver.findElement(By.id(loc.getProperty("buildersroofmaterial"))).sendKeys(buildersroofmaterial);
		driver.findElement(By.cssSelector(loc.getProperty("buildersaddinterespage"))).click();
		if (!buildersinteresttype.equals("")) {
			Thread.sleep(500);
			driver.findElement(By.id(loc.getProperty("buildersaddinterestbtn"))).click();
			Thread.sleep(3000);
			driver.findElement(By.id(loc.getProperty("buildersinteresttype"))).click();
			driver.findElement(By.id(loc.getProperty("buildersinteresttype"))).sendKeys(buildersinteresttype);
			driver.findElement(By.id(loc.getProperty("buildersinterestname"))).click();
			driver.findElement(By.id(loc.getProperty("buildersinterestname"))).sendKeys(buildersinterestname);
			driver.findElement(By.id(loc.getProperty("buildersinterestaddress"))).click();
			driver.findElement(By.id(loc.getProperty("buildersinterestaddress"))).sendKeys(buildersinterestaddress);
			driver.findElement(By.id(loc.getProperty("buildersinterestaddress2"))).click();
			driver.findElement(By.id(loc.getProperty("buildersinterestaddress2"))).sendKeys(buildersinterestaddress2);
			driver.findElement(By.id(loc.getProperty("buildersinterestcity"))).click();
			driver.findElement(By.id(loc.getProperty("buildersinterestcity"))).sendKeys(buildersinterestcity);
			driver.findElement(By.id(loc.getProperty("buildersintereststate"))).click();
			driver.findElement(By.id(loc.getProperty("buildersintereststate"))).sendKeys(buildersintereststate);
			driver.findElement(By.id(loc.getProperty("buildersinterestzip"))).click();
			driver.findElement(By.id(loc.getProperty("buildersinterestzip"))).sendKeys(buildersinterestzip);
			driver.findElement(By.id(loc.getProperty("buildersinterestzip4"))).click();
			driver.findElement(By.id(loc.getProperty("buildersinterestzip4"))).sendKeys(buildersinterestzip4);
			Thread.sleep(2000);
			try {
				driver.switchTo().alert().accept();
			} catch (Exception e) {
				System.out.print("\nNo alert shown for address");
			}
			driver.findElement(By.id(loc.getProperty("buildersloannumber"))).sendKeys(buildersloannumber);
		}
		Thread.sleep(1000);
		if (!builderstinsuredtype.equals("")) {
			driver.findElement(By.id(loc.getProperty("buildersaddinsuredbtn"))).click();
			Thread.sleep(2000);
			driver.findElement(By.id(loc.getProperty("builderstinsuredtype"))).click();
			driver.findElement(By.id(loc.getProperty("builderstinsuredtype"))).sendKeys(builderstinsuredtype);
			driver.findElement(By.id(loc.getProperty("builderstinsuredfirstname"))).click();
			driver.findElement(By.id(loc.getProperty("builderstinsuredfirstname"))).sendKeys(builderstinsuredfirstname);
			driver.findElement(By.id(loc.getProperty("builderstinsuredmiddlename"))).click();
			driver.findElement(By.id(loc.getProperty("builderstinsuredmiddlename")))
					.sendKeys(builderstinsuredmiddlename);
			driver.findElement(By.id(loc.getProperty("builderstinsuredlastname"))).click();
			driver.findElement(By.id(loc.getProperty("builderstinsuredlastname"))).sendKeys(builderstinsuredlastname);
			driver.findElement(By.id(loc.getProperty("builderstinsuredsuffix"))).click();
			driver.findElement(By.id(loc.getProperty("builderstinsuredaddresstype"))).click();
			driver.findElement(By.id(loc.getProperty("builderstinsuredaddress"))).click();
			driver.findElement(By.id(loc.getProperty("builderstinsuredaddress"))).sendKeys(builderstinsuredaddress);
			driver.findElement(By.id(loc.getProperty("builderstinsuredaddress2"))).click();
			driver.findElement(By.id(loc.getProperty("builderstinsuredaddress2"))).sendKeys(builderstinsuredaddress2);
			driver.findElement(By.id(loc.getProperty("builderstinsuredcity"))).click();
			driver.findElement(By.id(loc.getProperty("builderstinsuredcity"))).sendKeys(builderstinsuredcity);
			driver.findElement(By.id(loc.getProperty("builderstinsuredstate"))).click();
			driver.findElement(By.id(loc.getProperty("builderstinsuredstate"))).sendKeys(builderstinsuredstate);
			driver.findElement(By.id(loc.getProperty("builderstinsuredzip"))).click();
			driver.findElement(By.id(loc.getProperty("builderstinsuredzip"))).sendKeys(builderstinsuredzip);
			driver.findElement(By.id(loc.getProperty("builderstinsuredzip4"))).click();
			Thread.sleep(2000);
			try {
				driver.switchTo().alert().accept();
			} catch (Exception e) {
				System.out.print("\nNo alert shown for address");
			}
		}
		driver.findElement(By.cssSelector(loc.getProperty("buildershistorybtn"))).click();
		driver.findElement(By.id(loc.getProperty("buildersclaimnumbers"))).click();
		driver.findElement(By.cssSelector(loc.getProperty("buildersstatementspagebtn"))).click();
		driver.findElement(By.id(loc.getProperty("builderslegalname"))).click();
		driver.findElement(By.id(loc.getProperty("builderslegalname"))).sendKeys(builderslegalname);
		driver.findElement(By.id(loc.getProperty("builderslicensedyes"))).click();

//		This field below was removed and that's why is commented (Have axosoft approval for field removal
//		driver.findElement(By.id(loc.getProperty("buildersexperiencedyes"))).click();

		Select construction = new Select(driver.findElement(By.id(loc.getProperty("buildersconstructionstarted"))));
		if (buildersconstructionstarted.equalsIgnoreCase("Yes")) {
			driver.findElement(By.id(loc.getProperty("buildersconstructionstarted"))).click();
			construction.selectByValue("Y");
			driver.findElement(By.id(loc.getProperty("buildersconstructionstarted"))).click();
			driver.findElement(By.id(loc.getProperty("buildersconstructionstartdate"))).click();
			Calendar cal = Calendar.getInstance();
			Date date = cal.getTime();
			StringBuilder buildersconstructionstartdate2 = new StringBuilder()
					.append(new SimpleDateFormat("MM/dd/yyyy").format(date));
			driver.findElement(By.id(loc.getProperty("buildersconstructionstartdate")))
					.sendKeys(buildersconstructionstartdate2);
			driver.findElement(By.id(loc.getProperty("buildersconstructionstarted"))).click();
			driver.findElement(By.id(loc.getProperty("buildersconstructionstarted"))).click();
			driver.findElement(By.id(loc.getProperty("builderspercentcomplete"))).click();
			driver.findElement(By.id(loc.getProperty("builderspercentcomplete"))).sendKeys(builderspercentcomplete);
		}
		else {
			driver.findElement(By.id(loc.getProperty("buildersconstructionstarted"))).click();
			construction.selectByValue("N");
			driver.findElement(By.id(loc.getProperty("buildersconstructionstarted"))).click();
		}
		driver.findElement(By.id(loc.getProperty("builderscrimescore"))).click();
		driver.findElement(By.id(loc.getProperty("builderscrimescore"))).sendKeys(builderscrimescore);
		driver.findElement(By.id(loc.getProperty("builderscrimescore"))).click();
		if(builderscrimescore.equalsIgnoreCase("D") || builderscrimescore.equalsIgnoreCase("E") || builderscrimescore.equalsIgnoreCase("F")) {
			driver.findElement(By.id(loc.getProperty("builderssecurityfenceno"))).click();
			driver.findElement(By.id(loc.getProperty("builderssecurityfenceyes"))).click();
			driver.findElement(By.id(loc.getProperty("builderswarningsignno"))).click();
			driver.findElement(By.id(loc.getProperty("builderswarningsignyes"))).click();
			driver.findElement(By.id(loc.getProperty("buildersalarmsystemno"))).click();
			driver.findElement(By.id(loc.getProperty("buildersalarmsystemyes"))).click();
			driver.findElement(By.id(loc.getProperty("buildersroutinepatrolno"))).click();
			driver.findElement(By.id(loc.getProperty("buildersroutinepatrolyes"))).click();
			driver.findElement(By.id(loc.getProperty("builderssubdivisionno"))).click();
			driver.findElement(By.id(loc.getProperty("builderssubdivisionyes"))).click();
			driver.findElement(By.id(loc.getProperty("buildersnightlightno"))).click();
			driver.findElement(By.id(loc.getProperty("buildersnightlightyes"))).click();
			driver.findElement(By.id(loc.getProperty("builderssecuritychecksno"))).click();
			driver.findElement(By.id(loc.getProperty("builderssecuritychecksyes"))).click();
			driver.findElement(By.id(loc.getProperty("builderssuspiciousactno"))).click();
			driver.findElement(By.id(loc.getProperty("builderssuspiciousactyes"))).click();
			driver.findElement(By.id(loc.getProperty("builderssecuredmaterialsno"))).click();
			driver.findElement(By.id(loc.getProperty("builderssecuredmaterialsyes"))).click();
			driver.findElement(By.id(loc.getProperty("buildersgatedsubdivisionno"))).click();
			driver.findElement(By.id(loc.getProperty("buildersgatedsubdivisionyes"))).click();
		}
		driver.findElement(By.id(loc.getProperty("buildersstiltsyes"))).click();
		driver.findElement(By.id(loc.getProperty("buildersstiltsno"))).click();
		driver.findElement(By.id(loc.getProperty("builderscrimetext"))).click();
		driver.findElement(By.id(loc.getProperty("builderscrimetext"))).sendKeys(builderscrimetext);
		driver.findElement(By.id(loc.getProperty("buildersoccupancyyes"))).click();
		driver.findElement(By.id(loc.getProperty("buildersoccupancyno"))).click();
		driver.findElement(By.cssSelector(loc.getProperty("buildersinternalpagebtn"))).click();
		Action.fluentWait(driver, null, 0);
		driver.findElement(By.id(loc.getProperty("builderssecurescore"))).click();
		driver.findElement(By.id(loc.getProperty("builderssecuritypoints"))).click();
		driver.findElement(By.id(loc.getProperty("builderssecuritypoints"))).clear();
		int points = Integer.parseInt(builderssecuritypoints);
		if(points >= 105) {
			driver.findElement(By.id(loc.getProperty("builderssecuritypoints"))).sendKeys("105");
		}
		else {
			driver.findElement(By.id(loc.getProperty("builderssecuritypoints"))).sendKeys(builderssecuritypoints);
		}
		driver.findElement(By.xpath(loc.getProperty("builderssecuritydesc"))).click();
		driver.findElement(By.xpath(loc.getProperty("builderssecuritydesc"))).sendKeys(builderssecuritydesc);
		driver.findElement(By.id(loc.getProperty("buildersjudgementrate"))).click();
		driver.findElement(By.id(loc.getProperty("buildersjudgementrate"))).sendKeys(buildersjudgementrate);
		driver.findElement(By.id(loc.getProperty("buildersjudgementreason"))).click();
		driver.findElement(By.id(loc.getProperty("buildersjudgementreason"))).sendKeys(buildersjudgementreason);
		driver.findElement(By.id(loc.getProperty("buildersfacultativeprem"))).click();
		String quotenumber = driver.findElement(By.xpath(loc.getProperty("quotenumber"))).getText().substring(14);
		System.out.println("\nQuote Number: " + quotenumber);
		driver.findElement(By.cssSelector(loc.getProperty("buildersdisplayquotepagebtn"))).click();
		Action.fluentWait(driver, null, 0);
		driver.findElement(By.cssSelector(loc.getProperty("buildersbindsubmitpagebtn"))).click();
		Action.fluentWait(driver, null, 0);
		if(prop.getProperty("testurl").contains("stage")){
			driver.findElement(By.xpath(loc.getProperty("buildersbindsubmitbtn"))).click();
		}
		else {
			driver.findElement(By.xpath(loc.getProperty("buildersbindsubmitbtnTEST"))).click();
		}
		Thread.sleep(2000);
		System.out.print("Policy Number: " + driver.findElement(By.xpath(loc.getProperty("builderspolicynumber"))).getText());
		}
}
