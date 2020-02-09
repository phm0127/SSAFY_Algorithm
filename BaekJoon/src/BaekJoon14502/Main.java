package BaekJoon14502;
/**
����
	��ü�� ġ������ ���̷����� �����ϴ� �����ҿ��� ���̷����� ����Ǿ���. ������ ���̷����� ���� ������ �ʾҰ�, ���̷����� Ȯ���� ���� ���ؼ� �����ҿ� ���� ������� �Ѵ�.

	�����Ҵ� ũ�Ⱑ N��M�� ���簢������ ��Ÿ�� �� ������, ���簢���� 1��1 ũ���� ���簢������ �������� �ִ�. �����Ҵ� �� ĭ, ������ �̷���� ������, ���� ĭ �ϳ��� ���� �����Ѵ�. 
	
	�Ϻ� ĭ�� ���̷����� �����ϸ�, �� ���̷����� �����¿�� ������ �� ĭ���� ��� �������� �� �ִ�. ���� ���� �� �ִ� ���� ������ 3���̸�, �� 3���� ������ �Ѵ�.
		
	���� ���, �Ʒ��� ���� �����Ұ� ���� ��츦 ���캸��.
	
	2 0 0 0 1 1 0
	0 0 1 0 1 2 0
	0 1 1 0 1 0 0
	0 1 0 0 0 0 0
	0 0 0 0 0 1 1
	0 1 0 0 0 0 0
	0 1 0 0 0 0 0
	
	�̶�, 0�� �� ĭ, 1�� ��, 2�� ���̷����� �ִ� ���̴�. �ƹ��� ���� ������ �ʴ´ٸ�, ���̷����� ��� �� ĭ���� �������� �� �ִ�.
	
	2�� 1��, 1�� 2��, 4�� 6���� ���� ����ٸ� ������ ����� �Ʒ��� �������� �ȴ�.
	
	2 1 0 0 1 1 0
	1 0 1 0 1 2 0
	0 1 1 0 1 0 0
	0 1 0 0 0 1 0
	0 0 0 0 0 1 1
	0 1 0 0 0 0 0
	0 1 0 0 0 0 0
	
	���̷����� ���� ���� ����� �Ʒ��� ��������.
	
	2 1 0 0 1 1 2
	1 0 1 0 1 2 2
	0 1 1 0 1 2 2
	0 1 0 0 0 1 2
	0 0 0 0 0 1 1
	0 1 0 0 0 0 0
	0 1 0 0 0 0 0
	
	���� 3�� ���� ��, ���̷����� ���� �� ���� ���� ���� �����̶�� �Ѵ�. ���� �������� ���� ������ ũ��� 27�̴�.
	
	�������� ������ �־����� �� ���� �� �ִ� ���� ���� ũ���� �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	
�޸�
	27,088 KB
����ð�
	332 ms
	
���� �˰���
	�ùķ��̼� (��Ʈ��ŷ)

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
    Virus ��ü ����
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
