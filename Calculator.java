package org.example;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("Тест функции сортировки массивао по возрастанию!");


        int arr[] = {1,2,4,6,1,0,5,3,2,0};
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i]);

            System.out.println("");
        int t = sort2(arr);
        System.out.println("Максимальное значение = " + t);
    }

    public static int sort2(int [] a1) {
        int temp = 0;
        int n = a1.length;
        int i = 0;
        boolean f = false;
      //  int a1[] = {31, 90, 6, 4, 3, 8, 0, 5, 4, 10};

        while (f == false) {
            f = true;
            for (i = 0; i < n - 1; i++) {
                if (a1[i] > a1[i + 1]) {
                    temp = a1[i];
                    a1[i] = a1[i + 1];
                    a1[i + 1] = temp;
                    f = false;
                }
            }
        }
        System.out.println("Отсортирован:");
        for (i = 0; i < n; i++)
            System.out.print(a1[i]);
        System.out.println("");
        return a1[n - 1];

    }
}