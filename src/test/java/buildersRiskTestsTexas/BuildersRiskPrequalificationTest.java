package buildersRiskTestsTexas;                                                                     // THIS TEST RUNS FOR 1 MINUTES AND 17 SECONDS

import java.io.IOException;

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

public class BuildersRiskPrequalificationTest extends BuildersRiskBaseClass {

	@DataProvider(name = "NewConstructionData")
	public String[][] getData() throws IOException {
		// Get data from Excel
		String path = ".\\src\\main\\resources\\data\\BuilderRiskData.xlsx";
		XLUtility xlutil = new XLUtility(path);

		int totalrows = xlutil.getRowCount("BuildersRiskTexas");
		int totalcols = xlutil.getCellCount("BuildersRiskTexas", 1);

		String loginData[][] = new String[totalrows][totalcols];

		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				loginData[i - 1][j] = xlutil.getCellData("BuildersRiskTexas", i, j);
			}
		}
		return loginData;
	}

	@Test(dataProvider = "NewConstructionData", description = "Builders Risk Start Quote Walkthrough", enabled = true, priority = 0)
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

		ReusableMethods.switchToTXInternal();
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
	}

	@Test(description = "C9078	TC01 - Builders Risk - Prequalification - Global Header", enabled = true)
	public void buildersRiskPrequalificationTest()throws InterruptedException {

		WebElement quoteNumber = driver.findElement(By.xpath(loc.getProperty("quotenumber")));
		if (driver.findElement(By.xpath(loc.getProperty("quotenumber"))).getText().substring(0, 14)
				.equals("Quote Number: ")) {
			System.out.print("Quote Number displayed: " + quoteNumber.getText().substring(14));
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
	}

	@Test(dataProvider = "NewConstructionData", description = "C9079	TC02 - Builders Risk - Prequalification - Sub Header", enabled = true)
	public void buildersRiskPrequalificationTest2(String newquotestate, String newquotepolicytype, String newquoteaddress, String newquoteaddress2, 
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

		if (driver.findElement(By.xpath(loc.getProperty("buildersselectedagent"))).getText().equals("Agency Code ")) {
			if (!driver.findElement(By.xpath(loc.getProperty("agentselected"))).getText()
					.equals("No Agents Found")) {
				Assert.fail("AGENT NOT DEFAULTED TO NONE");
			}
		}
		driver.findElement(By.cssSelector(loc.getProperty("builderscoveragebtn"))).click();
		try {
			driver.findElement(By.cssSelector(loc.getProperty("builderscoveragebtn"))).click();
		} catch (Exception e) {
			Assert.fail("PROGRESSED TO COVERAGES WITH ALL FIELDS BLANK");
		}
		driver.findElement(By.xpath(loc.getProperty("agentlookup"))).click();
		Thread.sleep(1000);
		WebElement agCode = driver.findElement(By.id(loc.getProperty("agentcode")));
		driver.findElement(By.id(loc.getProperty("agentcode"))).click();
		driver.findElement(By.id(loc.getProperty("agentcode"))).sendKeys("1");
		if (driver.findElement(By.xpath(loc.getProperty("noagentfoundTxt"))).getText()
				.equals("No data found for current search")) {
			System.out.print("Agent search is working correctly");
		}
		driver.findElement(By.xpath(loc.getProperty("closebtn"))).click();
		Thread.sleep(500);
		String agentname = driver.findElement(By.id(loc.getProperty("agentselected"))).getText();
		if (!agentname.equals("No Agents Found")) {
			Assert.fail("AGENT SELECTED WHEN NO AGENT WAS FOUND IN SEARCH");
		}
		Thread.sleep(500);
		for (int i = 0; i < 2; i++) {
			int x = 0;
			driver.findElement(By.xpath(loc.getProperty("agentlookup"))).click();
			Thread.sleep(1000);
			driver.findElement(By.id(loc.getProperty("agentcode"))).click();
			driver.findElement(By.id(loc.getProperty("agentcode"))).sendKeys(agentcode);
			new Actions(driver).moveToElement(agCode).keyDown(Keys.SHIFT).click().keyUp(Keys.SHIFT).build().perform();
			Thread.sleep(2000);
			try {
				Thread.sleep(1000);driver.findElement(By.xpath(loc.getProperty("firstagentshown"))).click();
			} catch (Exception e) {
				if (driver.findElement(By.xpath(loc.getProperty("noagentfoundTxt"))).getText().equals("No data found for current search")) {
					//If agent is not found with the agent code provided, it will try again 2 times. After multiple tries, it will stop the program!
					if(x==2) {Assert.fail("Agent search for " + agentcode + " has failed TWICE! AGENT NOT FOUND!");}
					else {x++;}
				}
				driver.findElement(By.xpath(loc.getProperty("closebtn"))).click();
			}
		}
		System.out.print("\nAgent Selected: " + driver.findElement(By.id(loc.getProperty("agentselected"))).getText());
		driver.findElement(By.xpath(loc.getProperty("effectivedate"))).click();
		driver.findElement(By.id(loc.getProperty("buildersprojecttype"))).click();
		driver.findElement(By.id(loc.getProperty("buildersprojecttype"))).sendKeys(buildersprojecttype);
		driver.findElement(By.id(loc.getProperty("builderspolicyterm"))).click();
		driver.findElement(By.id(loc.getProperty("builderspolicyterm"))).sendKeys(builderspolicyterm);
		driver.findElement(By.id(loc.getProperty("builderspolicyterm"))).click();
	}

	@Test(dataProvider = "NewConstructionData", description = "TC03 - Builders Risk - Prequalification - Questions", enabled = true)
	public void buildersRiskPrequalificationTest3(String newquotestate, String newquotepolicytype, String newquoteaddress, String newquoteaddress2, 
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

		driver.findElement(By.cssSelector(loc.getProperty("builderscoveragebtn"))).click();
		Action.fluentWait(driver, null, 0);
		try {
			driver.findElement(By.cssSelector(loc.getProperty("builderscoveragebtn"))).click();
		} catch (Exception e) {
			Assert.fail("PROGRESSED TO COVERAGES WITHOUT ANSWERING PREQUALIFICATION QUESTIONS");
		}
		Select checkdropdown = new Select(driver.findElement(By.id(loc.getProperty("buildersprojecttype"))));
		checkdropdown.selectByIndex(0);
		Thread.sleep(5000);
		driver.findElement(By.id(loc.getProperty("buildersprequalificationallno"))).click();
		driver.findElement(By.cssSelector(loc.getProperty("builderscoveragebtn"))).click();
		try {
			driver.findElement(By.cssSelector(loc.getProperty("builderscoveragebtn"))).click();
		} catch (Exception e) {
			Assert.fail("PROGRESSED TO COVERAGES WITHOUT SELECTING PROJECT TYPE");
		}
		driver.findElement(By.id(loc.getProperty("buildersprojecttype"))).click();
		driver.findElement(By.id(loc.getProperty("buildersprojecttype"))).sendKeys(buildersprojecttype);
		checkdropdown = new Select(driver.findElement(By.id(loc.getProperty("builderspolicyterm"))));
		checkdropdown.selectByIndex(0);
		driver.findElement(By.cssSelector(loc.getProperty("builderscoveragebtn"))).click();
		try {
			driver.findElement(By.cssSelector(loc.getProperty("builderscoveragebtn"))).click();
		} catch (Exception e) {
			Assert.fail("PROGRESSED TO COVERAGES WITHOUT SELECTING POLICY TERM");
		}
		driver.findElement(By.id(loc.getProperty("builderspolicyterm"))).click();
		driver.findElement(By.id(loc.getProperty("builderspolicyterm"))).sendKeys(builderspolicyterm);
		driver.findElement(By.cssSelector(loc.getProperty("builderscoveragebtn"))).click();
		Action.fluentWait(driver, null, 0);
		try {
			driver.findElement(By.cssSelector(loc.getProperty("builderscoveragebtn"))).click();
			Action.fluentWait(driver, null, 0);
		} catch (Exception e) {
			if (e.getMessage().contains("Unable to locate element")) {
				driver.findElement(By.xpath(loc.getProperty("buildersprequalificationtab"))).click();
				System.out.print("\nPREQUALIFICATION TAB (UPPER BUTTON) IS CLICKABLE AND WORKS");
			} else {
				Assert.fail(e.getMessage());
			}
		}
		driver.findElement(By.id(loc.getProperty("buildersprojecttype"))).click();
		driver.findElement(By.id(loc.getProperty("buildersprojecttype"))).sendKeys("Non-Structural Renovation");
		driver.findElement(By.id(loc.getProperty("buildersprojecttype"))).click();
		if(driver.findElement(By.id(loc.getProperty("builderspolicyterm"))).getAttribute("innerText").contains("3") && driver.findElement(By.id(loc.getProperty("builderspolicyterm"))).getAttribute("innerText").contains("6") && driver.findElement(By.id(loc.getProperty("builderspolicyterm"))).getAttribute("innerText").contains("9")) {
			System.out.print("\nPolicy Term is working correctly for Non-Structural Renovation");
		}
		else {
			Thread.sleep(500);
//			Assert.fail("POLICY TERM SHOULD DISPLAY 3, 6, 9, & 12 MONTHS FOR NON-STRUCTURAL RENOVATION");  --------------------------------------- COG06226
		}
		driver.findElement(By.cssSelector(loc.getProperty("builderscoveragebtn"))).click();
		try {
			driver.findElement(By.cssSelector(loc.getProperty("builderscoveragebtn"))).click();
		} catch (Exception e) {
			Assert.fail("PROGRESSED TO COVERAGES WITHOUT ANSWERING PREQUALIFICATION QUESTIONS");
		}
		Thread.sleep(5000);
		driver.findElement(By.id(loc.getProperty("buildersprequalificationallyes"))).click();
		try {
			driver.findElement(By.cssSelector(loc.getProperty("builderscoveragebtn"))).click();
		} catch (Exception e) {
			Assert.fail("PROGRESSED TO COVERAGES ANSWERING PREQUALIFICATION QUESTIONS AS YES");
		}
		driver.findElement(By.id(loc.getProperty("buildersprojecttype"))).click();
		driver.findElement(By.id(loc.getProperty("buildersprojecttype"))).sendKeys("Structural Renovation");
		driver.findElement(By.id(loc.getProperty("buildersprequalificationallno"))).click();
		driver.findElement(By.xpath(loc.getProperty("buildersadditionaldetails"))).click();
		if(!driver.findElement(By.xpath(loc.getProperty("buildersadditionaldetails"))).getAttribute("maxlength").equals("250")) {
			Assert.fail("EXPECTED ADDITIONAL INFO TEXTBOX FOR STRUCTURAL RENOVATION TO HAVE A MAX LENGTH OF 250");
		}
		if(driver.findElement(By.id(loc.getProperty("builderspolicyterm"))).getAttribute("innerText").contains("3") && driver.findElement(By.id(loc.getProperty("builderspolicyterm"))).getAttribute("innerText").contains("6") && driver.findElement(By.id(loc.getProperty("builderspolicyterm"))).getAttribute("innerText").contains("9")) {
			System.out.print("\nPolicy Term is working correctly for Structural Renovation");
		}
		else {
			Thread.sleep(500);
//			Assert.fail("POLICY TERM SHOULD DISPLAY 3, 6, 9, & 12 MONTHS FOR STRUCTURAL RENOVATION"); ------------------------------- COG06226
		}
		try {
			driver.findElement(By.cssSelector(loc.getProperty("builderscoveragebtn"))).click();
		} catch (Exception e) {
			Assert.fail("PROGRESSED TO COVERAGES WITHOUT PROVIDING ADDITIONAL DETAILS");
		}
		driver.findElement(By.id(loc.getProperty("buildersasphaltno"))).click();
		driver.findElement(By.id(loc.getProperty("buildersasphaltyes"))).click();
		driver.findElement(By.id(loc.getProperty("buildersconventionalno"))).click();
		driver.findElement(By.id(loc.getProperty("buildersconventionalyes"))).click();
		driver.findElement(By.id(loc.getProperty("builderselectricalno"))).click();
		driver.findElement(By.id(loc.getProperty("builderselectricalyes"))).click();
		driver.findElement(By.id(loc.getProperty("builderspolypipesno"))).click();
		driver.findElement(By.id(loc.getProperty("builderspolypipesyes"))).click();
		driver.findElement(By.id(loc.getProperty("buildershistoricalno"))).click();
		driver.findElement(By.id(loc.getProperty("buildershistoricalyes"))).click();
		driver.findElement(By.id(loc.getProperty("buildersremedationno"))).click();
		driver.findElement(By.id(loc.getProperty("buildersremediationyes"))).click();
		driver.findElement(By.id(loc.getProperty("buildersforeclosuren"))).click();
		driver.findElement(By.id(loc.getProperty("buildersforeclosurey"))).click();
		try {
			driver.findElement(By.cssSelector(loc.getProperty("builderscoveragebtn"))).click();
		} catch (Exception e) {
			Assert.fail("PROGRESSED TO COVERAGES WITH ANSWERING PREQUALIFICATION QUESTIONS AS YES");
		}
		driver.findElement(By.id(loc.getProperty("buildersprojecttype"))).sendKeys(buildersprojecttype);
		if(buildersprojecttype.equalsIgnoreCase("New Construction") || buildersprojecttype.contains("New Construction")) {
			if(driver.findElement(By.id(loc.getProperty("builderspolicyterm"))).getAttribute("innerText").contains("3") && driver.findElement(By.id(loc.getProperty("builderspolicyterm"))).getAttribute("innerText").contains("6") && driver.findElement(By.id(loc.getProperty("builderspolicyterm"))).getAttribute("innerText").contains("9")) {
				Assert.fail("POLICY TERM SHOULD ONLY BE 12 MONTHS FOR NEW CONSTRUCTION");
			}
			else {
				System.out.print("\nPolicy Term is working correctly for New Construction");
			}
		}
		driver.findElement(By.id(loc.getProperty("buildersprequalificationallno"))).click();
		driver.findElement(By.cssSelector(loc.getProperty("builderscoveragebtn"))).click();
		Action.fluentWait(driver, null, 0);
		System.out.print("\nAll questions depending on project type are working correctly\n");
	}
}
