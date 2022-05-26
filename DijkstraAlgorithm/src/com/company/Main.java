package com.company;

import java.util.Arrays;

public class Main {
    static int[][] e;
    static int[] dist;

    public static void main(String[] args) {
        e = new int[][]{
                {0, 1, 12, -1, -1, -1},
                {-1, 0, 9, 3, -1, -1},
                {-1, -1, 0, -1, 5, -1},
                {-1, -1, 4, 0, 13, 15},
                {-1, -1, -1, -1, 0, 4},
                {-1, -1, -1, -1, -1, 0},
        };

        dist = e[0];

        dijkstra(0, 0);

        System.out.println(Arrays.toString(dist));
    }

    private static void dijkstra(int temp, int cost) {
        if (dist[temp] > cost || dist[temp] == -1) {
            dist[temp] = cost;
        }

        for (int i = 0; i < e.length; i++) {
            if (e[temp][i] > 0) {
                dijkstra(i, cost + e[temp][i]);
            }
        }
    }
}
