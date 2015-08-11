package com.automation.pageObjects;

import java.net.MalformedURLException;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public abstract class BasePage<T> {

  // this is the driver that will be used for all Selenium test actions
  static RemoteWebDriver driver;

  /** Default page load times */
  private static final int LOAD_TIMEOUT = 60; // Wait 60 seconds for an element to be present on the
                                              // page,

  public T open_HomePage(Class<T> clazz) throws InterruptedException, MalformedURLException {

    T page = PageFactory.initElements(getDriver("browser"), clazz);
    getDriver("browser").navigate().to("http://t.hostelworld.com/");
    ElementLocatorFactory finder =
        new AjaxElementLocatorFactory(getDriver("browser"), LOAD_TIMEOUT);
    PageFactory.initElements(finder, this);
    BasePage.getDriver("browser");
    return page;
  }

  public void waitForPageToLoad(ExpectedCondition<T> pageLoadCondition)
      throws InterruptedException, MalformedURLException {
    ElementLocatorFactory finder =
        new AjaxElementLocatorFactory(getDriver("browser"), LOAD_TIMEOUT);
    PageFactory.initElements(finder, this);
    BasePage.getDriver("browser");
  }

  /**
   * Provides page relative URL/
   *
   * @return
   */
  public abstract String getPageUrl();

  @BeforeMethod
  // The annotated method will be run before all tests in this suite have run
  @Parameters("browser")
  // a method to allow retrieving our driver instance
  // this annotation (browser) is used to insert parameter in test
  public static RemoteWebDriver getDriver(String browser) throws InterruptedException,
      MalformedURLException {

    if (browser.equalsIgnoreCase("FF")) { // Firefox browser on local machine
      FirefoxProfile firefoxProfile = new FirefoxProfile();
      driver = new FirefoxDriver(firefoxProfile);
      driver.manage().deleteAllCookies();
      driver.manage().window().maximize();
    } 
    return driver;
  }

  /**
   * Provides condition when page can be considered as fully loaded.
   *
   * @return
   */
  protected abstract ExpectedCondition<T> getPageLoadCondition();

  @AfterMethod
  /* this annotation will run once test script execution is complete */
  public void closeBrowser() {
    driver.quit();
  }
}
