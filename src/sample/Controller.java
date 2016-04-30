package sample;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Controller implements  ViewActionsListener{
    private PlayList mPlaylist;
    private MediaPlayer mediaPlayer;
    private View mView;
    public Controller(View view,PlayList playlist){
          mView=new View(this);
          mPlaylist =playlist;
          if(mPlaylist.getCurrentlyPlaying()!=null)
              mediaPlayer=new MediaPlayer(playlist.getCurrentlyPlaying());

    }
    public void onMediaOpen(File file){
        mPlaylist.addMedia(new Media(file.toURI().toString()));
        if(mediaPlayer==null)
            mediaPlayer=new MediaPlayer(mPlaylist.getCurrentlyPlaying());
        else{
            mediaPlayer.stop();
            mediaPlayer=new MediaPlayer(mPlaylist.getCurrentlyPlaying());
        }
          mediaPlayer.play();
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onPlay() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onExit() {

    }

    @Override
    public void onDirOpen(File file) {

    }

    public View getView() {
        return mView;
    }

    public PlayList getPlayList() {
        return mPlaylist;
    }
}
