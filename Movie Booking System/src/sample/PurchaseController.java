package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class PurchaseController implements Initializable {

  @FXML
  private ImageView imageView;
  @FXML
  private Label                           userLabel;
  @FXML
  private TableView<ModelTable> table;
  @FXML
  private TableColumn<ModelTable, String> col_name;
  @FXML
  private TableColumn<ModelTable, String> col_movie;
  @FXML
  private TableColumn<ModelTable, String> col_date;
  @FXML
  private TableColumn<ModelTable, String> col_time;
  @FXML
  private TableColumn<ModelTable, String> col_seat;
  @FXML
  private Button cancelButton;
  @FXML
  private Button backButton;

  ObservableList<ModelTable> oblist = FXCollections.observableArrayList();

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

    File  file  = new File("Images/main.png");
    Image image = new Image(file.toURI().toString());
    imageView.setImage(image);
    username();
    table.setPlaceholder(new Label("You haven't any tickets."));
    setTable(name());

  }

  public void username() {

    DatabaseConnection db = new DatabaseConnection();

    userLabel.setText("Welcome " + db.getUsername());

  }

  public String name() {
    DatabaseConnection db        = new DatabaseConnection();
    ArrayList<String>  arrayList = new ArrayList<String>();
    String             s         = null;
    String[] array = null;

    arrayList = db.getName(db.getUsername());
    s = arrayList.toString();
    array = s.split(", ");
    s = array[0].replace("[", "") + " " + array[1].replace("]", "");
    return s;
  }

  public void setTable(String name) {
    try {
      Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0" +
                                                    ".0" +
                                                   ".1:5432/postgres", "postgres", "password");

      PreparedStatement
          stmt = conn.prepareStatement("select name,title,date,time,seat from" +
                                       " " +
                                       "movie natural join available_seats " +
                                       "where name = ?");

      stmt.setString(1, name);
      ResultSet rs   = stmt.executeQuery();

      while(rs.next()) {
        oblist.add(new ModelTable(rs.getString("name"),
                                  rs.getString("title"), rs.getString("date"),
                                  rs.getString("time"), rs.getString("seat")));
      }

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
    col_movie.setCellValueFactory(new PropertyValueFactory<>("title"));
    col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
    col_time.setCellValueFactory(new PropertyValueFactory<>("time"));
    col_seat.setCellValueFactory(new PropertyValueFactory<>("seat"));

    table.setItems(oblist);

  }

  public void cancelButtonAction(ActionEvent event) {

    DatabaseConnection db = new DatabaseConnection();
    ModelTable selectedItem = table.getSelectionModel().getSelectedItem();
    Alert      alert        = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setContentText("Do you wish to cancel this booking?");

    Optional<ButtonType> result = alert.showAndWait();
    if(result.get() == ButtonType.OK)
    {
      int id = 0;
      id = db.movieID(selectedItem.getTitle());
      table.getItems().remove(selectedItem);
      db.cancelSeat(selectedItem.getName(), selectedItem.getDate(),selectedItem.getTime(),
                    selectedItem.getSeat(),id);
    }
    else if(result.get() == ButtonType.CANCEL)
    {
      System.out.println("User cancel the action.");
    }
  }

  public void backButtonAction(ActionEvent event) {

    Stage stage = (Stage) backButton.getScene().getWindow();
    stage.close();

  }
}
