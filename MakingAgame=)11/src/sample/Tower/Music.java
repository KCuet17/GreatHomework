package sample.Tower;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class Music {

    //public static  mediaPlayer;
    Media media = new Media (new File ("Darkling.mp3").toURI ().toString ());
    Media media1=new Media (new File ("Start.mp3").toURI ().toString ());
    public MediaPlayer mediaPlayer = new MediaPlayer (media);
    public MediaPlayer mediaPlayer1=new MediaPlayer (media1);

    public Music() {
    }
}
