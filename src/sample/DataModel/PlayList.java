package sample.DataModel;

import javafx.beans.NamedArg;
import javafx.collections.MapChangeListener;
import javafx.scene.media.Media;

import java.util.ArrayList;
import java.util.List;

public class PlayList {
     public enum SORTTYPE{DEFAULT,TITLE,YEAR,ARTIST,ALBUM}

    private SORTTYPE sorttype=SORTTYPE.DEFAULT;
    private Audio currentlyPlaying;
    private ArrayList<Audio>list=new ArrayList<>();

    public int getCurrentlyPlayinIndex() {
        return currentlyPlayinIndex;
    }

    public void setCurrentlyPlayinIndex(int currentlyPlayinIndex) {
        this.currentlyPlayinIndex = currentlyPlayinIndex;
        currentlyPlaying=list.get(currentlyPlayinIndex);
    }

    private int currentlyPlayinIndex;
    private boolean playing;
    private boolean paused;
    private boolean shuffle;
    private boolean repeat;
    private int numOFMediaFiles;
    private int listDuration;
    private ArrayList<Integer>playingSeq=new ArrayList<>();
    //private ArrayList
    private String Name="playlist";
    public ArrayList<Audio> getList() {
        return list;
    }

    public void setList(ArrayList<Audio> list) {
        this.list = list;
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
        setPlaying(!paused);
    }

    public boolean isShuffle() {
        return shuffle;
    }

    public void setShuffle(boolean shuffle) {
        this.shuffle = shuffle;
    }

    public boolean isRepeat() {
        return repeat;
    }

    public void setRepeat(boolean repeat) {
        this.repeat = repeat;
    }

    public int getNumOFMediaFiles() {
        return numOFMediaFiles;
    }

    public void setNumOFMediaFiles(int numOFMediaFiles) {
        this.numOFMediaFiles = numOFMediaFiles;
    }

    public int getListDuration() {
        return listDuration;
    }

    public void setListDuration(int listDuration) {
        this.listDuration = listDuration;
    }

    public ArrayList<Integer> getPlayingSeq() {
        return playingSeq;
    }

    public void setPlayingSeq(ArrayList<Integer> playingSeq) {
        this.playingSeq = playingSeq;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
    public SORTTYPE getSorttype() {
        return sorttype;
    }

    public void setSorttype(SORTTYPE sorttype) {
        this.sorttype = sorttype;
    }


    public void makeSequene(){
        currentlyPlaying=list.get(0);
        switch(sorttype){
            case ARTIST:
               list.sort(Audio.getArtistComprator());
                break;
            case TITLE:
               list.sort(Audio.getTitleComprator());
                break;
            case YEAR:
               list.sort(Audio.getYearComprator());
                break;

            case ALBUM:
               list.sort(Audio.getAlbumComprator());
               break;
            default:
        }

    }
    //void Sort(SORTTYPE sorttype){}
    public void addMedia(Audio media,boolean openAndPlay){
        if(openAndPlay==true){
            clearList();
            currentlyPlaying=media;
            playing=true;
            paused=false;
        }
        list.add(media);

    }
    public void removeMedia(Media media){}
    public Audio getNext(){
        return null;
    }
    public Audio getPrevious(){
        return null;
    }
    public Audio getCurrentlyPlaying(){
        return currentlyPlaying;
    }
    public void addMediaCollection(boolean isNewList,List<Audio> collection){
        if(isNewList)
            list = (ArrayList) collection;
        else
            list.addAll(collection);

        makeSequene();


    }
    public void clearList(){}
    //public void changePlaying(Media media){}


}

