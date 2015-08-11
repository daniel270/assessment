package com.automation.pageObjects;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Page object representing the home page
 *
 * @author: Daniel Adewale
 */
public class HomePage extends BasePage<HomePage> {


  // lookup button elements
  @FindBys(value = {@FindBy(tagName = "button")})
  List<WebElement> buttonElements;

  // lookup input elements
  @FindBys(value = {@FindBy(tagName = "input")})
  List<WebElement> inputElements;

  // click search button
  public void search() throws InterruptedException {
    for (WebElement we : buttonElements) {
      if (we.getText().equalsIgnoreCase("SEARCH") && we.isDisplayed()) {
        we.click();
        Thread.sleep(2000);
        break;
      }
    }
  }

  // input text in text field
  public void search_by_city_or_hotel(String searchText) {
    for (WebElement we : inputElements) {
        if (we.getAttribute("id").equals("home-search-keywords")) {
          we.clear();
          we.sendKeys(searchText);
          break;
        }
      }
    }

  // lookup suggestions texts dropdown list
  @FindBys(value = {@FindBy(className = "suggestion")})
  List<WebElement> suggestion_list;

  // click on text from suggestion list
  public void select(String text) {
    try{
    for (WebElement we : suggestion_list) {
      if (we.getText().equalsIgnoreCase(text) && we.isDisplayed()) {
        we.click();
        break;
      }
    }}catch(NoSuchElementException e){
      e.printStackTrace();
    }
  }

  // confirm search bar contains correct text
  public boolean search_bar_text(String textToVerify) {
    boolean found = false;
    try{
    for (WebElement we : inputElements) {
      if (we.getAttribute("id").equals("home-search-keywords")
          && we.getAttribute("value").equals(textToVerify)) {
        found = true;
        break;
      }
    }
    }catch(NoSuchElementException e){
      System.out.println(textToVerify + " not found");
      e.printStackTrace();
    }
    return found;
  }

  // confirm search bar is present in the home screen
  public boolean search_bar_Present() {
    boolean found = false;
    for (WebElement we : inputElements) {
      if (we.getAttribute("id").equals("home-search-keywords")
          && we.isDisplayed()) {
        found = true;
        break;
      }
    }
    if (!found) {
      System.out.println("Home search bar not found");
    }
    return found;
  }

  /*********************************************************/

  @Override
  protected ExpectedCondition getPageLoadCondition() {
    return ExpectedConditions.titleContains("");
  }

  @Override
  public String getPageUrl() {
    return "";
  }

  public HomePage open() throws InterruptedException, MalformedURLException {
    return new HomePage().open_HomePage(HomePage.class);
  }

}
