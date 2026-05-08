package it.unicam.cs.mpgc.rpg129876.ui;

import it.unicam.cs.mpgc.rpg129876.game.GameManager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameGUI extends Application {

    private GameManager gameManager;

    @Override
    public void start(Stage stage) {

        gameManager = new GameManager();

        TextArea gameLog = new TextArea();
        gameLog.setEditable(false);

        Button exploreButton = new Button("Esplora Dungeon");

        exploreButton.setOnAction(e -> {

            for (String line : gameManager.esploraStanza()) {
                gameLog.appendText(line + "\n");
            }
        });

        VBox root = new VBox(10);
        root.getChildren().addAll(gameLog, exploreButton);

        Scene scene = new Scene(root, 700, 500);

        stage.setTitle("Echoes of the Forgotten Dungeon");
        stage.setScene(scene);
        stage.show();
    }
}