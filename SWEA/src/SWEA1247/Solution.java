package SWEA1247;
/**
문제
	삼성전자의 서비스 기사인 김대리는 회사에서 출발하여 냉장고 배달을 위해 N명의 고객을 방문하고 자신의 집에 돌아가려한다.
	
	회사와 집의 위치, 그리고 각 고객의 위치는 이차원 정수 좌표 (x, y)로 주어지고 (0 ≤ x ≤ 100, 0 ≤ y ≤ 100)
	
	두 위치 (x1, y1)와 (x2, y2) 사이의 거리는 |x1-x2| + |y1-y2|으로 계산된다.
	
	여기서 |x|는 x의 절대값을 의미하며 |3| = |-3| = 3이다. 회사의 좌표, 집의 좌표, 고객들의 좌표는 모두 다르다.
	
	회사에서 출발하여 N명의 고객을 모두 방문하고 집으로 돌아오는 경로 중 가장 짧은 것을 찾으려 한다.
	
	회사와 집의 좌표가 주어지고, 2명에서 10명 사이의 고객 좌표가 주어질 때,
	
	회사에서 출발해서 이들을 모두 방문하고 집에 돌아가는 경로 중 총 이동거리가 가장 짧은 경로를 찾는 프로그램을 작성하라.
	
	여러분의 프로그램은 가장 짧은 경로의 이동거리만 밝히면 된다.
	
	이 문제는 가장 짧은 경로를 ‘효율적으로’ 찾는 것이 목적이 아니다.
	
	여러분은 모든 가능한 경로를 살펴서 해를 찾아도 좋다.
	
	모든 경우를 체계적으로 따질 수 있으면 정답을 맞출 수 있다.
	
메모리
	21,548 KB
실행시간
	968 ms
	
적용 알고리즘
	완전 탐색



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
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
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







