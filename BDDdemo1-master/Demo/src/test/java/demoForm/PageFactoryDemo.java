package demoForm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryDemo {

	WebDriver d;

	public PageFactoryDemo(WebDriver driver) {
		super();
		this.d = driver;
		PageFactory.initElements(d, this);

	}
	 public PageFactoryDemo()  {
		 super(); 
	 }
	 @FindBy(name="txtName")
	 @CacheLookup
	 WebElement name;
	 
	 @FindBy(name="mobileNum")
	 @CacheLookup
	 WebElement mobile;
	 
	 @FindBy(name="email")
	 @CacheLookup
	 WebElement email;
	 
	 @FindBy(id="male")
	 @CacheLookup
	 WebElement male;
	 
	 @FindBy(id="female")
	 @CacheLookup
	 WebElement female;
	 
	 @FindBy(xpath="/html/body/form/table/tbody/tr[5]/td[2]/textarea")
	 @CacheLookup
	 WebElement address;
	 
	 @FindBy(id="btn")
	 @CacheLookup
	 WebElement submit;
	 
	 //setters
	 public void setName(String fname) {
		 name.sendKeys(fname);
	 }
	 public void setMobile(String number) {
		 mobile.sendKeys(number);
	 }
	 public void setEmail(String mailId) {
		 email.sendKeys(mailId);
	 }
	 public void setGender1() {
		 male.click();
	 }
	 public void setGender2() {
		 female.click();
	 }
	 public void setAddress(String address1) {
		 address.sendKeys(address1);
	 }
	 public void setSubmit() {
		 submit.click();
	 }
	 
	 //getters
	 public WebElement getName() {
		 return name;
	 }
	 public WebElement getMobile() {
		 return mobile;
	 }
	 public WebElement getEmail() {
		 return email;
	 }
	 public WebElement getGender1(){
		 return male;
	 }
	 public WebElement getGender2() {
		 return female;
	 }
	 public WebElement getAddress() {
		 return address;
	 }
	 public WebElement getSubmit() {
		 return submit;
	 }
}
