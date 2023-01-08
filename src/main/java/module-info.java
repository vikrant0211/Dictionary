module com.example.dictinary123 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dictionary to javafx.fxml;
    exports com.example.dictionary;
}