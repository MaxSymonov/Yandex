package ru.testing.yanex.tests;

import org.testng.annotations.Test;

public class SearchTests extends TestBase{

    @Test
    public void tests() throws InterruptedException {
        app.getSearchHelper().searchMarket();
    }
}
