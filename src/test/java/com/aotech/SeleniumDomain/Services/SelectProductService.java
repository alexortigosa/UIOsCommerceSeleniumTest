package com.aotech.SeleniumDomain.Services;

import com.aotech.SeleniumDomain.Common.IToolingRepository;
import com.aotech.SeleniumDomain.Common.Service;
import org.openqa.selenium.By;

public class SelectProductService extends Service {

  public SelectProductService(
      IToolingRepository<By> repository) {
    super(repository);
  }

  @Override
  public void execute() {

  }
}
