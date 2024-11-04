package buildersRiskTXAgentTests;                                                                     // THIS TEST RUNS FOR 2 MINUTES AND 36 SECONDS

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import actiondriver.Action;
import actiondriver.ReusableMethods;
import base.BuildersRiskBaseClass;
import utilities.XLUtility;

public class AgentAdditionalInterestsTest extends BuildersRiskBaseClass{
	
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
	
	@Test(dataProvider = "NewConstructionData", description = "Builders Risk Start Quote Walkthrough to Add Interest/Insured page", enabled = true, priority = 0)
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
		driver.findElement(By.id(loc.getProperty("buildersaddinterestbtn"))).click();
		Action.fluentWait(driver, null, 0);
	}
	
	@Test(dataProvider = "NewConstructionData", description = "T18798	TC01 - Builders Risk - Additional Interest & Insured Headers", enabled = true, priority = 1)
	public void buildersRiskInterests1(String newquotestate, String newquotepolicytype, String newquoteaddress, String newquoteaddress2, 
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
		System.out.print("Effective Date: " + driver.findElement(By.xpath(loc.getProperty("effectivedate"))).getAttribute("value"));
	}
	
	@Test(description = "T18799	TC02 - Builders Risk - Additional Interest", enabled = true, priority = 2)
	public void buildersRiskInterests2() throws InterruptedException{
		Boolean checker = true;
		try {
			driver.findElement(By.id(loc.getProperty("buildersloannumber"))).click();
		} catch (Exception e) {
			Assert.fail("LOAN NUMBER NOT FOUND/HIDDEN");
		}
		driver.findElement(By.cssSelector(loc.getProperty("buildershistorybtn"))).click();
		try {
			driver.findElement(By.cssSelector(loc.getProperty("buildershistorybtn"))).click();
		} catch (Exception e) {
			Assert.fail("USER WAS ABLE TO PROGRESS WITH EMPTY FIELDS");
		}
		driver.findElement(By.id(loc.getProperty("buildersinteresttype"))).click();
		driver.findElement(By.id(loc.getProperty("buildersinteresttype"))).sendKeys("M");
		driver.findElement(By.id(loc.getProperty("buildersinterestname"))).click();
		if(!driver.findElement(By.id(loc.getProperty("buildersinterestname"))).getAttribute("maxlength").equals("50")) {
	    	Assert.fail("EXPECTED INTEREST NAME FIELD TO HAVE A MAX LENGTH OF 50");
	    }
		driver.findElement(By.id(loc.getProperty("buildersinterestname"))).sendKeys("NAME");
		driver.findElement(By.id(loc.getProperty("buildersinterestaddress"))).click();
		if(!driver.findElement(By.id(loc.getProperty("buildersinterestaddress"))).getAttribute("maxlength").equals("50")) {
	    	Assert.fail("EXPECTED INTEREST ADDRESS FIELD TO HAVE A MAX LENGTH OF 50");
	    }
		driver.findElement(By.id(loc.getProperty("buildersinterestaddress"))).sendKeys("4222 E Curtis St");
		driver.findElement(By.id(loc.getProperty("buildersinterestaddress2"))).click();
		if(!driver.findElement(By.id(loc.getProperty("buildersinterestaddress2"))).getAttribute("maxlength").equals("50")) {
	    	Assert.fail("EXPECTED INTEREST ADDRESS 2 FIELD TO HAVE A MAX LENGTH OF 50");
	    }
		driver.findElement(By.id(loc.getProperty("buildersinterestaddress2"))).sendKeys("APT 2");
		driver.findElement(By.id(loc.getProperty("buildersinterestcity"))).click();
		if(!driver.findElement(By.id(loc.getProperty("buildersinterestcity"))).getAttribute("maxlength").equals("50")) {
	    	Assert.fail("EXPECTED INTEREST CITY FIELD TO HAVE A MAX LENGTH OF 50");
	    }
		driver.findElement(By.id(loc.getProperty("buildersinterestcity"))).sendKeys("Tampa");
		driver.findElement(By.id(loc.getProperty("buildersintereststate"))).click();
		driver.findElement(By.id(loc.getProperty("buildersintereststate"))).sendKeys("FL");
		driver.findElement(By.id(loc.getProperty("buildersinterestzip"))).click();
		if(!driver.findElement(By.id(loc.getProperty("buildersinterestzip"))).getAttribute("maxlength").equals("5")) {
	    	Assert.fail("EXPECTED INTEREST ZIP CODE FIELD TO HAVE A MAX LENGTH OF 5");
	    }
		driver.findElement(By.id(loc.getProperty("buildersinterestzip"))).sendKeys("33610");
		driver.findElement(By.id(loc.getProperty("buildersinterestzip4"))).click();
		if(!driver.findElement(By.id(loc.getProperty("buildersinterestzip4"))).getAttribute("maxlength").equals("4")) {
	    	Assert.fail("EXPECTED INTEREST ZIP4 CODE FIELD TO HAVE A MAX LENGTH OF 5");
	    }
		Thread.sleep(2000);
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			System.out.print("\nNo alert shown for address");
		}
		if(!driver.findElement(By.id(loc.getProperty("buildersloannumber"))).getAttribute("maxlength").equals("20")) {
	    	Assert.fail("EXPECTED LOAN NUMBER FIELD TO HAVE A MAX LENGTH OF 20");
	    }
		driver.findElement(By.id(loc.getProperty("buildersloannumber"))).sendKeys("TEST");
		driver.findElement(By.id(loc.getProperty("buildersinterestaddresstype"))).click();
		driver.findElement(By.id(loc.getProperty("buildersinterestaddresstype"))).sendKeys("I");
		driver.findElement(By.id(loc.getProperty("buildersinterestaddresstype"))).click();
		driver.findElement(By.id(loc.getProperty("buildersinterestaddress"))).click();
		driver.findElement(By.id(loc.getProperty("buildersinterestaddress2"))).click();
		try {
			driver.findElement(By.id(loc.getProperty("buildersinterestcountry"))).click();
		} catch (Exception e) {
			Assert.fail("INTEREST ADDRESS TYPE WAS SET TO INTERNATIONAL BUT COUNTRY NAME FIELD IS MISSING");
		}
		if(!driver.findElement(By.id(loc.getProperty("buildersinterestcountry"))).getAttribute("maxlength").equals("100")) {
	    	Assert.fail("EXPECTED COUNTRY NAME FIELD TO HAVE A MAX LENGTH OF 100");
	    }
		driver.findElement(By.xpath(loc.getProperty("builderslookupinterestbtn"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("builderslookupsearchterm"))).click();
		driver.findElement(By.xpath(loc.getProperty("builderslookupsearchstate"))).click();
		driver.findElement(By.xpath(loc.getProperty("builderslookupsearchstate"))).click();
		driver.findElement(By.xpath(loc.getProperty("builderslookupclosebtn"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("buildersminimizeinterest"))).click();
		Thread.sleep(1000);
		checker = true;
		try {
			driver.findElement(By.id(loc.getProperty("buildersinterestaddress"))).click();
			Action.fluentWait(driver, null, 0);
		} catch (Exception e) {
			checker = false;
			System.out.print("\nBuilder's Minimize Interest Button is working correctly");
		}
		if(checker==true) {
			Assert.fail("THE BUILDER'S MINIMIZE INTEREST IS NOT WORKING AS EXPECTED");
		}
		driver.findElement(By.xpath(loc.getProperty("buildersminimizeinterest"))).click();
		driver.findElement(By.id(loc.getProperty("buildersdeleteinterestbtn"))).click();
		Action.fluentWait(driver, null, 0);
		Action.fluentWait(driver, null, 0);
		driver.findElement(By.id(loc.getProperty("buildersinterestclosedeletebtn"))).click();
		Thread.sleep(1000);
		driver.findElement(By.id(loc.getProperty("buildersdeleteinterestbtn"))).click();
		Thread.sleep(1000);
		driver.findElement(By.id(loc.getProperty("buildersinterestconfirmdeletebtn"))).click();
		Action.fluentWait(driver, null, 0);
		
	}
	
	@Test(dataProvider = "NewConstructionData", description = "T18801	TC04 - Builders Risk - Additional Insureds", enabled = true, priority = 3)
	public void buildersRiskInterests3(String newquotestate, String newquotepolicytype, String newquoteaddress, String newquoteaddress2, 
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
		
		driver.findElement(By.id(loc.getProperty("buildersaddinsuredbtn"))).click();
		Thread.sleep(2000);
		driver.findElement(By.id(loc.getProperty("builderstinsuredtype"))).click();
		driver.findElement(By.id(loc.getProperty("builderstinsuredtype"))).sendKeys("A");
		driver.findElement(By.id(loc.getProperty("builderstinsuredtype"))).click();
		driver.findElement(By.id(loc.getProperty("builderstinsuredfirstname"))).click();
		if(!driver.findElement(By.id(loc.getProperty("builderstinsuredfirstname"))).getAttribute("maxlength").equals("35")) {
	    	Assert.fail("EXPECTED FIRST NAME FIELD TO HAVE A MAX LENGTH OF 35");
	    }
		driver.findElement(By.id(loc.getProperty("builderstinsuredfirstname"))).sendKeys("JOHN");
		driver.findElement(By.id(loc.getProperty("builderstinsuredmiddlename"))).click();
		if(!driver.findElement(By.id(loc.getProperty("builderstinsuredmiddlename"))).getAttribute("maxlength").equals("15")) {
	    	Assert.fail("EXPECTED MIDDLE NAME FIELD TO HAVE A MAX LENGTH OF 15");
	    }
		driver.findElement(By.id(loc.getProperty("builderstinsuredmiddlename"))).sendKeys("D");
		driver.findElement(By.id(loc.getProperty("builderstinsuredlastname"))).click();
		if(!driver.findElement(By.id(loc.getProperty("builderstinsuredlastname"))).getAttribute("maxlength").equals("50")) {
	    	Assert.fail("EXPECTED LAST NAME FIELD TO HAVE A MAX LENGTH OF 50");
	    }
		driver.findElement(By.id(loc.getProperty("builderstinsuredlastname"))).sendKeys("SMITH");
		driver.findElement(By.id(loc.getProperty("builderstinsuredsuffix"))).click();
		if(!driver.findElement(By.id(loc.getProperty("builderstinsuredsuffix"))).getAttribute("maxlength").equals("10")) {
	    	Assert.fail("EXPECTED SUFFIX NAME FIELD TO HAVE A MAX LENGTH OF 10");
	    }
		driver.findElement(By.id(loc.getProperty("builderstinsuredsuffix"))).sendKeys("JR");
		driver.findElement(By.id(loc.getProperty("builderstinsuredaddresstype"))).click();
		driver.findElement(By.id(loc.getProperty("builderstinsuredaddresstype"))).click();
		driver.findElement(By.id(loc.getProperty("builderstinsuredaddress"))).click();
		if(!driver.findElement(By.id(loc.getProperty("builderstinsuredaddress"))).getAttribute("maxlength").equals("50")) {
	    	Assert.fail("EXPECTED INSURED ADDRESS FIELD TO HAVE A MAX LENGTH OF 50");
	    }
		driver.findElement(By.id(loc.getProperty("builderstinsuredaddress"))).sendKeys("4222 E Curtis St");
		driver.findElement(By.id(loc.getProperty("builderstinsuredaddress2"))).click();
		if(!driver.findElement(By.id(loc.getProperty("builderstinsuredaddress2"))).getAttribute("maxlength").equals("50")) {
	    	Assert.fail("EXPECTED INSURED ADDRESS 2 FIELD TO HAVE A MAX LENGTH OF 50");
	    }
		driver.findElement(By.id(loc.getProperty("builderstinsuredaddress2"))).sendKeys("APT 2");
		driver.findElement(By.id(loc.getProperty("builderstinsuredcity"))).click();
		if(!driver.findElement(By.id(loc.getProperty("builderstinsuredcity"))).getAttribute("maxlength").equals("50")) {
	    	Assert.fail("EXPECTED INSURED CITY FIELD TO HAVE A MAX LENGTH OF 50");
	    }
		driver.findElement(By.id(loc.getProperty("builderstinsuredcity"))).sendKeys("Tampa");
		driver.findElement(By.id(loc.getProperty("builderstinsuredstate"))).click();
		driver.findElement(By.id(loc.getProperty("builderstinsuredstate"))).sendKeys("FL");
		driver.findElement(By.id(loc.getProperty("builderstinsuredzip"))).click();
		if(!driver.findElement(By.id(loc.getProperty("builderstinsuredzip"))).getAttribute("maxlength").equals("5")) {
	    	Assert.fail("EXPECTED INSURED ZIP CODE FIELD TO HAVE A MAX LENGTH OF 5");
	    }
		driver.findElement(By.id(loc.getProperty("builderstinsuredzip"))).sendKeys("33610");
		driver.findElement(By.id(loc.getProperty("builderstinsuredzip4"))).click();
		if(!driver.findElement(By.id(loc.getProperty("builderstinsuredzip4"))).getAttribute("maxlength").equals("4")) {
	    	Assert.fail("EXPECTED INSURED ZIP4 CODE FIELD TO HAVE A MAX LENGTH OF 4");
	    }
		Thread.sleep(2000);
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			System.out.print("\nNo alert shown for address");
		}
		driver.findElement(By.xpath(loc.getProperty("buildersminimizeinsured"))).click();
		Thread.sleep(1000);
		Boolean checker = true;
		try {
			driver.findElement(By.id(loc.getProperty("builderstinsuredzip4"))).click();
		} catch (Exception e) {
			checker = false;
			System.out.print("\nBuilder's Minimize Insured Button is working correctly");
		}
		if(checker==true) {
			Assert.fail("THE BUILDER'S MINIMIZE INSURED IS NOT WORKING AS EXPECTED");
		}
		driver.findElement(By.xpath(loc.getProperty("buildersminimizeinsured"))).click();
		driver.findElement(By.id(loc.getProperty("builderstinsuredaddresstype"))).click();
		driver.findElement(By.id(loc.getProperty("builderstinsuredaddresstype"))).sendKeys("I");
		driver.findElement(By.id(loc.getProperty("builderstinsuredaddresstype"))).click();
		driver.findElement(By.id(loc.getProperty("builderstinsuredaddress"))).click();
		driver.findElement(By.id(loc.getProperty("builderstinsuredaddress2"))).click();
		driver.findElement(By.id(loc.getProperty("buildersinsuredcountry"))).click();
		if(!driver.findElement(By.id(loc.getProperty("buildersinsuredcountry"))).getAttribute("maxlength").equals("100")) {
	    	Assert.fail("EXPECTED INSURED COUNTRY NAME FIELD TO HAVE A MAX LENGTH OF 100");
	    }
		driver.findElement(By.id(loc.getProperty("buildersdeleteinsuredbtn"))).click();
		Thread.sleep(1000);
		driver.findElement(By.id(loc.getProperty("buildersinterestclosedeletebtn"))).click();
		Thread.sleep(1000);
		driver.findElement(By.id(loc.getProperty("buildersdeleteinsuredbtn"))).click();
		Thread.sleep(1000);
		driver.findElement(By.id(loc.getProperty("buildersinterestconfirmdeletebtn"))).click();
		Action.fluentWait(driver, null, 0);
		System.out.print("\nBuilder's Add Interest/Insured page is working successfully");
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
	}
}
