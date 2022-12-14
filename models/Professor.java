package models;

public class Professor extends Usuario{

  private String subject;
  
  public Professor(String firstName, String lastName, String username, String password, String subject) {
    super(firstName, lastName, username, password);
    this.subject = subject;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  @Override
  public String toString() {
    return "\nNOME: " + getNome() + " " + getLastName() + ", PROJETOS ENVOLVIDOS: " + getProjectsEnvolved() + ", ATIVIDADES ENVOLVIDAS: " + getActivitiesEnvolved() +
    ", TIPO DE USUARIO: PROFESSOR, MATERIA: " + getSubject();
  }
}