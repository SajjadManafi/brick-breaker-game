package sample;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

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
        parent.getChildren().remove(this);
        allBricks.remove(this);
    }
}
