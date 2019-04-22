package unionfind;

public class UnionFind {
    private int size;
    private int componentNum;
    private int[] sizes;
    private int[] ids;

    // size > 0
    public UnionFind (int size) {
        sizes = new int[size];
        ids = new int[size];
        this.size = size;
        this.componentNum = size;

        for(int i = 0; i < size; i++) {
            ids[i] = i;
            sizes[i] = 1;
        }
    }

    public Integer find(Integer node) {
        int root = node;
        // find root node
        while(root != ids[root]) {
            root = ids[root];
        }

        // path compression
        while(node != root) {
            Integer next = ids[node];
            ids[node] = root;
            node = next;
        }

        return root;
    }

    public void union(Integer n1, Integer n2) {
        Integer root1 = find(n1);
        Integer root2 = find(n2);

        if(root1 == root2) {
            return;
        }


        // put smaller component to the larger one
        if(sizes[root1] <= sizes[root2]) {
            ids[root1] = root2;
            sizes[root2] += sizes[root1];
        } else {
            ids[root2] = root1;
            sizes[root1] += sizes[root2];
        }

        componentNum--;
    }

    public boolean connected(Integer n1, Integer n2) {
        return find(n1) == find(n2);
    }


}
