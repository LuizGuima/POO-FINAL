package controllers;

import java.util.Scanner;

import models.Conta;
import models.Projeto;

public class Payment {
	public void payment(Conta account) {
		Scanner input = new Scanner(System.in);
		String id;
		Projeto currentProject = null;
		System.out.println("INSIRA O ID DO PROEJTO QUE DESEJA FAZER UM PAGAMENTO: ");
		id = input.nextLine();
		for (Projeto project : account.getProjects())
			if (project.getId().equals(id))
				currentProject = project;
		System.out.printf("O VALOR DA BOLSA DESSE PROJETO É %.2f. ", currentProject.getValorDaBolsa());

	}

}
