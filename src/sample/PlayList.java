package sample;

import javafx.scene.media.Media;

import java.util.ArrayList;
import java.util.List;

public class PlayList {
    enum SORTTYPE{NAME,DURATION,ARTIST}

    private Media currentlyPlaying;
    private ArrayList<Media>list=new ArrayList<>();
    private boolean playing;
    private boolean paused;
    private boolean shuffle;
    private boolean repeat;
    private int numOFMediaFiles;
    private int listDuration;
    private ArrayList<Integer>playingSeq=new ArrayList<>();
    private String Name="playlist";
    public ArrayList<Media> getList() {
        return list;
    }

    public void setList(ArrayList<Media> list) {
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


    void makeSequene(){}
    void Sort(SORTTYPE sorttype){}
    void addMedia(Media media){
        clearList();
        currentlyPlaying=media;
        playing=true;
        paused=false;
    }
    void removeMedia(Media media){}
    Media getNext(){
        return null;
    }
    Media getPrevious(){
        return null;
    }
    Media getCurrentlyPlaying(){
        return currentlyPlaying;
    }
    void addMediaCollection(List<Media> collection){}
    void clearList(){}
    void changePlaying(Media media){}

}
