module com.example.projuct_crud {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens com.example.projuct_crud to javafx.fxml;
    exports com.example.projuct_crud;
}