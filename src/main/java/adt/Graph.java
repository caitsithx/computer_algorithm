/***************************************************************************
 * Copyright (c) 2016 VMware, Inc. All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ***************************************************************************/
package adt;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by xiaoliangl on 5/12/16.
 */
public class Graph {
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
      vertexAndNeighbors.get(v).add(v);
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
