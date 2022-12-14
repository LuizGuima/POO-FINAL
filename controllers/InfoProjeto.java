package controllers;

import java.util.Scanner;

import models.Conta;
import models.Projeto;

public class InfoProjeto {
	public void infoProjeto(Conta account) {
		Scanner input = new Scanner(System.in);

		String id;
		Projeto wantedProject = null;

		System.out.println("INSIRA O ID DO PROJETO QUE DESEJA CONSULTAR: ");
		id = input.nextLine();

		for (Projeto project : account.getProjects())
			if (project.getId().equals(id))
				wantedProject = project;

		if (wantedProject != null)
			System.out.println(wantedProject.getAllInfo());
		else
			System.out.println("\nPROJETO NAO ENCONTRADO.\n");
	}
}
