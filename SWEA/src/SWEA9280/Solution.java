package SWEA9280;
/**
����
	�������� �����̴� ���� �տ��� ���� ������ ��ϰ� �ִ�. �� �������� 1 ���� n ���� ��ȣ�� �Ű��� n ���� ���� ������ ������ �ִ�.

	���� ��ħ ��� ���� ������ ��� �ִ� ���¿��� ������ �����ϸ�, ������ ���� ������� ��ȴ�. 
	 
		���� �����忡 �����ϸ�, �����̴� ����ִ� ���� ������ �ִ��� �˻��Ѵ�.
		 
		����ִ� ������ ���ٸ�, �� ������ ���� ������ ������ �Ա����� ��ٸ��� �Ѵ�.
		 
		�� ���� ������ ������ �����̴� ��ٷ� ������ ��Ű��, ���� ������ ���� �� ��ȣ�� ���� ���� ���� ������ �����ϵ��� �Ѵ�.
		 
		���� ������ ��ٸ��� ������ ���� ����, �Ա��� �����ҿ��� �ڱ� ���ʸ� ��ٷ��� �Ѵ�. �����ڵ��� ���ǰ� �ٸ��� ������ ��ġ�⸦ ���� �ʴ´�.
	
	��������� ������ ���Կ� ���� �������� ���� å���� ���� ���Դ� �ݾ��� ���� �����̴�. �����̳� �����忡���� ���� �̿�Ǹ��� �Ǹ��ϱ� ������ �̿�ð��� ������� �ʴ´�.
	
	�����̴� ���� �������� �̿��� m ���� �������� ������ ������ ������ �˰� �ִ�.
	
	�������� �������� ���� �Ϸ� ������� �� ������ ����ϴ� ���α׷��� �ۼ��϶�.

	
�޸�
	56,500 KB
����ð�
	238 ms
	
���� �˰���
	���� Ž��



*/

import java.util.*;

class Solution {

	static int B[];
	static int n,m;
	static int R[];
	static int W[];
	static Queue<Integer> q;
	
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int T;
		
		
		int input;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int answer=0;
			q=new LinkedList<Integer>();
			n=sc.nextInt();
			m=sc.nextInt();
			R=new int[n];
			B=new int[n];
			W=new int[m];
			for(int i=0;i<n;i++) {
				R[i]=sc.nextInt();
			}
			for(int j=0;j<m;j++) {
				W[j]=sc.nextInt();
			}
			
			for(int k=0;k<2*m;k++) {
				input = sc.nextInt();
				if(input>0) {
					answer+=cost(input);
				}
				else {
					
					answer+=out(-input);
				}
			}
			System.out.println("#"+test_case+" "+answer);
		}
	}
	
	static public int cost(int input) {
		int cost=0;
		int flag =0;
		for(int i=0;i<n;i++) {
			if(B[i]==0) {
				B[i]=input;
				cost = R[i]*W[input-1];
				flag=1;
				break;
			}
		}
		if(flag!=1) {
			q.add(input);
		}
		
		return cost;
	}
	static public int out(int input) {
		int cost=0;
		
		for(int i=0;i<n;i++) {
			
			if(B[i]==input) {
				if(q.isEmpty()) {
					B[i]=0;
				}
				else {
					B[i]=q.poll();
					cost = R[i]*W[B[i]-1];
				}
				break;
			}
		}
		
		
		return cost;
	}

}









