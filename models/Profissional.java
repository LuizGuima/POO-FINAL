package models;

public class Profissional extends Usuario{

  private String type;
  
  public Profissional(String firstName, String lastName, String username, String password, String type)throws IllegalArgumentException {
	  
    super(firstName, lastName, username, password);
    this.type = type;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "\nNOME: " + getNome() + " " + getLastName() + ", PROJETOS ENVOLVIDOS: " + getProjectsEnvolved() + ", ATIVIDADES ENVOLVIDAS: " + getActivitiesEnvolved() +
    ", TIPO DE USUARIO: PROFISSIONAL (" + getType() + ")";
  }
}