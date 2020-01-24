package BaekJoon7568;

/**
����
	�츮�� ����� ��ġ�� Ű�� ������, �� �� ���� ������ ǥ���Ͽ� �� ����� �Űܺ����� �Ѵ�. � ����� �����԰� x kg�̰� Ű�� y cm��� �� ����� ��ġ�� (x,y)�� ǥ�õȴ�. �� ��� A �� B�� ��ġ�� ���� (x,y), (p,q)��� �� �� x>p �׸��� y>q �̶�� �츮�� A�� ��ġ�� B�� ��ġ���� "�� ũ��"�� ���Ѵ�. ���� ��� � A, B �� ����� ��ġ�� ���� (56,177), (45,165) ��� �Ѵٸ� A�� ��ġ�� B���� ū ���� �ȴ�. �׷��� ���� �ٸ� ��ġ���� ũ�⸦ ���� �� ���� ��쵵 �ִ�. ���� ��� �� ��� C�� D�� ��ġ�� ���� (45, 181), (55,173)�̶�� �����Դ� D�� C���� �� ���̰�, Ű�� C�� �� ũ�Ƿ�, "��ġ"�θ� �� �� C�� D�� ������ ���溸�� �� ũ�ٰ� ���� �� ����.

	N���� ���ܿ��� �� ����� ��ġ ����� �ڽź��� �� "ū ��ġ"�� ����� ���� ��������. ���� �ڽź��� �� ū ��ġ�� ����� k���̶�� �� ����� ��ġ ����� k+1�� �ȴ�. �̷��� ����� �����ϸ� ���� ��ġ ����� ���� ����� ���� ���� �����ϴ�. �Ʒ��� 5������ �̷���� ���ܿ��� �� ����� ��ġ�� �� ����� ǥ�õ� ǥ�̴�.

			�̸�	<������, Ű>	��ġ ���
			A	<55, 185>	2
			B	<58, 183>	2
			C	<88, 186>	1
			D	<60, 175>	2
			E	<46, 155>	5
	�� ǥ���� C���� �� ū ��ġ�� ����� �����Ƿ� C�� 1���� �ȴ�. �׸��� A, B, D ������ ��ġ���� ū ����� C���̹Ƿ� �̵��� ��� 2���� �ȴ�. �׸��� E���� ū ��ġ�� A, B, C, D �̷��� 4���̹Ƿ� E�� ��ġ�� 5���� �ȴ�. �� ��쿡 3��� 4���� �������� �ʴ´�. �������� �л� N���� �����Կ� Ű�� ��� �Է��� �о �� ����� ��ġ ����� ����Ͽ� ����ؾ� �Ѵ�.
	
�޸�
	14484KB
����ð�
	120ms
	
���� �˰�����
	���� Ž��
	
	
 */

import java.util.Scanner;
import java.util.Set;
import java.util.HashMap;

public class Main {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<Integer,Integer> ranking = new HashMap<Integer,Integer>();
		int N = sc.nextInt();
		int[] height = new int[N];
		int[] weight = new int[N];
		for(int i=0;i<N;i++) {
			weight[i]=sc.nextInt();
			height[i]=sc.nextInt();
			ranking.put(i,1);
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(height[i]<height[j]&&weight[i]<weight[j]) {
					ranking.replace(i, ranking.get(i)+1);
				}
			}
		}
		Set<Integer> key = ranking.keySet();
		for(int i : key) {
			System.out.print(ranking.get(i)+" ");
		}
	}
		

}
