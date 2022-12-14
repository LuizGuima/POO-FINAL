package models;
import java.util.ArrayList;

import java.lang.reflect.Field;

public class Projeto implements Pagamento {

  private String id;
  private String description;
  private String startAt;
  private String endAt;
  private Usuario coordinator;
  private ArrayList<Usuario> members;
  private ArrayList<Atividades> activities;
  private double schoolarAmount;
  private String duringAt;
  private String status;
  private ArrayList<Data> payment;

  public Projeto(String id, String description, String startAt, String endAt, Usuario coordinator, 
  ArrayList<Usuario> members, ArrayList<Atividades> activities, double schoolarAmount, String duringAt) {
	  if(id == null || id.isBlank()) {
			throw new IllegalArgumentException("ERRO! O ID NOME NAO PODE SER VAZIO!");
		}
		if(description == null || description.isBlank()) {
			throw new IllegalArgumentException("ERRO! A DESCRICAO NAO PODE SER VAZIA!");
		}
		if(startAt == null || startAt.isBlank()) {
			throw new IllegalArgumentException("ERRO! A DATA DE INICIO NAO PODE SER VAZIO!");
		}
		if(duringAt == null || duringAt.isBlank()) {
			throw new IllegalArgumentException("ERRO! A DATA DE TERMINO NAO PODE SER VAZIA!");
		}
	this.id = id;
    this.description = description;
    this.startAt = startAt;
    this.endAt = endAt;
    this.coordinator = coordinator;
    this.members = members;
    this.activities = activities;
    this.schoolarAmount = schoolarAmount;
    this.duringAt = duringAt;
    this.status = "EM PROCESSO DE CRIACAO";
    this.payment = new ArrayList<Data>();
  }

  public void setPayment(ArrayList<Data> payment) {
    this.payment = payment;
  }

  public ArrayList<Data> getPagamaneto() {
    return payment;
  }

  public void makePayment(String date) {
    Data payment = new Data(this.getValorDaBolsa(), date);

    this.getPagamaneto().add(payment);
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getStartAt() {
    return startAt;
  }

  public void setStartAt(String startAt) {
    this.startAt =startAt;
  }

  public String getEndAt() {
    return endAt;
  }

  public void setEndAt(String endAt) {
    this.endAt = endAt;
  }

  public Usuario getCoordinator() {
    return coordinator;
  }

  public void setCoordinator(Usuario coordinator) {
    this.coordinator = coordinator;
  }

  public ArrayList<Usuario> getMembers() {
    return members;
  }

  public String getMembersUsername() {
    for (Usuario user : members) {
      return user.getUsername();
    }
    return null;
  }

  public void setMembers(ArrayList<Usuario> members) {
    this.members = members;
  }

  public ArrayList<Atividades> getActivities() {
    return activities;
  }

  public void setActivities(ArrayList<Atividades> activities) {
    this.activities = activities;
  }

  @Override
  public double getValorDaBolsa() {
    return schoolarAmount;
  }

  public void setSchoolarAmount(double schoolarAmount) {
    this.schoolarAmount = schoolarAmount;
  }

  public String getDuringAt() {
    return duringAt;
  }

  public void setDuringAt(String duringAt) {
    this.duringAt = duringAt;
  }

  public boolean checkNull() {
    for (Field f : getClass().getDeclaredFields()) 
      if (f == null) return true;

    return false;
  }

  public String toString() {
    return "ID: " + this.getId() + "DESCRICAO: " + this.getDescription();
  }

  public String getAllInfo() {
    return "\nID: " + this.getId() + "\nDESCRICAO: " + this.getDescription() + "\nCOMECA EM: " + this.getStartAt() + "\nTERMINA EM: " +
    this.getEndAt() + "\nCOORDENADOR: " + this.getCoordinator() + "\nMEMBROS: " + this.getMembers() + "\nATIVIDADES: " + 
    this.getActivities() + "\nVALOR DA BOLSA: " + this.getValorDaBolsa() + "\nDURACAO: " + this.getDuringAt();
  }

}