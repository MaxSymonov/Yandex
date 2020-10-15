package ru.testing.yanex.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    public WebDriver wd;

    SearchHelper searchHelper;

    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if (browser.equals(BrowserType.EDGE)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        }

        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.navigate().to("https://yandex.ru/");

        searchHelper = new SearchHelper(wd);

    }


    public SearchHelper getSearchHelper() {
        return searchHelper;
    }

    public void stop() {
        wd.quit();
    }

}
