package cn.com.kgc.Pojo;


import java.sql.Date;

public class Orderse {

  private long id;
  private long orderseGoodsId;
  private long orderseCusId;
  private java.sql.Date orderseDate;
  private String orderseAddress;
  private double orderseMoney;
  private long orderseStatus;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Orderse(long id, long orderseGoodsId, long orderseCusId, Date orderseDate, String orderseAddress, double orderseMoney, long orderseStatus) {
    this.id = id;
    this.orderseGoodsId = orderseGoodsId;
    this.orderseCusId = orderseCusId;
    this.orderseDate = orderseDate;
    this.orderseAddress = orderseAddress;
    this.orderseMoney = orderseMoney;
    this.orderseStatus = orderseStatus;
  }

  public Orderse() {
  }

  public long getOrderseGoodsId() {
    return orderseGoodsId;
  }

  public void setOrderseGoodsId(long orderseGoodsId) {
    this.orderseGoodsId = orderseGoodsId;
  }


  public long getOrderseCusId() {
    return orderseCusId;
  }

  public void setOrderseCusId(long orderseCusId) {
    this.orderseCusId = orderseCusId;
  }


  public java.sql.Date getOrderseDate() {
    return orderseDate;
  }

  public void setOrderseDate(java.sql.Date orderseDate) {
    this.orderseDate = orderseDate;
  }


  public String getOrderseAddress() {
    return orderseAddress;
  }

  public void setOrderseAddress(String orderseAddress) {
    this.orderseAddress = orderseAddress;
  }


  public double getOrderseMoney() {
    return orderseMoney;
  }

  public void setOrderseMoney(double orderseMoney) {
    this.orderseMoney = orderseMoney;
  }


  public long getOrderseStatus() {
    return orderseStatus;
  }

  public void setOrderseStatus(long orderseStatus) {
    this.orderseStatus = orderseStatus;
  }

}
