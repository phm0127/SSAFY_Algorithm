package SWEA1247;
/**
����
	�Ｚ������ ���� ����� ��븮�� ȸ�翡�� ����Ͽ� ����� ����� ���� N���� ���� �湮�ϰ� �ڽ��� ���� ���ư����Ѵ�.
	
	ȸ��� ���� ��ġ, �׸��� �� ���� ��ġ�� ������ ���� ��ǥ (x, y)�� �־����� (0 �� x �� 100, 0 �� y �� 100)
	
	�� ��ġ (x1, y1)�� (x2, y2) ������ �Ÿ��� |x1-x2| + |y1-y2|���� ���ȴ�.
	
	���⼭ |x|�� x�� ���밪�� �ǹ��ϸ� |3| = |-3| = 3�̴�. ȸ���� ��ǥ, ���� ��ǥ, ������ ��ǥ�� ��� �ٸ���.
	
	ȸ�翡�� ����Ͽ� N���� ���� ��� �湮�ϰ� ������ ���ƿ��� ��� �� ���� ª�� ���� ã���� �Ѵ�.
	
	ȸ��� ���� ��ǥ�� �־�����, 2���� 10�� ������ �� ��ǥ�� �־��� ��,
	
	ȸ�翡�� ����ؼ� �̵��� ��� �湮�ϰ� ���� ���ư��� ��� �� �� �̵��Ÿ��� ���� ª�� ��θ� ã�� ���α׷��� �ۼ��϶�.
	
	�������� ���α׷��� ���� ª�� ����� �̵��Ÿ��� ������ �ȴ�.
	
	�� ������ ���� ª�� ��θ� ��ȿ�������Ρ� ã�� ���� ������ �ƴϴ�.
	
	�������� ��� ������ ��θ� ���켭 �ظ� ã�Ƶ� ����.
	
	��� ��츦 ü�������� ���� �� ������ ������ ���� �� �ִ�.
	
�޸�
	21,548 KB
����ð�
	968 ms
	
���� �˰���
	���� Ž��



*/


import java.util.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.*;






class Solution {

	static int answer=987654321;


	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int T;
		
		T=sc.nextInt();
		int N;
		Point[] arr;
		boolean[] boo;
		Point point;
		/*
		   ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
		 */

		for(int test_case = 1; test_case <= T; test_case++)
		{
			answer=987654321;
	
			N=sc.nextInt();
			
			arr = new Point[N+2];
			boo = new boolean[N];
			
			for(int i=0;i<N+2;i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				point = new Point(x,y);
				arr[i]=point;
			}
			
			cal(arr,N,0,arr[0],boo,0);
			
			System.out.println("#"+test_case+" "+answer);
		}
	}

	static void cal(Point[] arr, int N, int count, Point p, boolean[] boo, int dist) {
		int temp;
		if(count==N) {
			temp = Math.abs(p.getX()-arr[1].getX())+Math.abs(p.getY()-arr[1].getY());
			dist+=temp;
			if(answer>dist){
				answer=dist;
			}
		}else {
			for(int i=0;i<N;i++) {
				if(!boo[i]) {
					boo[i]=true;
					temp = Math.abs(p.getX()-arr[i+2].getX())+Math.abs(p.getY()-arr[i+2].getY());
					cal(arr,N,count+1,arr[i+2],boo,dist+temp);
					boo[i]=false;
				}
			}
		}
		
		
	}
	
	

}

class Point {
	int x;
	int y;
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
}







