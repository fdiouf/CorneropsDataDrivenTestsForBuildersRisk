package buildersRiskTXAgentTests;                                                                     // THIS TEST RUNS FOR 2 MINUTES AND 26 SECONDS

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import actiondriver.Action;
import actiondriver.ReusableMethods;
import base.BuildersRiskBaseClass;
import utilities.XLUtility;

public class AgentBindSubmitTest extends BuildersRiskBaseClass {
	
	@DataProvider(name = "NewConstructionData")
	public String[][] getData() throws IOException {
		// Get data from Excel
		String path = ".\\src\\main\\resources\\data\\BuilderRiskData.xlsx";
		XLUtility xlutil = new XLUtility(path);

		int totalrows = xlutil.getRowCount("BuildersRiskTXAgent");
		int totalcols = xlutil.getCellCount("BuildersRiskTXAgent", 1);

		String loginData[][] = new String[totalrows][totalcols];

		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				loginData[i - 1][j] = xlutil.getCellData("BuildersRiskTXAgent", i, j);
			}
		}
		return loginData;
	}
	
	double total = 0.00;
	String effective = "";

	@Test(dataProvider = "NewConstructionData", description = "Builders Risk Start Quote Walkthrough to Bind/Submit Application", enabled = true, priority = 0)
	public void buildersRiskNewQuote(String newquotestate, String newquotepolicytype, String newquoteaddress, String newquoteaddress2, 
			String newquotecity, String newquotezipcode, String agentcode, String buildersprojecttype, String builderspolicyterm, 
			String buildersapplicantphone, String buildersapplicantemail, String buildersapplicanttype, String buildersnametype, 
			String buildersfirstname, String buildersmiddlename, String builderslastname, String builderssuffixname, String buildersbusinessname, 
			String buildersdbaname, String buildersstructure, String buildersmailingaddress, String buildersmailingaddress2,
			String buildersmailingcity, String buildersmailingstate, String buildersmailingzip, String buildersmailingzip4, 
			String builderslocationzip4, String builderscounty, String buildershailscore, String builderswindpool, String builderstier, 
			String buildersprotectionclass, String buildersfirestation, String buildersfirehydrant, String builderscompletedvalue, 
			String buildersdeductible, String builderswindhaildeductible, String buildersconstructioncostlimit, String builderspropertytransitlimit, 
			String builderssoftcostlimit, String buildersstructuretype, String buildersconstructionyear, String builderselectricalyear, 
			String buildersroofingyear, String buildersplumbingyear, String buildershvacyear, String builderssquarefootage, 
			String buildersroofmaterial, String buildersconstructiontype, String builderspriorinscarrier, String buildersnumberofstories, 
			String builderspriorinsenddate, String builderspriorinspremium, String buildersinteresttype, String buildersinterestname, 
			String buildersinterestaddress, String buildersinterestaddress2, String buildersinterestcity, String buildersintereststate, 
			String buildersinterestzip, String buildersinterestzip4, String buildersloannumber, String builderstinsuredtype, 
			String builderstinsuredfirstname, String builderstinsuredmiddlename, String builderstinsuredlastname, String builderstinsuredaddress, 
			String builderstinsuredaddress2, String builderstinsuredcity, String builderstinsuredstate, String builderstinsuredzip, 
			String builderslegalname, String buildersconstructionstarted, String buildersconstructionstartdate, String builderspercentcomplete, 
			String builderscrimescore, String builderscrimetext, String builderssecuritydesc, String builderssecuritypoints, 
			String buildersjudgementrate, String buildersjudgementreason)
			throws InterruptedException, ParseException {

		ReusableMethods.switchToAgent();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath(loc.getProperty("topmenustart"))).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(loc.getProperty("topmenustartanewquote"))).click();
		driver.switchTo().frame(0);
		if(!newquotestate.equalsIgnoreCase("Texas")) {
			Assert.fail("RAN TEXAS TEST WITH FLORIDA ADDRESS");
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
		Action.fluentWait(driver, null, 0);
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			Thread.sleep(1000);
		}
		driver.findElement(By.xpath(loc.getProperty("buildersstartquote"))).click();
		Action.fluentWait(driver, null, 0);
		driver.findElement(By.xpath(loc.getProperty("effectivedate"))).click();
		driver.findElement(By.id(loc.getProperty("buildersprojecttype"))).click();
		driver.findElement(By.id(loc.getProperty("buildersprojecttype"))).sendKeys(buildersprojecttype);
		driver.findElement(By.id(loc.getProperty("builderspolicyterm"))).click();
		driver.findElement(By.id(loc.getProperty("builderspolicyterm"))).sendKeys(builderspolicyterm);
		driver.findElement(By.id(loc.getProperty("buildersprequalificationallno"))).click();
		driver.findElement(By.xpath(loc.getProperty("builderscoveragesbtn"))).click();
		Action.fluentWait(driver, null, 0);
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
			System.out.print("No alert shown for address");
		}
		boolean h = true;
		try {
			driver.findElement(By.id(loc.getProperty("builderslocationaddress"))).click();
		} catch (Exception e) {
			h = false;
			System.out.print("\nLocation Address is not editable for agents as expected");
		}
		if(h==true) {
			Assert.fail("Location Address should NOT be editable for agents");
		}
		try {
			driver.findElement(By.id(loc.getProperty("builderscounty"))).click();
		} catch (Exception e) {
			h = true;
			System.out.print("\nBuilders County is not editable for agents as expected");
		}
		if(h==false) {
			Assert.fail("Builders County should NOT be editable for agents");
		}
		try {
			driver.findElement(By.id(loc.getProperty("buildersprotectionclass"))).click();
			driver.findElement(By.id(loc.getProperty("buildersprotectionclass"))).sendKeys(buildersprotectionclass);
		} catch (Exception e) {
			h = false;
			System.out.print("\nProtection Class is not editable for agents as expected");
		}
		if(h==true) {
			Assert.fail("Protection Class should NOT be editable for agents");
		}
		
		if(driver.findElement(By.id(loc.getProperty("buildersfirestation"))).getAttribute("readOnly").equalsIgnoreCase("true")){
			h = true;
			System.out.print("\nFire Station Distance is not editable for agents as expected");
		}
		else {
			Assert.fail("Fire Station Distance should NOT be editable for agents");
		}
		driver.findElement(By.id(loc.getProperty("buildersfirehydrant"))).click();
		driver.findElement(By.id(loc.getProperty("buildersfirehydrant"))).sendKeys(buildersfirehydrant);
		driver.findElement(By.id(loc.getProperty("buildersfirehydrant"))).click();
		driver.findElement(By.id(loc.getProperty("builderscompletedvalue"))).click();
		driver.findElement(By.id(loc.getProperty("builderscompletedvalue"))).sendKeys(builderscompletedvalue);
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
		Select constructioncostlimit = new Select(driver.findElement(By.id(loc.getProperty("buildersconstructioncostlimit"))));
		driver.findElement(By.id(loc.getProperty("buildersconstructioncostlimit"))).click();
		constructioncostlimit.selectByVisibleText(buildersconstructioncostlimit);
		Select propertytransitlimit = new Select(driver.findElement(By.id(loc.getProperty("builderspropertytransitlimit"))));
		driver.findElement(By.id(loc.getProperty("builderspropertytransitlimit"))).click();
		propertytransitlimit.selectByVisibleText(builderspropertytransitlimit);
		Select softcostlimit = new Select(driver.findElement(By.id(loc.getProperty("builderssoftcostlimit"))));
		driver.findElement(By.id(loc.getProperty("builderssoftcostlimit"))).click();
		softcostlimit.selectByVisibleText(builderssoftcostlimit);
