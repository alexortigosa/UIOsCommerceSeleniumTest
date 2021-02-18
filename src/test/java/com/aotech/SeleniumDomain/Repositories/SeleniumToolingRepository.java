package com.aotech.SeleniumDomain.Repositories;

import org.openqa.selenium.*;

public class SeleniumToolingRepository implements IToolingRepository<By> {

  private static WebDriver _driver = null;

  public SeleniumToolingRepository(WebDriver driver) {
    if (driver == null) {
      throw new InvalidArgumentException("Driver must not be null");
    }
    _driver = driver;
  }

  @Override
  public String getTitle(By filter) {
    WebElement h1Element = _driver.findElement(filter);
    return h1Element.getText();
  }

  @Override
  public void clickButton(By filter) {
    WebElement nextButton = _driver.findElement(filter);
    nextButton.click();
  }

  @Override
  public void setInput(By filter) {
    WebElement nextButton = _driver.findElement(filter);
    nextButton.click();
  }

  @Override
  public void executeScript(By filter, String script) {
    WebElement inputText = _driver.findElement(filter);
    inputText.sendKeys(script);
  }

  @Override
  public void acceptDialog() {
    Alert javascriptAlert = _driver.switchTo().alert();
    javascriptAlert.accept();
  }

  @Override
  public void sleep() throws InterruptedException {
    Thread.sleep(2000);
  }
}
