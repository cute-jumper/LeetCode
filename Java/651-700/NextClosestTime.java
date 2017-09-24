class NextClosestTime {
    static class Time {
        int h, m;
        boolean[] shown = new boolean[256];
        Time(String t) {
            String[] ts = t.split(":");
            h = Integer.parseInt(ts[0]);
            m = Integer.parseInt(ts[1]);
            for (char c : t.toCharArray()) shown[c] = true;
        }
        void inc() {
            if (m++ == 59) {
                m = 0;
                if (h++ == 23) h = 0;
            }
        }
        boolean isValid() {
            String s = toString();
            for (char c : s.toCharArray()) {
                if (!shown[c]) return false;
            }
            return true;
        }
        @Override
        public String toString() {
            return String.format("%02d:%02d", h, m);
        }
    }
    public String nextClosestTime(String time) {
        Time t = new Time(time);
        do {
            t.inc();
        } while (!t.isValid());
        return t.toString();
    }
}
