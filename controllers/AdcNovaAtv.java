package controllers;

import java.util.ArrayList;
import java.util.Scanner;

import models.Atividades;
import models.Conta;
import models.Usuario;

public class AdcNovaAtv {
	public void adcNovaAtv(Conta account) {
		Scanner input = new Scanner(System.in);

		String id, description, startAt, endAt, leader, instructions, username;
		ArrayList<Usuario> members = new ArrayList<Usuario>();
		ArrayList<Atividades> activities = new ArrayList<Atividades>();

		System.out.println("\nINSIRA O ID DA ATIVIDADE: ");
		id = input.nextLine();

		System.out.println("INSIRA A DESCRICAO DA ATIVIDADE: ");
		description = input.nextLine();

		System.out.println("INSIRA A DATA DE INICIO DA ATIVIDADE: ");
		startAt = input.nextLine();

		System.out.println("INSIRA A DATA DE TERMINO DA ATIVIDADE: ");
		endAt = input.nextLine();

		System.out.println("INSIRA O RESPONSAVEL PELA ATIVIDADE: ");
		leader = input.nextLine();

		System.out.println("INSIRA OS USERNAMES PARA ADICIONAR OS MEMBROS: ");
		int option = 12;
		while (option != 0) {
			System.out.println("1 - ADICIONA UM USERNAME.");
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

		System.out.println("INSIRA AS INSTRUCOES: ");
		instructions = input.nextLine();

		Atividades activity = new Atividades(id, description, startAt, endAt, leader, members, instructions);

		activities = account.getActivities();
		activities.add(activity);
		account.setActivities(activities);

		System.out.printf("%nATIVIDADE CRIADA COM SUCESSO!%n");
	}

}
