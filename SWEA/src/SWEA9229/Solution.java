package SWEA9229;
/**
����

	�Ѻ��̴� ��ٱ濡 ���̸�Ʈ�� �鷯 ���� �� ������ �缭 �� �տ� �ϳ��� ��� ������ �Ѵ�. 
	
	���̸�Ʈ���� N���� ���� ������ ������, �� ���� ������ ai�׷��� ���Ը� ������. 
	
	�谡 ���� ���� �Ѻ��̴� �ִ��� ���� ���� (���԰� ���� ������) ���� ������ ���� ������, 
	
	���� �� ������ ���԰� M �׷��� �ʰ��ϸ� ���ſ��� ���ڸ� ��� �ٴ� �� ����. 
	
	�Ѻ��̰� ��� �ٴҼ� �ִ� ���ڵ��� �ִ� ���� ���� ����϶�. �Ѻ��̴� ���ڸ� ����Ȯ���� �� ���� ��� �Կ� �����϶�

	
�޸�
	49,052 KB
����ð�
	315 ms
	
���� �˰���
	���� Ž��


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









