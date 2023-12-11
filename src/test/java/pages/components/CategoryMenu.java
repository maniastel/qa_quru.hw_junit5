package tests.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CategoryMenu {
        private SelenideElement allButton = $("#nav-hamburger-menu"),
                menuTitle = $("hmenu-customer-name"),
                categoryLink = $(".hmenu-item"),
                categoryTitle = $(".hmenu-item.hmenu-title");


        public CategoryMenu openCategoryMenu () {
            allButton.click();
            menuTitle.shouldHave(text("Hello"));
            return this;
        }

        public CategoryMenu selectRootCategory (String value) {
            categoryLink.$(byTagAndText("div", value)).click();
            categoryTitle.shouldHave(text(value));
            return this;

        }

        public CategoryMenu selectSubcategory (String value) {
            categoryLink.$(byText(value)).click();
            return this;
        }

}

