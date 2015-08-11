package com.automation.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedCondition;

/**
 * Page object representing the home page
 *
 * @author: Daniel Adewale
 */
public class ObjectsPage extends BasePage<ObjectsPage> {

  // Lookup all links
  @FindBys(value = {@FindBy(className = "sort-button")})
  List<WebElement> sort_button;

  // click on a link
  public void sort() {
    for (WebElement we : sort_button) {
      if (we.getText().contains("Sort")) {
        we.click();
        break;
      }
    }
  }

  // Lookup sort by list
  @FindBys(value = {@FindBy(id = "drop1"), @FindBy(tagName = "li")})
  List<WebElement> sortby_list;

  // click sort by list
  public void sort_by(String sortText) {
    for (WebElement we : sortby_list) {
      if (we.getAttribute("id").contains("sortBy") && we.getText().equalsIgnoreCase(sortText)) {
        we.click();
        break;
      }
    }
  }


  // Lookup search result container
  @FindBys(value = {@FindBy(className = "resultcontainer")})
  List<WebElement> search_result;

  // click sort by list
  public boolean search_results_Present() {
    boolean found = false;
    for (WebElement we : search_result) {
      if (we.getAttribute("class").contains("resultcontainer") && !we.isDisplayed()) {
        found = true;
        break;
      }
    }
    return found;
  }

  // Lookup link elements
  @FindBys(value = {@FindBy(tagName = "a")})
  List<WebElement> linkElements;

  // get search results by name
  public List<String> get_properties_displayed_by_name() {
    List<String> all_props = new ArrayList<>();
    for (WebElement we : linkElements) {
      if (we.getAttribute("class").equals("hwta-property-link") && we.isDisplayed()
          && !we.getText().contains("Dorms From") && !we.getText().contains("Privates From")) {
        all_props.add(we.getText());
      }
    }
    return all_props;
  }

  // get search result list by price
  public List<String> get_properties_displayed_by_price() {
    List<String> all_props = new ArrayList<>();
    for (WebElement we : linkElements) {
      if (we.getAttribute("class").equals("hwta-property-link") && we.isDisplayed()
          && !we.getText().contains("Dorms From") && !we.getText().contains("Privates From")) {
        all_props.add(we.getText());
      }
    }
    return all_props;
  }

  /**
   * Provides condition when page can be considered as fully loaded.
   *
   * @return
   */

  @Override
  protected ExpectedCondition<ObjectsPage> getPageLoadCondition() {
    return getPageLoadCondition();
  }

  @Override
  public String getPageUrl() {
    // TODO Auto-generated method stub
    return null;
  }

}
