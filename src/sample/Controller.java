package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {
    @FXML
    TextField textfield;

public void starte() throws Exception {
    String url = textfield.getText();
    if(!url.contains("youtu")){
        url=new redirect().redirection(" http://www.google.de/search?btnI&q="+url.replace(" ", "+")+"youtube");
    }

    new Main().vid("src=\""+url.replace("https://www.youtube.com/watch?v=", "https://www.youtube.com/embed/").replace("https://youtu.be/", "https://www.youtube.com/embed/")+"\"");
}
}
