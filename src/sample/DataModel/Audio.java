package sample.DataModel;

import javafx.collections.MapChangeListener;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.Comparator;

public class Audio{
    private String artist="NA";
    private String album="NA";
    private String year="NA";
    private String title="NA";
    private Media media;
    private MetadataListener metadataListener;
    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Audio(Media media){
        this.media=media;
        this.metadataListener=new MetadataListener(this);
        this.media.getMetadata().addListener(metadataListener);
    }
    public Audio(File file){
        this.media=new Media(file.toURI().toString());
        this.metadataListener=new MetadataListener(this);
        this.media.getMetadata().addListener(metadataListener);

    }
    public Audio(String artist, String album, String year, String title,Media media) {
        this.artist = artist;
        this.album = album;
        this.year = year;
        this.title = title;
        this.media=media;
        this.metadataListener=new MetadataListener(this);
        this.media.getMetadata().addListener(metadataListener);
    }
    //to be Removed if you can't achieve sorting
    public static Comparator<Audio> getArtistComprator(){
        return (o1, o2) -> o1.artist.compareTo(o2.getArtist());


    }
    public static Comparator<Audio> getTitleComprator(){
        return (o1, o2) -> o1.title.compareTo(o2.getTitle());


    }
    public static Comparator<Audio> getYearComprator(){
        return (o1, o2) -> o1.year.compareTo(o2.getYear());


    }
    public static Comparator<Audio> getAlbumComprator(){
        return (o1, o2) -> o1.album.compareTo(o2.getAlbum());


    }

    @Override
    public String toString() {
        return String.format("Artist:%s  Title:%s  Year:%s  Album:%s",artist,title,year,album)+"***" +media.getSource();
    }
}
class MetadataListener implements MapChangeListener<String,Object> {
    Audio mAudio;

    public MetadataListener(Audio mAudio) {
        this.mAudio = mAudio;
    }

    @Override
    public void onChanged(Change<? extends String, ?> change) {
        if (change.getKey().equals("album")) {
            mAudio.setAlbum(change.getValueAdded().toString());
        }
        else if (change.getKey().equals("artist")) {
            mAudio.setArtist(change.getValueAdded().toString());
        }
        else if (change.getKey().equals("title")) {
            mAudio.setTitle(change.getValueAdded().toString());
        }
        else if (change.getKey().equals("year")) {
            mAudio.setYear(change.getValueAdded().toString());
        }
       // System.out.println(mAudio);

    }
}

