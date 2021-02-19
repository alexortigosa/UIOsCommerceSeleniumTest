package com.aotech.SeleniumDomain.Services;

import com.aotech.SeleniumDomain.Common.IToolingRepository;
import com.aotech.SeleniumDomain.Common.Service;
import org.openqa.selenium.By;

public class GoToService extends Service {

  private String _target;

  public GoToService(
      IToolingRepository<By> repository) {
    super(repository);

  }

  public void initParams(String target) {
    if (target == null) {
      throw new IllegalArgumentException("target must not be null");
    }
    this._target = target;
  }

  @Override
  public void execute() {
    this._repository.clickButton(_target, "a");
  }
}
