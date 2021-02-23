package com.aotech.SeleniumDomain.Services;

import com.aotech.SeleniumDomain.Common.IService;
import com.aotech.SeleniumDomain.Common.IToolingRepository;
import com.aotech.SeleniumDomain.Common.Service;
import org.openqa.selenium.By;

public class AddProductToCartService extends Service {

  private InspectProductDetailsService _inspectProductDetailsService;
  private String _targetProductName;
  private String _targetCategoryName;

  public AddProductToCartService(
      IToolingRepository<By> repository, IService inspectProductDetailsService) {
    super(repository);
    _inspectProductDetailsService = (InspectProductDetailsService) inspectProductDetailsService;
  }

  public void initParams(String targetProduct, String categoryProduct) {
    this._targetProductName = targetProduct;
    this._targetCategoryName = categoryProduct;
    _inspectProductDetailsService.initParams(_targetProductName, _targetCategoryName);
  }

  @Override
  public void execute() {
    _inspectProductDetailsService.execute();
    _repository.clickElement("Add to Cart", "button");
  }
}
