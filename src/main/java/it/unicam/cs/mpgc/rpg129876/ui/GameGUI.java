package it.unicam.cs.mpgc.rpg129876.ui;

import it.unicam.cs.mpgc.rpg129876.game.GameManager;
import it.unicam.cs.mpgc.rpg129876.map.GameMap;
import it.unicam.cs.mpgc.rpg129876.map.MoveResult;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

public class GameGUI extends Application {

    private GameManager gameManager;

    private GameMap gameMap;

    @Override
    public void start(Stage stage) {

        gameManager = new GameManager();

        gameMap = new GameMap();

        Image wallImage =
                new Image(getClass().getResourceAsStream(
                        "/sprites/wall.png"));

        Image floorImage =
                new Image(getClass().getResourceAsStream(
                        "/sprites/floor.png"));

        Image playerImage =
                new Image(getClass().getResourceAsStream(
                        "/sprites/player.png"));

        Image enemyImage =
                new Image(getClass().getResourceAsStream(
                        "/sprites/enemy.png"));

        Image treasureImage =
                new Image(getClass().getResourceAsStream(
                        "/sprites/treasure.png"));

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

                    ImageView tileView = new ImageView();

                    switch (map[row][col]) {

                        case 0:
                            tileView.setImage(floorImage);
                            break;

                        case 1:
                            tileView.setImage(wallImage);
                            break;

                        case 2:
                            tileView.setImage(playerImage);
                            break;

                        case 3:
                            tileView.setImage(enemyImage);
                            break;

                        case 4:
                            tileView.setImage(treasureImage);
                            break;
                    }

                    tileView.setFitWidth(48);
                    tileView.setFitHeight(48);

                    mapGrid.add(tileView, col, row);
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
                combatButtons,
                mapGrid,
                gameLog
        );

        Scene scene = new Scene(root, 800, 700);

        java.util.function.BiConsumer<Integer, Integer> movePlayer =
                (dRow, dCol) -> {

                    MoveResult result =
                            gameMap.movePlayer(dRow, dCol);

                    switch (result) {

                        case WALL:

                            gameLog.appendText(
                                    "C'è un muro!\n");

                            break;

                        case ENEMY:

                            gameLog.appendText(
                                    "Hai incontrato un nemico!\n");

                            for (String line : gameManager.attacca()) {

                                gameLog.appendText(line + "\n");
                            }

                            break;

                        case TREASURE:

                            gameLog.appendText(
                                    "Hai trovato un tesoro!\n");

                            break;

                        case MOVED:

                            break;
                    }

                    aggiornaHUD.run();

                    renderMap.run();
                };

        scene.setOnKeyPressed(event -> {

            KeyCode key = event.getCode();

            switch (key) {

                case W:
                    movePlayer.accept(-1, 0);
                    break;

                case S:
                    movePlayer.accept(1, 0);
                    break;

                case A:
                    movePlayer.accept(0, -1);
                    break;

                case D:
                    movePlayer.accept(0, 1);
                    break;
            }

            renderMap.run();
        });

        stage.setTitle("Echoes of the Forgotten Dungeon");

        stage.setScene(scene);

        stage.show();
    }
}