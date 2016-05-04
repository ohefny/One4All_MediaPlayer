package sample;

import javafx.scene.media.MediaPlayer;
import sample.DataModel.Audio;
import sample.DataModel.PlayList;

import java.io.File;
import java.io.FileFilter;
import java.util.*;

public class Controller implements ViewActionsListener {
    private PlayList mPlaylist;
    private MediaPlayer mediaPlayer;
    private View mView;
    private MediaEndListener mediaEndListener;

    public Controller(View view, PlayList playlist) {
        mView = new View(this);
        mPlaylist = playlist;
        mediaEndListener =new MediaEndListener();
        assignMediaToPlayer();

    }

    public void onMediaOpen(File file) {
        if (getFileFilter().accept(file)) {
            mPlaylist.addMedia(new Audio(file), true);
            assignMediaToPlayer();
            mediaPlayer.play();
        }
        else{
          mView.errorDialog("Please choose one of these file formates" +
                  "mp3,wav,aiff,mp4,mpeg-4,flv","Unsupported File");
        }
    }


    @Override
    public void onDirOpen(File file) {
                  List<Audio> audios = getMediaFromDir(file);
                  for (Audio audio : audios)
                      mView.getMediaDirTA().appendText(audio.getMedia().getSource() + System.lineSeparator());
                  mPlaylist.addMediaCollection(true,audios);
                  onShuffle();
                  assignMediaToPlayer();

    }

    @Override
    public void onPause() {
        if (mediaPlayer != null && mPlaylist.isPlaying()) {
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

    @Override
    public void onSort(PlayList.SORTTYPE sorttype) {
        if(sorttype!=mPlaylist.getSorttype()){
            mPlaylist.setSorttype(PlayList.SORTTYPE.DEFAULT);
          //  mPlaylist.makeSequene();
        }
    }

    @Override
    public void onShuffle() {
        mPlaylist.setShuffle(!mPlaylist.isShuffle());

    }

    @Override
    public void onIncreaseRate(float rate) {

    }

    @Override
    public void onDecreaseRate(float rate) {

    }

    @Override
    public void onPlayNext() {

    }

    @Override
    public void onPlayPrevious() {

    }


    public View getView() {
        return mView;
    }

    public PlayList getPlayList() {
        return mPlaylist;
    }

   /* public static Media getMediaFromFile(File file) {
        return new Media(file.toURI().toString());

    }*/

    public static FileFilter getFileFilter() {
        String[] acceptableExtensions = new String[]{"mp3", "aiff", "wav", "mp4", "mpeg-4", "flv"};
        return new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                for (String extension : acceptableExtensions) {
                    if (pathname.getName().toLowerCase().endsWith(extension))
                        return true;
                }
                return false;
            }
        };

    }

    public static List<Audio> getMediaFromDir(File file) {
        List<Audio> audioList = new ArrayList<>();
        for (File mediaFile : file.listFiles(getFileFilter())) {
            audioList.add(new Audio(mediaFile));
        }
        return audioList;
    }

    private void assignMediaToPlayer() {
        if(mPlaylist.getCurrentlyPlaying()==null)
            return;
        if (mediaPlayer == null)
            mediaPlayer = new MediaPlayer(mPlaylist.getCurrentlyPlaying().getMedia());
        else {
            mediaPlayer.stop();
            mediaPlayer = new MediaPlayer(mPlaylist.getCurrentlyPlaying().getMedia());

        }
        mediaPlayer.setOnEndOfMedia(mediaEndListener);
        mediaPlayer.play();
        mView.getText().appendText(System.lineSeparator()+"Now Playing ::: "+mPlaylist.getCurrentlyPlaying());
    }
 class MediaEndListener implements Runnable{
     @Override
     public void run() {
         mPlaylist.getNext();
         assignMediaToPlayer();
         //tobeRemoved
         mView.getText().appendText(System.lineSeparator()+"Now Playing ::: "+mPlaylist.getCurrentlyPlaying());
     }
 }
}
