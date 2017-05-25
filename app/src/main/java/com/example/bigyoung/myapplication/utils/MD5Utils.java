package com.example.bigyoung.myapplication.utils;

import android.text.TextUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {

	/**
	 * 获取文件的md5指纹
	 * 
	 * @param file
	 * @return
	 */
	public static String md5(File file) {

		FileInputStream in = null;
		// MD5
		try {
			in = new FileInputStream(file);
			MessageDigest digester = MessageDigest.getInstance("MD5");
			byte[] bytes = new byte[8192];
			int byteCount;
			while ((byteCount = in.read(bytes)) > 0) {
				digester.update(bytes, 0, byteCount);
			}
			// 文件指纹
			byte[] digest = digester.digest();

			// 转换byte --》String
			StringBuilder builder = new StringBuilder();

			for (byte b : digest) {
				int c = b & 0xff;// 16进制的数据
				// 0,1,2....9,A,B,C,D,E,F
				String str = Integer.toHexString(c);
				if (str.length() == 1) {
					str = 0 + str;
				}
				builder.append(str);
			}

			return builder.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			StreamUtils.closeIO(in);
		}
		return null;
	}

	public static String md5(String string) {
		if (TextUtils.isEmpty(string)) {
			return "";
		}
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
			byte[] bytes = md5.digest(string.getBytes());
			String result = "";
			for (byte b : bytes) {
				String temp = Integer.toHexString(b & 0xff);
				if (temp.length() == 1) {
					temp = "0" + temp;
				}
				result += temp;
			}
			return result;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}
	public static String md5(InputStream in) {

		// MD5
		try {
			MessageDigest digester = MessageDigest.getInstance("MD5");
			byte[] bytes = new byte[8192];
			int byteCount;
			while ((byteCount = in.read(bytes)) > 0) {
				digester.update(bytes, 0, byteCount);
			}
			// 文件指纹
			byte[] digest = digester.digest();

			// 转换byte --》String
			StringBuilder builder = new StringBuilder();

			for (byte b : digest) {
				int c = b & 0xff;// 16进制的数据
				// 0,1,2....9,A,B,C,D,E,F
				String str = Integer.toHexString(c);
				if (str.length() == 1) {
					str = 0 + str;
				}
				builder.append(str);
			}

			return builder.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			StreamUtils.closeIO(in);
		}
		return null;
	}
}
