package SWEA4112;
/**
문제
	https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWJHmLraeEwDFAUH
	
메모리
	27,748 KB
실행시간
	200 ms
	
적용 알고리즘
	그리디 알고리즘



*/

import java.util.*;

class Solution {

	static HashMap<Integer,Point> hash;
	static int answer=987654321;


	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int T;
		hash = new HashMap<Integer,Point>();
		Point point;
		int x;
		for(int i=1;i<=10000;i++) {
			for(int j=1;j<150;j++) {

				if(i>=1+(j*(j-1)/2)&&i<=j*(j+1)/2) {
					x=i-(1+(j*(j-1)/2));
					point = new Point(x,j);
					hash.put(i, point);
					break;
				}
			}
		}
		T=sc.nextInt();
		int a,b;


		for(int test_case = 1; test_case <= T; test_case++)
		{
			a=sc.nextInt();
			b=sc.nextInt();
			if(a>b) {
				answer= cal(b,a);
			}
			else {
				answer=cal(a,b);
			}
			
			System.out.println("#"+test_case+" "+answer);
		}
	}

	static int cal(int pos, int treasure) {

		Point A,B;
		int dist,diff;
		
		A=hash.get(pos);
		B=hash.get(treasure);
		dist=B.getY()-A.getY();
		diff=A.getX()-B.getX();
		if(diff>0) {
			dist+=diff;
		}
		else if(diff<0) {
			diff=-diff;
			if(dist<diff) {
				dist+=diff-dist;
			}
		}
		else {
			return dist;
		}
		
		return dist;
	}
	

}

class Point {
	int x;
	int y;
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
}








