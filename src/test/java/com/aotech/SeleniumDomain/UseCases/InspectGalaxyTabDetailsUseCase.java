package com.aotech.SeleniumDomain.UseCases;

import com.aotech.SeleniumDomain.Common.UseCase;
import com.aotech.SeleniumDomain.Services.GoToService;
import com.aotech.SeleniumDomain.Common.IService;
import com.aotech.SeleniumDomain.Services.InspectProductDetailsService;

public class InspectGalaxyTabDetailsUseCase extends UseCase {

  private InspectProductDetailsService _inspectProductDetailsService;
  private String _targetProductName = "Samsung Galaxy Tab";
  private String _targetCategoryName = "Gadgets";

  public InspectGalaxyTabDetailsUseCase(IService inspectProductDetailsService) {
    this._inspectProductDetailsService = (InspectProductDetailsService) inspectProductDetailsService;
    this._inspectProductDetailsService.initParams(_targetProductName, _targetCategoryName);
  }


  @Override
  public void execute() throws Exception {
    this._inspectProductDetailsService.execute();
  }
}
