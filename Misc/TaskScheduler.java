import java.util.*;

public class TaskScheduler {
    public static void main(String[] args) {
        TaskScheduler t = new TaskScheduler();
        System.out.println(t.compute("ababcacb".toCharArray(), 2));
        //ab_abca_cb
        System.out.println(t.compute("abbacacb".toCharArray(), 3));
        //ab___bac__acb
    }
    public int compute(char[] tasks, int n) {
        int time = 0;
        int[] map = new int[256];
        for (char c : tasks) {
            if (time < map[c]) time = map[c];
            map[c] = time + n + 1;
            time++;
        }
        return time;
    }
}
