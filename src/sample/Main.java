package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Objects;

public class Main extends Application {

    private boolean gameStarted = false;

    @Override
    public void start(Stage stage) throws Exception {
        Pane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
        Board board = createBoard();
        pane.getChildren().add(board);
        Ball ball = createBall();
        pane.getChildren().add(ball);
        ArrayList<Brick> bricks = createBricks(pane);
        pane.getChildren().addAll(bricks);
        stage.setTitle("Brick Breaker");
        Scene scene = new Scene(pane);
        stage.setScene(scene);

        pane.getChildrenUnmodifiable().get(0).requestFocus();
        stage.show();
    }

    private Board createBoard() {
        Board board = new Board();
        board.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!gameStarted) {
                    gameStarted = true;
                    BallAnimation animation = new BallAnimation(Ball.getInstance(), board);
                    animation.play();
                }
                String keyName = keyEvent.getCode().getName();
                switch (keyName) {
                    case "Left" -> board.moveLeft();
                    case "Right" -> board.moveRight();
                }
            }
        });
        return board;
    }

    private Ball createBall() {
        return Ball.getInstance();
    }

    private ArrayList<Brick> createBricks(Pane parent){
        for (int i = 0; i < 7; i++) {
            double x = i * 63 + 79.5;
            double y = 80;
            new Brick(x,y , parent);
        }
        for (int i = 0; i < 8; i++) {
            double x = i * 63 + 48;
            double y = 105;
            new Brick(x,y, parent);
        }
        return Brick.getAllBricks();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
