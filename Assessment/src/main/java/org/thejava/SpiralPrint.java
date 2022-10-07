package org.thejava;

import java.util.ArrayList;
import java.util.List;


// TODO:  this solutions complexity is O(n^2), maybe it can be improved. If matrix can be split sub-matrix recursively that complexity might be increase
public class SpiralPrint {

    enum Direction { // Direction of the cursor,
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public List<Integer> getSpiralPrintList(int[][] input) {

        List<Integer> output = new ArrayList<Integer>(); // create List for output.
        Direction direction = Direction.RIGHT; // decide first moving direction.

        // these variables are keeping dimensions, current indexes and seen element count (to decide that the process is finished)
        int dx = input.length;
        int dy = input[0].length;
        int x = 0, y = 0, seenCount = 0;

        boolean[][] seen = new boolean[dx][dy];

        // start the loop for element count of matrix
        while (seenCount <= dx * dy - 1) {

            if (y >= 0 && y < dy && x < dx && !seen[x][y]) { // if this element is not seen yet and indexes aren't out of the matrix, collect this item.
                output.add(input[x][y]);
                seen[x][y] = true; // mark as seen
                seenCount++;
            } else { // if this element seen before or indexes out of the matrix change direction and rescale indexes
                if (direction == Direction.RIGHT) {
                    y--;
                    direction = Direction.DOWN;
                } else if (direction == Direction.LEFT) {
                    y++;
                    direction = Direction.UP;
                } else if (direction == Direction.DOWN) {
                    x--;
                    direction = Direction.LEFT;
                } else if (direction == Direction.UP) {
                    x++;
                    direction = Direction.RIGHT;
                }

            }
            // move forward to collecting
            if (direction == Direction.RIGHT) {
                y = (y % dy) + 1;
            } else if (direction == Direction.DOWN) {
                x = (x % dx) + 1;

            } else if (direction == Direction.LEFT) {
                y = (y % dy) - 1;

            } else if (direction == Direction.UP) {
                x = (x % dx) - 1;
            }

        }
        return output;
    }


}
