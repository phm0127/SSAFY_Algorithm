package SWEA8658;
/**
문제

	의석이는 종강 기념 피자 파티를 열기 위해서 피자를 사러 왔다.
	
	하지만 피자 가게 주인 동욱이는 피자를 순순히 판매하지 않는 사람이다.
	
	돈 보다 문제 내는 것을 더 좋아하는 이상한 동욱이는 피자를 사러 온 의석이에게 3개의 시련을 부여했고, 모두 통과해야만 거래를 시작한다.
	
	첫 번째 관문에서는 10개의 자연수가 주어진다.
	
	각 수마다 그 수의 각 자리 수를 다 더한 값을 계산해야 한다.
	
	예를 들어서 주어진 수 중에 1203이 있다면 이 수의 각 자리 수를 모두 더하면 1 + 2 + 0 + 3 = 6이 된다.
	
	의석이는 동욱이에게 받은 10개의 숫자들 중, 위와 같이 변환했을 때의 최대, 최소값을 대답해야만 한다.
	
	의석이를 도와서 관문 1의 정답을 구하는 프로그램을 작성하라.
	
메모리
	20,308 KB
실행시간
	140 ms
	
적용 알고리즘
	완전 탐색



*/
import java.util.Scanner;

class Solution
{
	static int max;
	static int min;

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int T= scan.nextInt();
		int[] arr = new int[10];
		
		
		for(int i=0;i<T;i++) {
			min=987654321;
			max=0;
			for(int j=0;j<10;j++) {
				arr[j]= scan.nextInt();
			}
			
			cal(arr);
			System.out.println("#"+(i+1)+" "+max+" "+min);
		}
		
		
	}
	
	public static void cal(int[] arr){
		int sum;
		for(int i=0;i<10;i++) {
			sum=0;
			while(true) {
				sum+=arr[i]%10;
				if(arr[i]<10) {
					break;
				}
				arr[i]/=10;
			}
			max=Math.max(max, sum);
			min=Math.min(min, sum);
		}
	}
}