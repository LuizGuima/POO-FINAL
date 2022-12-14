package controllers;

import java.util.Scanner;

import models.Atividades;
import models.Conta;

public class RemoverAtv {
	public void removerAtv(Conta account) {
		Scanner input = new Scanner(System.in);
		String id;
		Atividades wantedActivity = null;

		System.out.println("INSIRA O ID DA ATIVIDADE QUE DESEJA REMOVER: ");
		id = input.nextLine();

		for (Atividades activity : account.getActivities())
			if (activity.getId().equals(id))
				wantedActivity = activity;

		if (wantedActivity != null) {
			account.getActivities().remove(wantedActivity);
			System.out.println("\nATIVIDADE REMOVIDA COM SUCESSO!\n");
		}

		else
			System.out.println("A ATIVIDADE NÃO FOI ENCONTRADA.");
	}
}
