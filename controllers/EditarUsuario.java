package controllers;

import java.util.ArrayList;
import java.util.Scanner;

import models.Atividades;
import models.Conta;
import models.Projeto;
import models.Usuario;

public class EditarUsuario {
	public void editarUsuario(Conta account) {
		Scanner input = new Scanner(System.in);

		String firstName, lastName, username, password, projectId, activityId;
		ArrayList<Usuario> users = new ArrayList<Usuario>();
		ArrayList<Projeto> projectsEnvolved = new ArrayList<Projeto>();
		ArrayList<Atividades> activitiesEnvolved = new ArrayList<Atividades>();

		Usuario currentUser = null;

		System.out.println("INSIRA SEU USERNAME: ");
		username = input.nextLine();

		System.out.println("INSIRA SUA SENHA: ");
		password = input.nextLine();

		for (Usuario user : account.getUsers())
			if (user.getUsername().equals(username) && user.getPassword().equals(password))
				currentUser = user;

		if (currentUser != null) {
			System.out.println("\nINSIRA SEU NOME: ");
			firstName = input.nextLine();
			currentUser.setFirstName(firstName);

			System.out.println("INSIRA SEU SOBRENOME: ");
			lastName = input.nextLine();
			currentUser.setLastName(lastName);

			System.out.println("INSIRA SEU USUARIO: ");
			username = input.nextLine();
			currentUser.setUsername(username);

			System.out.println("INSIRA SUA SENHA: ");
			password = input.nextLine();
			currentUser.setPassword(password);

			System.out.println("INSIRA QUAIS PROJETOS ESTA ENVOLVIDO: ");
			int option = 12;
			while (option != 0) {
				System.out.println("1 - ADICIONAR PROJETO.");
				System.out.println("0 - SAIR.");
				option = input.nextInt();
				input.nextLine();

				switch (option) {
				case 0:
					break;
				case 1:
					System.out.println("ID DO PROJETO: ");
					projectId = input.nextLine();
					FindProject findProject = new FindProject();
					Projeto project = findProject.findProject(projectId, account);
					if (project != null) {
						projectsEnvolved.add(project);
						System.out.println("\nPROJETO ADICIONADO COM SUCESSO.\n");
					} else
						System.out.println("\nID NAO ENCONTRADOR, DIGITE NOVAMENTE.\n");
					break;
				}
			}
			currentUser.setProjectsEnvolved(projectsEnvolved);

			System.out.println("INSIRA QUAIS ATIVIDADES ESTA ENVOLVIDO: ");
			int option2 = 12;
			while (option2 != 0) {
				System.out.println("1 -ADICIONAR UMA ATIVIDADES.");
				System.out.println("0 - SAIR.");
				option2 = input.nextInt();
				input.nextLine();

				switch (option2) {
				case 0:
					break;
				case 1:
					System.out.println("ID DA ATIVIDADE: ");
					activityId = input.nextLine();
					FindActivity findActivity = new FindActivity();
					Atividades activity = findActivity.findActivity(activityId, account);
					if (activity != null) {
						activitiesEnvolved.add(activity);
						System.out.println("\nATIVIDADE ADICIONADA COM SUCESSO\n");
					} else
						System.out.println("\nID NAO ENCONTRADO, DIGITE NOVAMENTE.\n");
					break;
				}
			}
			currentUser.setActivitiesEnvolved(activitiesEnvolved);

			System.out.println("\nSUA CONTA FOI EDITADA COM SUCESSO!");
		}

		else
			System.out.println("\nALGO DEU ERRADO, TENTE NOVAMENTE.");
	}

}
