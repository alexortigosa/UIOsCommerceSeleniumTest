package com.aotech.osCommerceSelenium;

import com.aotech.SeleniumDomain.UseCases.AddSamsunToCartUseCase;
import com.aotech.SeleniumDomain.UseCases.InspectGalaxyTabDetailsUseCase;
import com.aotech.SeleniumDomain.UseCases.SearchSamsungUseCase;
import com.aotech.SeleniumDomain.UseCases.UseCaseFactory;
import com.aotech.SeleniumDomain.UseCases.UseCaseFactory.UseCase;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

class MainPageTest {

  private static WebDriver _driver = null;
  private static ChromeOptions _chromeOptions;

  @BeforeAll
  public static void setUpAllure() {

    SelenideLogger.addListener("allure", new AllureSelenide());
    WebDriverManager.chromedriver().setup();
    ArrayList<String> optionsList = new ArrayList<String>();
    _chromeOptions = new ChromeOptions();
    optionsList.add("--start-maximized");
    optionsList.add("--incognito");
    optionsList.add("disable-notifications");
    optionsList.add("--no-sandbox");
    optionsList.add("--disable-dev-shm-usage");
    optionsList.add("--headless");
    _chromeOptions.addArguments(optionsList);
    _chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
    _chromeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

  }

  @BeforeEach
  public void setUp() {
    _driver = new ChromeDriver(_chromeOptions);
    _driver.get("https://demo.oscommerce.com/");
  }

  @AfterEach
  void tearDown() throws Exception {
    _driver.quit();
  }

  @Test
  public void searchSamsungTestCas() throws Exception {
    SearchSamsungUseCase searchSamsungUseCase = (SearchSamsungUseCase) UseCaseFactory
        .getUseCase(UseCase.SEARCH_SAMSUNG_USE_CASE, _driver);
    searchSamsungUseCase.execute();

  }

  @Test
  void inspectSamsungDetailsTestCase() throws Exception {

    InspectGalaxyTabDetailsUseCase inpectProductUseCase = (InspectGalaxyTabDetailsUseCase) UseCaseFactory
        .getUseCase(UseCase.INSPECT_SAMSUNG_DETAILS_USE_CASE, _driver);
    inpectProductUseCase.execute();
  }

  @Test
  void addSamsungToCartTestCase() throws Exception {

    AddSamsunToCartUseCase addTestCase = (AddSamsunToCartUseCase) UseCaseFactory
        .getUseCase(UseCase.ADD_SAMSUNG_TO_CART_USE_CASE, _driver);
    addTestCase.execute();
  }

}
