package controllers;

import java.util.ArrayList;
import java.util.Scanner;

import models.Aluno;
import models.Atividades;
import models.Conta;
import models.Pesquisador;
import models.Professor;
import models.Profissional;
import models.Projeto;
import models.Usuario;

public class AdcNovoUsuario {
	public void adcNovoUsuario(Conta account) {
		Scanner input = new Scanner(System.in);

		String firstName, lastName, username, password, projectId, activityId;
		ArrayList<Usuario> users = new ArrayList<Usuario>();
		ArrayList<Projeto> projectsEnvolved = new ArrayList<Projeto>();
		ArrayList<Atividades> activitiesEnvolved = new ArrayList<Atividades>();
		Usuario user = null;
		System.out.println("\nINSIRA SEU NOME: ");
		firstName = input.nextLine();
		System.out.println("INSIRA SEU SOBRENOME: ");
		lastName = input.nextLine();

		System.out.println("INSIRA SEU USERNAME: ");
		username = input.nextLine();

		System.out.println("INSIRA SUA SENHA: ");
		password = input.nextLine();

		System.out.println("INSIRA SUA POSIÇAO NA UNIVERDADE: ");
		System.out.println("1 - ESTUDANTE.\n2 - PROFESSOR.\n3 - PESQUISADOR\n4 - PROFISSIONAL: ");
		int optionUserType = input.nextInt();
		input.nextLine();

		switch (optionUserType) {
		case 1:
			String degree = null;
			int degreeOption;
			System.out.println("SELECIONE SUA ESCOLARIDADE:\n1 - GRADUANDO.\n2 - MESTRE.\n3 -  DOUTOR.");
			degreeOption = input.nextInt();
			switch (degreeOption) {
			case 1:
				degree = "GRADUANDO";
				break;
			case 2:
				degree = "MESTRE";
				break;
			case 3:
				degree = "DOUTOR";
				break;
			}
			try {
				user = new Aluno(firstName, lastName, username, password, degree);
				System.out.println("\nVOCE FOI REGISTRADOR COM SUCESSO!");
			} catch (Exception e) {
				System.out.println("\n" + e.getMessage());
			}

			break;
		case 2:
			System.out.println("DE QUAL MATERIA? ");
			String subject = input.nextLine();
			user = new Professor(firstName, lastName, username, password, subject);
			break;
		case 3:
			System.out.println("QUAL PESQUISA? ");
			String subjectR = input.nextLine();
			user = new Pesquisador(firstName, lastName, username, password, subjectR);
			break;
		case 4:
			int typeOption;
			String type = null;
			System.out.println("QUE TIPO DE PROFISSIONAL VOCE E?:\n1 - DESENVOLVEDOR.\n2 - TESTADOR.\n3 - ANALISTA.");
			typeOption = input.nextInt();
			switch (typeOption) {
			case 1:
				type = "DESENVOLVEDOR";
				break;
			case 2:
				type = "TESTADOR";
				break;
			case 3:
				type = "ANALISTA";
				break;
			}

			user = new Profissional(firstName, lastName, username, password, type);
			System.out.println("\nVOCE FOI REGISTRADOR COM SUCESSO!");

			break;
		}

		users = account.getUsers();
		users.add(user);
		account.setUser(users);

	}

}
