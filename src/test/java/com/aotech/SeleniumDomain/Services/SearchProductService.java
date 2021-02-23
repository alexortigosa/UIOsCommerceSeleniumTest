package com.aotech.SeleniumDomain.Services;

import com.aotech.SeleniumDomain.Common.IService;
import com.aotech.SeleniumDomain.Common.IToolingRepository;
import com.aotech.SeleniumDomain.Common.Service;
import org.openqa.selenium.By;

public class SearchProductService extends Service {

  private GoToService _goToService;
  private String _targetProductName;
  private String _xpathInput = "//*[@id=\"columnLeft\"]/div[3]/div[2]/form/input[1]";
  private String _xpathSearchButton = "//*[@id=\"columnLeft\"]/div[3]/div[2]/form/input[3]";

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
    _repository.setInput(_xpathInput, _targetProductName);
    _repository.clickElement(_xpathSearchButton);
    this._goToService.execute();
  }
}
