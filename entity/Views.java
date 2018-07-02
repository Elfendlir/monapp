package com.monapp.entity;

public interface Views {
	
	public static interface Common{	
		public static interface Inventaire extends Common{}
		public static interface Item extends Common{}
		public static interface Partie extends Common{}
		public static interface Personnage extends Common{}
		public static interface Route extends Common{}
		public static interface Scenario extends Common{}
		public static interface Utilisateur extends Common{}
		public static interface ItemWithScenario extends Item{}
		public static interface ScenarioWithItem extends Scenario{}
		public static interface UtilisateurWithPartie extends Utilisateur{}
		public static interface PartieWithUtilisateur extends Partie{}	
		public static interface RouteWithRoute extends Route{}
		public static interface RouteWithScenario extends Route{}
		public static interface ScenarioWithRoute extends Scenario{}
		
	}
	
}
