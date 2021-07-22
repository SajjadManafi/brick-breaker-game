package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Objects;

public class Brick extends Rectangle {

    private static ArrayList<Brick> allBricks = new ArrayList<>();
    private Pane parent;
    public Brick(double x, double y , Pane parent) {
        super(x, y, 60, 15);
        this.getStyleClass().add("brick");
        this.parent = parent;
        allBricks.add(this);
    }

    public static ArrayList<Brick> getAllBricks() {
        return allBricks;
    }

    public void remove (){
        allBricks.remove(this);
    }

    public void setBackGround (String url){
        this.setFill(new ImagePattern(new Image(Objects.requireNonNull(getClass().getResource(url)).toExternalForm())));
    }
    public void explode() {
        ExplodeAnimation animation = new ExplodeAnimation(this);
        animation.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                parent.getChildren().remove(Brick.this);
            }
        });
        animation.play();
    }
}
