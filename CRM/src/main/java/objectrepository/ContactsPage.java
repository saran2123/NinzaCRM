package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	WebDriver driver;
	
	public ContactsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	 @FindBy(xpath = "//span[text()='Create Contact']") 
	 private WebElement createContactBtn; 
	 
	 
	 public WebElement getCreateContactBtn() { 
	  return createContactBtn; 
	 } 

}
