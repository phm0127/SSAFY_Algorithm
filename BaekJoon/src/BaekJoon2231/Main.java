package BaekJoon2231;

/**
����
	� �ڿ��� N�� ���� ��, �� �ڿ��� N�� �������� N�� N�� �̷�� �� �ڸ����� ���� �ǹ��Ѵ�. � �ڿ��� M�� �������� N�� ���, M�� N�� �����ڶ� �Ѵ�. ���� ���, 245�� �������� 256(=245+2+4+5)�� �ȴ�. ���� 245�� 256�� �����ڰ� �ȴ�. ����, � �ڿ����� ��쿡�� �����ڰ� ���� ���� �ִ�. �ݴ��, �����ڰ� ���� ���� �ڿ����� ���� �� �ִ�.

	�ڿ��� N�� �־����� ��, N�� ���� ���� �����ڸ� ���س��� ���α׷��� �ۼ��Ͻÿ�.
	
�޸�
	14260KB
����ð�
	120ms
	
���� �˰���
	���� Ž��
	
 */

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int findNum=0;
		int calNum;
		int present=0;
		int answer=0;
		while(true) {
			if(findNum==N) {
				break;
			}
			calNum=findNum;
			present=0;
			while(calNum!=0) {
				present+=calNum%10;
				calNum=calNum/10;
			}
			present+=calNum%10;
			if(present+findNum==N) {
				answer=findNum;
				break;
			}
			findNum++;
		}
		System.out.println(answer);
	}
	
	

}
