package 이코테;

import org.junit.jupiter.api.Test;

public class 다이나믹프로그래밍 {

    final static long[] x = new long[100];

    @Test
    void 다이나믹(){
       System.out.println(하향식(50));
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

        /* 문제
           정수 x가 주어질때 정수 x에 사용할 수 있는 연산은 4가지 이다.
           1. x가 5로 나누어 떨어진다면, 5로 나눈다
           2. x가 3으로 나누어 떨어진다면, 3으로 나눈다
           3. x가 2로 나누어 떨어진다면, 2으로 나눈다
           4. x에서 1을 뺀다.
         */

        int x = 26; // 주어진 값

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


    @Test
    void 개미전사(){
        /* 문제
           개미 전사는 부족한 식량을 충당하기 위해 메뚜기의 식량창고를 공격하려 한다.
           식량창고는 정해진 창고수를 가지며, 선택적으로 약탈 할 수 있다.
           단, 연속된 식량 창고는 발각이 되기에 연속된 창고는 약탈 할 수 없다.
           식량창고를 약탈 할 때 최대 얻을 수 있는 식량을 구하시오.
         */

        int[] d = new int[100]; // 최대 100까지 입력 받을 수 있다.
        int[] 창고 = {1,3,1,5};
        // 창고를 털어 최대값을 구할 수 있는 해
        int max = 0;

        d[0] = 0;
        d[1] = Math.max(창고[0], 창고[1]); // 두번째 인덱스 배열에 0번째와 첫번째 배열 중 큰값 입력

        // 2번째 인덱스 부터 시작(보텀업 방식)
        // 루프를 돌며 값이 저장된 d[i-1] 와 d[i-2] + 창고[i]를 비교 후 큰값을 담는다.
        for(int i=2; i<창고.length; ++i){
            d[i] = Math.max(d[i-1], d[i-2] + 창고[i]);
        }

        // 0번 인덱스 부터 시작 하기에 -1처리 해
        System.out.println(d[창고.length-1]);
    }

    @Test
    void 바닥_공사(){
        /* 문제
           가로이 길이가 N, 세로의 길이가 2인 직사각형 형태의 얇은 바닥이 존재 한다.
           이 얇은 바닥을 1 x 2의 덮개, 2 x 1의 덮개, 2 x 2의 덮개를 이용해 채우고자 한다.
           이때 바닥을 채우는 모든 경우의 수를 구하는 프로그램을 작성 하시오
           (바닥을 채우는 방법의 수를 796,796으로 나눈 나머지를 출력 한다.)
        */

        int[] d = new int[1001]; // 계산값을 저장할 DP 테이블 초기화
        int n = 3; // 임의의 입력값 셋팅

        // 보텀업 방식
        d[1] = 1;
        d[2] = 3;
        for (int i = 3; i <= n; i++) {
            d[i] = (d[i - 1] + 2 * d[i - 2]) % 796796;
        }

        // 계산된 결과 출력
        System.out.println(d[n]);
    }

}
