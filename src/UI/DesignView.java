package UI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import sample.*;


public class DesignView {

    Stage primaryStage;
    Scene scene;
    private ViewActionsListener viewActionsListener;

    private BorderPane primaryPane;

    private HBox upPane;
    private Button musicButton, listButton, openButton;
    private StackPane centerPane;
    private VBox mainPane;
    private HBox firstPiecePane;
    private HBox secondPiecePane;
    private GridPane thirdPiecePane;

    private BorderPane playListPane;


    private Button previous, play, pause, next;
    private String nowPlaying = "Song's name";
    private String albumName = "Album", artist = "Artist";


    private Slider durationBar, volumeBar;

    private int currentDuration, fullDuration, currentVolume;

    private Label nowPlayingSongName, nowPlayingAlbumName, nowPlayingArtistName;
    private Label duration, volume;
    private ImageView albumPic;


    private StackPane picPane;
    private VBox songDataPane;

    private VBox slidersPane;
    private VBox labelsPane;


    private HBox downOfPlaylistPane;
    private Button addToPlayListButton, savePlayListButton, shufflePlayListButton, deleteButton;

    private StackPane playListViewPane;

    public DesignView(ViewActionsListener viewActionsListener) {

        this.viewActionsListener = viewActionsListener;
        initializePrimaryPane();
        initializeConrolersActions();
    }

    private void initializePrimaryPane() {
        initializeUpPane();
        initializeCenterPane();
        primaryPane = new BorderPane();
        primaryPane.setCenter(centerPane);
        primaryPane.setTop(upPane);

    }

    private void initializeUpPane() {


        musicButton = new Button("", new ImageView("icons/music.png"));
        musicButton.setStyle("-fx-background-color: black;");
        listButton = new Button("", new ImageView("icons/list.png"));
        listButton.setStyle("-fx-background-color: black;");
        openButton = new Button("", new ImageView("icons/file.png"));
        openButton.setStyle("-fx-background-color: black;");
        upPane = new HBox(5);

        upPane.setPadding(new Insets(5, 15, 5, 280));

        upPane.getChildren().addAll(openButton, musicButton, listButton);
        upPane.setStyle("-fx-background-color: black;");
        upPane.setStyle("-fx-background-color: black;");


    }

    private void initializeCenterPane() {
        initializeMainPane();
        initializePlayListPane();
        centerPane = new StackPane();
        centerPane.setPadding(new Insets(10, 10, 10, 10));
        centerPane.setStyle("-fx-background-image: url('icons/background.jpg')");

        centerPane.getChildren().add(mainPane);

    }

    private void initializeMainPane() {
        mainPane = new VBox(10);
        initializeConrolers();
        initializeLabels();
        initializeFirstPiece();
        initializeSecondPiece();
        initializeThirdPiece();
        mainPane.getChildren().addAll(firstPiecePane, secondPiecePane, thirdPiecePane);
        mainPane.setPadding(new Insets(10, 10, 10, 10));
        mainPane.setStyle("-fx-border-color: white ; -fx-background-color: black;");


    }

    private void initializeConrolers() {
        previous = new Button("", new ImageView("icons/pre.png"));
        previous.setStyle(
                "-fx-background-radius: 1000em; " +
                        "-fx-min-width: 64px; " +
                        "-fx-min-height: 64px; " +
                        "-fx-max-width: 64px; " +
                        "-fx-max-height: 64px;"
        );

        play = new Button("", new ImageView("icons/play.png"));
        play.setStyle(
                "-fx-background-radius: 1000em; " +
                        "-fx-min-width: 64px; " +
                        "-fx-min-height: 64px; " +
                        "-fx-max-width: 64px; " +
                        "-fx-max-height: 64px;"
        );


        pause = new Button("", new ImageView("icons/pause.png"));
        pause.setStyle(
                "-fx-background-radius: 1000em; " +
                        "-fx-min-width: 64px; " +
                        "-fx-min-height: 64px; " +
                        "-fx-max-width: 64px; " +
                        "-fx-max-height: 64px;"
        );


        next = new Button("", new ImageView("icons/next.png"));
        next.setStyle(
                "-fx-background-radius: 1000em; " +
                        "-fx-min-width: 64px; " +
                        "-fx-min-height: 64px; " +
                        "-fx-max-width: 64px; " +
                        "-fx-max-height: 64px;"
        );


        nowPlayingSongName = new Label(nowPlaying);
    }

