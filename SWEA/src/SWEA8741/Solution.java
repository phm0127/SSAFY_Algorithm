package SWEA8741;
/**
문제

	이번 여름 휴가로 하와이를 갈 예정인 상길이는 매일 영어 단어를 외운다.
	
	똑똑한 상길이는 이전에 외운 단어는 단어의 앞글자만 보면 다시 기억해낼 수 있다.
	
	상길이는 자신이 외운 영어 단어를 까먹을 때를 대비해서 단어의 앞글자를 따와 대문자로 적어 놓으려고 한다.
	
	상길이를 도와 세 단어의 앞글자를 따와서 대문자로 바꾸는 프로그램을 작성해보자.
	
	예를 들어 “knuth morris pratt”은 “KMP”로 바뀐다.
		
메모리
	21,864 KB
실행시간
	155 ms
	
적용 알고리즘
	없음.
	이런 문제 유형은 String 보다는 StringBuilder나 StringBuffer을 사용하는 것이 좋다.



*/

import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner scan = new Scanner(System.in);
		
		int T= scan.nextInt();
		String str;
		StringBuilder sb;
		String answer="";
		String[] ans = new String[T];
		
		for(int i=0;i<T;i++) {
			answer="";
			str=scan.next();
			sb= new StringBuilder(str);
			answer+=sb.charAt(0);
			str=scan.next();
			sb= new StringBuilder(str);
			answer+=sb.charAt(0);
			str=scan.next();
			sb= new StringBuilder(str);
			answer+=sb.charAt(0);
			
			answer=answer.toUpperCase();
			ans[i]=answer;
			
		}
		for (int i=0;i<T;i++) {
			System.out.println("#"+(i+1)+" "+ans[i]);
		}

		
	}
}
