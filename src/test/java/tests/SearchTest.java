package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.SearchResultPage;
import pages.components.SearchBar;

import static com.codeborne.selenide.Selenide.open;

public class SearchTest extends TestBase {
    SearchBar searchBar = new SearchBar();
    SearchResultPage searchResultPage = new SearchResultPage();

    @BeforeEach
    public void setUp() {
        open("https://www.amazon.com/ref=nav_bb_logo");
    }

    @ValueSource(strings = {
            "table", "chair", "mug"
    })
    @ParameterizedTest(name = "Успешный поиск товара по поисковому запросу: {0}")
    @Tag("SMOKE")
    public void successfulProductSearchTest (String searchTerm) {
        searchBar.setSearchTerm(searchTerm);
        searchResultPage.checkSearchTerm(searchTerm)
                .checkNotEmptyResult(searchTerm);
    }

}
