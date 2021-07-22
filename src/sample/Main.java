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

import java.util.Objects;

public class Main extends Application {


    @Override
    public void start(Stage stage) throws Exception{
        Pane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
        Board board = createBoard();
        pane.getChildren().add(board);
        stage.setTitle("Brick Breaker");
        Scene scene = new Scene(pane);
        stage.setScene(scene);

        pane.getChildrenUnmodifiable().get(0).requestFocus();
        stage.show();
    }

    private Board createBoard(){
        Board board = new Board();
        board.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                String keyName = keyEvent.getCode().getName();
                switch (keyName) {
                    case "Left" -> board.moveLeft();
                    case "Right" -> board.moveRight();
                }
            }
        });
        return board;
    }
    @FXML
    public void initialize(){

    }

    public static void main(String[] args) {
        launch(args);
    }
}
