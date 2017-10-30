import java.util.*;

public class Chemical {
    public Map<String, Integer> getCount(String s) {
        Map<String, Integer> map = new HashMap<>();
        char[] cs = s.toCharArray();
        Deque<Map<String, Integer>> stack = new ArrayDeque<>();
        stack.push(map);
        for (int i = 0; i < cs.length;) {
            if (cs[i] >= 'A' && cs[i] <= 'Z') {
                String name = "" + cs[i++];
                if (i < cs.length && cs[i] >= 'a' && cs[i] <= 'z') name += cs[i++];
                int num = 0;
                if (i == cs.length || cs[i] < '0' || cs[i] > '9') num = 1;
                else {
                    while (i < cs.length && cs[i] >= '0' && cs[i] <= '9') {
                        num = num * 10 + cs[i++] - '0';
                    }
                }
                map = stack.peek();
                if (map.containsKey(name)) map.put(name, map.get(name) + num);
                else map.put(name, num);
            } else if (cs[i] == '(') {
                stack.push(new HashMap<>());
                i++;
            } else if (cs[i] == ')') {
                Map<String, Integer> curr = stack.pop();
                int num = 0;
                i++;
                while (i < cs.length && cs[i] >= '0' && cs[i] <= '9') {
                    num = num * 10 + cs[i++] - '0';
                }
                map = stack.peek();
                for (String name : curr.keySet()) {
                    if (!map.containsKey(name)) map.put(name, 0);
                    map.put(name, map.get(name) + curr.get(name) * num);
                }
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        Chemical c = new Chemical();
        String s = "NaCi((Ci2)3Na2Ci)4Li";
        Map<String, Integer> map = c.getCount(s);
        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
    }
}
