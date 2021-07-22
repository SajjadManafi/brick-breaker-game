package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    public Rectangle board;

    @Override
    public void start(Stage stage) throws Exception{
        Parent pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
        stage.setTitle("Brick Breaker");
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        pane.getChildrenUnmodifiable().get(0).requestFocus();
        stage.show();
    }

    @FXML
    public void initialize(){
        board.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                String keyName = keyEvent.getCode().getName();
                switch (keyName) {
                    case "Left" -> board.setX(board.getX() - 10);
                    case "Right" -> board.setX(board.getX() + 10);
                }
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
