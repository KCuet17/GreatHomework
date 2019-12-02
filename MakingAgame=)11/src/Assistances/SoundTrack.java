package Assistances;


import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class SoundTrack {

    Media media = new Media (new File ("Ignite.mp3").toURI ().toString ());
    MediaPlayer mediaPlayer = new MediaPlayer (media);

    public SoundTrack() {
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }
}