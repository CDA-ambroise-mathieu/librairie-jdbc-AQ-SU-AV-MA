package models;

import java.util.HashMap;

import lombok.Data;

@Data
public class Panier {

	private HashMap<Livre , Integer> hmapPanier = new HashMap<>();
	
}
