package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import pages.components.CategoryMenu;
import pages.components.SearchBar;
import pages.CategoryPage;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.open;

@DisplayName("Тесты на странице категории")
public class CategoryTest extends TestBase {

    CategoryMenu categoryMenu = new CategoryMenu();
    SearchBar searchBar = new SearchBar();
    CategoryPage categoryPage = new CategoryPage();

    @BeforeEach
    public void setUp() {
        open("https://www.amazon.com/ref=nav_bb_logo");
    }

    @CsvFileSource(resources = "/test_data/data.csv")
    @ParameterizedTest(name = "Проверка отображения товаров на странице категории: {0}/{1}")
    @Tag("BLOCKER")
    public void CategoryShouldHaveProductsTest (String category, String subcategory) {
        categoryMenu.openCategoryMenu()
                .selectRootCategory(category)
                .selectSubcategory(subcategory);
        searchBar.checkSelectedCategoryInSearchBar(subcategory);
        categoryPage.checkExistedProductInCategory();

    }

    static Stream<Arguments> productSortingOnCategoryPage () {
        return Stream.of(
                Arguments.of(
                        "Electronics", "Accessories & Supplies", "Price: Low to High"),
                Arguments.of(
                        "Computers", "Data Storage", "Price: High to Low")
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Сортировка товаров по {2} на странице категории {0}/{1}")
    @Tag("SMOKE")
    public void productSortingOnCategoryPage (String category, String subcategory, String sortingOption) {
        categoryMenu.openCategoryMenu()
                .selectRootCategory(category)
                .selectSubcategory(subcategory);
        searchBar.checkSelectedCategoryInSearchBar(subcategory);
        categoryPage.changeProductSorting(sortingOption);
    }







}
