package SWEA1289;
/**
����
	���簡 ��ǻ�͸� �����ٰ� �Ǽ��� �������� ���Ҵ�. �޸𸮰� �ʱ�ȭ�� ���̴�.

	������ ���� �޸𸮰� ���� ���̾����� �˰� �־��� ����� �ٷ� ���� ������ �ǵ������� ������ �޸� ���� �ٲ� �� �� ������ �����.

	�޸� bit�� �ϳ��� ��� 0���� 1���� �����ϸ� �ش� ���� �޸��� ������ ������ ���̴�.

	���� ��� ���� �޸� ���� 0100�̰�, 3��° bit�� ��� 1�� �����ϸ� 0111�� �ȴ�.

	���� ���°� �־��� �� �ʱ�ȭ ���� (��� bit�� 0) ���� ���� ���·� ���ư��µ� �ּ� �� ���̳� ���ľ� �ϴ��� ����غ���.
	
�޸�
	20,304 KB
����ð�
	134 ms
	
���� �˰���
	���� Ž��



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
