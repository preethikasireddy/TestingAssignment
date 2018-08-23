package myproject.common;
import base.BaseScenario;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.Given;

public class CommonStepDef extends BaseScenario
{
  /**
   * Common Step to Open the site with device
   * @param pageType For your project to define page type url / init page object
   * @param screenSize hd-desktop | tablet | mobile
   * @throws Throwable
   */
  @Given("^The website page type \"(.*?)\" is opened in \"(.*?)\"$")
  public void the_website_page_type_is_opened_in(String pageType, String screenSize) throws Throwable
  {

    WebDriver driver = getDriver();
    driver.manage().window().maximize();
    String uri = "";
    driver.get(getSiteBaseUrl() + "/" + uri);
    WebDriverWait wait = new WebDriverWait(driver, 200);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'gmail-nav__nav-link')][2]")));
    WebElement element = driver.findElement(By.xpath("//*[contains(@class, 'gmail-nav__nav-link')][2]"));
    element.click();
  }

  @Given("^I navigate to the Amazon website$")
  public void I_navigate_to_the_Amazon_website() throws Throwable
  {

    WebDriver driver = getDriver();
    driver.manage().window().maximize();
    driver.get("https://www.amazon.co.uk");
    Thread.sleep(5000);
  }

}