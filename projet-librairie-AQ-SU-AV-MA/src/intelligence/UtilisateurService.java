package intelligence;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.DatatypeConverter;

import dao.Dao;
import dao.bdd.LivreDaoImpl;
import dao.bdd.MyConnection;
import dao.bdd.UtilisateurDaoImpl;
import models.Livre;
import models.Session;
import models.Utilisateur;

public class UtilisateurService {
	private Scanner sc;
	private Dao<Utilisateur> userDAO;

	public UtilisateurService() {
		sc = new Scanner(System.in);
		userDAO = new UtilisateurDaoImpl();
	}

	public boolean inscription() {
		int lastEntry = 0;
		String requete = "SELECT Utilisateur.id_utilisateur FROM Utilisateur ORDER BY Utilisateur.id_utilisateur DESC LIMIT 1;";

		try {
			Connection co = MyConnection.getConnection();
			PreparedStatement statement = co.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				lastEntry = result.getInt("id_utilisateur");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("*** INSCRIPTION ***");
		System.out.print("Nom :");
		String nom = sc.nextLine();

		System.out.print("Prenom :");
		String prenom = sc.nextLine();

		System.out.print("Login :");
		String login = sc.nextLine();

		System.out.print("Mot de passe :");
		String mdp = sc.nextLine();

		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			md.update(mdp.getBytes());
			byte[] digest = md.digest();
			String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
			System.out.println(myHash);
			mdp = myHash;

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Quel role souhaitez vous ?");
		System.out.println("(1) Client");
		System.out.println("(2) Libraire");
		String role = new String();
		boolean inscrit = false;
		if (sc.hasNextInt()) {
			int numRole = sc.nextInt();
			sc.nextLine();

			switch (numRole) {
			case 1:
				role = "client";
				break;
			case 2:
				role = "libraire";
				inscrit = true;
				break;
			default:
				System.out.println("Choix non supporté.");
				break;
			}
		} else {
			System.out.println("Veuillez entrer une valeur valide.");
		}

		if (((UtilisateurDaoImpl) userDAO).findByLogin(login) == null) {
			Utilisateur tmp = new Utilisateur(nom, prenom, role, login, mdp, inscrit, false);
			tmp = userDAO.save(tmp);

			if (tmp != null) {
				System.out.println("Creation reussi !");
				return true;
			} else {
				return false;
			}
		} else {
			System.out.println("Un utilisateur possède déjà ce pseudo, veuillez recommencer !");
		}
		return false;

	}

	public boolean authentification() {
		System.out.println("*** AUTHENTIFICATION ***");
		System.out.print("Login : ");
		String login = sc.nextLine();

		System.out.println("Mot de passe : ");
		String mdp = sc.nextLine();

		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			md.update(mdp.getBytes());
			byte[] digest = md.digest();
			String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
			mdp = myHash;

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		Utilisateur user = ((UtilisateurDaoImpl) userDAO).findByLogin(login);
		if (user != null) {
			if (user.getPassword().equals(mdp)) {
				if(user.getInscrit() == true) {
					Session curr = Session.getInstance();
					curr.connexion(user);
					return true;
				}else {
					System.out.println("Votre compte n'a pas été validé par le libraire. Veuillez vous référer à ce dernier.");
				}
			} else {
				System.out.println("Mot de passe incorrect !");
			}
		} else {
			System.out.println("Problème de connexion, veuillez recommencer !");
		}
		return false;
	}

	public void listerLivres() {
		LivreDaoImpl ldao = new LivreDaoImpl();
		ArrayList<Livre> livres = (ArrayList<Livre>) ldao.getAll();
		for (Livre livre : livres) {
			System.out.println("("+livre.getId()+")"+livre.getTitre()+" par "+livre.getAuteur()+" - "+livre.getAnneeParution());
		}
	}
}
