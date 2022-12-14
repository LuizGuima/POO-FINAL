package controllers;

import models.Atividades;
import models.Conta;

public class FindActivity {
	public Atividades findActivity(String activityId, Conta account) {
		for (Atividades activity : account.getActivities())
			if (activity.getId().equals(activityId))
				return activity;
		return null;
	}
}
