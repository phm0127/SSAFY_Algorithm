package SWEA8658;
/**
����

	�Ǽ��̴� ���� ��� ���� ��Ƽ�� ���� ���ؼ� ���ڸ� �緯 �Դ�.
	
	������ ���� ���� ���� �����̴� ���ڸ� ������ �Ǹ����� �ʴ� ����̴�.
	
	�� ���� ���� ���� ���� �� �����ϴ� �̻��� �����̴� ���ڸ� �緯 �� �Ǽ��̿��� 3���� �÷��� �ο��߰�, ��� ����ؾ߸� �ŷ��� �����Ѵ�.
	
	ù ��° ���������� 10���� �ڿ����� �־�����.
	
	�� ������ �� ���� �� �ڸ� ���� �� ���� ���� ����ؾ� �Ѵ�.
	
	���� �� �־��� �� �߿� 1203�� �ִٸ� �� ���� �� �ڸ� ���� ��� ���ϸ� 1 + 2 + 0 + 3 = 6�� �ȴ�.
	
	�Ǽ��̴� �����̿��� ���� 10���� ���ڵ� ��, ���� ���� ��ȯ���� ���� �ִ�, �ּҰ��� ����ؾ߸� �Ѵ�.
	
	�Ǽ��̸� ���ͼ� ���� 1�� ������ ���ϴ� ���α׷��� �ۼ��϶�.
	
�޸�
	20,308 KB
����ð�
	140 ms
	
���� �˰���
	���� Ž��



*/
import java.util.Scanner;

class Solution
{
	static int max;
	static int min;

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int T= scan.nextInt();
		int[] arr = new int[10];
		
		
		for(int i=0;i<T;i++) {
			min=987654321;
			max=0;
			for(int j=0;j<10;j++) {
				arr[j]= scan.nextInt();
			}
			
			cal(arr);
			System.out.println("#"+(i+1)+" "+max+" "+min);
		}
		
		
	}
	
	public static void cal(int[] arr){
		int sum;
		for(int i=0;i<10;i++) {
			sum=0;
			while(true) {
				sum+=arr[i]%10;
				if(arr[i]<10) {
					break;
				}
				arr[i]/=10;
			}
			max=Math.max(max, sum);
			min=Math.min(min, sum);
		}
	}
}