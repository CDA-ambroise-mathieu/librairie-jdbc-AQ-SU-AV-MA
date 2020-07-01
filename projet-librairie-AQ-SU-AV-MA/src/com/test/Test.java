package com.test;

import dao.bdd.PersonneDaoImpl;
import models.Personne;

public class Test {

	public static void main(String[] args) {
		System.out.println("OK Mathieu");
		System.out.println("OK Mathieu");
		System.out.println("Yes maggle Alice");

		PersonneDaoImpl personneDaoImpl = new PersonneDaoImpl();
		Personne personne = new Personne("Wick", "John");
		Personne insertedPersonne = personneDaoImpl.save(personne);
		if (insertedPersonne != null)
			System.out.println("personne num´ero " + insertedPersonne.getId() + " a ´et´e ins´er´ee");
		else
			System.out.println("probl`eme d’insertion");

	}

}
