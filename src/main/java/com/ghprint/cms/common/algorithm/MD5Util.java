package com.ghprint.cms.common.algorithm;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

	/** * * 16进制字符集 */
	private static final char HEX_DIGITS[] = { '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	/** * * 指定算法为MD5的MessageDigest */
	private static MessageDigest messageDigest = null;

	/** * 初始化messageDigest的加密算法为MD5 */
	static {
		try {
			messageDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	/**
	 * * 获取文件的MD5值
	 * 
	 * @param file
	 *            目标文件
	 * @return MD5字符串
	 */
	public static String getFileMD5String(File file) {
		String ret = "";
		FileInputStream in = null;
		FileChannel ch = null;
		try {
			in = new FileInputStream(file);
			ch = in.getChannel();
			ByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, 0,
					file.length());
			messageDigest.update(byteBuffer);
			ret = bytesToHex(messageDigest.digest());
		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (ch != null) {
				try {
					ch.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return ret;
	}
	/**
	 * * 获取文件的MD5值
	 * 
	 * @param file
	 *            目标文件
	 * @return MD5字符串
	 */
	public static String getFileMD5FromBytes(byte[] bytes) {
		String ret = "";
		try {
			messageDigest.update(bytes);
			ret = bytesToHex(messageDigest.digest());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
	/**
	 * 
	 * 方法的描述: 分段获取文件的MD5值
	 * @author: Administrator  
	 * @version: 2012-12-20 下午02:39:33
	 * @param file
	 * @param len 设定读取的字节数
	 * @return
	 * @return String
	 */
	public static String getFileMD5String(File file,int size) {
		if(size <= 0)
			getFileMD5String(file);
		
		byte[] buf = new byte[size]; // 这个byte[]的长度可以是任意的。
		boolean fileIsNull = true;
		FileInputStream fis = null;
		String md5 = "";
		try {
			fis = new FileInputStream(file);
			int len = 0;
			len = fis.read(buf);
			if (len > 0) {
				fileIsNull = false;
				while (len > 0) {
					messageDigest.update(buf, 0, len);
					md5 += "|" + bytesToHex(messageDigest.digest());
					len = fis.read(buf);
				}
			}
			if (!Charset.isEmpty(md5)) {
				md5 = md5.substring(1);
			}
		} catch (Exception e) {
			return md5;
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if (fileIsNull)
			return md5;
		else
			return md5;
	}
	/**
	 * 
	 * 方法的描述: 分段获取文件的MD5值
	 * @author: Administrator  
	 * @version: 2012-12-20 下午02:39:33
	 * @param file
	 * @param len 设定读取的字节数
	 * @return
	 * @return String
	 */
	public static String getMD5StringFromByte(byte[] bytes,int size) {
		
		byte[] buf = new byte[size]; // 这个byte[]的长度可以是任意的。
		boolean fileIsNull = true;
		ByteArrayInputStream fis = null;
		String md5 = "";
		try {
			fis =  new ByteArrayInputStream(bytes);
			int len = 0;
			len = fis.read(buf);
			if (len > 0) {
				fileIsNull = false;
				while (len > 0) {
					messageDigest.update(buf, 0, len);
					md5 += "|" + bytesToHex(messageDigest.digest());
					len = fis.read(buf);
				}
			}
			if (!Charset.isEmpty(md5)) {
				md5 = md5.substring(1);
			}
		} catch (Exception e) {
			return md5;
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if (fileIsNull)
			return md5;
		else
			return md5;
	}

	/**
	 * * 获取文件的MD5值
	 * 
	 * @param fileName
	 *            目标文件的完整名称
	 * 
	 * @return MD5字符串
	 */
	public static String getFileMD5String(String fileName) {
		return getFileMD5String(new File(fileName));
	}

	/**
	 * * MD5加密字符串
	 * 
	 * @param str
	 *            目标字符串
	 * 
	 * @return MD5加密后的字符串
	 */

	public static String getMD5String(String str) {

		return getMD5String(str.getBytes());
	}

	/**
	 * * MD5加密以byte数组表示的字符串
	 * 
	 * @param bytes
	 *            目标byte数组
	 * 
	 * @return MD5加密后的字符串
	 */

	public static String getMD5String(byte[] bytes) {
		messageDigest.update(bytes);
		return bytesToHex(messageDigest.digest());
	}

	/**
	 * * 校验密码与其MD5是否一致
	 * 
	 * @param pwd
	 *            密码字符串
	 * 
	 * @param md5
	 *            基准MD5值
	 * 
	 * @return 检验结果
	 */
	public static boolean checkPassword(String pwd, String md5) {
		return getMD5String(pwd).equalsIgnoreCase(md5);
	}

	/**
	 * * 校验密码与其MD5是否一致
	 * 
	 * @param pwd
	 *            以字符数组表示的密码
	 * 
	 * @param md5
	 *            基准MD5值
	 * 
	 * @return 检验结果
	 */
	public static boolean checkPassword(char[] pwd, String md5) {
		return checkPassword(new String(pwd), md5);

	}

	/**
	 * * 检验文件的MD5值
	 * 
	 * @param file
	 *            目标文件
	 * 
	 * @param md5
	 *            基准MD5值
	 * 
	 * @return 检验结果
	 */
	public static boolean checkFileMD5(File file, String md5) {
		return getFileMD5String(file).equalsIgnoreCase(md5);

	}

	/**
	 * * 检验文件的MD5值
	 * 
	 * @param fileName
	 *            目标文件的完整名称
	 * 
	 * @param md5
	 *            基准MD5值
	 * 
	 * @return 检验结果
	 */
	public static boolean checkFileMD5(String fileName, String md5) {
		return checkFileMD5(new File(fileName), md5);

	}

	/**
	 * * 将字节数组转换成16进制字符串
	 * 
	 * @param bytes
	 *            目标字节数组
	 * 
	 * @return 转换结果
	 */
	public static String bytesToHex(byte bytes[]) {
		return bytesToHex(bytes, 0, bytes.length);

	}

	/**
	 * * 将字节数组中指定区间的子数组转换成16进制字符串
	 * 
	 * @param bytes
	 *            目标字节数组
	 * 
	 * @param start
	 *            起始位置（包括该位置）
	 * 
	 * @param end
	 *            结束位置（不包括该位置）
	 * 
	 * @return 转换结果
	 */
	public static String bytesToHex(byte bytes[], int start, int end) {
		StringBuilder sb = new StringBuilder();
		for (int i = start; i < start + end; i++) {
			sb.append(byteToHex(bytes[i]));
		}
		return sb.toString();

	}

	/**
	 * * 将单个字节码转换成16进制字符串
	 * 
	 * @param bt
	 *            目标字节
	 * 
	 * @return 转换结果
	 */
	public static String byteToHex(byte bt) {
		return HEX_DIGITS[(bt & 0xf0) >> 4] + "" + HEX_DIGITS[bt & 0xf];

	}

	public static void main(String[] args) throws IOException {
		long begin = System.currentTimeMillis();
		String md5 = getFileMD5String(new File("d:/Bestpay_V2.6.0_20140321_1_A_common_debug.apk"),1024*500);

		System.out.println(md5);

	}
}
