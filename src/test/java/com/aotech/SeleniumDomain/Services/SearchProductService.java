package com.aotech.SeleniumDomain.Services;

import com.aotech.SeleniumDomain.Common.IService;
import com.aotech.SeleniumDomain.Common.IToolingRepository;
import com.aotech.SeleniumDomain.Common.Service;
import org.openqa.selenium.By;

public class SearchProductService extends Service {

  private GoToService _goToService;
  private String _targetProductName;

  public SearchProductService(
      IToolingRepository<By> repository, IService goToService) {
    super(repository);
    _goToService = (GoToService) goToService;
  }

  public void initParams(String targetProduct) {
    this._targetProductName = targetProduct;
    this._goToService.initParams(_targetProductName);
  }

  @Override
  public void execute() {
    //To do, insert product name
    this._goToService.execute();
  }
}
