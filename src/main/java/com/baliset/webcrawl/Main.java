package com.baliset.webcrawl;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;

@SpringBootApplication
public class Main extends AbstractJavaFxApplicationSupport{

  public static void main(String[] args) {
    launchApp(Main.class, CrawlView.class, new CrawlSplash(), args);
  }
}