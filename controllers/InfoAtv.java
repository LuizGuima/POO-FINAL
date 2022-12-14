package controllers;

import java.util.Scanner;

import models.Atividades;
import models.Conta;

public class InfoAtv {
	public void infoAtv(Conta account) {
		Scanner input = new Scanner(System.in);

		String id;
		Atividades wantedActivity = null;

		System.out.println("INSIRA O ID DO ATIVIDADE QUE DESEJA CONSULTAR: ");
		id = input.nextLine();

		for (Atividades activity : account.getActivities())
			if (activity.getId().equals(id))
				wantedActivity = activity;

		if (wantedActivity != null)
			System.out.println(wantedActivity.getAllInfo());
		else
			System.out.println("\nATIVIDADE NAO ENCONTRADA.\n");
	}
}
