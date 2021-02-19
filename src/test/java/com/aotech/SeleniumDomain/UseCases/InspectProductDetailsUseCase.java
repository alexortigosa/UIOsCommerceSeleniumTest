package com.aotech.SeleniumDomain.UseCases;

import com.aotech.SeleniumDomain.Common.UseCase;
import com.aotech.SeleniumDomain.Services.GoToService;
import com.aotech.SeleniumDomain.Common.IService;

public class InspectProductDetailsUseCase extends UseCase {

  private GoToService _goToCategoryService;
  private GoToService _goToProductService;
  private String _targetProductName;
  private String _targetCategoryName;

  public InspectProductDetailsUseCase(IService goToCategoryService, IService goToProductService) {
    this._goToProductService = (GoToService) goToProductService;
    this._goToCategoryService = (GoToService) goToCategoryService;
  }

  public void initParams(String targetProduct, String categoryProduct) {
    this._targetProductName = targetProduct;
    this._goToProductService.initParams(_targetProductName);
    this._targetCategoryName = categoryProduct;
    this._goToCategoryService.initParams(_targetCategoryName);
  }

  @Override
  public void execute() throws Exception {
    this._goToCategoryService.execute();
    this._goToProductService.execute();
    int asd = 2;

  }
}
