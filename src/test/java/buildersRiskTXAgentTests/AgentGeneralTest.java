package buildersRiskTXAgentTests;                                                                     // THIS TEST RUNS FOR 5 MINUTES AND 07 SECONDS

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

public class AgentGeneralTest extends BuildersRiskBaseClass{

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
	
	@Test(dataProvider = "NewConstructionData", description = "Builders Risk Start Quote Walkthrough to General", enabled = true, priority = 0)
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
			throws InterruptedException {

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
	}
	
	
	@Test(dataProvider = "NewConstructionData", description = "T18789	TC01 - Builders Risk - General Headers", enabled = true, priority = 1)
	public void buildersRiskGeneral1(String newquotestate, String newquotepolicytype, String newquoteaddress, String newquoteaddress2, 
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
		driver.findElement(By.id(loc.getProperty("buildersroofmaterial"))).click();
		driver.findElement(By.id(loc.getProperty("buildersroofmaterial"))).sendKeys(buildersroofmaterial);
	}
	
	@Test(description = "T18790	TC02 - Builders Risk - General - Policy Information", enabled = true, priority = 2)
	public void buildersRiskGeneral2()throws InterruptedException {
		driver.findElement(By.xpath(loc.getProperty("buildersaddinterestpage"))).click();
		Action.fluentWait(driver, null, 0);
		try {
			driver.findElement(By.xpath(loc.getProperty("buildersaddinterestpage"))).click();
		} catch (Exception e) {
			Assert.fail("USER WAS ABLE TO PROGRESS TO ADD INTEREST PAGE WITH BLANK FIELDS ON THE GENERAL PAGE");
		}
		if(!driver.findElement(By.id(loc.getProperty("buildersstructuretype"))).getAttribute("childElementCount").equals("13")) {
			Assert.fail("EXPECTED BUILDER'S STRUCTURE TYPE TO ONLY HAVE 13 OPTIONS AVAILABLE");
		}
		Select structure = new Select(driver.findElement(By.id(loc.getProperty("buildersstructuretype"))));
		if(structure.getFirstSelectedOption().getText().equals("")) {
			System.out.print("\nBuilder's Structure Type is blank by default as expected");
		}
		else {
			Assert.fail("EXPECTED BUILDER'S STRUCTURE TYPE TO BE BLANK BY DEFAULT");
		}
		try {
			driver.findElement(By.id(loc.getProperty("buildersstructuredesc"))).click();
		} catch (Exception e) {
			System.out.print("\nStructure Type Description is hidden by default as expected");
		}
		structure.selectByValue("SINGLEFAMILYDWELLING");
		try {
			driver.findElement(By.id(loc.getProperty("buildersstructuredesc"))).click();
		} catch (Exception e) {
			System.out.print("\nStructure Type 'Single family residential dwelling' is working correctly");
		}
		structure.selectByValue("TWOFAMILYDWELLING");
		try {
			driver.findElement(By.id(loc.getProperty("buildersstructuredesc"))).click();
		} catch (Exception e) {
			System.out.print("\nStructure Type 'Two family residential dwelling' is working correctly");
		}
		structure.selectByValue("THREEFAMILYDWELLING");
		try {
			driver.findElement(By.id(loc.getProperty("buildersstructuredesc"))).click();
		} catch (Exception e) {
			System.out.print("\nStructure Type 'Three family residential dwelling' is working correctly");
		}
		structure.selectByValue("FOURFAMILYDWELLING");
		try {
			driver.findElement(By.id(loc.getProperty("buildersstructuredesc"))).click();
		} catch (Exception e) {
			System.out.print("\nStructure Type 'Four family residential dwelling' is working correctly");
		}
		structure.selectByValue("MULTIUNIT");
		try {
			driver.findElement(By.id(loc.getProperty("buildersstructuredesc"))).click();
		} catch (Exception e) {
			System.out.print("\nStructure Type 'Multiunit (Four or more units per building)' is working correctly");
		}
		structure.selectByValue("APARTMENTCOMPLEX");
		try {
			driver.findElement(By.id(loc.getProperty("buildersstructuredesc"))).click();
		} catch (Exception e) {
			System.out.print("\nStructure Type 'Apartment Complex' is working correctly");
		}
		structure.selectByValue("CONDOMINIUMCOMPLEX");
		try {
			driver.findElement(By.id(loc.getProperty("buildersstructuredesc"))).click();
		} catch (Exception e) {
			System.out.print("\nStructure Type 'Condominium Complex' is working correctly");
		}
		structure.selectByValue("SHOPPINGCENTER");
		try {
			driver.findElement(By.id(loc.getProperty("buildersstructuredesc"))).click();
		} catch (Exception e) {
			System.out.print("\nStructure Type 'Shopping Center' is working correctly");
		}
		structure.selectByValue("STRIPMALL");
		try {
			driver.findElement(By.id(loc.getProperty("buildersstructuredesc"))).click();
		} catch (Exception e) {
			System.out.print("\nStructure Type 'Strip Mall' is working correctly");
		}
		structure.selectByValue("MEDICALFACILITY");
		try {
			driver.findElement(By.id(loc.getProperty("buildersstructuredesc"))).click();
		} catch (Exception e) {
			System.out.print("\nStructure Type 'Medical Facility' is working correctly");
		}
		structure.selectByValue("MODULARHOME");
		try {
			driver.findElement(By.id(loc.getProperty("buildersstructuredesc"))).click();
		} catch (Exception e) {
			System.out.print("\nStructure Type 'Modular or Pre-Fabricated Home' is working correctly");
		}
		structure.selectByValue("OTHER");
		try {
			driver.findElement(By.id(loc.getProperty("buildersstructuredesc"))).click();
		} catch (Exception e) {
			Assert.fail("WHEN STRUCTURE TYPE IS 'OTHER', DESCRIPTION FIELD SHOULD BE DISPLAYED");
		}
		structure.selectByValue("");
		driver.findElement(By.id(loc.getProperty("builderssquarefootage"))).click();
		if(driver.findElement(By.id(loc.getProperty("builderssquarefootage"))).getAttribute("value").equals("")) {
			System.out.print("\nTotal Square Footage field is blank by default as expected");
		}
		else {
			Assert.fail("EXPECTED TOTAL SQUARE FOOTAGE FIELD TO BE BLANK BY DEFAULT");
		}
		driver.findElement(By.id(loc.getProperty("buildersnumberofstories"))).click();
		if(!driver.findElement(By.id(loc.getProperty("buildersnumberofstories"))).getAttribute("childElementCount").equals("5")) {
			Assert.fail("EXPECTED NUMBER OF STORIES DROPDOWN TO ONLY HAVE 5 OPTIONS AVAILABLE");
		}
		if(driver.findElement(By.id(loc.getProperty("buildersnumberofstories"))).getAttribute("value").equals("")) {
			System.out.print("\nNumber of Stories dropdown is defaulted to blank as expected");
		}
		driver.findElement(By.id(loc.getProperty("buildersnumberofstories"))).sendKeys("1");
		driver.findElement(By.id(loc.getProperty("builderssquarefootage"))).click();
		Assert.assertTrue(driver.findElement(By.id(loc.getProperty("buildersnumberofstories"))).getAttribute("value").equals("1"));
		driver.findElement(By.id(loc.getProperty("buildersnumberofstories"))).sendKeys("2");
		driver.findElement(By.id(loc.getProperty("builderssquarefootage"))).click();
		Assert.assertTrue(driver.findElement(By.id(loc.getProperty("buildersnumberofstories"))).getAttribute("value").equals("2"));
		driver.findElement(By.id(loc.getProperty("buildersnumberofstories"))).sendKeys("3");
		driver.findElement(By.id(loc.getProperty("builderssquarefootage"))).click();
		Assert.assertTrue(driver.findElement(By.id(loc.getProperty("buildersnumberofstories"))).getAttribute("value").equals("3"));
		driver.findElement(By.id(loc.getProperty("buildersnumberofstories"))).sendKeys("4");
		driver.findElement(By.id(loc.getProperty("builderssquarefootage"))).click();
		Assert.assertTrue(driver.findElement(By.id(loc.getProperty("buildersnumberofstories"))).getAttribute("value").equals("4"));
		if(!driver.findElement(By.id(loc.getProperty("buildersconstructiontype"))).getAttribute("childElementCount").equals("8")) {
			Assert.fail("EXPECTED CONSTRUCTION TYPE DROPDOWN TO ONLY HAVE 8 OPTIONS AVAILABLE");
		}
		if(driver.findElement(By.id(loc.getProperty("buildersconstructiontype"))).getAttribute("value").equals("")) {
			System.out.print("\nConstruction Type dropdown is defaulted to blank as expected");
		}
		else {
			Assert.fail("EXPECTED CONSTRUCTION TYPE DROPDOWN TO BE DEFAULTED TO BLANK");
		}
		Select constructiontype = new Select(driver.findElement(By.id(loc.getProperty("buildersconstructiontype"))));
		constructiontype.selectByValue("F");
		try {
			driver.findElement(By.id(loc.getProperty("buildersstructuredesc"))).click();
		} catch (Exception e) {
			System.out.print("\nConstruction Type 'Frame' is working correctly");
		}
		constructiontype.selectByValue("J");
		try {
			driver.findElement(By.id(loc.getProperty("buildersstructuredesc"))).click();
		} catch (Exception e) {
			System.out.print("\nConstruction Type 'Joisted Masonry' is working correctly");
		}
		constructiontype.selectByValue("N");
		try {
			driver.findElement(By.id(loc.getProperty("buildersstructuredesc"))).click();
		} catch (Exception e) {
			System.out.print("\nConstruction Type 'Non-Combustible' is working correctly");
		}
		constructiontype.selectByValue("B");
		try {
			driver.findElement(By.id(loc.getProperty("buildersstructuredesc"))).click();
		} catch (Exception e) {
			System.out.print("\nConstruction Type 'Masonry Non-Combustible' is working correctly");
		}
		constructiontype.selectByValue("M");
		try {
			driver.findElement(By.id(loc.getProperty("buildersstructuredesc"))).click();
		} catch (Exception e) {
			System.out.print("\nConstruction Type 'Modified Fire Resistive' is working correctly");
		}
		constructiontype.selectByValue("R");
		try {
			driver.findElement(By.id(loc.getProperty("buildersstructuredesc"))).click();
		} catch (Exception e) {
			System.out.print("\nConstruction Type 'Fire Resistive' is working correctly");
		}
		constructiontype.selectByValue("O");
		driver.findElement(By.id(loc.getProperty("builderssquarefootage"))).click();
		try {
			driver.findElement(By.id(loc.getProperty("buildersconstructiondesc"))).click();
		} catch (Exception e) {
			Assert.fail("WHEN CONSTRUCTION TYPE IS 'OTHER', DESCRIPTION FIELD SHOULD BE DISPLAYED");
		}
		structure.selectByValue("");
		System.out.print("\nConstruction Type dropdown is working correctly");
	}
	
