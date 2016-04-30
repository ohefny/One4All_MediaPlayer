package sample;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.FileFilter;
import java.util.*;

public class Controller implements  ViewActionsListener{
    private PlayList mPlaylist;
    private MediaPlayer mediaPlayer;
    private View mView;
    public Controller(View view,PlayList playlist){
          mView=new View(this);
          mPlaylist =playlist;
      /*  mediaPlayer.setOnPaused(new Runnable() {
            @Override
            public void run() {
                mPlaylist.setPaused(true);
            }
        });*/
          if(mPlaylist.getCurrentlyPlaying()!=null)
              mediaPlayer=new MediaPlayer(playlist.getCurrentlyPlaying());

    }
    public void onMediaOpen(File file){
        mPlaylist.addMedia(getMediaFromFile(file),true);
          assignMediaToPlayer();
          mediaPlayer.play();
    }


    @Override
    public void onDirOpen(File file) {
        List<Media> medias=getMediaFromDir(file);
        for(Media media:medias)
            mView.getMediaDirTA().appendText(media.getSource()+System.lineSeparator());
        mPlaylist.addMediaCollection(medias);
        mPlaylist.makeSequene();
        assignMediaToPlayer();
    }

    @Override
    public void onPause() {
       if(mediaPlayer!=null&&mPlaylist.isPlaying()){
           mediaPlayer.pause();

       }
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


    public View getView() {
        return mView;
    }

    public PlayList getPlayList() {
        return mPlaylist;
    }
    public static Media getMediaFromFile(File file){
        return new Media(file.toURI().toString());

    }
    public static FileFilter getFileFilter(){
        String[] acceptableExtensions = new String[] {"mp3", "aiff", "wav","mp4","mpeg-4","flv"};
        return new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                for(String extension:acceptableExtensions){
                    if(pathname.getName().toLowerCase().endsWith(extension))
                        return true;
                }
                return false;
            }
        };

    }
    public static List<Media> getMediaFromDir(File file){
        List<Media>mediaList =new ArrayList<>();
        for(File mediaFile:file.listFiles(getFileFilter())){
            mediaList.add(new Media(mediaFile.toURI().toString()));

        }
        return mediaList;
    }
    private void assignMediaToPlayer() {
        if(mediaPlayer==null)
            mediaPlayer=new MediaPlayer(mPlaylist.getCurrentlyPlaying());
        else{
            mediaPlayer.stop();
            mediaPlayer=new MediaPlayer(mPlaylist.getCurrentlyPlaying());
        }
    }

}
