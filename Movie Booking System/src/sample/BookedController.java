package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.io.File;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class BookedController implements Initializable {

  public static String name[] = null;
  public static String fullName   = null;
  public static String movieTitle = null;
  public static String movieDate  = null;
  public static String movieTime = null;
  public static String movieSeats = null;


  @FXML
  private ImageView imageView;
  @FXML
  private Label nameLabel;
  @FXML
  private Label movieLabel;
  @FXML
  private Label dateLabel;
  @FXML
  private Label timeLabel;
  @FXML
  private Label seatLabel;
  @FXML
  private Button closeButton;
  @FXML
  private MediaView mediaView;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

    getSummary();
    nameLabel.setText("Name: " + name[0].replace("[", "") + " " + name[1].replace("]", ""));
    setFullName(nameLabel.getText());
    movieLabel.setText("Movie: " + MainController.movie_title);
    setMovieTitle(movieLabel.getText());
    dateLabel.setText("Date: " + MainController.movie_date);
    setMovieDate(dateLabel.getText());
    timeLabel.setText("Time: " + MainController.movie_time);
    setMovieTime(timeLabel.getText());
    seatLabel.setText("Seats: " + getSeat().replace("null",""));
    setMovieSeats(seatLabel.getText());
    SeatsController.list.clear();
    backgroundVideo();
    try {
      DatabaseConnection db = new DatabaseConnection();
      sendMail(db.getEmail(db.getUsername()));
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public void getSummary() {
    DatabaseConnection db = new DatabaseConnection();
    ArrayList<String> arrayList = new ArrayList<String>();
    String s = null;

    arrayList = db.getName(db.getUsername());
    s = arrayList.toString();
    this.name = s.split(", ");
  }

  public String getSeat() {

    String s = null;

    for (int i = 0; i < SeatsController.list.size(); i++) {
      s += (SeatsController.list.get(i) + ",").toString();
    }

    s = s.substring(0, s.length() -1);

    return s;
  }

  public void closeButtonAction(ActionEvent event) {

    Stage stage = (Stage) closeButton.getScene().getWindow();
    stage.close();
  }

  public void setFullName(String s) {

    String[] name = s.split("Name: ");

    this.fullName = name[1];

  }

  public void setMovieTitle(String s) {

    String[] title = s.split("Movie: ");

    this.movieTitle = title[1];

  }

  public void setMovieDate(String s) {

    String[] date = s.split("Date: ");

    this.movieDate = date[1];

  }

  public void setMovieTime(String s) {

    String[] time = s.split("Time: ");

    this.movieTime = time[1];

  }

  public void setMovieSeats(String s) {

    String[] seats = s.split("Seats: ");

    this.movieSeats = seats[1];

  }


  public String getFullName() {
    return this.fullName;
  }

  public String getMovieTitle() {
    return this.movieTitle;
  }

  public String getMovieDate() {
    return this.movieDate;
  }

  public String getMovieTime() {
    return this.movieTime;
  }

  public String getMovieSeats() {
    return this.movieSeats;
  }

  public void backgroundVideo() {


    if (MainController.movie_title.equals("Interstellar")) {

      File file = new File("Videos/Interstellar.mp4");
      Media media = new Media((file.toURI().toString()));
      MediaPlayer player =
          new MediaPlayer(media);
      mediaView.setMediaPlayer(player);
      player.setVolume(0);
      player.setRate(1);
      player.play();
    }

    if (MainController.movie_title.equals("1917")) {

      File file = new File("Videos/1917.mp4");
      Media media = new Media((file.toURI().toString()));
      MediaPlayer player =
          new MediaPlayer(media);
      mediaView.setMediaPlayer(player);
      player.setVolume(0);
      player.setRate(1);
      player.play();
    }

    if (MainController.movie_title.equals("Titanic")) {

      File file = new File("Videos/Titanic.mp4");
      Media media = new Media((file.toURI().toString()));
      MediaPlayer player =
          new MediaPlayer(media);
      mediaView.setMediaPlayer(player);
      player.setVolume(0);
      player.setStartTime(Duration.seconds(26));
      player.setRate(1);
      player.play();
    }

    if (MainController.movie_title.equals("The Avengers")) {

      File file = new File("Videos/The_Avengers.mp4");
      Media media = new Media((file.toURI().toString()));
      MediaPlayer player =
          new MediaPlayer(media);
      mediaView.setMediaPlayer(player);
      player.setVolume(0);
      player.setStartTime(Duration.seconds(7));
      player.setRate(1);
      player.play();
    }

    if (MainController.movie_title.equals("Star Wars The Rise of Skywalker")) {

      File file = new File("Videos/Star_Wars_The_Rise_of_Skywalker.mp4");
      Media media = new Media((file.toURI().toString()));
      MediaPlayer player =
          new MediaPlayer(media);
      mediaView.setMediaPlayer(player);
      player.setVolume(0);
      player.setStartTime(Duration.seconds(7));
      player.setRate(1);
      player.play();
    }

    if (MainController.movie_title.equals("Forrest Gump")) {

      File file = new File("Videos/Forrest_Gump.mp4");
      Media media = new Media((file.toURI().toString()));
      MediaPlayer player =
          new MediaPlayer(media);
      mediaView.setMediaPlayer(player);
      player.setVolume(0);
      player.setStartTime(Duration.seconds(3));
      player.setRate(1);
      player.play();
    }

    if (MainController.movie_title.equals("Resident Evil")) {

      File file = new File("Videos/Resident_Evil.mp4");
      Media media = new Media((file.toURI().toString()));
      MediaPlayer player =
          new MediaPlayer(media);
      mediaView.setMediaPlayer(player);
      player.setVolume(0);
      player.setStartTime(Duration.seconds(3));
      player.setRate(1);
      player.play();
    }

    if (MainController.movie_title.equals("The Lord of the Rings The Fellowship of the Ring")) {

      File file = new File("Videos" +
                           "/The_Lord_of_the_Rings_The_Fellowship_of_the_Ring.mp4");
      Media media = new Media((file.toURI().toString()));

      MediaPlayer player =
          new MediaPlayer(media);
      mediaView.setMediaPlayer(player);
      player.setVolume(0);
      player.setStartTime(Duration.seconds(6));
      player.setRate(1);
      player.play();
    }
  }

  /**********************************************
   * @Author: Afsal Ashyana
   * @Website: https://www.genuinecoder.com/send-email-from-java-application-using-java-mail-api/
   */

  public static void sendMail(String recepient) throws Exception {
    System.out.println("Preparing to send email");
    Properties properties = new Properties();


    properties.put("mail.smtp.auth", "true");

    properties.put("mail.smtp.starttls.enable", "true");

    properties.put("mail.smtp.host", "smtp.gmail.com");

    properties.put("mail.smtp.port", "587");


    DatabaseConnection db = new DatabaseConnection();
    String myAccountEmail = "cinefilmbham@gmail.com";

    String password = "Cinefilm2021!?";


    Session session = Session.getInstance(properties, new Authenticator() {
      @Override
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(myAccountEmail,password);
      }
    });

    Message message = prepareMessage(session, myAccountEmail, recepient);

    Transport.send(message);
    System.out.println("Message sent successfully");
  }

  private static Message prepareMessage(Session session, String myAccountEmail, String recepient) {
    try {
      Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress(myAccountEmail));
      message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
      message.setSubject("CineFilm Booking Confirmation.");

      String firstMsg = "Thank you for choosing us!";
      String confirmation = "Below you will find details of your ticket:";
      String name = "Name: " + fullName ;
      String title = "Movie: " + movieTitle;
      String date = "Date: " + movieDate;
      String time = "Time: " + movieTime;
      String seats = "Seats: " + movieSeats;
      String lastMsg = "Enjoy your show!! :)";
      String booking =
          firstMsg + "\n" + "\n" + confirmation + "\n" + "\n" + "\n" + name + "\n" + "\n" + title + "\n" + "\n" + date + "\n" +
                   "\n" + time + "\n" + "\n" + seats + "\n" + "\n" + "\n" + lastMsg;
      message.setText(booking);

      return message;
    } catch (Exception ex) {
      Logger.getLogger(BookedController.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }

  /********************************************/


  public void relatedMoviesAction(ActionEvent event) {

      try {

        Parent root   = FXMLLoader.load(getClass().getResource("related.fxml"));
        Stage  booked = new Stage();
        Image icon = new Image(getClass().getResourceAsStream("icon.png"));
        booked.getIcons().add(icon);
        booked.setTitle("CineFilm");
        booked.setScene(new Scene(root, 750, 660));
        booked.show();
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();

      } catch (Exception e) {
        e.printStackTrace();
        e.getCause();
      }
    }
}
