package models;

import java.util.ArrayList;
import java.util.Scanner;

import controllers.AdcNovaAtv;
import controllers.AdcNovoProject;
import controllers.AdcNovoUsuario;
import controllers.CheckStatus;
import controllers.EditarAtv;
import controllers.EditarProjeto;
import controllers.EditarUsuario;
import controllers.FolhaDePagamento;
import controllers.InfoAtv;
import controllers.InfoProjeto;
import controllers.UserInformation;
import controllers.Payment;
import controllers.RemoveProject;
import controllers.RemoverAtv;
import controllers.RemoverUsuario;
import controllers.Report;
import controllers.Status;

public class Universidade {

	public void menu(Conta account) {
		Scanner input = new Scanner(System.in);
		int option = 13;

		while (option != 0) {
			System.out.println("\nO que deseja fazer?: ");
			System.out.println("[1] Login.");
			System.out.println("[2] Criar Conta.");
			System.out.println("[0] Sair.");

			option = input.nextInt();

			switch (option) {
			case 0:
				System.out.println("\nVoce saiu!");
				break;
			case 1:
				login(account);
				break;
			case 2:
				AdcNovoUsuario adcNovoUsuario = new AdcNovoUsuario();
				adcNovoUsuario.adcNovoUsuario(account);
			}
		}
	}

	public void system(Conta account, Usuario user) {
		Scanner input = new Scanner(System.in);
		int option = 18;

		while (option != 0) {
			System.out.println("\nEscolha o que deseja fazer: ");
			System.out.println("1 - ADICIONAR UM PROJETO.");
			System.out.println("2 - ADICIONAR UMA ATIVIDADE.");
			System.out.println("3 -ADICIONAR UM USUARIO.");
			System.out.println("4 - EDITAR UM PROJETO.");
			System.out.println("5 - EDITAR UMA ATIVIDADE.");
			System.out.println("6 - EDITAR UM USUARIO.");
			System.out.println("7 - REMOVER UM PROJETO.");
			System.out.println("8 - REMOVER UMA ATIVIDADE.");
			System.out.println("9 - REMOVER UM USARIO.");
			System.out.println("10 - CONSULTAR UM USUARIO.");
			System.out.println("11 - CONSULTAR UM PROJETO.");
			System.out.println("12 - CONSULTAR UMA ATIVIDADE.");
			System.out.println("13 - CONSULTAR STATUS DO PROJETO.");
			System.out.println("14 - DEFINIR STATUS DO PROJETO.");
			System.out.println("15 - PAGAMENTO.");
			System.out.println("16 - FOLHA DE PAGAMENTO.");
			System.out.println("17 - SEUS PROJETOS E ATIVIDADES.");
			System.out.println("0 - SAIR.");

			option = input.nextInt();

			switch (option) {
			case 0:
				break;
			case 1:
				AdcNovoProject adcNovoProject = new AdcNovoProject();
				adcNovoProject.adcNovoProjeto(account);
				break;
			case 2:
				AdcNovaAtv adcNovaAtv = new AdcNovaAtv();
				adcNovaAtv.adcNovaAtv(account);
				break;
			case 3:
				AdcNovoUsuario adcNovoUsuario = new AdcNovoUsuario();
				adcNovoUsuario.adcNovoUsuario(account);
				break;
			case 4:
				EditarProjeto editarProjeto = new EditarProjeto();
				editarProjeto.editarProjeto(account);
				break;
			case 5:
				EditarAtv editarAtv = new EditarAtv();
				editarAtv.editarAtv(account);
				break;
			case 6:
				EditarUsuario editarUsuario = new EditarUsuario();
				editarUsuario.editarUsuario(account);
				break;
			case 7:
				RemoveProject removeProject = new RemoveProject();
				removeProject.removerProjeto(account);
				break;
			case 8:
				RemoverAtv removerAtv = new RemoverAtv();
				removerAtv.removerAtv(account);
				break;
			case 9:
				RemoverUsuario removerUsuario = new RemoverUsuario();
				removerUsuario.removerUsuario(account);
				break;
			case 10:
				UserInformation userInformation = new UserInformation();
				userInformation.userInformation(account);
				break;
			case 11:
				InfoProjeto infoProjeto = new InfoProjeto();
				infoProjeto.infoProjeto(account);
				break;
			case 12:
				InfoAtv infoAtv = new InfoAtv();
				infoAtv.infoAtv(account);
				break;
			case 13:
				CheckStatus checkStatus = new CheckStatus();
				checkStatus.checkStatus(account);
				break;
			case 14:
				Status status = new Status();
				status.status(account,user);
				break;
			case 15:
				Payment payment = new Payment();
				payment.payment(account);
				
				break;
			case 16:
				FolhaDePagamento folhaDePagamento = new FolhaDePagamento();
				folhaDePagamento.folhaDePagamento(account);
				break;
			case 17:
				Report report = new Report();
				report.report(account);
				break;
			}
		}
	}

	public void login(Conta account) {
		Scanner input = new Scanner(System.in);

		String firstName, lastName, username, password;
		ArrayList<Usuario> users = new ArrayList<Usuario>();

		Usuario currentUser = null;

		System.out.println("\nINSIRO O USERNAME: ");
		username = input.nextLine();

		System.out.println("INSIRA A SENHA: ");
		password = input.nextLine();

		for (Usuario user : account.getUsers()) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password))
				currentUser = user;
			else if (user.getUsername().equals(username)) {
				int option;
				System.out.println("\n SENHA ERRADA");
				break;

			}
		}
		if (currentUser != null)
			system(account, currentUser);
		else
			System.out.println("\nVOCE NAO ESTA REGISTRADO.");
	}

	
	

	

	
	
	
	
	

}