package SWEA2382;
/**
문제
	https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV597vbqAH0DFAVl&categoryId=AV597vbqAH0DFAVl&categoryType=CODE
	
메모리
	107,044 KB
실행시간
	318 ms
	
적용 알고리즘
	시뮬레이션

*/
import java.util.Scanner;

public class Solution {
	static int[] dR = {-1,1,0,0};
	static int[] dC = {0,0,-1,1};
	static int answer;
	static int N;
	static int M;
	static int K;
	static Virus[] list;
	static boolean[] b;
	static boolean[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			list = new Virus[K];
			b=new boolean[K];
			for(int i=0;i<K;i++) {
				int r = sc.nextInt();
				int c = sc.nextInt();
				int number = sc.nextInt();
				int dir = sc.nextInt()-1;
				Virus v = new Virus(r,c,number,dir);
				list[i]=v;
			}
			go(0);
			System.out.println("#"+test_case+" "+answer);
		}
	}

	static void go(int time) {
		if(time==M) {
			answer =0;
			for(int i=0;i<K;i++) {
				if(!b[i]) {
					answer+=list[i].number;
				}
			}
		}else {
			map=new boolean[N][N];
			for(int i=0; i<K;i++) {
				if(!b[i]) {
					list[i].curMax=list[i].number;
					list[i].r+=dR[list[i].dir];
					list[i].c+=dC[list[i].dir];
					if(list[i].r==0||list[i].c==0||list[i].r==N-1||list[i].c==N-1) {
						list[i].number/=2;
						list[i].dir=opposite(list[i].dir);
					}
					if(list[i].number==0) {
						b[i]=true;
					}
					if(map[list[i].r][list[i].c]) {
						for(int j=0;j<i;j++) {
							if(!b[j]) {
								if(list[j].r==list[i].r&&list[j].c==list[i].c) {
									if(list[i].curMax>list[j].curMax) {
										list[i].number+=list[j].number;
										list[j].number=0;
										b[j]=true;
									}else {
										list[j].number+=list[i].number;
										list[i].number=0;
										b[i]=true;
									}
								}
							}
							
						}
					}else {
						map[list[i].r][list[i].c]=true;
					}
				}
				
				
				
			}
			go(time+1);
		}
	}

	static int opposite(int dir) {
		if(dir%2==0) {
			return dir+1;	
		}else {
			return dir-1;
		}
	}

}


class Virus{
	int r;
	int c;
	int number;
	int dir;
	int curMax;

	public Virus(int r, int c, int number, int dir) {
		this.r = r;
		this.c = c;
		this.number = number;
		this.dir = dir;
		this.curMax = number;
	}
}

