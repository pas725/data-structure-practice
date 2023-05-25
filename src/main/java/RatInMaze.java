public class RatInMaze {
    public static void main(String[] args) {

        int m[][] = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};
        boolean vis[][] = new boolean[4][4];
        fun(m, vis, 0, 0, "", m.length);
    }

    private static void fun(int[][] m, boolean[][] vis, int i, int j, String s, int n) {
        if (i == n-1 && j == n-1)
            System.out.println(s);
        if (i == n || j == n || i < 0 || j< 0 ||
                m[i][j] == 0 || vis[i][j])
            return;

        vis[i][j] = true;

        int adj[][] = {{1, -1, 0, 0},
                       {0, 0, 1, -1}};
        String move[] = {"D", "U", "R", "L"};
        for (int k=0; k<4; k++) {
            fun(m, vis, i+adj[0][k], j+adj[1][k], s + move[k], n);
        }

        vis[i][j] = false;
    }
}
