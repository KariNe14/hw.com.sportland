package pages;

import baseFunc.BaseFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BoysShoes {


    private BaseFunc baseFunc;
    private final By PRODUCTS = By.xpath("//div[@class='spodb-products-grid__item']/a[@class='spodb-product-card']");
    private final By PRICE_FILTER = By.xpath("//div[@class='spodb-filter__select']");
    private final By PRICE_FILTER_OPTIONS = By.xpath("//div[@class='spodb-filter__select']//select/option");
    private final By FILTERS = By.xpath("//div[@class = 'spodb-filter']//label");
    private final By DISCOUNTS = By.xpath("//p[@class='spodb-product-card__percentage']");

    private List<WebElement> priceFilters;
    private List<WebElement> filteredProducts;
    private List<WebElement> productsWithDiscount;
    private List<WebElement> productFilters;

    public BoysShoes(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void sortProductsBy(String priceFilter) {
        baseFunc.waitUntilVisible(PRODUCTS);
        baseFunc.getElement((PRICE_FILTER)).click();
        priceFilters = baseFunc.getAllElements(PRICE_FILTER_OPTIONS);
        for (int i = 0; i < priceFilters.size(); i++) {
            if (priceFilters.get(i).getText().equals(priceFilter)) {
                priceFilters.get(i).click();
                baseFunc.getElement((PRICE_FILTER)).click();
                baseFunc.waitUntilVisible(PRODUCTS);
                break;
            }
        }
    }

    public void selectProductFilter(List<String> filterNames) {
        baseFunc.waitUntilVisible(FILTERS);
        productFilters = baseFunc.getAllElements(FILTERS);
        System.out.println(productFilters);
        for (int i = 0; i < productFilters.size(); i++) {
            for (int j = 0; j < filterNames.size(); j++) {
                if (productFilters.get(i).getText().equals(filterNames.get(j))) {
                    productFilters.get(i).click();
//                    baseFunc.waitFor10Sec();
                }
            }
        }
    }

    public void checkProductBrand (String brand){
        baseFunc.waitUntilVisible(PRODUCTS);
        filteredProducts = baseFunc.getAllElements(PRODUCTS);
        for (int i = 0; i < filteredProducts.size(); i++) {
            assertThat(filteredProducts.get(i).getText()).startsWith(brand);
            System.out.println("All products are from " + brand);

        }
    }

    public void checkProductDiscount (){
//        baseFunc.waitUntilVisible(PRODUCTS);
        filteredProducts = baseFunc.getAllElements(PRODUCTS);
        for (int i = 0; i < filteredProducts.size(); i++) {
            assertThat(filteredProducts.get(i).getText()).contains("%");
            System.out.println(filteredProducts.get(i).getText());
//            productsWithDiscount = baseFunc.getAllElements(DISCOUNTS);
//            assertThat(filteredProducts.size()).isEqualTo(productsWithDiscount.size());
//            System.out.println(filteredProducts.get(i).getText());
        }
    }



}
