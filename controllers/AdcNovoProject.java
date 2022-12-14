package controllers;

import java.util.ArrayList;
import java.util.Scanner;

import models.Atividades;
import models.Conta;
import models.Pesquisador;
import models.Professor;
import models.Projeto;
import models.Usuario;

public class AdcNovoProject {
	public void adcNovoProjeto(Conta account) {
	    Scanner input = new Scanner(System.in);

	    String id, description, startAt, endAt, coordinatorUsername, duringAt, username, activityId;
	    Usuario coordinator = null;
	    double schoolarAmount;
	    ArrayList<Usuario> members = new ArrayList<Usuario>();
	    ArrayList<Projeto> projects = new ArrayList<Projeto>();
	    ArrayList<Atividades> activities = new ArrayList<Atividades>();

	    System.out.println("\nINSIRA UM ID PARA O PROJETO: ");
	    id = input.nextLine();

	    System.out.println("INSIRA A DESCRICAO DO PROJETO: ");
	    description = input.nextLine();

	    System.out.println("INSIRA A DATA DE INICIO DO PROJETO: ");
	    startAt = input.nextLine();

	    System.out.println("INSIRA A DATA DE TERMINO DO PROJETO: ");
	    endAt = input.nextLine();

	    System.out.println("INSIRA O USERNAME DO COORDENADOR DO PROJETO: ");
	    coordinatorUsername = input.nextLine();
	    for (Usuario user : account.getUsers()) {
	      if (user.getUsername().equals(coordinatorUsername)) {
	        coordinator = user;
	        if (user instanceof Professor | user instanceof Pesquisador) coordinator = user;
	        else System.out.println("ESSE USUARIO NAO PODE SER COORDENADOR DO PROJETO.");
	      }
	    }

	    if (coordinator == null) System.out.println("USERNAME NAO ENCONTRADO.");

	    System.out.println("INSIRA USERNAMES PARA ADICIONAR MEMBROS: ");
	    int option = 12;
	    while(option!=0) {
	      System.out.println("1 - ADICIONAR UM USERNAME.");
	      System.out.println("0 - SAIR.");
	      option = input.nextInt();
	      input.nextLine();

	      switch(option) {
	        case 0:
	          break;
	        case 1:
	          System.out.println("USERNAME: ");
	          username = input.nextLine();
	          FindUser findUser = new FindUser();
	          Usuario user = findUser.findUser(username, account);
	          if (user != null) {
	            members.add(user);
	            System.out.println("USERNAME ADICIONADO COM SUCESSO.");
	          }
	          else System.out.println("\nUSERNAME NAO ENCONTRADO, TENTE NOVAMENTE.\n");
	          break;
	      }
	    }

	    System.out.println("INSIRA OS IDs PARA ADICIONAR ATIVIDADES: ");
	    int option2 = 12;
	    while(option2!=0) {
	      System.out.println("1 - ADCIONAR UMA ATIVIDADE.");
	      System.out.println("0 - SAIR.");
	      option2 = input.nextInt();
	      input.nextLine();

	      switch(option2) {
	        case 0:
	          break;
	        case 1:
	          System.out.println("ID DA ATIVIDADE: ");
	          activityId = input.nextLine();
	          FindActivity findActivity = new FindActivity();
	          Atividades activity = findActivity.findActivity(activityId, account);
	          if (activity != null) {
	            activities.add(activity);
	            System.out.println("ATIVIDADE ADICIONADA COM SUCESSO.");
	          }
	          else System.out.println("\nATIVIDADE NAO ENCONTRADA, TENTE NOVAMENTE.\n");
	          break;
	      }
	    }

	    System.out.println("INISRA O VALOR DA BOLSA: ");
	    schoolarAmount = input.nextDouble();
	    input.nextLine();

	    System.out.println("INSIRA A DURACAO DO PROJETO: ");
	    duringAt = input.nextLine();

	    Projeto project = new Projeto(id, description, startAt, endAt, coordinator, members, activities, schoolarAmount, duringAt);

	    projects = account.getProjects();
	    projects.add(project);
	    account.setProject(projects);
	    
	    System.out.printf("%nPROJETO CRIADO COM SUCESSO!%n");
	  }

}
