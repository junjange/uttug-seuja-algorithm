
import java.io.*;
import java.util.*;

public class Baek2295 {

    static List<Integer> sumArr = new ArrayList<>();
    static List<Integer> minusArr = new ArrayList<>();
    static int[] arr;
    static long max = Long.MIN_VALUE;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        arr = new int[n];


        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                sumArr.add(arr[i] + arr[j]);
            }
        }

        Collections.sort(sumArr);

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {

                int k = arr[i] - arr[j];
                int index = binarySearch(k);

                if (index != -1) {
                    max = Math.max(max,sumArr.get(index) + arr[j]);
                }
            }
        }

        System.out.println(max);

    }
    static int binarySearch(int key) {

        int low = 0;
        int high = sumArr.size()-1;

        while (low <= high) {

            int mid = (low+high)/2;

            if (sumArr.get(mid) == key) {
                return mid;
            }else if (sumArr.get(mid) > key) {
                high = mid-1;

            }else {
                low = mid+1;
            }
        }

        return -1;

    }
}
