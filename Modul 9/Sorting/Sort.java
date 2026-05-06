import java.util.Arrays;

public class Sort{
  
    //Method bubble descending
    public static int[] bubble_desc(int[] list) {
        int tukarAtauGeser = 0;
        for (int i = 0; i < list.length - 1; i++) {
            for (int k = i + 1; k < list.length; k++) {
                System.out.printf("%d:%d\n", list[k], list[i]);
                if (list[k] > list[i]) { // untuk descending kurang dari (<) diganti lebih dari (>)
                    int t = list[i];
                    list[i] = list[k];
                    list[k] = t;
                    tukarAtauGeser++;
                }
            }
        }
        System.out.println("Banyak pergerakan: " +tukarAtauGeser);
        return list;
    }

    //Method bubble ascending
    public static int[] bubble(int[] list) {
        int tukarAtauGeser = 0;
        for (int i = 0; i < list.length - 1; i++) {
            for (int k = i + 1; k < list.length; k++) {
                System.out.printf("%d:%d\n", list[k], list[i]);
                if (list[k] < list[i]) {
                    int t = list[i];
                    list[i] = list[k];
                    list[k] = t;
                    tukarAtauGeser++;
                }
            }
        }
        System.out.println("Banyak pergerakan: " +tukarAtauGeser);
        return list;
    }

    //Method insertion descending
    public static int[] insertion_desc(int[] list) {
        int tukarAtauGeser = 0;
        for (int i = 1; i < list.length; ++i) {
            int key = list[i];
            int k = i - 1;
            /*
            * Move elements of arr[0..i-1], that are greater than key,
            * to one position ahead of their current position
            */
            while (k >= 0 && list[k] < key) { // untuk descending lebih dari (>) diganti kurang dari (<)
                list[k + 1] = list[k];
                tukarAtauGeser++;
                k = k - 1;
            }
            list[k + 1] = key;
        }
        System.out.println("Banyak pergerakan: " +tukarAtauGeser);
        return list;
    }

    //Method insertion ascending
    public static int[] insertion(int[] list) {
        int tukarAtauGeser = 0;
        for (int i = 1; i < list.length; ++i) {
            int key = list[i];
            int k = i - 1;
            /*
            * Move elements of arr[0..i-1], that are greater than key,
            * to one position ahead of their current position
            */
            while (k >= 0 && list[k] > key) {
                list[k + 1] = list[k];
                tukarAtauGeser++;
                k = k - 1;
            }
            list[k + 1] = key;
        }
        System.out.println("Banyak pergerakan: " +tukarAtauGeser);
        return list;
    }

    //Method selection descending
    public static int[] selection_desc(int[] list) {
        int tukarAtauGeser = 0;
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < list.length - 1; i++) {
            // Find the minimum element in unsorted array
            int minIndex = i;
            for (int k = i + 1; k < list.length; k++) {
                if (list[k] > list[minIndex]) // untuk descending kurang dari (<) diganti lebih dari (>)
                minIndex = k;
            }
            // Swap the found minimum element
            // with the first element
            int t = list[minIndex];
            list[minIndex] = list[i];
            list[i] = t;
            tukarAtauGeser++;
        }
        System.out.println("Banyak pergerakan: " +tukarAtauGeser);
        return list;
    }

    //Method selection ascending
    public static int[] selection(int[] list) {
        int tukarAtauGeser = 0;
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < list.length - 1; i++) {
            // Find the minimum element in unsorted array
            int minIndex = i;
            for (int k = i + 1; k < list.length; k++) {
                if (list[k] < list[minIndex])
                minIndex = k;
            }
            // Swap the found minimum element
            // with the first element
            int t = list[minIndex];
            list[minIndex] = list[i];
            list[i] = t;
            tukarAtauGeser++;
        }
        System.out.println("Banyak pergerakan: " +tukarAtauGeser);
        return list;
    }
    
    public static void main(String[] args) {
        // ubah nilai default Array ini menjadi sebanyak 30 elemen
        int[] arr = {23, 88, 38, 31, 2, 97, 50, 37, 78, 68, 
            1, 8, 29, 15, 25, 59, 99, 16, 60, 90, 
            72, 100, 47, 36, 87, 26, 96, 39, 12, 55
        };
        System.out.println(Arrays.toString(arr));
        System.out.println();

        int[] sort;

        //Pemanggilan method bubble (ascending)
        sort = bubble(arr);
        System.out.println("Bubble sort (ascending): " +Arrays.toString(sort));

        //Pemanggilan method bubble (descending)
        sort = bubble_desc(arr);
        System.out.println("Bubble sort (descending): " +Arrays.toString(sort));

        //Pemanggilan method insertion (ascending)
        sort = insertion(arr);
        System.out.println("Insertion sort (ascending): " +Arrays.toString(sort));

        //Pemanggilan method insertion (descending)
        sort = insertion_desc(arr);
        System.out.println("Insertion sort (descending): " +Arrays.toString(sort));

        //Pemanggilan method selection (ascending)
        sort = selection(arr);
        System.out.println("Selection sort (ascending): " +Arrays.toString(sort));

        //Pemanggilan method selection (descending)
        sort = selection_desc(arr);
        System.out.println("Selection sort (descending): " +Arrays.toString(sort));

        // acak/tidak terurut dan nilai elemennya tidak ada yang ganda.
        int[] data = { 10, 5, 15, 8, 3 };
        int[] sorted = bubble(data);
        // int[] sorted = insertion(data);
        // int[] sorted = selection(data);
        System.out.println(Arrays.toString(sorted));
    }
}
