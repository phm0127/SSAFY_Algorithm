package SWEA1204;
/**
����
	��� ����б����� �ǽ��� 1000���� ���� ������ ���� ��� �ڷḦ ������� �Ѵ�.

	�̶�, �� �б������� �ֺ���� �̿��Ͽ� �л����� ��� ������ �����ϴµ�, ���⼭ �ֺ���� Ư�� �ڷῡ�� ���� ���� �� ��Ÿ���� ���� �ǹ��Ѵ�.
	
	������ ���� �� ������ ������,
	
	10, 8, 7, 2, 2, 4, 8, 8, 8, 9, 5, 5, 3
	
	�ֺ���� 8�� �ȴ�.
	
	�ֺ���� ����ϴ� ���α׷��� �ۼ��Ͽ��� (��, �ֺ���� ���� �� �� ������ ���� ū ������ ����϶�).

�޸�
	34,068 KB
����ð�
	187 ms
	
���� �˰���
	���� Ž��



*/

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;


class Solution
{
	static int answer;
	static int[] memory;

	public static void main(String args[])
	{

		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		HashMap<Integer, Integer> hash;
		int[] arr;
		int max=0;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			answer=0;
			max=0;
			int t= sc.nextInt();
			
			hash = new HashMap<Integer, Integer>();
			
			arr = new int[1000];


			for(int i=0;i<1000;i++) {
				arr[i]=sc.nextInt();
				hash.put(arr[i], hash.getOrDefault(arr[i], 0)+1);
			}
			
			Set<Integer> key = hash.keySet();
			for(int i:key) {
				//System.out.println(i+" : "+hash.get(i));
				if(hash.get(i)>=max) {
					if(i>answer) {
						max=hash.get(i);
						answer=i;
					}

				}
			}



			System.out.println("#"+test_case+" "+answer);

		} // end of for testCase
	} // end of main




}
