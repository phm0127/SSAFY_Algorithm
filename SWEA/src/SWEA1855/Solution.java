package SWEA1855;
/**
문제
미해결!

	영준이는 루트가 있는 트리에서 BFS(Breadth First Search)를 하려고 한다.
	
	트리는 1에서 N까지의 번호가 붙은 N개의 노드로 이루어져 있으며, 1이 루트이자 동시에 탐색 시작점이다.
	
	BFS는 큐를 이용하여 탐색을 하는데, 큐의 가장 앞에 있는 노드를 뽑아 탐색을 하고, 탐색을 하는 노드의 자식들을 작은 번호부터 순서대로 큐의 뒤쪽에 넣는 방식으로 탐색이 진행된다.
	
	이것은 컴퓨터에서 실제로 진행되는 방식이 아니고 영준이가 직접 노드를 방문해야 하기 때문에, BFS를 한다면 노드를 방문하는 순서가 정해질 것이고 영준이는 그 순서를 따라 최단거리로 트리를 이동하여 모든 노드를 탐색한다.
	
	영준이는 과연 몇 개의 간선을 지나고 나서야 탐색을 끝 마칠 수 있을까?
	
메모리
	 KB
실행시간
	 ms
	
적용 알고리즘
	



*/
import java.util.*;
//import java.math.*;






class Solution {

	static long answer=0;
	//static HashMap<Integer,Integer> tree;
	//static Queue<Integer> Q;
	

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int T;
		//show(10000);

		T=sc.nextInt();
		int N;
		int[] P;
		int[] Pa;

		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */

		for(int test_case = 1; test_case <= T; test_case++)
		{
			answer=0;
			//tree = new HashMap<Integer,Integer>();
			//Q=new LinkedList<Integer>();

			N=sc.nextInt();
			P=new int[N];
			Pa=new int[N];

			//tree.put(0, 0);
			//System.out.println(Pa[124]);
			Pa[0]=0;
			P[0]=0;
			for(int i=1;i<N;i++) {
				P[i] = sc.nextInt()-1;
				//tree.put(i, (tree.get(P[i]))+1);
				
				Pa[i]=Pa[P[i]]+1;
			}
			enQueue(N,P,0,0,0,Pa);
			//answer=dfs(0,P);

			System.out.println("#"+test_case+" "+answer);
		}
	}

	static void enQueue(int N, int[] P, int count,int level,int x,int[] Pa) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		if(count<N-1) {
			for(int i=1;i<N;i++) {
				if(Pa[i]==level) {
					arr.add(i);
					count++;
					//					Q.add(i);
				}
			}
			Collections.sort(arr, new Comparator<Integer>() {
				@Override
				public int compare(Integer a, Integer b) {
					// TODO Auto-generated method stub
					Integer x= (Integer)P[a];
					Integer y= (Integer)P[b];
					return x.compareTo(y);
				}
			});
			for(int k=0;k< arr.size();k++) {
				//Q.add(arr.get(k));
				answer+=cal(x,arr.get(k),P,Pa);
				x=arr.get(k);
			}

			if(count<N-1) {
				enQueue(N,P,count,level+1,x,Pa);
			}
		}
	}

//	static long dfs(int x, int[] P) {
//		long dist;
//		if(Q.isEmpty()) {
//			return 0;
//		}
//		else {
//			int temp = Q.poll();
//			return 0;//cal(x,temp,P)+dfs(temp,P);
//		}
//
//
//	}

	static long cal(int x, int y,int[] P,int[] Pa) {
		long dist=0;
		int[] A,B;

//		int depX=tree.get(x)+1;
//		int depY=tree.get(y)+1;
		int depX=Pa[x]+1;
		int depY=Pa[y]+1;

		A=new int[depX];
		B=new int[depY];

		A[0]=x;
		B[0]=y;

		for(int i=1;i<A.length;i++) {
			A[i]=P[A[i-1]];
		}
		for(int i=1;i<B.length;i++) {
			B[i]=P[B[i-1]];
		}

		boolean flag=true;
//		for(int i=0; i< depX;i++) {
//			System.out.println("A["+i+"] : "+A[i]);
//		}
//		for(int i=0; i< depY;i++) {
//			System.out.println("B["+i+"] : "+B[i]);
//		}
//		System.out.println("-----");
		

		int j=0;
		while(flag) {
			if(j>=depY) {
				flag=false;
				dist=depX+depY;
			}
			else {
				for(int i=0;i<depX;i++) {
					if(A[i]==B[j]) {
						flag=false;
						dist=i+j;
					}
				}
				
			}
			
			j++;


		}


		return dist;
	}
	
	static public void show(int N) {
		//System.out.println(1);
		//System.out.println(N);
		int th=10000;
		int n=9;
		for(int i=1;i<N;i++) {
			int num=(int) (Math.random()*(i-1+(th*n))+1);
			System.out.print(num+" ");
			if((i+1)%10==0) {
				System.out.println();
			}
		}
	}



}








