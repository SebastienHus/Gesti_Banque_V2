package models;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Address {

	// param(s)
	private String streetNumber;
	private String street;
	private String town;
	private String zipcode;
	private String country;
	private String complement;
	private PreparedStatement st = null;

	// Constructor(s)
	public Address() {
		super();
	}

	public Address(String streetNumber, String street, String town, String zipcode, String country, String complement) {
		super();
		this.streetNumber = streetNumber;
		this.street = street;
		this.town = town;
		this.zipcode = zipcode;
		this.country = country;
		this.complement = complement;
	}

	// method(s)

	// getters and setters
	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}
	
	public Address getAddress(long id) {
		Address a=new Address();
		try
		{
			Connexion cnx = new Connexion();
			Connection con = cnx.getCnx();
			st=con.prepareStatement("select * from adresse Where IdAdresse =? ");
			st.setLong(1, id);
			ResultSet rs=st.executeQuery();
			if(rs.next())
			{
				a.setStreetNumber(rs.getString("numero"));
				a.setStreet(rs.getString("rue"));
				a.setComplement(rs.getString("complement"));
				a.setZipcode(rs.getString("codePostal"));				
				a.setTown(rs.getString("ville"));
				
				return a;
			}				
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return a;		
	}

}
