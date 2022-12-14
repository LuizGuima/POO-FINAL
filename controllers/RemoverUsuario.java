package controllers;

import java.util.Scanner;

import models.Conta;
import models.Usuario;

public class RemoverUsuario {
	public void removerUsuario(Conta account) {
		Scanner input = new Scanner(System.in);
		String username, password;
		Usuario wantedUser = null;

		System.out.println("INSIRA SEU USERNAME: ");
		username = input.nextLine();

		System.out.println("INSIRA SUA SENHA: ");
		password = input.nextLine();

		for (Usuario user : account.getUsers())
			if (user.getUsername().equals(username) && user.getPassword().equals(password))
				wantedUser = user;

		if (wantedUser != null) {
			account.getUsers().remove(wantedUser);
			System.out.println("\nUSUARIO REMOVIDO COM SUCESSO\n");
		}

		else
			System.out.println("ALGO DEU ERRADO TENTE NOVAMENTE.");
	}
}
