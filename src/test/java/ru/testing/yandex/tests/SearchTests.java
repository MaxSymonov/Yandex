package ru.testing.yandex.tests;

import org.testng.annotations.Test;
import ru.testing.yandex.model.Search;

public class SearchTests extends TestBase{

    @Test(dataProvider = "search", dataProviderClass = DataProviders.class)
    public void searchTest(Search search) throws InterruptedException {
        app.getSearchHelper().searchMarket(search);
    }
}



