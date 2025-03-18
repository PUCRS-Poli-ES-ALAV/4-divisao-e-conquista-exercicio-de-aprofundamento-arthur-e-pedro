
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

    public static void main( String[] args )
    {
        cont = 0;
        Random rng = new Random();
        int size = 2048;
        var list = new long[size];
        for (int i = 0; i < size; i++) {
            list[i] = rng.nextInt(size);
        }
        var startTime = System.nanoTime();
        maxVal1(list, size);
        var endTime = System.nanoTime();
        System.out.println(endTime-startTime);
        System.out.println(cont);
    }
}
