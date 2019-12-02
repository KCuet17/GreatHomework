package sample;

import javafx.scene.image.Image;

public class AnimatedImage
{
    // assumes animation loops,
    //  each image displays for equal time
    public Image[] frames;
    public double duration;

    public Image getFrame(long tick)
    {
        int index = (int)tick/20;
        return frames[index];
    }
}
