package com.ziduye.utils.base;

import java.util.Date;
import java.util.Iterator;

/**
 * 生成随即数
 * </p>
 * <p>
 * "线性同余法" 参考
 * http://books.google.com.hk/books?id=Niw0OodQL8oC&pg=PA16&lpg=PA16&dq=2053+13849&source=bl&ots=D946uJegqV&sig=QHCuSmGU2ywWE288Fv0cc7ucUHY&hl=zh-CN&ei=J9lATpmrHobRiAK-383EBQ&sa=X&oi=book_result&ct=result&resnum=6&ved=0CDsQ6AEwBQ#v=onepage&q=2053%2013849&f=false
 * </p>
 * 
 * @author ziduye(a)gmail.com
 * @date Aug 26, 2011
 */
public class Random implements Iterator<Long> {
	protected static long limit = 65536;
	protected static long unit = 2053;
	protected static long offset = 13849;

	private long seed;

	public Random() {
		this(10);
	}

	public Random(long seed) {
		this.seed = seed % limit;
	}

	@Override
	public boolean hasNext() {
		return true;
	}

	@Override
	public Long next() {
		return seed = (seed * unit + offset) % limit;
	}

	@Override
	public void remove() {
		next();
	}

	public static void main(String[] args) {
		Random rnd = new Random(new Date().getTime());
		for (int i = 0; i < 10; i++) {
			System.out.println(rnd.next());
		}
	}
}
