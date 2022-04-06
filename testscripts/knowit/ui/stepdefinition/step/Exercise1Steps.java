
package step;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import knowit.pages.*;

import java.io.IOException;

public class Exercise1Steps{

    @Given("User is in KnowIt's homepage")
    public void user_opens_knowit_homepage()
    {
        HomePage homePage = new HomePage();
        homePage.verify_home_page();
    }

    @When("User clicks search option")
    public void user_clicks_search_option()
    {
        HomePage homePage = new HomePage();
        homePage.click_search_option();
    }

    @When("Tool gets default value in search box")
    public void tool_gets_default_value_in_search_box()
    {
        HomePage homePage = new HomePage();
        homePage.get_search_box_value();
    }

    @When("User types automation in search box")
    public void user_types_automation_in_search_box() {
        HomePage homePage = new HomePage();
        homePage.type_string_search_box();
    }

    @When("User press enter")
    public void user_press_enter() {
        HomePage homePage = new HomePage();
        homePage.keyboard_enter();
    }

    @When("User scroll down the page")
    public void user_scroll_down_the_page() {
        HomePage homePage = new HomePage();
        homePage.scroll_down();
    }

    @When("User clicks Facebook icon")
    public void user_clicks_facebook_icon() {
        HomePage homePage = new HomePage();
        homePage.click_facebook_icon();
    }

    @When("User closes newly opened tab")
    public void user_closes_newly_opened_tab() throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.close_recently_opened_tab();
    }

    @When("User navigates back to original tab")
    public void user_navigates_back_to_original_tab()  throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.navigate_to_original_tab_scroll_up();
    }

    @Then("User takes screenshot")
    public void user_takes_screenshot() throws IOException {
        HomePage homePage = new HomePage();
        homePage.take_screenshot();
    }

}
