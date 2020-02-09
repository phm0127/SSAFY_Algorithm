package BaekJoon11559;
/**
����
	�ѿ�ѿ��� ���� ������ ����.

	�ʵ忡 ���� ���� ������ �ѿ並 ���´�. �ѿ�� �߷��� ������ �޾� �Ʒ��� �ٴ��̳� �ٸ� �ѿ䰡 ���� ������ �Ʒ��� ��������.

	�ѿ並 ���� �� ��, ���� �� �ѿ䰡 4�� �̻� �����¿�� ����Ǿ� ������ ����� ���� �� �ѿ���� �Ѳ����� ��������.

	�ѿ���� �������� ���� ���� �ٸ� �ѿ���� �ִٸ�, ���� �߷��� ������ �޾� ���ʴ�� �Ʒ��� �������� �ȴ�.

	�Ʒ��� �������� ���� �ٽ� ���� ���� �ѿ���� 4�� �̻� ���̰� �Ǹ� �� ������ �Ǵµ�, ���� �� �ѿ���� �������� �ٽ� ������ �ݺ��� ������ 1���⾿ �þ��.

	���� �� �ִ� �ѿ䰡 ���� �׷��� �ִٸ� ���ÿ� ������ �ϰ� ���� �׷��� �������� �ѹ��� ���Ⱑ �߰��ȴ�.

	���Դ� �ֱ� �ѿ�ѿ� ���ӿ� ǫ ������. �� ������ 1:1�� �ٴ� ���������̶� �� �״� �͵� �߿�������, ������ �Ͷ߸��ٸ� ���Ⱑ �� ���� ���� �ٷ� �ľ��� �� �ִ� �ɷµ� �ʿ��ϴ�.
	
	������ ���� �Ƿ��� �����Ͽ� ���Դ� �ڱ� �ʵ忡�� �Ű� ���� �ٻڴ�. ������ �ʵ尡 �־����� ��, ���Ⱑ �� �� �������� �Ͼ�� ����Ͽ� ���Ը� ��������!
	
�޸�
	14,336 KB
����ð�
	104 ms
	
���� �˰���
	�ùķ��̼�

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

