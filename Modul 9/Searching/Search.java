package Searching;

public class Search {
    public static int linearSearch(int[] arr, int search) {
        int check = 0;
        for (int i = 0; i < arr.length; i++) {
            check++;
            if (arr[i] == search) {
                System.out.println("Pengecekan dilakukan sebanyak: " +check +" kali");
                return i;
            }
        }
        System.out.println("Pengecekan dilakukan sebanyak: " +check +" kali");
        return -1;
    }

    public static int binarySearch(int[] arr, int search ) {
        int check = 0;
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            check++;
            int mid = low + (high - low) / 2;
            if (arr[mid] == search){
                System.out.println("Pengecekan dilakukan sebanyak: " +check +" kali");
                return mid;
            }
            if (arr[mid] < search) low = mid + 1;
            else high = mid - 1;
        }
        System.out.println("Pengecekan dilakukan sebanyak: " +check +" kali");
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 12, 15, 16, 23, 25, 26, 29, 
            31, 36, 37, 38, 39, 47, 50, 55, 59, 60, 
            68, 72, 78, 87, 88, 90, 96, 97, 99, 100
        };

        System.out.println("\nLinear search (arr, 88):");
        int hasil = linearSearch(arr, 88);
        System.out.println("Nilai dari variabel hasil adalah " +hasil);

        System.out.println("\nLinear search (arr, 21):");
        hasil = linearSearch(arr, 21);
        System.out.println("Nilai dari variabel hasil adalah " +hasil);

        System.out.println("\nBinary search (arr, 88):");
        hasil = binarySearch(arr, 88);
        System.out.println("Nilai dari variabel hasil adalah " +hasil);

        System.out.println("\nBinary search (arr, 35):");
        hasil = binarySearch(arr, 35);
        System.out.println("Nilai dari variabel hasil adalah " +hasil);

        System.out.println();
        linearSearch(arr, 88);
        binarySearch(arr, 88);

        linearSearch(arr, 21);
        binarySearch(arr, 21);
    }
}
