package 이코테;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 이진탐색 {

    @Test
    void 부품찾기_Strem(){

        int[] n = {8, 3, 7, 9, 2};
        int[] m = {5, 7, 9};

        // 순서대로 부품을 1개씩 찾아 해당 부품이 존재 할 경우 yes, 없으면 no를 반환
        StringBuilder sb = new StringBuilder();

        //m의 갯수만큼 루프를 돌며 보유한 부품이 존재 하는지 체크
        for(int i=0; i<m.length; ++i){
            int val = m[i];
            sb.append(Arrays.stream(n).filter(k -> k == val).findAny().orElse(0) != 0 ? "yes " : "no ");
        }

        System.out.println(sb.toString());
    }

    @Test
    void 부품찾기_Set(){

        Set<Integer> set = new HashSet<>(Arrays.asList(8, 3, 7, 9, 2));
        int[] m = {5, 7, 9};

        // 순서대로 부품을 1개씩 찾아 해당 부품이 존재 할 경우 yes, 없으면 no를 반환
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<m.length; ++i){
            sb.append(set.contains(m[i]) ? "yes " : "no ");
        }

        System.out.println(sb.toString());
    }

    @Test
    void 떡볶이_떡_만들기(){

        int[] 떡 = {19,15,10,17};
        int m = 6;

        int result = 0;
        int start = 0;
        int end = Arrays.stream(떡).max().orElse(0);

        // 절단기 시작의 크기가 절단기 마지막의 크기가 같을때까지 loop실행
        while(start <= end){
            int bucket = 0;
            int mid = (start+end) / 2;

            // 배열 갯수만큼 중간 크기로 떡을 잘라 남은 부분을 바구니에 담는다
            for(int i=0; i<떡.length; ++i){
                if(떡[i] >= mid){
                    bucket += 떡[i] - mid;
                }
            }

            // 바구니에 담긴 떡이 부족할 경우 끝점을 당긴다
            if(bucket < m){
                end = mid - 1;
            }else{
                // 떡의 길이가 필요 이상일 경우 시작점의 위치를 조절
                result = mid;
                start = mid+1;
            }
        }
        System.out.println("result : " + result);
    }

    @Test
    void 특정수의_개수_구하기(){

        int[] 배열 = {1,1,2,2,2,3,3};
        int m = 2;
        int result = (int) Arrays.stream(배열).filter(n -> m==n).count();

        if(result < 1)
            result = -1;

        System.out.println("result : " + result);
    }
}