//		driver.findElement(By.xpath(loc.getProperty("buildersterrorism"))).click();
		driver.findElement(By.xpath(loc.getProperty("buildersratingsbtn"))).click();
		Action.fluentWait(driver, null, 0);
		driver.findElement(By.xpath(loc.getProperty("buildersgeneralsbtn"))).click();
		Action.fluentWait(driver, null, 0);
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
		driver.findElement(By.id(loc.getProperty("buildersroofmaterial"))).click();
		driver.findElement(By.id(loc.getProperty("buildersroofmaterial"))).sendKeys(buildersroofmaterial);
		driver.findElement(By.xpath(loc.getProperty("buildersaddinterestpage"))).click();
		Action.fluentWait(driver, null, 0);
		if (!buildersinteresttype.equals("")) {
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
		driver.findElement(By.xpath(loc.getProperty("buildersstatementpagebtn"))).click();
		Action.fluentWait(driver, null, 0);
		driver.findElement(By.id(loc.getProperty("builderslegalname"))).click();
		driver.findElement(By.id(loc.getProperty("builderslegalname"))).sendKeys(builderslegalname);
		driver.findElement(By.id(loc.getProperty("builderslicensedyes"))).click();
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
		driver.findElement(By.id(loc.getProperty("buildersstiltsyes"))).click();
		driver.findElement(By.id(loc.getProperty("buildersstiltsno"))).click();
		driver.findElement(By.id(loc.getProperty("buildersoccupancyyes"))).click();
		driver.findElement(By.id(loc.getProperty("buildersoccupancyno"))).click();
		driver.findElement(By.xpath(loc.getProperty("buildersdisplayquotepgbtn"))).click();
		Action.fluentWait(driver, null, 0);
		driver.findElement(By.xpath(loc.getProperty("buildersbindandsubmitbtn"))).click();
		Action.fluentWait(driver, null, 0);
	}
	
	@Test(dataProvider = "NewConstructionData", description = "T18816	TC01 - Builder Risk - Bind Submit Application - Global Header", enabled = true, priority = 1)
	public void buildersRiskBindSubmit1(String newquotestate, String newquotepolicytype, String newquoteaddress, String newquoteaddress2, 
			String newquotecity, String newquotezipcode, String agentcode, String buildersprojecttype, String builderspolicyterm, 
			String buildersapplicantphone, String buildersapplicantemail, String buildersapplicanttype, String buildersnametype, 
			String buildersfirstname, String buildersmiddlename, String builderslastname, String builderssuffixname, String buildersbusinessname, 
			String buildersdbaname, String buildersstructure, String buildersmailingaddress, String buildersmailingaddress2,
			String buildersmailingcity, String buildersmailingstate, String buildersmailingzip, String buildersmailingzip4, 
			String builderslocationzip4, String builderscounty, String buildershailscore, String builderswindpool, String builderstier, 
			String buildersprotectionclass, String buildersfirestation, String buildersfirehydrant, String builderscompletedvalue, 
			String buildersdeductible, String builderswindhaildeductible, String buildersconstructioncostlimit, String builderspropertytransitlimit, 
			String builderssoftcostlimit, String buildersstructuretype, String buildersconstructionyear, String builderselectricalyear, 
			String buildersroofingyear, String buildersplumbingyear, String buildershvacyear, String builderssquarefootage, 
			String buildersroofmaterial, String buildersconstructiontype, String builderspriorinscarrier, String buildersnumberofstories, 
			String builderspriorinsenddate, String builderspriorinspremium, String buildersinteresttype, String buildersinterestname, 
			String buildersinterestaddress, String buildersinterestaddress2, String buildersinterestcity, String buildersintereststate, 
			String buildersinterestzip, String buildersinterestzip4, String buildersloannumber, String builderstinsuredtype, 
			String builderstinsuredfirstname, String builderstinsuredmiddlename, String builderstinsuredlastname, String builderstinsuredaddress, 
			String builderstinsuredaddress2, String builderstinsuredcity, String builderstinsuredstate, String builderstinsuredzip, 
			String builderslegalname, String buildersconstructionstarted, String buildersconstructionstartdate, String builderspercentcomplete, 
			String builderscrimescore, String builderscrimetext, String builderssecuritydesc, String builderssecuritypoints, 
			String buildersjudgementrate, String buildersjudgementreason)
			throws InterruptedException {

		WebElement quoteNumber = driver.findElement(By.xpath(loc.getProperty("quotenumber")));
		if (driver.findElement(By.xpath(loc.getProperty("quotenumber"))).getText().substring(0, 14)
				.equals("Quote Number: ")) {
			System.out.print("\nQuote Number displayed: " + quoteNumber.getText().substring(14));
			try {
				quoteNumber.sendKeys("TEST");
			} catch (Exception e) {
				if (!e.getMessage().contains("element not interactable")) {
					System.out.print(e);
					Assert.fail("QUOTE NUMBER IS NOT SUPPOSED TO BE EDITABLE");
				} else {
					System.out.print("\nQUOTE NUMBER IS NOT EDITABLE");
				}
			}
		} else {
			Assert.fail("QUOTE NUMBER IS NOT DISPLAYED");
		}

		WebElement policyType = driver.findElement(By.xpath(loc.getProperty("builderspolicytype")));
		if (driver.findElement(By.xpath(loc.getProperty("builderspolicytype"))).getText().substring(0, 13)
				.equals("Policy Type: ")) {
			System.out.print("\nPolicy type displayed: " + policyType.getText().substring(13));
			try {
				policyType.sendKeys("TEST");
			} catch (Exception e) {
				if (!e.getMessage().contains("element not interactable")) {
					System.out.print(e);
					Assert.fail("POLICY TYPE IS NOT SUPPOSED TO BE EDITABLE");
				} else {
					System.out.print("\nPOLICY TYPE IS NOT EDITABLE");
				}
			}
		} else {
			Assert.fail("POLICY TYPE IS NOT DISPLAYED");
		}
		
		WebElement projectType = driver.findElement(By.id(loc.getProperty("buildersprojecttypeselected")));
		if (driver.findElement(By.id(loc.getProperty("buildersprojecttypeselected"))).getText().substring(0, 14)
				.equals("Project Type: ")) {
			System.out.print("\nProject type displayed: " + projectType.getText().substring(14));
			if(!projectType.getText().substring(14).equals("NEW")) {
				Assert.fail("PROJECT TYPE SHOULD BE 'NEW' FOR NEW CONSTRUCTION");
			}
			try {
				policyType.sendKeys("TEST");
			} catch (Exception e) {
				if (!e.getMessage().contains("element not interactable")) {
					System.out.print(e);
					Assert.fail("PROJECT TYPE IS NOT SUPPOSED TO BE EDITABLE");
				} else {
					System.out.print("\nPROJECT TYPE IS NOT EDITABLE");
				}
			}
		} else {
			Assert.fail("PROJECT TYPE IS NOT DISPLAYED");
		}
		
		WebElement agencyCode = driver.findElement(By.id(loc.getProperty("buildersagentcodeselected")));
		if (driver.findElement(By.id(loc.getProperty("buildersagentcodeselected"))).getText().substring(0, 13)
				.equals("Agency Code: ")) {
			System.out.print("\nAgency code displayed: " + agencyCode.getText().substring(13));
			if(!agencyCode.getText().substring(13).equals(agentcode)) {
				Assert.fail("AGENCY CODE SHOULD BE " + agentcode +" AS SELECTED");
			}
			try {
				policyType.sendKeys("TEST");
			} catch (Exception e) {
				if (!e.getMessage().contains("element not interactable")) {
					System.out.print(e);
					Assert.fail("AGENCY CODE IS NOT SUPPOSED TO BE EDITABLE");
				} else {
					System.out.print("\nAGENCY CODE IS NOT EDITABLE");
				}
			}
		} else {
			Assert.fail("AGENCY CODE IS NOT DISPLAYED");
		}
		try {
			driver.findElement(By.xpath(loc.getProperty("effectivedate"))).clear();
		} catch (Exception e) {
			System.out.print("\nEffective date is not editable at this point as expected\n");
		}
		effective = driver.findElement(By.xpath(loc.getProperty("effectivedate"))).getAttribute("value");
		System.out.print("Effective Date: " + effective + "\n");
		ReusableMethods.printValidations();
	}
	
	@Test(description = "T18818	TC03 - Builder Risk - Bind Submit Application - Premiums and Fees", enabled = false, priority = 2) // HIDDEN FOR AGENTS
	public void buildersRiskBindSubmit2() throws InterruptedException, ParseException {
		if(driver.findElement(By.xpath(loc.getProperty("buildersbindpremfeestitle"))).getAttribute("innerText").equals("Premium and Fees")) {
			System.out.print("\nPremium and Fees title is displaying as expected");
		}
		else {
			Assert.fail("PREMIUM AND FEES TITLE MISMATCH");
		}
		String totalcovprem = "";
		if(driver.findElement(By.xpath(loc.getProperty("buildersbindcoverageprem"))).getAttribute("innerText").contains("$") && driver.findElement(By.xpath(loc.getProperty("buildersbindcoverageprem"))).getAttribute("innerText").contains(".")) {
			System.out.print("\nTotal Coverage Premium is displaying in currency format as expected");
			totalcovprem = driver.findElement(By.xpath(loc.getProperty("buildersbindcoverageprem"))).getAttribute("innerText").substring(1).replace(",", "").replace("\n", "");
		}
		else {
			Assert.fail("TOTAL COVERAGE PREMIUM IS NOT DISPLAYING IN CURRENCY FORMAT");
		}
		total = Double.parseDouble(totalcovprem);
		String totalpremium = "";
		if(driver.findElement(By.xpath(loc.getProperty("buildersbindtotalprem"))).getAttribute("innerText").contains("$") && driver.findElement(By.xpath(loc.getProperty("buildersbindtotalprem"))).getAttribute("innerText").contains(".")) {
			System.out.print("\nTotal Premium, Taxes, and Fees is displaying in currency format as expected");
			totalpremium = driver.findElement(By.xpath(loc.getProperty("buildersbindtotalprem"))).getAttribute("innerText").substring(1).replace(",", "");
		}
		else {
			Assert.fail("TOTAL PREMIUM, TAXES, AND FEES IS NOT DISPLAYING IN CURRENCY FORMAT");
		}
		
		if((total+"").equals(totalpremium)) {
			System.out.print("\nTotal Premium, Taxes, and Fees is correctly calculated");
		}
		System.out.print("\nTOTAL: " + total);
		System.out.print("\nPremium and Fees section is working successfully");
	}
	
	@Test(description = "T18819	TC04 - Builder Risk - Bind Submit Application - Payment Information", enabled = false, priority = 3)  // HIDDEN FOR AGENTS
	public void buildersRiskBindSubmit3() throws InterruptedException{
		if(driver.findElement(By.xpath(loc.getProperty("buildersbindpaymentinfotitle"))).getAttribute("innerText").equals("Payment Information")) {
			System.out.print("\nPayment Information title is displaying as expected");
		}
		else {
			Assert.fail("PAYMENT INFORMATION TITLE MISMATCH");
		}
		if(driver.findElement(By.xpath(loc.getProperty("buildersbindagentbill"))).getAttribute("innerText").equals("Agent Bill")) {
			System.out.print("\nPayment Method 'Agent Bill' is displaying as expected");
		}
		else {
			Assert.fail("PAYMENT METHOD NAME MISMATCH");
		}
		if(driver.findElement(By.xpath(loc.getProperty("buildersbindmaxpaymentammount"))).getAttribute("readOnly").equals("true")) {
			System.out.print("\nTotal Payment is displaying and is NOT editable as expected");
		}
		else {
			Assert.fail("TOTAL PAYMENT SHOULD NOT BE EDITABLE");
		}
		String value = driver.findElement(By.xpath(loc.getProperty("buildersbindmaxpaymentammount"))).getAttribute("value");
		String totals = String.format("%.2f", total);
		if(value.substring(0, value.length()-1).equals(totals) || value.equals(totals)) {
			System.out.print("\nTotal Payment is displaying the correct total");
		}
		else {
			Assert.fail("TOTAL PAYMENT MISMATCHES WITH CALCULATED TOTAL. EXPECTED " + total + " BUT FOUND " + driver.findElement(By.xpath(loc.getProperty("buildersbindmaxpaymentammount"))).getAttribute("value"));
		}
		try {
			driver.findElement(By.xpath(loc.getProperty("buildersbinddepositdate"))).click();
		} catch (Exception e) {
			Assert.fail("DATE PAID SHOULD BE CLICKABLE");
		}
		if(driver.findElement(By.xpath(loc.getProperty("buildersbinddepositdate"))).getAttribute("minvalue").equals("today") && driver.findElement(By.xpath(loc.getProperty("buildersbinddepositdate"))).getAttribute("maxvalue").equals(effective)) {
			System.out.print("\nDate Paid is displaying, editable, BUT only allows today's date");
		}
		else {
			Assert.fail("DATE PAID SHOULD ONLY ALLOW TODAY AS THE DATE AVAILABLE");
		}
		Boolean check = true;
		try {
			driver.findElement(By.xpath(loc.getProperty("buildersbindpaymentunverifiedno"))).click();
		} catch (Exception e) {
			check = false;
		}
		try {
			driver.findElement(By.xpath(loc.getProperty("buildersbindpaymentunverifiedyes"))).click();
		} catch (Exception e) {
			if(check==true) {
				Assert.fail("EXPECTED UNVERIFIED PAYMENTS RADIO BUTTONS TO BE MISSING FOR AGENTS");			
			}
		}
		if(check==true) {
			Assert.fail("EXPECTED UNVERIFIED PAYMENTS RADIO BUTTONS TO BE MISSING FOR AGENTS");			
		}
		System.out.print("\nPayment Information section is working correctly as expected");
	}
	
	@Test(description = "T18820	TC05 - Builder Risk - Bind Submit Application - Document Upload", enabled = true, priority = 4)
	public void buildersRiskBindSubmit4() throws InterruptedException {
		if(driver.findElement(By.xpath(loc.getProperty("buildersbinddocumentuploadtitle"))).getAttribute("innerText").equals("Document Upload")) {
			System.out.print("\nDocument Upload title is displaying as expected");
		}
		else {
			Assert.fail("DOCUMENT UPLOAD TITLE MISMATCH");
		}
		if(driver.findElement(By.xpath(loc.getProperty("buildersbinduploaddocsheader"))).getAttribute("innerText").equals("Upload Your Quote Document(s) Now")) {
			System.out.print("\nUpload Your Quote Document(s) Now header is displaying as expected");
		}
		else {
			Assert.fail("DOCUMENT UPLOAD HEADER MISMATCH");
		}
		driver.findElement(By.xpath(loc.getProperty("buildersbinduploaddocsheader"))).click();
		Boolean x = true;
		try {
			driver.findElement(By.xpath(loc.getProperty("buildersstartfileupload"))).click();
		} catch (Exception e) {
			x=false;
			System.out.print("\nDocument Upload section is working as expected");
		}
		if(x==true) {
			Assert.fail("EXPECTED START FILE UPLOADS TO NOT BE CLICKABLE");
		}
	}
	
	@Test(description = "T18821	TC06 - Builder Risk - Bind Submit Application - Set Application Status", enabled = true, priority = 5)
	public void buildersRiskBindSubmit5() throws InterruptedException {
		if(driver.findElement(By.xpath(loc.getProperty("buildersbindsetappstatustitle"))).getAttribute("innerText").equals("Set Application Status")) {
			System.out.print("\nSet Application Status title is displaying as expected");
		}
		else {
			Assert.fail("SET APPLICATION STATUS TITLE MISMATCH");
		}
		driver.findElement(By.xpath(loc.getProperty("buildersbindagentnotify"))).click();
	}
	
	@Test(description = "T18822	TC07 - Builder Risk - Bind Submit Application - Remarks", enabled = true, priority = 6)
	public void buildersRiskBindSubmit6() throws InterruptedException {
		if(driver.findElement(By.xpath(loc.getProperty("buildersbindremarkstitle"))).getAttribute("innerText").equals("Remarks")) {
			System.out.print("\nRemarks title is displaying as expected");
		}
		else {
			Assert.fail("REMARKS TITLE MISMATCH");
		}
		driver.findElement(By.xpath(loc.getProperty("buildersbindremarkstitle"))).click();
		new Actions(driver).keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("buildersbindremarksbox"))).click();
	}
	
	@Test(description = "T18823	TC08 - Builder Risk - Bind Submit Application - Quote Message Log & T18824 TC09 - Builder Risk - Bind Submit Application - Quote Preparation Options", enabled = true, priority = 7)
	public void buildersRiskBindSubmit7() throws InterruptedException {
		if(driver.findElement(By.xpath(loc.getProperty("buildersbindquotemessagetitle"))).getAttribute("innerText").equals("Quote Message Log")) {
			System.out.print("\nQuote Message Log title is displaying as expected");
		}
		else {
			Assert.fail("QUOTE MESSAGE LOG TITLE MISMATCH");
		}
//		HIDDEN FOR AGENTS: 
//		if(driver.findElement(By.xpath(loc.getProperty("buildersbindquotepreptitle"))).getAttribute("innerText").equals("Quote Preparation Options")) {
//			System.out.print("\nQuote Preparation Options title is displaying as expected");
//		}
//		else {
//			Assert.fail("QUOTE PREPARATION OPTIONS TITLE MISMATCH");
//		}
	}
	
	@Test(description = "T18825	TC10 - Builder Risk - Bind Submit Application - Send Quote by E-Mail", enabled = true, priority = 8)
	public void buildersRiskBindSubmit8() throws InterruptedException {
//		HIDDEN FOR AGENTS:
//		driver.findElement(By.xpath(loc.getProperty("buildersbindemailquote"))).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath(loc.getProperty("buildersquoteemailto"))).click();
//		driver.findElement(By.xpath(loc.getProperty("buildersquoteemailsubject"))).click();
//		driver.findElement(By.xpath(loc.getProperty("buildersquoteemailbody"))).click();
//		driver.findElement(By.xpath(loc.getProperty("builderemailquoteclosebtn"))).click();
//		Thread.sleep(1000);
//		System.out.print("\nEmail Quote form is working as expected");
		Boolean check = false;
		try {
			driver.findElement(By.xpath(loc.getProperty("buildersbindsubmitbtn"))).click();
		} catch (Exception e) {
			check = true;
		}
		if(check==false) {
			Assert.fail("EXPECTED 'BIND & SUBMIT' BUTTON TO BE 'SEND TO COMPANY' FOR AGENTS");
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("builderssendtocompanybtn"))).click();
		check = true;
		try {
			driver.findElement(By.xpath(loc.getProperty("builderspolicynumber"))).click();
		} catch (Exception e) {
			check = false;
		}
		if(check==true) {
			Assert.fail("EXPECTED QUOTE TO BE SENT TO COMPANY NOT BOUND");
		}
		driver.findElement(By.xpath(loc.getProperty("buildersagentsubmitted"))).click();
		System.out.print("\nBind/Submit page is working correctly as expected!");
	}
}
