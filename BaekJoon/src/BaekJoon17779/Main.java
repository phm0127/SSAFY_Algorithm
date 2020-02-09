package BaekJoon17779;
/**
����
	�������� ���� �������� ���� �� �Ⱓ �Ը��Ǵ����� ���ؼ� �ڽ��� �翡�� �����ϰ� ���ű��� ȹ���ߴ�. ������ �Ƿ��� ������ �������� �Ƿ��� �ſ� �δ��ϰ� ����߰�, ������� ���� �̸��� �����÷� �����ߴ�. �̹� ���ſ����� �ִ��� �����ϰ� ���ű��� ȹ���Ϸ��� �Ѵ�.

	�����ô� ũ�Ⱑ N��N�� ���ڷ� ��Ÿ�� �� �ִ�. ������ �� ĭ�� ������ �ǹ��ϰ�, r�� c���� �ִ� ������ (r, c)�� ��Ÿ�� �� �ִ�. ������ �ټ� ���� ���ű��� ������ �ϰ�, �� ������ �ټ� ���ű� �� �ϳ��� ���ԵǾ�� �Ѵ�. ���ű��� ������ ��� �ϳ� �����ؾ� �ϰ�, �� ���ű��� ���ԵǾ� �ִ� ������ ��� ����Ǿ� �־�� �Ѵ�. ���� A���� ������ ������ ���ؼ� ���� B�� �� �� ���� ��, �� ������ ����Ǿ� �ִٰ� �Ѵ�. �߰��� ���ϴ� ������ ������ 0�� �̻��̾�� �ϰ�, ��� ���� ���ű��� ���Ե� �����̾�� �Ѵ�.
	
	���ű��� ������ ����� ������ ����.
	
	1. ������ (x, y)�� ����� ���� d1, d2�� ���Ѵ�. (d1, d2 �� 1, 1 �� x < x+d1+d2 �� N, 1 �� y-d1 < y < y+d2 �� N)
	
	2. ���� ĭ�� ��輱�̴�.
	
		(x, y), (x+1, y-1), ..., (x+d1, y-d1)
		(x, y), (x+1, y+1), ..., (x+d2, y+d2)
		(x+d1, y-d1), (x+d1+1, y-d1+1), ... (x+d1+d2, y-d1+d2)
		(x+d2, y+d2), (x+d2+1, y+d2-1), ..., (x+d2+d1, y+d2-d1)
	
	3. ��輱�� ��輱�� �ȿ� ���ԵǾ��ִ� 5�� ���ű��̴�.
	
	4. 5�� ���ű��� ���Ե��� ���� ���� (r, c)�� ���ű� ��ȣ�� ���� ������ ������.
	
		1�� ���ű�: 1 �� r < x+d1, 1 �� c �� y
		2�� ���ű�: 1 �� r �� x+d2, y < c �� N
		3�� ���ű�: x+d1 �� r �� N, 1 �� c < y-d1+d2
		4�� ���ű�: x+d2 < r �� N, y-d1+d2 �� c �� N
		
	�Ʒ��� ũ�Ⱑ 7��7�� �����ø� �ټ� ���� ���ű��� ���� ����� �����̴�.  [��ũ ����]
	
	https://www.acmicpc.net/problem/17779
	
	���� (r, c)�� �α��� A[r][c]�̰�, ���ű��� �α��� ���ű��� ���Ե� ������ �α��� ��� ���� ���̴�. ���ű��� ������ ��� �߿���, �α��� ���� ���� ���ű��� ���� ���� ���ű��� �α� ������ �ּڰ��� ���غ���.
	
�޸�
	17,672 KB
����ð�
	220 ms
	
���� �˰���
	�ùķ��̼� (��Ʈ��ŷ)

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

