package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

  @FXML
  private Button cancelButton;
  @FXML
  private Label loginMessageLabel;
  @FXML
  private ImageView imageView;
  @FXML
  private TextField usernameTextField;
  @FXML
  private PasswordField passwordField;
  @FXML
  private Button registerButton;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

    File file = new File("Images/login.png");
    Image image = new Image(file.toURI().toString());
    imageView.setImage(image);
  }

  public void loginButtonAction(ActionEvent event) {

    if (usernameTextField.getText().isBlank() == false && passwordField.getText().isBlank() == false) {

      validateLogin();

    } else {

      loginMessageLabel.setText("Please enter your username and password");

    }
  }

  public void cancelButtonAction(ActionEvent event) {
    Stage stage = (Stage) cancelButton.getScene().getWindow();
    stage.close();
    Platform.exit();
  }

  public void validateLogin() {


    DatabaseConnection db = new DatabaseConnection();
    Connection connectDatabase = db.connect();

    db.login(usernameTextField.getText(), passwordField.getText());

    if (db.num == 1) {

      loginMessageLabel.setText("You have successfully logged!");
      createMainStage();
    }

    if (db.num == -1) {
      loginMessageLabel.setText("Wrong username or password");
    }

   }

  public void loginRegisterButton(ActionEvent event) {

    try {

      Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
      Stage register = new Stage();
      register.setScene(new Scene(root, 700, 650));
      Image icon = new Image(getClass().getResourceAsStream("icon.png"));
      register.getIcons().add(icon);
      register.setTitle("CineFilm");
      register.show();

    } catch (Exception e) {
      e.printStackTrace();
      e.getCause();
    }
  }

  public void createMainStage() {

    try {

      Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
      Stage main = new Stage();
      Image icon = new Image(getClass().getResourceAsStream("icon.png"));
      main.getIcons().add(icon);
      main.setTitle("CineFilm");
      main.setScene(new Scene(root, 800, 800));
      main.show();

    } catch (Exception e) {
      e.printStackTrace();
      e.getCause();
    }
  }
}

