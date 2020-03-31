package br.com.welson.codenation.teste;

import java.io.File;
import java.io.IOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import br.com.welson.codenation.client.RequestGet;
import br.com.welson.codenation.client.RequestPost;
import br.com.welson.codenation.criptografia.Criptografa;
import br.com.welson.codenation.dado.DadosJson;
import br.com.welson.codenation.file.GerarArquivo;

public class Teste {

	public static void main(String[] args) {

	final String TOKEN = "814858516cd676572b4d77dfea079ef8111e6098";
	final String URL_GET = "https://api.codenation.dev/v1/challenge/dev-ps/generate-data?token=" + TOKEN;
	final String URL_POST = "https://api.codenation.dev/v1/challenge/dev-ps/submit-solution?token=" + TOKEN;
	final String ANSWER = "/answer.json";

	String caminhoArq = null;
	RequestGet get = new RequestGet();
	GerarArquivo arquivo = new GerarArquivo();
	DadosJson json = new DadosJson();
	Criptografa criptografa = new Criptografa();
	RequestPost post = new RequestPost();

	try {
		caminhoArq = new File("../codenation/files").getCanonicalPath() + ANSWER;
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			JsonObject jsonObject = (JsonObject) new JsonParser().parse(get.getJson(URL_GET));
			json.populaJson(jsonObject);
			json.decriptadorJulioCesar(json.getNumeroCasas(), json.getCifrado());
			json.setResumoCriptografico(criptografa.criptografiaSha1(json.getDecifrado()));
			arquivo.gravaArquivoJson(json, caminhoArq);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			post.postJson(URL_POST, caminhoArq);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}