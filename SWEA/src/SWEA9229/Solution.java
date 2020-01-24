package SWEA9229;
/**
문제

	한빈이는 퇴근길에 스팟마트에 들러 과자 두 봉지를 사서 양 손에 하나씩 들고 가려고 한다. 
	
	스팟마트에는 N개의 과자 봉지가 있으며, 각 과자 봉지는 ai그램의 무게를 가진다. 
	
	배가 많이 고픈 한빈이는 최대한 양이 많은 (무게가 많이 나가는) 과자 봉지를 고르고 싶으나, 
	
	과자 두 봉지의 무게가 M 그램을 초과하면 무거워서 과자를 들고 다닐 수 없다. 
	
	한빈이가 들고 다닐수 있는 과자들의 최대 무게 합을 출력하라. 한빈이는 과자를 “정확히” 두 봉지 사야 함에 유의하라

	
메모리
	49,052 KB
실행시간
	315 ms
	
적용 알고리즘
	완전 탐색


*/

import java.util.*;

class Solution {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int T;
		
		T=sc.nextInt();
		int N,M;
		int[] arr;
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int answer=-1;
			N=sc.nextInt();
			M=sc.nextInt();
			arr=new int[N];
			
			for(int i=0;i<N;i++) {
				arr[i]=sc.nextInt();
			}
			
			for(int i=0;i<N-1;i++) {
				if(answer==M) {
					break;
				}
				for(int j=i+1; j<N; j++) {
					if(arr[i]+arr[j]>answer&&arr[i]+arr[j]<=M) {
						answer=arr[i]+arr[j];
					}
				}
			}
			
			
			System.out.println("#"+test_case+" "+answer);
		}
	}

}









