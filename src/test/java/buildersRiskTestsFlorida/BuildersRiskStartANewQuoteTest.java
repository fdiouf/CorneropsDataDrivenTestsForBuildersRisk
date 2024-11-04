package buildersRiskTestsFlorida;														// THIS TEST RUNS FOR 25 SECONDS

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

public class BuildersRiskStartANewQuoteTest extends BuildersRiskBaseClass {
	
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
	
	@Test(dataProvider = "NewConstructionData", description = "C9075	TC01 - Builders Risk - Start a New Quote", enabled = true)
	  public void buildersRiskStartANewQuoteTest(String newquotestate, String newquotepolicytype, String newquoteaddress,
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
		if(!newquotestate.equalsIgnoreCase("Florida")) {
			Assert.fail("RAN FLORIDA TEST WITH TEXAS ADDRESS");
			driver.quit();
		}
		driver.findElement(By.xpath(loc.getProperty("topmenustart"))).click();
		driver.findElement(By.xpath(loc.getProperty("topmenustartanewquote"))).click();
		driver.switchTo().frame(0);
		driver.findElement(By.xpath(loc.getProperty("buildersstartquote"))).click();
		String alertmsg = driver.switchTo().alert().getText();
		if(alertmsg.equals("The complete risk address is required for a quote")) {
			System.out.print("Expected alert shown: " + alertmsg);
			driver.switchTo().alert().accept();
		}
		else {
			Assert.fail("Expected alert NOT shown! Message captured: " + alertmsg);
			driver.quit();
		}
		driver.findElement(By.xpath(loc.getProperty("newquotestate"))).click();
		WebElement dropdownOptions = driver.findElement(By.xpath(loc.getProperty("newquotestate")));
		Select select = new Select(dropdownOptions);
		List<WebElement> allOptions = select.getOptions();
	    for(WebElement x: allOptions) {
	    	if(!x.getText().equals("TEXAS") && !x.getText().equals("FLORIDA")) {
	    		Assert.fail("FOUND THIS IN STATE FIELD: " + x.getText());
	    	}
	    }
	    driver.findElement(By.xpath(loc.getProperty("newquotestate"))).sendKeys(newquotestate);
	    driver.findElement(By.xpath(loc.getProperty("newquotestate"))).click();
	    dropdownOptions = driver.findElement(By.xpath(loc.getProperty("newquotepolicytype")));
		select = new Select(dropdownOptions);
		allOptions = select.getOptions();
	    for(WebElement x: allOptions) {
	    	if(!x.getText().equals("One Shot")) {
	    		Assert.fail("FOUND THIS IN POLICY TYPE FIELD: " + x.getText());
	    	}
	    }
	    String date = driver.findElement(By.xpath(loc.getProperty("newquoteeffectivedate"))).getAttribute("value");
	    String currentDate = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
	    if(date.equals(currentDate)) {
	    	System.out.print("\nCurrent day defaulted: " + date);
	    }
	    else {
	    	Assert.fail("DIFFERENT DEFAULT DATE FOUND: " + date);
	    }
	    if(!driver.findElement(By.xpath(loc.getProperty("newquoteaddress"))).getAttribute("maxlength").equals("50")) {
	    	Assert.fail("EXPECTED ADDRESS FIELD TO HAVE A MAX LENGTH OF 50");
	    }
	    driver.findElement(By.xpath(loc.getProperty("newquoteaddress"))).click();
	    driver.findElement(By.xpath(loc.getProperty("newquoteaddress"))).sendKeys(newquoteaddress);
	    driver.findElement(By.xpath(loc.getProperty("buildersstartquote"))).click();
		alertmsg = driver.switchTo().alert().getText();
		if(alertmsg.equals("The complete risk address is required for a quote")) {
			System.out.print("Expected alert shown: " + alertmsg);
			driver.switchTo().alert().accept();
		}
		else {
			Assert.fail("Expected alert NOT shown! Message captured: " + alertmsg);
			driver.quit();
		}
	    if(!driver.findElement(By.xpath(loc.getProperty("newquoteaddress2"))).getAttribute("maxlength").equals("50")) {
	    	Assert.fail("EXPECTED EXT ADDRESS FIELD TO HAVE A MAX LENGTH OF 50");
	    }
	    driver.findElement(By.xpath(loc.getProperty("newquoteaddress2"))).click();
	    driver.findElement(By.xpath(loc.getProperty("newquoteaddress2"))).sendKeys(newquoteaddress2);
	    if(!driver.findElement(By.xpath(loc.getProperty("newquotecity"))).getAttribute("maxlength").equals("50")) {
	    	Assert.fail("EXPECTED ADDRESS CITY FIELD TO HAVE A MAX LENGTH OF 50");
	    }
	    driver.findElement(By.xpath(loc.getProperty("newquotecity"))).click();
	    driver.findElement(By.xpath(loc.getProperty("newquotecity"))).sendKeys(newquotecity);
	    driver.findElement(By.xpath(loc.getProperty("buildersstartquote"))).click();
		alertmsg = driver.switchTo().alert().getText();
		if(alertmsg.equals("The complete risk address is required for a quote")) {
			System.out.print("\nExpected alert shown: " + alertmsg);
			driver.switchTo().alert().accept();
		}
		else {
			Assert.fail("Expected alert NOT shown! Message captured: " + alertmsg);
			driver.quit();
		}
		if(!driver.findElement(By.xpath(loc.getProperty("newquotezipcode"))).getAttribute("maxlength").equals("5")) {
	    	Assert.fail("EXPECTED ZIP CODE FIELD TO HAVE A MAX LENGTH OF 5");
	    }
		driver.findElement(By.xpath(loc.getProperty("newquotezipcode"))).click();
	    driver.findElement(By.xpath(loc.getProperty("newquotezipcode"))).sendKeys(newquotezipcode);
	    driver.findElement(By.xpath(loc.getProperty("buildersstartquote"))).click();
	    Thread.sleep(1000);
	    try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			Thread.sleep(500);
		}
	    driver.findElement(By.xpath(loc.getProperty("buildersstartquote"))).click();
	    Action.fluentWait(driver, null, 0);
	    System.out.print("\nQuote Number displayed: " + driver.findElement(By.xpath(loc.getProperty("quotenumber"))).getText().substring(14));
	    System.out.print("\nAll start a new quote fields are working correctly.\n");
	  }
}
