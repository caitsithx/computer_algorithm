package hackerrank.algorithms.graphs.breadth_first_search;


import java.util.*;

class Graph {
   private Map<String, Set<String>> vertexAndNeighbors = new HashMap<>();

   public void addVertex(String v) {
      if (!vertexAndNeighbors.containsKey(v)) {
         vertexAndNeighbors.put(v, new HashSet<>());
      }
   }

   public void addEdge(String v, String w) {
      addVertex(v);

      vertexAndNeighbors.get(v).add(w);

      addVertex(w);

      vertexAndNeighbors.get(w).add(v);
   }

   public int numberOfVertices() {
      return vertexAndNeighbors.size();
   }

   public Set<String> neighborsOf(String v) {
      return vertexAndNeighbors.get(v);
   }

   public Set<String> vertices() {
      return vertexAndNeighbors.keySet();
   }

   public int numOfNeighbors(String v) {
      return neighborsOf(v).size();
   }

   public boolean hasVertex(String v) {
      return vertexAndNeighbors.containsKey(v);
   }

   public boolean hasEdge(String v, String w) {
      if (hasVertex(v)) {
         return vertexAndNeighbors.get(v).contains(w);
      }

      return false;
   }

}

public class Solution {

   /* Tail starts here */
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int caseCount = in.nextInt();
      for (int caseIndex = 0; caseIndex < caseCount; caseIndex++) {
         start = null;
         visited.clear();
         distances.clear();
         graph = null;
         int vertexCount = in.nextInt();
         int edgeCount = in.nextInt();
         graph = new Graph();
         for (int i = 1; i <= vertexCount; i++) {
            graph.addVertex(Integer.toString(i));
         }

         for (int edgeIndex = 0; edgeIndex < edgeCount; edgeIndex++) {
            graph.addEdge(
                  Integer.toString(in.nextInt()),
                  Integer.toString(in.nextInt())
            );
         }

         start = Integer.toString(in.nextInt());
         visited.add(start);
         visit(graph.neighborsOf(start), 1);

         List<Integer> shortests = new ArrayList<>();
         for (int i = 1; i <= vertexCount; i++) {
            if (Integer.parseInt(start) == i) {
               continue;
            }

            String key = start + "-" + i;
            shortests.add(distances.get(key));
         }


         printArray(shortests.stream().mapToInt(intg -> {
            if(intg == null) {
               return -1;
            } else {
               return intg * 6;
            }
         }).toArray());
      }
   }

   private static String start = null;
   private static Map<String, Integer> distances = new HashMap<>();
   private static Set<String> visited = new HashSet<>();
   private static Graph graph;


   private static void visit(Set<String> vertices, int distance) {
      Set<String> nextLevels = new HashSet<>();
      for(String vertex : vertices) {
         if(visited.contains(vertex)) {
            continue;
         }
         visited.add(vertex);

         String key = start + "-" + vertex;
         if(distances.containsKey(key)) {
            if(distances.get(key) > distance) {
               distances.put(key, distance);
            }
         } else {
            distances.put(key, distance);
         }

         nextLevels.addAll(graph.neighborsOf(vertex));
      }

      if(!nextLevels.isEmpty()) {
         visit(nextLevels, distance + 1);
      }
   }


   private static void printArray(int[] ar) {
      for (int n : ar) {
         System.out.print(n + " ");
      }
      System.out.println("");
   }


}
