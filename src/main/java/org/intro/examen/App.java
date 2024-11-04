package org.intro.examen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    private static Stage stage;

    @Override
    public void start(Stage stage) {
        App.stage = stage;
        loadFXML("hello-view.fxml", "Main", 900, 700);
    }

    private static void loadFXML(String view, String title, int width, int height) {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(view));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), width, height);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}