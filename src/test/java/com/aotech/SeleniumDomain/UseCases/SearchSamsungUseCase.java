package com.aotech.SeleniumDomain.UseCases;

import com.aotech.SeleniumDomain.Common.IService;
import com.aotech.SeleniumDomain.Common.UseCase;
import com.aotech.SeleniumDomain.Services.SearchProductService;

public class SearchSamsungUseCase extends UseCase {

  private SearchProductService _searchService;
  private String _targetProductName = "Samsung Galaxy Tab";

  public SearchSamsungUseCase(IService searchService) {
    this._searchService = (SearchProductService) searchService;
    this._searchService.initParams(_targetProductName);
  }

  @Override
  public void execute() throws Exception {
    _searchService.execute();
  }
}
