package com.aotech.osCommerceSelenium;

import com.aotech.SeleniumDomain.UseCases.InspectProductDetailsUseCase;
import com.aotech.SeleniumDomain.UseCases.SearchProductUseCase;
import com.aotech.SeleniumDomain.UseCases.UseCaseFactory;
import com.aotech.SeleniumDomain.UseCases.UseCaseFactory.UseCase;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import java.util.ArrayList;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPageTest {

  private final MainPage mainPage = new MainPage();
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
  public void search() throws Exception {
    SearchProductUseCase searchProductUseCase = (SearchProductUseCase) UseCaseFactory
        .getUseCase(UseCase.SEARCH_PRODUCT_USE_CASE, _driver);
    searchProductUseCase.initParams("Samsung Galaxy Tab");
    searchProductUseCase.execute();

  }

  @Test
  public void inspectProductDetails() throws Exception {

    InspectProductDetailsUseCase inpectProductUseCase = (InspectProductDetailsUseCase) UseCaseFactory
        .getUseCase(UseCase.INSPECT_PRODUCT_DETAILS_USE_CASE, _driver);
    inpectProductUseCase.initParams("Samsung Galaxy Tab", "Gadgets");
    inpectProductUseCase.execute();
  }

}
