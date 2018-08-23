package myproject.homepage;

import base.BaseScenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class AmazonPurchaseScenario extends BaseScenario
{
    String searchItem;

    @When("^I search for an item \"([^\"]*)\"$")
    public void SearchItem(String item) throws Throwable
    {
        searchItem=item;
        WebElement searchTextbox=driver.findElement(By.xpath("//*[@id=\'twotabsearchtextbox\']"));
        searchTextbox.sendKeys(searchItem);
        WebElement searchButton=driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input"));
        searchButton.click();
    }

    @When("^I verify the book in search results$")
    public void VerifyResults() throws Throwable
    {
        List<WebElement> SearchResults=driver.findElements(By.xpath("//ul[@id='s-results-list-atf']/li/div/div/div/div[2]/div[1]/div[1]/a"));
        int ResultsTotal=SearchResults.size();
        //System.out.println(ResultsTotal);
        for(int i=0;i<ResultsTotal;i++)
        {
            //System.out.println(searchItem);
            //System.out.println(SearchResults.get(i).getAttribute("title"));
            if(searchItem.equals(SearchResults.get(i).getAttribute("title")))
            {
                SearchResults.get(i).click();
                break;
            }
        }
    }

    @And("^I add the book to my cart$")
    public void AddItemToCart() throws Throwable
    {
        driver.findElement(By.xpath("//div[@class='a-button-stack']/span/span/input")).click();
    }

    @And("^I click on Proceed to checkout$")
    public void ProceedtoCheckout() throws Throwable
    {
        driver.findElement(By.xpath("//*[@id=\'hlb-ptc-btn-native\']")).click();
    }

    @Then("^Signin screen should be present$")
    public void SignInScreenDisplay() throws Throwable
    {
      if(driver.findElement(By.xpath("//*[@id=\'authportal-main-section\']/div[2]/div/div[1]/form/div/div/div/h1")).isDisplayed())
      {
            assertTrue(true);
      }
      else
      {
            assertTrue(false);
      }

    }



}