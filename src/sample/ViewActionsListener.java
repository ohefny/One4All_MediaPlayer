package sample;

import java.io.File;


 interface ViewActionsListener {
     void onMediaOpen(File file);
     void onPause();
    void onPlay();
    void onStop();
    void onExit();
    void onDirOpen(File file);

}
