package buildersRiskTestsTexas;                                                                     // THIS TEST RUNS FOR 1 MINUTES AND 28 SECONDS

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

public class BuildersRiskCoverageTest extends BuildersRiskBaseClass {

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
	
	@Test(dataProvider = "NewConstructionData", description = "Builders Risk Start Quote Walkthrough to Coverages", enabled = true, priority = 0)
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
	}
	
	
	@Test(dataProvider = "NewConstructionData", description = "C9093	TC01 - Builders Risk - Coverage - Global Header", enabled = true, priority = 1)
	public void buildersRiskCoverage(String newquotestate, String newquotepolicytype, String newquoteaddress, String newquoteaddress2, 
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
			System.out.print("Effective date is not editable at this point as expected\n");
		}
		System.out.print("Effective Date: " + driver.findElement(By.xpath(loc.getProperty("effectivedate"))).getAttribute("value"));
	}
	
	@Test(dataProvider = "NewConstructionData", description = "C9094	TC02 - Builders Risk - Coverage - Applicant Information", enabled = true, priority = 2)
	public void buildersRiskCoverage2(String newquotestate, String newquotepolicytype, String newquoteaddress, String newquoteaddress2, 
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
		
		driver.findElement(By.id(loc.getProperty("buildersapplicantphone"))).click();
		driver.findElement(By.id(loc.getProperty("buildersapplicantphone"))).sendKeys("TEST@");
		if(!driver.findElement(By.id(loc.getProperty("buildersapplicantphone"))).getText().equals("")) {
			Assert.fail("APPLICANT PHONE IS TAKING TEXT WHEN IT SHOULD ONLY TAKE NUMBERS");
		}
		driver.findElement(By.xpath(loc.getProperty("buildersapplicantphonetooltip"))).click();
		if(!driver.findElement(By.xpath(loc.getProperty("buildersapplicantphonetooltip"))).getAttribute("data-original-title").equals("Represents Phone Number of Insured. Format as ###-###-####")) {
			Assert.fail("PHONE NUMBER TOOLTIP IS NOT MATCHING EXPECTED TEXT");
		}
		System.out.print("\nPHONE NUMBER TOOLTIP IS WORKING AS EXPECTED");
		driver.findElement(By.cssSelector(loc.getProperty("buildersratingbtn"))).click();
		Action.fluentWait(driver, null, 0);
		try {
			driver.findElement(By.cssSelector(loc.getProperty("buildersratingbtn"))).click();
			Action.fluentWait(driver, null, 0);
		} catch (Exception e) {
			if (e.getMessage().contains("Unable to locate element")) {
				Assert.fail("\nPROGRESSED TO RATING WITHOUT ANSWERING QUESTIONS");
			} else {
				Assert.fail(e.getMessage());
			}
		}
		driver.findElement(By.id(loc.getProperty("buildersapplicanttype"))).sendKeys(buildersapplicanttype);
		driver.findElement(By.xpath(loc.getProperty("buildersindividualrdbtn"))).click();
		driver.findElement(By.xpath(loc.getProperty("buildersbusinessrdbtn"))).click();
		if (buildersnametype.equalsIgnoreCase("Business")) {
			driver.findElement(By.xpath(loc.getProperty("buildersbusinessrdbtn"))).click();
			Thread.sleep(500);
			driver.findElement(By.id(loc.getProperty("buildersbusinessname"))).click();
			if(!driver.findElement(By.id(loc.getProperty("buildersbusinessname"))).getAttribute("maxlength").equals("50")) {
		    	Assert.fail("EXPECTED BUSINESS NAME FIELD TO HAVE A MAX LENGTH OF 50");
		    }
			driver.findElement(By.id(loc.getProperty("buildersbusinessname"))).sendKeys(buildersbusinessname);
			driver.findElement(By.id(loc.getProperty("buildersdbaname"))).click();
			if(!driver.findElement(By.id(loc.getProperty("buildersdbaname"))).getAttribute("maxlength").equals("50")) {
		    	Assert.fail("EXPECTED DBA NAME FIELD TO HAVE A MAX LENGTH OF 50");
		    }
			driver.findElement(By.id(loc.getProperty("buildersdbaname"))).sendKeys(buildersdbaname);
			driver.findElement(By.id(loc.getProperty("buildersstructure"))).sendKeys(buildersstructure);
		} else {
			if (buildersnametype.equalsIgnoreCase("Individual")) {
				driver.findElement(By.xpath(loc.getProperty("buildersindividualrdbtn"))).click();
				Thread.sleep(500);
				driver.findElement(By.id(loc.getProperty("buildersfirstname"))).click();
				if(!driver.findElement(By.id(loc.getProperty("buildersfirstname"))).getAttribute("maxlength").equals("35")) {
			    	Assert.fail("EXPECTED FIRST NAME FIELD TO HAVE A MAX LENGTH OF 35");
			    }
				driver.findElement(By.id(loc.getProperty("buildersfirstname"))).sendKeys(buildersfirstname);
				driver.findElement(By.id(loc.getProperty("buildersmiddlename"))).click();
				if(!driver.findElement(By.id(loc.getProperty("buildersmiddlename"))).getAttribute("maxlength").equals("15")) {
			    	Assert.fail("EXPECTED MIDDLE NAME FIELD TO HAVE A MAX LENGTH OF 15");
			    }
				driver.findElement(By.id(loc.getProperty("buildersmiddlename"))).sendKeys(buildersmiddlename);
				driver.findElement(By.id(loc.getProperty("builderslastname"))).click();
				if(!driver.findElement(By.id(loc.getProperty("builderslastname"))).getAttribute("maxlength").equals("50")) {
			    	Assert.fail("EXPECTED LAST NAME FIELD TO HAVE A MAX LENGTH OF 50");
			    }
				driver.findElement(By.id(loc.getProperty("builderslastname"))).sendKeys(builderslastname);
				driver.findElement(By.id(loc.getProperty("builderssuffixname"))).click();
				if(!driver.findElement(By.id(loc.getProperty("builderssuffixname"))).getAttribute("maxlength").equals("10")) {
			    	Assert.fail("EXPECTED SUFFIX NAME FIELD TO HAVE A MAX LENGTH OF 10");
			    }
				driver.findElement(By.id(loc.getProperty("builderssuffixname"))).sendKeys(builderssuffixname);
			} else {
				Assert.fail("INVALID BUSINESS NAME TYPE: ONLY BUSINESS OR INDIVIDUAL AVAILABLE");
				driver.quit();
			}
		}
	}
		
	@Test(dataProvider = "NewConstructionData", description = "C9095	TC03 - Builders Risk - Coverage - Applicant Mailing Address", enabled = true, priority = 3)
	public void buildersRiskCoverage3(String newquotestate, String newquotepolicytype, String newquoteaddress, String newquoteaddress2, 
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
		
		driver.findElement(By.xpath(loc.getProperty("buildersaddresstype"))).click();
		driver.findElement(By.xpath(loc.getProperty("buildersaddresstype"))).sendKeys("I");
		driver.findElement(By.xpath(loc.getProperty("buildersaddresstype"))).click();
		driver.findElement(By.id(loc.getProperty("buildersmailingaddress"))).click();
		try {
			driver.findElement(By.xpath(loc.getProperty("builderscountryname"))).click();
		} catch (Exception e) {
			Assert.fail("EXPECTED TO FIND COUNTRY NAME FIELD IF ADDRESS TYPE IS INTERNATIONAL");
		}
		System.out.print("\nApplicant mailing address type is working as expected");
		driver.findElement(By.xpath(loc.getProperty("buildersaddresstype"))).click();
		driver.findElement(By.xpath(loc.getProperty("buildersaddresstype"))).sendKeys("U");
		driver.findElement(By.xpath(loc.getProperty("buildersaddresstype"))).click();
		driver.findElement(By.id(loc.getProperty("buildersmailingaddress"))).click();
		driver.findElement(By.id(loc.getProperty("buildersmailingaddress"))).sendKeys(buildersmailingaddress);
		driver.findElement(By.id(loc.getProperty("buildersmailingaddress2"))).click();
		driver.findElement(By.id(loc.getProperty("buildersmailingaddress2"))).sendKeys(buildersmailingaddress2);
		driver.findElement(By.id(loc.getProperty("buildersmailingcity"))).click();
		driver.findElement(By.id(loc.getProperty("buildersmailingcity"))).sendKeys(buildersmailingcity);
		driver.findElement(By.id(loc.getProperty("buildersmailingstate"))).click();
		driver.findElement(By.id(loc.getProperty("buildersmailingstate"))).sendKeys(buildersmailingstate);
		driver.findElement(By.id(loc.getProperty("buildersmailingzip"))).click();
		if(!driver.findElement(By.id(loc.getProperty("buildersmailingzip"))).getAttribute("maxlength").equals("5")) {
	    	Assert.fail("EXPECTED ZIP CODE FIELD TO HAVE A MAX LENGTH OF 5");
	    }
		driver.findElement(By.id(loc.getProperty("buildersmailingzip"))).sendKeys(buildersmailingzip);
		driver.findElement(By.id(loc.getProperty("buildersmailingzip4"))).click();
		if(!driver.findElement(By.id(loc.getProperty("buildersmailingzip4"))).getAttribute("maxlength").equals("4")) {
	    	Assert.fail("EXPECTED ZIP4 FIELD TO HAVE A MAX LENGTH OF 4");
	    }
		driver.findElement(By.id(loc.getProperty("buildersmailingzip4"))).sendKeys(buildersmailingzip4);
		Thread.sleep(5000);
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			System.out.print("\nNo alert shown for address");
		}
	}
	
	@Test(dataProvider = "NewConstructionData", description = "T18806	TC04 - Builders Risk - Coverage - Building and Location Information", enabled = true, priority = 4)
	public void buildersRiskCoverage4(String newquotestate, String newquotepolicytype, String newquoteaddress, String newquoteaddress2, 
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
		
		driver.findElement(By.id(loc.getProperty("builderslocationaddress"))).click();
		driver.findElement(By.id(loc.getProperty("builderslocationaddress2"))).click();
		driver.findElement(By.id(loc.getProperty("builderslocationcity"))).click();
		driver.findElement(By.id(loc.getProperty("builderslocationstate"))).click();
		driver.findElement(By.id(loc.getProperty("builderslocationzip"))).click();
		if(!driver.findElement(By.id(loc.getProperty("builderslocationzip"))).getAttribute("maxlength").equals("5")) {
	    	Assert.fail("EXPECTED ZIP CODE FIELD TO HAVE A MAX LENGTH OF 5");
	    }
		driver.findElement(By.id(loc.getProperty("builderslocationzip4"))).click();
		if(!driver.findElement(By.id(loc.getProperty("builderslocationzip4"))).getAttribute("maxlength").equals("4")) {
	    	Assert.fail("EXPECTED ZIP4 FIELD TO HAVE A MAX LENGTH OF 4");
	    }
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
		System.out.print("\nLatitude: " + driver.findElement(By.xpath(loc.getProperty("builderslatitude"))).getText());
		System.out.print("\nLongitude: " + driver.findElement(By.xpath(loc.getProperty("builderslongitude"))).getText());
		driver.findElement(By.id(loc.getProperty("builderswindpool"))).click();
		driver.findElement(By.id(loc.getProperty("builderswindpool"))).sendKeys(builderswindpool);
	}
	
	@Test(dataProvider = "NewConstructionData", description = "T18807	TC05 - Builders Risk - Coverage - Protection Information", enabled = true, priority = 5)
	public void buildersRiskCoverage5(String newquotestate, String newquotepolicytype, String newquoteaddress, String newquoteaddress2, 
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
		
		driver.findElement(By.id(loc.getProperty("buildersprotectionclass"))).click();
		driver.findElement(By.id(loc.getProperty("buildersprotectionclass"))).sendKeys(buildersprotectionclass);
		driver.findElement(By.id(loc.getProperty("buildersfirestation"))).click();
		driver.findElement(By.id(loc.getProperty("buildersfirestation"))).sendKeys(buildersfirestation);
		driver.findElement(By.id(loc.getProperty("buildersfirehydrant"))).click();
		driver.findElement(By.id(loc.getProperty("buildersfirehydrant"))).sendKeys(buildersfirehydrant);
		driver.findElement(By.id(loc.getProperty("buildersfirehydrant"))).click();
		if(driver.findElement(By.id(loc.getProperty("buildersprotectionclass"))).getAttribute("childElementCount").equals("11")) {
			System.out.print("\nBuilder's Protection Class dropdown is displaying the correct values");
		}
		else{
			Assert.fail("BUILDERS PROTECTION CLASS SHOULD CONTAIN A DROPDOWN WITH NUMBERS 1-10");
		}
		if(driver.findElement(By.id(loc.getProperty("buildersfirehydrant"))).getAttribute("childElementCount").equals("3")) {
			System.out.print("\nBuilder's Fire Hydrant Distance dropdown is displaying the correct values");
		}
		else{
			Assert.fail("BUILDERS FIRE HYDRANT DISTANCE SHOULD CONTAIN A DROPDOWN WITH NUMBERS ONLY 2 OPTIONS");
		}
	}
	
	@Test(dataProvider = "NewConstructionData", description = "T18808	TC06 - Builders Risk - Coverage - Limits/Deductibles", enabled = true, priority = 6)
	public void buildersRiskCoverage6(String newquotestate, String newquotepolicytype, String newquoteaddress, String newquoteaddress2, 
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
		
		driver.findElement(By.id(loc.getProperty("builderscompletedvalue"))).click();
		if(!driver.findElement(By.id(loc.getProperty("builderscompletedvalue"))).getAttribute("minvalue").equals("10000")) {
	    	Assert.fail("EXPECTED COMPLETED VALUE LIMIT FIELD TO HAVE A MIN VALUE OF 10000");
	    }
		if(!driver.findElement(By.id(loc.getProperty("builderscompletedvalue"))).getAttribute("maxvalue").equals("20000000")) {
	    	Assert.fail("EXPECTED COMPLETED VALUE LIMIT FIELD TO HAVE A MAX VALUE OF 20000000");
	    }
		driver.findElement(By.id(loc.getProperty("builderscompletedvalue"))).sendKeys(builderscompletedvalue);
		String aopdeductible = driver.findElement(By.id(loc.getProperty("buildersdeductible"))).getAttribute("innerText");
		if(aopdeductible.contains("$1,000") && aopdeductible.contains("$2,500") && aopdeductible.contains("$5,000") && aopdeductible.contains("$10,000")) {
			System.out.print("\nAOP Deductible dropdown is displaying the correct values");
		}
		else{
			Assert.fail("AOP DEDUCTIBLE SHOULD CONTAIN A DROPDOWN WITH VALUES: '$1,000' '$2,500' '$5,000' '$10,000' ");
		}
		driver.findElement(By.id(loc.getProperty("buildersdeductible"))).click();
		Select aop = new Select(driver.findElement(By.id(loc.getProperty("buildersdeductible"))));
		aop.selectByValue(buildersdeductible);
		driver.findElement(By.id(loc.getProperty("buildersdeductible"))).click();
		String winddeductible = driver.findElement(By.id(loc.getProperty("builderswindhaildeductible"))).getAttribute("innerText");
		String buildertier = driver.findElement(By.xpath(loc.getProperty("builderstier"))).getAttribute("value");
		if(buildertier.equals("DFW") || buildertier.equals("PANHANDLE") || buildertier.equals("REMAINDER")) {
			if(winddeductible.contains("5%") && winddeductible.contains("10%") && !winddeductible.contains("2%") && !winddeductible.contains("Excluded")) {
				System.out.print("\nWind/Hail Deductible dropdown is displaying the correct values");
			}
			else{
				Assert.fail("WIND/HAIL DEDUCTIBLE SHOULD ONLY CONTAIN A DROPDOWN WITH VALUES: '5%' & '10%' ");
			}
		}
		else {
			if(winddeductible.contains("2%") && winddeductible.contains("5%") && winddeductible.contains("10%") && winddeductible.contains("Excluded")) {
				System.out.print("\nWind/Hail Deductible dropdown is displaying the correct values");
			}
			else{
				Assert.fail("WIND/HAIL DEDUCTIBLE SHOULD CONTAIN A DROPDOWN WITH VALUES: '2%' '5%' '10%' 'Excluded' ");
			}
			driver.findElement(By.id(loc.getProperty("builderswindhaildeductible"))).click();
			driver.findElement(By.id(loc.getProperty("builderswindhaildeductible"))).sendKeys("E");
			driver.findElement(By.id(loc.getProperty("builderswindhaildeductible"))).click();
			driver.findElement(By.id(loc.getProperty("buildersdeductible"))).click();
			try {
				driver.findElement(By.xpath(loc.getProperty("builderswindmessage"))).click();
			} catch (Exception e) {
				Assert.fail("IF WIND/HAIL DEDUCTIBLE IS 'Excluded' DROPDOWN MESSAGE SHOULD'VE SHOWN UP");
			}
		}
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
		
	}
	
	@Test(dataProvider = "NewConstructionData", description = "T18809	TC07 - Builders Risk - Coverage - Optional Coverages/Limits", enabled = true, priority = 7)
	public void buildersRiskCoverage7(String newquotestate, String newquotepolicytype, String newquoteaddress, String newquoteaddress2, 
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
		
		String constructionlimit = driver.findElement(By.id(loc.getProperty("buildersconstructioncostlimit"))).getAttribute("innerText");
		if(constructionlimit.contains("5%") && constructionlimit.contains("10%") && constructionlimit.contains("15%") && constructionlimit.contains("20%")) {
			System.out.print("\nConstruction Cost Coverage dropdown is displaying the correct values");
		}
		else{
			Assert.fail("CONSTRUCTION COST COVERAGE SHOULD CONTAIN A DROPDOWN WITH VALUES: '5%' '10%' '15%' '20%' ");
		}
		Select constructioncostlimit = new Select(driver.findElement(By.id(loc.getProperty("buildersconstructioncostlimit"))));
		driver.findElement(By.id(loc.getProperty("buildersconstructioncostlimit"))).click();
		constructioncostlimit.selectByVisibleText(buildersconstructioncostlimit);
		String transitlimit = driver.findElement(By.id(loc.getProperty("builderspropertytransitlimit"))).getAttribute("innerText");
		if(transitlimit.contains("$10,000") && transitlimit.contains("$15,000") && transitlimit.contains("$20,000") && transitlimit.contains("$25,000")) {
			if(driver.findElement(By.id(loc.getProperty("builderspropertytransitlimit"))).getAttribute("childElementCount").equals("4")) {
				System.out.print("\nPropety in Transit dropdown is displaying the correct values");
			}
			else {
				Assert.fail("PROPERTY IN TRANSIT LIMIT SHOULD ONLY HAVE 4 OPTIONS TO CHOOSE FROM");
			}
		}
		else{
			Assert.fail("PROPERTY IN TRANSIT LIMIT SHOULD CONTAIN A DROPDOWN WITH VALUES: '$10,000' '$15,000' '$20,000' '$25,000' ");
		}
		Select propertytransitlimit = new Select(driver.findElement(By.id(loc.getProperty("builderspropertytransitlimit"))));
		driver.findElement(By.id(loc.getProperty("builderspropertytransitlimit"))).click();
		propertytransitlimit.selectByVisibleText(builderspropertytransitlimit);
		String softlimit = driver.findElement(By.id(loc.getProperty("builderssoftcostlimit"))).getAttribute("innerText");
		if(softlimit.contains("$10,000") && softlimit.contains("$15,000") && softlimit.contains("$20,000") && softlimit.contains("$5,000")) {
			if(driver.findElement(By.id(loc.getProperty("builderssoftcostlimit"))).getAttribute("childElementCount").equals("4")) {
				System.out.print("\nSoft Cost Coverage dropdown is displaying the correct values\n");
			}
			else {
				Assert.fail("SOFT COST COVERAGE SHOULD ONLY HAVE 4 OPTIONS TO CHOOSE FROM");
			}
		}
		else{
			Assert.fail("SOFT COST COVERAGE SHOULD CONTAIN A DROPDOWN WITH VALUES: '$5,000' '$10,000' '$15,000' '$20,000' ");
		}
		Select softcostlimit = new Select(driver.findElement(By.id(loc.getProperty("builderssoftcostlimit"))));
		driver.findElement(By.id(loc.getProperty("builderssoftcostlimit"))).click();
		softcostlimit.selectByVisibleText(builderssoftcostlimit);
		driver.findElement(By.xpath(loc.getProperty("buildersterrorism"))).click();
		driver.findElement(By.cssSelector(loc.getProperty("buildersratingbtn"))).click();
		Action.fluentWait(driver, null, 0);
		Boolean checker = true;
		try {
			driver.findElement(By.xpath(loc.getProperty("buildersgeneralsbtn"))).click();
		} catch (Exception e) {
			checker = false;
			System.out.print("\nEmail address is required as expected.");
		}
		if(checker==true) {
			Assert.fail("EXPECTED EMAIL ADDRESS TO BE REQUIRED");
		}
		driver.findElement(By.id(loc.getProperty("buildersapplicantemail"))).click();
		driver.findElement(By.id(loc.getProperty("buildersapplicantemail"))).clear();
		driver.findElement(By.id(loc.getProperty("buildersapplicantemail"))).sendKeys(buildersapplicantemail);
		driver.findElement(By.cssSelector(loc.getProperty("buildersratingbtn"))).click();
		Action.fluentWait(driver, null, 0);
		ReusableMethods.printValidations();
	}
}
