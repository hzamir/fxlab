package com.baliset.fxlab;

import javafx.scene.control.*;
import org.springframework.beans.factory.annotation.Autowired;

import de.felixroske.jfxsupport.FXMLController;
import javafx.event.Event;
import javafx.fxml.FXML;

@FXMLController
public class HelloworldController
{

  CrawlConfig config;

  @Autowired public HelloworldController(CrawlConfig config)
  {
    this.config = config;
  }

  @FXML public TextField initialUrl;
  @FXML public TextField initialDomain;
  @FXML private TextField outputFormat;      // xml, yaml, or json

  @FXML private CheckBox stayInDomain;     // stay in domain (don't go to another domain)
  @FXML private CheckBox allowSubdomains;  // if inside domain are subdomains ok?
  @FXML private Slider     minutesLimit;     // max time
  @FXML private Slider     depthLimit;       // max depth


  private void populate()
  {
    initialUrl.textProperty().set(config.getInitialUrl());
    initialDomain.textProperty().set(config.getInitialDomain());

    stayInDomain.selectedProperty().set(config.isStayInDomain());
    allowSubdomains.selectedProperty().set(config.isAllowSubdomains());
    outputFormat.textProperty().set(config.getOutputFormat());
    minutesLimit.valueProperty().set(config.getMinutesLimit());
    depthLimit.valueProperty().set(config.getDepthLimit());

    minutesLimit.setMin(1);
    minutesLimit.setMax(300);
    minutesLimit.setMajorTickUnit(20);
    minutesLimit.setMinorTickCount(5);
    minutesLimit.setShowTickMarks(true);
    
    depthLimit.setMin(1);
    depthLimit.setMax(300);
  }


  private void p()
  {
    System.out.println(config.toString());
  }
  private void bindings()
  {
    initialUrl.textProperty().addListener((observable, ov, v) -> {
      config.setInitialUrl(v);
      initialDomain.textProperty().set(config.getInitialDomain());    // it is refreshed
      p();
    });

    stayInDomain.selectedProperty().addListener((observable, ov, v) -> {
      config.setStayInDomain(v);
      allowSubdomains.disableProperty().setValue(!v);
      p();
    });

    allowSubdomains.selectedProperty().addListener((observable, ov, v) -> {
      config.setAllowSubdomains(v);
      p();
    });

    outputFormat.textProperty().addListener((observable, ov, v) -> {
      config.setOutputFormat(v);
      p();
    });

    depthLimit.valueProperty().addListener((observable, ov, v) -> {
      config.setDepthLimit(v.intValue());
      p();
    });

    minutesLimit.valueProperty().addListener((observable, ov, v) -> {
      config.setMinutesLimit(v.intValue());
      p();
    });


  }

  public void initialize()
  {
    populate();   // show the initial default values of the controls
    bindings();   // bind the controls to the configuration settings
  }

//  @Autowired
//  private AwesomeActionService actionService;


//
//  @FXML private void setInitialUrl(final Event event) {
//    final String s = config.getInitialUrl();
//    initialUrl.setText(s);
//  }

  

}
