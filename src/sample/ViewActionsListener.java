package sample;

import sample.DataModel.PlayList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;


public interface ViewActionsListener {
    void onMediaOpen(File file);

    void onPause();

    void onPlay();

    void onStop();

    void onExit();
    void onSort(PlayList.SORTTYPE sorttype);
    void onShuffle();
    void onIncreaseRate();
    void onDecreaseRate();
    void onPlayNext();
    void onPlayPrevious();

    void onDirOpen(File file);
    void onMediaAdded(File file);
   // void onMediasAdded(List<File> list);
    void onDragDrop(File file,boolean playlistIsOn);
    void onSavePlaylist() ;
    void onLoadPlaylist(File listPath);

}
