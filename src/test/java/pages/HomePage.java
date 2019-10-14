package pages;

import baseFunc.BaseFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;


public class HomePage {


    private BaseFunc baseFunc;
    private final By SECTIONS = By.xpath("//ul[@id='menu-product-menu1']/li");

    private List<WebElement> sections;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }


    public void selectProductBy(String gender, String division, String product) {
        baseFunc.waitUntilVisible(SECTIONS);
        sections = baseFunc.getAllElements(SECTIONS);
        for (int i = 0; i < sections.size(); i++) {
            if (sections.get(i).getText().equals(gender)) {
                sections.get(i).click();
                List<WebElement> divisions = sections.get(i).findElements(By.tagName("a"));
                for (int j = 0; j < divisions.size(); j++) {
                    if (divisions.get(j).getText().equals(division)) {
                        for (int k = j + 1; k < divisions.size(); k++) {
                            if (divisions.get(k).getText().equals(product)) {
                                divisions.get(k).click();
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            }
        }
    }
}





//    boolean discount = true;
//        if (List<WebElement> selectedProducts = baseFunc.getAllElements(PRODUCTS).contains(DISCOUNTS)) {
//            System.out.println("All products have a discount");
//        }
//            else {
//            System.out.println("There are products without a discount");
//    }



//    public WebElement sortProductsBy(String priceFilter) {
//        this.WebElement Webelement;
//        baseFunc driver;
//        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(By.tagName("select"))).click();
//        Select select = new Select(By.tagName("//select//option"));
//        select.selectByVisibleText(priceFilters);
//        return;
//    }

    //        Actions sorting = new Actions(baseFunc.select();
//        driver.findElement(By.ByTagName("select")).click();
//        Action selectObject = sorting.moveToElement(findElement(By.ByLinkText(priceFilter))).click().build();
//        selectObject.perform();





