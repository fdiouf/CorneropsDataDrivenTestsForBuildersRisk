package actiondriver;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BuildersRiskBaseClass;

public class ReusableMethods extends BuildersRiskBaseClass{

	public static void loginIsi() throws IOException {
		driver.findElement(By.name(loc.getProperty("agentcode_field"))).click();
		WebElement uagCode = driver.findElement(By.name("userloginid"));
		uagCode.clear();
		uagCode.sendKeys("0");
 
		WebElement ulname = driver.findElement(By.name("userloginname"));
		ulname.clear();
		ulname.sendKeys("TUSER001");
 
		WebElement pwd = driver.findElement(By.name("password"));
		pwd.clear();
		pwd.sendKeys("Test@123");
 
		WebElement loginBtn = driver.findElement(By.name(loc.getProperty("loginbtn")));
		loginBtn.click();
	}
	
	public static void switchToFLInternal(){
		driver.findElement(By.name(loc.getProperty("agentlogin"))).click();
		driver.findElement(By.name(loc.getProperty("agentlogin"))).sendKeys("0 - TUSER001");
		driver.findElement(By.name(loc.getProperty("agentlogin"))).click();
	}
	
	public static void switchToTXInternal(){
		driver.findElement(By.name(loc.getProperty("agentlogin"))).click();
		driver.findElement(By.name(loc.getProperty("agentlogin"))).sendKeys("0 - TUSER002");
		driver.findElement(By.name(loc.getProperty("agentlogin"))).click();
	}
	
	public static void switchToAgent(){
		driver.findElement(By.name(loc.getProperty("agentlogin"))).click();
		driver.findElement(By.name(loc.getProperty("agentlogin"))).sendKeys("10107 - TUSER003");
		driver.findElement(By.name(loc.getProperty("agentlogin"))).click();
	}
	
	public static void printValidations(){
		boolean validations = true;
		try {
			driver.findElement(By.className(loc.getProperty("validationlist")));
		} catch (Exception e) {
			System.out.print("\nNO VALIDATIONS DISPLAYING\n");
			validations = false;
		}
		if(validations == true) {
			System.out.println("\nVALIDATIONS FOUND:\n" + driver.findElement(By.className(loc.getProperty("validationlist"))).getText());
			String[] x = driver.findElement(By.className(loc.getProperty("validationlist"))).getAttribute("innerText").split("\n");
			System.out.println("\nTOTAL VALIDATIONS: " + x.length + "\n");
		}
	}
	
	public static void searchPolicy(String policy) throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath(loc.getProperty("topmenustart"))).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(loc.getProperty("topmenuviewpolicylink"))).click();
		Thread.sleep(500);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath(loc.getProperty("searchbypolicyrdbtn"))).click();
		driver.findElement(By.xpath(loc.getProperty("searchpolicynumberfield"))).click();
		driver.findElement(By.xpath(loc.getProperty("searchpolicynumberfield"))).sendKeys(policy);
		driver.findElement(By.xpath(loc.getProperty("searchpolicycontinuebtn"))).click();
		Thread.sleep(500);
	}
}
