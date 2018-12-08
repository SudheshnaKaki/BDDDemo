package demoForm;

import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef {

	WebDriver driver;
	PageFactoryDemo fact;
	@Given("^user is on the Registration page$")
	public void user_is_on_the_Registration_page() throws Throwable {
		
	  System.setProperty("webdriver.chrome.driver", "D:\\selenium jars\\ChromeDriver.exe");
	   driver = new ChromeDriver();
	   fact = new PageFactoryDemo(driver);
	   driver.get("file:///C:/Users/nvavilal/Desktop/formDemo.html");
	}

	@Then("^check the title of Registartion page$")
	public void check_the_title_of_Registartion_page() throws Throwable {
		
		String title = driver.getTitle();
		if (title.equals("Registration Form")) {
			System.out.println("matched " + title);
		} else {
			System.out.println("not matched");
		}
	}

	@When("^user enters valid details$")
	public void user_enters_valid_details() throws Throwable {
	   fact.setName("lahari");
	   Thread.sleep(1000);
	   fact.setMobile("9441929956");
	   Thread.sleep(1000);
	   fact.setEmail("lahari12@gmail.com");
	   Thread.sleep(1000);
	   fact.setGender2();
	   Thread.sleep(1000);
	   fact.setAddress("chennai, sipcot IT park, siruseri");
	   Thread.sleep(1000);
	}

	@Then("^display success page$")
	public void display_success_page() throws Throwable {
	   fact.setSubmit();
	   Thread.sleep(1000);
	  // driver.get("file:///C:/Users/nvavilal/Desktop/success.html");
	 
	  
	}

	@When("^user enter invalid name$")
	public void user_enter_invalid_name(DataTable arg1) throws Throwable {
		 fact.setMobile("9441929956");
		   Thread.sleep(1000);
		   fact.setEmail("lahari12@gmail.com");
		   Thread.sleep(1000);
		   fact.setGender2();
		   Thread.sleep(1000);
		   fact.setAddress("chennai, sipcot IT park, siruseri");
		   Thread.sleep(1000);
		   
		   List<String> list = arg1.asList(String.class);

			String data = null;
			for (String names : list) {
				data = names;
				fact.getName().clear();
				Thread.sleep(1000);
				fact.setName(names);
				Thread.sleep(1000);
				fact.setSubmit();
				   Thread.sleep(1000);
				if (Pattern.matches("[A-Za-z]{3,}", data)) {
					System.out.println("matched  " + data);
				} else {
					System.out.println("not matched  " + data);
					String alert = driver.switchTo().alert().getText();
					System.out.println(alert);
					Thread.sleep(1000);
					driver.switchTo().alert().accept();
					
				}
				
				

				

			}
	}

	@Then("^display error message$")
	public void display_error_message() throws Throwable {
	   
	}
	
	@When("^user enters invalid mobile number$")
	public void user_enters_invalid_mobile_number(DataTable arg2) throws Throwable {
		fact.setName("lahari");
		   Thread.sleep(1000);
		   fact.setEmail("lahari12@gmail.com");
		   Thread.sleep(1000);
		   fact.setGender2();
		   Thread.sleep(1000);
		   fact.setAddress("chennai, sipcot IT park, siruseri");
		   Thread.sleep(1000);
		  
		   List<String> list = arg2.asList(String.class);

			String data = null;
			for (String num : list) {
				data = num;
				fact.getMobile().clear();
				Thread.sleep(1000);
				fact.setMobile(num);
				Thread.sleep(1000);
				fact.setSubmit();
				   Thread.sleep(1000);
				
				if (Pattern.matches("[6-9][0-9]{9}", data)) {
					System.out.println("matched  " + data);
				} else {
					System.out.println("not matched  " + data);
					String alert = driver.switchTo().alert().getText();
					System.out.println(alert);
					Thread.sleep(1000);
					driver.switchTo().alert().accept();
					
				}
			}
	}

	@When("^user enters invalid email$")
	public void user_enters_invalid_email(DataTable arg3) throws Throwable {
		fact.setName("lahari");
		   Thread.sleep(1000);
		   fact.setMobile("9441929956");
		   Thread.sleep(1000);
		   fact.setGender2();
		   Thread.sleep(1000);
		   fact.setAddress("chennai, sipcot IT park, siruseri");
		   Thread.sleep(1000);
		  
		   List<String> list = arg3.asList(String.class);

			String data = null;
			for (String email : list) {
				data = email;
				fact.getEmail().clear();
				Thread.sleep(1000);
				fact.setEmail(email);
				Thread.sleep(1000);
				fact.setSubmit();
				   Thread.sleep(1000);
				if (Pattern.matches("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}", data)) {
					System.out.println("matched  " + data);
				} else {
					System.out.println("not matched  " + data);
					String alert = driver.switchTo().alert().getText();
					System.out.println(alert);
					Thread.sleep(1000);
					driver.switchTo().alert().accept();
					
				}
			}
			
			
	}
	
	@When("^user dont check gender$")
	public void user_dont_check_gender() throws Throwable {
		
		   fact.setName("lahari");
		   Thread.sleep(1000);
		   fact.setMobile("9441929956");
		   Thread.sleep(1000);
		   fact.setEmail("lahari12@gmail.com");
		   Thread.sleep(1000);
		   fact.setAddress("chennai, sipcot IT park, siruseri");
		   Thread.sleep(1000);
		   fact.setSubmit();
		   Thread.sleep(1000);
	}

	@Then("^display error message for gender$")
	public void display_error_message_for_gender() throws Throwable {
		String alert = driver.switchTo().alert().getText();
		System.out.println(alert);
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
	}
	
	
	@After
	public void after() {
		driver.close();
	}

}
