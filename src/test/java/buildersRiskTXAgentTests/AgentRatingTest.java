package buildersRiskTXAgentTests;                                                                     // THIS TEST RUNS FOR 1 MINUTES AND 58 SECONDS

import java.io.IOException;
import java.text.ParseException;

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

public class AgentRatingTest extends BuildersRiskBaseClass {
	
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
	
	@Test(dataProvider = "NewConstructionData", description = "Builders Risk Start Quote Walkthrough to Rating", enabled = true, priority = 0)
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
	}
	
	
	@Test(dataProvider = "NewConstructionData", description = "T18810	TC01 - Builders Risk - Rating Header", enabled = true, priority = 2)
	public void buildersRiskRating2(String newquotestate, String newquotepolicytype, String newquoteaddress, String newquoteaddress2, 
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
		if(driver.findElement(By.xpath(loc.getProperty("buildersprintquotebtn"))).getAttribute("href").contains(prop.getProperty("testurl").substring(0, 38))) {
			System.out.print("\nPrint Quote is clickable and has a link\n");
		}
		else {
			Assert.fail("PRINT QUOTE BUTTON IS NOT CLICKABLE");
		}
	}
	
	@Test(description = "T18812	TC03 - Builders Risk - Rating - Coverage", enabled = true, priority = 3)
	public void buildersRiskRating3() throws InterruptedException{

		driver.findElement(By.xpath(loc.getProperty("buildersquoteinfoheader"))).click();
		if(driver.findElement(By.xpath(loc.getProperty("buildersquoteinfoheader"))).getText().equals("Quote Information")) {
			System.out.print("Quote Information header is displaying successfully\n");
		}
		else {
			Assert.fail("QUOTE INFORMATION HEADER IS NOT DISPLAYING CORRECTLY");
		}
		if(driver.findElement(By.xpath(loc.getProperty("builderspremiumfeesheader"))).getText().equals("Premium and Fees")) {
			System.out.print("Premium and Fees header is displaying successfully\n");
		}
		else {
			Assert.fail("PREMIUM AND FEES HEADER IS NOT DISPLAYING CORRECTLY");
		}
		if(driver.findElement(By.xpath(loc.getProperty("buildersratingvariablesheader"))).getText().equals("Rating Variables")) {
			System.out.print("Rating Variables header is displaying successfully\n");
		}
		else {
			Assert.fail("RATING VARIABLES HEADER IS NOT DISPLAYING CORRECTLY");
		}
		Boolean check = true;
		try {
			driver.findElement(By.xpath(loc.getProperty("buildersratingresultheader"))).click();
		} catch (Exception e) {
			check = false;
			System.out.print("Rating Results header is hidden from agents successfully\n");
		}
		if(check==true) {
			Assert.fail("RATING RESULTS HEADER SHOULD BE HIDDEN FOR AGENTS");
		}
		try {
			driver.findElement(By.xpath(loc.getProperty("buildersunderwriterheader"))).click();
		} catch (Exception e) {
			check = true;
			System.out.print("Underwriter header is hidden from agents successfully\n");
		}
		if(check==false) {
			Assert.fail("UNDERWRITER HEADER SHOULD BE HIDDEN FOR AGENTS");
		}
	}
	
	@Test(dataProvider = "NewConstructionData", description = "T18813	TC04 - Builders Risk - Rating - Rating Variables", enabled = false, priority = 4) // HIDDEN FOR AGENTS
	public void buildersRiskRating4(String newquotestate, String newquotepolicytype, String newquoteaddress, String newquoteaddress2, 
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
			throws InterruptedException{
		
		if(driver.findElement(By.xpath(loc.getProperty("buildersratingcounty"))).getText().equals(builderscounty)) {
			System.out.print("Builder's County was saved and displays successfully\n");
		}
		else {
			Assert.fail("BUILDER'S COUNTY IS NOT DISPLAYING CORRECTLY. EXPECTED: " + builderscounty + " BUT FOUND: " + driver.findElement(By.xpath(loc.getProperty("buildersratingcounty"))).getText());
		}
		if(driver.findElement(By.xpath(loc.getProperty("buildersratingclass"))).getText().equals(buildersprotectionclass)) {
			System.out.print("Builder's Protection Class was saved and displays successfully\n");
		}
		else {
			Assert.fail("BUILDER'S PROTECTION CLASS IS NOT DISPLAYING CORRECTLY. EXPECTED: " + buildersprotectionclass + " BUT FOUND: " + driver.findElement(By.xpath(loc.getProperty("buildersratingclass"))).getText());
		}
		if(driver.findElement(By.xpath(loc.getProperty("buildersratingwind"))).getText().equals(builderswindhaildeductible)) {
			System.out.print("Builder's Wind/Hail Deductible was saved and displays successfully\n");
		}
		else {
			Assert.fail("BUILDER'S WIND/HAIL DEDUCTIBLE IS NOT DISPLAYING CORRECTLY. EXPECTED: " + builderswindhaildeductible + " BUT FOUND: " + driver.findElement(By.xpath(loc.getProperty("buildersratingwind"))).getText());
		}
	}
	
	@Test(description = "T18814	TC05 - Builders Risk - Rating - Premium and Fees", enabled = true, priority = 5)
	public void buildersRiskRating5() throws InterruptedException, ParseException{
		if(driver.findElement(By.xpath(loc.getProperty("buildersratingpremium"))).getText().contains("$") && driver.findElement(By.xpath(loc.getProperty("buildersratingpremium"))).getText().contains(".")) {
			System.out.print("Total Coverage Premium is displaying correctly and in currency format\n");
		}
		else {
			Assert.fail("TOTAL COVERAGE PREMIUM IS NOT DISPLAYING CORRECTLY");
		}
		if(driver.findElement(By.xpath(loc.getProperty("builderstotalpremium"))).getText().contains("$") && driver.findElement(By.xpath(loc.getProperty("builderstotalpremium"))).getText().contains(".")) {
			System.out.print("Total Premium, Taxes, and Fees is displaying correctly and in currency format\n");
		}
		else {
			Assert.fail("TOTAL PREMIUM, TAXES, AND FEES IS NOT DISPLAYING CORRECTLY");
		}
	}
	
	@Test(description = "T18815	TC06 - Builders Risk - Rating - Underwriter", enabled = true, priority = 6)
	public void buildersRiskRating6() throws InterruptedException{
		Boolean x = true;
		try {
			driver.findElement(By.xpath(loc.getProperty("buildersdisplayflowbtn"))).click();
		} catch (Exception e) {
			System.out.print("Display Flow is hidden for agents as expected\n");
			x = false;
		}
		if(x==true) {
			Assert.fail("DISPLAY FLOW BUTTON SHOULD BE HIDDEN FOR AGENTS");
		}
		driver.findElement(By.xpath(loc.getProperty("buildersgeneralsbtn"))).click();
		Action.fluentWait(driver, null, 0);
		System.out.print("Rating Page is working correctly as expected\n");
	}
	
}
