package com.aotech.SeleniumDomain.Services;


import com.aotech.SeleniumDomain.Common.IService;
import com.aotech.SeleniumDomain.Common.IToolingRepository;
import com.aotech.SeleniumDomain.Repositories.SeleniumToolingRepository;
import org.openqa.selenium.WebDriver;

public class ServiceFactory {

  public static enum Service {
    GO_TO_SERVICE,
    SELECT_PRODUCT_SERVICE,
    INSPECT_PRODUCT_DETAIL_SERVICE,
    SEARCH_PRODUCT_SERVICE,
    ADD_PRODUCT_TO_CART
  }

  public static IService getService(Service service, WebDriver driver) throws Exception {
    IToolingRepository seleniumRepository = new SeleniumToolingRepository(driver);
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
      case ADD_PRODUCT_TO_CART:
        return new AddProductToCartService(seleniumRepository,
            getService(Service.INSPECT_PRODUCT_DETAIL_SERVICE, driver));
      default:
        throw new Exception("The service not exist");
    }
  }
}
