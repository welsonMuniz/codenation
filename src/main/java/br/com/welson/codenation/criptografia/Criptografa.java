package br.com.welson.codenation.criptografia;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Criptografa {

	public String criptografiaSha1(String string) {
		String sha1 = "";
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
	        digest.reset();
	        digest.update(string.getBytes("utf8"));
	        sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
		} catch (Exception e){
			e.printStackTrace();
		}
		return sha1;
     }
}