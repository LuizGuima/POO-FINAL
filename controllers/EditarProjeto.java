package controllers;

import java.util.ArrayList;
import java.util.Scanner;

import models.Atividades;
import models.Conta;
import models.Pesquisador;
import models.Professor;
import models.Projeto;
import models.Usuario;

public class EditarProjeto {
	public void editarProjeto(Conta account) {
		Scanner input = new Scanner(System.in);

		String id, description, startAt, endAt, coordinatorUsername, duringAt, username, activityId;
		Usuario coordinator = null;
		double schoolarAmount;
		ArrayList<Usuario> members = new ArrayList<Usuario>();
		ArrayList<Atividades> activities = new ArrayList<Atividades>();

		System.out.println("INSIRA O ID DO PROJETO QUE DESEJA EDITAR: ");
		id = input.nextLine();

		Projeto currentProject = null;

		for (Projeto project : account.getProjects()) {
			if (project.getId().equals(id)) {
				currentProject = project;
			}
		}

		System.out.println("INSIRA UM ID PARA O PROJETO: ");
		id = input.nextLine();
		currentProject.setId(id);

		System.out.println("INSIRA UMA DESCRICAO DO PROJETO: ");
		description = input.nextLine();
		currentProject.setDescription(description);

		System.out.println("INSIRA A DATA DE INICIO DO PROJETO: ");
		startAt = input.nextLine();
		currentProject.setStartAt(startAt);

		System.out.println("INSIRA A DATA DE TERMINO DO PROJETO: ");
		endAt = input.nextLine();
		currentProject.setEndAt(endAt);

		System.out.println("INSIRA O USERNAME DO CORDENADOR DO PROJETO: ");
		coordinatorUsername = input.nextLine();
		for (Usuario user : account.getUsers()) {
			if (user.getUsername().equals(coordinatorUsername)) {
				coordinator = user;
				if (user instanceof Professor | user instanceof Pesquisador)
					coordinator = user;
				else
					System.out.println("ESSE USUARIO NAO PODE SER COORDENADOR DO PROJETO.");
			}
		}

		if (coordinator == null)
			System.out.println("Username not found.");
		currentProject.setCoordinator(coordinator);

		System.out.println("INSIRA UM USERNAME PARA ADICIONAR AO PROJETO: ");
		int option = 12;
		while (option != 0) {
			System.out.println("1 - ADIONAR UM USERNAME.");
			System.out.println("0 - SAIR.");
			option = input.nextInt();
			input.nextLine();

			switch (option) {
			case 0:
				break;
			case 1:
				System.out.println("Username: ");
				username = input.nextLine();
				FindUser findUser = new FindUser();
				Usuario user = findUser.findUser(username, account);
				if (user != null) {
					members.add(user);
					System.out.println("USUARIO ADICIONADO COM SUCESSO.");
				} else
					System.out.println("\nUSUARIO NAO ENCONTRADOR, TENTE NOVAMENTE.\n");
				break;
			}
		}
		currentProject.setMembers(members);

		System.out.println("Enter the Id's to add activities: ");
		int option2 = 12;
		while (option2 != 0) {
			System.out.println("1 - Add an activity.");
			System.out.println("0 - Exit.");
			option2 = input.nextInt();
			input.nextLine();

			switch (option2) {
			case 0:
				break;
			case 1:
				System.out.println("INISRA O ID DA ATIVIDADE: ");
				activityId = input.nextLine();
				FindActivity findActivity = new FindActivity();
				Atividades activity = findActivity.findActivity(activityId, account);
				if (activity != null) {
					activities.add(activity);
					System.out.println("ATIVIDADE ADICIONADA COM SUCESSO.");
				} else
					System.out.println("\nATIVIDADE NAO ENCONTRADA, TENTE NOVAMENTE.\n");
				break;
			}
		}
		currentProject.setActivities(activities);

		System.out.println("INSIRA O VALOR DA BOLSA: ");
		schoolarAmount = input.nextDouble();
		input.nextLine();
		currentProject.setSchoolarAmount(schoolarAmount);

		System.out.println("INSIRA A DURACAO DO PROJETO: ");
		duringAt = input.nextLine();
		currentProject.setDuringAt(duringAt);

		System.out.printf("\nPROJETO COM ID %s FOI EDITADOR COM SUCESSO.\n", id);

	}
}

