package br.com.daobeans;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection {
	private static EntityManagerFactory  emf=Persistence.createEntityManagerFactory("banco_pbd");;

	public static EntityManagerFactory getEmf() {
		return emf;
	}
	
	
}
