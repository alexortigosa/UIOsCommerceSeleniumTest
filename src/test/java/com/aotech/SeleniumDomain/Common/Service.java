package com.aotech.SeleniumDomain.Common;

import org.openqa.selenium.By;

public abstract class Service implements IService {

  protected static IToolingRepository<By> _repository;

  public Service(IToolingRepository<By> repository) {
    if (repository == null) {
      throw new IllegalArgumentException("repository must not be null");
    }
    _repository = repository;
  }

  public abstract void execute();
}
