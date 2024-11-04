package buildersRiskTestsFlorida;														// THIS TEST RUNS FOR 2 MINUTES AND 37 SECONDS

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import actiondriver.ReusableMethods;
import utilities.ReusablePolicyMaker;

public class BuildersRiskCoverageSummaryTest extends ReusablePolicyMaker{
	
	@Test(description = "T18853	TC01 - Builders Risk - Coverage Summary - Login to ISi Test and load Coverage Summary page", enabled = true, priority = 1)
	public void CoverageSummaryTest1() throws InterruptedException, ParseException{
		
		ReusableMethods.switchToFLInternal();
		CreateNewPolicyFL();
		ReusableMethods.searchPolicy(policyNumber);
		Thread.sleep(500);
		if(driver.findElement(By.xpath(loc.getProperty("builderspolicynumber"))).getText().equals(policyNumber)) {
			System.out.print("\nPolicy correctly dispayed");
		}
		else {
			Assert.fail("POLICY CREATED MISMATCHES POLICY DISPLAYED");
		}
	}
	
	@Test(description = "T18855	TC02 - Builders Risk - Coverage Summary - Policy overview header", enabled = true, priority = 2)
	public void CoverageSummaryTest2() throws InterruptedException{
		
		String insuredNameFound = driver.findElement(By.xpath(loc.getProperty("builderspolicyinsuredname"))).getAttribute("innerText");
		insuredNameFound = insuredNameFound.substring(0, insuredNameFound.length()-2);
		if(insuredNameFound.contains(FLData[17].toUpperCase())) {
			System.out.print("\nBusiness Name is correctly displayed");
			if(!FLData[66].equals("")) {
				if(insuredNameFound.contains(FLData[66].toUpperCase())) {
					System.out.print("\nInsured's First Name is correctly displayed");
				}
				else {
					Assert.fail("INSURED'S FIRST NAME MISMATCH");
				}
			}
			if(!FLData[66].equals("")) {
				if(insuredNameFound.contains(FLData[66].toUpperCase())) {
					System.out.print("\nInsured's Middle Name is correctly displayed");
				}
				else {
					Assert.fail("INSURED'S MIDDLE NAME MISMATCH");
				}
			}
			if(!FLData[68].equals("")) {
				if(insuredNameFound.contains(FLData[68].toUpperCase())) {
					System.out.print("\nInsured's Last Name is correctly displayed");
				}
				else {
					Assert.fail("INSURED'S LAST NAME MISMATCH");
				}
			}
		}
		else {
			Assert.fail("BUSINESS NAME MISMATCH");
		}
		Thread.sleep(500);
		String insuredinfo = driver.findElement(By.xpath(loc.getProperty("builderspolicyinsuredinfo"))).getAttribute("innerHTML");
		String[] insuredaddress = insuredinfo.split("<br>");
		Boolean mailing = false;
		if(insuredaddress[0].contains(FLData[20].toUpperCase()) && insuredaddress[0].contains(FLData[22].toUpperCase())) {
			if(insuredaddress[0].contains(FLData[23].toUpperCase()) && insuredaddress[0].contains(FLData[24].toUpperCase())) {
				System.out.print("\nMailing address is correctly displayed");
				mailing = true;
			}
		}
		if(mailing==false) {
			Assert.fail("MAILING ADDRESS MISMATCH");
		}
		if(insuredaddress[1].contains(FLData[9])) {
			System.out.print("\nInsured phone number is correctly displayed");
		}
		else {
			Assert.fail("INSURED'S PHONE NUMBER MISMATCH");
		}
		if(insuredaddress[2].contains(FLData[10].toUpperCase())) {
			System.out.print("\nInsured email address is correctly displayed");
		}
		else {
			Assert.fail("INSURED'S EMAIL ADDRESS MISMATCH");
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		String dateFormatted= dateFormat.format(date);
		if(driver.findElement(By.xpath(loc.getProperty("builderspolicydates"))).getText().contains(dateFormatted)) {
			System.out.print("\nPolicy Effective Date is successfully displayed");
		}
		else {
			Assert.fail("POLICY EFFECTIVE DATE MISMATCH");
		}
		cal.add(Calendar.YEAR, 1);
		Date date2 = cal.getTime();
		String dateFormatted2= dateFormat.format(date2);
		if(driver.findElement(By.xpath(loc.getProperty("builderspolicydates"))).getText().contains(dateFormatted2)) {
			System.out.print("\nPolicy Expiration Date is successfully displayed");
		}
		else {
			Assert.fail("POLICY EXPIRATION DATE MISMATCH");
		}
		if(driver.findElement(By.xpath(loc.getProperty("buildersfinalpolicytype"))).getText().contains(FLData[0].toUpperCase())) {
			if(driver.findElement(By.xpath(loc.getProperty("buildersfinalpolicytype"))).getText().contains(FLData[1])) {
				System.out.print("\nPolicy Type is successfully displayed");
			}
			else {
				Assert.fail("POLICY TYPE MISMATCH - EXPECTED: " + FLData[1]);
			}
		}
		else {
			Assert.fail("POLICY TYPE STATE MISMATCH - EXPECTED: " + FLData[0]);
		}
		if(driver.findElement(By.xpath(loc.getProperty("policycompanyname"))).getText().equals("Cypress Property & Casualty Insurance Company")) {
			System.out.print("\nCypress Company Name is successfully displayed");
		}
		else {
			Assert.fail("CYPRESS COMPANY NAME MISMATCH");
		}
		if(driver.findElement(By.xpath(loc.getProperty("builderspolicyselectedagent"))).getText().contains(FLData[6])) {
			System.out.print("\nAgent selected is successfully displayed");
		}
		else {
			Assert.fail("AGENT SELECTED MISMATCH");
		}
		driver.findElement(By.xpath(loc.getProperty("builderssummarymorebtn"))).click();
		Thread.sleep(500);
		if(driver.findElement(By.xpath(loc.getProperty("builderspolicyaccoundid"))).getAttribute("innerHTML").contains("Account ID:")) {
			System.out.print("\nAccount ID is successfully displayed");
		}
		else {
			Assert.fail("ACCOUNT ID IS MISSING");
		}
		if(driver.findElement(By.xpath(loc.getProperty("builderspolicypayplan"))).getAttribute("innerText").contains("Pay Plan:")) {
			System.out.print("\nPay Plan is successfully displayed");
		}
		else {
			Assert.fail("PAY PLAN IS MISSING");
		}
		driver.findElement(By.xpath(loc.getProperty("builderspolicydates"))).click();
		Thread.sleep(1000);
		driver.switchTo().frame(0);
		try {
			driver.findElement(By.xpath(loc.getProperty("buildersalldocumentsheader"))).getText();
		} catch (Exception e) {
			Assert.fail("EXPECTED POLICY TERM TO BE CLICKABLE");
		}
		System.out.print("\nPolicy term is calculated and clickable as expected");
		ReusableMethods.searchPolicy(policyNumber);
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("builderspolicyoustandingtasks"))).click();
		Thread.sleep(1000);
		driver.switchTo().frame(0);
		try {
			driver.findElement(By.xpath(loc.getProperty("buildersoutstandingtasksheader"))).getText();;
		} catch (Exception e) {
			Assert.fail("EXPECTED OUTSTANDING TASKS TO BE CLICKABLE");
		}
		System.out.print("\nOutstanding tasks is working as expected");
		ReusableMethods.searchPolicy(policyNumber);
		driver.findElement(By.xpath(loc.getProperty("builderssummarymorebtn"))).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(loc.getProperty("builderspolicynumber"))).click();
		Thread.sleep(1000);
		driver.switchTo().frame(0);
		try {
			driver.findElement(By.xpath(loc.getProperty("builderscoveragesummaryheader"))).getText();;
		} catch (Exception e) {
			Assert.fail("EXPECTED POLICY NUMBER TO BE CLICKABLE");
		}
		Thread.sleep(1000);
		ReusableMethods.searchPolicy(policyNumber);
		driver.findElement(By.xpath(loc.getProperty("builderspolicyreloadbtn"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("builderssummarymorebtn"))).click();
		Thread.sleep(500);
		String tasks = driver.findElement(By.xpath(loc.getProperty("builderspolicyoustandingtasks"))).getCssValue("color");
		if(driver.findElement(By.xpath(loc.getProperty("builderspolicyoustandingtasks"))).getAttribute("innerHTML").contains("Outstanding")){
			String expectedTextColor = "rgba(255, 0, 0, 1)";
			Assert.assertEquals(tasks, expectedTextColor);
		}
		else {
			String expectedTextColor = "rgba(1, 156, 223, 1)";
			Assert.assertEquals(tasks, expectedTextColor);
		}
		System.out.print("\nCoverage Summary Policy overview header is working as expected");
	}
	
	@Test(description = "T18857	TC03 - Builders Risk - Coverage Summary - Policy Characteristics", enabled = true, priority = 3)
	public void CoverageSummaryTest3() throws InterruptedException{
		ReusableMethods.searchPolicy(policyNumber);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath(loc.getProperty("builderspolicyrisklocation"))).click();
		Boolean checker = false;
		if(driver.findElement(By.xpath(loc.getProperty("builderspolicyrisklocation"))).getText().contains(FLData[2].toUpperCase())){
			if(driver.findElement(By.xpath(loc.getProperty("builderspolicyrisklocation"))).getText().contains(FLData[4].toUpperCase())){
				if(driver.findElement(By.xpath(loc.getProperty("builderspolicyrisklocation"))).getText().contains(FLData[5].toUpperCase())){
					checker = true;
					System.out.print("\nRisk Address is correctly displayed");
				}
			}
		}
		if(checker==false){
			Assert.fail("RISK ADDRESS MISMATCH");
		}
		if(driver.findElement(By.xpath(loc.getProperty("builderspolicyprojecttype"))).getText().contains(FLData[7])) {
			System.out.print("\nProject Type is correctly displayed");
		}
		else {
			Assert.fail("PROJECT TYPE MISMATCH");
		}
		if(driver.findElement(By.xpath(loc.getProperty("builderspolicycounty"))).getText().contains(FLData[27].toUpperCase())) {
			System.out.print("\nRisk County is correctly displayed");
		}
		else {
			Assert.fail("RISK COUNTY MISMATCH");
		}
		if(driver.findElement(By.xpath(loc.getProperty("builderspolicywindpool"))).getText().contains(FLData[30].toUpperCase())) {
			System.out.print("\nWindpool value is correctly displayed");
		}
		else {
			Assert.fail("WINDPOOL VALUE MISMATCH");
		}
		if(driver.findElement(By.xpath(loc.getProperty("builderspolicyprotectionclass"))).getText().contains(FLData[34].toUpperCase())) {
			System.out.print("\nProtection Class is correctly displayed");
		}
		else {
			Assert.fail("PROTECTION CLASS MISMATCH");
		}
		if(driver.findElement(By.xpath(loc.getProperty("builderspolicylosshistory"))).getText().contains("0")) {
			System.out.print("\nLoss History is correctly displayed");
		}
		else {
			Assert.fail("LOSS HISTORY MISMATCH");
		}
		if(driver.findElement(By.xpath(loc.getProperty("builderspolicysecurityscore"))).getText().contains("Security Score: ")) {
			System.out.print("\nSecurity Score is correctly displayed");
		}
		else {
			Assert.fail("SECURITY SCORE IS MISSING");
		}
		if(driver.findElement(By.xpath(loc.getProperty("builderspolicyratingdesc"))).getText().contains("JUDGEMENT") || driver.findElement(By.xpath(loc.getProperty("builderspolicyratingdesc"))).getText().contains("SYSTEM")) {
			System.out.print("\nPolicy Rating is correctly displayed");
		}
		else {
			Assert.fail("UNEXPECTED POLICY RATING: ONLY OPTIONS ALLOWED ARE 'JUDGEMENT' OR 'SYSTEM'");
		}
		try {
			driver.findElement(By.xpath(loc.getProperty("builderspolicybaserate"))).getText();
		} catch (Exception e) {
			Assert.fail("BASE RATE IS MISSING");
		}
		System.out.print("\nBase Rate is correctly displayed");
		System.out.print("\nRisk Location Coverage Summary section is working successfully");
	}
	
	
	@Test(description = "T18859	TC04 - Builders Risk - Coverage Summary - Coverage Information", enabled = true, priority = 4)
	public void CoverageSummaryTest4() throws InterruptedException{
		ReusableMethods.searchPolicy(policyNumber);
		driver.switchTo().frame(0);
		String coveragesummarytitles = driver.findElement(By.xpath(loc.getProperty("builderspolicycoveragestitle"))).getAttribute("innerText");
		if(coveragesummarytitles.contains("COVERAGES") && coveragesummarytitles.contains("LIMIT OF INSURANCE") && coveragesummarytitles.contains("PREMIUM")){
			System.out.print("\nCoverage summary titles are sucessfully displaying");
		}
		else {
			Assert.fail("COVERAGES, LIMIT OF INSURANCE, & PREMIUM TITLES MISSING/MISMATCH");
		}
		Double completedvalue = Double.parseDouble(FLData[37].toUpperCase());
		String cv = completedvalue + "";
		if(completedvalue>1000000.0) {
			cv = cv.substring(0, cv.length()-8) + "," + cv.substring(cv.length()-8, cv.length()-5) + "," + cv.substring(cv.length()-5);
		}
		else {
			cv = cv.substring(0, cv.length()-5) + "," + cv.substring(cv.length()-5);
		}
		if(driver.findElement(By.xpath(loc.getProperty("builderspolicycompletedvalue"))).getText().contains(cv)) {
			System.out.print("\nCompleted Value Limit is correctly displayed");
		}
		else {
			Assert.fail("COMPLETED VALUE LIMIT MISMATCH");
		}
		String buildingmaterials = driver.findElement(By.xpath(loc.getProperty("builderspolicybuildingmaterials"))).getAttribute("innerText");
		if(buildingmaterials.contains("$5,000.00") && buildingmaterials.contains("INCLUDED")){
			System.out.print("\nBuilding Materials limit is sucessfully displaying");
		}
		else {
			Assert.fail("BUILDING MATERIALS AND SUPPLIES OF OTHERS MISSING/MISMATCH");
		}
		String collapse = driver.findElement(By.xpath(loc.getProperty("builderspolicycollapse"))).getAttribute("innerText");
		if(collapse.contains("Form CPCBR 009") && collapse.contains("INCLUDED")){
			System.out.print("\nCollapse limit and form is sucessfully displaying");
		}
		else {
			Assert.fail("COLLAPSE LIMIT AND FORM ARE MISSING/MISMATCH");
		}
		String constructioncost = driver.findElement(By.xpath(loc.getProperty("builderspolicyconstructioncost"))).getAttribute("innerText");
		if(constructioncost.contains("\t5%")) {
			if(constructioncost.contains("INCLUDED")) {
				System.out.print("\nConstruction Cost Increase Coverage is successfully displayed");
			}
			else {
				Assert.fail("EXPECTED CONSTRUCTION COST LIMIT TO HAVE INCLUDED PREMIUM SINCE LIMIT WAS 5%");
			}
		}
		else {
			if(constructioncost.contains("\t10%") || constructioncost.contains("\t15%") || constructioncost.contains("\t20%")){
				if(constructioncost.contains("\t$")){
					System.out.print("\nConstruction Cost Increase Coverage is successfully displayed");
				}
				else {
					Assert.fail("EXPECTED CONSTRUCTION COST PREMIUM TO HAVE A DOLLAR AMMOUNT");
				}
			}
			else {
				Assert.fail("EXPECTED CONSTRUCTION COST LIMIT TO BE 5%, 10%, 15%, OR 20%");
			}
		}
		String debrisremoval = driver.findElement(By.xpath(loc.getProperty("builderspolicydebrisremoval"))).getAttribute("innerText");
		if(debrisremoval.contains("Form IH 00 70") && debrisremoval.contains("INCLUDED")){
			System.out.print("\nDebris Removal limit and form is sucessfully displaying");
		}
		else {
			Assert.fail("DEBRIS REMOVAL LIMIT AND FORM ARE MISSING/MISMATCH");
		}
		String firedeptservice = driver.findElement(By.xpath(loc.getProperty("builderspolicyfiredeptservice"))).getAttribute("innerText");
		if(firedeptservice.contains("$1,000.00") && firedeptservice.contains("INCLUDED")){
			System.out.print("\nFire Dept Service limit and form is sucessfully displaying");
		}
		else {
			Assert.fail("FIRE DEPT SERVICE LIMT AND FORM ARE MISSING/MISMATCH");
		}
		String vegetations = driver.findElement(By.xpath(loc.getProperty("builderspolicyvegetations"))).getAttribute("innerText");
		if(vegetations.contains("Form IH 00 70") && vegetations.contains("INCLUDED")){
			System.out.print("\nLawns, Trees, Shrubs, & Plants limit and form is sucessfully displaying");
		}
		else {
			Assert.fail("LAWNS, TREES, SHRUBS, & PLANTS LIMT AND FORM ARE MISSING/MISMATCH");
		}
		String fungilimit = driver.findElement(By.xpath(loc.getProperty("builderspolicyfungilimit"))).getAttribute("innerText");
		if(fungilimit.contains("$15,000.00") && fungilimit.contains("INCLUDED")){
			System.out.print("\nCoverage for Fungi, Wet Rot and Dry Rot limit is sucessfully displaying");
		}
		else {
			Assert.fail("FUNGI, WET ROT, AND DRY ROT LIMT AND FORM ARE MISSING/MISMATCH");
		}
		String ordinancelawA = driver.findElement(By.xpath(loc.getProperty("builderspolicyordinancelawA"))).getAttribute("innerText");
		if(ordinancelawA.contains("INCLUDED\tINCLUDED")){
			System.out.print("\nOrdinance or Law - Coverage A limit is sucessfully displaying");
		}
		else {
			Assert.fail("ORDINANCE OR LAW - COVERAGE A LIMT IS MISSING/MISMATCH");
		}
		String ordinancelawBC = driver.findElement(By.xpath(loc.getProperty("builderspolicyordinancelawBC"))).getAttribute("innerText");
		if(ordinancelawBC.contains("$15,000.00\tINCLUDED")){
			System.out.print("\nOrdinance or Law - Coverage B & C limit is sucessfully displaying");
		}
		else {
			Assert.fail("ORDINANCE OR LAW - COVERAGE B & C LIMT IS MISSING/MISMATCH");
		}
		String pollutantcleanup = driver.findElement(By.xpath(loc.getProperty("builderspolicypollutantcleanup"))).getAttribute("innerText");
		if(pollutantcleanup.contains("$10,000.00\tINCLUDED")){
			System.out.print("\nPollutant Cleanup and Removal limit is sucessfully displaying");
		}
		else {
			Assert.fail("POLLUTANT CLEANUP AND REMOVAL LIMT IS MISSING/MISMATCH");
		}
		String preservation = driver.findElement(By.xpath(loc.getProperty("builderspolicypreservation"))).getAttribute("innerText");
		if(preservation.contains("INCLUDED\tINCLUDED")){
			System.out.print("\nPreservation of Property limit is sucessfully displaying");
		}
		else {
			Assert.fail("PRESERVATION OF PROPERTY LIMT IS MISSING/MISMATCH");
		}
		
		String transit = driver.findElement(By.xpath(loc.getProperty("builderspolicypropertytransit"))).getAttribute("innerText");
		if(FLData[41].equals("") || FLData[41].contains("$10,000")) {
			if(transit.contains("$10,000\tINCLUDED")){
				System.out.print("\nProperty at Transit limit is sucessfully displaying");
			}
			else {
				Assert.fail("PROPERTY AT TRANSIT LIMT IS MISSING/MISMATCH. EXPECTED BASE POLICY: $10,000.00 & INCLUDED");
			}
		}
		else {
			String propertytransit = FLData[41].substring(FLData[41].length()-6);
			if(transit.contains(propertytransit) && transit.contains("\t$")){
				System.out.print("\nProperty at Transit limit is sucessfully displaying");
			}
			else {
				Assert.fail("PROPERTY AT TRANSIT LIMT IS MISSING/MISMATCH. EXPECTED: " + propertytransit);
			}
		}
		String softcost = driver.findElement(By.xpath(loc.getProperty("builderspolicysoftcost"))).getAttribute("innerText");
		if(FLData[42].equals("") || FLData[42].contains("$5,000")) {
			if(softcost.contains("$5,000") && softcost.contains("INCLUDED")){
				System.out.print("\nSoft Cost Coverage limit is correctly displayed");
			}
			else {
				System.out.print("\nSOFTCOST: "+ softcost + "\n");
				Assert.fail("SOFT COST COVERAGE LIMT IS MISSING/MISMATCH. EXPECTED BASE POLICY: $5,000.00 & INCLUDED");
			}
		}
		else {
			if(softcost.contains(FLData[42]) && softcost.contains("\t$")){
				System.out.print("\nSoft Cost Coverage limit is correctly displayed");
			}
			else {
				Assert.fail("SOFT COST COVERAGE LIMT IS MISSING/MISMATCH. EXPECTED: " + FLData[42]);
			}
		}
		String terrorism = driver.findElement(By.xpath(loc.getProperty("builderspolicyterrorism"))).getText();
		if(terrorism.contains("EXCLUDED") || terrorism.contains("INCLUDED")) {
			System.out.print("\nTerrorism limit is correctly displayed");
		}
		else {
			Assert.fail("TERRORISM LIMIT MISSING/INVALID");
		}
		String valuablepapers = driver.findElement(By.xpath(loc.getProperty("builderspolicyvaluablepapers"))).getText();
		if(valuablepapers.contains("$10,000.00") || valuablepapers.contains("INCLUDED")) {
			System.out.print("\nValuable Papers limit is correctly displayed");
		}
		else {
			Assert.fail("VALUABLE PAPERS LIMIT MISSING/INVALID");
		}
		String deductible = FLData[38].substring(0, FLData[38].length()-3) + "," + FLData[38].substring(FLData[38].length()-3);
		if(driver.findElement(By.xpath(loc.getProperty("builderspolicydeductible"))).getText().contains(deductible)) {
			System.out.print("\nAOP Deductible is correctly displayed");
		}
		else {
			Assert.fail("AOP DEDUCTIBLE MISMATCH");
		}
		if(driver.findElement(By.xpath(loc.getProperty("builderspolicywindhail"))).getText().contains(FLData[39])) {
			System.out.print("\nWindstorm/hail limit is correctly displayed");
		}
		else {
			Assert.fail("WINDSTORM/HAIL LIMIT MISMATCH");
		}
		System.out.print("\nCoverage Summary - Coverage Information is displaying all of the values correctly");
	}
	
	@Test(description = "T18861	TC05 - Builders Risk - Coverage Summary - Premium and Fees", enabled = true, priority = 5)
	public void CoverageSummaryTest5() throws InterruptedException{
		String[] totalprem = driver.findElement(By.xpath(loc.getProperty("builderspolicytotalcov"))).getAttribute("innerText").split("\t");
		if(driver.findElement(By.xpath(loc.getProperty("builderspolicytotalcov"))).getAttribute("innerText").contains("TOTAL COVERAGE PREMIUM\t$")) {
			System.out.print("\nTOTAL COVERAGE PREMIUM is correctly displayed");
		}
		else {
			Assert.fail("TOTAL COVERAGE PREMIUM MISMATCH");
		}
		if(driver.findElement(By.xpath(loc.getProperty("builderspolicytotalcovfees"))).getAttribute("innerText").contains("FL Fire Marshal Regulatory Assessment\t$")) {
			System.out.print("\nFL Fire Marshal Regulatory Assessment is correctly displayed");
		}
		else {
			Assert.fail("FL FIRE MARSHALL FEE IS MISSING/MISMATCHES");
		}
		if(driver.findElement(By.xpath(loc.getProperty("builderspolicytotalFLFUND"))).getAttribute("innerText").contains("FL Emergency Management, Preparedness and Assistance Trust Fund\t$")) {
			System.out.print("\nFL Emergency Management, Preparedness and Assistance Trust Fund is correctly displayed");
		}
		else {
			Assert.fail("FL EMERGENCY MANAGEMENT, PREPAREDNESS AND ASSISTANCE TRUST FUND FEE IS MISSING/MISMATCHES");
		}
		String[] fee1 = driver.findElement(By.xpath(loc.getProperty("builderspolicytotalcovfees"))).getAttribute("innerText").split("\t");
		String[] fee2 = driver.findElement(By.xpath(loc.getProperty("builderspolicytotalFLFUND"))).getAttribute("innerText").split("\t");
		String[] fee3 = driver.findElement(By.xpath(loc.getProperty("builderspolicytotalFLfigafees"))).getAttribute("innerText").split("\t");
		double totalofall = Double.parseDouble(totalprem[1].substring(1).replace(",", "")) + Double.parseDouble(fee1[1].substring(1)) + Double.parseDouble(fee2[1].substring(1)) + Double.parseDouble(fee3[1].substring(1));
		String finaltotal = String.format("%.2f", totalofall);
		finaltotal = finaltotal.substring(0, finaltotal.length()-6) + "," + finaltotal.substring(finaltotal.length()-6);
		if(driver.findElement(By.xpath(loc.getProperty("builderspolicytotalFLcovfees"))).getAttribute("innerText").contains("TOTAL POLICY PREMIUM, ASSESSMENTS, FEES AND ALL SURCHARGES\t$")) {
			if(driver.findElement(By.xpath(loc.getProperty("builderspolicytotalFLcovfees"))).getAttribute("innerText").contains(finaltotal)) {
				System.out.print("\nTOTAL POLICY PREMIUM, ASSESSMENTS, FEES AND ALL SURCHARGES is correctly displayed");
			}
			else {
				Assert.fail("FLORIDA FEES CALCULATION MISMATCH (PREMIUM AND FEES SECTION)");
			}
		}
		else {
			Assert.fail("TOTAL POLICY PREMIUM, ASSESSMENTS, FEES AND ALL SURCHARGES MISMATCH");
		}
		System.out.print("\nPremium: " + totalprem[1]);
		System.out.print("\nPremium w/ Fees: " + finaltotal);
		System.out.print("\nPolicy Premium & Fees Section is correctly displayed");
	}
	
	@Test(description = "T18863	TC06 - Builders Risk - Coverage Summary - Forms and Endorsements", enabled = true, priority = 6)
	public void CoverageSummaryTest6() throws InterruptedException{
		if(driver.findElement(By.xpath(loc.getProperty("builderspolicyformsandendorsements"))).getAttribute("innerText").contains("FORMS AND ENDORSEMENTS:")) {
			System.out.print("\nFORMS AND ENDORSEMENTS title is correctly displayed");
		}
		else {
			Assert.fail("FORMS AND ENDORSEMENTS TITLE MISSING/MISMATCH");
		}
		if(driver.findElement(By.xpath(loc.getProperty("builderspolicyformsandendorsementssub"))).getAttribute("innerText").contains("Forms attached to and made a part of this policy.")) {
			System.out.print("\nFORMS AND ENDORSEMENTS SUBTITLE is correctly displayed");
		}
		else {
			Assert.fail("FORMS AND ENDORSEMENTS SUBTITLE MISSING/MISMATCH");
		}
		if(driver.findElement(By.xpath(loc.getProperty("builderspolicyformstable"))).getAttribute("innerText").contains("CM 00 01")) {
			System.out.print("\nForms and Endorsements section is working successfully");
		}
		else {
			Assert.fail("FORMS TABLE IS MISSING/INVALID");
		}
	}
	
	@Test(description = "T18865	TC07 - Builders Risk - Coverage Summary - bottom of page", enabled = true, priority = 7)
	public void CoverageSummaryTest7() throws InterruptedException{
		if(driver.findElement(By.xpath(loc.getProperty("builderspolicycurrentaccount"))).getAttribute("innerText").contains("Current Account Balance:")) {
			System.out.print("\nCurrent Account Balance is working successfully");
		}
		else {
			Assert.fail("CURRENT ACCOUNT BALANCE IS MISSING/INVALID");
		}
		if(driver.findElement(By.xpath(loc.getProperty("builderspolicyfutureinstallments"))).getAttribute("innerText").contains("Future Installments")) {
			System.out.print("\nFuture Installments is working successfully");
		}
		else {
			Assert.fail("FUTURE INSTALLMENTS SECTION IS MISSING/INVALID");
		}
		try {
			driver.findElement(By.xpath(loc.getProperty("builderspolicypaymentactivityshow"))).click();
		} catch (Exception e) {
			Assert.fail("PAYMENT ACTIVITY SHOW/HIDE BUTTON IS MISSING");
		}
		try {
			driver.findElement(By.xpath(loc.getProperty("builderspolicypaymentactivitylink"))).click();
		} catch (Exception e) {
			Assert.fail("SEE ALL PAYMENT ACTIVITY LINK IS MISSING");
		}
		ReusableMethods.searchPolicy(policyNumber);
		Thread.sleep(500);
		System.out.print("\nCoverage Summary Page & Values are working successfully\n");
	}
}
