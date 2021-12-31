package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class RelatedController implements Initializable {


  @FXML
  private ImageView imageView1;
  @FXML
  private ImageView imageView2;
  @FXML
  private ImageView imageView3;
  @FXML
  private ImageView imageView4;
  @FXML
  private ImageView imageView5;
  @FXML
  private ImageView imageView6;
  @FXML
  private ImageView imageView7;
  @FXML
  private ImageView imageView8;
  @FXML
  private ImageView imageView9;
  @FXML
  private HBox      movieHBox;
  @FXML
  private HBox      movieHBox2;
  @FXML
  private Text      gamerText;
  @FXML
  private Button    gamerButton;
  @FXML
  private Label gamerLabel;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    movieHBox.setSpacing(10);
    movieHBox2.setSpacing(10);
    movieHBox2.setVisible(false);
    relatedMovies();

    File  file  = new File("Images/gameButton.png");
    Image image = new Image(file.toURI().toString());
    imageView5.setImage(image);
  }

  DatabaseConnection db = new DatabaseConnection();

  public void relatedMovies() {

    String movieGenre = (db.movieGenre(MainController.movie_title));

    String[] array = movieGenre.split(", ");
//    System.out.println(array[0]);
//    System.out.println(array[1]);
//    System.out.println(array.length);

    if (array.length == 2) {

      Object[] movies =
          db.getRelatedMovies2(array[0], array[1]).toArray();

//      System.out.println(movies[0]);
//      System.out.println(movies[1]);

      if (movies.length < 3) {

        if (movies[0].equals("Pirates of the Caribbean The Curse of the Black " +
                             "Pearl") || movies[1].equals("Pirates of the " +
                                                          "Caribbean The Curse of the Black " +
                                                          "Pearl")) {
          File  file  = new File("Images/movieR1.png");
          Image image = new Image(file.toURI().toString());
          imageView1.setImage(image);
        }

        if (movies[0].equals("Inception") || movies[1].equals("Inception")) {
          File  file  = new File("Images/Inception.png");
          Image image = new Image(file.toURI().toString());
          imageView1.setImage(image);
        }

        if (movies[0].equals("District 9") || movies[1].equals("District 9")) {
          File  file  = new File("Images/District_9.png");
          Image image = new Image(file.toURI().toString());
          imageView1.setImage(image);
        }

        if (movies[0].equals("Atonement") || movies[1].equals("Atonement")) {
          File  file  = new File("Images/Atonement.png");
          Image image = new Image(file.toURI().toString());
          imageView1.setImage(image);
        }

        if (movies[0].equals("The Notebook") || movies[1].equals("The " +
                                                                 "Notebook")) {
          File  file  = new File("Images/The_Notebook.png");
          Image image = new Image(file.toURI().toString());
          if (imageView2.getImage() == null) {

            imageView2.setImage(image);

          } else if (imageView1.getImage() == null) {

            imageView1.setImage(image);
          }

        }
      }
    }
    else if (array.length == 3) {

      Object[] movies =
          db.getRelatedMovies3(array[0], array[1], array[2]).toArray();
//      System.out.println(movies.length);
//      System.out.println(movies[0]);

      if (movies.length == 1) {

        if (movies[0].equals("Pirates of the Caribbean The Curse of the Black " +
                             "Pearl")) {
          File  file  = new File("Images/movieR1.png");
          Image image = new Image(file.toURI().toString());
          imageView1.setImage(image);
        }

        if (movies[0].equals("Inception")) {
          File  file  = new File("Images/Inception.png");
          Image image = new Image(file.toURI().toString());
          imageView1.setImage(image);
        }

        if (movies[0].equals("District 9")) {
          File  file  = new File("Images/District_9.png");
          Image image = new Image(file.toURI().toString());
          imageView1.setImage(image);
        }

        if (movies[0].equals("Tomb Raider")) {
          File  file  = new File("Images/movieR2.png");
          Image image = new Image(file.toURI().toString());
          imageView1.setImage(image);
        }
        if (movies[0].equals("Atonement")) {
          File  file  = new File("Images/Atonement.png");
          Image image = new Image(file.toURI().toString());
          imageView1.setImage(image);
        }

        if (movies[0].equals("The Notebook")) {
          File  file  = new File("Images/The_Notebook.png");
          Image image = new Image(file.toURI().toString());
          if (imageView2.getImage() == null) {

            imageView2.setImage(image);
          } else {
            imageView1.setImage(image);
          }
        }
          if (movies[0].equals("Saving Private Ryan")) {
            File  file  = new File("Images/Saving_Private_Ryan.png");
            Image image = new Image(file.toURI().toString());
            if (imageView1.getImage() == null) {

              imageView1.setImage(image);
            } else
              imageView2.setImage(image);
          }

      } else if (movies.length == 2) {

        if (movies[0].equals("Atonement") || movies[1].equals("Atonement")) {
          File  file  = new File("Images/Atonement.png");
          Image image = new Image(file.toURI().toString());
          imageView1.setImage(image);
        }

        if (movies[0].equals("The Notebook") || movies[1].equals("The " +
                                                                 "Notebook")) {
          File  file  = new File("Images/The_Notebook.png");
          Image image = new Image(file.toURI().toString());
          if (imageView2.getImage() == null) {

            imageView2.setImage(image);
          }
        }

        if ((movies[0].equals("District 9")) ||
            (movies[1].equals("District" +
                              " 9"))) {

          File  file3  = new File("Images/District_9.png");
          Image image3 = new Image(file3.toURI().toString());
          imageView1.setImage(image3);
        }
        if ((movies[0].equals("Inception")) ||
            (movies[1].equals("Inception"))) {

          File  file4  = new File("Images/Inception.png");
          Image image4 = new Image(file4.toURI().toString());
          if (imageView1.getImage() == null) {

            imageView1.setImage(image4);
          } else
            imageView2.setImage(image4);

        }
      }
      else if (movies.length == 3) {

        if ((movies[0].equals("Pirates of the Caribbean The Curse of the Black " +
                              "Pearl")) ||
            (movies[1].equals("Pirates of the " +
                              "Caribbean The Curse of the Black " +
                              "Pearl")) ||
            (movies[2].equals("Pirates of the Caribbean The Curse of the Black " +
                              "Pearl"))) {

          File  file1  = new File("Images/movieR1.png");
          Image image1 = new Image(file1.toURI().toString());
          imageView1.setImage(image1);

        }

        if (movies[0].equals("Tomb Raider") ||
            (movies[1].equals("Tomb " +
                              "Raider")) ||
            (movies[2].equals("Tomb " +
                              "Raider"))) {

          File  file2  = new File("Images/movieR2.png");
          Image image2 = new Image(file2.toURI().toString());
          imageView2.setImage(image2);
        }
        if ((movies[0].equals("District 9")) ||
            (movies[1].equals("District" +
                              " 9")) ||
            (movies[2].equals("District 9"))) {

          File  file3  = new File("Images/District_9.png");
          Image image3 = new Image(file3.toURI().toString());
          imageView3.setImage(image3);
        }
        if ((movies[0].equals("Inception")) ||
            (movies[1].equals("Inception")) ||
            (movies[2].equals("Inception"))) {

          File  file4  = new File("Images/Inception.png");
          Image image4 = new Image(file4.toURI().toString());
          if (imageView3.getImage() == null) {

            imageView3.setImage(image4);
          }
        }
      }
      else if (movies.length == 4) {

        if ((movies[0].equals("Pirates of the Caribbean The Curse of the Black " +
                              "Pearl")) ||
            (movies[1].equals("Pirates of the " +
                              "Caribbean The Curse of the Black " +
                              "Pearl")) ||
            (movies[2].equals("Pirates of the Caribbean The Curse of the Black " +
                              "Pearl") || (movies[3].equals("Pirates of the " +
                                                            "Caribbean The Curse of the Black " +
                                                            "Pearl")))) {

          File  file1  = new File("Images/movieR1.png");
          Image image1 = new Image(file1.toURI().toString());
          imageView1.setImage(image1);

        }

        if (movies[0].equals("Tomb Raider") ||
            (movies[1].equals("Tomb " +
                              "Raider")) ||
            (movies[2].equals("Tomb " +
                              "Raider")) ||
            (movies[3].equals("Tomb " +
                              "Raider"))) {

          File  file2  = new File("Images/movieR2.png");
          Image image2 = new Image(file2.toURI().toString());
          imageView2.setImage(image2);
        }
        if ((movies[0].equals("District 9")) ||
            (movies[1].equals("District" +
                              " 9")) ||
            (movies[2].equals("District 9")) ||
        (movies[3].equals("District 9"))) {

          File  file3  = new File("Images/District_9.png");
          Image image3 = new Image(file3.toURI().toString());
          imageView3.setImage(image3);
        }
        if ((movies[0].equals("Inception")) ||
            (movies[1].equals("Inception")) ||
            (movies[2].equals("Inception")) ||
            (movies[3].equals("Inception"))) {

          File  file4  = new File("Images/Inception.png");
          Image image4 = new Image(file4.toURI().toString());
          if (imageView3.getImage() == null) {

            imageView3.setImage(image4);
          } else
            imageView4.setImage(image4);
        }
      }
    }
  }

  public void gamerButtonAction(ActionEvent event) {

    movieHBox2.setVisible(true);

    String movieGenre = (db.movieGenre(MainController.movie_title));

    String[] array = movieGenre.split(", ");

    if (array.length < 3) {

      gamerLabel.setText("No related games.");
    }

    Object[] games =
        db.getRelatedGames(array[0], array[1], array[2]).toArray();

    if (games.length == 0) {
      gamerLabel.setText("No related games.");
    }

    if (games.length == 1) {

      if(games[0].equals("Fallout 3")) {

        File  file6  = new File("Images/Fallout_3.png");
        Image image6 = new Image(file6.toURI().toString());
        imageView6.setImage(image6);
      }
    }

    if (games.length == 2) {

      if (games[0].equals("The Last of Us") || games[1].equals("The Last" +
                                                                    " of" +
                                                                    " Us")) {

        File  file6  = new File("Images/The_Last_of_Us.png");
        Image image6 = new Image(file6.toURI().toString());
        imageView6.setImage(image6);
      }

      if (games[0].equals("Horizon Zero Dawn") ||
          games[1].equals("Horizon Zero Dawn")) {

        File  file7  = new File("Images/Horizon_Zero_Dawn.png");
        Image image7 = new Image(file7.toURI().toString());
        imageView7.setImage(image7);
      }
      else {
        gamerLabel.setText("No related games.");
      }
    }

    if (games.length > 2) {

    if(games[0].equals("The Last of Us") || games[1].equals("The Last of " +
                                                              "Us") || games[2].equals("The Last of Us")) {

      File  file  = new File("Images/The_Last_of_Us.png");
      Image image = new Image(file.toURI().toString());
      imageView6.setImage(image);

    }
      if(games[0].equals("Horizon Zero Dawn") || games[1].equals("Horizon " +
                                                                   "Zero " +
                                                                   "Dawn") || games[2].equals("Horizon Zero Dawn")) {

        File  file  = new File("Images/Horizon_Zero_Dawn.png");
        Image image = new Image(file.toURI().toString());
        imageView7.setImage(image);
    }

      if(games[0].equals("Assassin's Creed Odyssey") || games[1].equals(
          "Assassin's Creed Odyssey") || games[2].equals("Assassin's Creed " +
                                                          "Odyssey")) {

        File  file  = new File("Images/Assassin's_Creed_Odyssey.png");
        Image image = new Image(file.toURI().toString());
        imageView8.setImage(image);
      }

      if(games[0].equals("Fallout 3") || games[1].equals(
          "Fallout 3") || games[2].equals("Fallout 3") || games[3].equals(
              "Fallout 3")) {

        File  file  = new File("Images/Fallout_3.png");
        Image image = new Image(file.toURI().toString());
        imageView9.setImage(image);

      } else {
        gamerLabel.setText("No related games.");
      }
    }
  }
}
