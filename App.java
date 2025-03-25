
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{
    static long cont;

    static List<Integer> merge(List<Integer> a, List<Integer> b) {
        var res = new ArrayList<Integer>();
        int i = 0, j = 0;
        while (i < a.size() && j < b.size()) {
            if (a.get(i) > b.get(j)) {
                res.add(b.get(j++));
            } else {
                res.add(a.get(i++));
            }
            cont++;
        }

        if (i == a.size()) {
            for (int k = j; k < b.size(); k++) {
                res.add(b.get(k));
                cont++;
            }
        } else {
            for (int k = i; k < a.size(); k++) {
                res.add(a.get(k));
                cont++;
            }
        }

        return res;
    }

    static List<Integer> mergeSort(List<Integer> l) {
        if (l.size() == 1) return l;
        List<Integer> a = mergeSort(l.subList(0, l.size()/2));
        List<Integer> b = mergeSort(l.subList(l.size()/2, l.size()));
        return merge(a,b);
    }

    static long maxVal1(long A[], int n) {  
        cont++;
        long max = A[0];
        for (int i = 1; i < n; i++) {  
            if( A[i] > max ) 
               max = A[i];
        }
        return max;
    }

    static long maxVal2(long A[], int init, int end) {  
        cont++;
        if (end - init <= 1)
            return Math.max(A[init], A[end]);  
        else {
              int m = (init + end)/2;
              long v1 = maxVal2(A,init,m);   
              long v2 = maxVal2(A,m+1,end);  
              return Math.max(v1,v2);
             }
    }

    static long multiply(long x, long y, long n) {
        cont++;
        if (n == 1) {
            return x * y;
        } else {
            long m = n >> 1;
            System.out.printf("m = %d\n", m);
            long a = x >> m;
            System.out.printf("a = %d\n", a);
            long b = x % (1<<m);
            System.out.printf("b = %d\n", b);
            long c = y >> m;
            System.out.printf("c = %d\n", c);
            long d = y % (1<<m);
            System.out.printf("d = %d\n", d);
            long e = multiply(a, c, m);
            System.out.printf("e = %d\n", e);
            long f = multiply(b, d, m);
            System.out.printf("f = %d\n", f);
            long g = multiply(b, c, m);
            System.out.printf("g = %d\n", g);
            long h = multiply(a, d, m);
            System.out.printf("h = %d\n", h);
            return (1<<(2*m))*e + (1<<m)*(g+h) + f;
        }
    }

    public static void main( String[] args )
    {
        cont = 0;
        System.out.printf("%d * %d = %d\n",0b1111, 0b1010, multiply(0b1111, 0b1010, 4));
        System.out.println(cont);
        cont = 0;
        System.out.printf("%d * %d = %d\n", 10000, 11000, multiply(10000, 11000, 16));
        System.out.println(cont);
        cont = 0;
        Random rng = new Random();
        long x = rng.nextLong()/2;
        long y = rng.nextLong()/2;
        //System.out.printf("%d * %d = %d\n", x, y, multiply(x, y, 32));
    }
}
