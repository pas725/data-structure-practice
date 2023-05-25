package graph;

// https://leetcode.com/problems/surrounded-regions/description/
public class SurroundedReigon {

    public static void main(String[] args) {
        char[][] board = {
                {'O','X','X','O','X'},
                {'X','O','O','X','O'},
                {'X','O','X','O','X'},
                {'O','X','O','O','O'},
                {'X','X','O','X','O'}
        };

        System.out.println("Input:");
        print(board);

        solve(board);

        System.out.println("Output:");
        print(board);
    }

    private static void print(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i=0; i<m; i++) {
            System.out.println("");
            for (int j=0; j<n; j++) {
                System.out.print(board[i][j] + " ");
            }
        }
        System.out.println("");
    }


    public static void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if ( (i==0 || j==0 || i==m-1 || j==n-1) && board[i][j] == 'O') {
                    dfs(i, j, m, n, board);
                }
            }
        }

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == 'V') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    static int x[] = {1, -1, 0, 0};
    static int y[] = {0, 0, 1, -1};

    static void dfs(int i, int j, int m, int n, char[][] board) {
        if (i < 0 || i>= m || j<0 || j>= n)
            return;
        if (board[i][j] == 'X' || board[i][j] == 'V')
            return;

        board[i][j] = 'V';
        for (int k=0; k<4; k++) {
            dfs(i+x[k], j+y[k], m, n, board);
        }
    }
}
