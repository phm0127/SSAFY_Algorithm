package SWEA7673;
/**
미해결!!
	
	
문제
	영이 집과 철수 집 사이의 길은 가로와 세로가 N칸으로 이루어진 2차원 평면으로 표현할 수 있다.
	
	영이의 집은 왼쪽 위인 (1, 1)에 있으며, 철수의 집은 오른쪽 아래인 (N, N)에 있다.
	
	각 칸에는 0 이상의 정수가 쓰여져 있다. 영이는 영이 너무 너무~~~ 싫은 나머지, 0이 쓰여진 칸을 피해 철수의 집을 가고 싶다.
	
	그리고 철수에게 가는 경로에 놓여져 있는 숫자들을 모두 곱했을 때, 맨 뒷자리에 연속으로 있는 0의 개수를 최소화 시키고 싶다.
	
	영이는 매우 효율적인 사람이기 때문에 무조건 오른쪽 또는 아래쪽으로만 이동한다
	
	
	 예를 한번 보도록 하자
	  
	
	1 3 7 
	2 0 3 
	3 4 5 
	
	
	길이 위쪽 모양으로 구성되어 있을 때,
	
	1->3->7->3->5 순서로 이동하면 모두 곱한 값이 315 이고,
	
	1->2->3->4->5 순서로 이동하면 모두 곱한 값이 120 이다.
	
	따라서 영이는 1->3->7->3->5 경로로 이동하여 맨 뒷자리에 연속으로 있는 0의 개수를 최소화 할 것이다.
	
	영이의 집과 철수의 집 사이의 길이 주어졌을 때, 맨 뒷자리에 연속으로 있는 0의 개수의 최소값을 구하여랏.
	
메모리
	 KB
실행시간
	 ms
	
적용 알고리즘
	



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







