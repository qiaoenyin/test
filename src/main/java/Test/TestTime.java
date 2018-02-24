package main.java.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TestTime {
	
	public static void main(String[] args){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		String Nowdate = sdf.format(new Date());//获取当前时间
		String  validDate= "2018-01-03 23:59:59";   //到期时间
		try {
			if(sdf.parse(Nowdate).getTime() > sdf.parse(validDate).getTime()){
				System.out.println(1);

			}else if(sdf.parse(Nowdate).getTime() == sdf.parse(validDate).getTime()){
				System.out.println(2);
			 }else{
				 System.out.println(3);
			 }
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
