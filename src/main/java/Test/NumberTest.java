package main.java.Test;

import java.util.UUID;

public class NumberTest {
	public static String generateShortUuid() {
	    StringBuffer shortBuffer = new StringBuffer();
	    String uuid = UUID.randomUUID().toString().replace("-", "");
	    System.out.println("uuid:"+uuid);
	    for (int i = 0; i < 8; i++) {
	        String str = uuid.substring(i * 4, i * 4 + 4);
	        //Integer.parseInt(String s,int radix)返回的结果是一个十进制数.我们是要得到s的十进制数，而radix是表示s当前是多少进制的数
	        int x = Integer.parseInt(str, 16);//输入16进制str在10进制下的数，就是把16进制的str转化为10进制的数
	        System.out.println("str:"+str+"=========="+"x:"+x);
	        System.out.println("i:"+i+"================"+0x3E);
	        shortBuffer.append(x % 0x3E);//0x表示
	    }
	    return shortBuffer.toString();

	}
	
	public static void main(String args[]){
		String number = generateShortUuid();
		System.out.println("number:"+number);
	}
}
