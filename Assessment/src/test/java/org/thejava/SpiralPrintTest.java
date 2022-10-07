package org.thejava;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SpiralPrintTest {

    @Test
    public void getSpiralPrintListTest() {
        int[][] input = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        List<Integer> expectedOutput = Arrays.asList(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10);
        SpiralPrint sp = new SpiralPrint();
        assert sp.getSpiralPrintList(input).equals(expectedOutput);


    }

}