    private void initializeLabels() {
        nowPlayingSongName = new Label(nowPlaying);
        nowPlayingSongName.setFont(Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture.REGULAR, 32));

        nowPlayingAlbumName = new Label(albumName);
        nowPlayingAlbumName.setFont(Font.font("Times New Roman",
                FontWeight.LIGHT, FontPosture.REGULAR, 22));


        nowPlayingArtistName = new Label(artist);
        nowPlayingArtistName.setFont(Font.font("Times New Roman",
                FontWeight.LIGHT, FontPosture.REGULAR, 22));


    }

    private void initializeFirstPiece() {
        firstPiecePane = new HBox(10);
        picPane = new StackPane();
        songDataPane = new VBox(10);
        albumPic = new ImageView("icons/default.jpg");
        picPane.getChildren().add(albumPic);
        songDataPane.getChildren().addAll(nowPlayingSongName, nowPlayingAlbumName, nowPlayingArtistName);

        firstPiecePane.getChildren().addAll(picPane, songDataPane);
        firstPiecePane.setPadding(new Insets(20, 15, 10, 10));

    }

    private void initializeSecondPiece() {
        secondPiecePane = new HBox(10);
        secondPiecePane.getChildren().addAll(previous, play, pause, next);
        //secondPiece.setPadding(new Insets(10, 15, 10, 30));
        secondPiecePane.setAlignment(Pos.CENTER);

    }

    private void initializeThirdPiece() {
        thirdPiecePane = new GridPane();
        durationBar = new Slider(0, 100, 0);
        durationBar.setPrefWidth(200);
        volumeBar = new Slider(0, 100, 50);

        volumeBar.setPrefWidth(200);

        slidersPane = new VBox(7);
        labelsPane = new VBox(3);
        slidersPane.getChildren().addAll(durationBar, volumeBar);


        duration = new Label(Integer.toString(currentDuration) + " / " + Integer.toString(fullDuration));
        volume = new Label("Volume: " + Integer.toString(currentVolume));
        labelsPane.getChildren().addAll(duration, volume);

        thirdPiecePane.add(labelsPane, 0, 0);
        thirdPiecePane.add(slidersPane, 1, 0);
        thirdPiecePane.setHgap(30);
        thirdPiecePane.setPadding(new Insets(10, 0, 10, 10));

    }

    private void initializePlayListPane() {
        initializePlayListViewPane();
        initializedownOfPlaylistPane();

        playListPane = new BorderPane();
        playListPane.setStyle("-fx-border-color: white ; -fx-background-color: black;");
        playListPane.setPadding(new Insets(10, 10, 10, 10));

        playListPane.setCenter(playListViewPane);
        playListPane.setBottom(downOfPlaylistPane);

    }

    private void initializePlayListViewPane() {
        playListViewPane = new StackPane();
        //playListViewPane.setPadding(new Insets(10,10,10,10));
        playListViewPane.setStyle("-fx-border-color: white;  -fx-background-color: black;");
    }

    private void initializedownOfPlaylistPane() {
        addToPlayListButton = new Button("", new ImageView("icons/add.png"));
        addToPlayListButton.setStyle(" -fx-background-color: black;");

        savePlayListButton = new Button("", new ImageView("icons/save.png"));
        savePlayListButton.setStyle(" -fx-background-color: black;");

        shufflePlayListButton = new Button("", new ImageView("icons/shuffle.png"));
        shufflePlayListButton.setStyle(" -fx-background-color: black;");

        deleteButton = new Button("", new ImageView("icons/delete.png"));
        deleteButton.setStyle(" -fx-background-color: black;");

        downOfPlaylistPane = new HBox(0);
        downOfPlaylistPane.setStyle("-fx-border-color: white;  -fx-background-color: black;");
        downOfPlaylistPane.setPadding(new Insets(2, 5, 2, 215));
        downOfPlaylistPane.getChildren().addAll(addToPlayListButton, deleteButton, savePlayListButton, shufflePlayListButton);


    }

    private void initializeConrolersActions() {
        getMusicButton().setOnAction(e -> {
            getMusicButton().setStyle("-fx-border-color: white; ");
            getListButton().setStyle("-fx-background-color: black;");
            getCenterPane().getChildren().remove(getPlayListPane());

            getCenterPane().getChildren().add(getMainPane());
        });
        getListButton().setOnAction(e -> {
            getListButton().setStyle("-fx-border-color: white; ");
            getMusicButton().setStyle("-fx-background-color: black;");
            getCenterPane().getChildren().remove(getMainPane());

            getCenterPane().getChildren().add(getPlayListPane());
        });
        previous.setOnAction(event -> viewActionsListener.onPlayPrevious());
        play.setOnAction(event -> viewActionsListener.onPlay());
        pause.setOnAction(event -> viewActionsListener.onPause());
        next.setOnAction(event -> viewActionsListener.onPlayNext());


    }

    public void show() {

        scene = new Scene(primaryPane, 450, 450);
        primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("One4All");
        primaryStage.show();
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public BorderPane getPrimaryPane() {
        return primaryPane;
    }

    public void setPrimaryPane(BorderPane primaryPane) {
        this.primaryPane = primaryPane;
    }

    public HBox getUpPane() {
        return upPane;
    }

    public void setUpPane(HBox upPane) {
        this.upPane = upPane;
    }

    public Button getMusicButton() {
        return musicButton;
    }

    public void setMusicButton(Button musicButton) {
        this.musicButton = musicButton;
    }

    public Button getListButton() {
        return listButton;
    }

    public void setListButton(Button listButton) {
        this.listButton = listButton;
    }

    public Button getOpenButton() {
        return openButton;
    }

    public void setOpenButton(Button openButton) {
        this.openButton = openButton;
    }

    public StackPane getCenterPane() {
        return centerPane;
    }

    public void setCenterPane(StackPane centerPane) {
        this.centerPane = centerPane;
    }

    public VBox getMainPane() {
        return mainPane;
    }

    public void setMainPane(VBox mainPane) {
        this.mainPane = mainPane;
    }

    public HBox getFirstPiecePane() {
        return firstPiecePane;
    }

    public void setFirstPiecePane(HBox firstPiecePane) {
        this.firstPiecePane = firstPiecePane;
    }

    public HBox getSecondPiecePane() {
        return secondPiecePane;
    }

    public void setSecondPiecePane(HBox secondPiecePane) {
        this.secondPiecePane = secondPiecePane;
    }

    public GridPane getThirdPiecePane() {
        return thirdPiecePane;
    }

    public void setThirdPiecePane(GridPane thirdPiecePane) {
        this.thirdPiecePane = thirdPiecePane;
    }

    public BorderPane getPlayListPane() {
        return playListPane;
    }

    public void setPlayListPane(BorderPane playListPane) {
        this.playListPane = playListPane;
    }

    public Button getPrevious() {
        return previous;
    }

    public void setPrevious(Button previous) {
        this.previous = previous;
    }

    public Button getPlay() {
        return play;
    }

    public void setPlay(Button play) {
        this.play = play;
    }

    public Button getPause() {
        return pause;
    }

    public void setPause(Button pause) {
        this.pause = pause;
    }

    public Button getNext() {
        return next;
    }

    public void setNext(Button next) {
        this.next = next;
    }

    public String getNowPlaying() {
        return nowPlaying;
    }

    public void setNowPlaying(String nowPlaying) {
        this.nowPlaying = nowPlaying;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Slider getDurationBar() {

        return durationBar;
    }

    public void setDurationBar(Slider durationBar) {
        this.durationBar = durationBar;
    }

    public Slider getVolumeBar() {
        return volumeBar;
    }

    public void setVolumeBar(Slider volumeBar) {
        this.volumeBar = volumeBar;
    }

    public int getCurrentDuration() {
        return currentDuration;
    }

    public void setCurrentDuration(int currentDuration) {
        this.currentDuration = currentDuration;
    }

    public int getFullDuration() {
        return fullDuration;
    }

    public void setFullDuration(int fullDuration) {
        this.fullDuration = fullDuration;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int currentVolume) {
        this.currentVolume = currentVolume;
    }

    public Label getNowPlayingSongName() {
        return nowPlayingSongName;
    }

    public void setNowPlayingSongName(Label nowPlayingSongName) {
        this.nowPlayingSongName = nowPlayingSongName;
    }

    public Label getNowPlayingAlbumName() {
        return nowPlayingAlbumName;
    }

    public void setNowPlayingAlbumName(Label nowPlayingAlbumName) {
        this.nowPlayingAlbumName = nowPlayingAlbumName;
    }

    public Label getNowPlayingArtistName() {
        return nowPlayingArtistName;
    }

    public void setNowPlayingArtistName(Label nowPlayingArtistName) {
        this.nowPlayingArtistName = nowPlayingArtistName;
    }

    public Label getDuration() {
        return duration;
    }

    public void setDuration(Label duration) {
        this.duration = duration;
    }

    public Label getVolume() {
        return volume;
    }

    public void setVolume(Label volume) {
        this.volume = volume;
    }

    public ImageView getAlbumPic() {
        return albumPic;
    }

    public void setAlbumPic(ImageView albumPic) {
        this.albumPic = albumPic;
    }

    public StackPane getPicPane() {
        return picPane;
    }

    public void setPicPane(StackPane picPane) {
        this.picPane = picPane;
    }

    public VBox getSongDataPane() {
        return songDataPane;
    }

    public void setSongDataPane(VBox songDataPane) {
        this.songDataPane = songDataPane;
    }

    public VBox getSlidersPane() {
        return slidersPane;
    }

    public void setSlidersPane(VBox slidersPane) {
        this.slidersPane = slidersPane;
    }

    public VBox getLabelsPane() {
        return labelsPane;
    }

    public void setLabelsPane(VBox labelsPane) {
        this.labelsPane = labelsPane;
    }

    public HBox getDownOfPlaylistPane() {
        return downOfPlaylistPane;
    }

    public void setDownOfPlaylistPane(HBox downOfPlaylistPane) {
        this.downOfPlaylistPane = downOfPlaylistPane;
    }

    public Button getAddToPlayListButton() {
        return addToPlayListButton;
    }

    public void setAddToPlayListButton(Button addToPlayListButton) {
        this.addToPlayListButton = addToPlayListButton;
    }

    public Button getSavePlayListButton() {
        return savePlayListButton;
    }

    public void setSavePlayListButton(Button savePlayListButton) {
        this.savePlayListButton = savePlayListButton;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(Button deleteButton) {
        this.deleteButton = deleteButton;
    }

    public Button getShufflePlayListButton() {
        return shufflePlayListButton;
    }

    public void setShufflePlayListButton(Button shufflePlayListButton) {
        this.shufflePlayListButton = shufflePlayListButton;
    }


    public StackPane getPlayListViewPane() {
        return playListViewPane;
    }

    public void setPlayListViewPane(StackPane playListViewPane) {
        this.playListViewPane = playListViewPane;
    }
}

