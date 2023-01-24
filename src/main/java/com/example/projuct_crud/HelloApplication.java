package com.example.projuct_crud;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("crud_App.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 950, 400);
        stage.setTitle("Crud_App");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        Image icon = new Image(getClass().getResourceAsStream("student.png"));
        stage.getIcons().add(icon);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}