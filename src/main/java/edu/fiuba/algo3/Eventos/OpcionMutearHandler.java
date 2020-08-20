package edu.fiuba.algo3.Eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.MediaPlayer;

public class OpcionMutearHandler implements EventHandler<ActionEvent> {

    MediaPlayer mediaPlayer;

    public OpcionMutearHandler(MediaPlayer mediaPlayer){
        this.mediaPlayer = mediaPlayer;
    }

    @Override
    public void handle(ActionEvent event) {
        if(mediaPlayer.isMute()){
            mediaPlayer.setMute(false);
        }
        else {
            mediaPlayer.setMute(true);
        }
    }
}
