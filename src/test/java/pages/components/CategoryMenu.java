package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CategoryMenu {
        private SelenideElement allButton = $("#nav-hamburger-menu"),
                menuTitle = $("#hmenu-customer-name");


        public CategoryMenu openCategoryMenu () {
            allButton.click();
            menuTitle.shouldHave(text("Hello"));
            return this;
        }

        public CategoryMenu selectRootCategory (String value) {
            $(byTagAndText("div", value)).click();
            $$(".hmenu.hmenu-visible.hmenu-translateX li").get(1).shouldHave(text(value.toLowerCase()));
            return this;

        }

        public CategoryMenu selectSubcategory (String value) {
            $$(".hmenu.hmenu-visible.hmenu-translateX li a").filterBy(text(value)).get(1).click();
            return this;
        }

}

