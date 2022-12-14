package controllers;

import java.util.Scanner;

import models.Conta;
import models.Projeto;

public class FolhaDePagamento {
	public void folhaDePagamento(Conta account) {
		Scanner input = new Scanner(System.in);
		String id;
		Projeto currentProject = null;

		System.out.println("INSIRA O ID DO PROEJETO QUE DESEJA VER O PAGAMENTO: ");
		id = input.nextLine();
		for (Projeto project : account.getProjects())
			if (project.getId().equals(id))
				currentProject = project;

		System.out.println(currentProject.getPagamaneto());
	}
	
	
}
