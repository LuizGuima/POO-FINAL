package controllers;

import java.util.ArrayList;
import java.util.Scanner;

import models.Atividades;
import models.Conta;
import models.Projeto;
import models.Usuario;

public class EditarAtv {
	public void editarAtv(Conta account) {
		Scanner input = new Scanner(System.in);

		String id, description, startAt, endAt, leader, instructions, username;
		ArrayList<Usuario> members = new ArrayList<Usuario>();

		System.out.println("\nINSIRA O ID DA ATIVIDADE QUE QUER EDITAR: ");
		id = input.nextLine();

		Atividades currentActivity = null;

		for (Atividades activity : account.getActivities()) {
			if (activity.getId().equals(id)) {
				currentActivity = activity;
			}
		}

		System.out.println("INSIRA UM ID PARA A ATIVIDADE: ");
		id = input.nextLine();
		currentActivity.setId(id);

		System.out.println("INSIRA UMA DESCRICAO DA ATIVIDADE: ");
		description = input.nextLine();
		currentActivity.setDescription(description);

		System.out.println("INSIRA A DATA DE INICIO DA ATIVIDADE: ");
		startAt = input.nextLine();
		currentActivity.setStartAt(startAt);

		System.out.println("INSIRA A DATA DE TERMINO DA ATIVIDADE: ");
		endAt = input.nextLine();
		currentActivity.setEndAt(endAt);

		System.out.println("INSIRA O RESPONSAVEL PELA ATIVIDADE: ");
		leader = input.nextLine();
		currentActivity.setLeader(leader);

		System.out.println("INSIRA O USERNAME DOS MEMBROS: ");
		int option = 12;
		while (option != 0) {
			System.out.println("1 - ADICIONAR UM USERNAME.");
			System.out.println("0 - SAIR.");
			option = input.nextInt();
			input.nextLine();

			switch (option) {
			case 0:
				break;
			case 1:
				System.out.println("USERNAME: ");
				username = input.nextLine();
				FindUser findUser = new FindUser();
				Usuario user = findUser.findUser(username, account);
				if (user != null) {
					members.add(user);
					System.out.println("USUARIO ADICIONADO COM SUCESSO.");
				} else
					System.out.println("\nUSERNAME NAO ENCONTRADO, TENTE NOVAMENTE.\n");
				break;
			}
		}
		currentActivity.setMembers(members);

		System.out.println("INSIRA AS INSTRUCOES: ");
		instructions = input.nextLine();
		currentActivity.setInstructions(instructions);

		System.out.printf("\nO PROJETO COM ID %s FOI EDITADO COM SUCESSO.", id);
	}

}
