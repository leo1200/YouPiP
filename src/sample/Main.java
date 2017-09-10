package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.getIcons().add(new Image(this.getClass().getResourceAsStream("icon.png")));
        Scene s = new Scene(root, 300, 50);
        primaryStage.setTitle("YouPiP");
        primaryStage.setScene(s);
        // primaryStage.initStyle(StageStyle.DECORATED); change if you want to
        primaryStage.show();
    }

    public void vid(String vid) throws Exception{
        Stage s2 = new Stage();
        s2.setAlwaysOnTop(true);
        s2.getIcons().add(new Image(this.getClass().getResourceAsStream("icon2.png")));
        //s2.initStyle(StageStyle.TRANSPARENT); //change if you want to
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webView.getEngine().setUserStyleSheetLocation(getClass().getResource("style.css").toExternalForm());
        webEngine.loadContent("<html><iframe width=\"100%\" height=\"100%\" " + vid + " frameborder=\"0\" allowfullscreen></iframe></html>");
        s2.setOnCloseRequest(new EventHandler<WindowEvent>(){
            @Override
            public void handle(WindowEvent event) {
                webView.getEngine().load(null);
            }
        });
        Scene s = new Scene(webView, 1280, 720);
        s2.setScene(s);
        s2.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}


