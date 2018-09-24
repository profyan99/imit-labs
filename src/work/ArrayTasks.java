package work;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayTasks {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

    }

    private static void func8() {
        int arr[] = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr));
    }

    private static void func9(int size) {
        int arr[] = new int[size];
        for (int i = 0; i < size && scanner.hasNextInt(); i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void func10(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        System.out.println("Array sum: " + sum);
    }

    private static void func11(int[] arr) {
        int amount = 0;
        for (int i : arr) {
            if (i % 2 == 0) {
                amount++;
            }
        }
        System.out.println("Amount even numbers: " + amount);
    }

    private static void func12(int[] arr, int min, int max) {
        int amount = 0;
        for (int i : arr) {
            if (i >= min && i <= max) {
                amount++;
            }
        }
        System.out.println("Amount: " + amount);
    }

    private static void func13(int[] arr) {
        boolean isAllPositive = true;
        for (int i = 0; i < arr.length && isAllPositive; i++) {
            if (arr[i] <= 0) {
                isAllPositive = false;
            }
        }
        System.out.println("Is all positive: " + isAllPositive);
    }

    private static void func14(int[] arr) {
        int tmp = 0;
        for (int i = 0; i < arr.length / 2 + 1; i++) {
            tmp = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = arr[i];
            arr[i] = tmp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
