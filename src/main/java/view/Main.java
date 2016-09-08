package view;

import com.sun.javafx.collections.ImmutableObservableList;
import controller.ManageEmployee;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Client;

/**
 * Created by alex on 15.08.2016.
 */
public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane borderPane = new BorderPane();

        HBox hBoxTop = addTopHBox();
        VBox vBoxLeft = addLeftVBox();
        VBox vBoxRight = addRightVBox();

        borderPane.setTop(hBoxTop);
        borderPane.setLeft(vBoxLeft);
        borderPane.setCenter(vBoxRight);

        Parent root = borderPane;
        root.minHeight(400);
        root.minWidth(600);
        primaryStage.setTitle("Client Book");
        Scene scene = new Scene(root, 810, 500);
        primaryStage.setMinHeight(400);
        primaryStage.setMinWidth(600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private HBox addTopHBox(){
        //<------------------------Кнопка назад---------------------------->
        Image image = new Image("arrow-icon.png");
        ImageView imagePrev = new ImageView();
        imagePrev.setImage(image);
        imagePrev.setRotate(180);
        Button buttonPrev = new Button();
        buttonPrev.setPrefSize(35,35);
        buttonPrev.setGraphic(imagePrev);
        //<------------------------Кнопка вперед---------------------------->
        Button buttonNext = new Button();
        buttonNext.setPrefSize(35,35);
        ImageView imageNext = new ImageView();
        imageNext.setImage(image);
        buttonNext.setGraphic(imageNext);
        //<------------------------Кнопка домой---------------------------->
        Image imageHome = new Image("home-icon.png");
        ImageView imageViewHome = new ImageView(imageHome);
        Button buttonHome = new Button();
        buttonHome.setPrefSize(35,35);
        buttonHome.setGraphic(imageViewHome);
        //<------------------------Кнопка поиск---------------------------->
        Image imageSearch = new Image("search-icon.png");
        ImageView imageViewSearch = new ImageView(imageSearch);
        Button buttonSearch = new Button("Поиск");
        buttonSearch.setPrefSize(80,35);
        buttonSearch.setGraphic(imageViewSearch);
        buttonSearch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SearchForm searchForm = new SearchForm();
                Stage stage = new Stage();
                try {
                    searchForm.start(stage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        //<--------------------------------------------------------------->
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(5,5,5,5));
        hBox.setSpacing(5);
        hBox.setPrefSize(800,40);
        hBox.setMinSize(600,30);
        hBox.getChildren().add(buttonPrev);
        hBox.getChildren().add(buttonNext);
        hBox.getChildren().add(buttonHome);
        hBox.getChildren().add(buttonSearch);
        return hBox;
    }

    private VBox addLeftVBox(){
        VBox vBox = new VBox();
        vBox.setPrefSize(450,440);
        vBox.setMinSize(390,360);
        vBox.setPadding(new Insets(5,5,5,5));
        //TODO: Изменить после
        ManageEmployee me = new ManageEmployee();
        ObservableList<Client> data = me.listEmployees();


        //<----------1 Column--------------------->
        TableColumn fioCol = new TableColumn("ФИО");
        fioCol.setCellValueFactory(new PropertyValueFactory("name"));
        //<----------2 Column--------------------->
        TableColumn phoneCol = new TableColumn("Номер");
        phoneCol.setCellValueFactory(new PropertyValueFactory("phoneNumber"));
        //<---------3 Column---------------------->
        TableColumn emailCol = new TableColumn("email");
        emailCol.setCellValueFactory(new PropertyValueFactory("email"));

        TableView tableView = new TableView();
        tableView.setItems(data);
        tableView.getColumns().addAll(fioCol,phoneCol,emailCol);
        vBox.getChildren().add(tableView);
        return vBox;
    }

    private VBox addRightVBox(){
        VBox vBox = new VBox();
        vBox.setPrefSize(400,400);
        vBox.setPadding(new Insets(0,5,5,5));
        Text details = new Text("Информация клиента:");
        details.setFont(new Font("Arial",18));
        vBox.getChildren().add(details);
        //<---------------------------Карточка клиента----------------->
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(5,0,5,0));

        Text fio = new Text("ФИО: ");
        gridPane.add(fio,0,0);
        Label labelFIO = new Label("Hot Dog");
        gridPane.add(labelFIO,1,0);

        Text addres = new Text("Адрес: ");
        gridPane.add(addres,0,1);
        Label labelAddress = new Label("Lenina Street");
        gridPane.add(labelAddress,1,1);

        Text age = new Text("Возраст: ");
        gridPane.add(age,0,2);
        Label labelAge = new Label("20");
        gridPane.add(labelAge,1,2);

        Text weight = new Text("Рост: ");
        gridPane.add(weight,0,3);
        Label labelWeight = new Label("175");
        gridPane.add(labelWeight,1,3);

        Text height = new Text("Вес: ");
        gridPane.add(height,0,4);
        Label labelHeight = new Label("75");
        gridPane.add(labelHeight,1,4);

        Text sex = new Text("Пол: ");
        gridPane.add(sex,0,5);
        Label labelSex = new Label("1");
        gridPane.add(labelSex,1,5);

        Text phone = new Text("Номер телефона:  ");
        gridPane.add(phone,0,6);
        Label labelPhone = new Label("89236567899");
        gridPane.add(labelPhone,1,6);

        Text email = new Text("email: ");
        gridPane.add(email,0,7);
        Label labelEmail = new Label("vasya@pupkin@rambler.ru");
        gridPane.add(labelEmail,1,7);
        //<------------------------Кнопки--------------------------------->
        Button buttonPrint = new Button("Печать");
        buttonPrint.setPrefSize(75,35);
        Image imagePrint = new Image("print-icon.png");
        ImageView imageViewPrint = new ImageView(imagePrint);
        buttonPrint.setGraphic(imageViewPrint);

        Button buttonAdd = new Button("Добавить");
        buttonAdd.setPrefSize(90,35);
        Image imageAdd = new Image("add-icon.png");
        ImageView imageViewAdd = new ImageView(imageAdd);
        buttonAdd.setGraphic(imageViewAdd);

        Button buttonEdit = new Button("Изменить");
        buttonEdit.setPrefSize(90,35);
        Image imageEdit = new Image("edit-icon.png");
        ImageView imageViewEdit = new ImageView(imageEdit);
        buttonEdit.setGraphic(imageViewEdit);

        Button buttonRemove = new Button("Удалить");
        buttonRemove.setPrefSize(80,35);
        Image imageRemove = new Image("delete-icon.png");
        ImageView imageViewReamove = new ImageView(imageRemove);
        buttonRemove.setGraphic(imageViewReamove);
        //<--------------------Размещение---------------------->
        HBox buttonBox = new HBox(5);
        buttonBox.setPrefSize(400,40);
        //buttonBox.setPadding(new Insets(200,0,5,0));
        buttonBox.getChildren().addAll(buttonPrint,buttonAdd,buttonEdit,buttonRemove);

        vBox.getChildren().add(gridPane);
        vBox.getChildren().add(buttonBox);
        return vBox;
    }
}
