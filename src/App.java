import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {

    public static List<Integer> topKFrequent(int[] arr, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
            min = Math.min(arr[i], min);
        }
        int[] freq = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            freq[arr[i] - min]++;
        }
        for (int i = 0; i < k; i++) {
            int ran = frequent(freq);
            freq[ran] = 0;
            list.add(ran + min);
        }
        return list;
    }
    //how many each item frequent
    static int frequent(int[] res) {
        int max = 0, index = 0;
        for (int i = 0; i < res.length; i++) {
            if (res[i] > max) {
                index = i;
                max = res[i];
            }
        }
        return index;
    }

    public static void main(String[] args) throws Exception {

        int sum = 0;
        float avg = 0;
        Random rand = new Random();

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the length of array");

        int n = scan.nextInt();
        int arr[] = new int[n];

        if (n < 10000) {
            System.out.println("The length should be more than 10000");
            n = scan.nextInt();
            arr = new int[n];
        } else {

            for (int i = 0; i < n; i++) {
                arr[i] = rand.nextInt(1000);
                sum += arr[i];
                avg = sum / arr.length;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("Sum of all the array items = " + sum);
        System.out.println("Average of all the array items = " + avg);
        System.out.println("Most frequent three numbers "+topKFrequent(arr, 3));
    }
}
