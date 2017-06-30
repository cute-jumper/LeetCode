public class Excel {
    class Cell {
        int r;
        char c;
        Cell(int r, char c) {
            this.r = r;
            this.c = c;
        }
    }
    int getIndex(Cell cell) {
        return getIndex(cell.r, cell.c);
    }
    int getIndex(int r, char c) {
        return (r - 1) * (W - 'A' + 1) + (c - 'A');
    }

    int H;
    char W;
    int[] cells;
    List<Map<Integer, Integer>> formulas = new ArrayList<>();
    List<Set<Integer>> links = new ArrayList<>();
    public Excel(int H, char W) {
        this.H = H;
        this.W = W;
        int total = H * (W - 'A' + 1);
        this.cells = new int[total];
        for (int i = 0; i < total; i++) {
            formulas.add(new HashMap<>());
            links.add(new HashSet<>());
        }
    }

    private void add(Map<Integer, Integer> map, int key) {
        if (!map.containsKey(key)) {
            map.put(key, 1);
        } else {
            map.put(key, map.get(key) + 1);
        }
    }

    private void subtract(Map<Integer, Integer> map, int key) {
        map.put(key, map.get(key) - 1);
        if (map.get(key) == 0) {
            map.remove(key);
        }
    }

    private void update(int index, int v, boolean clear) {
        Map<Integer, Integer> fs = formulas.get(index);
        if (clear && !fs.isEmpty()) {
            for (Integer i : fs.keySet()) {
                links.get(i).remove(index);
            }
            fs.clear();
        }
        Set<Integer> ls = links.get(index);
        if (!ls.isEmpty()) {
            for (Integer i : ls) {
                int diff = formulas.get(i).get(index) * (v - cells[index]);
                update(i, cells[i] + diff, false);
            }
        }
        cells[index] = v;
    }

    public void set(int r, char c, int v) {
        int index = getIndex(r, c);
        update(index, v, true);
    }

    public int get(int r, char c) {
        int index = getIndex(r, c);
        return cells[index];
    }

    public int sum(int r, char c, String[] strs) {
        int index = getIndex(r, c);
        int sumVal = 0;
        update(index, 0, true);
        Map<Integer, Integer> fs = formulas.get(index);
        for (String s : strs) {
            Cell[] ces = parseStr(s);
            if (ces.length == 1) {
                add(fs, getIndex(ces[0]));
                links.get(getIndex(ces[0])).add(index);
                sumVal += get(ces[0].r, ces[0].c);
            } else {
                for (int i = ces[0].r; i <= ces[1].r; i++) {
                    for (char j = ces[0].c; j <= ces[1].c; j++) {
                        int cellIndex = getIndex(i, j);
                        add(fs, cellIndex);
                        links.get(cellIndex).add(index);
                        sumVal += get(i, j);
                    }
                }
            }
        }
        update(index, sumVal, false);
        return sumVal;
    }
    Cell[] parseStr(String s) {
        if (s.indexOf(':') != -1) {
            String[] ps = s.split(":");
            return new Cell[] { parseStr(ps[0])[0], parseStr(ps[1])[0] };
        }
        return new Cell[] { new Cell(Integer.parseInt(s.substring(1)), s.charAt(0)) };
    }
}

/**
 * Your Excel object will be instantiated and called as such:
 * Excel obj = new Excel(H, W);
 * obj.set(r,c,v);
 * int param_2 = obj.get(r,c);
 * int param_3 = obj.sum(r,c,strs);
 */
