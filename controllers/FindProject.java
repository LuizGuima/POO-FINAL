package controllers;

import models.Conta;
import models.Projeto;

public class FindProject {
	public Projeto findProject(String projectId, Conta account) {
		for (Projeto project : account.getProjects())
			if (project.getId().equals(projectId))
				return project;
		return null;
	}
}
