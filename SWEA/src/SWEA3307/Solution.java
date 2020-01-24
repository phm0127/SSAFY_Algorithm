package SWEA3307;
/**
����
	�־��� �� ������ ���� ���� �κ� ����(Longest Increasing Subsequence)�� ���̸� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
	
	���� { A1, A2, ... , AN }�� ���� ���� �κ� ���� B�� ������ ���� ���ǵȴ�.
	
	 { B1, B2, ... , BK }���� 0��K��N, B1 �� B2 �� ... �� BK�̰�,
	
	AB1 �� AB2 �� ... �� ABK�� �ִ� K�� ������ �����̴�.
	
	���� ���, ������ { 1, 3, 2, 5, 4, 7 } �̶��, ���� �κ� ���� ������ ���̴� 4�� �ȴ�.
	
�޸�
	32,576 KB
����ð�
	176 ms
	
���� �˰���
	���� ���α׷���(DP) - Memoization



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
