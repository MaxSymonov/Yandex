package ru.testing.yandex.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import ru.testing.yandex.model.Search;

public class SearchHelper extends HelperBase {
    public SearchHelper(WebDriver wd) {
        super(wd);
    }

    public void searchMarket(Search search) throws InterruptedException {
        switchToNewTab(By.xpath("//a[@data-id='market']"));
        click(By.xpath("//div[@role='tablist']//div[7]"));
        click(By.xpath("//ul[@data-autotest-id='subItems']//li[3]"));
        click(By.xpath("//div[@data-zone-name='all-filters-button']//span[1]"));
        waitAndType(By.xpath("//input[@placeholder='187']"), search.getPriceFrom());
        waitAndType(By.xpath("//input[@placeholder='508 338']"), search.getPriceTo());
        WebElement element = wd.findElement(By.xpath("//*[@id='153043']/input[@tabindex='0']"));

        Actions actions = new Actions(wd);
        actions.moveToElement(element).click().build().perform();
        click(By.xpath("//a[contains(text(),'Показать')]"));

        WebElement secondSearchResult = wd.findElement(By.xpath("//article[2]//span[@data-tid]"));
        String searchStr = secondSearchResult.getText();
        click(By.xpath("//input[@id='header-search']"));
        wd.findElement(By.xpath("//input[@id='header-search']"));
        wd.findElement(By.xpath("//input[@id='header-search']")).sendKeys(searchStr);
        click(By.xpath("//button[@type='submit']"));
        Thread.sleep(5000);

        String searchField = wd.findElement(By.xpath("//*[@id='header-search']")).getAttribute("value");
        Assert.assertEquals(searchStr, searchField);

    }

}
