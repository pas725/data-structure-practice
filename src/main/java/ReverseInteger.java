/**
 * Created by psagar on 9/20/2017.
 */
public class ReverseInteger {
    public static void main(String[] args) {
        int i = Integer.MAX_VALUE;
        long j = i;

        int num = 1534236469;
        long res = reverse2(num);
        int resNum = (int) res;
        System.out.println(res);
        byte b = 126;
        byte c = (byte) (b  * 10 );
        System.out.println(Integer.MAX_VALUE);
        System.out.println((964632435 < Integer.MAX_VALUE));
    }

    static int reverse(int x) {
        int n = Math.abs(x);
        long resNum = 0;
        while (n > 0) {
            long rem = n%10;
            resNum = (resNum*10) + rem;
            n = n/10;
        }
        int resNumInt = (int) resNum;
        if (resNumInt == resNum) {
            if (x < 0)
                return (int) -resNum;
            return (int) resNum;
        }
        return 0;
    }

    static int reverse2(int x) {
        int n = Math.abs(x);
        int resNum = 0;
        while (n > 0) {
            int rem = n%10;
            /*if ((resNum * 10 ) % 10 != 0) {
                return 0;
            }*/
            resNum = (resNum*10) + rem;
            n = n/10;
        }

        if (x < 0)
            return (int) -resNum;
        return (int) resNum;
    }
}
