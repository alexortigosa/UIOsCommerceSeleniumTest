package com.aotech.SeleniumDomain.UseCases;

import com.aotech.SeleniumDomain.Common.IService;
import com.aotech.SeleniumDomain.Common.UseCase;
import com.aotech.SeleniumDomain.Services.AddProductToCartService;

public class AddSamsunToCartUseCase extends UseCase {

  private String _targetProductName = "Samsung Galaxy Tab";
  private String _targetCategoryName = "Gadgets";
  private AddProductToCartService _addProductToCartService;

  public AddSamsunToCartUseCase(
      IService addProductToCartService) {
    this._addProductToCartService = (AddProductToCartService) addProductToCartService;
    _addProductToCartService.initParams(_targetProductName, _targetCategoryName);
  }

  @Override
  public void execute() throws Exception {
    _addProductToCartService.execute();
  }
}
