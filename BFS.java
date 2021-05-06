package 이코테;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    boolean[] visited = new boolean[9];
    ArrayList<ArrayList<Integer>> graph =  new ArrayList<>();

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

        bfs(1);
    }

    void bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);

        // 파라미터로 넘어온 노드를 방문 처리
        // 재귀 호출방식이 아니기에 1번 노드를 먼저 방문처리 한다.
        visited[x] = true;

        // 큐가 빌때까지 반복 처리
        while(!q.isEmpty()){
            // q에 들어 있는 노드값을 꺼낸다.
            int k = q.poll();
            System.out.print(k + " ");

            // 해당 노드와 연결된, 아직 방문하지 않은 노드들을 큐에 삽입
            for(int i = 0; i < graph.get(k).size(); ++i) {
                int y = graph.get(k).get(i);
                if(!visited[y]) {
                    // 큐에 담고 방문처리
                    q.offer(y);
                    visited[y] = true;
                }
            }
        }
    }

    public int n = 5, m = 6;
    public int[][] graph_미로 = {{1,0,1,0,1,0}, {1,1,1,1,1,1}, {0,0,0,0,0,1}, {1,1,1,1,1,1}, {1,1,1,1,1,1}};

    // 이동할 네 가지 방향 정의 (상, 하, 좌, 우)
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};

    @Test
    void 미로탈출(){
        System.out.println(bfs미로(0, 0));
    }

    int bfs미로(int x, int y){

        // 큐(Queue) 구현을 위해 queue 라이브러리 사용
        Queue<Node> q = new LinkedList<>();

        // 최초 진입 시 큐에 초기값 셋팅
        q.offer(new Node(x, y));

        // 큐가 빌 때까지 반복하기
        while(!q.isEmpty()) {
            Node node = q.poll();
            x = node.getX();
            y = node.getY();
            // 현재 위치에서 4가지 방향으로의 위치 확인
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 미로 찾기 공간을 벗어난 경우 무시
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                // 벽인 경우 무시
                if (graph_미로[nx][ny] == 0) continue;
                // 해당 노드를 처음 방문하는 경우에만 최단 거리 기록
                if (graph_미로[nx][ny] == 1) {
                    graph_미로[nx][ny] = graph_미로[x][y] + 1;
                    q.offer(new Node(nx, ny));
                }
            }
        }
        // 가장 오른쪽 아래까지의 최단 거리 반환
        return graph_미로[n - 1][m - 1];
    }

    public int bn = 4, bm = 6;
    public int[][] graph미로 = {{1,0,1,1,1,1},{1,0,1,0,1,0},{1,0,1,0,1,1},{1,1,1,0,1,1}};
    @Test
    void 백준_미로탈출(){
        System.out.println(백준_미로탈출ST(0,0));
    }

    int 백준_미로탈출ST(int x, int y){

        int result = 0;
        Queue<Node> q = new LinkedList<>();
        // q에 첫번째 값을 삽입
        q.offer(new Node(x,y));

        while(!q.isEmpty()){
            Node node = q.poll();

            x = node.getX();
            y = node.getY();

            // 루프를 돌며 4방향을 탐색
            for(int i=0; i<4; ++i){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= bn || ny < 0 || ny>= bm) continue;
                if(graph미로[nx][ny] == 0) continue;
                if(graph미로[nx][ny] == 1){
                    graph미로[nx][ny] = graph미로[x][y] + 1;
                    q.offer(new Node(nx,ny));
                }
            }
        }

        return graph미로[bn-1][bm-1];
    }

}

class Node {

    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}