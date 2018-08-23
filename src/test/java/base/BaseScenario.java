
package base;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseScenario
{
  /** handle to the webdriver */
  protected static WebDriver driver = null;

  // Wait for AJAX if needed
  protected int secondsToWait = 1000;

  /**
   *  Get the driver with devices
   */
  public WebDriver getDriver()
  {
    if (null != driver)
    {
      return driver;
    }

    // Environment variables
    String envName = (String)System.getProperty("envName","local");
    String browserName = (String)System.getProperty("browserName","googlechrome");

    if (envName.equalsIgnoreCase("local"))
    {
      String driverDirectory = System.getProperty("user.dir")+"\\drivers\\";
      String driverLocation = System.getProperty("driverLocation",driverDirectory);
      String machineType = System.getProperty("machineType","");
      if (browserName.equalsIgnoreCase("googlechrome"))
      {
        /* Chrome Local */
        if (machineType.equalsIgnoreCase("mac"))
        {
          System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
        }
        else
        {
          System.setProperty("webdriver.chrome.driver", driverLocation + "chromedriver.exe");
        }
        driver = new ChromeDriver();
      }
      else if (browserName.equalsIgnoreCase("ie"))
      {
       /* IE Local */
       System.setProperty("webdriver.ie.driver", driverLocation + "IEDriverServer.exe");
       DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
       ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
       ieCapabilities.setCapability("ignoreZoomSetting", true);
       driver = new InternetExplorerDriver(ieCapabilities);
      }
      else if (browserName.equalsIgnoreCase("safari"))
      {
      /* Safari Driver */
      driver = new SafariDriver();
      }
      else if (browserName.equalsIgnoreCase("firefox"))
      {
      /* Firefox */
      driver = new FirefoxDriver();
      }
    }
    return driver;
  }

  /**
   * Get Site Url from pom.xml properties or command line -DsiteUrl
   */
  public String getSiteBaseUrl() {
    return (String)System.getProperty("siteUrl");
  }

  /**
   * Close Driver: delete all cookies for new session, tearDownClass() will handle closing the driver
   */
  public static void closeDriver()
  {
    if (null != driver)
    {
      driver.manage().deleteAllCookies();
    }
  }
  /**
   * Quit Driver: tearDownClass() will handle closing the driver
   */
  public static void quitDriver()
  {
    if (null != driver)
    {
      driver.quit();
    }
  }

}
