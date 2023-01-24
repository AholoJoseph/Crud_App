package com.example.projuct_crud;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


public class HelloController implements Initializable {
//LOGIN


//MAIN
    @FXML
    private Button addID;

    @FXML
    private TextField courseID;

    @FXML
    private TableColumn<Model_Table, String> course_Column;

    @FXML
    private Button delID;

    @FXML
    private TextField hallID;

    @FXML
    private TableColumn<Model_Table,String > hall_Column;

    @FXML
    private TableColumn<Model_Table, Integer> id_Column;

    @FXML
    private TextField indexID;

    @FXML
    private TableColumn<Model_Table,String> index_Column;

    @FXML
    private TextField mobileID;

    @FXML
    private TableColumn<Model_Table,String> mobile_Column;

    @FXML
    private TextField nameID;

    @FXML
    private TableColumn<Model_Table,String> stdname_Column;

    ObservableList<Model_Table> print = FXCollections.observableArrayList();

    @FXML
    private TableView< Model_Table> tableID;

    @FXML
    private Button updateID;



    Connection con;
    PreparedStatement pst;

    int At_Index;
    int id;

    public void Connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/students", "root", "");
        } catch (ClassNotFoundException | SQLException exception) {
            exception.printStackTrace();
        }
    }






    @FXML
    void OnAdd(ActionEvent event) throws SQLException, ClassNotFoundException {

        String name, index, course, mobile, hall;

        name = nameID.getText();
        index = indexID.getText();
        course = courseID.getText();
        mobile = mobileID.getText();
        hall = hallID.getText();


        pst = con.prepareStatement("insert into register(Name,Index_Num,Course,Mobile,Hall)values(?,?,?,?,?)");
            pst.setString(1, name);
            pst.setString(2, index);
            pst.setString(3, course);
            pst.setString(4, mobile);
            pst.setString(5, hall);
            pst.executeUpdate();


            //print message
            Alert message = new Alert(Alert.AlertType.CONFIRMATION);
            message.setTitle("Student Registration");
            message.setContentText("Record Added Successfully");
            message.show();

            nameID.setText("");
            indexID.setText("");
            courseID.setText("");
            mobileID.setText("");
            hallID.setText("");
            load_table();
    }


    @FXML
    void OnDel(ActionEvent event) throws SQLException, ClassNotFoundException {
        At_Index = tableID.getSelectionModel().getSelectedIndex();
        id = Integer.parseInt(String.valueOf(tableID.getItems().get(At_Index).getStudent_ID()));

        pst = con.prepareStatement("delete from register where Student_ID = ?");
        pst.setInt(1,id);
        pst.executeUpdate();

        //print message
        Alert message = new Alert(Alert.AlertType.WARNING);
        message.setTitle("Student Registration");
        message.setContentText("Record Deleted successfully");
        message.show();

        nameID.setText("");
        indexID.setText("");
        courseID.setText("");
        mobileID.setText("");
        hallID.setText("");
        load_table();

    }


    @FXML
    void OnUpdate(ActionEvent event) throws ClassNotFoundException, SQLException {

        At_Index = tableID.getSelectionModel().getSelectedIndex();


        String name, index, course, mobile, hall;
        id = Integer.parseInt(String.valueOf(tableID.getItems().get(At_Index).getStudent_ID()));

        name = nameID.getText();
        index = indexID.getText();
        course = courseID.getText();
        mobile = mobileID.getText();
        hall = hallID.getText();

        try {
            pst = con.prepareStatement("update register set Name = ?,Index_Num = ?,Course = ?,Mobile = ?,Hall = ? where Student_ID = ?");
            pst.setString(1, name);
            pst.setString(2, index);
            pst.setString(3, course);
            pst.setString(4, mobile);
            pst.setString(5, hall);
            pst.setInt(6, id);

            pst.executeUpdate();


            //print message
            Alert message = new Alert(Alert.AlertType.INFORMATION);
            message.setTitle("REGISTRATION");
            message.setTitle("Student Registration");
            message.setContentText("Record Updated successfully");
            message.show();

            nameID.setText("");
            indexID.setText("");
            courseID.setText("");
            mobileID.setText("");
            hallID.setText("");

            load_table();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Connect();


        try {
            load_table();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void load_table() throws SQLException {

        print = FXCollections.observableArrayList();

        pst = con.prepareStatement("select * from register");
        ResultSet result = pst.executeQuery();

        while (result.next()) {
            Model_Table table = new Model_Table();

            table.setStudent_ID(result.getString("Student_ID"));
            table.setName(result.getString("Name"));
            table.setIndex_Num(result.getString("Index_Num"));
            table.setCourse(result.getString("Course"));
            table.setMobile(result.getString("Mobile"));
            table.setHall(result.getString("Hall"));

            print.add(table);

            tableID.setRowFactory(tv->{
                TableRow<Model_Table>myRow = new TableRow<>();
                myRow.setOnMouseClicked(mouseEvent -> {
                    if (mouseEvent.getClickCount() == 1 && (!myRow.isEmpty())) {
                        At_Index = tableID.getSelectionModel().getSelectedIndex();

                        At_Index = tableID.getSelectionModel().getSelectedIndex();
                        id = Integer.parseInt(String.valueOf(tableID.getItems().get(At_Index).Student_ID));
                        nameID.setText(tableID.getItems().get(At_Index).Name);
                        indexID.setText(tableID.getItems().get(At_Index).Index_Num);
                        courseID.setText(tableID.getItems().get(At_Index).Course);
                        mobileID.setText(tableID.getItems().get(At_Index).Mobile);
                        hallID.setText(tableID.getItems().get(At_Index).Hall);

                    }
                });
                return myRow;
            });

            id_Column.setCellValueFactory(new PropertyValueFactory<>("Student_ID"));
            stdname_Column.setCellValueFactory(new PropertyValueFactory<>("Name"));
            index_Column.setCellValueFactory(new PropertyValueFactory<>("Index_Num"));
            course_Column.setCellValueFactory(new PropertyValueFactory<>("Course"));
            mobile_Column.setCellValueFactory(new PropertyValueFactory<>("Mobile"));
            hall_Column.setCellValueFactory(new PropertyValueFactory<>("Hall"));

            tableID.setItems(print);

        }

    }


}





