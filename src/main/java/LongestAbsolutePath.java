import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LongestAbsolutePath {
    public static void main(String[] args) {
        String path = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        String res = getLongestAbsolutePath(path);
        System.out.println(res);
    }

    static String max = "";
    private static String getLongestAbsolutePath(String path) {
        var files = path.split("\\n");
        Stack<PathNode> stack = new Stack<>();
        var n = new PathNode(files[0], 0);
        stack.add(n);
        for (int i=1; i<files.length; i++) {
            String p = files[i];
            int l = getLevel(p);
            var pn = new PathNode(p, l);

            while (stack.peek().level != l-1)
                stack.pop();

            var parent = stack.peek();
            parent.addChild(pn);
            stack.add(pn);
        }
        dfs(n, "");
        return max;
    }

    private static void dfs(PathNode n, String path) {
        if (n == null)
            return;
        var np = path + "\n" + n.p;
        if (n.isFile) {
            if (np.length() > max.length()) {
                max = np;
            }
            return;
        }

        for (PathNode c : n.child) {
            dfs(c,np);
        }
    }

    private static int getLevel(String p) {
        int l = 0;
        String pref = "\t";
        while(p.startsWith(pref)) {
            l++;
            pref += "\t";
        }
        return l;
    }
}

class PathNode {
    String p;
    int level;
    List<PathNode> child = new ArrayList<>();
    boolean isFile = false;

    public PathNode(String p, int level) {
        this.p = p;
        this.level = level;
        isFile = p.contains(".");
    }

    public PathNode(String p) {
        this(p, 0);
    }

    public void addChild(PathNode pn) {
        child.add(pn);
    }
}