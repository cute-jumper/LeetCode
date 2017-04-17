public class IPO {
    static class Project implements Comparable<Project> {
        int profit;
        int capital;
        public Project(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
        @Override
        public int compareTo(Project that) {
            return this.capital - that.capital;
        }
    }
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        Project[] projects = new Project[Profits.length];
        for (int i = 0; i < projects.length; i++) {
            projects[i] = new Project(Profits[i], Capital[i]);
        }
        PriorityQueue<Project> pq = new PriorityQueue<>(projects.length, new Comparator<Project>() {
            @Override
            public int compare(Project a, Project b) {
                return b.profit - a.profit;
            }
            });
        Arrays.sort(projects);
        int index = 0;
        while (k > 0) {
            while (index < projects.length && projects[index].capital <= W) {
                pq.add(projects[index++]);
            }
            if (pq.isEmpty()) break;
            k--;
            Project p = pq.poll();
            W += p.profit;
        }
        return W;
    }
}
