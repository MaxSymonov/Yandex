package ru.testing.yandex.tests;

import org.testng.annotations.Test;
import ru.testing.yandex.model.Search;

public class SearchTests extends TestBase{

    @Test(dataProvider = "search", dataProviderClass = DataProviders.class)
    public void searchTest(String priceFrom, String priceTo) throws InterruptedException {
        Search search = new Search().setPriceFrom(priceFrom).setPriceTo(priceTo);
        app.getSearchHelper().searchMarket(search);
    }
}



