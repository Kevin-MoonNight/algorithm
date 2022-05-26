package com.company;

public class Main {
    static int n = 7, m = 9;
    static int[] startVertices = new int[m], endVertices = new int[m], cost = new int[m], ind = new int[m], verticesRoot = new int[n];

    public static void main(String[] args) {
        startVertices[0] = 1;
        endVertices[0] = 2;
        cost[0] = 20;

        startVertices[1] = 1;
        endVertices[1] = 3;
        cost[1] = 40;

        startVertices[2] = 2;
        endVertices[2] = 3;
        cost[2] = 70;

        startVertices[3] = 2;
        endVertices[3] = 6;
        cost[3] = 10;

        startVertices[4] = 2;
        endVertices[4] = 5;
        cost[4] = 5;

        startVertices[5] = 2;
        endVertices[5] = 4;
        cost[5] = 10;

        startVertices[6] = 4;
        endVertices[6] = 5;
        cost[6] = 5;

        startVertices[7] = 5;
        endVertices[7] = 6;
        cost[7] = 80;

        startVertices[8] = 6;
        endVertices[8] = 3;
        cost[8] = 100;

        System.out.println("圖");
        for (int i = 0; i < m; i++) {
            ind[i] = i;
            System.out.println(startVertices[ind[i]] + "," + endVertices[ind[i]] + " " + cost[ind[i]]);
        }

        //sort
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                if (cost[ind[i]] > cost[ind[j]]) {
                    int temp = ind[i];
                    ind[i] = ind[j];
                    ind[j] = temp;
                }
            }
        }


        for (int i = 1; i < n; i++) {
            verticesRoot[i] = -1;
        }

        System.out.println("最小生成樹");
        kruskal();
    }

    private static void kruskal() {
        int startVertexRoot, endVertexRoot;

        for (int i = 0; i < m; i++) {
            startVertexRoot = findRoot(startVertices[ind[i]]);
            endVertexRoot = findRoot(endVertices[ind[i]]);
            if (startVertexRoot != endVertexRoot) {
                verticesRoot[endVertexRoot] = startVertexRoot;

                System.out.println(startVertices[ind[i]] + "," + endVertices[ind[i]] + " " + cost[ind[i]]);
            }
        }
    }

    private static int findRoot(int index) {
        if (verticesRoot[index] == -1) {
            return index;
        }

        return (verticesRoot[index] = findRoot(verticesRoot[index]));
    }

}