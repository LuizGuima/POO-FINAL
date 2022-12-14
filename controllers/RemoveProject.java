package controllers;
import java.util.Scanner;

import models.Conta;
import models.Projeto;

public class RemoveProject {
	  public void removerProjeto(Conta account) {
		    Scanner input = new Scanner(System.in);
		    String id;
		    Projeto wantedProject = null;

		    System.out.println("INSIRA O ID DO PREOJETO QUE VOCE QUER REMOVER");
		    id = input.nextLine();

		    
		    for (Projeto project : account.getProjects())
		        if (project.getId().equals(id)) wantedProject = project;
		      
		      if (wantedProject != null) {
		        account.getProjects().remove(wantedProject);
		        System.out.println("\nPROJETO REMOVIDO COM SUCESSO!\n");
		      }
		      else System.out.println("ESSE PROJETO NAO FOI ENCONTRADO.");
		    }
}
