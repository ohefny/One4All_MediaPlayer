package sample;

import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import sample.DataModel.PlayList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;


public interface ViewActionsListener {
    void onMediaOpen(File[] files);

    void onPause();

    void onPlay();
    boolean onCheckSaved();
    void onStop();

    void onExit();
    void onSort(PlayList.SORTTYPE sorttype);
    void onShuffle();
    void onIncreaseRate();
    void onDecreaseRate();
    void onPlayNext();
    void onPlayPrevious();
    void onDurationChange(float val);
    void onVolumeChange(int val);

   // void onDirOpen(File[] file);
    void onMediaAdded(File[] list);
   // void onMediasAdded(List<File> list);
    void onDragDrop(File file,boolean playlistIsOn);
    void onSavePlaylist(File Dir,boolean isNewPlt) ;
   // void onLoadPlaylist(File listPath);

    void onRemoveMedia(ObservableList<Integer>list);

    void onMediaChanged(int index);
}
