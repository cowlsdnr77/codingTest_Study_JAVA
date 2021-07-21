package Programmers.Mathmetics;

/*
    프로그래머스 - N개의 최소공배수 (level 2)
    *PS
    최소공배수, 최대공약수 문제는 "유클리드 호제법" 을 떠올려라
    A와 B의 최소공배수 = A*B/gcd(A,B)
 */
public class LCMofNs {
    public int solution(int[] arr) {
        int lcm = arr[0] * arr[1] / gcd(arr[0],arr[1]);
        for(int i=2; i< arr.length; i++) {
            lcm = lcm * arr[i] / gcd(lcm, arr[i]);
        }
        return lcm;
    }
    private int gcd(int a, int b) {
        while (b != 0 ) {
            int r = a % b; // 나머지를 구한다.

            // GCD(a,b) = GCD(b,r) 이므로 변환한다.
            a = b;
            b = r;
        }
        return a;
    }
    public static void main(String[] args) {
        LCMofNs L = new LCMofNs();
        System.out.println(L.solution(new int[]{1,2,3}));
        /*
        2와 6 = 6
        6과 8 = 24
        14와 24 = 168
         */
    }
}
