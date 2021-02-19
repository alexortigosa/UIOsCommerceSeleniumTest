package com.aotech.SeleniumDomain.UseCases;

import com.aotech.SeleniumDomain.Common.UseCase;
import com.aotech.SeleniumDomain.Services.GoToService;
import com.aotech.SeleniumDomain.Common.IService;

public class SearchProductUseCase extends UseCase {

  private GoToService _goToService;
  private String _targetProductName;

  public SearchProductUseCase(IService goToService) {
    this._goToService = (GoToService) goToService;
  }

  public void initParams(String targetProduct) {
    this._targetProductName = targetProduct;
    this._goToService.initParams(_targetProductName);
  }

  @Override
  public void execute() throws Exception {
    if (this._targetProductName == null) {
      throw new Exception("You must initiate the use case before execute");
    }
    _goToService.execute();
  }
}
