
package step;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import amazon.pages.*;

public class Exercise2Steps {

    @Given("Fuck this shit")
    public void fuck_this_shit() {
        HomePage homePage = new HomePage();
        homePage.verify_home_page();
    }

    @Given("User is in Amazon's homepage")
    public void user_is_in_amazon_s_homepage() {
        HomePage homePage = new HomePage();
        homePage.verify_home_page();
    }
    @When("Tools print message on hover")
    public void tools_print_message_on_hover() throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.hover_searchbox();
    }
    @When("User clicks all in dropdown")
    public void user_clicks_all_in_dropdown() throws InterruptedException  {
        HomePage homePage = new HomePage();
        homePage.click_all();
    }
    @When("Tools print list of values")
    public void tools_print_list_of_values() {
        HomePage homePage = new HomePage();
        homePage.print_dropdown_options();
    }
}
