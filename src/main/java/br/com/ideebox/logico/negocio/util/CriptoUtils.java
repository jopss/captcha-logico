package br.com.ideebox.logico.negocio.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.apache.log4j.Logger;

/**
 * Classe responsavel pela criptografia de strings.
 */
public final class CriptoUtils {
	
	private static Logger log = Logger.getLogger(CriptoUtils.class);

	public static String md5Encrypt(String texto) {
		String encripted = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(texto.getBytes());
			BigInteger hash = new BigInteger(1, md.digest());
			encripted = hash.toString(16);
		} catch (NoSuchAlgorithmException e) {
			log.error(e);
		}
		return encripted;
	}

	public static String desEncode(String texto, String chave) {
		Cipher ecipher;
		SecretKey key;
		String encod = null;
		try {
			key = new SecretKeySpec(chave.getBytes("UTF-8"), 0, 8, "DES");
			ecipher = Cipher.getInstance("DES");
			ecipher.init(Cipher.ENCRYPT_MODE, key);

			byte[] utf8 = texto.getBytes("UTF8");
			byte[] crip = ecipher.doFinal(utf8);
			encod = new String(Hex.encodeHex(crip));

		} catch (Exception e) {
			log.error(e);
		}

		return encod;
	}

	public static String desDecode(String texto, String chave) {
		Cipher dcipher;
		SecretKey key;
		String decod = null;

		try {
			key = new SecretKeySpec(chave.getBytes(), 0, 8, "DES");
			dcipher = Cipher.getInstance("DES");
			dcipher.init(Cipher.DECRYPT_MODE, key);
			byte[] dec = Hex.decodeHex(texto.toCharArray());
			byte[] utf8 = dcipher.doFinal(dec);
			decod = new String(utf8, "UTF8");
		} catch (Exception e) {
			log.error(e);
		}

		return decod;
	}

}