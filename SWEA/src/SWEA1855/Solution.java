package SWEA1855;
/**
����
���ذ�!

	�����̴� ��Ʈ�� �ִ� Ʈ������ BFS(Breadth First Search)�� �Ϸ��� �Ѵ�.
	
	Ʈ���� 1���� N������ ��ȣ�� ���� N���� ���� �̷���� ������, 1�� ��Ʈ���� ���ÿ� Ž�� �������̴�.
	
	BFS�� ť�� �̿��Ͽ� Ž���� �ϴµ�, ť�� ���� �տ� �ִ� ��带 �̾� Ž���� �ϰ�, Ž���� �ϴ� ����� �ڽĵ��� ���� ��ȣ���� ������� ť�� ���ʿ� �ִ� ������� Ž���� ����ȴ�.
	
	�̰��� ��ǻ�Ϳ��� ������ ����Ǵ� ����� �ƴϰ� �����̰� ���� ��带 �湮�ؾ� �ϱ� ������, BFS�� �Ѵٸ� ��带 �湮�ϴ� ������ ������ ���̰� �����̴� �� ������ ���� �ִܰŸ��� Ʈ���� �̵��Ͽ� ��� ��带 Ž���Ѵ�.
	
	�����̴� ���� �� ���� ������ ������ ������ Ž���� �� ��ĥ �� ������?
	
�޸�
	 KB
����ð�
	 ms
	
���� �˰���
	



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
		   ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
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








