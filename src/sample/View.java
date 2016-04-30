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


    private TextArea text=new TextArea();
     private Button button=new Button("play");
     private ViewActionsListener mListener;
     public View(ViewActionsListener listener){
         mListener=listener;
         text.setText("");
         getChildren().add(text);
         button.setOnAction(event -> mListener.onMediaOpen(new File(text.getText())));
         getChildren().add(button);
         this.setSpacing(10);
         this.setAlignment(Pos.CENTER);
     }
    public TextArea getText() {
        return text;
    }

    public void setText(TextArea text) {
        this.text = text;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }
}
