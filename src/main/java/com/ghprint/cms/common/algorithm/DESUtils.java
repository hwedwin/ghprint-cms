package com.ghprint.cms.common.algorithm;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
/**
 * @ClassName: DESUtils
 * @Description: 加密解密
 * @author 庞超
 * @date 2013-11-15 上午10:09:33
 * 
 */
@SuppressWarnings("restriction")
public class DESUtils {
	private static final Key key;
	private static final String KEY_STR = "myKey";
	private static final String DES_ALGORITHM = "DES";  
	static {
		try {

			key = generateKey(KEY_STR);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/** 
	* @Title: 加密解密算法
	* @Description: 对str进行DES加密
	* @param str
	* @return String
	* @throws 
	*/ 
	public static String getEncryptString(String str) {
		BASE64Encoder base64en = new BASE64Encoder();
		try {
			byte[] strBytes = str.getBytes("UTF8");
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] encryptStrBytes = cipher.doFinal(strBytes);
			return base64en.encode(encryptStrBytes);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public static void main(String[] args) {
		//System.out.println(getEncryptString("mepfts"));
		System.out.println(getEncryptString("bao19901015"));
		//String s ="sEH8vgU4IxM=";
		//System.out.println(getDecryptString(s));
		//System.out.println(getDecryptString("UFCLDsSmj+086/9heuVEYA=="));
	}

	/** 
	* @Title: 加密解密算法
	* @Description: 对str进行DES解密
	* @param str
	* @return String
	* @throws 
	*/ 
	public static String getDecryptString(String str) {
		BASE64Decoder base64De = new BASE64Decoder();
		try {
			byte[] strBytes = base64De.decodeBuffer(str);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] decryptStrBytes = cipher.doFinal(strBytes);
			return new String(decryptStrBytes, "UTF8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
	/** 
	 * 获得秘密密钥 
	 *  
	 * @param secretKey 
	 * @return 
	 * @throws java.security.NoSuchAlgorithmException
	 */  
	private static SecretKey generateKey(String secretKey) throws NoSuchAlgorithmException{  
	 
	    SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");  
	    secureRandom.setSeed(secretKey.getBytes());  
      
	    // 为我们选择的DES算法生成一个KeyGenerator对象   
	    KeyGenerator kg = null;  
	    try {  
	        kg = KeyGenerator.getInstance(DES_ALGORITHM);  
	    } catch (NoSuchAlgorithmException e) {  
	    }  
	    kg.init(secureRandom);
	      
	    // 生成密钥   
	    return kg.generateKey();  
	}  
}
