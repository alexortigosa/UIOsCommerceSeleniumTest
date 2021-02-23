package com.aotech.SeleniumDomain.Services;


import com.aotech.SeleniumDomain.Common.IService;
import com.aotech.SeleniumDomain.Common.IToolingRepository;
import com.aotech.SeleniumDomain.Repositories.SeleniumToolingRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ServiceFactory {

  public static enum Service {
    GO_TO_SERVICE,
    SELECT_PRODUCT_SERVICE,
    INSPECT_PRODUCT_DETAIL_SERVICE,
    SEARCH_PRODUCT_SERVICE
  }

  public static IService getService(Service service, WebDriver driver) throws Exception {
    IToolingRepository<By> seleniumRepository = new SeleniumToolingRepository(driver);
    switch (service) {
      case GO_TO_SERVICE:
        return new GoToService(seleniumRepository);
      case SELECT_PRODUCT_SERVICE:
        return new SelectProductService(seleniumRepository);
      case INSPECT_PRODUCT_DETAIL_SERVICE:
        return new InspectProductDetailsService(seleniumRepository);
      case SEARCH_PRODUCT_SERVICE:
        return new SearchProductService(seleniumRepository,
            getService(Service.GO_TO_SERVICE, driver));
      default:
        throw new Exception("The service not exist");
    }
  }
}
