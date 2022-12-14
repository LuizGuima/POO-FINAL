package controllers;

import models.Conta;
import models.Usuario;

public class FindUser {
	 public Usuario findUser(String username, Conta account) {
		    for (Usuario user : account.getUsers()) 
		      if (user.getUsername().equals(username)) return user;
		    return null;
		  }
}
