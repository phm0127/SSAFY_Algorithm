package SWEA8741;
/**
����

	�̹� ���� �ް��� �Ͽ��̸� �� ������ ����̴� ���� ���� �ܾ �ܿ��.
	
	�ȶ��� ����̴� ������ �ܿ� �ܾ�� �ܾ��� �ձ��ڸ� ���� �ٽ� ����س� �� �ִ�.
	
	����̴� �ڽ��� �ܿ� ���� �ܾ ����� ���� ����ؼ� �ܾ��� �ձ��ڸ� ���� �빮�ڷ� ���� �������� �Ѵ�.
	
	����̸� ���� �� �ܾ��� �ձ��ڸ� ���ͼ� �빮�ڷ� �ٲٴ� ���α׷��� �ۼ��غ���.
	
	���� ��� ��knuth morris pratt���� ��KMP���� �ٲ��.
		
�޸�
	21,864 KB
����ð�
	155 ms
	
���� �˰���
	����.
	�̷� ���� ������ String ���ٴ� StringBuilder�� StringBuffer�� ����ϴ� ���� ����.



*/

import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner scan = new Scanner(System.in);
		
		int T= scan.nextInt();
		String str;
		StringBuilder sb;
		String answer="";
		String[] ans = new String[T];
		
		for(int i=0;i<T;i++) {
			answer="";
			str=scan.next();
			sb= new StringBuilder(str);
			answer+=sb.charAt(0);
			str=scan.next();
			sb= new StringBuilder(str);
			answer+=sb.charAt(0);
			str=scan.next();
			sb= new StringBuilder(str);
			answer+=sb.charAt(0);
			
			answer=answer.toUpperCase();
			ans[i]=answer;
			
		}
		for (int i=0;i<T;i++) {
			System.out.println("#"+(i+1)+" "+ans[i]);
		}

		
	}
}
