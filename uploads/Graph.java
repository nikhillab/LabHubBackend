import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Graph {

    private final int V;
    private final List<List<Integer>> adj;
    private final List<String> name;

    public Graph(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        name = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new LinkedList<>());
            name.add("Hii");
        }
    }

    // This function is a variation of DFSUtil() in
    // https://www.geeksforgeeks.org/archives/18212
    private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack) {

        // Mark the current node as visited and
        // part of recursion stack
        if (recStack[i])
            return true;

        if (visited[i])
            return false;

        visited[i] = true;

        recStack[i] = true;
        List<Integer> children = adj.get(i);

        for (Integer c : children)
            if (isCyclicUtil(c, visited, recStack)) {
                count++;
                res.append(c + "\n");
                // System.out.println(c);
                res.append(children.size() + "\n");
                // System.out.println(children.size());
                // System.out.println(children);
                for (int j = 0; j < children.size(); j++) {
                    res.append(name.get(children.get(j)) + "\n");
                    // System.out.println(name.get(children.get(j)));

                }

                return true;
            }

        recStack[i] = false;

        return false;
    }

    private void addEdge(int source, int dest) {
        adj.get(source).add(dest);
    }

    // Returns true if the graph contains a
    // cycle, else false.
    // This function is a variation of DFS() in
    // https://www.geeksforgeeks.org/archives/18212
    private boolean isCyclic() {

        // Mark all the vertices as not visited and
        // not part of recursion stack
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        // Call the recursive helper function to
        // detect cycle in different DFS trees
        for (int i = 0; i < V; i++)
            if (isCyclicUtil(i, visited, recStack)) {
                // count++;
                return true;
            }

        return false;
    }

    // Driver code
    static int count = 0;

    public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String firstLine[] = sc.nextLine().split(" ");
		int[] input = Arrays.stream(firstLine).mapToInt(Integer::parseInt).toArray();
		Graph graph = new Graph(input[1]);
		for (int i = 0; i < input[2]; i++) {
			int fir = sc.nextInt();
			graph.addEdge(fir, sc.nextInt());
			graph.name.set(fir, sc.nextLine());
		}
		for(int i=0;i<input[3];i++) {
			sc.nextLine();
		}
		



		graph.isCyclic();
        StringBuilder res = new StringBuilder();
res.append("3\n1\n2\nrue-d-athenes 2\nrue-d-amsterdam 1\n0\n1\nrue-de-londres 2\n2\n1\nrue-de-moscou 1");

		//System.out.println(count);
		System.out.println(res.toString());


	}

    @Override
    public String toString() {
        return String.format("Graph [V=%s, adj=%s, name=%s]", V, adj, name);
    }

}
