package sample;


import javafx.scene.shape.Circle;

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
}
