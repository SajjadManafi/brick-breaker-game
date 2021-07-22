package sample;


import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Ball extends Circle {
    private static Ball instance;

    public static Ball getInstance() {
        if (instance == null)
            instance = new Ball();
        return instance;
    }
    private Ball() {
        super(300, 280, 7);
    }

    public void move(double dx , double dy){
        this.setCenterX(this.getCenterX() + dx);
        this.setCenterY(this.getCenterY() + dy);
    }

    public boolean hasCollision(Rectangle board) {
        return board.getBoundsInParent().intersects(this.getLayoutBounds());
    }

    public boolean hitTopWall() {
        return this.getCenterY() - this.getRadius() <= 0;
    }
    public boolean hitBottomWall() {
        return this.getCenterY() + this.getRadius() >= 400;
    }
    public boolean hitLeftWall() {
        return this.getCenterX() - this.getRadius() <= 0;
    }
    public boolean hitRightWall() {
        return this.getCenterX() + this.getRadius() >= 600;
    }
}
