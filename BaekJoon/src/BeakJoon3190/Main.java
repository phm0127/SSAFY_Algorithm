package BeakJoon3190;
/**
����
	'Dummy' ��� ���������� �ִ�. �� ���ӿ��� ���� ���ͼ� ���ٴϴµ�, ����� ������ �� ���̰� �þ��. ���� �̸����� ���ٴϴٰ� �� �Ǵ� �ڱ��ڽ��� ���� �ε����� ������ ������.

	������ NxN ���簢 ���������� ����ǰ�, ��� ĭ���� ����� ������ �ִ�. ������ �����¿� ���� ���� �ִ�. ������ �����Ҷ� ���� ���� �������� ��ġ�ϰ� ���� ���̴� 1 �̴�. ���� ó���� �������� ���Ѵ�.

	���� �� �ʸ��� �̵��� �ϴµ� ������ ���� ��Ģ�� ������.

		���� ���� �����̸� �÷� �Ӹ��� ����ĭ�� ��ġ��Ų��.
		
		���� �̵��� ĭ�� ����� �ִٸ�, �� ĭ�� �ִ� ����� �������� ������ �������� �ʴ´�.
		
		���� �̵��� ĭ�� ����� ���ٸ�, �����̸� �ٿ��� ������ ��ġ�� ĭ�� ����ش�. ��, �����̴� ������ �ʴ´�.
		
	����� ��ġ�� ���� �̵���ΰ� �־��� �� �� ������ �� �ʿ� �������� ����϶�.
	
�޸�
	15,664 KB
����ð�
	164 ms
	
���� �˰���
	�ùķ��̼�

*/
import java.util.*;
import java.io.IOException;
import java.math.*;

public class Main {

	static int[] dr= {-1,1,0,0}; // �����¿� 0123
	static int[] dc= {0,0,-1,1}; // �����¿�

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
				// 0 : �� || 1 : �� || 2 : �� || 3: ��
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

