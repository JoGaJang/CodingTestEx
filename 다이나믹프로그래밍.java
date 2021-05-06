package 이코테;

import org.junit.jupiter.api.Test;

public class 다이나믹프로그래밍 {

    final static long[] x = new long[100];

    @Test
    void 다이나믹(){
       //System.out.println(하향식(50));
       System.out.println(상향식());

    }

    static long 하향식(int n){

        if(n == 1 || n == 2){
            return 1;
        }

        if(x[n] != 0){
            return x[n];
        }

        x[n] = 하향식(n - 1) + 하향식(n - 2);
        return x[n];
    }

    static long 상향식(){

        x[1] = 1;
        x[2] = 1;
        int n = 50;

        for(int i=3; i <= n; ++i){
            x[i] = x[i - 1] + x[i - 2];
        }

        return x[n];
    }

    final static int[] k = new int[30001];

    @Test
    void 일로_만들기(){

        int x = 26;

        for(int i = 2; i <= x; ++i){
           // 현재의 수에서 1을 뺀 값
           k[i] = k[i - 1] + 1;

           if(i % 2 == 0)
               k[i] = Math.min(k[i], k[i / 2] + 1);

            if(i % 3 == 0)
                k[i] = Math.min(k[i], k[i / 3] + 1);

            if(i % 5 == 0)
                k[i] = Math.min(k[i], k[i / 5] + 1);
        }

        System.out.println(k[x]);
    }

}
