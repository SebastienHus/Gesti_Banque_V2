package controller;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ConversionDevises {
	/*
	 * public static void main(String[] args) {
	 * 
	 * 
	 * String deviseSRC; String deviseDest; float sum; System.out.
	 * println("Veuillez entrer la devise que vous souhaitez convertir (écrire en majuscules) : "
	 * ); Scanner sc = new Scanner(System.in); deviseSRC=sc.nextLine(); System.out.
	 * println("Veuillez entrer la devise dans laquelle vous souhaitez convertir (écrire en majuscules) : "
	 * ); deviseDest=sc.nextLine();
	 * System.out.println("Veuillez entrer une somme : ");
	 * sum=Float.parseFloat(sc.nextLine()); ConversionDevises.conversion(deviseSRC,
	 * deviseDest, sum);
	 * 
	 * 
	 * }
	 * 
	 */	public boolean verifValidity(String namedevise) {
		ArrayList<String> devises = new ArrayList<String>();
		devises.add("EUR");
		devises.add("AUD");
		devises.add("CAD");
		devises.add("CHF");
		devises.add("CNY");
		devises.add("GBP");
		devises.add("HKD");
		devises.add("INR");
		devises.add("JPY");
		devises.add("NZD");
		devises.add("SGD");
		devises.add("USD");
		devises.add("ZAR");
		devises.add("ARS");
		devises.add("BCH");
		devises.add("BRL");
		devises.add("CLP");
		devises.add("BTC");
		devises.add("CZK");
		devises.add("DKK");
		devises.add("DZD");
		devises.add("ETH");
		devises.add("KRW");
		devises.add("LTC");
		devises.add("MAD");
		devises.add("MYR");
		devises.add("NOK");
		devises.add("PHP");
		devises.add("PLN");
		devises.add("SEK");
		devises.add("THB");
		devises.add("TND");
		devises.add("TRY");
		devises.add("XAF");
		devises.add("XPF");
		for (int i = 0; i < devises.size(); i++) {
			if (namedevise.compareTo(devises.get(i)) == 0) {
				return true;

			}
		}
		return false;

	}

	public float conversion(String deviseSRC, String deviseDest, float sum) {
		String urlString = "http://www.convertisseur-euros.com/api.php?d1=" + deviseSRC + "&d2=" + deviseDest + "&x="
				+ sum + "&t=text";
		float valeurconvertie;
		if (verifValidity(deviseSRC) == false) {
			System.out.println("Erreur devise source incorrecte");
			return -1;
		}
		if (verifValidity(deviseDest) == false) {
			System.out.println("Erreur devise destinataire incorrecte");
			return -1;
		}
		try {
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "text/plain");
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
			}
			InputStreamReader in = new InputStreamReader(conn.getInputStream());
			BufferedReader br = new BufferedReader(in);
			String output;
			while ((output = br.readLine()) != null) {
				valeurconvertie = Float.parseFloat(output);
				System.out.println("Valeur convertie : " + valeurconvertie);
				return valeurconvertie;
			}
			conn.disconnect();

		} catch (Exception e) {
			System.out.println("Exception in NetClientGet:- " + e);
		}
		return sum;

	}

}
