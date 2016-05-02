package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.DataModel.PlayList;

public class Main extends Application {
    private View view;
    private Controller controller;
    private PlayList mplayList;
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Hello World");
        Controller controller=new Controller(view,new PlayList());
        view=controller.getView();
        mplayList=controller.getPlayList();
        Scene scene=new Scene(view,500,500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
