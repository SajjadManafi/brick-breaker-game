package sample;

import javafx.animation.Transition;
import javafx.util.Duration;

public class ExplodeAnimation extends Transition {
    private Brick brick;

    public ExplodeAnimation(Brick brick) {
        this.brick = brick;
        setCycleDuration(Duration.millis(500));
    }

    @Override
    protected void interpolate(double v) {
        int frame = (int) Math.floor(v * 6);
        brick.setBackGround("png/" + frame + ".png");
    }
}
