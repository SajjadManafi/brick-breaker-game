package sample;

import javafx.animation.Transition;
import javafx.util.Duration;

public class BallAnimation extends Transition {
    private Ball ball;
    private int speed = 1;
    private int theta = 225;

    public BallAnimation(Ball ball) {
        this.ball = ball;
        this.setCycleDuration(Duration.millis(1000));
        this.setCycleCount(-1);
    }

    @Override
    protected void interpolate(double v) {
        double dx = speed * Math.cos(Math.toRadians(theta));
        double dy = speed * Math.sin(Math.toRadians(theta)) * (-1);
        ball.move(dx , dy);
    }
}
