package BaekJoon16637;
/**
문제
	길이가 N인 수식이 있다. 수식은 0보다 크거나 같고, 9보다 작거나 같은 정수와 연산자(+, -, ×)로 이루어져 있다. 연산자 우선순위는 모두 동일하기 때문에, 수식을 계산할 때는 왼쪽에서부터 순서대로 계산해야 한다. 예를 들어, 3+8×7-9×2의 결과는 136이다.

	수식에 괄호를 추가하면, 괄호 안에 들어있는 식은 먼저 계산해야 한다. 단, 괄호 안에는 연산자가 하나만 들어 있어야 한다. 예를 들어, 3+8×7-9×2에 괄호를 3+(8×7)-(9×2)와 같이 추가했으면, 식의 결과는 41이 된다. 하지만, 중첩된 괄호는 사용할 수 없다.
	
	 즉, 3+((8×7)-9)×2, 3+((8×7)-(9×2))은 모두 괄호 안에 괄호가 있기 때문에, 올바른 식이 아니다.

	수식이 주어졌을 때, 괄호를 적절히 추가해 만들 수 있는 식의 결과의 최댓값을 구하는 프로그램을 작성하시오. 추가하는 괄호 개수의 제한은 없으며, 추가하지 않아도 된다.
	
메모리
	14,264 KB
실행시간
	108 ms
	
적용 알고리즘
	동적 프로그래밍(DP)

*/
import java.util.Scanner;

public class Main {
	static int N;
	static int answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		answer=Integer.MIN_VALUE;
		int[] number= new int[(N+1)/2];
		char[] operator = new char[(N-1)/2];
		String str = sc.next();
		number[0]=str.charAt(0)-48;
		
		for(int i=1;i<=(N-1)/2;i++) {
			number[i]=str.charAt(2*i)-48;
			operator[i-1]=str.charAt(2*i-1);
			
		}
		
		
		answer=calValue(number,operator,0);
		
		System.out.println(answer);
		

	}
	static void getMax(int[] num, char[] op) {
		if(num.length==1) {
			answer = Math.max(answer, num[0]);
			
		}else {
			
			for(int i=0;i<op.length;i++) {
				int[] newnum = new int[num.length-1];
				char[] newop = new char[op.length-1];
				for(int j=0;j<op.length;j++) {
					if(i>j) {
						newnum[j]=num[j];
						newop[j]=op[j];
					}
					else if(i==j) {
						newnum[j]=cal(num[i],num[i+1],op[i]);
					}
					else {
						newnum[j]=num[j+1];
						newop[j-1]=op[j];
					}
				}
				
				getMax(newnum,newop);
			}
			
		}
		
		
	}
	
	static int calValue(int[] num, char[] op, int index) {
		if(index>=op.length) {
			int ret=num[0];
			for(int i=0;i<op.length;i++) {
				
				ret=cal(ret,num[i+1],op[i]);
			}
			return ret;
		}else {
			int[] newnum = new int[num.length-1];
			char[] newop = new char[op.length-1];
			for(int j=0;j<op.length;j++) {
				
				if(index>j) {
					newnum[j]=num[j];
					newop[j]=op[j];
				}
				else if(index==j) {
					newnum[j]=cal(num[j],num[j+1],op[j]);
				}
				else {
					newnum[j]=num[j+1];
					newop[j-1]=op[j];
				}
			}
			return Math.max(calValue(num,op,index+1),calValue(newnum,newop,index+1));
		}
		
	}
	
	
	static int cal(int a, int b, char op) {
		if(op=='+') {
			return a+b;
		}
		if(op=='-') {
			return a-b;
		}
		if(op=='*') {
			return a*b;
		}
		if(op=='/') {
			return a/b;
		}
		return -1;
	}

}
