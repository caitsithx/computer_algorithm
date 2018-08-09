package zr.pagepath;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

class LogItem {
   String user;
   String page;

   public LogItem(String user, String page) {
      this.user = user;
      this.page = page;
   }

   public String getUser() {
      return user;
   }

   public void setUser(String user) {
      this.user = user;
   }

   public String getPage() {
      return page;
   }

   public void setPage(String page) {
      this.page = page;
   }
}

public class Solution {
   public final static Map<String, Integer> DICT = new HashMap<>(4);

   static {
      DICT.put("/", 0);
      DICT.put("/login", 1);
      DICT.put("/product", 2);
   }




   public Map<String, List<Integer>> process(Stream<LogItem> logItems) {
      return logItems.collect(
            Collectors.groupingBy(LogItem::getUser,
                  Collectors.mapping(item -> DICT.get(item.getPage()), Collectors.toList())));
   }

   @Test
   public void test1() {
      List<LogItem> items = new ArrayList<>();
      items.add(new LogItem("u1", "/"));
      items.add(new LogItem("u1", "/login"));
      items.add(new LogItem("u2", "/product"));
      items.add(new LogItem("u3", "/"));
      Map<String, List<Integer>> result = process(items.stream());
      System.out.println();
   }

   private final Set<String> users = new HashSet<>();

   public void step0(String dataFile) {
      Map<String, List<Integer>> step0Results = null;
      try (BufferedReader reader = new BufferedReader(new FileReader(dataFile))) {
         step0Results = process(reader.lines().map(line -> {
            String[] words = line.split(",");
            return new LogItem(words[0], words[1]);
         }).parallel());
      } catch (IOException e) {
         System.out.println("failed reading: " + dataFile);
      }

      if (step0Results != null && !step0Results.isEmpty()) {
         try (BufferedWriter writer = new BufferedWriter(new FileWriter(dataFile + ".step0"))) {
            step0Results.entrySet().stream()
                  .map(entry -> entry.getKey() + ","
                        + entry.getValue().stream().map(Object::toString).collect(Collectors.joining("/")))
                  .forEach(lineStr -> {
                     try {
                        writer.write(lineStr);
                        writer.newLine();
                     } catch (IOException e) {
                        e.printStackTrace();
                     }
                  });

            synchronized (users) {
               users.addAll(step0Results.keySet());
            }
         } catch (IOException e) {
            System.out.println("failed reading: " + dataFile);
         }
      }
   }

   public void main(String[] args) {
      String[] dataFiles = args[0].split(",");
      Arrays.stream(dataFiles).parallel().forEach(this::step0);
   }
}
