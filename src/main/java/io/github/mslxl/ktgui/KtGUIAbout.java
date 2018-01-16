package io.github.mslxl.ktgui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class KtGUIAbout extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        WebView view = new WebView();
        view.prefHeightProperty().bind(stage.heightProperty());
        view.prefWidthProperty().bind(stage.widthProperty());
        view.getEngine().load("https://github.com/mslxl/KtGUI");
        stage.setScene(new Scene(new Group(view), 1200, 500));
        stage.setTitle("KtGUI - Mslxl's GitHub");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}