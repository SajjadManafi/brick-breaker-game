package sample;

import javafx.scene.shape.Rectangle;

public class Board extends Rectangle {
    public Board () {
        super(275, 320, 50, 15);
        this.getStyleClass().add("board");
    }

    public void moveRight(){
        if (!hitRightWall())
            this.setX(this.getX() + 10);
    }
    public void moveLeft(){
        if (!hitLeftWall())
            this.setX(this.getX() - 10);
    }

    public boolean hitRightWall(){
        return this.getX() + this.getWidth() >= 600;
    }
    public boolean hitLeftWall(){
        return this.getX() <= 0;
    }
}
