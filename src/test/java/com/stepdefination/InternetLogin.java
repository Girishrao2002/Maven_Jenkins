package com.stepdefination;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InternetLogin {

	WebDriver driver;
	WebDriverWait wait;
	
	@Before("@LoginTest")
	public void setUp() {
		driver=new ChromeDriver();
	    wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set explicit wait

        driver.manage().window().maximize();
	}
	
	@Given("I navigate to the login page")
	public void i_navigate_to_the_login_page() {
	    
	    driver.get("https://the-internet.herokuapp.com/login");
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
	}
	@When("I enter valid login credentials")
	public void i_enter_valid_login_credentials() {
	   
		WebElement username= wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
		WebElement password=wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
		
		username.sendKeys("tomsmith");
		password.sendKeys("SuperSecretPassword!");	
	}
	@When("I click the login button")
	public void i_click_the_login_button() {
	   WebElement loginBtn=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login\"]/button/i")));
	   loginBtn.click();
	}
	@Then("I should see a successful login message")
	public void i_should_see_a_successful_login_message() {
	   WebElement msg=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/div/h2")));
	   if (msg.getText().contentEquals("Secure Area")) {
		   System.out.println("Login Successful!: Test Passed.");
	   }else {
		   System.out.println("Test Failed!");
	   }
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
