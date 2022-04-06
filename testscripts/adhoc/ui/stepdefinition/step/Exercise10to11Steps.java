
package step;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import adhoc.pages.*;

public class Exercise10to11Steps {

    @Given("User is in w3shools homepage")
    public void user_is_in_w3shools_homepage() {
        HomePage homePage = new HomePage();
        homePage.go_to_w3schools();

    }
    @Then("Tool locates and print all the links")
    public void tool_locates_all_the_links() throws InterruptedException  {
        HomePage homePage = new HomePage();
        homePage.get_and_print_all_links();
    }

    @Given("Tool opens the result.html")
    public void tool_opens_the_result_html() {
        HomePage homePage = new HomePage();
        homePage.go_to_results();
    }
    @Then("Tool prints the values in console")
    public void tool_prints_the_values_in_console() {
        HomePage homePage = new HomePage();
        homePage.print_results();
    }
}
