package com.aotech.SeleniumDomain.Common;

public interface IToolingRepository<T> {

  String getTitle(T filter);

  void clickButton(String target, String type);

  void setInput(T filter);

  void executeScript(T filter, String script);

  void acceptDialog();

  void sleep() throws InterruptedException;
}
