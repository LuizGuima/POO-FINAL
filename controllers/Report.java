package controllers;

import models.Atividades;
import models.Conta;
import models.Projeto;

public class Report {
	public void report(Conta account) {
		System.out.println("\nPROJETOS: ");
		for (Projeto project : account.getProjects())
			System.out.println(project.getAllInfo());
		System.out.println("\nATIVIDADES: ");
		for (Atividades activity : account.getActivities())
			System.out.println(activity.getAllInfo());
	}

}
