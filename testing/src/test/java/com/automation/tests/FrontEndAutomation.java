package com.automation.tests;

import java.net.MalformedURLException;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.pageObjects.BasePage;
import com.automation.pageObjects.HomePage;
import com.automation.pageObjects.ObjectsPage;


public class FrontEndAutomation extends BasePage<FrontEndAutomation> {

  @Test(
      description = "User Searches for Available properties in ‘Dublin, Ireland’ on the Hostelworld Site and sorts the results by Name")
  public void search_and_sort_result_by_name() throws MalformedURLException, InterruptedException {

    // initialize elements of the ObjectsPage class
    ObjectsPage test = new ObjectsPage();
    PageFactory.initElements(getDriver("browser"), test);

    // initialize elements of the HomePage class
    HomePage home = new HomePage().open();

    // input search in text field
    home.search_by_city_or_hotel("Dublin, Ireland");
    home.select("Dublin, Ireland");
    Assert.assertTrue(home.search_bar_text("Dublin, Ireland"));
    // click search
    home.search();

    // get unsorted search results
    List<String> unsortedList = test.get_properties_displayed_by_name();

    List<String> sort_after_search = test.get_properties_displayed_by_name();
    // Sort the list manually
    Collections.sort(sort_after_search);

    // click sort and sort by name in the drop down list
    test.sort();
    test.sort_by("Name");
    // get sorted search results
    List<String> sortedList = test.get_properties_displayed_by_name();

    // confirm sorted search result matches manually sorted list
    Assert.assertTrue(sort_after_search.equals(sortedList));
    Assert.assertTrue(!unsortedList.equals(sortedList));
    System.out.println(unsortedList);
    System.out.println(sortedList);

  }

  @Test( description = "User Searches for Available properties in ‘Dublin, Ireland’ by Price")
  public void search_and_sort_result_by_price() throws MalformedURLException, InterruptedException {

    // initialize elements of the ObjectsPage class
    ObjectsPage test = new ObjectsPage();
    PageFactory.initElements(getDriver("browser"), test);

    // initialize elements of the HomePage class
    HomePage home = new HomePage().open();

    // input search in text field
    home.search_by_city_or_hotel("Dublin, Ireland");
    home.select("Dublin, Ireland");
    Assert.assertTrue(home.search_bar_text("Dublin, Ireland"));
    // click search
    home.search();

    // get unsorted search results
    List<String> unsortedList = test.get_properties_displayed_by_price();
    System.out.println(unsortedList);

    // click sort and sort by name in the drop down list
    test.sort();
    test.sort_by("Name");
    // get sorted search results
    List<String> sortedList = test.get_properties_displayed_by_price();
    System.out.println(sortedList);

    // confirm sorted search result matches manually sorted list
    Assert.assertTrue(!unsortedList.equals(sortedList));

  }

  @Override
  protected ExpectedCondition<FrontEndAutomation> getPageLoadCondition() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getPageUrl() {
    // TODO Auto-generated method stub
    return null;
  }

}
