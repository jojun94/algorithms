package study;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class GraphTemplate {
    static int N; // 노드 수
    static List<Integer>[] graph; // 인접 리스트

    public static void main(String[] args) {
        N = 5; // 예시: 노드 5개
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 예시 간선 추가
        graph[1].add(2);
        graph[1].add(3);
        graph[2].add(4);
        graph[3].add(5);

        //모든 노드 한번만 방문, 중복 방문
        dfsPushVisited(1);
        dfsPopVisited(1);
        //최단 경로, 거리, 최단 횟수, 퍼지는 현상
        bfsPushVisited(1);

        //N-Queen, 순열, 조합, 부분집합, 퍼즐(스토쿠), 가지치기는 push 할 때 해야 효과적, 쓰레기를 애초에 넣지 말자
        boolean[] visited = new boolean[N + 1];
        dfsBacktrackingPath(1, new ArrayList<>(), visited);
        dfsBacktrackingNoVisited(1, new ArrayList<>());

    }

    static void dfsPushVisited(int start) {
        boolean[] visited = new boolean[N + 1];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true;

        while (!stack.isEmpty()) {
            int curr = stack.pop();
            System.out.println("Visit: " + curr);

            for (int next : graph[curr]) {
                if (!visited[next]) {
                    stack.push(next);
                    visited[next] = true; //  push할 때 마킹
                }
            }
        }
    }

    //모든 경로, 중복 허용 탐색
    static void dfsPopVisited(int start) {
        boolean[] visited = new boolean[N + 1];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int curr = stack.pop();

            if (visited[curr]) {
                continue; //  pop할 때 검사
            }
            visited[curr] = true;
            System.out.println("Visit: " + curr);

            for (int next : graph[curr]) {
                stack.push(next); //  중복이더라도 push
            }
        }
    }

    static void bfsPushVisited(int start) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            System.out.println("Visit: " + curr);

            for (int next : graph[curr]) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true; //  push할 때 마킹
                }
            }
        }
    }

    static void dfsBacktrackingPath(int curr, List<Integer> path, boolean[] visited) {
        visited[curr] = true;
        path.add(curr);

        //  도착 조건이 있다면 여기서 처리 (예: path 길이가 M 이상 등)
        System.out.println("Path: " + path);

        for (int next : graph[curr]) {
            if (!visited[next]) {
                dfsBacktrackingPath(next, path, visited);
            }
        }

        //  백트래킹 (상태 복원)
        path.remove(path.size() - 1);
        visited[curr] = false;
    }

    static void dfsBacktrackingNoVisited(int curr, List<Integer> path) {
        if (path.contains(curr)) {
            return; //  중복 방지
        }

        path.add(curr);

        //  도착 조건이 있다면 여기서 처리
        System.out.println("Path: " + path);

        for (int next : graph[curr]) {
            dfsBacktrackingNoVisited(next, path);
        }

        //  백트래킹 (상태 복원)
        path.remove(path.size() - 1);
    }
}
