package 이코테;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class DFS {

    static boolean[] visited = new boolean[9];
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    @Test
    void setGraph(){
        // 그래프 초기화
        for (int i = 0; i < 9; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // 노드 1에 연결된 노드 정보 저장
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);

        // 노드 2에 연결된 노드 정보 저장
        graph.get(2).add(1);
        graph.get(2).add(7);

        // 노드 3에 연결된 노드 정보 저장
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);

        // 노드 4에 연결된 노드 정보 저장
        graph.get(4).add(3);
        graph.get(4).add(5);

        // 노드 5에 연결된 노드 정보 저장
        graph.get(5).add(3);
        graph.get(5).add(4);

        // 노드 6에 연결된 노드 정보 저장
        graph.get(6).add(7);

        // 노드 7에 연결된 노드 정보 저장
        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);

        // 노드 8에 연결된 노드 정보 저장
        graph.get(8).add(1);
        graph.get(8).add(7);

        dfs(1);
    }

    void dfs(int x){

        // 파라미터로 넘어온 현재 노드를 방문처리
        visited[x] = true;
        System.out.print(x + " ");

        // 현재 노드에 인접한 다른 노드를 방문(재귀)
        // 그래프에 담긴 노드
        for(int i=0; i<graph.get(x).size(); ++i){
            // 그래프의 x인덱스에 인접한 노드를 꺼내어 루프를 돈다
            // 단, 현재 방법은 그래프에 담긴 값이 오름차순으로 정렬이 되어 있다 가정하에
            // 작은 값부터 순차적으로 방문하게 된다.
            int y = graph.get(x).get(i);

            // 현재 좌표의 노드를 방문하지 않았을 경우 재귀를 통해 방문과 동시에 해당 노드의 인접한
            // 다음노드를 방문 처리 한다.
            if(!visited[y]) dfs(y);
        }
    }

    int n=3, m=3; //n은 세로, m은 가로
    int[][] graph2 = {{0,0,1}, {0,1,0}, {1,0,1}};
    @Test
    void 음료수얼려먹기(){

        // 총만들수 있는 얼음덩어리는?
        int result = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(물담기_dfs(i,j)){
                    result += 1;
                }
            }
        }

        System.out.println("result : " + result);
    }

    boolean 물담기_dfs(int x, int y){
        // 현재 위치가 좌표를 벗어나지 않는지 체크
        if(x <= -1 || x >= n || y <= -1 || y >= m) {
            return false;
        }

        // 현재 위치를 아직 방문하지 않았을 경우
        if(graph2[x][y] == 0){

            graph2[x][y] = 1; // 방문처리
            물담기_dfs(x - 1, y); // 상
            물담기_dfs(x, y - 1); // 좌
            물담기_dfs(x + 1, y); // 하
            물담기_dfs(x, y + 1); // 우

            return true;
        }

        return false;
    }
}