package sample;

import UI.DesignView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.DataModel.PlayList;

import java.io.File;
import java.io.PrintWriter;

public class Main extends Application {
    private DesignView designView;
    private Controller controller;
    private PlayList mplayList;
    @Override
    public void start(Stage primaryStage) throws Exception{
         controller=new Controller();
         mplayList=controller.getPlayList();
        designView=controller.getDesignView();
        designView.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
