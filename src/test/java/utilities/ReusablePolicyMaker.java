package utilities;

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
import base.BuildersRiskBaseClass;

public class ReusablePolicyMaker extends BuildersRiskBaseClass {

	protected String policyNumber = "POLICY NOT CREATED";
	protected String[] TXData;
	protected String[] FLData;
	
	@DataProvider(name = "ReusableTexasPolicy")
	public String[][] getData() throws IOException {
		// Get data from Excel
		String path = ".\\src\\main\\resources\\data\\BuilderRiskData.xlsx";
		XLUtility xlutil = new XLUtility(path);

		int totalrows = xlutil.getRowCount("ReusableTexasPolicy");
		int totalcols = xlutil.getCellCount("ReusableTexasPolicy", 1);

		String loginData[][] = new String[totalrows][totalcols];

		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				loginData[i - 1][j] = xlutil.getCellData("ReusableTexasPolicy", i, j);
			}
		}
		return loginData;
	}
	
	@DataProvider(name = "ReusableFloridaPolicy")
	public String[][] getData2() throws IOException {
		// Get data from Excel
		String path = ".\\src\\main\\resources\\data\\BuilderRiskData.xlsx";
		XLUtility xlutil = new XLUtility(path);

		int totalrows = xlutil.getRowCount("ReusableFloridaPolicy");
		int totalcols = xlutil.getCellCount("ReusableFloridaPolicy", 1);

		String loginData[][] = new String[totalrows][totalcols];

		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				loginData[i - 1][j] = xlutil.getCellData("ReusableFloridaPolicy", i, j);
			}
		}
		return loginData;
	}
	
	@Test(dataProvider = "ReusableTexasPolicy", description = "Builders Risk - Generate Texas Policy Data", enabled = true, priority = 0)
	public void GenerateTXData(String newquotestate, String newquotepolicytype, String newquoteaddress,
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
			String builderssecuritypoints, String buildersjudgementrate, String buildersjudgementreason) {
		
		String[] TXData = {newquotestate, newquotepolicytype, newquoteaddress,
				 newquoteaddress2, newquotecity, newquotezipcode, agentcode,
				 buildersprojecttype, builderspolicyterm, buildersapplicantphone,
				 buildersapplicantemail, buildersapplicanttype, buildersnametype,
				 buildersfirstname, buildersmiddlename, builderslastname, builderssuffixname,
				 buildersbusinessname, buildersdbaname, buildersstructure,
				 buildersmailingaddress, buildersmailingaddress2, buildersmailingcity,
				 buildersmailingstate, buildersmailingzip, buildersmailingzip4,
				 builderslocationzip4, builderscounty, builderscoastdistance,
				 builderscoastdistanceunit, builderswindpool, buildersterritory,
				 builderssinkholedistance, builderssinkholedistanceunits, buildersprotectionclass,
				 buildersfirestation, buildersfirehydrant, builderscompletedvalue,
				 buildersdeductible, builderswindhaildeductible, buildersconstructioncostlimit,
				 builderspropertytransitlimit, builderssoftcostlimit, buildersstructuretype,
				 buildersconstructionyear, builderselectricalyear, buildersroofingyear,
				 buildersplumbingyear, buildershvacyear, builderssquarefootage, buildersroofmaterial,
				 buildersconstructiontype, builderspriorinscarrier, buildersnumberofstories,
				 builderspriorinsenddate, builderspriorinspremium, buildersinteresttype,
				 buildersinterestname, buildersinterestaddress, buildersinterestaddress2,
				 buildersinterestcity, buildersintereststate, buildersinterestzip,
				 buildersinterestzip4, buildersloannumber, builderstinsuredtype,
				 builderstinsuredfirstname, builderstinsuredmiddlename, builderstinsuredlastname,
				 builderstinsuredaddress, builderstinsuredaddress2, builderstinsuredcity,
				 builderstinsuredstate, builderstinsuredzip, builderslegalname,
				 buildersconstructionstarted, buildersconstructionstartdate, builderspercentcomplete,
				 builderscrimescore, builderscrimetext, builderssecuritydesc,
				 builderssecuritypoints, buildersjudgementrate, buildersjudgementreason, buildersroofmaterial};
		this.TXData = TXData;
	}
	
	@Test(dataProvider = "ReusableFloridaPolicy", description = "Builders Risk - Generate Florida Policy Data", enabled = true, priority = 0)
	public void GenerateFLData(String newquotestate, String newquotepolicytype, String newquoteaddress,
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
			String builderssecuritypoints, String buildersjudgementrate, String buildersjudgementreason) {
		
		String[] FLData = {newquotestate, newquotepolicytype, newquoteaddress,
				 newquoteaddress2, newquotecity, newquotezipcode, agentcode,
				 buildersprojecttype, builderspolicyterm, buildersapplicantphone,
				 buildersapplicantemail, buildersapplicanttype, buildersnametype,
				 buildersfirstname, buildersmiddlename, builderslastname, builderssuffixname,
				 buildersbusinessname, buildersdbaname, buildersstructure,
				 buildersmailingaddress, buildersmailingaddress2, buildersmailingcity,
				 buildersmailingstate, buildersmailingzip, buildersmailingzip4,
				 builderslocationzip4, builderscounty, builderscoastdistance,
				 builderscoastdistanceunit, builderswindpool, buildersterritory,
				 builderssinkholedistance, builderssinkholedistanceunits, buildersprotectionclass,
				 buildersfirestation, buildersfirehydrant, builderscompletedvalue,
				 buildersdeductible, builderswindhaildeductible, buildersconstructioncostlimit,
				 builderspropertytransitlimit, builderssoftcostlimit, buildersstructuretype,
				 buildersconstructionyear, builderselectricalyear, buildersroofingyear,
				 buildersplumbingyear, buildershvacyear, builderssquarefootage, buildersroofmaterial,
				 buildersconstructiontype, builderspriorinscarrier, buildersnumberofstories,
				 builderspriorinsenddate, builderspriorinspremium, buildersinteresttype,
				 buildersinterestname, buildersinterestaddress, buildersinterestaddress2,
				 buildersinterestcity, buildersintereststate, buildersinterestzip,
				 buildersinterestzip4, buildersloannumber, builderstinsuredtype,
				 builderstinsuredfirstname, builderstinsuredmiddlename, builderstinsuredlastname,
				 builderstinsuredaddress, builderstinsuredaddress2, builderstinsuredcity,
				 builderstinsuredstate, builderstinsuredzip, builderslegalname,
				 buildersconstructionstarted, buildersconstructionstartdate, builderspercentcomplete,
				 builderscrimescore, builderscrimetext, builderssecuritydesc,
				 builderssecuritypoints, buildersjudgementrate, buildersjudgementreason};
		this.FLData = FLData;
	}
	
	@SuppressWarnings("unused")
	public void CreateNewPolicyTX() throws InterruptedException, ParseException {

		String newquotestate = TXData[0]; 
		String newquotepolicytype = TXData[1];
		String newquoteaddress = TXData[2];
		String newquoteaddress2 = TXData[3]; 
		String newquotecity = TXData[4]; 
		String newquotezipcode = TXData[5]; 
		String agentcode = TXData[6];
		String buildersprojecttype = TXData[7]; 
		String builderspolicyterm = TXData[8]; 
		String buildersapplicantphone = TXData[9];
		String buildersapplicantemail = TXData[10]; 
		String buildersapplicanttype = TXData[11]; 
		String buildersnametype = TXData[12];
		String buildersfirstname = TXData[13]; 
		String buildersmiddlename = TXData[14];
		String builderslastname = TXData[15];
		String builderssuffixname = TXData[16];
		String buildersbusinessname = TXData[17]; 
		String buildersdbaname = TXData[18]; 
		String buildersstructure = TXData[19];
		String buildersmailingaddress = TXData[20]; 
		String buildersmailingaddress2 = TXData[21]; 
		String buildersmailingcity = TXData[22];
		String buildersmailingstate = TXData[23]; 
		String buildersmailingzip = TXData[24]; 
		String buildersmailingzip4 = TXData[25];
		String builderslocationzip4 = TXData[26]; 
		String builderscounty = TXData[27]; 
		String builderscoastdistance = TXData[28];
		String builderscoastdistanceunit = TXData[29]; 
		String builderswindpool = TXData[30]; 
		String buildersterritory = TXData[31];
		String builderssinkholedistance = TXData[32]; 
		String builderssinkholedistanceunits = TXData[33]; 
		String buildersprotectionclass = TXData[34];
		String buildersfirestation = TXData[35]; 
		String buildersfirehydrant = TXData[36]; 
		String builderscompletedvalue = TXData[37];
		String buildersdeductible = TXData[38]; 
		String builderswindhaildeductible = TXData[39]; 
		String buildersconstructioncostlimit = TXData[40];
		String builderspropertytransitlimit = TXData[41]; 
		String builderssoftcostlimit = TXData[42]; 
		String buildersstructuretype = TXData[43];
		String buildersconstructionyear = TXData[44]; 
		String builderselectricalyear = TXData[45]; 
		String buildersroofingyear = TXData[46];
		String buildersplumbingyear = TXData[47]; 
		String buildershvacyear = TXData[48]; 
		String builderssquarefootage = TXData[49];
		String buildersroofmaterial = TXData[50];
		String buildersconstructiontype = TXData[51]; 
		String builderspriorinscarrier = TXData[52]; 
		String buildersnumberofstories = TXData[53];
		String builderspriorinsenddate = TXData[54]; 
		String builderspriorinspremium = TXData[55]; 
		String buildersinteresttype = TXData[56];
		String buildersinterestname = TXData[57]; 
		String buildersinterestaddress = TXData[58]; 
		String buildersinterestaddress2 = TXData[59];
		String buildersinterestcity = TXData[60]; 
		String buildersintereststate = TXData[61]; 
		String buildersinterestzip = TXData[62];
		String buildersinterestzip4 = TXData[63]; 
		String buildersloannumber = TXData[64]; 
		String builderstinsuredtype = TXData[65];
		String builderstinsuredfirstname = TXData[66]; 
		String builderstinsuredmiddlename = TXData[67]; 
		String builderstinsuredlastname = TXData[68];
		String builderstinsuredaddress = TXData[69]; 
		String builderstinsuredaddress2 = TXData[70]; 
		String builderstinsuredcity = TXData[71];
		String builderstinsuredstate = TXData[72]; 
		String builderstinsuredzip = TXData[73]; 
		String builderslegalname = TXData[74];
		String buildersconstructionstarted = TXData[75]; 
		String buildersconstructionstartdate = TXData[76]; 
		String builderspercentcomplete = TXData[77];
		String builderscrimescore = TXData[78]; 
		String builderscrimetext = TXData[79]; 
		String builderssecuritydesc = TXData[80];
		String builderssecuritypoints = TXData[81]; 
		String buildersjudgementrate = TXData[82]; 
		String buildersjudgementreason = TXData[83];
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
		Thread.sleep(10000);
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			Thread.sleep(500);
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
			Thread.sleep(500);
		}
		Select buildercounty = new Select(driver.findElement(By.id(loc.getProperty("builderscounty"))));
		driver.findElement(By.id(loc.getProperty("builderscounty"))).click();
		Thread.sleep(5000);
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			Thread.sleep(500);
		}
		buildercounty.selectByVisibleText(builderscounty);
		driver.findElement(By.id(loc.getProperty("builderswindpool"))).click();
		driver.findElement(By.id(loc.getProperty("builderswindpool"))).sendKeys(builderswindpool);
		driver.findElement(By.id(loc.getProperty("buildersprotectionclass"))).click();
		driver.findElement(By.id(loc.getProperty("buildersprotectionclass"))).sendKeys(buildersprotectionclass);
		driver.findElement(By.id(loc.getProperty("buildersfirestation"))).click();
		Thread.sleep(5000);
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			Thread.sleep(500);
		}
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
		driver.findElement(By.id(loc.getProperty("builderswindhaildeductible"))).click();
		driver.findElement(By.id(loc.getProperty("builderswindhaildeductible"))).sendKeys(builderswindhaildeductible);
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
				Thread.sleep(500);
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
			Thread.sleep(5000);
			try {
				driver.switchTo().alert().accept();
			} catch (Exception e) {
				Thread.sleep(500);
			}
		}
		driver.findElement(By.cssSelector(loc.getProperty("buildershistorybtn"))).click();
		Action.fluentWait(driver, null, 0);
		driver.findElement(By.id(loc.getProperty("buildersclaimnumbers"))).click();
		driver.findElement(By.cssSelector(loc.getProperty("buildersstatementspagebtn"))).click();
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
		policyNumber = driver.findElement(By.xpath(loc.getProperty("builderspolicynumber"))).getText();
		System.out.print("\nPolicy Created: " + policyNumber + "\n");
	}
	
	@SuppressWarnings("unused")
	public void CreateNewPolicyFL() throws InterruptedException, ParseException{
		
		String newquotestate = FLData[0]; 
		String newquotepolicytype = FLData[1];
		String newquoteaddress = FLData[2];
		String newquoteaddress2 = FLData[3]; 
		String newquotecity = FLData[4]; 
		String newquotezipcode = FLData[5]; 
		String agentcode = FLData[6];
		String buildersprojecttype = FLData[7]; 
		String builderspolicyterm = FLData[8]; 
		String buildersapplicantphone = FLData[9];
		String buildersapplicantemail = FLData[10]; 
		String buildersapplicanttype = FLData[11]; 
		String buildersnametype = FLData[12];
		String buildersfirstname = FLData[13]; 
		String buildersmiddlename = FLData[14];
		String builderslastname = FLData[15];
		String builderssuffixname = FLData[16];
		String buildersbusinessname = FLData[17]; 
		String buildersdbaname = FLData[18]; 
		String buildersstructure = FLData[19];
		String buildersmailingaddress = FLData[20]; 
		String buildersmailingaddress2 = FLData[21]; 
		String buildersmailingcity = FLData[22];
		String buildersmailingstate = FLData[23]; 
		String buildersmailingzip = FLData[24]; 
		String buildersmailingzip4 = FLData[25];
		String builderslocationzip4 = FLData[26]; 
		String builderscounty = FLData[27]; 
		String builderscoastdistance = FLData[28];
		String builderscoastdistanceunit = FLData[29]; 
		String builderswindpool = FLData[30]; 
		String buildersterritory = FLData[31];
		String builderssinkholedistance = FLData[32]; 
		String builderssinkholedistanceunits = FLData[33]; 
		String buildersprotectionclass = FLData[34];
		String buildersfirestation = FLData[35]; 
		String buildersfirehydrant = FLData[36]; 
		String builderscompletedvalue = FLData[37];
		String buildersdeductible = FLData[38]; 
		String builderswindhaildeductible = FLData[39]; 
		String buildersconstructioncostlimit = FLData[40];
		String builderspropertytransitlimit = FLData[41]; 
		String builderssoftcostlimit = FLData[42]; 
		String buildersstructuretype = FLData[43];
		String buildersconstructionyear = FLData[44]; 
		String builderselectricalyear = FLData[45]; 
		String buildersroofingyear = FLData[46];
		String buildersplumbingyear = FLData[47]; 
		String buildershvacyear = FLData[48]; 
		String builderssquarefootage = FLData[49];
		String buildersroofmaterial = TXData[50];
		String buildersconstructiontype = FLData[51]; 
		String builderspriorinscarrier = FLData[52]; 
		String buildersnumberofstories = FLData[53];
		String builderspriorinsenddate = FLData[54]; 
		String builderspriorinspremium = FLData[55]; 
		String buildersinteresttype = FLData[56];
		String buildersinterestname = FLData[57]; 
		String buildersinterestaddress = FLData[58]; 
		String buildersinterestaddress2 = FLData[59];
		String buildersinterestcity = FLData[60]; 
		String buildersintereststate = FLData[61]; 
		String buildersinterestzip = FLData[62];
		String buildersinterestzip4 = FLData[63]; 
		String buildersloannumber = FLData[64]; 
		String builderstinsuredtype = FLData[65];
		String builderstinsuredfirstname = FLData[66]; 
		String builderstinsuredmiddlename = FLData[67]; 
		String builderstinsuredlastname = FLData[68];
		String builderstinsuredaddress = FLData[69]; 
		String builderstinsuredaddress2 = FLData[70]; 
		String builderstinsuredcity = FLData[71];
		String builderstinsuredstate = FLData[72]; 
		String builderstinsuredzip = FLData[73]; 
		String builderslegalname = FLData[74];
		String buildersconstructionstarted = FLData[75]; 
		String buildersconstructionstartdate = FLData[76]; 
		String builderspercentcomplete = FLData[77];
		String builderscrimescore = FLData[78]; 
		String builderscrimetext = FLData[79]; 
		String builderssecuritydesc = FLData[80];
		String builderssecuritypoints = FLData[81]; 
		String buildersjudgementrate = FLData[82]; 
		String buildersjudgementreason = FLData[83];
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
			Thread.sleep(500);
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
			Thread.sleep(500);
		}
		Select buildercounty = new Select(driver.findElement(By.id(loc.getProperty("builderscounty"))));
		driver.findElement(By.id(loc.getProperty("builderscounty"))).click();
		Thread.sleep(5000);
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			Thread.sleep(500);
		}
		buildercounty.selectByVisibleText(builderscounty);
		driver.findElement(By.id(loc.getProperty("builderswindpool"))).click();
		driver.findElement(By.id(loc.getProperty("builderswindpool"))).sendKeys(builderswindpool);
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
			Thread.sleep(500);
		}
		driver.findElement(By.id(loc.getProperty("builderssinkholedistance"))).click();
		driver.findElement(By.id(loc.getProperty("builderssinkholedistance"))).sendKeys(builderssinkholedistance);
		driver.findElement(By.id(loc.getProperty("builderssinkholedistanceunits"))).click();
		driver.findElement(By.id(loc.getProperty("builderssinkholedistanceunits"))).sendKeys(builderssinkholedistanceunits);
		driver.findElement(By.id(loc.getProperty("buildersprotectionclass"))).click();
		driver.findElement(By.id(loc.getProperty("buildersprotectionclass"))).sendKeys(buildersprotectionclass);
		driver.findElement(By.id(loc.getProperty("buildersfirestation"))).click();
		Thread.sleep(5000);
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			Thread.sleep(500);
		}
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
		driver.findElement(By.id(loc.getProperty("builderswindhaildeductible"))).click();
		driver.findElement(By.id(loc.getProperty("builderswindhaildeductible"))).sendKeys(builderswindhaildeductible);
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
				Thread.sleep(500);
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
				Thread.sleep(500);
			}
		}
		driver.findElement(By.cssSelector(loc.getProperty("buildershistorybtn"))).click();
		driver.findElement(By.id(loc.getProperty("buildersclaimnumbers"))).click();
		driver.findElement(By.cssSelector(loc.getProperty("buildersstatementspagebtn"))).click();
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
		policyNumber = driver.findElement(By.xpath(loc.getProperty("builderspolicynumber"))).getText();
		System.out.print("\nPolicy Created: " + policyNumber + "\n");
	}
}
