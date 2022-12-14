package controllers;

import java.util.Scanner;

import models.Conta;
import models.Projeto;

public class CheckStatus {
	public void checkStatus(Conta account) {
		Scanner input = new Scanner(System.in);
		String id;
		String projectStatus = null;

		System.out.println("INSIRA O ID DO PREOJETO QUE DESEJA VER O STATUS: ");
		id = input.nextLine();

		for (Projeto project : account.getProjects())
			if (project.getId().equals(id))
				projectStatus = project.getStatus();

		System.out.printf("%nStatus: %s%n", projectStatus);
	}

}
