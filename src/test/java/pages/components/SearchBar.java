package tests.components;

import com.codeborne.selenide.SelenideElement;
import tests.pages.CategoryPage;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class SearchBar {

    private SelenideElement searchInput = $("#twotabsearchtextbox"),
                            searchButton = $("#nav-search-submit-button"),
                            searchDropDownSelect = $("#searchDropdownBox");

    public SearchBar checkSelectedCategoryInSearchBar (String value) {
        searchDropDownSelect.$(withTagAndText("option", value)).shouldHave(attribute("selected"));

        return this;
    }

    public SearchBar setSearchTerm (String value) {
        searchInput.setValue(value);
        searchButton.click();

        return this;
    }
}
