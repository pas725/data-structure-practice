package onlinejudge.codility;

/**
 * Created by psagar on 2/4/2018.
 * https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/
 */
public class FrogJump {
    public static void main(String[] args) {
        System.out.println(solution(10, 85, 30));
    }

    public static int solution(int X, int Y, int D) {
        // write your code in Java SE 8
        int diff = Y - X;
        int numSteps = diff / D;
        return (numSteps * D) > diff ? numSteps : ++numSteps ;
    }
}
