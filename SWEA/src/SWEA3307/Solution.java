package SWEA3307;
/**
문제
	주어진 두 수열의 최장 증가 부분 수열(Longest Increasing Subsequence)의 길이를 계산하는 프로그램을 작성하시오.
	
	수열 { A1, A2, ... , AN }의 최장 증가 부분 수열 B는 다음과 같이 정의된다.
	
	 { B1, B2, ... , BK }에서 0≤K≤N, B1 ≤ B2 ≤ ... ≤ BK이고,
	
	AB1 ≤ AB2 ≤ ... ≤ ABK인 최대 K로 구성된 수열이다.
	
	예를 들어, 수열이 { 1, 3, 2, 5, 4, 7 } 이라면, 최장 부분 증가 수열의 길이는 4가 된다.
	
메모리
	32,576 KB
실행시간
	176 ms
	
적용 알고리즘
	동적 프로그래밍(DP) - Memoization



*/

import java.util.Scanner;

class Solution
{
	static int answer;
	static int[] memory;

	public static void main(String args[])
	{

		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		int N;
		int[] arr;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			answer=0;
			N=sc.nextInt();
			arr = new int[N];
			memory= new int[N];
			for(int i=0;i<N;i++) {
				arr[i]=sc.nextInt();
                memory[i]=1;
			}
			for(int i=N-1;i>=0;i--) {
				cal(arr,i);
			}
			
			for(int i=0;i<N;i++) {
				answer=Math.max(memory[i], answer);
			}
			
			

			System.out.println("#"+test_case+" "+answer);

		} // end of for testCase
	} // end of main

	public static void cal(int[] arr, int pos) {
		
		if(pos==arr.length-1) {
			memory[pos]=1;
		}
		else {
			for(int i=pos+1;i<arr.length;i++) {
				if(arr[pos]<=arr[i]) {
					if(memory[i]==0) {
						cal(arr,i);
					}
					memory[pos]=Math.max(memory[i]+1, memory[pos]);
				}
			}
			
		}
	}
	

}
