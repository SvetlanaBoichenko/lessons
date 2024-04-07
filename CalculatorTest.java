package org.example;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.Assert.assertTrue;


class CalculatorTest {

    @org.junit.jupiter.api.Test
    void main() {
    }


    @org.junit.jupiter.api.Test
    void sort5() {
        System.out.println("random test");
        Random rand = new Random();
        int a4[] = new int[15];
        for (int i = 0; i < 15; i++) {
            a4[i] = rand.nextInt(20) - 1;
        }
        assertTrue(Calculator.sort2(a4) <= 0);
    }

    @org.junit.jupiter.api.Test
    void sort6() {
        System.out.println("null test");

        int a5[] = {0};
        assertTrue(Calculator.sort2(a5) == 0);
    }

    @org.junit.jupiter.api.Test
    void sort7() {
        System.out.println("MaxValue test");

        int a6[] = {2147483647, 2147483647};
        assertTrue(Calculator.sort2(a6) > 0);
    }

    @org.junit.jupiter.api.Test
    void sort8() {
        System.out.println("Regres test");

        int a8[] = {3, 5, 0};
        assertTrue(Calculator.sort2(a8) == 5);
    }

}
