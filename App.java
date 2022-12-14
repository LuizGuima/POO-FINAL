import models.Conta;
import models.Universidade;

public class App {

  public static void main(String[] args) {

    Conta account = new Conta();
    Universidade universidade = new Universidade();

    universidade.menu(account);
  }
}