	@Test(dataProvider = "NewConstructionData", description = "T18791	TC03 - Builders Risk - General - Prior Insurance Information", enabled = true, priority = 3)
	public void buildersRiskGeneral3(String newquotestate, String newquotepolicytype, String newquoteaddress, String newquoteaddress2, 
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
			throws InterruptedException, ParseException{
		driver.findElement(By.xpath(loc.getProperty("buildersaddpriorinsurance"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(loc.getProperty("builderspriorinscarrier"))).click();
		driver.findElement(By.xpath(loc.getProperty("builderspriorinscarrier"))).sendKeys("TEST");
		driver.findElement(By.id(loc.getProperty("buildersconstructiontype"))).click();
	    driver.findElement(By.id(loc.getProperty("builderspriorinsenddateSTAGE"))).click();
	    driver.findElement(By.id(loc.getProperty("builderspriorinsenddateSTAGE"))).clear();
	    driver.findElement(By.id(loc.getProperty("builderspriorinsenddateSTAGE"))).sendKeys("01/01/1899");
	    boolean checker = true;
	    try {
	    	driver.findElement(By.xpath(loc.getProperty("builderspriorinscarrier"))).click();
			driver.findElement(By.xpath(loc.getProperty("builderspriorinscarrier"))).sendKeys("TEST");
		} catch (Exception e) {
			System.out.print("\nPrior Expiration Date super old date validation is working successfully");
			checker = false;
		}
	    if(checker==true) {
	    	Assert.fail("NO VALIDATION DISPLAYED WHEN EXPIRATION DATE WAS SET WAY FAR BACK");
	    }
	    checker = true;
	    try {
			driver.findElement(By.id(loc.getProperty("builderspriorinsenddateSTAGE"))).click();
			driver.findElement(By.id(loc.getProperty("builderspriorinsenddateSTAGE"))).clear();
			driver.findElement(By.id(loc.getProperty("builderspriorinsenddateSTAGE"))).sendKeys("01/01/2199");
			driver.findElement(By.xpath(loc.getProperty("builderspriorinscarrier"))).click();
			driver.findElement(By.xpath(loc.getProperty("builderspriorinscarrier"))).sendKeys("TEST");
		} catch (Exception e1) {
			System.out.print("\nPrior Expiration Date far future date validation is working successfully");
			checker = false;
		}
	    if(checker==true) {
	    	Assert.fail("NO VALIDATION DISPLAYED WHEN EXPIRATION DATE WAS SET WAY IN THE FUTURE");
	    }
	    checker = true;
	    try {
			driver.findElement(By.id(loc.getProperty("builderspriorinsenddateSTAGE"))).click();
			driver.findElement(By.id(loc.getProperty("builderspriorinsenddateSTAGE"))).clear();
			driver.findElement(By.id(loc.getProperty("builderspriorinsenddateSTAGE"))).sendKeys("13/01/2019");
			driver.findElement(By.xpath(loc.getProperty("builderspriorinscarrier"))).click();
			driver.findElement(By.xpath(loc.getProperty("builderspriorinscarrier"))).sendKeys("TEST");
		} catch (Exception e1) {
			System.out.print("\nPrior Expiration Date invalid month validation is working successfully");
			checker = false;
		}
	    if(checker==true) {
	    	Assert.fail("NO VALIDATION DISPLAYED WHEN AN INVALID MONTH WAS ENTERED");
	    }
	    checker = true;
	    try {
			driver.findElement(By.id(loc.getProperty("builderspriorinsenddateSTAGE"))).click();
			driver.findElement(By.id(loc.getProperty("builderspriorinsenddateSTAGE"))).clear();
			driver.findElement(By.id(loc.getProperty("builderspriorinsenddateSTAGE"))).sendKeys("11/31/2019");
			driver.findElement(By.xpath(loc.getProperty("builderspriorinscarrier"))).click();
			driver.findElement(By.xpath(loc.getProperty("builderspriorinscarrier"))).sendKeys("TEST");
		} catch (Exception e1) {
			System.out.print("\nPrior Expiration Date invalid date validation is working successfully");
			checker = false;
		}
	    if(checker==true) {
	    	Assert.fail("NO VALIDATION DISPLAYED WHEN AN INVALID DATE WAS ENTERED");
	    }
	    try {
			driver.findElement(By.id(loc.getProperty("builderspriorinsenddateSTAGE"))).click();
			driver.findElement(By.id(loc.getProperty("builderspriorinsenddateSTAGE"))).clear();
			driver.findElement(By.id(loc.getProperty("builderspriorinsenddateSTAGE"))).sendKeys("01/21/2024");
			driver.findElement(By.xpath(loc.getProperty("builderspriorinscarrier"))).click();
			driver.findElement(By.xpath(loc.getProperty("builderspriorinscarrier"))).sendKeys("TEST");
		} catch (Exception e1) {
			Assert.fail("RECIEVED ERROR WHEN TRYING TO CLICK ON PRIOR EXPIRING PREMIUM: ");
			e1.printStackTrace();
		}
		driver.findElement(By.id(loc.getProperty("builderspriorinspremium"))).click();
		if(!driver.findElement(By.id(loc.getProperty("builderspriorinspremium"))).getAttribute("minvalue").equals("1")) {
			Assert.fail("EXPIRING PREMIUM MINIMUM SHOULD BE 1 BUT FOUND " + driver.findElement(By.id(loc.getProperty("builderspriorinspremium"))).getAttribute("minvalue"));
		}
		if(!driver.findElement(By.id(loc.getProperty("builderspriorinspremium"))).getAttribute("maxvalue").equals("1000000")) {
			Assert.fail("EXPIRING PREMIUM MAXIMUM SHOULD BE 1000000 BUT FOUND " + driver.findElement(By.id(loc.getProperty("builderspriorinspremium"))).getAttribute("maxvalue"));
		}
		driver.findElement(By.id(loc.getProperty("builderspriorinspremium"))).clear();
		driver.findElement(By.xpath(loc.getProperty("builderdeletepriorinsurance"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("builderdeleteclose"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("builderdeletepriorinsurance"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("builderconfirmdelete"))).click();
		Thread.sleep(2000);
		checker = true;
		try {
			driver.findElement(By.xpath(loc.getProperty("builderspriorinscarrier"))).click();
		} catch (Exception e) {
			checker = false;
			System.out.print("\nBuilders Prior Insurance Information is working successfully");
		}
		if(checker == true) {
			Assert.fail("DELETED PRIOR INSURANCE BUT THE FIELDS WERE STILL DISPLAYING");
		}
		driver.findElement(By.id(loc.getProperty("buildersstructuretype"))).click();
		driver.findElement(By.id(loc.getProperty("buildersstructuretype"))).sendKeys(buildersstructuretype);
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
		driver.findElement(By.xpath(loc.getProperty("buildersaddinterestpage"))).click();
		Action.fluentWait(driver, null, 0);
		try {
			driver.findElement(By.id(loc.getProperty("buildersaddinterestbtn"))).click();
		} catch (Exception e) {
			Assert.fail("WAS NOT ABLE TO PROCEED TO THE ADD INTEREST/INSURED PAGE");
		}
		System.out.print("\nGeneral page is working successfully as expected");
	}
	
}
