package BeakJoon3190;
/**
문제
	'Dummy' 라는 도스게임이 있다. 이 게임에는 뱀이 나와서 기어다니는데, 사과를 먹으면 뱀 길이가 늘어난다. 뱀이 이리저리 기어다니다가 벽 또는 자기자신의 몸과 부딪히면 게임이 끝난다.

	게임은 NxN 정사각 보드위에서 진행되고, 몇몇 칸에는 사과가 놓여져 있다. 보드의 상하좌우 끝에 벽이 있다. 게임이 시작할때 뱀은 맨위 맨좌측에 위치하고 뱀의 길이는 1 이다. 뱀은 처음에 오른쪽을 향한다.

	뱀은 매 초마다 이동을 하는데 다음과 같은 규칙을 따른다.

		먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
		
		만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
		
		만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
		
	사과의 위치와 뱀의 이동경로가 주어질 때 이 게임이 몇 초에 끝나는지 계산하라.
	
메모리
	15,664 KB
실행시간
	164 ms
	
적용 알고리즘
	시뮬레이션

*/
import java.util.*;
import java.io.IOException;
import java.math.*;

public class Main {

	static int[] dr= {-1,1,0,0}; // 상하좌우 0123
	static int[] dc= {0,0,-1,1}; // 상하좌우

	static ArrayList<Snake> SA;
	static ArrayList<Integer> turn;
	static ArrayList<String> turnInfo;
	static int answer=0;
	static int[] x;
	static int[] y;
	static int K;

	public static void main(String[] args) throws IOException {

		Scanner scan = new Scanner(System.in);

		int N= scan.nextInt();
		K = scan.nextInt();
		int map[][] = new int [N][N];
		x=new int[K];
		y= new int[K];
		for(int i=0;i<K;i++) {
			x[i]=scan.nextInt()-1;
			y[i]=scan.nextInt()-1;

		}
		int turnTime=scan.nextInt();
		int t;

		String direction;
		turn = new ArrayList<>();
		turnInfo = new ArrayList<>();
		for(int i=0;i<turnTime;i++) {
			t=scan.nextInt();
			direction=scan.next();
			
			turn.add(t);
			turnInfo.add(direction);
		}
		SA= new ArrayList<Snake>();
		Snake snake =new Snake(0,0);

		SA.add(snake);

		move(map,3,0);
		System.out.println(answer);
	}

	public static void move(int[][] map, int direction, int time) {
		int r,c;
		r=SA.get(0).r;
		c=SA.get(0).c;

		while(true) {
			time++;
			r+=dr[direction];
			c+=dc[direction];
			
			Snake newSnake = new Snake(r,c);
			SA.add(0,newSnake);
			
			if(isCollide(r, c, map)) {
				answer=time;
				break;
			}
			

			

			if(!turn.isEmpty()&&time==turn.get(0)) {
				turn.remove(0);
				// 0 : 상 || 1 : 하 || 2 : 좌 || 3: 우
				if(turnInfo.get(0).equals("L")) {
					if(direction==0) {
						direction=2;
					}else if(direction==1) {
						direction=3;
					}else if(direction==2) {
						direction=1;
					}else {
						direction=0;
					}
				}else {
					if(direction==0) {
						direction=3;
					}else if(direction==1) {
						direction=2;
					}else if(direction==2) {
						direction=0;
					}else {
						direction=1;
					}
				}

				turnInfo.remove(0);
			}
			

			if(!isApple(r,c)) {
				SA.remove(SA.size()-1);
			}
			
			



		}


	}

	public static boolean isApple(int r, int c) {
		for(int i=0;i<K;i++) {
			if(r==x[i]&&c==y[i]) {
				x[i]=-1;
				y[i]=-1;
				return true;
			}
		}

		return false;
	}

	public static boolean isCollide(int r, int c, int[][] map) {
		if(r<0||c<0||r>map.length-1||c>map.length-1) {
			return true;
		}else {
			Iterator<Snake> iter = SA.iterator();
			Snake s= iter.next();
			while(iter.hasNext()) {
				s = iter.next();
				if(s.c==c&&s.r==r) {
					return true;
				}
				
			}
		}
		return false;
	}



}

class Snake{
	int r;
	int c;
	public Snake(int r,int c) {
		this.r=r;
		this.c=c;
	}
}

