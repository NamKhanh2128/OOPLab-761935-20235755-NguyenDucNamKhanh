import java.util.Arrays;
import java.util.Scanner;

public class ArraySortAndCalculate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Số lượng phần tử của mảng
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] my_array = new int[n];

        // 2. Nhập từng phần tử
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            my_array[i] = scanner.nextInt();
        }

        // Hiển thị mảng ban đầu
        System.out.println("\nOriginal array: " + Arrays.toString(my_array));

        // 3. Sắp xếp mảng
        Arrays.sort(my_array);
        System.out.println("Sorted array: " + Arrays.toString(my_array));

        // 4. Tính tổng
        int sum = 0;
        for (int num : my_array) {
            sum += num;
        }

        // 5. Tính trung bình 
        double average = (double) sum / n;

        System.out.println("Sum of array elements: " + sum);
        System.out.println("Average value: " + average);

        scanner.close();
    }
}