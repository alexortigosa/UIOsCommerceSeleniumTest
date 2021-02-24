package com.aotech.SeleniumDomain.Repositories;

import com.aotech.SeleniumDomain.Common.IToolingRepository;
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
}
