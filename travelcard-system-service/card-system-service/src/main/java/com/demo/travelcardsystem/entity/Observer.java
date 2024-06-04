package com.demo.travelcardsystem.entity;

public interface Observer<T> {
    void reactOnChange(T t);
}
