package sample;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.File;

public class View extends VBox {


    private TextArea openSongTA=new TextArea();

    public TextArea getMediaDirTA() {
        return mediaDirTA;
    }

    private TextArea mediaDirTA=new TextArea();
     private Button button=new Button("play");
     private Button openBt=new Button("Open dir");
     private ViewActionsListener mListener;
     public View(ViewActionsListener listener){
         mListener=listener;
         openSongTA.setText("");
         getChildren().add(openSongTA);
         button.setOnAction(event -> mListener.onMediaOpen(new File(openSongTA.getText())));
         openBt.setOnAction(event -> mListener.onDirOpen(new File(openSongTA.getText())));
         getChildren().add(button);
         getChildren().add(openBt);
         getChildren().add(mediaDirTA);
         this.setSpacing(10);
         this.setAlignment(Pos.CENTER);
     }
    public TextArea getText() {
        return openSongTA;
    }

    public void setText(TextArea text) {
        this.openSongTA = text;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }
}
