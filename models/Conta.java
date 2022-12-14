package models;
import java.util.ArrayList;

public class Conta {

  private ArrayList<Usuario> users;
  private ArrayList<Projeto> projects;
  private ArrayList<Atividades> activities;

  public Conta() {
    this.users = new ArrayList<Usuario>();
    this.projects = new ArrayList<Projeto>();
    this.activities = new ArrayList<Atividades>();
  }

  public ArrayList<Usuario> getUsers() {
    return users;
  }

  public ArrayList<Projeto> getProjects() {
    return projects;
  }

  public ArrayList<Atividades> getActivities() {
    return activities;
  }

  public void setUser(ArrayList<Usuario> users) {
    this.users = users;
  }

  public void setProject(ArrayList<Projeto> projects) {
    this.projects = projects;
  }

  public void setActivities(ArrayList<Atividades> activities) {
    this.activities = activities;
  }

} 