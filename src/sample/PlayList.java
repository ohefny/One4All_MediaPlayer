package sample;

import javafx.scene.media.Media;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Be The Change on 4/30/2016.
 */
public class PlayList {
    enum SORTTYPE{NAME,DURATION,ARTIST};
    Media currentlyPlaying;
    ArrayList<Media>list=new ArrayList<>();
    boolean playing;
    boolean shuffle;
    boolean repeat;
    int numOFMediaFiles;
    int listDuration;
    ArrayList<Integer>playingSeq=new ArrayList<>();
    String Name="playlist";
    void makeSequene(){}
    void Sort(SORTTYPE sorttype){}
    void AddMedia(Media media){}
    void removeMedia(Media media){}
    Media getNext(){
        return null;
    }
    Media getPrevious(){
        return null;
    }
    Media getCurrentlyPlaying(){
        return null;
    }
    void AddMediaCollection(List<Media> collection){}
    void clearList(){}
    void changePlaying(Media media){}

}
