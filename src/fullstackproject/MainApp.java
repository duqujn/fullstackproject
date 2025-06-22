package fullstackproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;



public class MainApp extends Application {
public void start(Stage primaryStage){

    //menuBar
    MenuBar menuBar = new MenuBar();
    Menu fileMenu = new Menu("File");
    Menu editMenu = new Menu("Edit");
    Menu ThemeMenu = new Menu("Theme");
    Menu helpMenu = new Menu("Help");
    MenuItem exitItem = new MenuItem("Exit");
    fileMenu.getItems().addAll(exitItem);
    menuBar.getMenus().addAll(fileMenu, editMenu, ThemeMenu, helpMenu);

    Image profileImage = new Image(getClass().getResource("/images/userIcon.jpg").toExternalForm());
    ImageView profileImageView = new ImageView(profileImage);
    profileImageView.setFitHeight(100);
    profileImageView.setFitWidth(100);
    VBox leftbox = new VBox(profileImageView);
    leftbox.setId("left-box");

    //tableview Center
    TableView<Object> tableView = new TableView<>();
    TableColumn<Object, String> idCol = new TableColumn<>("ID");
    TableColumn<Object, String> firstNameCol = new TableColumn<>("First Name");
    TableColumn<Object, String> lastNameCol = new TableColumn<>("Last Name");
    TableColumn<Object, String> deptCol = new TableColumn<>("Department");
    TableColumn<Object, String> majorCol = new TableColumn<>("Major");
    TableColumn<Object, String> emailCol = new TableColumn<>("Email");

    tableView.getColumns().addAll(idCol, firstNameCol, lastNameCol, deptCol, emailCol );

    //right form
    VBox rightbox = new VBox(10);
    rightbox.setId("right-box");

    VBox textfieldBox = new VBox(10);
    TextField firstNameField = new TextField();
    firstNameField.setPromptText("First Name");
    TextField lastNameField = new TextField();
    lastNameField.setPromptText("Last Name");
    TextField deptField = new TextField();
    deptField.setPromptText("Department");
    TextField majorField = new TextField();
    majorField.setPromptText("Major");
    TextField emailField = new TextField();
    emailField.setPromptText("Email");
    TextField imageField = new TextField();
    imageField.setPromptText("ImageURL");
    textfieldBox.getChildren().addAll(
            firstNameField, lastNameField, deptField, majorField, emailField, imageField
    );

    VBox buttonBox = new VBox(10);
    Button clearButton = new Button("Clear");
    clearButton.setPrefWidth(150);
    clearButton.setPrefHeight(40);
    Button addButton = new Button("Add");
    addButton.setPrefWidth(150);
    addButton.setPrefHeight(40);
    Button deleteButton = new Button("Delete");
    deleteButton.setPrefWidth(150);
    deleteButton.setPrefHeight(40);
    Button editButton = new Button("Edit");
    editButton.setPrefWidth(150);
    editButton.setPrefHeight(40);

    buttonBox.getChildren().addAll(
        clearButton, addButton, deleteButton, editButton
    );

    rightbox.getChildren().addAll(textfieldBox, buttonBox);
    buttonBox.setPadding(new Insets(175, 0, 0, 0));

    //root layout
    BorderPane root = new BorderPane();
    root.setTop(menuBar);
    root.setLeft(leftbox);
    root.setCenter(tableView);
    root.setRight(rightbox);

    Scene scene = new Scene(root, 900, 600);
    scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

    primaryStage.setTitle("Full Stack Project");
    primaryStage.setScene(scene);
    primaryStage.show();

    exitItem.setOnAction(event -> System.exit(0));
}

public static void main(String[] args) {
    launch(args);}
}
