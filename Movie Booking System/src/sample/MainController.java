package sample;

import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.File;
import java.net.URL;
import java.util.*;

import javafx.scene.web.WebView;
import javafx.stage.WindowEvent;

public class MainController implements Initializable {

  public static String movie_title = null;
  public static String movie_date  = null;
  public static String movie_time  = null;
  public static int    movie_id    = 0;
  public static String movie_rating = null;
  public static double rating = 0;

  @FXML
  private Label      userLabel;
  @FXML
  private Button     logoutButton;
  @FXML
  private ComboBox   movieComboBox;
  @FXML
  private ImageView  imageView;
  @FXML
  private ImageView  movieImageView;
  @FXML
  private TextArea   movieTextArea;
  @FXML
  private TextField  genreTextField;
  @FXML
  private TextField  durationTextField;
  @FXML
  private ComboBox   dateComboBox;
  @FXML
  private ComboBox   timeComboBox;
  @FXML
  private Label      titleMainLabel;
  @FXML
  private Button     nextButton;
  @FXML
  private WebView    trailerWebView;
  @FXML
  private Button     trailerButton;
  @FXML
  private Text       descriptionText;
  @FXML
  private Text       genreText;
  @FXML
  private Text       durationText;
  @FXML
  private Button     menuButton;
  @FXML
  private ImageView  menuImageView;
  @FXML
  private AnchorPane menuAnchorPane;
  @FXML
  private Button     purchaseButton;
  @FXML
  private Button     accountButton;
  @FXML
  private Button     backButton;
  @FXML
  private Label ratingLabel;
  @FXML
  private Text ratingText;
  @FXML
  private Pane ratingPane;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

    File  file  = new File("Images/main.png");
    Image image = new Image(file.toURI().toString());
    File  fl    = new File("Images/menu.png");
    Image img   = new Image(fl.toURI().toString());
    menuImageView.setImage(img);
    imageView.setImage(image);
    movieTextArea.setVisible(false);
    descriptionText.setVisible(false);
    genreText.setVisible(false);
    genreTextField.setVisible(false);
    durationText.setVisible(false);
    durationTextField.setVisible(false);
    trailerButton.setVisible(false);
    nextButton.setDisable(true);
    menuAnchorPane.setVisible(false);
    ratingPane.setVisible(false);
    ratingText.setVisible(false);
    userStatus();

