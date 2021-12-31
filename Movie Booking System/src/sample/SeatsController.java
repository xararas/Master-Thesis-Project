package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SeatsController implements Initializable {

  public static String movieTitle = null;
  public static String movieDate  = null;
  public static String movieTime  = null;
  public static String name = null;

  public static ArrayList<String> list           = new ArrayList<String>();
  public static ArrayList<String> enabledButtons = new ArrayList<String>();


  @FXML
  public Button logoutButton;
  @FXML
  private Label     userLabel;
  @FXML
  private ImageView imageView;
  @FXML
  private ImageView movieImageView;
  @FXML
  private Label     titleLabel;
  @FXML
  private ImageView seatsImageView;
  @FXML
  private Label     dateLabel;
  @FXML
  private Label  timeLabel;
  @FXML
  private Button A1;
  @FXML
  private Button A2;
  @FXML
  private Button A3;
  @FXML
  private Button A4;
  @FXML
  private Button A5;
  @FXML
  private Button B1;
  @FXML
  private Button B2;
  @FXML
  private Button B3;
  @FXML
  private Button B4;
  @FXML
  private Button B5;
  @FXML
  private Button C1;
  @FXML
  private Button C2;
  @FXML
  private Button C3;
  @FXML
  private Button C4;
  @FXML
  private Button C5;
  @FXML
  private Label  totalPriceLabel;
  @FXML
  private Button bookButton;
  @FXML
  private Button backButton;
  @FXML
  private AnchorPane menuAnchorPane;
  @FXML
  private ImageView menuImageView;

  public       double totalPrice  = 0;
  public final double ticketPrice = 7.5;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

    File  file  = new File("Images/main.png");
    Image image = new Image(file.toURI().toString());
    imageView.setImage(image);
    File  fl    = new File("Images/menu.png");
    Image img   = new Image(fl.toURI().toString());
    menuImageView.setImage(img);
    userLabel.setText("Welcome " + DatabaseConnection.username);
    dateLabel.setText("Date: " + MainController.movie_date);
    timeLabel.setText("Time: " + MainController.movie_time);
    bookButton.setDisable(true);
    menuAnchorPane.setVisible(false);
    summary();
  }

  public void summary() {

    DatabaseConnection db = new DatabaseConnection();

    if (MainController.movie_title.equals("Interstellar")) {
      titleLabel.setText(MainController.movie_title);
      movieTitle = titleLabel.getText();
      File  file  = new File("Images/movie1.png");
      Image image = new Image(file.toURI().toString());
      movieImageView.setImage(image);
      notAvailableSeats();

    } else if (MainController.movie_title.equals("1917")) {
      titleLabel.setText(MainController.movie_title);
      movieTitle = titleLabel.getText();
      File  file  = new File("Images/movie2.png");
      Image image = new Image(file.toURI().toString());
      movieImageView.setImage(image);
      notAvailableSeats();


    } else if (MainController.movie_title.equals("Titanic")) {
      titleLabel.setText(MainController.movie_title);
      movieTitle = titleLabel.getText();
      File  file  = new File("Images/movie3.png");
      Image image = new Image(file.toURI().toString());
      movieImageView.setImage(image);
      notAvailableSeats();


    } else if (MainController.movie_title.equals("The Avengers")) {
      titleLabel.setText(MainController.movie_title);
      movieTitle = titleLabel.getText();
      File  file  = new File("Images/movie4.png");
      Image image = new Image(file.toURI().toString());
      movieImageView.setImage(image);
      notAvailableSeats();

    } else if (MainController.movie_title.equals(
        "Star Wars The Rise of Skywalker")) {
      titleLabel.setText(MainController.movie_title);
      movieTitle = titleLabel.getText();
      File  file  = new File("Images/movie5.png");
      Image image = new Image(file.toURI().toString());
      movieImageView.setImage(image);
      notAvailableSeats();

    } else if (MainController.movie_title.equals("Forrest Gump")) {
      titleLabel.setText(MainController.movie_title);
      movieTitle = titleLabel.getText();
      File  file  = new File("Images/movie6.png");
      Image image = new Image(file.toURI().toString());
      movieImageView.setImage(image);
      notAvailableSeats();

    } else if (MainController.movie_title.equals("Resident Evil")) {
      titleLabel.setText(MainController.movie_title);
      movieTitle = titleLabel.getText();
      File  file  = new File("Images/movie7.png");
      Image image = new Image(file.toURI().toString());
      movieImageView.setImage(image);
      notAvailableSeats();

    } else if (MainController.movie_title.equals("The Lord of the Rings The Fellowship of the Ring")) {
      titleLabel.setText(MainController.movie_title);
      movieTitle = titleLabel.getText();
      File  file  = new File("Images/movie8.png");
      Image image = new Image(file.toURI().toString());
      movieImageView.setImage(image);
      notAvailableSeats();
    }
  }

  DatabaseConnection db = new DatabaseConnection();

  public void notAvailableSeats() {

    DatabaseConnection db = new DatabaseConnection();

    for (String s : db.seatsNotAvailable(getDate(), getTime())) {

      if (s.equals(A1.getId())) {
        A1.setStyle("-fx-background-color: #B22222");
        A1.setDisable(true);
      } else if (s.equals(A2.getId())) {
        A2.setStyle("-fx-background-color: #B22222");
        A2.setDisable(true);
      } else if (s.equals(A3.getId())) {
        A3.setStyle("-fx-background-color: #B22222");
        A3.setDisable(true);
      } else if (s.equals(A4.getId())) {
        A4.setStyle("-fx-background-color: #B22222");
        A4.setDisable(true);
      } else if (s.equals(A5.getId())) {
        A5.setStyle("-fx-background-color: #B22222");
        A5.setDisable(true);
      } else if (s.equals(B1.getId())) {
        B1.setStyle("-fx-background-color: #B22222");
        B1.setDisable(true);
      } else if (s.equals(B2.getId())) {
        B2.setStyle("-fx-background-color: #B22222");
        B2.setDisable(true);
      } else if (s.equals(B3.getId())) {
        B3.setStyle("-fx-background-color: #B22222");
        B3.setDisable(true);
      } else if (s.equals(B4.getId())) {
        B4.setStyle("-fx-background-color: #B22222");
        B4.setDisable(true);
      } else if (s.equals(B5.getId())) {
        B5.setStyle("-fx-background-color: #B22222");
        B5.setDisable(true);
      } else if (s.equals(C1.getId())) {
        C1.setStyle("-fx-background-color: #B22222");
        C1.setDisable(true);
      } else if (s.equals(C2.getId())) {
        C2.setStyle("-fx-background-color: #B22222");
        C2.setDisable(true);
      } else if (s.equals(C3.getId())) {
        C3.setStyle("-fx-background-color: #B22222");
        C3.setDisable(true);
      } else if (s.equals(C4.getId())) {
        C4.setStyle("-fx-background-color: #B22222");
        C4.setDisable(true);
      } else if (s.equals(C5.getId())) {
        C5.setStyle("-fx-background-color: #B22222");
        C5.setDisable(true);
      }
    }
  }

  public String getDate() {
    String[] date = dateLabel.getText().split(": ");
    return date[1];
  }

  public String getTime() {
    String[] time = timeLabel.getText().split(": ");
    return time[1];
  }

  public void A1ButtonAction(ActionEvent event) {
    A1.setStyle("-fx-background-color: #228B22");
    setTotalPrice(ticketPrice);
    if (this.totalPrice > 45) {
      this.totalPrice = 0;
      list.clear();
      A1.setStyle(null);
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setContentText("You can't book more than 6 seats.");
      alert.show();
      totalPriceLabel.setText("Total Price: " + getTotalPrice() + "€");
      resetButtons();
      enabledButtons.clear();

    } else {
      totalPriceLabel.setText("Total Price: " + getTotalPrice() + "€");
      A1.setDisable(true);
      list.add(A1.getId());
      enabledButtons.add(A1.getId());
      bookButton.setDisable(false);
    }
  }

  public void A2ButtonAction(ActionEvent event) {
    A2.setStyle("-fx-background-color: #228B22");
    setTotalPrice(ticketPrice);
    if (this.totalPrice > 45) {
      this.totalPrice = 0;
      list.clear();
      A2.setStyle(null);
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setContentText("You can't book more than 6 seats.");
      alert.show();
      totalPriceLabel.setText("Total Price: " + getTotalPrice() + "€");
      resetButtons();
      enabledButtons.clear();

    } else {
      totalPriceLabel.setText("Total Price: " + getTotalPrice() + "€");
      A2.setDisable(true);
      list.add(A2.getId());
      enabledButtons.add(A2.getId());
      bookButton.setDisable(false);

    }
  }

  public void A3ButtonAction(ActionEvent event) {
    A3.setStyle("-fx-background-color: #228B22");
    setTotalPrice(ticketPrice);
    if (this.totalPrice > 45) {
      this.totalPrice = 0;
      list.clear();
      A3.setStyle(null);
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setContentText("You can't book more than 6 seats.");
      alert.show();
      totalPriceLabel.setText("Total Price: " + getTotalPrice() + "€");
      resetButtons();
      enabledButtons.clear();

    } else {
      totalPriceLabel.setText("Total Price: " + getTotalPrice() + "€");
      A3.setDisable(true);
      list.add(A3.getId());
      enabledButtons.add(A3.getId());
      bookButton.setDisable(false);

    }

  }

  public void A4ButtonAction(ActionEvent event) {
    A4.setStyle("-fx-background-color: #228B22");
    setTotalPrice(ticketPrice);
    if (this.totalPrice > 45) {
      this.totalPrice = 0;
      list.clear();
      A4.setStyle(null);
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setContentText("You can't book more than 6 seats.");
      alert.show();
      totalPriceLabel.setText("Total Price: " + getTotalPrice() + "€");
      resetButtons();
      enabledButtons.clear();

    } else {
      totalPriceLabel.setText("Total Price: " + getTotalPrice() + "€");
      A4.setDisable(true);
      list.add(A4.getId());
      enabledButtons.add(A4.getId());
      bookButton.setDisable(false);

    }
  }

  public void A5ButtonAction(ActionEvent event) {
    A5.setStyle("-fx-background-color: #228B22");
    setTotalPrice(ticketPrice);
    if (this.totalPrice > 45) {
      this.totalPrice = 0;
      list.clear();
      A5.setStyle(null);
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setContentText("You can't book more than 6 seats.");
      alert.show();
      totalPriceLabel.setText("Total Price: " + getTotalPrice() + "€");
      resetButtons();
      enabledButtons.clear();

    } else {
      totalPriceLabel.setText("Total Price: " + getTotalPrice() + "€");
      A5.setDisable(true);
      list.add(A5.getId());
      enabledButtons.add(A5.getId());
      bookButton.setDisable(false);

    }
  }

  public void B1ButtonAction(ActionEvent event) {
    B1.setStyle("-fx-background-color: #228B22");
    setTotalPrice(ticketPrice);
    if (this.totalPrice > 45) {
      this.totalPrice = 0;
      list.clear();
      B1.setStyle(null);
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setContentText("You can't book more than 6 seats.");
      alert.show();
      totalPriceLabel.setText("Total Price: " + getTotalPrice() + "€");
      resetButtons();
      enabledButtons.clear();

    } else {
      totalPriceLabel.setText("Total Price: " + getTotalPrice() + "€");
      B1.setDisable(true);
      list.add(B1.getId());
      enabledButtons.add(B1.getId());
      bookButton.setDisable(false);

    }

  }

  public void B2ButtonAction(ActionEvent event) {
    B2.setStyle("-fx-background-color: #228B22");
    setTotalPrice(ticketPrice);
    if (this.totalPrice > 45) {
      this.totalPrice = 0;
      list.clear();
      B2.setStyle(null);
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setContentText("You can't book more than 6 seats.");
      alert.show();
      totalPriceLabel.setText("Total Price: " + getTotalPrice() + "€");
      resetButtons();
      enabledButtons.clear();

    } else {
      totalPriceLabel.setText("Total Price: " + getTotalPrice() + "€");
      B2.setDisable(true);
      list.add(B2.getId());
      enabledButtons.add(B2.getId());
      bookButton.setDisable(false);

    }

  }

  public void B3ButtonAction(ActionEvent event) {
    B3.setStyle("-fx-background-color: #228B22");
    setTotalPrice(ticketPrice);
    if (this.totalPrice > 45) {
      this.totalPrice = 0;
      list.clear();
      B3.setStyle(null);
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setContentText("You can't book more than 6 seats.");
      alert.show();
      totalPriceLabel.setText("Total Price: " + getTotalPrice() + "€");
      resetButtons();
      enabledButtons.clear();

    } else {
      totalPriceLabel.setText("Total Price: " + getTotalPrice() + "€");
      B3.setDisable(true);
      list.add(B3.getId());
      enabledButtons.add(B3.getId());
      bookButton.setDisable(false);

    }

  }

  public void B4ButtonAction(ActionEvent event) {
    B4.setStyle("-fx-background-color: #228B22");
    setTotalPrice(ticketPrice);
    if (this.totalPrice > 45) {
      this.totalPrice = 0;
      list.clear();
      B4.setStyle(null);
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setContentText("You can't book more than 6 seats.");
      alert.show();
      totalPriceLabel.setText("Total Price: " + getTotalPrice() + "€");
      resetButtons();
      enabledButtons.clear();

    } else {
      totalPriceLabel.setText("Total Price: " + getTotalPrice() + "€");
      B4.setDisable(true);
      list.add(B4.getId());
      enabledButtons.add(B4.getId());
      bookButton.setDisable(false);

    }

  }

  public void B5ButtonAction(ActionEvent event) {
    B5.setStyle("-fx-background-color: #228B22");
    setTotalPrice(ticketPrice);
    if (this.totalPrice > 45) {
      this.totalPrice = 0;
      list.clear();
      B5.setStyle(null);
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setContentText("You can't book more than 6 seats.");
      alert.show();
      totalPriceLabel.setText("Total Price: " + getTotalPrice() + "€");
      resetButtons();
      enabledButtons.clear();

    } else {
      totalPriceLabel.setText("Total Price: " + getTotalPrice() + "€");
      B5.setDisable(true);
      list.add(B5.getId());
      enabledButtons.add(B5.getId());
      bookButton.setDisable(false);

    }

  }

  public void C1ButtonAction(ActionEvent event) {
    C1.setStyle("-fx-background-color: #228B22");
    setTotalPrice(ticketPrice);
    if (this.totalPrice > 45) {
      this.totalPrice = 0;
      list.clear();
      C1.setStyle(null);
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setContentText("You can't book more than 6 seats.");
      alert.show();
      totalPriceLabel.setText("Total Price: " + getTotalPrice() + "€");
      resetButtons();
      enabledButtons.clear();

    } else {
      totalPriceLabel.setText("Total Price: " + getTotalPrice() + "€");
      C1.setDisable(true);
      list.add(C1.getId());
      enabledButtons.add(C1.getId());
      bookButton.setDisable(false);

    }
  }

  public void C2ButtonAction(ActionEvent event) {
    C2.setStyle("-fx-background-color: #228B22");
    setTotalPrice(ticketPrice);
    if (this.totalPrice > 45) {
      this.totalPrice = 0;
      list.clear();
      C2.setStyle(null);
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setContentText("You can't book more than 6 seats.");
      alert.show();
      totalPriceLabel.setText("Total Price: " + getTotalPrice() + "€");
      resetButtons();
      enabledButtons.clear();

    } else {
      totalPriceLabel.setText("Total Price: " + getTotalPrice() + "€");
      C2.setDisable(true);
      list.add(C2.getId());
      enabledButtons.add(C2.getId());
      bookButton.setDisable(false);

    }
  }

  public void C3ButtonAction(ActionEvent event) {
    C3.setStyle("-fx-background-color: #228B22");
    setTotalPrice(ticketPrice);
    if (this.totalPrice > 45) {
      this.totalPrice = 0;
      list.clear();
      C3.setStyle(null);
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setContentText("You can't book more than 6 seats.");
      alert.show();
      totalPriceLabel.setText("Total Price: " + getTotalPrice() + "€");
      resetButtons();
      enabledButtons.clear();

    } else {
      totalPriceLabel.setText("Total Price: " + getTotalPrice() + "€");
      C3.setDisable(true);
      list.add(C3.getId());
      enabledButtons.add(C3.getId());
      bookButton.setDisable(false);

    }
  }

  public void C4ButtonAction(ActionEvent event) {
    C4.setStyle("-fx-background-color: #228B22");
    setTotalPrice(ticketPrice);
    if (this.totalPrice > 45) {
      this.totalPrice = 0;
      list.clear();
      C4.setStyle(null);
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setContentText("You can't book more than 6 seats.");
      alert.show();
      totalPriceLabel.setText("Total Price: " + getTotalPrice() + "€");
      resetButtons();
      enabledButtons.clear();

    } else {
      totalPriceLabel.setText("Total Price: " + getTotalPrice() + "€");
      C4.setDisable(true);
      list.add(C4.getId());
      enabledButtons.add(C4.getId());
      bookButton.setDisable(false);

    }
  }

  public void C5ButtonAction(ActionEvent event) {
    C5.setStyle("-fx-background-color: #228B22");
    setTotalPrice(ticketPrice);
    if (this.totalPrice > 45) {
      this.totalPrice = 0;
      list.clear();
      C5.setStyle(null);
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setContentText("You can't book more than 6 seats.");
      alert.show();
      totalPriceLabel.setText("Total Price: " + getTotalPrice() + "€");
      resetButtons();
      enabledButtons.clear();

    } else {
      totalPriceLabel.setText("Total Price: " + getTotalPrice() + "€");
      C5.setDisable(true);
      list.add(C5.getId());
      enabledButtons.add(C5.getId());
      bookButton.setDisable(false);

    }

  }

  public void setTotalPrice(double price) {
    this.totalPrice += price;

  }

  public double getTotalPrice() {
    return this.totalPrice;
  }

  public void bookButtonAction(ActionEvent event) {

    selectedButtons();
    enabledButtons.clear();

    try {

      Parent root   = FXMLLoader.load(getClass().getResource("booked.fxml"));
      Stage  booked = new Stage();
      Image icon = new Image(getClass().getResourceAsStream("icon.png"));
      booked.getIcons().add(icon);
      booked.setTitle("CineFilm");
      booked.setScene(new Scene(root, 700, 620));
      booked.show();
      closeSeatStage();

    } catch (Exception e) {
      e.printStackTrace();
      e.getCause();
    }
  }

  public void closeSeatStage() {
    Stage stage = (Stage) bookButton.getScene().getWindow();
    stage.close();

  }

  public void resetButtons() {

    for (String s : enabledButtons) {
      if (s.equals(A1.getId())) {
        A1.setStyle("");
        A1.setDisable(false);
      } else if (s.equals(A2.getId())) {
        A2.setStyle("");
        A2.setDisable(false);
      } else if (s.equals(A3.getId())) {
        A3.setStyle("");
        A3.setDisable(false);
      } else if (s.equals(A4.getId())) {
        A4.setStyle("");
        A4.setDisable(false);
      } else if (s.equals(A5.getId())) {
        A5.setStyle("");
        A5.setDisable(false);
      } else if (s.equals(B1.getId())) {
        B1.setStyle("");
        B1.setDisable(false);
      } else if (s.equals(B2.getId())) {
        B2.setStyle("");
        B2.setDisable(false);
      } else if (s.equals(B3.getId())) {
        B3.setStyle("");
        B3.setDisable(false);
      } else if (s.equals(B4.getId())) {
        B4.setStyle("");
        B4.setDisable(false);
      } else if (s.equals(B5.getId())) {
        B5.setStyle("");
        B5.setDisable(false);
      } else if (s.equals(C1.getId())) {
        C1.setStyle("");
        C1.setDisable(false);
      } else if (s.equals(C2.getId())) {
        C2.setStyle("");
        C2.setDisable(false);
      } else if (s.equals(C3.getId())) {
        C3.setStyle("");
        C3.setDisable(false);
      } else if (s.equals(C4.getId())) {
        C4.setStyle("");
        C4.setDisable(false);
      } else if (s.equals(C5.getId())) {
        C5.setStyle("");
        C5.setDisable(false);
      }
    }
    bookButton.setDisable(true);
  }

  public void selectedButtons() {

    for (String s : enabledButtons) {

      if (s.equals(A1.getId())) {

        db.bookSeat(db.movieID(movieTitle), A1.getId(), getDate(),
                    getTime(),getName());

      } else if (s.equals(A2.getId())) {

        db.bookSeat(db.movieID(movieTitle), A2.getId(), getDate(),
                    getTime(),getName());
      }

      else if (s.equals(A3.getId())) {

        db.bookSeat(db.movieID(movieTitle), A3.getId(), getDate(),
                    getTime(),getName());
      }

      else if (s.equals(A4.getId())) {

        db.bookSeat(db.movieID(movieTitle), A4.getId(), getDate(),
                    getTime(),getName());
      }

      else if (s.equals(A5.getId())) {

        db.bookSeat(db.movieID(movieTitle), A5.getId(), getDate(),
                    getTime(),getName());
      }

      else if (s.equals(B1.getId())) {

        db.bookSeat(db.movieID(movieTitle), B1.getId(), getDate(),
                    getTime(),getName());
      }

      else if (s.equals(B2.getId())) {

        db.bookSeat(db.movieID(movieTitle), B2.getId(), getDate(),
                    getTime(),getName());
      }

      else if (s.equals(B3.getId())) {

        db.bookSeat(db.movieID(movieTitle), B3.getId(), getDate(),
                    getTime(),getName());
      }

      else if (s.equals(B4.getId())) {

        db.bookSeat(db.movieID(movieTitle), B4.getId(), getDate(),
                    getTime(),getName());
      }

      else if (s.equals(B5.getId())) {

        db.bookSeat(db.movieID(movieTitle), B5.getId(), getDate(),
                    getTime(),getName());
      }

      else if (s.equals(C1.getId())) {

        db.bookSeat(db.movieID(movieTitle), C1.getId(), getDate(),
                    getTime(),getName());
      }

      else if (s.equals(C2.getId())) {

        db.bookSeat(db.movieID(movieTitle), C2.getId(), getDate(),
                    getTime(),getName());
      }

      else if (s.equals(C3.getId())) {

        db.bookSeat(db.movieID(movieTitle), C3.getId(), getDate(),
                    getTime(),getName());
      }

      else if (s.equals(C4.getId())) {

        db.bookSeat(db.movieID(movieTitle), C4.getId(), getDate(),
                    getTime(),getName());
      }

      else if (s.equals(C5.getId())) {

        db.bookSeat(db.movieID(movieTitle), C5.getId(), getDate(),
                    getTime(),getName());
      }
    }
  }

  public void backButtonAction(ActionEvent event) {

    Stage stage = (Stage) backButton.getScene().getWindow();
    stage.close();

    try {

      Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
      Stage main = new Stage();
      Image icon = new Image(getClass().getResourceAsStream("icon.png"));
      main.getIcons().add(icon);
      main.setScene(new Scene(root, 700, 700));
      main.show();

    } catch (Exception e) {
      e.printStackTrace();
      e.getCause();
    }
  }

  public String getName() {
    DatabaseConnection db = new DatabaseConnection();
    ArrayList<String> arrayList = new ArrayList<String>();
    String s = null;
    String[] array = null;

    arrayList = db.getName(db.getUsername());
    s = arrayList.toString();
    array = s.split(", ");
    s = array[0].replace("[", "") + " " + array[1].replace("]", "");
    return  this.name = s;
  }

  public void menuButtonAction(ActionEvent event) {

    menuAnchorPane.setVisible(true);

  }

  public void logoutButtonAction(ActionEvent event) {

    Stage stage = (Stage) bookButton.getScene().getWindow();
    stage.close();

    Stage stage1 = new Stage();
    stage1.initOwner(Main.getPrimaryStage());


  }

  public void hideMenuAnchorPane() {

    menuAnchorPane.setVisible(false);
  }

  public void purchaseButtonAction(ActionEvent event) {

    try {

      Parent root  = FXMLLoader.load(getClass().getResource("purchase.fxml"));
      Stage  seats = new Stage();
      seats.setTitle("CineFilm");
      Image icon = new Image(getClass().getResourceAsStream("icon.png"));
      seats.getIcons().add(icon);
      seats.setScene(new Scene(root, 700, 650));
      seats.show();

    } catch (Exception e) {
      e.printStackTrace();
      e.getCause();
    }
  }

  public void accountButtonAction(ActionEvent event) {

    try {

      Parent root  = FXMLLoader.load(getClass().getResource("account.fxml"));
      Stage  seats = new Stage();
      seats.setTitle("CineFilm");
      Image icon = new Image(getClass().getResourceAsStream("icon.png"));
      seats.getIcons().add(icon);
      seats.setScene(new Scene(root, 700, 650));
      seats.show();

    } catch (Exception e) {
      e.printStackTrace();
      e.getCause();
    }
  }
}

