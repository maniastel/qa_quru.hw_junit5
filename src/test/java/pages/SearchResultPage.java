package tests.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultPage {

    private SelenideElement searchTermTitle = $(".a-color-state.a-text-bold");

    public SearchResultPage checkSearchTerm (String value) {
        searchTermTitle.shouldHave(text(value));

        return this;
    }

    public SearchResultPage checkNotEmptyResult (String value) {
        $$("[data-component-type='s-search-result']").shouldHave(sizeGreaterThan(0));
        $$("[data-component-type='s-search-result']").first().shouldHave(text(value));

        return this;
    }


}
