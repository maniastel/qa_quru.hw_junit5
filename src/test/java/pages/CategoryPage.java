package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CategoryPage {

    private SelenideElement sortingButton = $(".a-button-text.a-declarative");


    public CategoryPage checkExistedProductInCategory () {
        $$("[data-component-type='s-search-result']").shouldHave(sizeGreaterThan(0));
        return this;
    }

    public CategoryPage changeProductSorting (String value) {
        sortingButton.click();
        $(withTagAndText("a", value)).click();
        $(".a-dropdown-prompt").shouldHave(text(value));

        return this;
    }

    public CategoryPage checkProductSorting (String price) {
        $$("[data-component-type='s-search-result']").shouldHave(sizeGreaterThan(0));
        $$("[data-component-type='s-search-result']").first().shouldHave(text(price));
        return this;
    }



}
