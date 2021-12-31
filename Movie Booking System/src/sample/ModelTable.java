package sample;

public class ModelTable {

  String name, title, date,time, seat;

  public ModelTable(String name,String movie, String date,
                    String time,
                    String seat) {
    this.name  = name;
    this.title = movie;
    this.date  = date;
    this.time  = time;
    this.seat  = seat;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSeat() {
    return seat;
  }

  public void setSeat(String seat) {
    this.seat = seat;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
