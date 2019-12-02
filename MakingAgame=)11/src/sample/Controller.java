package sample;

//import javax.annotation.Nonnull;


import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

public final class Controller extends AnimationTimer {

    private final GraphicsContext graphicsContext;

    public Controller(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
    }

    @Override
    public void handle(long l) {

    }
}