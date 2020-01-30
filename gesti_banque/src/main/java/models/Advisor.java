package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Advisor extends User {

	private String matriculeAdvisor;
	private PreparedStatement st = null;
	private ResultSet rs = null;

	public Advisor() {
		super();
	}

	public Advisor(String login, String firstname, String lastName, String email, String password, String phone,
			Address address, String typeOfUser) {
		super();
	}

	public Advisor(String matriculeAdvisor) {
		super();
		this.matriculeAdvisor = matriculeAdvisor;
	}

	public String getMatriculeAdvisor() {
		return matriculeAdvisor;
	}

	public void setMatriculeAdvisor(String matriculeAdvisor) {
		this.matriculeAdvisor = matriculeAdvisor;
	}

	// Si le conseiller veut valider l'ouverture du compte apres avoir verifier
	// l'ensemble des renseignements il lui suffira de cocher la validation de
	// l'ouverture du compte

	public boolean validateOpenCompte(boolean validation) {
		if (validation)
			return true;
		else
			return false;
	}

	// ici le conseiller doit verifier que le solde du compte soit egale à 0 donc pas de
	// decouvert ni d'avoir pour valider la fermeture du compte en cochant la bonne
	// case
	public boolean validateClosedCompte(float solde, boolean close) {
		if (solde == 0 && close == true)
			return true;
		else
			return false;
	}

	// liste de l'ensemble des données relatives à un client par conseiller

	public ArrayList<User> showClientList(String matricule)
	{
		ArrayList <User> liste=new ArrayList<User>();
		try
		{
			Connexion cnx = new Connexion();
			Connection con = cnx.getCnx();
			st=con.prepareStatement("SELECT client.*, a.* FROM user agent, user client, adresse a  WHERE agent.matricule = ? AND client.idvisavis = agent.idUser AND a.idAdresse = client.idAdresse AND agent.idRole = 2");
			st.setString(1, matricule);
			rs=st.executeQuery();
			while(rs.next())
			{
				Address a = new Address();
				User u=new User();
				u.setFirstname(rs.getString("prenom"));
				u.setLastName(rs.getString("nom"));
				u.setPhone(rs.getLong("telephone"));
				u.setAddress(a.getAddress(rs.getLong(13)));
				u.setEmail(rs.getString("email"));
								
				liste.add(u);				
			}			
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return liste;
	}

	// liste de l'ensemble des données relatives à un client par conseiller et par nom
	public ArrayList<User> showClientSearchByName(String matricule, String name){
		 ArrayList <User> liste=new ArrayList<User>();
			try
			{
				Connexion cnx = new Connexion();
				Connection con = cnx.getCnx();
				st=con.prepareStatement("SELECT client.*, a.* FROM user agent, user client, adresse a  WHERE agent.matricule = ? AND client.idvisavis = agent.idUser AND a.idAdresse = client.idAdresse AND agent.idRole = 2 AND Name =?");
				st.setString(1, matricule);
				st.setString(2, name);
				rs=st.executeQuery();
				while(rs.next())
				{
					Address a = new Address();
					User u=new User();
					u.setFirstname(rs.getString("prenom"));
					u.setLastName(rs.getString("nom"));
					u.setPhone(rs.getLong("telephone"));
					u.setAddress(a.getAddress(rs.getLong(13)));
					u.setEmail(rs.getString("email"));
					
					liste.add(u);					
				}				
			}
			catch(SQLException ex)
			{
				System.out.println(ex.getMessage());
			}
			return liste;		
	}

	// liste de l'ensemble des données relatives à un client par conseiller et par numero de compte
	public ArrayList<User> showClientSearchByNumberAccount(String matricule, String NumberAccount){
		 ArrayList <User> liste=new ArrayList<User>();
			try
			{
				Connexion cnx = new Connexion();
				Connection con = cnx.getCnx();
				st=con.prepareStatement("SELECT client.*, a.* FROM user agent, user client, adresse a, compte c  WHERE agent.matricule = ? AND client.idvisavis = agent.idUser AND a.idAdresse = client.idAdresse AND agent.idRole = 2 AND client.idUser = c.idClient AND NumCompte =?");
				st.setString(1, matricule);
				st.setString(2, NumberAccount);
				rs=st.executeQuery();
				while(rs.next())
				{
					Address a = new Address();
					User u=new User();
					u.setFirstname(rs.getString("prenom"));
					u.setLastName(rs.getString("nom"));
					u.setPhone(rs.getLong("telephone"));
					u.setAddress(a.getAddress(rs.getLong(13)));
					u.setEmail(rs.getString("email"));
					
					liste.add(u);					
				}				
			}
			catch(SQLException ex)
			{
				System.out.println(ex.getMessage());
			}
			return liste;		
	}
}
