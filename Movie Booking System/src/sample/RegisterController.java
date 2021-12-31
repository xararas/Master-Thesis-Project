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
import java.sql.Connection;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

  @FXML
  private ImageView     imageView;
  @FXML
  private TextField     firstnameTextField;
  @FXML
  private TextField     lastnameTextField;
  @FXML
  private TextField     emailTextField;
  @FXML
  private TextField     usernameTextField;
  @FXML
  private PasswordField passwordField;
  @FXML
  private Button        registerButton;
  @FXML
  private Button        cancelButton;
  @FXML
  private Label         messageLabel;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

    File  file  = new File("Images/main.png");
    Image image = new Image(file.toURI().toString());
    imageView.setImage(image);
  }

  /**********************************************
   * @Author: Tookootek
   * @Website: https://www.youtube.com/watch?v=DH3dWzmkT5Y&t=588s
   */

  public void registerButtonAction(ActionEvent event) {

    DatabaseConnection db              = new DatabaseConnection();
    Connection         connectDatabase = db.connect();

    if (firstnameTextField.getText().isBlank() == true) {
      messageLabel.setText("Please enter your firstname.");
      messageLabel.setTextFill(Color.web("#B22222"));

    }
    if (lastnameTextField.getText().isBlank() == true) {
      messageLabel.setText("Please enter your lastname.");
      messageLabel.setTextFill(Color.web("#B22222"));

    }
    if (emailTextField.getText().isBlank() == true) {
      messageLabel.setText("Please enter your email.");
      messageLabel.setTextFill(Color.web("#B22222"));

    }
    if (usernameTextField.getText().isBlank() == true) {
      messageLabel.setText("Please enter your username.");
      messageLabel.setTextFill(Color.web("#B22222"));

    }
    if (passwordField.getText().isBlank() == true) {
      messageLabel.setText("Please enter your password.");
      messageLabel.setTextFill(Color.web("#B22222"));

    } if(firstnameTextField.getText().isBlank() == true && lastnameTextField.getText().isBlank() == true &&
         emailTextField.getText().isBlank() == true && usernameTextField.getText().isBlank() == true
    && passwordField.getText().isBlank() == true) {
      messageLabel.setText("Please fill out the empty fields.");
      messageLabel.setTextFill(Color.web("#B22222"));
      System.out.println(
          db.getUsername()
                        );

    } if(firstnameTextField.getText().isBlank() == false && lastnameTextField.getText().isBlank() == false &&
         emailTextField.getText().isBlank() == false && usernameTextField.getText().isBlank() == false
         && passwordField.getText().isBlank() == false) {

      db.register(usernameTextField.getText(), passwordField.getText(), firstnameTextField.getText(),
                  lastnameTextField.getText(), emailTextField.getText());
      messageLabel.setText("Congratulations. You have registered " +
                           "successfully!");
      messageLabel.setTextFill(Color.web("#6495ED"));

    }
  }

/**********************************************/

 public void cancelButtonAction(ActionEvent event) {
    Stage stage = (Stage) cancelButton.getScene().getWindow();
    stage.close();
  }
}
