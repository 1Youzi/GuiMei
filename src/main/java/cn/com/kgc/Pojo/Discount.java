package cn.com.kgc.Pojo;


public class Discount {

  private long id;
  private double discRate;

  public Discount() {
  }

  public Discount(long id, double discRate) {
    this.id = id;
    this.discRate = discRate;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public double getDiscRate() {
    return discRate;
  }

  public void setDiscRate(double discRate) {
    this.discRate = discRate;
  }

}