    DatabaseConnection db = new DatabaseConnection();
    ObservableList<String> list =
        FXCollections.observableArrayList(db.movieList());
    movieComboBox.setItems(list);
    purchaseButton.setOnMouseEntered(e -> purchaseButton.setStyle("-fx-background-color: #F5F5F5"));
    purchaseButton.setOnMouseExited(e -> purchaseButton.setStyle("-fx-background-color:  #dcdcdc"));
    accountButton.setOnMouseEntered(e -> accountButton.setStyle("-fx-background-color: #F5F5F5"));
    accountButton.setOnMouseExited(e -> accountButton.setStyle("-fx-background-color:  #dcdcdc"));
    logoutButton.setOnMouseEntered(e -> logoutButton.setStyle("-fx-background-color: #F5F5F5"));
    logoutButton.setOnMouseExited(e -> logoutButton.setStyle("-fx-background-color:  #dcdcdc"));

  }


  public void userStatus() {

    DatabaseConnection db = new DatabaseConnection();

    userLabel.setText("Welcome " + db.getUsername());
  }

  public void menuButtonAction(ActionEvent event) {

    menuAnchorPane.setVisible(true);

  }

  public void logoutButtonAction(ActionEvent event) {

    Stage stage = (Stage) logoutButton.getScene().getWindow();
    stage.close();
  }

  public void hideMenuAnchorPane() {

    menuAnchorPane.setVisible(false);
  }

  public void movieComboBox(ActionEvent event) {

    String s = movieComboBox.getSelectionModel().getSelectedItem().toString();

    if (s.equals("Interstellar")) {
      movieTextArea.setVisible(true);
      descriptionText.setVisible(true);
      genreText.setVisible(true);
      genreTextField.setVisible(true);
      durationText.setVisible(true);
      durationTextField.setVisible(true);
      trailerButton.setVisible(true);
      titleMainLabel.setText("Interstellar");
      setMovieTitle(titleMainLabel.getText());
      File  file  = new File("Images/movie1.png");
      Image image = new Image(file.toURI().toString());
      movieImageView.setImage(image);
      DatabaseConnection db = new DatabaseConnection();
      movieTextArea.setText(db.movieSummary("Interstellar"));
      movieTextArea.setWrapText(true);
      genreTextField.setText(db.movieGenre("Interstellar"));
      durationTextField.setText(db.movieDuration("Interstellar"));
      movie_id = db.movieID(movie_title);
      ratingPane.setVisible(true);
      ratingText.setVisible(true);
      movie_rating = db.getRating(movie_title);
      ratingLabel.setText(movie_rating);
      rating = Double.parseDouble(movie_rating);
      if(rating > 7.0) {
        ratingLabel.setText(movie_rating);
        ratingPane.setStyle("-fx-background-color: #228B22");
      }

      else  if (rating < 7.0) {
        ratingLabel.setText(movie_rating);
        ratingPane.setStyle("-fx-background-color: #DAA520");
      }

      ObservableList<String> date =
          FXCollections.observableArrayList(db.dateList(db.movieDate(
              "Interstellar")));
      dateComboBox.setItems(date);

      ObservableList<String> time =
          FXCollections.observableArrayList(db.timeList(db.movieTime(
              "Interstellar")));
      timeComboBox.setItems(time);

    } else if (s.equals("1917")) {
      movieTextArea.setVisible(true);
      descriptionText.setVisible(true);
      genreText.setVisible(true);
      genreTextField.setVisible(true);
      durationText.setVisible(true);
      durationTextField.setVisible(true);
      trailerButton.setVisible(true);
      titleMainLabel.setText("1917");
      setMovieTitle(titleMainLabel.getText());
      File  file  = new File("Images/movie2.png");
      Image image = new Image(file.toURI().toString());
      movieImageView.setImage(image);
      DatabaseConnection db = new DatabaseConnection();
      movieTextArea.setText(db.movieSummary("1917"));
      movieTextArea.setWrapText(true);
      genreTextField.setText(db.movieGenre("1917"));
      durationTextField.setText(db.movieDuration("1917"));
      movie_id = db.movieID(movie_title);
      ratingPane.setVisible(true);
      ratingText.setVisible(true);
      movie_rating = db.getRating(movie_title);
      rating = Double.parseDouble(movie_rating);
      if(rating > 7.0) {
        ratingLabel.setText(movie_rating);
        ratingPane.setStyle("-fx-background-color: #228B22");
      }

      else  if (rating < 7.0) {
        ratingLabel.setText(movie_rating);
        ratingPane.setStyle("-fx-background-color: #DAA520");
      }

      ObservableList<String> list =
          FXCollections.observableArrayList(db.dateList(db.movieDate(
              "1917")));
      dateComboBox.setItems(list);
      ObservableList<String> list1 =
          FXCollections.observableArrayList(db.timeList(db.movieTime(
              "1917")));
      timeComboBox.setItems(list1);


    } else if (s.equals("Titanic")) {
      movieTextArea.setVisible(true);
      descriptionText.setVisible(true);
      genreText.setVisible(true);
      genreTextField.setVisible(true);
      durationText.setVisible(true);
      durationTextField.setVisible(true);
      trailerButton.setVisible(true);
      titleMainLabel.setText("Titanic");
      setMovieTitle(titleMainLabel.getText());
      File  file  = new File("Images/movie3.png");
      Image image = new Image(file.toURI().toString());
      movieImageView.setImage(image);
      DatabaseConnection db = new DatabaseConnection();
      movieTextArea.setText(db.movieSummary("Titanic"));
      movieTextArea.setWrapText(true);
      genreTextField.setText(db.movieGenre("Titanic"));
      durationTextField.setText(db.movieDuration("Titanic"));
      movie_id = db.movieID(movie_title);
      ratingPane.setVisible(true);
      ratingText.setVisible(true);
      movie_rating = db.getRating(movie_title);
      ratingLabel.setText(movie_rating);
      rating = Double.parseDouble(movie_rating);
      if(rating > 7.0) {
        ratingLabel.setText(movie_rating);
        ratingPane.setStyle("-fx-background-color: #228B22");
      }

      else  if (rating < 7.0) {
        ratingLabel.setText(movie_rating);
        ratingPane.setStyle("-fx-background-color: #DAA520");
      }

      ObservableList<String> list =
          FXCollections.observableArrayList(db.dateList(db.movieDate(
              "Titanic")));
      dateComboBox.setItems(list);
      ObservableList<String> list1 =
          FXCollections.observableArrayList(db.timeList(db.movieTime(
              "Titanic")));
      timeComboBox.setItems(list1);


    } else if (s.equals("The Avengers")) {
      movieTextArea.setVisible(true);
      descriptionText.setVisible(true);
      genreText.setVisible(true);
      genreTextField.setVisible(true);
      durationText.setVisible(true);
      durationTextField.setVisible(true);
      trailerButton.setVisible(true);
      titleMainLabel.setText("The Avengers");
      setMovieTitle(titleMainLabel.getText());
      File  file  = new File("Images/movie4.png");
      Image image = new Image(file.toURI().toString());
      movieImageView.setImage(image);
      DatabaseConnection db = new DatabaseConnection();
      movieTextArea.setText(db.movieSummary("The Avengers"));
      movieTextArea.setWrapText(true);
      genreTextField.setText(db.movieGenre("The Avengers"));
      durationTextField.setText(db.movieDuration("The Avengers"));
      movie_id = db.movieID(movie_title);
      ratingPane.setVisible(true);
      ratingText.setVisible(true);
      movie_rating = db.getRating(movie_title);
      ratingLabel.setText(movie_rating);
      rating = Double.parseDouble(movie_rating);
      if(rating > 7.0) {
        ratingLabel.setText(movie_rating);
        ratingPane.setStyle("-fx-background-color: #228B22");
      }

      else  if (rating < 7.0) {
        ratingLabel.setText(movie_rating);
        ratingPane.setStyle("-fx-background-color: #DAA520");
      }

      ObservableList<String> list =
          FXCollections.observableArrayList(db.dateList(db.movieDate("The" +
                                                                     " " +
                                                                     "Avengers")));
      dateComboBox.setItems(list);


      ObservableList<String> list1 =
          FXCollections.observableArrayList(db.timeList(db.movieTime("The" +
                                                                     " " +
                                                                     "Avengers")));
      timeComboBox.setItems(list1);

    } else if (s.equals("Star Wars The Rise of Skywalker")) {
      movieTextArea.setVisible(true);
      descriptionText.setVisible(true);
      genreText.setVisible(true);
      genreTextField.setVisible(true);
      durationText.setVisible(true);
      durationTextField.setVisible(true);
      trailerButton.setVisible(true);
      titleMainLabel.setText("Star Wars The Rise of Skywalker");
      setMovieTitle(titleMainLabel.getText());
      File  file  = new File("Images/movie5.png");
      Image image = new Image(file.toURI().toString());
      movieImageView.setImage(image);
      DatabaseConnection db = new DatabaseConnection();
      movieTextArea.setText(db.movieSummary("Star Wars The Rise of Skywalker"));
      movieTextArea.setWrapText(true);
      genreTextField.setText(db.movieGenre("Star Wars The Rise of Skywalker"));
      durationTextField.setText(db.movieDuration(
          "Star Wars The Rise of Skywalker"));
      movie_id = db.movieID(movie_title);
      ratingPane.setVisible(true);
      ratingText.setVisible(true);
      movie_rating = db.getRating(movie_title);
      ratingLabel.setText(movie_rating);
      rating = Double.parseDouble(movie_rating);
      if(rating > 7.0) {
        ratingLabel.setText(movie_rating);
        ratingPane.setStyle("-fx-background-color: #228B22");
      }

      else  if (rating < 7.0) {
        ratingLabel.setText(movie_rating);
        ratingPane.setStyle("-fx-background-color: #DAA520");
      }

      ObservableList<String> list =
          FXCollections.observableArrayList(db.dateList(db.movieDate(
              "Star Wars The Rise of Skywalker")));
      dateComboBox.setItems(list);


      ObservableList<String> list1 =
          FXCollections.observableArrayList(db.timeList(db.movieTime(
              "Star Wars The Rise of Skywalker")));
      timeComboBox.setItems(list1);

    } else if (s.equals("Forrest Gump")) {
      movieTextArea.setVisible(true);
      descriptionText.setVisible(true);
      genreText.setVisible(true);
      genreTextField.setVisible(true);
      durationText.setVisible(true);
      durationTextField.setVisible(true);
      trailerButton.setVisible(true);
      titleMainLabel.setText("Forrest Gump");
      setMovieTitle(titleMainLabel.getText());
      File  file  = new File("Images/movie6.png");
      Image image = new Image(file.toURI().toString());
      movieImageView.setImage(image);
      DatabaseConnection db = new DatabaseConnection();
      movieTextArea.setText(db.movieSummary("Forrest Gump"));
      movieTextArea.setWrapText(true);
      genreTextField.setText(db.movieGenre("Forrest Gump"));
      durationTextField.setText(db.movieDuration("Forrest Gump"));
      movie_id = db.movieID(movie_title);
      ratingPane.setVisible(true);
      ratingText.setVisible(true);
      movie_rating = db.getRating(movie_title);
      ratingLabel.setText(movie_rating);
      rating = Double.parseDouble(movie_rating);
      if(rating > 7.0) {
        ratingLabel.setText(movie_rating);
        ratingPane.setStyle("-fx-background-color: #228B22");
      }

      else  if (rating < 7.0) {
        ratingLabel.setText(movie_rating);
        ratingPane.setStyle("-fx-background-color: #DAA520");
      }

      ObservableList<String> list =
          FXCollections.observableArrayList(db.dateList(db.movieDate(
              "Forrest Gump")));
      dateComboBox.setItems(list);


      ObservableList<String> list1 =
          FXCollections.observableArrayList(db.timeList(db.movieTime(
              "Forrest Gump")));
      timeComboBox.setItems(list1);

    } else if (s.equals("Resident Evil")) {
      movieTextArea.setVisible(true);
      descriptionText.setVisible(true);
      genreText.setVisible(true);
      genreTextField.setVisible(true);
      durationText.setVisible(true);
      durationTextField.setVisible(true);
      trailerButton.setVisible(true);
      titleMainLabel.setText("Resident Evil");
      setMovieTitle(titleMainLabel.getText());
      File  file  = new File("Images/movie7.png");
      Image image = new Image(file.toURI().toString());
      movieImageView.setImage(image);
      DatabaseConnection db = new DatabaseConnection();
      movieTextArea.setText(db.movieSummary("Resident Evil"));
      movieTextArea.setWrapText(true);
      genreTextField.setText(db.movieGenre("Resident Evil"));
      durationTextField.setText(db.movieDuration("Resident Evil"));
      movie_id = db.movieID(movie_title);
      ratingPane.setVisible(true);
      ratingText.setVisible(true);
      movie_rating = db.getRating(movie_title);
      ratingLabel.setText(movie_rating);
      rating = Double.parseDouble(movie_rating);
      if(rating > 7.0) {
        ratingLabel.setText(movie_rating);
        ratingPane.setStyle("-fx-background-color: #228B22");
      }

      else  if (rating < 7.0) {
        ratingLabel.setText(movie_rating);
        ratingPane.setStyle("-fx-background-color: #DAA520");
      }

      ObservableList<String> list =
          FXCollections.observableArrayList(db.dateList(db.movieDate(
              "Resident Evil")));
      dateComboBox.setItems(list);


      ObservableList<String> list1 =
          FXCollections.observableArrayList(db.timeList(db.movieTime(
              "Resident Evil")));
      timeComboBox.setItems(list1);

    } else if (s.equals("The Lord of the Rings The Fellowship of the Ring")) {
      movieTextArea.setVisible(true);
      descriptionText.setVisible(true);
      genreText.setVisible(true);
      genreTextField.setVisible(true);
      durationText.setVisible(true);
      durationTextField.setVisible(true);
      trailerButton.setVisible(true);
      titleMainLabel.setText("The Lord of the Rings The Fellowship of the Ring");
      setMovieTitle(titleMainLabel.getText());
      File  file  = new File("Images/movie8.png");
      Image image = new Image(file.toURI().toString());
      movieImageView.setImage(image);
      DatabaseConnection db = new DatabaseConnection();
      movieTextArea.setText(db.movieSummary("The Lord of the Rings The Fellowship of the Ring"));
      movieTextArea.setWrapText(true);
      genreTextField.setText(db.movieGenre("The Lord of the Rings The Fellowship of the Ring"));
      durationTextField.setText(db.movieDuration("The Lord of the Rings The Fellowship of the Ring"));
      movie_id = db.movieID(movie_title);
      ratingPane.setVisible(true);
      ratingText.setVisible(true);
      movie_rating = db.getRating(movie_title);
      ratingLabel.setText(movie_rating);
      rating = Double.parseDouble(movie_rating);
      if(rating > 7.0) {
        ratingLabel.setText(movie_rating);
        ratingPane.setStyle("-fx-background-color: #228B22");
      }

      else  if (rating < 7.0) {
        ratingLabel.setText(movie_rating);
        ratingPane.setStyle("-fx-background-color: #DAA520");
      }

      ObservableList<String> list =
          FXCollections.observableArrayList(db.dateList(db.movieDate(
              "The Lord of the Rings The Fellowship of the Ring")));
      dateComboBox.setItems(list);


      ObservableList<String> list1 =
          FXCollections.observableArrayList(db.timeList(db.movieTime(
              "The Lord of the Rings The Fellowship of the Ring")));
      timeComboBox.setItems(list1);

    }
  }

  public void trailerButtonAction(ActionEvent event) {

    WebView webView = new WebView();
    Stage   stage   = new Stage();

    if (titleMainLabel.getText().equals("Interstellar")) {

      webView.getEngine().load("https://www.youtube.com/embed/zSWdZVtXT7E");
      webView.setPrefSize(650, 650);
      stage.setTitle("CineFilm");
      Image icon = new Image(getClass().getResourceAsStream("icon.png"));
      stage.getIcons().add(icon);
      stage.setScene(new Scene(webView));
      stage.show();
      stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

        @Override
        public void handle(WindowEvent event) {
          webView.getEngine().load(null);
        }
      });
    }

    if (titleMainLabel.getText().equals("1917")) {

      webView.getEngine().load("https://www.youtube.com/embed/YqNYrYUiMfg");
      stage.setTitle("CineFilm");
      Image icon = new Image(getClass().getResourceAsStream("icon.png"));
      stage.getIcons().add(icon);
      webView.setPrefSize(650, 650);
      stage.setScene(new Scene(webView));
      stage.show();
      stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

        @Override
        public void handle(WindowEvent event) {
          webView.getEngine().load(null);
        }
      });
    }

    if (titleMainLabel.getText().equals("Titanic")) {

      webView.getEngine().load("https://www.youtube.com/embed/kVrqfYjkTdQ");
      stage.setTitle("CineFilm");
      Image icon = new Image(getClass().getResourceAsStream("icon.png"));
      stage.getIcons().add(icon);
      webView.setPrefSize(650, 650);
      stage.setScene(new Scene(webView));
      stage.show();
      stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

        @Override
        public void handle(WindowEvent event) {
          webView.getEngine().load(null);
        }
      });
    }

    if (titleMainLabel.getText().equals("The Avengers")) {

      webView.getEngine().load("https://www.youtube.com/embed/eOrNdBpGMv8");
      stage.setTitle("CineFilm");
      Image icon = new Image(getClass().getResourceAsStream("icon.png"));
      stage.getIcons().add(icon);
      webView.setPrefSize(650, 650);
      stage.setScene(new Scene(webView));
      stage.show();
      stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

        @Override
        public void handle(WindowEvent event) {
          webView.getEngine().load(null);
        }
      });
    }

    if (titleMainLabel.getText().equals("Star Wars The Rise of Skywalker")) {

      webView.getEngine().load("https://www.youtube.com/embed/8Qn_spdM5Zg");
      stage.setTitle("CineFilm");
      Image icon = new Image(getClass().getResourceAsStream("icon.png"));
      stage.getIcons().add(icon);
      webView.setPrefSize(650, 650);
      stage.setScene(new Scene(webView));
      stage.show();
      stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

        @Override
        public void handle(WindowEvent event) {
          webView.getEngine().load(null);
        }
      });
    }

    if (titleMainLabel.getText().equals("Forrest Gump")) {

      webView.getEngine().load("https://www.youtube.com/embed/bLvqoHBptjg");
      stage.setTitle("CineFilm");
      Image icon = new Image(getClass().getResourceAsStream("icon.png"));
      stage.getIcons().add(icon);
      webView.setPrefSize(650, 650);
      stage.setScene(new Scene(webView));
      stage.show();
      stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

        @Override
        public void handle(WindowEvent event) {
          webView.getEngine().load(null);
        }
      });
    }

    if (titleMainLabel.getText().equals("Resident Evil")) {

      webView.getEngine().load("https://www.youtube.com/embed/kEutwdia8n0");
      stage.setTitle("CineFilm");
      Image icon = new Image(getClass().getResourceAsStream("icon.png"));
      stage.getIcons().add(icon);
      webView.setPrefSize(650, 650);
      stage.setScene(new Scene(webView));
      stage.show();
      stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

        @Override
        public void handle(WindowEvent event) {
          webView.getEngine().load(null);
        }
      });
    }

    if (titleMainLabel.getText().equals("The Lord of the Rings The Fellowship of the Ring")) {

      webView.getEngine().load("https://www.youtube.com/embed/aStYWD25fAQ");
      stage.setTitle("CineFilm");
      Image icon = new Image(getClass().getResourceAsStream("icon.png"));
      stage.getIcons().add(icon);
      webView.setPrefSize(650, 650);
      stage.setScene(new Scene(webView));
      stage.show();
      stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

        @Override
        public void handle(WindowEvent event) {
          webView.getEngine().load(null);
        }
      });
    }
  }

  public void nextButtonAction(ActionEvent event) {

    try {

      Parent root  = FXMLLoader.load(getClass().getResource("seats.fxml"));
      Stage  seats = new Stage();
      seats.setTitle("CineFilm");
      Image icon = new Image(getClass().getResourceAsStream("icon.png"));
      seats.getIcons().add(icon);
      seats.setScene(new Scene(root, 700, 650));
      seats.show();
      closeMainStage();

    } catch (Exception e) {
      e.printStackTrace();
      e.getCause();
    }
  }

  public void closeMainStage() {
    Stage stage = (Stage) nextButton.getScene().getWindow();
    stage.close();
  }

  public String setMovieTitle(String s) {
    return this.movie_title = s;
  }

  public void selectDateAction(ActionEvent event) {

    movie_date = dateComboBox.getValue().toString();
  }

  public void selectTimeAction(ActionEvent event) {

    movie_time = timeComboBox.getValue().toString();
    nextButton.setDisable(false);
  }

  public void backButtonAction(ActionEvent event) {

    Stage stage = (Stage) backButton.getScene().getWindow();
    stage.close();

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


