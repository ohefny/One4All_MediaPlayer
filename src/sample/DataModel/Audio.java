package sample.DataModel;

import javafx.collections.MapChangeListener;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.Comparator;

public class Audio{


    private String fileName="NA";
    private String artist="Unknown Artist";
    private String album="Unknown Album";
    private String year="NA";
    private String title="Unknown Title";


    Image albumCover;


    private String path="NA";
    private Media media;
    private static String[] acceptableExtensions = new String[]{"mp3", "aiff", "wav", "mp4", "mpeg-4", "flv"};
    private MetadataListener metadataListener;
    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public String getTitle() {
        if(title.equals("NA"))return fileName;
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
    public String getPath() {
        return path;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public Image getAlbumCover() {
        return albumCover;
    }

    public void setAlbumCover(Image albumCover) {
        this.albumCover = albumCover;
    }

    public String getFileName() {
        return fileName;
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
        this.fileName=file.getName();
        this.path=file.getPath();
        for(String str:acceptableExtensions)
            if(file.getName().endsWith(str)){
                fileName=fileName.substring(0,fileName.lastIndexOf(str)-1);
                break;
            }

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
        return String.format("Artist:%s  Title:%s  Year:%s  Album:%s",artist,title,year,album)+"***" +fileName;
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
            System.out.println(mAudio.getAlbum());
        }
        else if (change.getKey().equals("artist")) {
            mAudio.setArtist(change.getValueAdded().toString());
        }
        else if (change.getKey().equals("title")) {
            System.out.println(mAudio.getTitle());
            mAudio.setTitle(change.getValueAdded().toString());
        }
        else if (change.getKey().equals("year")) {
            mAudio.setYear(change.getValueAdded().toString());
        }
        else if (change.getKey().equals("image")) {
            mAudio.albumCover = ((Image) change.getValueAdded());

        }
    }
}

