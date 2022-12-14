package models;
public class Data {

  private double amount;
  private String date;

  public Data(double amount, String date) {
    this.amount = amount;
    this.date = date;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public double getAmount() {
    return amount;
  }

  public String getDate() {
    return date;
  }

  public String toString() {
    return "DATA: " + this.getDate() + ", BOLSA PAGA: "  + this.getAmount();
  }
}