package SWEA5215;
/**
����
	��� �ܹ��Ÿ� �����ϴ� �α�� �ֱ� ��½ �þ �� ������ ������ ����.

	�׷��ٰ� �ܹ��Ÿ� ������ �� ������ �α�� �ܹ����� ���� �ִ��� �����ϸ鼭 ������ Į�θ��� ���� �ʴ� �ܹ��Ÿ� �ֹ��Ͽ� �������� �Ѵ�. 

	�αⰡ �ַ� �̿��ϴ� �ܹ��� ���Կ����� ���� ���ϴ� �������� �ܹ��Ÿ� ���� �ش�.

	������ ���� �̸� ���� �غ��س��� ������ ���տ� ���� ��Ḧ �߶� ������������ �ʰ�, ��Ḧ �����ϸ� �غ��س��� ��Ḧ �״�� ����Ͽ� �������ش�. 

	�α�� �� ���Կ��� �ڽ��� �Ծ��� �ܹ����� ��ῡ ���� ���� �ڽ��� ���� ������ ���� ������ �Űܳ��Ҵ�.

	�α��� �ܹ��� ��ῡ ���� ������ ���Կ��� �����ϴ� ��ῡ ���� Į�θ��� �־����� ��,

	�αⰡ �����ϴ� �ܹ��Ÿ� �����鼭�� ���̾�Ʈ�� ������ �� �ֵ��� ������ Į�θ� ������ ���� �߿��� �αⰡ ���� ��ȣ�ϴ� �ܹ��Ÿ� �������ִ� ���α׷��� ������.

	(�� ���� ��Ḧ �����Ͽ��� �ܹ����� ��ȣ���� ���յ� ������ ���� ���� ������ ������ �����ǰ�, ���� ��Ḧ ���� �� ����� �� ������, �ܹ����� ������ ������ Į�θ��� �����ϰ�� ����.)

	
�޸�
	23,940 KB
����ð�
	212 ms
	
���� �˰���
	���� ���α׷���(DP)



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

