public class Game24 {
    static int cnt=0;
    public static void main(String[] args) {
        var g = new Game24();
        int in[] = {1, 1, 1, 1};
//        int in[] = {4, 1, 8, 7};
        System.out.println(g.judgePoint24(in));

        System.out.println("Num calls : " + cnt);
    }
    public boolean judgePoint24(int[] cards) {
        int n = cards.length;
        double da[] = {cards[0], cards[1], cards[2], cards[3]};
        return f(da, n);
    }

    boolean f(double cards[], int n) {
        cnt++;
        if (n == 1)
            return Math.abs(cards[0] - 24.0) < 0.000001;


        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                double da[] = new double[n-1];
                for (int k=0, ind = 0; k<n; k++) {
                    if (k!=i && k!=j) {
                        da[ind++] = cards[k];
                    }
                }
                for (double d : comp(cards[i], cards[j])) {
                    da[n-2] = d;
                    if (f(da, n-1))
                        return true;
                }

            }
        }
        return false;
    }

    double[] comp(double a, double b) {
        return new double[]{a+b, a-b, b-a, a*b, a/b, b/a};
    }
}
