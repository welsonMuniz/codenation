package br.com.welson.codenation.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class RequestGet {

	public String getJson(String url) throws IOException  {

		HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
		String dadosJson = new String();

        try {
			conn.setRequestMethod("GET");
	        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String line;
            try {
				while ((line = br.readLine()) != null) {
				    dadosJson = line;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
            conn.disconnect();
		} catch (ProtocolException e) {
			e.printStackTrace();
		}
        return dadosJson;
	}
}