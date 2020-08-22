package leetcode.hard;

import static java.util.Arrays.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JudgePoint24 {
    static List<String> buffer = new ArrayList<>();
    public static void main(String[] args) {
        int[] ints = new int[]{4,1,8,7};

        System.out.println(new JudgePoint24().judgePoint24(ints));
    }


    public boolean judgePoint24(int[] nums) {
        List<Double> current = stream(nums).mapToDouble(value -> (double) value).boxed().collect(Collectors.toList());

        return judge(current);
    }

    public boolean judge(List<Double> numbers) {
        if (numbers == null || numbers.size() == 0) {
            return false;
        }

        if (numbers.size() == 1) {
            System.out.println(numbers.get(0));
            return Math.abs(numbers.get(0) - 24) < 0.000001;
        }

        for (int i = 0; i < numbers.size(); i++) {
            double x = numbers.get(i);

            for (int j = 0; j < numbers.size(); j++) {
                double y = numbers.get(j);
                if(i == j) {
                    continue;
                }

                final List<Double> newNumbers = new ArrayList<>();
                for (int k = 0; k < numbers.size(); k++) {
                    if (k == i || k == j) {
                        continue;
                    }

                    newNumbers.add(numbers.get(k));
                }

                newNumbers.add(x + y);
                if (judge(newNumbers)) {
                    return true;
                }
                newNumbers.remove(newNumbers.size() - 1);


                newNumbers.add(x - y);
                if (judge(newNumbers)) {
                    return true;
                }
                newNumbers.remove(newNumbers.size() - 1);


                newNumbers.add(x * y);
                if (judge(newNumbers)) {
                    return true;
                }
                newNumbers.remove(newNumbers.size() - 1);


                newNumbers.add(x / y);
                if (judge(newNumbers)) {
                    return true;
                }

                newNumbers.remove(newNumbers.size() - 1);
            }
        }
        return false;
    }
}
