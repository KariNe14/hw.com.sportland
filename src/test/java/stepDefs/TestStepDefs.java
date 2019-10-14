package stepDefs;

import baseFunc.BaseFunc;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.BoysShoes;
import pages.HomePage;

import java.util.List;

public class TestStepDefs {
    private BaseFunc baseFunc = new BaseFunc();
    private HomePage homePage;
    private BoysShoes boysShoes;

    private String url = "sportland.lv";

    @Given("Sportland homepage")
    public void open_page(){
        baseFunc.getPage(url);
        homePage = new HomePage(baseFunc);
        boysShoes = new BoysShoes(baseFunc);
    }

    @When("select gender {string}, select division {string}, select product {string}")
    public void select_product_by(String gender, String division, String product) {
        homePage.selectProductBy(gender, division, product);
    }

    @When("sort products by price filter {string}")
    public void sort_products_by(String priceFilter){
        boysShoes.sortProductsBy(priceFilter);

    }

    @When("select product filters:")
    public void select_filters (List <String> filters){
        boysShoes.selectProductFilter(filters);
    }


    @Then("assert that all opened products have {string} brand")
    public void assert_that_all_opened_products_have_brand(String brand) {
        boysShoes.checkProductBrand(brand);
}


    @Then("assert that all products contains a discount")
    public void assert_that_all_products_contains_a_discount() {
        boysShoes.checkProductDiscount();
//    throw new cucumber.api.PendingException();
}



/*
    @Then("create text file with all info about products below {string} euro")
    public void create_text_file_with_all_info_about_products_below_euro(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("export to json file")
    public void export_to_json_file() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
*/

//    @When("filter brand {string}, filter shoes_type {string}")
//    public void filter_products_by (String brand, String shoes_type){
//        homePage.filterProductsBy(brand, shoes_type);
//    }


//    @Then("driver quit")
//    public void driver_quit() {
//        baseFunc.quit();
//}


}
