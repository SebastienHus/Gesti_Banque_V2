<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">
<title>ConversionDevises1</title>

</head>


<body>

	<h1>Conversion de devises</h1>
	<!-- mapping via les servlets -->
	<!-- 		<form action="conversion" method="post">  -->
	<form action="conversionOutput.jsp" method="post">
		<table style="">

			<tr>
				<td>Veuillez entrer le code de la devise que vous souhaitez
					convertir (liste ci-dessous) :</td>
				<td><input type="text" name="deviseSRC" /></td>
			</tr>

			<tr>
				<td>Veuillez entrer le code de la devise dans laquelle vous
					souhaitez convertir (liste ci-dessous) :</td>
				<td><input type="text" name="deviseDest" /></td>
			</tr>

			<tr>
				<td>Veuillez entrer une somme :</td>
				<td><input type="text" name="sum" /></td>
			</tr>

		</table>

		<input type="submit" value="Cliquez">

	</form>

	<p>Liste des devises convertibles et de leurs codes ISO-4217 (leurs
		abréviations) :</p>

	<select>

		<option>Baht thaïlandais (THB)</option>
		<option>Bitcoin (BTC)</option>
		<option>Bitcoin Cash (BCH)</option>
		<option>Couronne danoise (DKK)</option>
		<option>Couronne norvégienne (NOK)</option>
		<option>Couronne suédoise (SEK)</option>
		<option>Couronne tchèque (CZK)</option>
		<option>Dinar algérien (DZD)</option>
		<option>Dinar tunisien (TND)</option>
		<option>Dirham marocain (MAD)</option>
		<option>Dollar américain (USD)</option>
		<option>Dollar australien (AUD)</option>
		<option>Dollar canadien (CAD)</option>
		<option>Dollar de Hong-Kong (HKD)</option>
		<option>Dollar de Singapour (SGD)</option>
		<option>Dollar néo-zélandais (NZD)</option>
		<option>Ethereum (ETH)</option>
		<option>Euro (EUR)</option>
		<option>Franc CFA (XAF)</option>
		<option>Franc pacifique (XPF)</option>
		<option>Franc suisse (CHF)</option>
		<option>litecoin(LTC)</option>
		<option>Livre sterling (GBP)</option>
		<option>Livre turque (TRY)</option>
		<option>Peso argentin (ARS)</option>
		<option>Peso chilien (CLP)</option>
		<option>Peso philippin (PHP)</option>
		<option>Réal brésilien (BRL)</option>
		<option>Rand sud-africain (ZAR)</option>
		<option>Ringgit malaisien (MYR)</option>
		<option>Roupie indienne (INR)</option>
		<option>Won sud-coréen (KRW)</option>
		<option>Yen (JPY)</option>
		<option>Yuan (CNY)</option>
		<option>Zloty polonais (PLN)</option>

	</select>

</body>

</html>