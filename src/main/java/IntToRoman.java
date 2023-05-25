public class IntToRoman {
    public static void main(String[] args) {
        int num = 1904;
        intToRoman(num);
    }

    private static void intToRoman(int num) {
        String m[] = {"", "M", "MM", "MMM"};
        String c[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String t[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String d[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        while (num>0) {
            if (num>=1000) {
                System.out.print(m[num/1000]);
                num = num % 1000;
            } else if (num >= 100) {
                System.out.print(c[num/100]);
                num = num % 100;
            } else if (num >= 10) {
                System.out.print(t[num/10]);
                num = num % 10;
            } else if (num > 0) {
                System.out.print(d[num]);
                num =0;
            }
        }
    }
}
