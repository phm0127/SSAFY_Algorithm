package BaekJoon17779;
/**
문제
	재현시의 시장 구재현은 지난 몇 년간 게리맨더링을 통해서 자신의 당에게 유리하게 선거구를 획정했다. 견제할 권력이 없어진 구재현은 권력을 매우 부당하게 행사했고, 심지어는 시의 이름도 재현시로 변경했다. 이번 선거에서는 최대한 공평하게 선거구를 획정하려고 한다.

	재현시는 크기가 N×N인 격자로 나타낼 수 있다. 격자의 각 칸은 구역을 의미하고, r행 c열에 있는 구역은 (r, c)로 나타낼 수 있다. 구역을 다섯 개의 선거구로 나눠야 하고, 각 구역은 다섯 선거구 중 하나에 포함되어야 한다. 선거구는 구역을 적어도 하나 포함해야 하고, 한 선거구에 포함되어 있는 구역은 모두 연결되어 있어야 한다. 구역 A에서 인접한 구역을 통해서 구역 B로 갈 수 있을 때, 두 구역은 연결되어 있다고 한다. 중간에 통하는 인접한 구역은 0개 이상이어야 하고, 모두 같은 선거구에 포함된 구역이어야 한다.
	
	선거구를 나누는 방법은 다음과 같다.
	
	1. 기준점 (x, y)와 경계의 길이 d1, d2를 정한다. (d1, d2 ≥ 1, 1 ≤ x < x+d1+d2 ≤ N, 1 ≤ y-d1 < y < y+d2 ≤ N)
	
	2. 다음 칸은 경계선이다.
	
		(x, y), (x+1, y-1), ..., (x+d1, y-d1)
		(x, y), (x+1, y+1), ..., (x+d2, y+d2)
		(x+d1, y-d1), (x+d1+1, y-d1+1), ... (x+d1+d2, y-d1+d2)
		(x+d2, y+d2), (x+d2+1, y+d2-1), ..., (x+d2+d1, y+d2-d1)
	
	3. 경계선과 경계선의 안에 포함되어있는 5번 선거구이다.
	
	4. 5번 선거구에 포함되지 않은 구역 (r, c)의 선거구 번호는 다음 기준을 따른다.
	
		1번 선거구: 1 ≤ r < x+d1, 1 ≤ c ≤ y
		2번 선거구: 1 ≤ r ≤ x+d2, y < c ≤ N
		3번 선거구: x+d1 ≤ r ≤ N, 1 ≤ c < y-d1+d2
		4번 선거구: x+d2 < r ≤ N, y-d1+d2 ≤ c ≤ N
		
	아래는 크기가 7×7인 재현시를 다섯 개의 선거구로 나눈 방법의 예시이다.  [링크 참조]
	
	https://www.acmicpc.net/problem/17779
	
	구역 (r, c)의 인구는 A[r][c]이고, 선거구의 인구는 선거구에 포함된 구역의 인구를 모두 합한 값이다. 선거구를 나누는 방법 중에서, 인구가 가장 많은 선거구와 가장 적은 선거구의 인구 차이의 최솟값을 구해보자.
	
메모리
	17,672 KB
실행시간
	220 ms
	
적용 알고리즘
	시뮬레이션 (백트레킹)

*/
import java.util.Scanner;

public class Main {

	static int N;
	static int[][] map;
	static int answer;
	static int total;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		answer= Integer.MAX_VALUE;
		N = sc.nextInt();
		map=new int[N][N];
		total=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j]=sc.nextInt();
				total+=map[i][j];
			}
		}
		int r=0,c=0;
		while(true) {
			if(c>=N) {
				c=0;
				r++;
			}
			if(r>=N) {
				break;
			}
			choice(r,c,1);
			c++;
		}
		
		
		System.out.println(answer);
	}
	
	static void choice(int r, int c, int d1) {
		if(r+d1<N&&c-d1>=0) {
			choice2(r,c,d1,1);
			choice(r,c,d1+1);
		}
		else {
			
		}
		
	}
	static void choice2(int r, int c, int d1,int d2) {
		if(r+d1+d2<N&&c+d2<N) {
			cal(r,c,d1,d2);
			choice2(r,c,d1,d2+1);
		}
		else {
			
		}
		
	}

	static void cal(int r, int c, int d1, int d2) {
		int leftR,leftC,botR,botC,rightR,rightC;
		int max;
		int min;

		int sec1=0,sec2=0,sec3=0,sec4=0,sec5;
        
		//sec1
		for(int i=0;i<r+d1;i++) {
			if(i<r) {
				for(int j=0;j<=c;j++) {
					sec1+=map[i][j];
					
				}
			}
			else {
				for(int j=0;j<c-(i-r);j++) {
					sec1+=map[i][j];
					
				}
			}
		}
		
		max=sec1;
		min=sec1;
		//sec1 
		
		//sec2
		for(int i=0;i<=r+d2;i++) {
			if(i<=r) {
				for(int j=c+1;j<N;j++) {
					sec2+=map[i][j];
					
				}
			}
			else {
				for(int j=c+1+i-r;j<N;j++) {
					sec2+=map[i][j];
					
				}
			}
		}
		max=Math.max(max, sec2);
		min=Math.min(min, sec2);
		//sec2
		
		//sec3
		for(int i=r+d1;i<N;i++) {
			if(i<=r+d1+d2) {
				for(int j=0;j<c-d1+(i-r-d1);j++) {
					sec3+=map[i][j];
					
				}
			}
			else {
				for(int j=0;j<c-d1+d2;j++) {
					
					sec3+=map[i][j];
					
				}
			}
		}
		max=Math.max(max, sec3);
		min=Math.min(min, sec3);
		//sec3
		
		//sec4
		for(int i=r+d2+1;i<N;i++) {
			if(i<=r+d1+d2) {
				for(int j=c+d2-(i-(r+d2)-1);j<N;j++) {
					sec4+=map[i][j];
					
				}
			}
			else {
				for(int j=c-d1+d2;j<N;j++) {
					sec4+=map[i][j];
					
				}
			}
		}
		max=Math.max(max, sec4);
		min=Math.min(min, sec4);
		//sec4
		
		sec5 = total-sec1-sec2-sec3-sec4;
		
		max=Math.max(max, sec5);
		min=Math.min(min, sec5);
		
		answer=Math.min(answer, max-min);
	}
	
	


}

