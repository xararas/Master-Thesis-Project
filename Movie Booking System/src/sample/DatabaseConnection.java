package sample;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnection {

  private final  String     url      =
      "jdbc:postgresql://127.0.0.1:5432/postgres";
  private final  String     user     = "postgres";
  private final  String     password = "password";
  private static Connection conn;
  public int num = -1;
  public static String username = null;

  public Connection connect() {
    try {
      conn = DriverManager.getConnection(url, user, password);

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return conn;
  }

  public void login(String username, String password) {

    try {

      PreparedStatement stmt = conn.prepareStatement("select username," +
                                                     "password" +
                                                     " from customers WHERE username = ? AND password = ?");
      stmt.setString(1, username);
      stmt.setString(2, password);

      ResultSet rs   = stmt.executeQuery();
      String    user = null;
      String    pass = null;

      while (rs.next()) {
        user = rs.getObject("username").toString();
        pass = rs.getObject("password").toString();

      }
      if ((username.equals(user)) == true ||
          (password.equals(pass)) == true) {

        this.num = 1;
        setUsername(user);
      }

      if ((username.equals(user)) == false ||
          (password.equals(pass)) == false) {

        this.num = -1;
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void register(String username, String password, String firstName,
                       String lastName, String email) {

    int nextid = getNextUserID();

    try {

      PreparedStatement stmt = conn.prepareStatement("insert into customers " +
                                                     "values(?,?,?,?,?,?)");
      stmt.setInt(1, nextid);
      stmt.setString(2, username);
      stmt.setString(3, password);
      stmt.setString(4, firstName);
      stmt.setString(5, lastName);
      stmt.setString(6, email);

      stmt.executeQuery();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**********************************************
   * @Author: Ian Kenny
   * @Course: Full Stack Application Development
   * @Lecture: Sample Assignment 1
   * @Class: GroupMSGServer
   */

  public int getNextUserID() {

    String query = "select max(id) from customers";

    int maxid = -1;

    try (Statement stmt = conn.createStatement()) {
      ResultSet rs = stmt.executeQuery(query);
      while (rs.next()) {
        maxid = rs.getInt(1);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    if (maxid < 0) {
      return maxid;
    }

    return maxid + 1;
  }

  /********************************************/

  public void movieCollection() {

    try {

      PreparedStatement stmt = conn.prepareStatement("SELECT title FROM movie");

      ResultSet rs = stmt.executeQuery();

      int i = 1;
      while(rs.next()){

        System.out.println( i + " " + rs.getString(1));
        i++;
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public String movieSummary(String title) {
    String t = null;
    try {

      PreparedStatement stmt = conn.prepareStatement("SELECT description FROM" +
                                                     " movie WHERE title = ?");

      stmt.setString(1, title);
      ResultSet rs = stmt.executeQuery();

      while(rs.next()){

        t = rs.getString(1);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return t;
  }

  public String movieGenre(String title) {
    String g = null;
    try {

      PreparedStatement stmt = conn.prepareStatement("SELECT genre FROM" +
                                                     " movie WHERE title = ?");

      stmt.setString(1, title);
      ResultSet rs = stmt.executeQuery();

      while(rs.next()){

        g = rs.getString(1);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return g;
  }

  public String movieDuration(String title) {
    String d = null;
    try {

      PreparedStatement stmt = conn.prepareStatement("SELECT duration FROM" +
                                                     " movie WHERE title = ?");

      stmt.setString(1, title);
      ResultSet rs = stmt.executeQuery();

      while(rs.next()){

        d = rs.getString(1);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return d;
  }

  public String movieDate(String title) {
    String date = null;
    try {

      PreparedStatement stmt = conn.prepareStatement("SELECT date FROM" +
                                                     " movie_date WHERE " +
                                                     "title = ?");

      stmt.setString(1, title);
      ResultSet rs = stmt.executeQuery();

      while(rs.next()){

        date = rs.getString(1);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return date;
  }

  public String movieTime(String title) {

    String time = null;

    try {

      PreparedStatement stmt = conn.prepareStatement("SELECT time FROM" +
                                                     " auditorium WHERE " +
                                                     "title = ?");

      stmt.setString(1, title);
      ResultSet rs = stmt.executeQuery();

      while(rs.next()){

        time = rs.getString(1);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return time;
  }

  public int movieID(String title) {

    int id = 0;

    try {

      PreparedStatement stmt = conn.prepareStatement("SELECT id FROM" +
                                                     " movie WHERE " +
                                                     "title = ?");

      stmt.setString(1, title);
      ResultSet rs = stmt.executeQuery();

      while(rs.next()){

        id = rs.getInt(1);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return id;
  }

  public void setUsername(String user) {
    this.username = user;
  }
  public String getUsername() {
    return username;
  }

  public String getFirstName(String s) {

    String firstName = null;

    try {

      PreparedStatement stmt = conn.prepareStatement("SELECT first_name FROM" +
                                                     " customers WHERE " +
                                                     "username = ?");
      stmt.setString(1, username);
      ResultSet rs = stmt.executeQuery();

      while(rs.next()){

        firstName = rs.getString(1);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return firstName;
  }

  public String getLastName(String s) {

    String lastName = null;

    try {

      PreparedStatement stmt = conn.prepareStatement("SELECT last_name FROM" +
                                                     " customers WHERE " +
                                                     "username = ?");
      stmt.setString(1, username);
      ResultSet rs = stmt.executeQuery();

      while(rs.next()){

        lastName = rs.getString(1);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return lastName;
  }

  public String getEmail(String s) {

    String email = null;

    try {

      PreparedStatement stmt = conn.prepareStatement("SELECT email FROM" +
                                                     " customers WHERE " +
                                                     "username = ?");
      stmt.setString(1, username);
      ResultSet rs = stmt.executeQuery();

      while(rs.next()){

        email = rs.getString(1);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return email;
  }

  public String getRating(String s) {

    String rating = null;

    try {

      PreparedStatement stmt = conn.prepareStatement("SELECT rating FROM" +
                                                     " movie WHERE " +
                                                     "title = ?");
      stmt.setString(1, s);
      ResultSet rs = stmt.executeQuery();

      while(rs.next()){

        rating = rs.getString(1);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return rating;
  }

  public void changeUsername(String s) {


    try {

      PreparedStatement stmt = conn.prepareStatement("UPDATE customers SET " +
                                                     "username = ? WHERE " +
                                                     "username = ?");
      stmt.setString(1, s);
      stmt.setString(2, getUsername());
      ResultSet rs = stmt.executeQuery();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void changeFirstName(String s) {


    try {

      PreparedStatement stmt = conn.prepareStatement("UPDATE customers SET " +
                                                     "first_name = ? WHERE " +
                                                     "username = ?");
      stmt.setString(1, s);
      stmt.setString(2, getUsername());
      ResultSet rs = stmt.executeQuery();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void changeLastName(String s) {


    try {

      PreparedStatement stmt = conn.prepareStatement("UPDATE customers SET " +
                                                     "last_name = ? WHERE " +
                                                     "username = ?");
      stmt.setString(1, s);
      stmt.setString(2, getUsername());
      ResultSet rs = stmt.executeQuery();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void changeEmail(String s) {


    try {

      PreparedStatement stmt = conn.prepareStatement("UPDATE customers SET " +
                                                     "email = ? WHERE " +
                                                     "username = ?");
      stmt.setString(1, s);
      stmt.setString(2, getUsername());
      ResultSet rs = stmt.executeQuery();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void changePassword(String s) {


    try {

      PreparedStatement stmt = conn.prepareStatement("UPDATE customers SET " +
                                                     "password = ? WHERE " +
                                                     "username = ?");
      stmt.setString(1, s);
      stmt.setString(2, getUsername());
      ResultSet rs = stmt.executeQuery();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }




  public ArrayList<String> getName(String username) {

    ArrayList<String> name = new ArrayList<String>();

    try {

      PreparedStatement stmt = conn.prepareStatement("select first_name,last_name from customers where username = ?");

      stmt.setString(1, username);
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        name.add(rs.getObject("first_name").toString());
        name.add(rs.getObject("last_name").toString());

      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return name;
  }

  public ArrayList<String> getTitle(String name) {

    ArrayList<String> title = new ArrayList<String>();

    try {

      PreparedStatement stmt = conn.prepareStatement("select title from movie" +
                                                     " natural join available_seats where name = ?");

      stmt.setString(1, name);
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        title.add(rs.getObject("title").toString());

      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return title;
  }

  public ArrayList<String> movieList() {

    ArrayList<String> ml = new ArrayList<String>();

    try {

      PreparedStatement stmt = conn.prepareStatement("select title from movie");

      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        ml.add(rs.getObject("title").toString());
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return ml;
  }

  public ArrayList<String> dateList(String s) {

    ArrayList<String> date = new ArrayList<String>();
    String[] array = s.split(",");

    for (String i : array ) {
      date.add(i);
    }

    return date;
  }

  public ArrayList<String> timeList(String s) {

    ArrayList<String> time = new ArrayList<String>();
    String[] array = s.split(", ");

    for (String i : array ) {
      time.add(i);
    }

    return time;
  }

  public ArrayList<String> genreList(String s) {

    ArrayList<String> genre = new ArrayList<String>();
    String[] array = s.split(", ");

    for (String i : array ) {
      genre.add(i);
    }

    return genre;
  }

  public ArrayList<String> seatsNotAvailable(String date, String time) {

    ArrayList<String> array = new ArrayList<String>();

    try {

      PreparedStatement stmt = conn.prepareStatement(
          "select seat from available_seats WHERE availability = 'reserved' AND date = ? AND time = ?");

      stmt.setString(1, date);
      stmt.setString(2, time);
      ResultSet rs = stmt.executeQuery();

      while (rs.next()) {
        array.add(rs.getObject("seat").toString());
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return array;
  }

  public void bookSeat(int id, String seat, String date, String time,
                       String name) {

    try {

      PreparedStatement stmt = conn.prepareStatement("INSERT INTO " +
                                                     "available_seats (id, " +
                                                     "seat,availability,date," +
                                                     "time,name" +
                                                     ") VALUES (?,?," +
                                                     "'reserved',?,?,?)");
      stmt.setInt(1, id);
      stmt.setString(2, seat);
      stmt.setString(3, date);
      stmt.setString(4, time);
      stmt.setString(5, name);

      stmt.executeQuery();


    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void cancelSeat(String name, String date, String time,
   String seat,int id) {

    try {

      PreparedStatement stmt = conn.prepareStatement("Delete FROM " +
                                                     "available_seats WHERE " +
                                                     "name = ? AND date = ? AND time =" +
                                                     " ? AND seat = ? AND id " +
                                                     "= ?");
      stmt.setString(1, name);
      stmt.setString(2, date);
      stmt.setString(3, time);
      stmt.setString(4, seat);
      stmt.setInt(5,id);

      stmt.executeQuery();


    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public ArrayList<String> getRelatedMovies2(String genre1, String genre2) {

    ArrayList<String> title = new ArrayList<String>();

    try {

      PreparedStatement stmt = conn.prepareStatement("SELECT title FROM " +
                                                     "related_movies WHERE " +
                                                     "(genre1 = '"+genre1+"' " +
                                                     "AND genre2 = '"+genre2+
                                                     "') OR (genre1 = '"+genre1+
                                                     "' AND genre3 = '"+ genre2+"')");

      ResultSet rs = stmt.executeQuery();

      while (rs.next()) {
        title.add(rs.getObject("title").toString());
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return title;
  }

  public ArrayList<String> getRelatedMovies3(String genre1, String genre2,
                                            String genre3) {

    ArrayList<String> title = new ArrayList<String>();

    try {

      PreparedStatement stmt = conn.prepareStatement("SELECT title FROM " +
                                                     "related_movies WHERE " +
                                                     "(genre1 = '"+genre1+"' " +
                                                     "AND genre2 = '"+genre2+
                                                     "') OR (genre1 = " +
                                                     "'"+genre1+"' AND genre2" +
                                                     " = '"+genre3+"') OR " +
                                                     "(genre1 = '"+genre2+"' " +
                                                     "AND genre2 = '"+genre3+
                                                     "') OR (genre2 = '"+genre1+"' AND genre3 = '"+genre3+"') OR (genre1 = '"+genre1+"' AND genre3 = '"+genre3+"') OR (genre1 = '"+genre1+"' AND genre2 = '"+genre2+"' AND genre3 = '"+genre3+"')");

//      stmt.setString(1, genre1);
//      stmt.setString(2, genre2);
//      stmt.setString(3, genre3);
      ResultSet rs = stmt.executeQuery();

      while (rs.next()) {
        title.add(rs.getObject("title").toString());
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return title;
  }

  public ArrayList<String> getRelatedGames(String genre1, String genre2,
                                            String genre3) {

    ArrayList<String> title = new ArrayList<String>();

    try {

      PreparedStatement stmt = conn.prepareStatement("SELECT title FROM " +
                                                     "related_games WHERE " +
                                                     "(genre1 = '"+genre1+"' " +
                                                     "AND genre2 = '"+genre2+
                                                     "') OR (genre1 = " +
                                                     "'"+genre1+"' AND genre2" +
                                                     " = '"+genre3+"') OR " +
                                                     "(genre1 = '"+genre2+"' " +
                                                     "AND genre2 = '"+genre3+
                                                     "') OR (genre2 = '"+genre1+"' AND genre3 = '"+genre3+"') OR (genre1 = '"+genre1+"' AND genre3 = '"+genre3+"') OR (genre1 = '"+genre1+"' AND genre2 = '"+genre2+"' AND genre3 = '"+genre3+"')");

//      stmt.setString(1, genre1);
//      stmt.setString(2, genre2);
//      stmt.setString(3, genre3);
      ResultSet rs = stmt.executeQuery();

      while (rs.next()) {
        title.add(rs.getObject("title").toString());
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return title;
  }
}

