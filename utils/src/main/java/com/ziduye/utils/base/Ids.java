package com.ziduye.utils.base;

import java.security.SecureRandom;
import java.util.UUID;

import com.ziduye.utils.security.Encodes;


public class Ids {

	private static SecureRandom random = new SecureRandom();

	/**
	 * 封装JDK自带的UUID, 通过Random数字生成, 中间有-分割.
	 */
	public static String uuid() {
		return UUID.randomUUID().toString();
	}

	/**
	 * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
	 */
	public static String uuidShort() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	/**
	 * 使用SecureRandom随机生成Long.
	 */
	public static long randomLong() {
		return Math.abs(random.nextLong());
	}

	/**
	 * 基于Base62编码的SecureRandom随机生成bytes.
	 */
	public static String randomBase62(int length) {
		byte[] randomBytes = new byte[length];
		random.nextBytes(randomBytes);
		return Encodes.encodeBase62(randomBytes);
	}
	
	public static void main(String[] args) {
		System.out.println(uuid());
		System.out.println(uuidShort());
		System.out.println(randomLong());
		String rs = randomBase62(4);
		System.out.println(rs);
		
	}
	
}
