package SWEA9280;
/**
문제
	부지런한 진용이는 정문 앞에서 유료 주차장 운영하고 있다. 이 주차장은 1 부터 n 까지 번호가 매겨진 n 개의 주차 공간을 가지고 있다.

	매일 아침 모든 주차 공간이 비어 있는 상태에서 영업을 시작하며, 다음과 같은 방식으로 운영된다. 
	 
		차가 주차장에 도착하면, 진용이는 비어있는 주차 공간이 있는지 검사한다.
		 
		비어있는 공간이 없다면, 빈 공간이 생길 때까지 차량을 입구에서 기다리게 한다.
		 
		빈 주차 공간이 있으면 진용이는 곧바로 주차를 시키며, 주차 가능한 공간 중 번호가 가장 작은 주차 공간에 주차하도록 한다.
		 
		만약 주차를 기다리는 차량이 여러 대라면, 입구의 대기장소에서 자기 차례를 기다려야 한다. 운전자들은 예의가 바르기 때문에 새치기를 하지 않는다.
	
	주차요금은 차량의 무게와 주차 공간마다 따로 책정된 단위 무게당 금액을 곱한 가격이다. 진용이네 주차장에서는 종일 이용권만을 판매하기 때문에 이용시간은 고려하지 않는다.
	
	진용이는 오늘 주차장을 이용할 m 대의 차량들이 들어오고 나가는 순서를 알고 있다.
	
	진용이의 주차장이 오늘 하루 벌어들일 총 수입을 계산하는 프로그램을 작성하라.

	
메모리
	56,500 KB
실행시간
	238 ms
	
적용 알고리즘
	완전 탐색



*/

import java.util.*;

class Solution {

	static int B[];
	static int n,m;
	static int R[];
	static int W[];
	static Queue<Integer> q;
	
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int T;
		
		
		int input;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int answer=0;
			q=new LinkedList<Integer>();
			n=sc.nextInt();
			m=sc.nextInt();
			R=new int[n];
			B=new int[n];
			W=new int[m];
			for(int i=0;i<n;i++) {
				R[i]=sc.nextInt();
			}
			for(int j=0;j<m;j++) {
				W[j]=sc.nextInt();
			}
			
			for(int k=0;k<2*m;k++) {
				input = sc.nextInt();
				if(input>0) {
					answer+=cost(input);
				}
				else {
					
					answer+=out(-input);
				}
			}
			System.out.println("#"+test_case+" "+answer);
		}
	}
	
	static public int cost(int input) {
		int cost=0;
		int flag =0;
		for(int i=0;i<n;i++) {
			if(B[i]==0) {
				B[i]=input;
				cost = R[i]*W[input-1];
				flag=1;
				break;
			}
		}
		if(flag!=1) {
			q.add(input);
		}
		
		return cost;
	}
	static public int out(int input) {
		int cost=0;
		
		for(int i=0;i<n;i++) {
			
			if(B[i]==input) {
				if(q.isEmpty()) {
					B[i]=0;
				}
				else {
					B[i]=q.poll();
					cost = R[i]*W[B[i]-1];
				}
				break;
			}
		}
		
		
		return cost;
	}

}









