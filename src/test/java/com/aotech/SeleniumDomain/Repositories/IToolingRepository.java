package com.aotech.SeleniumDomain.Repositories;

public interface IToolingRepository<T> {
    String getTitle(T filter);
    void clickButton(T filter);
    void setInput(T filter);
    void executeScript(T filter, String script);
    void acceptDialog();
    void sleep();
}
