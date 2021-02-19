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
    SEARCH_PRODUCT_USE_CASE,
    INSPECT_PRODUCT_DETAILS_USE_CASE
  }

  public static IUseCase getUseCase(UseCase useCase, WebDriver driver) throws Exception {
    IToolingRepository<By> seleniumRepository = new SeleniumToolingRepository(driver);
    switch (useCase) {
      case SEARCH_PRODUCT_USE_CASE:
        return new SearchProductUseCase(ServiceFactory.getService(Service.GO_TO_SERVICE, driver));
      case INSPECT_PRODUCT_DETAILS_USE_CASE:
        return new InspectProductDetailsUseCase(
            ServiceFactory.getService(Service.GO_TO_SERVICE, driver),
            ServiceFactory.getService(Service.GO_TO_SERVICE, driver));
      default:
        throw new Exception("The use case not exist");
    }
  }
}
