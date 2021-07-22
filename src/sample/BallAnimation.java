package sample;

import javafx.animation.Transition;
import javafx.util.Duration;

public class BallAnimation extends Transition {
    private Ball ball;
    private Board board;
    private double speed = 0.5;
    private int theta = 225;

    public BallAnimation(Ball ball , Board board) {
        this.ball = ball;
        this.board = board;
        this.setCycleDuration(Duration.millis(1000));
        this.setCycleCount(-1);
    }

    @Override
    protected void interpolate(double v) {
        double dx = speed * Math.cos(Math.toRadians(theta));
        double dy = speed * Math.sin(Math.toRadians(theta)) * (-1);
        ball.move(dx , dy);
        if (ball.hasCollision(board))
            theta = 360 - theta;
        if (ball.hitTopWall())
            theta = -theta;
        if (ball.hitLeftWall())
            theta = 180 - theta;
        if (ball.hitRightWall())
            theta = 180 - theta;
//        if (ball.hitTopWall())
    }
}
