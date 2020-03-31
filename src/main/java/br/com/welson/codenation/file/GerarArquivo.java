package br.com.welson.codenation.file;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

import br.com.welson.codenation.dado.DadosJson;

public class GerarArquivo {

	public void gravaArquivoJson(DadosJson dadosJson, String nomeArquivo ) {
		Gson gson = new Gson();
	    String json = gson.toJson(dadosJson);	
	    try {
	        FileWriter writer = new FileWriter(nomeArquivo);
	        writer.write(json);
	        writer.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
    }
}