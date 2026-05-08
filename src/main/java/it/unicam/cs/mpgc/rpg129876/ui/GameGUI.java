package it.unicam.cs.mpgc.rpg129876.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameGUI extends Application {

    @Override
    public void start(Stage stage) {

        TextArea gameLog = new TextArea();
        gameLog.setEditable(false);

        Button exploreButton = new Button("Esplora Dungeon");

        exploreButton.setOnAction(e -> {
            gameLog.appendText("Hai esplorato una nuova stanza...\n");
        });

        VBox root = new VBox(10);
        root.getChildren().addAll(gameLog, exploreButton);

        Scene scene = new Scene(root, 600, 400);

        stage.setTitle("Echoes of the Forgotten Dungeon");
        stage.setScene(scene);
        stage.show();
    }
}