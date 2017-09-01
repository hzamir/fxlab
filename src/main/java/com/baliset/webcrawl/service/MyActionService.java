package com.baliset.webcrawl.service;

import org.springframework.stereotype.Component;

@Component
public class MyActionService implements AwesomeActionService
{

  @Override
  public String processName(final String name) {
    if(name.equals("Anton")) {
      return "Hello Anton!";
    }
    else {
      return "Hello Unknown Stranger!";
    }
  }

}