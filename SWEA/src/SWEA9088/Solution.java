package SWEA9088;
/**
����
		�¿��̴� N���� ���̾Ƹ�带 ������ �ִ�. �� ���̾Ƹ�� ũ��� 1 �̻� 10000 ������ �ڿ����� ��Ÿ�� �� �ִ�.
	
	 
	
	�¿��̴� N���� ���̾Ƹ�� �� �� ���� ���, ���ο��� ������ �ַ��� �Ѵ�.
	
	 
	
	����, �¿��̴� �� ���̾Ƹ���� ũ�Ⱑ ���׹����̸� ������ �������� ���� ���̶�� �����Ͽ�, 
	
	�� ���̾Ƹ�� �� ũ�� ���� K ������ �͵��� �������� ���������� �Ѵ�. (��, ������ ���� ������ �� �ִ�.)
	
	 
	
	�¿��̰� ���ο��� ������ �� �ִ� ���̾Ƹ���� �ִ� ������ ���ΰ�?

	
�޸�
	30,388 KB
����ð�
	181 ms
	
���� �˰���
	���� Ž��



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










