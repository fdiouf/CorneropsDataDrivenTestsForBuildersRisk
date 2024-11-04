package buildersRiskTestsFlorida;														// THIS TEST RUNS FOR 2 MINUTES AND 9 SECONDS

import java.io.IOException;
import java.text.DecimalFormat;
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

public class BuildersRiskInternalPageTest extends BuildersRiskBaseClass {
	
	@DataProvider(name = "NewConstructionData")
	public String[][] getData() throws IOException {
		// Get data from Excel
		String path = ".\\src\\main\\resources\\data\\BuilderRiskData.xlsx";
		XLUtility xlutil = new XLUtility(path);

		int totalrows = xlutil.getRowCount("BuildersRiskFlorida");
		int totalcols = xlutil.getCellCount("BuildersRiskFlorida", 1);

		String loginData[][] = new String[totalrows][totalcols];

		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				loginData[i - 1][j] = xlutil.getCellData("BuildersRiskFlorida", i, j);
			}
		}
		return loginData;
	}
	
	String CrimeScore = "";
	
	@Test(dataProvider = "NewConstructionData", description = "Builders Risk Start Quote Walkthrough to Internal page", enabled = true, priority = 0)
	public void buildersRiskNewQuote(String newquotestate, String newquotepolicytype, String newquoteaddress,
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
		driver.findElement(By.xpath(loc.getProperty("buildersstartquote"))).click();
		Action.fluentWait(driver, null, 0);
		driver.findElement(By.xpath(loc.getProperty("agentlookup"))).click();
		Thread.sleep(1000);
		WebElement agCode = driver.findElement(By.id(loc.getProperty("agentcode")));
		driver.findElement(By.id(loc.getProperty("agentcode"))).click();
		driver.findElement(By.id(loc.getProperty("agentcode"))).sendKeys(agentcode);
		new Actions(driver).moveToElement(agCode).keyDown(Keys.SHIFT).click().keyUp(Keys.SHIFT).build().perform();
		Thread.sleep(2000);
		Thread.sleep(1000);driver.findElement(By.xpath(loc.getProperty("firstagentshown"))).click();
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
			System.out.print("No alert shown for address");
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
		Select buildercounty = new Select(driver.findElement(By.id(loc.getProperty("builderscounty"))));
		driver.findElement(By.id(loc.getProperty("builderscounty"))).click();
		buildercounty.selectByVisibleText(builderscounty);
		driver.findElement(By.id(loc.getProperty("builderswindpool"))).click();
		driver.findElement(By.id(loc.getProperty("builderswindpool"))).sendKeys(builderswindpool);
		if(newquotestate.equalsIgnoreCase("Florida")) {
			driver.findElement(By.id(loc.getProperty("builderscoastdistance"))).click();
			driver.findElement(By.id(loc.getProperty("builderscoastdistance"))).sendKeys(builderscoastdistance);
			driver.findElement(By.id(loc.getProperty("builderscoastdistanceunit"))).click();
			driver.findElement(By.id(loc.getProperty("builderscoastdistanceunit"))).sendKeys(builderscoastdistanceunit);
			Select builderterritory = new Select(driver.findElement(By.id(loc.getProperty("buildersterritory"))));
			driver.findElement(By.id(loc.getProperty("buildersterritory"))).click();
			builderterritory.selectByVisibleText(buildersterritory);
			driver.findElement(By.id(loc.getProperty("buildersterritory"))).click();
			try {
				driver.switchTo().alert().accept();
			} catch (Exception e) {
				System.out.print("\nNo alert shown for address");
			}
			driver.findElement(By.id(loc.getProperty("builderssinkholedistance"))).click();
			driver.findElement(By.id(loc.getProperty("builderssinkholedistance"))).sendKeys(builderssinkholedistance);
			driver.findElement(By.id(loc.getProperty("builderssinkholedistanceunits"))).click();
			driver.findElement(By.id(loc.getProperty("builderssinkholedistanceunits"))).sendKeys(builderssinkholedistanceunits);
		}
		else {
			Assert.fail("RAN FLORIDA TEST WITH TEXAS ADDRESS");
			driver.quit();
		}
		driver.findElement(By.id(loc.getProperty("buildersprotectionclass"))).click();
		driver.findElement(By.id(loc.getProperty("buildersprotectionclass"))).sendKeys(buildersprotectionclass);
		driver.findElement(By.id(loc.getProperty("buildersfirestation"))).click();
		driver.findElement(By.id(loc.getProperty("buildersfirestation"))).sendKeys(buildersfirestation);
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
		driver.findElement(By.id(loc.getProperty("buildersroofmaterial"))).click();
		driver.findElement(By.id(loc.getProperty("buildersroofmaterial"))).sendKeys(buildersroofmaterial);
		driver.findElement(By.cssSelector(loc.getProperty("buildersaddinterespage"))).click();
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
		Action.fluentWait(driver, null, 0);
		Action.fluentWait(driver, null, 0);
		driver.findElement(By.cssSelector(loc.getProperty("buildersstatementspagebtn"))).click();
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
		driver.findElement(By.id(loc.getProperty("builderscrimescore"))).click();
		driver.findElement(By.id(loc.getProperty("builderscrimescore"))).sendKeys("A");
		driver.findElement(By.id(loc.getProperty("builderscrimescore"))).click();
		driver.findElement(By.id(loc.getProperty("builderscrimetext"))).click();
		driver.findElement(By.id(loc.getProperty("builderscrimetext"))).sendKeys(builderscrimetext);
		driver.findElement(By.cssSelector(loc.getProperty("buildersinternalpagebtn"))).click();
	}
	
	@Test(dataProvider = "NewConstructionData", description = "T18840	TC01 - Builders Risk - Internal Header", enabled = true, priority = 1)
	public void buildersRiskInternal1(String newquotestate, String newquotepolicytype,
			String newquoteaddress, String newquoteaddress2, String newquotecity, String newquotezipcode,
			String agentcode, String buildersprojecttype, String builderspolicyterm, String buildersapplicantphone,
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
			throws InterruptedException {

		driver.findElement(By.xpath(loc.getProperty("buildersgobackstatements"))).click();
		Thread.sleep(2000);
		driver.findElement(By.id(loc.getProperty("builderscrimescore"))).click();
		driver.findElement(By.id(loc.getProperty("builderscrimescore"))).sendKeys("D");
		driver.findElement(By.id(loc.getProperty("builderscrimescore"))).click();
		driver.findElement(By.id(loc.getProperty("builderssecurityfenceno"))).click();
		driver.findElement(By.id(loc.getProperty("builderswarningsignno"))).click();
		driver.findElement(By.id(loc.getProperty("buildersalarmsystemno"))).click();
		driver.findElement(By.id(loc.getProperty("buildersroutinepatrolno"))).click();
		driver.findElement(By.id(loc.getProperty("builderssubdivisionno"))).click();
		driver.findElement(By.id(loc.getProperty("buildersnightlightno"))).click();
		driver.findElement(By.id(loc.getProperty("builderssecuritychecksno"))).click();
		driver.findElement(By.id(loc.getProperty("builderssuspiciousactno"))).click();
		driver.findElement(By.id(loc.getProperty("builderssecuredmaterialsno"))).click();
		driver.findElement(By.id(loc.getProperty("buildersgatedsubdivisionno"))).click();
		driver.findElement(By.cssSelector(loc.getProperty("buildersinternalpagebtn"))).click();
		Thread.sleep(2000);
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
		System.out.print("Effective Date: " + driver.findElement(By.xpath(loc.getProperty("effectivedate"))).getAttribute("value"));
		CrimeScore = builderscrimescore;
	}
	
	@Test(description = "T18841	TC02 - Builders Risk - Internal Security Scoring", enabled = true, priority = 2)
	public void buildersRiskInternal2() throws InterruptedException {
		
		driver.findElement(By.id(loc.getProperty("builderssecurescore"))).click();
		System.out.print("\nCrime Score field is working as expected");
		if(!driver.findElement(By.id(loc.getProperty("builderssecurityfence"))).getAttribute("value").equals("0")) {
			Assert.fail("EXPECTED SECURITY FENCING TO HAVE A VALUE OF 0 SINCE 'NO' WAS SELECTED ON THE STATEMENTS TAB");
		}
		if(!driver.findElement(By.id(loc.getProperty("builderssecurityfence"))).getAttribute("readOnly").equals("true")) {
			Assert.fail("EXPECTED SECURITY FENCING TO BE READ ONLY AND NOT EDITABLE");
		}
		if(!driver.findElement(By.id(loc.getProperty("buildersnightlight"))).getAttribute("value").equals("0")) {
			Assert.fail("EXPECTED NIGHT LIGHTING TO HAVE A VALUE OF 0 SINCE 'NO' WAS SELECTED ON THE STATEMENTS TAB");
		}
		if(!driver.findElement(By.id(loc.getProperty("buildersnightlight"))).getAttribute("readOnly").equals("true")) {
			Assert.fail("EXPECTED NIGHT LIGHTING TO BE READ ONLY AND NOT EDITABLE");
		}
		if(!driver.findElement(By.id(loc.getProperty("builderswarningsigns"))).getAttribute("value").equals("0")) {
			Assert.fail("EXPECTED WARNING SIGNS TO HAVE A VALUE OF 0 SINCE 'NO' WAS SELECTED ON THE STATEMENTS TAB");
		}
		if(!driver.findElement(By.id(loc.getProperty("builderswarningsigns"))).getAttribute("readOnly").equals("true")) {
			Assert.fail("EXPECTED WARNING SIGNS TO BE READ ONLY AND NOT EDITABLE");
		}
		if(!driver.findElement(By.id(loc.getProperty("builderssecuritychecks"))).getAttribute("value").equals("0")) {
			Assert.fail("EXPECTED SECURITY CHECKS TO HAVE A VALUE OF 0 SINCE 'NO' WAS SELECTED ON THE STATEMENTS TAB");
		}
		if(!driver.findElement(By.id(loc.getProperty("builderssecuritychecks"))).getAttribute("readOnly").equals("true")) {
			Assert.fail("EXPECTED SECURITY CHECKS TO BE READ ONLY AND NOT EDITABLE");
		}
		if(!driver.findElement(By.id(loc.getProperty("buildersalarmservice"))).getAttribute("value").equals("0")) {
			Assert.fail("EXPECTED ALARM SERVICES TO HAVE A VALUE OF 0 SINCE 'NO' WAS SELECTED ON THE STATEMENTS TAB");
		}
		if(!driver.findElement(By.id(loc.getProperty("buildersalarmservice"))).getAttribute("readOnly").equals("true")) {
			Assert.fail("EXPECTED ALARM SERVICES TO BE READ ONLY AND NOT EDITABLE");
		}
		if(!driver.findElement(By.id(loc.getProperty("buildersreportsusact"))).getAttribute("value").equals("0")) {
			Assert.fail("EXPECTED REPORT SUSPICIOUS ACTIVITIES TO HAVE A VALUE OF 0 SINCE 'NO' WAS SELECTED ON THE STATEMENTS TAB");
		}
		if(!driver.findElement(By.id(loc.getProperty("buildersreportsusact"))).getAttribute("readOnly").equals("true")) {
			Assert.fail("EXPECTED REPORT SUSPICIOUS ACTIVITIES TO BE READ ONLY AND NOT EDITABLE");
		}
		if(!driver.findElement(By.id(loc.getProperty("buildersroutinepatrols"))).getAttribute("value").equals("0")) {
			Assert.fail("EXPECTED ROUTINE PATROLS TO HAVE A VALUE OF 0 SINCE 'NO' WAS SELECTED ON THE STATEMENTS TAB");
		}
		if(!driver.findElement(By.id(loc.getProperty("buildersroutinepatrols"))).getAttribute("readOnly").equals("true")) {
			Assert.fail("EXPECTED ROUTINE PATROLS TO BE READ ONLY AND NOT EDITABLE");
		}
		if(!driver.findElement(By.id(loc.getProperty("builderssecuredmaterials"))).getAttribute("value").equals("0")) {
			Assert.fail("EXPECTED SECURED MATERIALS TO HAVE A VALUE OF 0 SINCE 'NO' WAS SELECTED ON THE STATEMENTS TAB");
		}
		if(!driver.findElement(By.id(loc.getProperty("builderssecuredmaterials"))).getAttribute("readOnly").equals("true")) {
			Assert.fail("EXPECTED SECURED MATERIALS TO BE READ ONLY AND NOT EDITABLE");
		}
		if(!driver.findElement(By.id(loc.getProperty("buildersestablishedsubdivision"))).getAttribute("value").equals("0")) {
			Assert.fail("EXPECTED ESTABLISHED SUBDIVISION TO HAVE A VALUE OF 0 SINCE 'NO' WAS SELECTED ON THE STATEMENTS TAB");
		}
		if(!driver.findElement(By.id(loc.getProperty("buildersestablishedsubdivision"))).getAttribute("readOnly").equals("true")) {
			Assert.fail("EXPECTED ESTABLISHED SUBDIVISION TO BE READ ONLY AND NOT EDITABLE");
		}
		if(!driver.findElement(By.id(loc.getProperty("buildersgatedsubdivision"))).getAttribute("value").equals("0")) {
			Assert.fail("EXPECTED GATED SUBDIVISION TO HAVE A VALUE OF 0 SINCE 'NO' WAS SELECTED ON THE STATEMENTS TAB");
		}
		if(!driver.findElement(By.id(loc.getProperty("buildersgatedsubdivision"))).getAttribute("readOnly").equals("true")) {
			Assert.fail("EXPECTED GATED SUBDIVISION TO BE READ ONLY AND NOT EDITABLE");
		}
		System.out.print("\nSecurity Scoring default values are correctly being assinged if answers where 'No'");
		if(!driver.findElement(By.id(loc.getProperty("builderssecuritypoints"))).getAttribute("minvalue").equals("0")) {
			Assert.fail("EXPECTED ADDITIONAL SECURITY POINTS TO HAVE A MINIMUM VALUE OF 0");
		}
		if(!driver.findElement(By.id(loc.getProperty("builderssecuritypoints"))).getAttribute("maxvalue").equals("105")) {
			Assert.fail("EXPECTED ADDITIONAL SECURITY POINTS TO HAVE A MAXIMUM VALUE OF 105");
		}
		driver.findElement(By.xpath(loc.getProperty("builderssecuritydesc"))).click();
		if(!driver.findElement(By.xpath(loc.getProperty("builderssecuritydesc"))).getAttribute("maxLength").equals("100")) {
			Assert.fail("EXPECTED SECURITY SCORE DESCRIPTION TO HAVE A MAXIMUM LENGTH OF 100");
		}
		if(!driver.findElement(By.id(loc.getProperty("builderssecurityscore"))).getAttribute("innerText").equals("0")) {
			Assert.fail("EXPECTED SECURITY SCORE TO BE '0' SINCE ALL VALUES WERE ANSWERED NO AND NO ADDITIONAL POINTS WERE ADDED");
		}
		driver.findElement(By.id(loc.getProperty("builderssecuritypoints"))).click();
		driver.findElement(By.id(loc.getProperty("builderssecuritypoints"))).clear();
		if(!driver.findElement(By.id(loc.getProperty("builderssecuritypoints"))).getAttribute("maxvalue").equals("105")) {
			Assert.fail("EXPECTED ADDITIONAL SECURITY POINTS TO HAVE A MAX VALUE OF 105");
		}
		if(!driver.findElement(By.id(loc.getProperty("builderssecuritypoints"))).getAttribute("minvalue").equals("0")) {
			Assert.fail("EXPECTED ADDITIONAL SECURITY POINTS TO HAVE A MIN VALUE OF 0");
		}
		driver.findElement(By.id(loc.getProperty("builderssecuritypoints"))).sendKeys("105");
		driver.findElement(By.xpath(loc.getProperty("builderssecuritydesc"))).click();
		if(!driver.findElement(By.xpath(loc.getProperty("builderssecuritydesc"))).getAttribute("maxlength").equals("100")) {
			Assert.fail("EXPECTED ADDITIONAL SECURITY DESCRIPTION TO HAVE A MAX LENGTH OF 100");
		}
		if(!driver.findElement(By.id(loc.getProperty("builderssecurityscore"))).getAttribute("innerText").equals("105")) {
			Assert.fail("EXPECTED SECURITY SCORE TO BE '105' SINCE ALL VALUES WERE ANSWERED NO AND ONLY THE ADDITIONAL POINTS WERE ADDED");
		}
		driver.findElement(By.xpath(loc.getProperty("buildersgobackstatements"))).click();
		Thread.sleep(1000);
		driver.findElement(By.id(loc.getProperty("builderssecurityfenceyes"))).click();
		driver.findElement(By.id(loc.getProperty("builderswarningsignyes"))).click();
		driver.findElement(By.id(loc.getProperty("buildersalarmsystemyes"))).click();
		driver.findElement(By.id(loc.getProperty("buildersroutinepatrolyes"))).click();
		driver.findElement(By.id(loc.getProperty("builderssubdivisionyes"))).click();
		driver.findElement(By.id(loc.getProperty("buildersnightlightyes"))).click();
		driver.findElement(By.id(loc.getProperty("builderssecuritychecksyes"))).click();
		driver.findElement(By.id(loc.getProperty("builderssuspiciousactyes"))).click();
		driver.findElement(By.id(loc.getProperty("builderssecuredmaterialsyes"))).click();
		driver.findElement(By.id(loc.getProperty("buildersgatedsubdivisionyes"))).click();
		driver.findElement(By.cssSelector(loc.getProperty("buildersinternalpagebtn"))).click();
		Thread.sleep(1000);
		if(!driver.findElement(By.id(loc.getProperty("builderssecurityscore"))).getAttribute("innerText").equals("400")) {
			Assert.fail("EXPECTED SECURITY SCORE TO BE '400' SINCE ALL VALUES WERE ANSWERED YES AND THE ADDITIONAL POINTS WERE ADDED");
		}
		System.out.print("\nSecurity Scoring section is working as expected");
		driver.findElement(By.xpath(loc.getProperty("buildersgobackstatements"))).click();
		Thread.sleep(1000);
		driver.findElement(By.id(loc.getProperty("builderscrimescore"))).click();
		driver.findElement(By.id(loc.getProperty("builderscrimescore"))).sendKeys(CrimeScore);
		driver.findElement(By.id(loc.getProperty("builderscrimescore"))).click();
		driver.findElement(By.cssSelector(loc.getProperty("buildersinternalpagebtn"))).click();
		Thread.sleep(1000);
		if(CrimeScore.equalsIgnoreCase("D") || CrimeScore.equalsIgnoreCase("E") || CrimeScore.equalsIgnoreCase("F")) {
			if(!driver.findElement(By.id(loc.getProperty("builderssecurescore"))).getAttribute("value").equals("0")) {
				Assert.fail("EXPECTED CRIME SCORE TO HAVE A VALUE OF 0 SINCE IT WAS RATED AS 'D', 'E', OR 'F' ON THE STATEMENTS TAB");
			}
		}
		else {
			if(!driver.findElement(By.id(loc.getProperty("builderssecurescore"))).getAttribute("value").equals("70")) {
				Assert.fail("EXPECTED CRIME SCORE TO HAVE A VALUE OF 70 SINCE IT WAS RATED AS 'A', 'B', OR 'C' ON THE STATEMENTS TAB");
			}
		}
	}
	
	@Test(dataProvider = "NewConstructionData", description = "T18842	TC03 - Builders Risk - Internal Judgement Rate", enabled = true, priority = 3)
	public void buildersRiskInternal3(String newquotestate, String newquotepolicytype,
			String newquoteaddress, String newquoteaddress2, String newquotecity, String newquotezipcode,
			String agentcode, String buildersprojecttype, String builderspolicyterm, String buildersapplicantphone,
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
			throws InterruptedException{
		
		if(!driver.findElement(By.xpath(loc.getProperty("buildersinternalcounty"))).getAttribute("innerText").equals(builderscounty)) {
			Assert.fail("EXPECTED BUILDERS COUNTY TO BE '"+ builderscounty +"' BUT FOUND: " + driver.findElement(By.xpath(loc.getProperty("buildersinternalcounty"))).getAttribute("innerText"));
		}
		else {
			System.out.print("\nCounty is correctly being saved and displayed");
		}
		if(!driver.findElement(By.xpath(loc.getProperty("buildersinternalterritory"))).getAttribute("innerText").equals(buildersterritory)) {
			Assert.fail("EXPECTED BUILDERS TERRITORY TO BE '"+ buildersterritory +"' BUT FOUND: " + driver.findElement(By.xpath(loc.getProperty("buildersinternalterritory"))).getAttribute("innerText"));
		}
		else {
			System.out.print("\nTerritory is correctly being saved and displayed");
		}
		if(!driver.findElement(By.xpath(loc.getProperty("buildersinternalprotection"))).getAttribute("innerText").equals(buildersprotectionclass)) {
			Assert.fail("EXPECTED BUILDERS PROTECTION CLASS TO BE '"+ buildersprotectionclass +"' BUT FOUND: " + driver.findElement(By.xpath(loc.getProperty("buildersinternalprotection"))).getAttribute("innerText"));
		}
		else {
			System.out.print("\nProtection Class is correctly being saved and displayed");
		}
		if(!driver.findElement(By.xpath(loc.getProperty("buildersinternalprojecttype"))).getAttribute("innerText").equalsIgnoreCase(buildersprojecttype)) {
			Assert.fail("EXPECTED BUILDERS PROJECT TYPE TO BE '"+ buildersprojecttype +"' BUT FOUND: " + driver.findElement(By.xpath(loc.getProperty("buildersinternalprojecttype"))).getAttribute("innerText"));
		}
		else {
			System.out.print("\nProject Type is correctly being saved and displayed");
		}
		double completedlimit = Double.parseDouble(builderscompletedvalue);
		DecimalFormat formatter = new DecimalFormat("#,###.00");
		String valuelimit = "" + formatter.format(completedlimit);
		if(!driver.findElement(By.xpath(loc.getProperty("buildersinternalvaluelimit"))).getAttribute("innerText").contains(valuelimit)) {
			Assert.fail("EXPECTED BUILDERS COMPLETED VALUE LIMIT TO BE '"+ builderscompletedvalue +"' BUT FOUND: " + driver.findElement(By.xpath(loc.getProperty("buildersinternalvaluelimit"))).getAttribute("innerText"));
		}
		else {
			System.out.print("\nCompleted Value Limit is correctly being saved and displayed");
		}
		double limit = Double.parseDouble(buildersdeductible);
		String aoplimit = "" + formatter.format(limit);
		aoplimit = aoplimit.substring(0, aoplimit.length()-3);
		if(!driver.findElement(By.xpath(loc.getProperty("buildersinternalaopdeductible"))).getAttribute("innerText").contains(aoplimit)) {
			Assert.fail("EXPECTED BUILDERS AOP DEDUCTIBLE TO BE '"+ buildersdeductible +"' BUT FOUND: " + driver.findElement(By.xpath(loc.getProperty("buildersinternalaopdeductible"))).getAttribute("innerText"));
		}
		else {
			System.out.print("\nAOP Deductible is correctly being saved and displayed");
		}
		if(!driver.findElement(By.xpath(loc.getProperty("buildersinternalwinddeductible"))).getAttribute("innerText").contains(builderswindhaildeductible)) {
			Assert.fail("EXPECTED BUILDERS WIND/HAIL DEDUCTIBLE TO BE '"+ builderswindhaildeductible +"' BUT FOUND: " + driver.findElement(By.xpath(loc.getProperty("buildersinternalwinddeductible"))).getAttribute("innerText"));
		}
		else {
			System.out.print("\nWind/Hail Deductible is correctly being saved and displayed");
		}
		if(!driver.findElement(By.xpath(loc.getProperty("buildersinternallosses"))).getAttribute("innerText").equals("0")) {
			Assert.fail("EXPECTED BUILDERS LOSS HISTORY TO BE '0' BUT FOUND: " + driver.findElement(By.xpath(loc.getProperty("buildersinternallosses"))).getAttribute("innerText"));
		}
		else {
			System.out.print("\nLoss History is correctly being saved and displayed");
		}
		System.out.print("\nJudgement Rate section is working as expected");
		driver.findElement(By.id(loc.getProperty("buildersjudgementrate"))).click();
		if(!driver.findElement(By.id(loc.getProperty("buildersjudgementrate"))).getAttribute("minvalue").equals("0.000")) {
			Assert.fail("EXPECTED BUILDERS JUDGEMENT RATE TO HAVE A MINIMUM OF 0.000");
		}
		if(!driver.findElement(By.id(loc.getProperty("buildersjudgementrate"))).getAttribute("maxvalue").equals("5.000")) {
			Assert.fail("EXPECTED BUILDERS JUDGEMENT RATE TO HAVE A MAXIMUM OF 5.000");
		}
		driver.findElement(By.id(loc.getProperty("buildersjudgementrate"))).sendKeys(buildersjudgementrate);
		driver.findElement(By.id(loc.getProperty("buildersjudgementreason"))).click();
		if(!driver.findElement(By.id(loc.getProperty("buildersjudgementreason"))).getAttribute("maxlength").equals("500")) {
			Assert.fail("EXPECTED BUILDERS JUDGEMENT REASON TO HAVE A MAXIMUM CHARACTER LIMIT OF 500");
		}
		driver.findElement(By.id(loc.getProperty("buildersjudgementreason"))).sendKeys(buildersjudgementreason);
		driver.findElement(By.id(loc.getProperty("buildersfacultativeprem"))).click();
		if(!driver.findElement(By.id(loc.getProperty("buildersfacultativeprem"))).getAttribute("minvalue").equals("0")) {
			Assert.fail("EXPECTED BUILDERS FACULTATIVE REINSURANCE PREMIUM TO HAVE A MINIMUM OF 0");
		}
		if(!driver.findElement(By.id(loc.getProperty("buildersfacultativeprem"))).getAttribute("maxvalue").equals("50000")) {
			Assert.fail("EXPECTED BUILDERS FACULTATIVE REINSURANCE PREMIUM TO HAVE A MAXIMUM OF 50000");
		}
		driver.findElement(By.cssSelector(loc.getProperty("buildersdisplayquotepagebtn"))).click();
		Thread.sleep(2000);
		System.out.print("\nInternal's Page is working correctly\n");
		ReusableMethods.printValidations();
	}
}
