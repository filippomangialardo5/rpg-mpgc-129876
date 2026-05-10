package it.unicam.cs.mpgc.rpg129876.ui;

import it.unicam.cs.mpgc.rpg129876.game.GameManager;
import it.unicam.cs.mpgc.rpg129876.map.GameMap;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GameGUI extends Application {

    private GameManager gameManager;

    private GameMap gameMap;

    @Override
    public void start(Stage stage) {

        gameManager = new GameManager();

        gameMap = new GameMap();

        Label hpLabel = new Label();
        Label livelloLabel = new Label();
        Label esperienzaLabel = new Label();

        TextArea gameLog = new TextArea();
        gameLog.setEditable(false);

        GridPane mapGrid = new GridPane();

        Button northButton = new Button("Nord");
        Button southButton = new Button("Sud");
        Button eastButton = new Button("Est");
        Button westButton = new Button("Ovest");

        Button attackButton = new Button("Attacca");
        Button healButton = new Button("Cura");
        Button fleeButton = new Button("Fuggi");

        Runnable aggiornaHUD = () -> {

            hpLabel.setText(
                    "HP: "
                            + gameManager.getGiocatore().getVita());

            livelloLabel.setText(
                    "Livello: "
                            + gameManager.getGiocatore().getLivello());

            esperienzaLabel.setText(
                    "EXP: "
                            + gameManager.getGiocatore().getEsperienza());
        };

        Runnable renderMap = () -> {

            mapGrid.getChildren().clear();

            int[][] map = gameMap.getMap();

            for (int row = 0; row < map.length; row++) {

                for (int col = 0; col < map[row].length; col++) {

                    Rectangle tile = new Rectangle(40, 40);

                    switch (map[row][col]) {

                        case 0:
                            tile.setFill(Color.LIGHTGRAY);
                            break;

                        case 1:
                            tile.setFill(Color.DARKSLATEGRAY);
                            break;

                        case 2:
                            tile.setFill(Color.DEEPSKYBLUE);
                            break;

                        case 3:
                            tile.setFill(Color.CRIMSON);
                            break;

                        case 4:
                            tile.setFill(Color.GOLD);
                            break;

                        default:
                            tile.setFill(Color.BLACK);
                    }

                    mapGrid.add(tile, col, row);
                }
            }
        };

        aggiornaHUD.run();

        renderMap.run();

        northButton.setOnAction(e -> {

            gameMap.movePlayer(-1, 0);

            renderMap.run();
        });

        southButton.setOnAction(e -> {

            gameMap.movePlayer(1, 0);

            renderMap.run();
        });

        eastButton.setOnAction(e -> {

            gameMap.movePlayer(0, 1);

            renderMap.run();
        });

        westButton.setOnAction(e -> {

            gameMap.movePlayer(0, -1);

            renderMap.run();
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
                mapGrid,
                gameLog
        );

        Scene scene = new Scene(root, 800, 700);

        stage.setTitle("Echoes of the Forgotten Dungeon");

        stage.setScene(scene);

        stage.show();
    }
}