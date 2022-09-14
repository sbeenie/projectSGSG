package com.ici.projectSGSG.dao;

public class dogAgeCalculator {

	public static int calculator(int age,int size) {
		int rs = cal(age,size);
		return rs;
	}
	
	
	public static int claculator(String sage, String ssize) {
		int age= Integer.parseInt(sage);
		int size= Integer.parseInt(ssize); 
		int rs = cal(age,size);
		return rs;
	}
	
	public static int claculator(int age, String ssize) { 
		int size= Integer.parseInt(ssize); 
		int rs = cal(age,size);
		return rs;
	}
	
	public static int claculator(String sage, int size) {
		int age= Integer.parseInt(sage); 
		int rs = cal(age,size);
		return rs;
	}

	//1살미만일때 아기 1 태그번호 =6
	//1~10까지 일반 2 태그번호 =7
	//10~부터 노년 3 태그번호 =8
	private static int cal(int age,int size) { 
		if(1<age) {
			int c = age+size-1;
			if(8<c) {
				return 9;
			}else if (5<c) {
				return 8;
			}else {
				return 7;
			}
		} else {
			return 6;
		}
	}
	
	
	
	
	
}
