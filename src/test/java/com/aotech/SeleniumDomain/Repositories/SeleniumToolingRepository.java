package com.aotech.SeleniumDomain.Repositories;

import com.aotech.SeleniumDomain.Common.IToolingRepository;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumToolingRepository implements IToolingRepository<By> {

  private static WebDriver _driver = null;
  private static final int ESPERA = 10;
  private static WebDriverWait _wait;

  public SeleniumToolingRepository(WebDriver driver) {
    if (driver == null) {
      throw new InvalidArgumentException("Driver must not be null");
    }
    this._driver = driver;
    this._wait = new WebDriverWait(driver, ESPERA);
  }

  @Override
  public String getTitle(By filter) {
    WebElement h1Element = this._driver.findElement(filter);
    return h1Element.getText();
  }

  @Override
  public void clickElement(String target, String type) {
    WebElement nextButton = this._driver
        .findElement(By.xpath(String.format("//%s[contains(.,\"%s\")]", type, target)));
    this._wait.until(ExpectedConditions.elementToBeClickable(nextButton));
    nextButton.click();
  }

  @Override
  public void clickElement(String xpathTarget) {
    WebElement nextButton = this._driver
        .findElement(By.xpath(xpathTarget));
    //this._wait.until(ExpectedConditions.elementToBeClickable(nextButton));
    nextButton.click();
  }

  @Override
  public void setInput(String inputXpathTarget, String text) {
    WebElement inputText = this._driver.findElement(By.xpath(inputXpathTarget));
    inputText.sendKeys(text);
  }

  @Override
  public void executeScript(By filter, String script) {
    WebElement inputText = this._driver.findElement(filter);
    inputText.sendKeys(script);
  }

  @Override
  public void acceptDialog() {
    Alert javascriptAlert = this._driver.switchTo().alert();
    javascriptAlert.accept();
  }

  @Override
  public void sleep() throws InterruptedException {
    Thread.sleep(2000);
  }
}
