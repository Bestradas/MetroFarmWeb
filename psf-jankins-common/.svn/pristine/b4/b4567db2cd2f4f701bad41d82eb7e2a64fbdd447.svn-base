package co.jankins.psf.common.serializable;

import java.security.MessageDigest;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import co.jankins.psf.common.exception.JankinsMarshallException;

/**
 * 
 * @author Bestrada
 *
 */
public class Serializable {
	
    private final static String secretKey= "JankerEncrypt0529";//llave para encriptar datos
    
    /**
     * Encripta el text recibido con una llave secreta
     * @param texto  --Cadena sin encriptar
     * @return cadena encriptada
     */
    public static String Encriptar(String texto) {
        
      
       String base64EncryptedString = "";

       try {

           
           
           
           MessageDigest md = MessageDigest.getInstance("SHA-256");
           byte[] digestOfPassword = md.digest(secretKey.getBytes("UTF-8"));
           byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);

           SecretKey key = new SecretKeySpec(keyBytes, "DESede");
           Cipher cipher = Cipher.getInstance("DESede");
           cipher.init(Cipher.ENCRYPT_MODE, key);

           byte[] plainTextBytes = texto.getBytes("UTF-8");
           byte[] buf = cipher.doFinal(plainTextBytes);
           byte[] base64Bytes = Base64.encodeBase64URLSafe(buf);
           base64EncryptedString = new String(base64Bytes,"UTF-8");

       } catch (Exception ex) {
       }
       return base64EncryptedString;
   }

    /**
     * Texto a desencriptar
     * @param textoEncriptado -- Recibe texto a encriptar.
     * @return String con cadena desencriptada
     * @throws Exception
     */
   public static String Desencriptar(String textoEncriptado) throws Exception {

      
       String base64EncryptedString = "";

       try {
           byte[] message = Base64.decodeBase64(textoEncriptado.getBytes("UTF-8"));
           MessageDigest md = MessageDigest.getInstance("SHA-256");
           byte[] digestOfPassword = md.digest(secretKey.getBytes("UTF-8"));
           byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
           SecretKey key = new SecretKeySpec(keyBytes, "DESede");

           Cipher decipher = Cipher.getInstance("DESede");
           decipher.init(Cipher.DECRYPT_MODE, key);

           byte[] plainText = decipher.doFinal(message);

           base64EncryptedString = new String(plainText, "UTF-8");

       } catch (Exception ex) {
    	   ex.printStackTrace();
       }
       return base64EncryptedString;
   }
   
  
}
