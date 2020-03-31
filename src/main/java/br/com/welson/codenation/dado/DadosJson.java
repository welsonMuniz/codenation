package br.com.welson.codenation.dado;

import com.google.gson.JsonObject;

public class DadosJson {
	private Integer numero_casas;
	private String token;
	private String cifrado;
	private String decifrado;
	private String resumo_criptografico;

	public Integer getNumeroCasas() {
		return numero_casas;
	}
	public void setNumeroCasas(Integer numeroCasas) {
		this.numero_casas = numeroCasas;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getCifrado() {
		return cifrado;
	}
	public void setCifrado(String cifrado) {
		this.cifrado = cifrado;
	}
	public String getDecifrado() {
		return decifrado;
	}
	public void setDecifrado(String decifrado) {
		this.decifrado = decifrado;
	}
	public String getResumoCriptografico() {
		return resumo_criptografico;
	}
	public void setResumoCriptografico(String resumoCriptografico) {
		this.resumo_criptografico = resumoCriptografico;
	}

	public void populaJson(JsonObject jsonObject) {
		this.numero_casas = jsonObject.get("numero_casas").getAsInt();
		this.token = jsonObject.get("token").getAsString();
		this.cifrado = jsonObject.get("cifrado").getAsString();
		this.decifrado = jsonObject.get("decifrado").getAsString();
		this.resumo_criptografico = jsonObject.get("resumo_criptografico").getAsString();
	}

	public void decriptadorJulioCesar(int numeroCasas, String chave) {
		String valorDecriptogrado = "";
		chave = chave.toLowerCase();
		int tamanho = chave.length();
		for (int i = 0; i <= tamanho - 1; i++ ) {
			valorDecriptogrado = valorDecriptogrado + String.valueOf((valorDecriptado(numeroCasas, String.valueOf(chave.charAt(i)))));
		}
		this.decifrado = valorDecriptogrado;
	}

	public String valorDecriptado(int numeroCasas, String caractere) {
		String valoresPossiveis = "abcdefghijklmnopqrstuvwxyz";
		String valoresImutaveis = "1234567890.,;?!@#$%¨&*()-+=_ ";
		String valorCorrespondente;
		caractere = caractere.toLowerCase();
		int indice = 0;
		indice = valoresImutaveis.indexOf(caractere);
		if (indice < 0) {
			indice = valoresPossiveis.indexOf(caractere);
			if (indice - numeroCasas >= 0) {
				valorCorrespondente = String.valueOf(valoresPossiveis.charAt(indice - numeroCasas));
			}else {
				valorCorrespondente = String.valueOf(valoresPossiveis.charAt(indice - numeroCasas + 26));
			}
		} else {
			valorCorrespondente = caractere;
		}
		return valorCorrespondente;
	}
	@Override
	public String toString() {
		return "DadosJson [numeroCasas=" + numero_casas + ", token=" + token + ", cifrado=" + cifrado + ", decifrado="
				+ decifrado + ", resumoCriptografico=" + resumo_criptografico + "]";
	}
}