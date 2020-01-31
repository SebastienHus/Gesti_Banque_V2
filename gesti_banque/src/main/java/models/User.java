package models;

import java.sql.*;

public class User {

	// param(s)
	private long id;

	private String login;
	private String firstname;
	private String lastName;
	private String email;
	private String password;
	private long phone;
	private Address address;
	private long typeOfUser;

	public User verifUser(String username, String password) {
		Connexion cnx = new Connexion();
		Connection con = cnx.getCnx();
		User u = new User();
		Address a = new Address();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM User WHERE login = ? and password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				u.setId(rs.getInt(1));
				u.setAddress(a.getAddress(rs.getLong(13)));
				u.setEmail(rs.getString(6));
				u.setFirstname(rs.getString(5));
				u.setLastName(rs.getString(4));
				u.setLogin(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setPhone(rs.getLong(7));
				u.setTypeOfUser(rs.getLong(8));
				System.out.println("User capté :" + u);
				return u;
			} else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return u;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", firstname=" + firstname + ", lastName=" + lastName
				+ ", email=" + email + ", password=" + password + ", phone=" + phone + ", address=" + address
				+ ", typeOfUser=" + typeOfUser + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// Constructor(s)
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String login, String firstname, String lastName, String email, String password, long phone,
			Address address, long typeOfUser) {
		super();
		this.login = login;
		this.firstname = firstname;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.typeOfUser = typeOfUser;
	}

	// getters and setters

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public long getTypeOfUser() {
		return typeOfUser;
	}

	public void setTypeOfUser(long typeOfUser) {
		this.typeOfUser = typeOfUser;
	}

	public boolean createUser(String name, String firstname, String email, String login, String password, long phone,
			String streetNumber, String town, String zipcode, String street, String complement) {

		Connexion cnx = new Connexion();
		Connection con = cnx.getCnx();
		User u = new User();
		Address a = new Address();
		int idAddress;
		a.setStreetNumber(streetNumber);
		a.setComplement(complement);
		a.setCountry(town);
		a.setStreet(street);
		a.setZipcode(zipcode);

		// on vérifie si l'utilisateur existe via login et mot de passe
		try {

			PreparedStatement ps = con.prepareStatement("SELECT * FROM User WHERE email = ?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return false; // on lui envoie un message lui demandant de se connecter
			} else {
				PreparedStatement psa = con.prepareStatement(
						"SELECT IdAdresse FROM Adresse WHERE numero = ? AND complement = ? AND ville = ? "
								+ "AND codePostal = ? AND rue = ?");
				psa.setString(1, streetNumber);
				psa.setString(2, complement);
				psa.setString(3, town);
				psa.setString(4, zipcode);
				psa.setString(5, street);
				ResultSet rsa = psa.executeQuery();
				// On vérifie si l'adresse existe et on récupère son id
				if (rsa.next()) {

					idAddress = Integer.parseInt(rsa.toString());

				} else {
					//si elle n'existe pas on la rentre en base de données
					PreparedStatement psAddA = con
							.prepareStatement("INSERT INTO gestibankv2.adresse (IdAdresse, numero, complement, ville,"
									+ " codePostal, rue) VALUES (NULL, ?, ?, ?, ?, ?");
					psAddA.setString(1, streetNumber);
					psAddA.setString(2, complement);
					psAddA.setString(3, town);
					psAddA.setString(4, zipcode);
					psAddA.setString(5, street);
					psAddA.executeUpdate();
					
					//on récupère l'id de la nouvelle adresse pour créer le nouvel utilisateur
					PreparedStatement psIddAdress = con.prepareStatement(
							"SELECT IdAdresse FROM Adresse WHERE numero = ? AND complement = ? AND ville = ? "
									+ "AND codePostal = ? AND rue = ?");
					psIddAdress.setString(1, streetNumber);
					psIddAdress.setString(2, complement);
					psIddAdress.setString(3, town);
					psIddAdress.setString(4, zipcode);
					psIddAdress.setString(5, street);

					ResultSet rsidAddress = psIddAdress.executeQuery();
					idAddress = Integer.parseInt(rsidAddress.toString());
				}
				
				//création du nouvel utilisateur dans la BDD
				PreparedStatement psu = con.prepareStatement(
						"INSERT INTO gestibankv2.user  " + "( idUser, login, password, nom, prenom, email, telephone, "
								+ "IdRole, matricule, idNotification, idBoss, idVisaVis, idAdresse)"
								+ " VALUES (NULL, ?, ?, ?, ?, ?, ?, '3', NULL, NULL, NULL, NULL, ?");
				psu.setString(1, login);
				psu.setString(2, password);
				psu.setString(3, name);
				psu.setString(4, firstname);
				psu.setString(5, email);
				psu.setLong(6, phone);
				psu.setInt(7, idAddress);
				psu.executeUpdate();

				u.setId(rs.getInt(1));
				u.setAddress(a.getAddress(rs.getLong(13)));
				u.setEmail(rs.getString(6));
				u.setFirstname(rs.getString(5));
				u.setLastName(rs.getString(4));
				u.setLogin(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setPhone(rs.getLong(7));
				u.setTypeOfUser(rs.getLong(8));
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
	}
	
	//création de la demande d'ouverture d'un compte
	public boolean requestOpenningAccount(User u) {
			Connexion cnx = new Connexion();
			Connection con = cnx.getCnx();
			
			try {
				PreparedStatement psu = con.prepareStatement("SELECT idUser FROM User WHERE email = ?");
				psu.setString(1, u.getEmail());
				ResultSet rsu = psu.executeQuery();
				int idUser  = Integer.parseInt(rsu.toString());
				
				PreparedStatement ps = con.prepareStatement("INSERT INTO gestibankv2.demande "
						+ "(IDDemande, id_client, dateCreation, demandeChequier, demandeCloture) "
						+ "VALUES (NULL, ?, CURRENT_TIMESTAMP, NULL, NULL)");
				ps.setInt(1, idUser);
				psu.executeUpdate();		
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 			
		
		return true;
	}

}
