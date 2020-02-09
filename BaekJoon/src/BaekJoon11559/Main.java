package BaekJoon11559;
/**
문제
	뿌요뿌요의 룰은 다음과 같다.

	필드에 여러 가지 색깔의 뿌요를 놓는다. 뿌요는 중력의 영향을 받아 아래에 바닥이나 다른 뿌요가 나올 때까지 아래로 떨어진다.

	뿌요를 놓고 난 후, 같은 색 뿌요가 4개 이상 상하좌우로 연결되어 있으면 연결된 같은 색 뿌요들이 한꺼번에 없어진다.

	뿌요들이 없어지고 나서 위에 다른 뿌요들이 있다면, 역시 중력의 영향을 받아 차례대로 아래로 떨어지게 된다.

	아래로 떨어지고 나서 다시 같은 색의 뿌요들이 4개 이상 모이게 되면 또 터지게 되는데, 터진 후 뿌요들이 내려오고 다시 터짐을 반복할 때마다 1연쇄씩 늘어난다.

	터질 수 있는 뿌요가 여러 그룹이 있다면 동시에 터져야 하고 여러 그룹이 터지더라도 한번의 연쇄가 추가된다.

	남규는 최근 뿌요뿌요 게임에 푹 빠졌다. 이 게임은 1:1로 붙는 대전게임이라 잘 쌓는 것도 중요하지만, 상대방이 터뜨린다면 연쇄가 몇 번이 될지 바로 파악할 수 있는 능력도 필요하다.
	
	하지만 아직 실력이 부족하여 남규는 자기 필드에만 신경 쓰기 바쁘다. 상대방의 필드가 주어졌을 때, 연쇄가 몇 번 연속으로 일어날지 계산하여 남규를 도와주자!
	
메모리
	14,336 KB
실행시간
	104 ms
	
적용 알고리즘
	시뮬레이션

*/
import java.util.Scanner;

public class Main {
	static int N,M;
	static int answer=0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char map[][] = new char[12][6];
		for(int i=0;i<12;i++) {
			String str= sc.nextLine();
			for(int j=0;j<6;j++) {
				map[i][j]=str.charAt(j);
			}
		}
		
		
		puyo(map);
		
		
		System.out.println(answer);
		

	}
	static void puyo(char[][] map) {
		
		boolean flag=false;
		for(int i=0;i<12;i++) {
			for(int j=0;j<6;j++) {
				if(map[i][j]!='.') {
					boolean[][] boo = new boolean[12][6];
					if(check(map,boo,map[i][j],i,j)>=4) {
						flag=true;
						change(map,map[i][j],i,j);
						
					}
				}
			}
		}
		if(flag) {
			answer++;
			down(map);
			puyo(map);
		}
	}
	
	static int check(char[][] map,boolean[][] boo, char block,int r, int c) {
		if(r<0||c<0||r>=map.length||c>=map[0].length) {
			
		}
		else {
			if(map[r][c]==block&&!boo[r][c]) {
				boo[r][c]=true;
				return 1+check(map,boo,block,r+1,c)+check(map,boo,block,r,c+1)+check(map,boo,block,r-1,c)+check(map,boo,block,r,c-1);
			}
		}
		
		return 0;
	}
	
	static void change(char[][] map, char block,int r, int c) {
		if(r<0||c<0||r>=map.length||c>=map[0].length) {
			
		}
		else {
			if(map[r][c]==block) {
				map[r][c]='.';
				change(map,block,r+1,c);
				change(map,block,r,c+1);
				change(map,block,r-1,c);
				change(map,block,r,c-1);
			}
		}
		
		
	}
	
	static void down(char[][] map) {
		for(int i=11;i>=0;i--) {
			for(int j=0;j<6;j++) {
				if(map[i][j]!='.') {
					int index=i;
					char tmp = map[i][j];
					while(true) {
						index++;
						if(index>11) {
							index--;
							break;
						}
						if(map[index][j]!='.') {
							index--;
							break;
						}
					}
					map[i][j]='.';
					map[index][j]=tmp;
				}
			}
		}
	}
	
	
}

