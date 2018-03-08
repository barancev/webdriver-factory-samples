package ru.stqa.selenium.factory.samples;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.selenium.factory.WebDriverPool;

public class VariousBrowsersWebDriverSample {

  @AfterAll
  public static void stopAllBrowsers() {
    WebDriverPool.DEFAULT.dismissAll();
  }

  @Test
  public void testFirefox() {
    doSomething(WebDriverPool.DEFAULT.getDriver(new FirefoxOptions()));
  }

  @Test
  public void testInternetExplorer() {
    doSomething(WebDriverPool.DEFAULT.getDriver(new InternetExplorerOptions()));
  }

  @Test
  public void testChrome() {
    doSomething(WebDriverPool.DEFAULT.getDriver(new ChromeOptions()));
  }

  @Test
  public void testSafari() {
    doSomething(WebDriverPool.DEFAULT.getDriver(new SafariOptions()));
  }

  private void doSomething(WebDriver driver) {
    driver.get("http://seleniumhq.org/");
    driver.findElement(By.name("q")).sendKeys("selenium");
    driver.findElement(By.id("submit")).click();
    new WebDriverWait(driver, 30).until(
        ExpectedConditions.titleContains("Google Custom Search"));
  }

}
