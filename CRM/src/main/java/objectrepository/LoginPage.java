package objectrepository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="username")
	private WebElement usernameTf;
	
	@FindBy(id="inputPassword")
	private WebElement passwordTf;
	
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement loginBtn;

	public WebElement getUsernameTf() {
		return usernameTf;
	}

	public WebElement getPasswordTf() {
		return passwordTf;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	public void Login(String url,String username,String password) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		usernameTf.sendKeys(username);
		passwordTf.sendKeys(password);
		loginBtn.click();
		
	}

	
	

}
