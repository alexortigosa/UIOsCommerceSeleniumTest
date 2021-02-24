package com.aotech.SeleniumDomain.Common;

public interface IToolingRepository<T> {
  
  void clickElement(String target, String type);

  void clickElement(String xpathTarget);

  void setInput(String inputXpathTarget, String text);
}
