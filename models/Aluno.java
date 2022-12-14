package models;

public class Aluno extends Usuario{

  private String degree;
  
  public Aluno(String firstName, String lastName, String username, String password, String degree) {
    super(firstName, lastName, username, password);
    this.degree = degree;
  }

  public String getDegree() {
    return degree;
  }

  public void setDegree(String degree) {
    this.degree = degree;
  }

  @Override
  public String toString() {
    return "\nNOME: " + getNome() + " " + getLastName() + ", PROJETOS ENVOLVIDOS: " + getProjectsEnvolved() + ", ATIVIDADES ENVOLVIDAS: " + getActivitiesEnvolved() +
    ", TIPO DE USUARIO: ESTUDANTE, GRADUANDO: " + getDegree();
  }
}