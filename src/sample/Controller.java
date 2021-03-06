package sample;

import UI.DesignView;
import javafx.scene.media.MediaPlayer;
import sample.DataModel.Audio;
import sample.DataModel.PlayList;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Controller implements ViewActionsListener {
    private PlayList mPlaylist;
    private MediaPlayer mediaPlayer;
    private DesignView designView;
    private MediaEndListener mediaEndListener;
    private double rate=1;

    public Controller() {
        designView = new DesignView(this);
        mPlaylist = new PlayList();
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
       //   mView.errorDialog("Please choose one of these file formates" +
        //          "mp3,wav,aiff,mp4,mpeg-4,flv","Unsupported File");
        }
    }


    @Override
    public void onDirOpen(File file) {
                  List<Audio> audios = getMediaFromDir(file);
                  mPlaylist.addMediaCollection(true,audios);
                  onShuffle();
                  assignMediaToPlayer();

    }

    @Override
    public void onMediaAdded(File file) {
        File[] list=file.listFiles( getFileFilter());
        mPlaylist.addMediaCollection(false,getAudiosFromFiles(list));
    }

    @Override
    public void onDragDrop(File file, boolean playlistIsOn) {

    }

    @Override
    public void onSavePlaylist() {
        File file;
        PrintWriter printWriter;

        if(mPlaylist.getPlayListPath()!=null){
            file=new File(mPlaylist.getPlayListPath().getPath());
            try{
            printWriter=new PrintWriter(file);
            for(Audio audio:mPlaylist.getList())
                printWriter.println(audio.getPath());
            }catch (FileNotFoundException ex){

            }

        }
        else{
            //open dir chooser dialog
        }
    }

    @Override
    public void onLoadPlaylist(File listPath) {
        try{
       Scanner scanner=new Scanner(listPath);


        }
        catch (FileNotFoundException ex){

        }

    }

    @Override
    public void onPause() {
        if (mediaPlayer != null && mPlaylist.isPlaying()) {
            mediaPlayer.pause();
            mPlaylist.setPaused(false);
        }
    }

    @Override
    public void onPlay() {
        if(mPlaylist.isPlaying())return;
        if(mPlaylist.isPaused()){
            if(mediaPlayer==null)
                assignMediaToPlayer();
            else
                mediaPlayer.play();
            mPlaylist.setPaused(false);


        }
        else
            assignMediaToPlayer();
    }

    @Override
    public void onStop() {
        if(mediaPlayer==null)return;
        else{
            mediaPlayer.stop();
            mPlaylist.setPlaying(false);
        }

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
    public void onIncreaseRate() {

        rate+=.5;
        if(mediaPlayer!=null)
            mediaPlayer.setRate(rate);
    }

    @Override
    public void onDecreaseRate() {

        rate-=.5;
        if(mediaPlayer!=null)
            mediaPlayer.setRate(rate);

    }

    @Override
    public void onPlayNext() {
        if(mediaPlayer==null){
          assignMediaToPlayer();
        }
        else{
              mPlaylist.getNext();
              assignMediaToPlayer();

        }

    }

    @Override
    public void onPlayPrevious() {
        if(mediaPlayer==null){
            assignMediaToPlayer();
        }
        else{
            mPlaylist.getPrevious();
            assignMediaToPlayer();

        }
    }


    public DesignView getDesignView() {
        return designView;
    }

    public PlayList getPlayList() {
        return mPlaylist;
    }

   /* public static Media getMediaFromFile(File file) {
        return new Media(file.toURI().toString());

    }*/
   public static List<Audio> getAudiosFromFiles(File[]list){
       List<Audio>audios=new ArrayList<>();
       for(File file:list){
           audios.add(new Audio(file));
       }
       return audios;

   }
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
        mPlaylist.setPlaying(true);
        mediaPlayer.setOnEndOfMedia(mediaEndListener);
        mediaPlayer.play();
     //   mView.getText().appendText(System.lineSeparator()+"Now Playing ::: "+mPlaylist.getCurrentlyPlaying());
    }
 class MediaEndListener implements Runnable{
     @Override
     public void run() {
         mPlaylist.getNext();
         assignMediaToPlayer();
         //tobeRemoved
         //mView.getText().appendText(System.lineSeparator()+"Now Playing ::: "+mPlaylist.getCurrentlyPlaying());
     }
 }
}
