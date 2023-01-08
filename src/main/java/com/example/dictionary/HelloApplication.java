package com.example.dictionary;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.layout.Pane;
public class HelloApplication extends Application {
    Label meaningLabel;
    TextField wordTextField;
    Button searchButton;
    ListView<String> suggestionList;


    dictionaryUsingHashMap dictionaryUsingHashMap = new dictionaryUsingHashMap();
    Pane createContent(){
        Pane root = new Pane();

        root.setPrefSize(400, 600);

        wordTextField = new TextField();
        wordTextField.setTranslateX(60);
        wordTextField.setTranslateY(50);
       // wordTextField.setText(selectionword);

        searchButton = new Button("Search");
        searchButton.setTranslateX(250);
        searchButton.setTranslateY(50);
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String word = wordTextField.getText();
                if(word.isBlank() || word.isEmpty()){
                    meaningLabel.setText("Please enter a word");
                    meaningLabel.setTextFill(Color.RED);
                }
                else{
                    String meaning = dictionaryUsingHashMap.getMeaning(word);
                    meaningLabel.setText(meaning);
                    meaningLabel.setTextFill(Color.ROYALBLUE);
                }
            }
        });

        meaningLabel = new Label("I am meaning");
        meaningLabel.setTranslateX(60);
        meaningLabel.setTranslateY(120);

        suggestionList = new ListView<>();
        suggestionList.setTranslateX(20);
        suggestionList.setTranslateY(200);
        suggestionList.setMinSize(350, 40);
        suggestionList.setMaxSize(300, 100);
        String[] wordList = {"Work", "Biology", "Maths","Algorithem"};
        suggestionList.getItems().addAll(wordList);
        suggestionList.setOrientation(Orientation.VERTICAL);


        suggestionList.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                String selctedWord = suggestionList.getSelectionModel().getSelectedItem();
            }
        });

        root.getChildren().addAll(wordTextField,searchButton,meaningLabel,suggestionList);
        return root;
    }

    @Override
    public void start(Stage stage) throws IOException {
        // FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(createContent());
        stage.setTitle("Dictionary!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}