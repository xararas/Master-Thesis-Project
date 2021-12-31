package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class AccountController implements Initializable {


  @FXML
  private ImageView imageView;
  @FXML
  private TextField firstnameTextField;
  @FXML
  private TextField lastnameTextField;
  @FXML
  private TextField     emailTextField;
  @FXML
  private TextField     usernameTextField;
  @FXML
  private PasswordField passwordField;
  @FXML
  private Button UpdateButton;
  @FXML
  private Button closeButton;
  @FXML
  private Label  messageLabel;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

    DatabaseConnection db = new DatabaseConnection();
    File  file  = new File("Images/main.png");
    Image image = new Image(file.toURI().toString());
    imageView.setImage(image);
    usernameTextField.setText(db.getUsername());
    firstnameTextField.setText(db.getFirstName(db.getUsername()));
    lastnameTextField.setText(db.getLastName(db.getUsername()));
    emailTextField.setText(db.getEmail(db.getUsername()));

  }

  public void UpdateButtonAction(ActionEvent event) {

    DatabaseConnection db              = new DatabaseConnection();

      if (usernameTextField.getText().isBlank() == false) {

        db.changeUsername(usernameTextField.getText());
        messageLabel.setText(
            "Congratulations. Your credentials have changed successfully!");
        messageLabel.setTextFill(Color.web("#6495ED"));

      }

      if (firstnameTextField.getText().isBlank() == false) {

        db.changeFirstName(firstnameTextField.getText());
        messageLabel.setText(
            "Congratulations. Your credentials have changed successfully!");
        messageLabel.setTextFill(Color.web("#6495ED"));
      }

      if (lastnameTextField.getText().isBlank() == false) {

        db.changeLastName(lastnameTextField.getText());
        messageLabel.setText(
            "Congratulations. Your credentials have changed successfully!");
        messageLabel.setTextFill(Color.web("#6495ED"));
      }

      if (emailTextField.getText().isBlank() == false) {

        db.changeEmail(emailTextField.getText());
        messageLabel.setText(
            "Congratulations. Your credentials have changed successfully!");
        messageLabel.setTextFill(Color.web("#6495ED"));
      }

      if (passwordField.getText().isBlank() == false) {

        db.changePassword(passwordField.getText());
        messageLabel.setText(
            "Congratulations. Your credentials have changed successfully!");
        messageLabel.setTextFill(Color.web("#6495ED"));
      }
    }

  public void closeButtonAction(ActionEvent event) {
    Stage stage = (Stage) closeButton.getScene().getWindow();
    stage.close();
  }
}


