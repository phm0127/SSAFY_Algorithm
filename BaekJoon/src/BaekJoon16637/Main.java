package BaekJoon16637;
/**
����
	���̰� N�� ������ �ִ�. ������ 0���� ũ�ų� ����, 9���� �۰ų� ���� ������ ������(+, -, ��)�� �̷���� �ִ�. ������ �켱������ ��� �����ϱ� ������, ������ ����� ���� ���ʿ������� ������� ����ؾ� �Ѵ�. ���� ���, 3+8��7-9��2�� ����� 136�̴�.

	���Ŀ� ��ȣ�� �߰��ϸ�, ��ȣ �ȿ� ����ִ� ���� ���� ����ؾ� �Ѵ�. ��, ��ȣ �ȿ��� �����ڰ� �ϳ��� ��� �־�� �Ѵ�. ���� ���, 3+8��7-9��2�� ��ȣ�� 3+(8��7)-(9��2)�� ���� �߰�������, ���� ����� 41�� �ȴ�. ������, ��ø�� ��ȣ�� ����� �� ����.
	
	 ��, 3+((8��7)-9)��2, 3+((8��7)-(9��2))�� ��� ��ȣ �ȿ� ��ȣ�� �ֱ� ������, �ùٸ� ���� �ƴϴ�.

	������ �־����� ��, ��ȣ�� ������ �߰��� ���� �� �ִ� ���� ����� �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. �߰��ϴ� ��ȣ ������ ������ ������, �߰����� �ʾƵ� �ȴ�.
	
�޸�
	14,264 KB
����ð�
	108 ms
	
���� �˰���
	���� ���α׷���(DP)

*/
import java.util.Scanner;

public class Main {
	static int N;
	static int answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		answer=Integer.MIN_VALUE;
		int[] number= new int[(N+1)/2];
		char[] operator = new char[(N-1)/2];
		String str = sc.next();
		number[0]=str.charAt(0)-48;
		
		for(int i=1;i<=(N-1)/2;i++) {
			number[i]=str.charAt(2*i)-48;
			operator[i-1]=str.charAt(2*i-1);
			
		}
		
		
		answer=calValue(number,operator,0);
		
		System.out.println(answer);
		

	}
	static void getMax(int[] num, char[] op) {
		if(num.length==1) {
			answer = Math.max(answer, num[0]);
			
		}else {
			
			for(int i=0;i<op.length;i++) {
				int[] newnum = new int[num.length-1];
				char[] newop = new char[op.length-1];
				for(int j=0;j<op.length;j++) {
					if(i>j) {
						newnum[j]=num[j];
						newop[j]=op[j];
					}
					else if(i==j) {
						newnum[j]=cal(num[i],num[i+1],op[i]);
					}
					else {
						newnum[j]=num[j+1];
						newop[j-1]=op[j];
					}
				}
				
				getMax(newnum,newop);
			}
			
		}
		
		
	}
	
	static int calValue(int[] num, char[] op, int index) {
		if(index>=op.length) {
			int ret=num[0];
			for(int i=0;i<op.length;i++) {
				
				ret=cal(ret,num[i+1],op[i]);
			}
			return ret;
		}else {
			int[] newnum = new int[num.length-1];
			char[] newop = new char[op.length-1];
			for(int j=0;j<op.length;j++) {
				
				if(index>j) {
					newnum[j]=num[j];
					newop[j]=op[j];
				}
				else if(index==j) {
					newnum[j]=cal(num[j],num[j+1],op[j]);
				}
				else {
					newnum[j]=num[j+1];
					newop[j-1]=op[j];
				}
			}
			return Math.max(calValue(num,op,index+1),calValue(newnum,newop,index+1));
		}
		
	}
	
	
	static int cal(int a, int b, char op) {
		if(op=='+') {
			return a+b;
		}
		if(op=='-') {
			return a-b;
		}
		if(op=='*') {
			return a*b;
		}
		if(op=='/') {
			return a/b;
		}
		return -1;
	}

}
