package tests.pages;

import com.codeborne.selenide.SelenideElement;
import tests.components.SearchBar;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CategoryPage {


    public CategoryPage checkExistedProductInCategory () {
        $$("[data-component-type='s-search-result']").shouldHave(sizeGreaterThan(0));
        return this;
    }


}
