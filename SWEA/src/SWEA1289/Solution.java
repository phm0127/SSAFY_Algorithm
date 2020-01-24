package SWEA1289;
/**
문제
	원재가 컴퓨터를 만지다가 실수를 저지르고 말았다. 메모리가 초기화된 것이다.

	다행히 원래 메모리가 무슨 값이었는지 알고 있었던 원재는 바로 원래 값으로 되돌리려고 했으나 메모리 값을 바꿀 때 또 문제가 생겼다.

	메모리 bit중 하나를 골라 0인지 1인지 결정하면 해당 값이 메모리의 끝까지 덮어씌우는 것이다.

	예를 들어 지금 메모리 값이 0100이고, 3번째 bit를 골라 1로 설정하면 0111이 된다.

	원래 상태가 주어질 때 초기화 상태 (모든 bit가 0) 에서 원래 상태로 돌아가는데 최소 몇 번이나 고쳐야 하는지 계산해보자.
	
메모리
	20,304 KB
실행시간
	134 ms
	
적용 알고리즘
	완전 탐색



*/

import java.util.Scanner;


class Solution
{
	public static void main(String args[])
	{
		
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();;
		
		int answer;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			answer=0;
			String str;
			str = sc.next();
			String[] strA = new String[str.length()];
			strA=str.split("");
			int[] arr=new int[str.length()];
			for(int i=0;i<str.length();i++) {
				arr[i]=Integer.parseInt(strA[i]);
			}
			answer=go(arr,0);
			
			System.out.println("#"+test_case+" "+answer);

		} // end of for testCase
	} // end of main
	
	public static int go(int[] arr,int index) {
		
		if(index>=arr.length) {
			return 0;
		}
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=0) {
				for (int j = i; j < arr.length; j++) {
					arr[j]=1-arr[j];
				}
				return 1+go(arr,i+1);
			}
		}
		return 0;
	}
}
