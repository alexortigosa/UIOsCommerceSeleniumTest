package com.aotech.SeleniumDomain.Services;

import com.aotech.SeleniumDomain.Common.IService;
import com.aotech.SeleniumDomain.Common.IToolingRepository;
import com.aotech.SeleniumDomain.Common.Service;
import org.openqa.selenium.By;

public class InspectProductDetailsService extends Service {

  private String _targetProductName;
  private String _targetCategoryName;

  public InspectProductDetailsService(
      IToolingRepository<By> repository) {
    super(repository);
  }

  public void initParams(String targetProduct, String categoryProduct) {
    this._targetProductName = targetProduct;
    this._targetCategoryName = categoryProduct;
  }

  @Override
  public void execute() {
    this._repository.clickButton(_targetCategoryName, "a");
    this._repository.clickButton(_targetProductName, "a");
  }
}
