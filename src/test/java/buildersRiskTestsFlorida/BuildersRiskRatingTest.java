package buildersRiskTestsFlorida;														// THIS TEST RUNS FOR 1 MINUTES AND 18 SECONDS

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

public class BuildersRiskRatingTest extends BuildersRiskBaseClass {
	
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
	
	
	@Test(dataProvider = "NewConstructionData", description = "Builders Risk Start Quote Walkthrough to Rating", enabled = true, priority = 0)
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
			throws InterruptedException {

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
			driver.findElement(By.id(loc.getProperty("builderscoastdistance"))).clear();
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
			driver.findElement(By.id(loc.getProperty("builderssinkholedistance"))).clear();
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
	}
	
	
	@Test(dataProvider = "NewConstructionData", description = "T18810	TC01 - Builders Risk - Rating Header", enabled = true, priority = 2)
	public void buildersRiskRating2(String newquotestate, String newquotepolicytype,
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
		if(driver.findElement(By.xpath(loc.getProperty("buildersratingresultheader"))).getText().equals("Rating Results")) {
			System.out.print("Rating Results header is displaying successfully\n");
		}
		else {
			Assert.fail("RATING RESULTS HEADER IS NOT DISPLAYING CORRECTLY");
		}
		if(driver.findElement(By.xpath(loc.getProperty("buildersunderwriterheader"))).getText().equals("Underwriter")) {
			System.out.print("Underwriter header is displaying successfully\n");
		}
		else {
			Assert.fail("UNDERWRITER HEADER IS NOT DISPLAYING CORRECTLY");
		}
	}
	
	@Test(dataProvider = "NewConstructionData", description = "T18813	TC04 - Builders Risk - Rating - Rating Variables", enabled = true, priority = 4)
	public void buildersRiskRating4(String newquotestate, String newquotepolicytype,
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
		
		if(driver.findElement(By.xpath(loc.getProperty("buildersratingcounty"))).getText().equals(builderscounty)) {
			System.out.print("Builder's County was saved and displays successfully\n");
		}
		else {
			Assert.fail("BUILDER'S COUNTY IS NOT DISPLAYING CORRECTLY. EXPECTED: " + builderscounty + " BUT FOUND: " + driver.findElement(By.xpath(loc.getProperty("buildersratingcounty"))).getText());
		}
		if(driver.findElement(By.xpath(loc.getProperty("buildersratingterritory"))).getText().equals(buildersterritory)) {
			System.out.print("Builder's Territory was saved and displays successfully\n");
		}
		else {
			Assert.fail("BUILDER'S TERRITORY IS NOT DISPLAYING CORRECTLY. EXPECTED: " + buildersterritory + " BUT FOUND: " + driver.findElement(By.xpath(loc.getProperty("buildersratingterritory"))).getText());
		}
		if(driver.findElement(By.xpath(loc.getProperty("buildersratingcoast"))).getText().equals(builderscoastdistance)) {
			System.out.print("Builder's Distance From Coast was saved and displays successfully\n");
		}
		else {
			Assert.fail("BUILDER'S DISTANCE FROM COAST IS NOT DISPLAYING CORRECTLY. EXPECTED: " + builderscoastdistance + " BUT FOUND: " + driver.findElement(By.xpath(loc.getProperty("buildersratingcoast"))).getText());
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
//		if(driver.findElement(By.xpath(loc.getProperty("buildersflemergencyfund"))).getText().contains("$") && driver.findElement(By.xpath(loc.getProperty("buildersflemergencyfund"))).getText().contains(".")) {
//			System.out.print("FL Emergency Trust Fund is displaying correctly and in currency format\n");
//		}
//		else {
//			Assert.fail("FL EMERGENCY TRUST FUND IS NOT DISPLAYING CORRECTLY");
//		}
		if(driver.findElement(By.xpath(loc.getProperty("buildersflfiremarshal"))).getText().contains("$") && driver.findElement(By.xpath(loc.getProperty("buildersflfiremarshal"))).getText().contains(".")) {
			System.out.print("FL Fire Marshall Fee is displaying correctly and in currency format\n");
		}
		else {
			Assert.fail("FL FIRE MARSHALL FEE IS NOT DISPLAYING CORRECTLY");
		}
		Date date1 = new SimpleDateFormat("MM/dd/yyyy").parse(driver.findElement(By.xpath(loc.getProperty("effectivedate"))).getAttribute("value"));
		Date date2 = new SimpleDateFormat("MM/dd/yyyy").parse("09/30/2025");
		if(date1.before(date2)) {
			System.out.print("FIGA 2023 A SHOULD be displayed\n");
			if(driver.findElement(By.xpath(loc.getProperty("buildersFIGA2023A"))).getText().contains("$") && driver.findElement(By.xpath(loc.getProperty("buildersFIGA2023A"))).getText().contains(".")) {
				System.out.print("FIGA 2023 A Fee is correctly displayed in currency format\n");
			}
			else {
				Assert.fail("FIGA 2023 A FEE IS NOT DISPLAYING CORRECTLY");
			}
		}
		else {
			Boolean x = true;
			try {
				driver.findElement(By.xpath(loc.getProperty("buildersFIGA2023A"))).click();
			} catch (Exception e) {
				x = false;
				System.out.print("FIGA 2023 A is working as expected\n");
			}
			if(x==true) {
				Assert.fail("FIGA 2023 A SHOULD NOT BE DISPLAYED SINCE THE EFFECTIVE DATE IS PAST 09/30/2025");
			}
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
			if(driver.findElement(By.xpath(loc.getProperty("displayflowhider"))).getAttribute("value").equalsIgnoreCase("N")) {
				x = false;
				System.out.print("Display Flow is hidden by default as expected\n");
			}
			else {
				Assert.fail("DISPLAY FLOW BUTTON IS HIDDEN BUT THE INPUT IS STILL SAYING IT IS VISIBLE");
			}
			
		}
		if(x==true) {
			Assert.fail("DISPLAY FLOW BUTTON SHOULD BE HIDDEN BY DEFAULT");
		}
		driver.findElement(By.xpath(loc.getProperty("buildersdisplayflowyes"))).click();
		if(driver.findElement(By.xpath(loc.getProperty("displayflowhider"))).getAttribute("value").equalsIgnoreCase("Y")) {
			System.out.print("Display Flow is now visible when 'Yes' is clicked as expected\n");
		}
		else {
			Assert.fail("DISPLAY FLOW BUTTON IS VISIBLE BUT THE INPUT IS STILL SAYING IT IS HIDDEN");
		}
		driver.findElement(By.xpath(loc.getProperty("buildersdisplayflowno"))).click();
		driver.findElement(By.cssSelector(loc.getProperty("buildersgeneralbtn"))).click();
	}
	
}
