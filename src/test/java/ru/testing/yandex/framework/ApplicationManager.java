package ru.testing.yandex.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    public WebDriver wd;

    SearchHelper searchHelper;

    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        File file = new File("C:/Program Files/webdrivers/msedgedriver.exe");
        System.setProperty("webdriver.edge.driver", file.getAbsolutePath());

        if (browser.equals(BrowserType.EDGE)) {
            wd = new EdgeDriver();
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
