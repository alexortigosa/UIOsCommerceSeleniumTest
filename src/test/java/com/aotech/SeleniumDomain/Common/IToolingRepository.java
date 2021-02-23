package com.aotech.SeleniumDomain.Common;

public interface IToolingRepository<T> {

  String getTitle(T filter);

  void clickElement(String target, String type);

  void clickElement(String xpathTarget);

  void setInput(String inputXpathTarget, String text);

  void executeScript(T filter, String script);

  void acceptDialog();

  void sleep() throws InterruptedException;
}
