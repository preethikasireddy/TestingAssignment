package myproject.homepage;

import base.BaseScenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GmailLoginScenario extends BaseScenario
{
  @When("^I enter username \"(.*?)\" and click Next$")
  public void enterUsername(String arg1) throws Throwable
  {
    WebElement emailElement = driver.findElement(By.xpath("//*[contains(@type, 'email')]"));
    emailElement.sendKeys(arg1);
    WebElement nextOne = driver.findElement(By.xpath("(//*[contains(@class, 'CwaK9')])[2]"));
    nextOne.click();
    // Wait for 1 sec
    Thread.sleep(secondsToWait);
  }

  @When("^I enter password \"(.*?)\" and click Next$")
  public void enterPassword(String pwd) throws Throwable
  {
    WebElement password = driver.findElement(By.name("password"));
    password.sendKeys(pwd);
    Thread.sleep(secondsToWait);
    WebElement nextTwo = driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
    nextTwo.click();
  }

  @When("^I Click Next$")
  public void clickNext() throws Throwable
  {
     WebElement next = driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
     next.click();
  }

  @Then("^the page error message should be \"(.*?)\"$")
  public void getErrorMessage(String message)
  {
    WebDriverWait wait = new WebDriverWait(driver,10);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@jsname='B34EJ']")));
    String actualText = driver.findElement(By.xpath("//div[@jsname='B34EJ']")).getText();
    assertEquals(actualText,message);
    closeDriver();
  }

  @Then("^the search mail icon exists$")
  public void searchMailIcon()
  {
    WebDriverWait wait = new WebDriverWait(driver,20);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search mail']")));
    int size = driver.findElements(By.xpath("//input[@placeholder='Search mail']")).size();
    if(size>0)
    {
      assertTrue(true);
    }
    else
    {
      assertTrue(false);
    }
  }
}
