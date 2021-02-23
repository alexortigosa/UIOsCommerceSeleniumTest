package com.aotech.SeleniumDomain.UseCases;

import com.aotech.SeleniumDomain.Common.IToolingRepository;
import com.aotech.SeleniumDomain.Common.IUseCase;
import com.aotech.SeleniumDomain.Repositories.SeleniumToolingRepository;
import com.aotech.SeleniumDomain.Services.ServiceFactory;
import com.aotech.SeleniumDomain.Services.ServiceFactory.Service;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UseCaseFactory {

  public static enum UseCase {
    SEARCH_SAMSUNG_USE_CASE,
    INSPECT_SAMSUNG_DETAILS_USE_CASE,
    ADD_SAMSUNG_TO_CART_USE_CASE
  }

  public static IUseCase getUseCase(UseCase useCase, WebDriver driver) throws Exception {
    IToolingRepository<By> seleniumRepository = new SeleniumToolingRepository(driver);
    switch (useCase) {
      case SEARCH_SAMSUNG_USE_CASE:
        return new SearchSamsungUseCase(
            ServiceFactory.getService(Service.SEARCH_PRODUCT_SERVICE, driver));
      case INSPECT_SAMSUNG_DETAILS_USE_CASE:
        return new InspectGalaxyTabDetailsUseCase(
            ServiceFactory.getService(Service.INSPECT_PRODUCT_DETAIL_SERVICE, driver));
      case ADD_SAMSUNG_TO_CART_USE_CASE:
        return new AddSamsunToCartUseCase(
            ServiceFactory.getService(Service.ADD_PRODUCT_TO_CART, driver));
      default:
        throw new Exception("The use case not exist");
    }
  }
}
