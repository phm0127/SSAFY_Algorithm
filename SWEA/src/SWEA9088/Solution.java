package SWEA9088;
/**
문제
		태영이는 N개의 다이아몬드를 가지고 있다. 각 다이아몬드 크기는 1 이상 10000 이하의 자연수로 나타낼 수 있다.
	
	 
	
	태영이는 N개의 다이아몬드 중 몇 개를 골라, 애인에게 선물로 주려고 한다.
	
	 
	
	한편, 태영이는 고른 다이아몬드의 크기가 뒤죽박죽이면 애인이 좋아하지 않을 것이라고 생각하여, 
	
	고른 다이아몬드 중 크기 차가 K 이하인 것들을 묶음으로 가져가려고 한다. (단, 묶음은 여러 묶음일 수 있다.)
	
	 
	
	태영이가 애인에게 선물할 수 있는 다이아몬드의 최대 개수는 얼마인가?

	
메모리
	30,388 KB
실행시간
	181 ms
	
적용 알고리즘
	완전 탐색



*/

import java.util.*;

class Solution {

	static int answer;
	


	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int T;
		answer=0;

		T=sc.nextInt();
		int[] dia;
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			answer=0;
			int N,K;
			N=sc.nextInt();
			K=sc.nextInt();
			dia=new int[N];
			for(int i=0;i<N;i++) {
				dia[i]=sc.nextInt();
			}
			int count;
			for(int i=0;i<N;i++) {
				count=0;
				for(int j=0;j<N;j++) {
					if(dia[i]-dia[j]<=K&&dia[i]>=dia[j]) {
						count++;
					}
				}
				answer=Math.max(count, answer);
			}
			

			System.out.println("#"+test_case+" "+answer);


		}
	}
	
	

}










