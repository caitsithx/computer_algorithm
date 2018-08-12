package zr.pagepath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class SingleMachinedSolution {
   public final static int N = 3;
   private final Map<String, List<Integer>> users = new HashMap<>();
   private final Map<String, Integer> pathRanking = new HashMap<>();


   public void process(List<LogItem> logItems) {
      logItems.forEach(item -> {
         if (!users.containsKey(item.getUser())) {
            users.put(item.getUser(), new ArrayList<>());
         }
         List<Integer> pathList = users.get(item.getUser());

         int newPageIndex = Solution.DICT.get(item.getPage());
         pathList.add(newPageIndex);
         if (pathList.size() >= N) {
            String path =
                  pathList.stream().skip(pathList.size() - 3).map(Object::toString).collect(Collectors.joining());
            int newCount = 1;
            if (pathRanking.containsKey(path)) {
               newCount = pathRanking.get(path) + 1;
            }
            pathRanking.put(path, newCount);
         }
      });

//      logItems.stream().collect(Collectors.groupingBy(LogItem::getUser,
//            Collectors.mapping(LogItem::getPage, Collectors.toList())));

//      logItems.stream().sorted(Comparator.comparing(LogItem::getPage)).limit(3);
   }

   @Test
   public void test1() {
      List<LogItem> items = new ArrayList<>();
      items.add(new LogItem("u1", "/"));
      items.add(new LogItem("u1", "/login"));
      items.add(new LogItem("u1", "/product"));
      items.add(new LogItem("u2", "/"));
      items.add(new LogItem("u2", "/login"));
      items.add(new LogItem("u2", "/product"));
      items.add(new LogItem("u3", "/"));
      items.add(new LogItem("u3", "/login"));
      items.add(new LogItem("u3", "/product"));
      items.add(new LogItem("u3", "/"));

      process(items);
      System.out.println();
   }
}
