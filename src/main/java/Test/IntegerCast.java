package main.java.Test;

/**
 * 十进制转成十六进制：
Integer.toHexString(int i)
十进制转成八进制
Integer.toOctalString(int i)
十进制转成二进制
Integer.toBinaryString(int i)
十六进制转成十进制
Integer.valueOf("FFFF",16).toString()
八进制转成十进制
Integer.valueOf("876",8).toString()
二进制转十进制
Integer.valueOf("0101",2).toString() 
 * @ClassName: IntegerCast 
 * @author qiaoenyin
 * @date 2017年11月10日 下午3:19:50
 */
public class IntegerCast {
	public static void main(String args[]){
		int i =12;
		StringBuffer a = cast(i);
		System.out.println("a的值是："+a);
	}
	
	private static StringBuffer cast(int i) {
		StringBuffer a = new StringBuffer();
		//十进制转成十六进制：
		a.append(Integer.toHexString(i));
		a.append("=====");
		//十进制转成八进制
		a.append(Integer.toOctalString(i));
		a.append("=====");
		//十进制转成二进制
		a.append(Integer.toBinaryString(i));
		a.append("=====");
		//十六进制转成十进制
		a.append(Integer.valueOf("FFFF",16).toString());
		a.append("=====");
		//八进制转成十进制
		a.append(Integer.valueOf("776",8).toString());
		a.append("=====");
		//二进制转十进制
		a.append(Integer.valueOf("0101",2).toString());
		a.append("=====");
		return a;
	}

	
}
