package ru.testing.yanex.tests;

import org.testng.annotations.Test;
import ru.testing.yanex.model.Search;

public class SearchTests extends TestBase{

    @Test
    public void tests() throws InterruptedException {
        app.getSearchHelper().searchMarket(new Search().setPriceFrom("20000").setPriceTo("35000"));
    }
}



