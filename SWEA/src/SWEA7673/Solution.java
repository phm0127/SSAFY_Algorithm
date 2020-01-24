package SWEA7673;
/**
���ذ�!!
	
	
����
	���� ���� ö�� �� ������ ���� ���ο� ���ΰ� Nĭ���� �̷���� 2���� ������� ǥ���� �� �ִ�.
	
	������ ���� ���� ���� (1, 1)�� ������, ö���� ���� ������ �Ʒ��� (N, N)�� �ִ�.
	
	�� ĭ���� 0 �̻��� ������ ������ �ִ�. ���̴� ���� �ʹ� �ʹ�~~~ ���� ������, 0�� ������ ĭ�� ���� ö���� ���� ���� �ʹ�.
	
	�׸��� ö������ ���� ��ο� ������ �ִ� ���ڵ��� ��� ������ ��, �� ���ڸ��� �������� �ִ� 0�� ������ �ּ�ȭ ��Ű�� �ʹ�.
	
	���̴� �ſ� ȿ������ ����̱� ������ ������ ������ �Ǵ� �Ʒ������θ� �̵��Ѵ�
	
	
	 ���� �ѹ� ������ ����
	  
	
	1 3 7 
	2 0 3 
	3 4 5 
	
	
	���� ���� ������� �����Ǿ� ���� ��,
	
	1->3->7->3->5 ������ �̵��ϸ� ��� ���� ���� 315 �̰�,
	
	1->2->3->4->5 ������ �̵��ϸ� ��� ���� ���� 120 �̴�.
	
	���� ���̴� 1->3->7->3->5 ��η� �̵��Ͽ� �� ���ڸ��� �������� �ִ� 0�� ������ �ּ�ȭ �� ���̴�.
	
	������ ���� ö���� �� ������ ���� �־����� ��, �� ���ڸ��� �������� �ִ� 0�� ������ �ּҰ��� ���Ͽ���.
	
�޸�
	 KB
����ð�
	 ms
	
���� �˰���
	



*/
import java.util.*;


class Solution {

	static int MAX=Integer.MAX_VALUE;
	static int answer;
	static int[][] ansMap;
	static int N;


	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int T;
		

		T=sc.nextInt();
		int[][] map;
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			answer=MAX;


			N=sc.nextInt();
			map= new int[N][N];
			ansMap = new int[N][N];

			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j]=sc.nextInt();
					ansMap[i][j]=-1;
				}
			}
			answer = move(map,0,0);
			answer = count(answer);

			System.out.println("#"+test_case+" "+answer);
		}
	}

	static int move(int[][] map, int r, int c) {

		
		if(r==N-1&&c==N-1) {
			return map[r][c];
		}
		if(r>N-1||c>N-1||map[r][c]==0) {
			return -1;
		}
		if(ansMap[r][c]>0) {
			return ansMap[r][c];
		}
		else {
			int ansR,ansL;
			ansR=map[r][c]*move(map,r+1,c);
			ansL=map[r][c]*move(map,r,c+1);
			if(ansR>0&&ansL>0) {
				if(count(ansR)>count(ansL)) {
					return ansL;
				}else {
					return ansR;
				}
			}
			if(ansR<0&&ansL>0) {
				return ansL;
			}
			if(ansR>0&&ansL<0) {
				return ansR;
			}
		}
		
		
		return -1;
		

	}
	
	static int count(int sum) {
		int zero=0;
		while(sum%10==0) {
			sum/=10;
			zero++;
		}
		
		return zero;
	}
}


/*
 class Solution {

	static int MAX=987654321;
	static int answer;



	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int T;


		T=sc.nextInt();
		int N;
		int[][] map;
		int[][] ansMap;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			answer=MAX;


			N=sc.nextInt();
			map= new int[N][N];
			ansMap = new int[N][N];

			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j]=sc.nextInt();
					ansMap[i][j]=-1;
				}
			}
			move(N,map,map[0][0],0,0);


			System.out.println("#"+test_case+" "+answer);
		}
	}

	static void move(int N, int[][] map,int sum,int r, int c) {
		int zero;
		sum*=map[r][c];
		zero = count(sum);
		if(zero>answer) {

		}
		else {
			if(r==N-1&&c==N-1) {
				answer= Math.min(answer, zero);
			}
			else {
				if(r==N-1) {
					if(map[r][c+1]!=0) {
						move(N,map,sum,r,c+1);	
					}

				}
				else if(c==N-1) {
					if(map[r+1][c]!=0) {
						move(N,map,sum,r+1,c);	
					}
				}
				else {
					if(map[r][c+1]!=0) {
						move(N,map,sum,r,c+1);	
					}
					if(map[r+1][c]!=0) {
						move(N,map,sum,r+1,c);	
					}
				}



			}
		}



	}

	static int count(int sum) {
		int zero=0;
		while(sum%10==0) {
			sum/=10;
			zero++;
		}

		return zero;
	}
}
 */







