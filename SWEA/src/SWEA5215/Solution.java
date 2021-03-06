package SWEA5215;
/**
문제
	평소 햄버거를 좋아하던 민기는 최근 부쩍 늘어난 살 때문에 걱정이 많다.

	그렇다고 햄버거를 포기할 수 없었던 민기는 햄버거의 맛은 최대한 유지하면서 정해진 칼로리를 넘지 않는 햄버거를 주문하여 먹으려고 한다. 

	민기가 주로 이용하는 햄버거 가게에서는 고객이 원하는 조합으로 햄버거를 만들어서 준다.

	하지만 재료는 미리 만들어서 준비해놓기 때문에 조합에 들어가는 재료를 잘라서 조합해주지는 않고, 재료를 선택하면 준비해놓은 재료를 그대로 사용하여 조합해준다. 

	민기는 이 가게에서 자신이 먹었던 햄버거의 재료에 대한 맛을 자신의 오랜 경험을 통해 점수를 매겨놓았다.

	민기의 햄버거 재료에 대한 점수와 가게에서 제공하는 재료에 대한 칼로리가 주어졌을 때,

	민기가 좋아하는 햄버거를 먹으면서도 다이어트에 성공할 수 있도록 정해진 칼로리 이하의 조합 중에서 민기가 가장 선호하는 햄버거를 조합해주는 프로그램을 만들어보자.

	(단 여러 재료를 조합하였을 햄버거의 선호도는 조합된 재료들의 맛에 대한 점수의 합으로 결정되고, 같은 재료를 여러 번 사용할 수 없으며, 햄버거의 조합의 제한은 칼로리를 제외하고는 없다.)

	
메모리
	23,940 KB
실행시간
	212 ms
	
적용 알고리즘
	동적 프로그래밍(DP)



*/


import java.util.Scanner;


class Solution
{
  static int answer;

  public static void main(String args[])
  {

      Scanner sc = new Scanner(System.in);
      int T=sc.nextInt();;
      for(int test_case = 1; test_case <= T; test_case++)
      {
          answer=0;
          int N = sc.nextInt();
          int L = sc.nextInt();
          int[][] food = new int[N][2];
          int[] memory = new int[N];
          for(int i=0;i<N;i++) {
              food[i][0]=sc.nextInt();
              food[i][1]=sc.nextInt();
          }
          answer=cal(food,L,0,0);
          System.out.println("#"+test_case+" "+answer);

      } // end of for testCase
  } // end of main
   
  public static int cal(int[][] food, int L, int sum,int index) {
      if(sum>=L||index>=food.length) {
          return 0;
      }
      else {
          if(sum+food[index][1]<=L) {
              return Math.max(cal(food,L,sum,index+1), cal(food,L,sum+food[index][1],index+1)+food[index][0]);    
          }
          else {
              return cal(food,L,sum,index+1);
          }

      }
  }
   
}

