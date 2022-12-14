package controllers;

import java.util.Scanner;

import models.Atividades;
import models.Conta;
import models.Projeto;
import models.Usuario;

public class Status {
	public void status(Conta account, Usuario user) {
		Scanner input = new Scanner(System.in);
		String id;
		int option;

		System.out.println("INSIRA O ID DO PROEJETO QUE DESEJA DEFINIR O STATUS: ");
		id = input.nextLine();
		for (Projeto project : account.getProjects()) {
			{
				if (project.getId().equals(id)) {
					if (project.getCoordinator() == user) {
						System.out
								.println("QUAL O STATUS DO PROJETO: \n[1] Iniciado.\n[2] Em andamento.\n[3] Concluido");
						option = input.nextInt();
						input.nextLine();

						switch (option) {
						case 1:
							if (project.checkNull())
								System.out.println("\nO PROJETO DEVE TER AS INFORMAÇÕES BÁSICAS.");
							else {
								project.setStatus("Iniciado");
								System.out.println("\nSTATUS DO PROJETO: 'Iniciado'.");
							}
							break;
						case 2:
							if (project.getStatus() == "Iniciado") {
								project.setStatus("Em andamento");
								System.out.println("\nSTATUS DO PROJETO: 'Em andamento'.");
							} else
								System.out.println("\nO PROJETO AINDA NÃO COMEÇOU");
							break;
						case 3:
							if (project.getStatus() == "Em andamento") {
								for (Atividades activity : project.getActivities()) {
									if (activity.getDescription() == "")
										System.out.println("\nO PROJETO DEVE TER AS INFORMAÇÕES BÁSICAS.");
									else {
										project.setStatus("Concluido");
										System.out.println("\nSTATUS DO PROJETO: 'Concluido'.");
									}
								}
							} else
								System.out.println("\nPROJETO NAO ESTA EM PROCESSO.");
							break;
						}
					} else
						System.out.println("\nVOCE NAO E UM COORDENADOR DO PROJETO.");
				} else
					System.out.println("\nPROJETO NÃO ENCONTRADO.");
			}
		}
	}
}
