package SWEA1204;
/**
문제
	어느 고등학교에서 실시한 1000명의 수학 성적을 토대로 통계 자료를 만들려고 한다.

	이때, 이 학교에서는 최빈수를 이용하여 학생들의 평균 수준을 짐작하는데, 여기서 최빈수는 특정 자료에서 가장 여러 번 나타나는 값을 의미한다.
	
	다음과 같은 수 분포가 있으면,
	
	10, 8, 7, 2, 2, 4, 8, 8, 8, 9, 5, 5, 3
	
	최빈수는 8이 된다.
	
	최빈수를 출력하는 프로그램을 작성하여라 (단, 최빈수가 여러 개 일 때에는 가장 큰 점수를 출력하라).

메모리
	34,068 KB
실행시간
	187 ms
	
적용 알고리즘
	완전 탐색



*/

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;


class Solution
{
	static int answer;
	static int[] memory;

	public static void main(String args[])
	{

		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		HashMap<Integer, Integer> hash;
		int[] arr;
		int max=0;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			answer=0;
			max=0;
			int t= sc.nextInt();
			
			hash = new HashMap<Integer, Integer>();
			
			arr = new int[1000];


			for(int i=0;i<1000;i++) {
				arr[i]=sc.nextInt();
				hash.put(arr[i], hash.getOrDefault(arr[i], 0)+1);
			}
			
			Set<Integer> key = hash.keySet();
			for(int i:key) {
				//System.out.println(i+" : "+hash.get(i));
				if(hash.get(i)>=max) {
					if(i>answer) {
						max=hash.get(i);
						answer=i;
					}

				}
			}



			System.out.println("#"+test_case+" "+answer);

		} // end of for testCase
	} // end of main




}
