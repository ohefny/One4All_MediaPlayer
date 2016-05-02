package sample;

import sample.DataModel.PlayList;

import java.io.File;


interface ViewActionsListener {
    void onMediaOpen(File file);

    void onPause();

    void onPlay();

    void onStop();

    void onExit();
    void onSort(PlayList.SORTTYPE sorttype);
    void onShuffle();
    void onIncreaseRate(float rate);
    void onDecreaseRate(float rate);


    void onDirOpen(File file);

}
