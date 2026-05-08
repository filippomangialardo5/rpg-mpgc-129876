package it.unicam.cs.mpgc.rpg129876.ui;

import it.unicam.cs.mpgc.rpg129876.game.Direzione;
import it.unicam.cs.mpgc.rpg129876.game.GameManager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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

        Button northButton = new Button("Nord");
        Button southButton = new Button("Sud");
        Button eastButton = new Button("Est");
        Button westButton = new Button("Ovest");

        Button attackButton = new Button("Attacca");
        Button healButton = new Button("Cura");
        Button fleeButton = new Button("Fuggi");

        Runnable aggiornaHUD = () -> {

            hpLabel.setText(
                    "HP: " +
                            gameManager.getGiocatore().getVita());

            livelloLabel.setText(
                    "Livello: " +
                            gameManager.getGiocatore().getLivello());

            esperienzaLabel.setText(
                    "EXP: " +
                            gameManager.getGiocatore().getEsperienza());
        };

        aggiornaHUD.run();

        northButton.setOnAction(e -> {

            for (String line :
                    gameManager.muovi(Direzione.NORD)) {

                gameLog.appendText(line + "\n");
            }

            aggiornaHUD.run();
        });

        southButton.setOnAction(e -> {

            for (String line :
                    gameManager.muovi(Direzione.SUD)) {

                gameLog.appendText(line + "\n");
            }

            aggiornaHUD.run();
        });

        eastButton.setOnAction(e -> {

            for (String line :
                    gameManager.muovi(Direzione.EST)) {

                gameLog.appendText(line + "\n");
            }

            aggiornaHUD.run();
        });

        westButton.setOnAction(e -> {

            for (String line :
                    gameManager.muovi(Direzione.OVEST)) {

                gameLog.appendText(line + "\n");
            }

            aggiornaHUD.run();
        });

        attackButton.setOnAction(e -> {

            for (String line : gameManager.attacca()) {

                gameLog.appendText(line + "\n");
            }

            aggiornaHUD.run();
        });

        healButton.setOnAction(e -> {

            for (String line : gameManager.cura()) {

                gameLog.appendText(line + "\n");
            }

            aggiornaHUD.run();
        });

        fleeButton.setOnAction(e -> {

            for (String line : gameManager.fuggi()) {

                gameLog.appendText(line + "\n");
            }

            aggiornaHUD.run();
        });

        HBox movementButtons = new HBox(10);

        movementButtons.getChildren().addAll(
                northButton,
                southButton,
                eastButton,
                westButton
        );

        HBox combatButtons = new HBox(10);

        combatButtons.getChildren().addAll(
                attackButton,
                healButton,
                fleeButton
        );

        VBox root = new VBox(10);

        root.getChildren().addAll(
                hpLabel,
                livelloLabel,
                esperienzaLabel,
                movementButtons,
                combatButtons,
                gameLog
        );

        Scene scene = new Scene(root, 800, 600);

        stage.setTitle("Echoes of the Forgotten Dungeon");

        stage.setScene(scene);

        stage.show();
    }
}