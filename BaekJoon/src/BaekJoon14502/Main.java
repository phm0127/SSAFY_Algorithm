package BaekJoon14502;
/**
문제
	인체에 치명적인 바이러스를 연구하던 연구소에서 바이러스가 유출되었다. 다행히 바이러스는 아직 퍼지지 않았고, 바이러스의 확산을 막기 위해서 연구소에 벽을 세우려고 한다.

	연구소는 크기가 N×M인 직사각형으로 나타낼 수 있으며, 직사각형은 1×1 크기의 정사각형으로 나누어져 있다. 연구소는 빈 칸, 벽으로 이루어져 있으며, 벽은 칸 하나를 가득 차지한다. 
	
	일부 칸은 바이러스가 존재하며, 이 바이러스는 상하좌우로 인접한 빈 칸으로 모두 퍼져나갈 수 있다. 새로 세울 수 있는 벽의 개수는 3개이며, 꼭 3개를 세워야 한다.
		
	예를 들어, 아래와 같이 연구소가 생긴 경우를 살펴보자.
	
	2 0 0 0 1 1 0
	0 0 1 0 1 2 0
	0 1 1 0 1 0 0
	0 1 0 0 0 0 0
	0 0 0 0 0 1 1
	0 1 0 0 0 0 0
	0 1 0 0 0 0 0
	
	이때, 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 곳이다. 아무런 벽을 세우지 않는다면, 바이러스는 모든 빈 칸으로 퍼져나갈 수 있다.
	
	2행 1열, 1행 2열, 4행 6열에 벽을 세운다면 지도의 모양은 아래와 같아지게 된다.
	
	2 1 0 0 1 1 0
	1 0 1 0 1 2 0
	0 1 1 0 1 0 0
	0 1 0 0 0 1 0
	0 0 0 0 0 1 1
	0 1 0 0 0 0 0
	0 1 0 0 0 0 0
	
	바이러스가 퍼진 뒤의 모습은 아래와 같아진다.
	
	2 1 0 0 1 1 2
	1 0 1 0 1 2 2
	0 1 1 0 1 2 2
	0 1 0 0 0 1 2
	0 0 0 0 0 1 1
	0 1 0 0 0 0 0
	0 1 0 0 0 0 0
	
	벽을 3개 세운 뒤, 바이러스가 퍼질 수 없는 곳을 안전 영역이라고 한다. 위의 지도에서 안전 영역의 크기는 27이다.
	
	연구소의 지도가 주어졌을 때 얻을 수 있는 안전 영역 크기의 최댓값을 구하는 프로그램을 작성하시오.
	
메모리
	27,088 KB
실행시간
	332 ms
	
적용 알고리즘
	시뮬레이션 (백트레킹)

*/
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static int N,M;
	static int answer=0;
	static HashMap<Virus, Integer> hash;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int map[][] = new int[N][M];
		hash=new HashMap<Virus, Integer>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j]=sc.nextInt();
				if(map[i][j]==2) {
					Virus virus = new Virus(i,j);
					hash.put(virus, -1);
				}
			}
		}
		
		cal(map,0,0,0);
		System.out.println(answer);
		
	}
	
	static void cal(int[][] map,int r, int c, int count) {
		if(count>=3) {
			answer = Math.max(answer, survive(map));
		}
		else {
			if(c>=M) {
				c=0;
				r+=1;
			}
			if(r<N) {
				if(map[r][c]<1) {
					map[r][c]=1;
					cal(map,r,c+1,count+1);
					map[r][c]=0;
				}
				cal(map,r,c+1,count);
			}
		}
	}
	
	static int survive(int[][] map) {
		int count=0;
		Set<Virus> key = hash.keySet();
		for(Virus v : key) {
			int r= v.r;
			int c = v.c;
			plague(map, r-1, c);
			plague(map, r+1, c);
			plague(map, r, c+1);
			plague(map, r, c-1);
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) {
					count++;	
				}
				else if(map[i][j]==2) {
					map[i][j]=0;
				}
			}
		}
		for(Virus v : key) {
			map[v.r][v.c]=2;
		}
		return count;
	}
	
	static void plague(int map[][], int r, int c) {
		if(r<0||c<0||r>=N||c>=M) {
            
		}else {
			if(map[r][c]==0) {
				map[r][c]=2;
				plague(map, r-1, c);
				plague(map, r+1, c);
				plague(map, r, c+1);
				plague(map, r, c-1);
			}
		}
	}
}
/*=======================
    Virus 객체 생성
=======================*/
class Virus{
	int r;
	int c;
	int block;
	public Virus(int r, int c) {
		this.r=r;
		this.c=c;
	}
	
	public void setBlock(int block) {
		this.block=block;
	}
	
	public int getBlock() {
		return this.block;
	}
}
