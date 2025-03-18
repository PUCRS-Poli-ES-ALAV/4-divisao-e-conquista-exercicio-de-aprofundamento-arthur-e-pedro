
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    static List<Integer> merge(List<Integer> a, List<Integer> b) {
        var res = new ArrayList<Integer>();
        int i = 0, j = 0;
        while (i + j < a.size() + b.size() - 1) {
            if (a.get(i) > b.get(j) || i >= a.size()) {
                res.add(b.get(j));
                j += 1;
            } else {
                res.add(a.get(i));
                i += 1;
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

    public static void main( String[] args )
    {
        System.out.println(mergeSort(Arrays.asList(5,2,7,42,6,8,4,2,64,23,6,7731,67,23)));
    }
}
