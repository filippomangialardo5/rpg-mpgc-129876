package it.unicam.cs.mpgc.rpg129876.ui;

import it.unicam.cs.mpgc.rpg129876.game.GameManager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class GameGUI extends Application {

    private GameManager gameManager;

    @Override
    public void start(Stage stage) {

        gameManager = new GameManager();

        Label hpLabel = new Label();
        Label livelloLabel = new Label();
        Label esperienzaLabel = new Label();

        TextArea gameLog = new TextArea();
        gameLog.setEditable(false);

        Runnable aggiornaHUD = () -> {

            hpLabel.setText(
                    "HP: " + gameManager.getGiocatore().getVita());

            livelloLabel.setText(
                    "Livello: " + gameManager.getGiocatore().getLivello());

            esperienzaLabel.setText(
                    "EXP: " + gameManager.getGiocatore().getEsperienza());
        };

        aggiornaHUD.run();

        Button exploreButton = new Button("Esplora Dungeon");

        exploreButton.setOnAction(e -> {

            for (String line : gameManager.esploraStanza()) {
                gameLog.appendText(line + "\n");
            }

            aggiornaHUD.run();
        });

        VBox root = new VBox(10);

        root.getChildren().addAll(
                hpLabel,
                livelloLabel,
                esperienzaLabel,
                gameLog,
                exploreButton
        );

        Scene scene = new Scene(root, 700, 500);

        stage.setTitle("Echoes of the Forgotten Dungeon");
        stage.setScene(scene);
        stage.show();
    }
}