package com.learnJavaFx.controller;

import java.net.URL;
import java.sql.Time;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

public class PlayerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane drawPane;

    @FXML
    private BorderPane sliderPane;

    private Timeline  showAnim;
    private Timeline  hideAnim;

    @FXML
    void onHideSliderPaneAction(MouseEvent event) {
            showAnim.stop();
            hideAnim.play();


    }

    @FXML
    void onShowSliderPaneAction(MouseEvent event) {
            drawPane.setVisible(true);
            if(hideAnim.getStatus() == Animation.Status.STOPPED)
            showAnim.play();
    }

    @FXML
    void initialize() {
       showAnim = new Timeline(new KeyFrame(Duration.millis(300),new KeyValue(sliderPane.translateXProperty(),0)));
       hideAnim = new Timeline(new KeyFrame(Duration.millis(300),new KeyValue(sliderPane.translateXProperty(),300)));

       hideAnim.setOnFinished(event -> {
           drawPane.setVisible(false);
       });

    }
}
