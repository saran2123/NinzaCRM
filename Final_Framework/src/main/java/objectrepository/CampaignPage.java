package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {

	WebDriver driver;

	public CampaignPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "campaignName")
	private WebElement campaignNameTF;

	@FindBy(name = "targetSize")
	private WebElement targetSizeTF;

	@FindBy(name = "campaignStatus")
	private WebElement campaignStatusTF;

	@FindBy(name = "expectedCloseDate")
	private WebElement expectedCloseDateTF;

	@FindBy(xpath = "//button[text()='Create Campaign']")
	private WebElement createCampaignSubmitBtn;

	public WebElement getCampaignNameTF() {
		return campaignNameTF;
	}

	public WebElement getTargetSizeTF() {
		return targetSizeTF;
	}

	public WebElement getCampaignStatusTF() {
		return campaignStatusTF;
	}

	public WebElement getExpectedCloseDateTF() {
		return expectedCloseDateTF;
	}

	public WebElement getCreateCampaignSubmitBtn() {
		return createCampaignSubmitBtn;
	}

	public void createCampaign(String campaignName, String targetSize) {
		HomePage hp = new HomePage(driver);
		hp.getCreateCampaignBtn().click();
		campaignNameTF.sendKeys(campaignName);
		targetSizeTF.clear();
		targetSizeTF.sendKeys(targetSize);
	}

}
