package org.example;

import java.util.*;

public class GraphAlgorithms {
    static class Edge {
        int target, weight;

        public Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    // Dijkstra's Algorithm for shortest path
    public static void dijkstra(List<List<Edge>> graph, int source) {
        int n = graph.size();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{source, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            for (Edge edge : graph.get(node)) {
                int newDist = dist[node] + edge.weight;
                if (newDist < dist[edge.target]) {
                    dist[edge.target] = newDist;
                    pq.offer(new int[]{edge.target, newDist});
                }
            }
        }

        System.out.println("Dijkstra's Algorithm - Shortest distances:");
        for (int i = 0; i < n; i++) {
            System.out.println("To " + i + ": " + (dist[i] == Integer.MAX_VALUE ? "Infinity" : dist[i]));
        }
    }

    // Prim's Algorithm for Minimum Spanning Tree
    public static void prim(List<List<Edge>> graph) {
        int n = graph.size();
        boolean[] inMST = new boolean[n];
        int[] key = new int[n];
        int[] parent = new int[n];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            inMST[node] = true;
            for (Edge edge : graph.get(node)) {
                if (!inMST[edge.target] && edge.weight < key[edge.target]) {
                    parent[edge.target] = node;
                    key[edge.target] = edge.weight;
                    pq.offer(new int[]{edge.target, edge.weight});
                }
            }
        }

        System.out.println("Prim's Algorithm - Minimum Spanning Tree:");
        for (int i = 1; i < n; i++) {
            System.out.println("Edge: " + parent[i] + " - " + i + " Weight: " + key[i]);
        }
    }

    public static void main(String[] args) {
        int nodes = 6;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < nodes; i++) graph.add(new ArrayList<>());

        // Define graph edges
        graph.get(0).add(new Edge(1, 4));
        graph.get(0).add(new Edge(2, 1));
        graph.get(1).add(new Edge(3, 1));
        graph.get(2).add(new Edge(1, 2));
        graph.get(2).add(new Edge(3, 5));
        graph.get(3).add(new Edge(4, 3));
        graph.get(4).add(new Edge(5, 2));

        System.out.println("Running Dijkstra's Algorithm:");
        dijkstra(graph, 0);

        System.out.println("\nRunning Prim's Algorithm:");
        prim(graph);
    }
}
