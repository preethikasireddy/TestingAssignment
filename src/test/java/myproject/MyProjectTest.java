
package myproject;

import base.BaseScenario;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//@Cucumber.Options(features="src/test/resources/myproject/homepage//AmazonPurchaseScenario.feature",tags={"@focus"},format = {"pretty", "html:target/cucumber", "json:target/cucumber.json"})
public class MyProjectTest
{
  @AfterClass
  public static void tearDownClass()
  {
    // Close web driver
    BaseScenario.quitDriver();
  }
}
