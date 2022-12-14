package controllers;

import java.util.Scanner;

import models.Conta;
import models.Usuario;

public class UserInformation {
	public void userInformation(Conta account) {
		Scanner input = new Scanner(System.in);

		String username;
		Usuario wantedUser = null;

		System.out.println("\nINSIRA O USERNAME QUE QUER CONSULTAR: ");
		username = input.nextLine();

		for (Usuario user : account.getUsers())
			if (user.getUsername().equals(username))
				wantedUser = user;

		if (wantedUser != null)
			System.out.printf("%nINFORMACOES DO USUÁRIO: %s%n", wantedUser);
		else
			System.out.println("\nUSUÁRIO NAO ENCONTRADO.\n");
	}

}
