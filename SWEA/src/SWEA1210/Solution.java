package SWEA1210;
/**
문제
	https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14ABYKADACFAYh&categoryId=AV14ABYKADACFAYh&categoryType=CODE
	
메모리
	97,560 KB
실행시간
	306 ms
	
적용 알고리즘
	시뮬레이션



*/

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		int N=100;
		int answer=0;
		Scanner sc = new Scanner(System.in);
		
		for(int testcase=1;testcase<=10;testcase++) {
            int T=sc.nextInt();
			int[][] ladder= new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					ladder[i][j]=sc.nextInt();
				}
			}
			int index;
			for(index=0;index<N;index++) {
				if(ladder[N-1][index]==2) {
					break;
				}
			}
			
			answer=cal(ladder,index);
			
			System.out.println("#"+testcase+" "+answer);
			
		}

	}
	
	public static int cal(int[][] arr,int index) {
		int state=0;
		int ans;
		int r = arr.length-1;
		int c = index;
		while(true) {
			if(r==0) {
				break;
			}
			if((state==0||state==-1)&&hasLeft(arr,r,c)) {
				
					c-=1;
					state=-1;
				
			}
			else if((state==0||state==1)&&hasRight(arr,r,c)) {
					c+=1;
					state=1;
			}
			else {
				state=0;
				r--;
			}
			
		}
		return c;
	}
	
	public static boolean hasLeft(int[][] arr, int r,int c) {
		if(c<=0||arr[r][c-1]==0) {
			return false;
		}
		else {
			return true;
		}
	}
	public static boolean hasRight(int[][] arr, int r,int c) {
		if(c>=arr.length-1||arr[r][c+1]==0) {
			return false;
		}
		else {
			return true;
		}
	}
		

}

