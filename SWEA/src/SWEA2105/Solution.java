package SWEA2105;
/**
문제
	https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5VwAr6APYDFAWu&categoryId=AV5VwAr6APYDFAWu&categoryType=CODE
	
메모리
	64,524 KB
실행시간
	502 ms
	
적용 알고리즘
	시뮬레이션 (백트레킹)

*/

import java.util.HashMap;
import java.util.Scanner;
 
public class Solution {
 
    static int[] dR= {-1,-1,1,1};
    static int[] dC= {-1,1,-1,1};
     
    static int answer;
    static HashMap<Integer, Boolean> hash;
    static int[][] map;
    static int N;
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T= sc.nextInt();
         
        for(int t=1;t<=T;t++){
            answer=-1;
            N = sc.nextInt();
            map = new int[N][N];
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    map[i][j]=sc.nextInt();
                }
            }
             
             
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    hash = new HashMap<Integer,Boolean>();
                    boolean[] b=new boolean[4];
                    b[0]=true;
                    go(1,i,j,b,0,i,j);
                     
                }
            }
             
             
            System.out.println("#"+t+" "+answer );
        }
    }
     
    static void go(int count,int r, int c, boolean[] b,int d,int startR, int startC) {
        r+=dR[d];
        c+=dC[d];
        if(r<0||c<0||r>N-1||c>N-1) {
             
        }
        else if(hash.getOrDefault(map[r][c], false)) {
             
        }
        else if(r==startR&&c==startC&&count>=4) {
            answer=Math.max(answer, count);
        }
        else {
            hash.put(map[r][c], true);
            for(int i=0;i<4;i++) {
                if(i==d) {
                    go(count+1,r,c,b,d,startR,startC);
                }
                else if(!b[i]) {
                    b[i]=true;
                    go(count+1,r,c,b,i,startR,startC);
                    b[i]=false;
                }
            }
            hash.put(map[r][c], false);
        }
    }
 
}
