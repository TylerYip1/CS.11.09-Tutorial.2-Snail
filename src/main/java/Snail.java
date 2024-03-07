public class Snail {

    /**
     *
     * TODO 5
     *
     * Input: an n x n 2d array.
     * Output: a 1d array of length n^2 that contains the order of elements visited in a snail traversal of the 2d array.
     *
     * Example:
     *
     * Input:
     *
     * {
     *     {1,2,3},
     *     {4,5,6},
     *     {7,8,9}
     * }
     *
     * Output:
     *
     * {1,2,3,6,9,8,7,4,5}
     *
     * @param array2d
     * @return a 1d array containing the order of elements visited in a snail traversal of the 2d array.
     *         returns an empty array if array2d is not square.
     */
    public static int[] flattenSnail(int[][] array2d) {
        if(isPerfectSquare(array2d)){
            int[] a = new int [array2d.length * array2d.length];
            int x = 0;
            int y = 0;
            int rightBound = array2d.length - 1;
            int leftBound = 0;
            int topBound = 1;
            int bottomBound = array2d.length - 1;
            int direction = 0;
            int i = 0;
            while(i < array2d.length * array2d.length){
                a[i] = array2d[y][x];
                if(direction == 0){
                    if(x < rightBound){
                        x++;
                    }
                    else{
                        direction = 1;
                        rightBound--;
                        y++;
                    }
                }
                else if (direction == 1){
                    if(y < bottomBound){
                        y++;
                    }
                    else{
                        direction = 2;
                        bottomBound--;
                        x--;
                    }
                }
                else if (direction == 2){
                    if(x > leftBound){
                        x--;
                    }
                    else{
                        direction = 3;
                        leftBound++;
                        y--;
                    }
                }
                else if (direction == 3){
                    if(y > topBound){
                        y--;
                    }
                    else{
                        direction = 0;
                        topBound++;
                        x++;
                    }
                }
                i++;
            }
            return a;
        }
        else{
            int[] b = new int[0];
            return b;
        }
    }

    /**
     *
     * TODO 6
     *
     * Input: a 1d array of length n, where n is a perfect square.
     * Output: a 2d array of width == height == sqrt(n) that represents a snail.
     *
     * Example:
     *
     * Input:
     *
     * {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
     *
     * Output:
     *
     * {
     *     {1,2,3,4,5},
     *     {16,17,18,19,6},
     *     {15,24,25,20,7},
     *     {14,23,22,21,8},
     *     {13,12,11,10,9},
     * }
     *
     *
     * @param array1d
     * @return a 2d array of width == height == sqrt(n), where n is the length of the inputted array, that represents a snail.
     *         returns an empty 2d array if the length of array1d is not a perfect square.
     */
    public static int[][] makeSnail(int[] array1d) {
        if(isPerfectSquare(array1d)){
            int length = (int) Math.sqrt(array1d.length);
            int[][] a = new int[length][length];
            int i = 0;
            int x = 0;
            int y = 0;
            int rightBound = length - 1;
            int leftBound = 0;
            int topBound = 1;
            int bottomBound = length - 1;
            int direction = 0;
            while(i < array1d.length){
                a[y][x] = array1d[i];
                if(direction == 0){
                    if(x < rightBound){
                        x++;
                    }
                    else{
                        direction = 1;
                        rightBound--;
                        y++;
                    }
                }
                else if (direction == 1){
                    if(y < bottomBound){
                        y++;
                    }
                    else{
                        direction = 2;
                        bottomBound--;
                        x--;
                    }
                }
                else if (direction == 2){
                    if(x > leftBound){
                        x--;
                    }
                    else{
                        direction = 3;
                        leftBound++;
                        y--;
                    }
                }
                else if (direction == 3){
                    if(y > topBound){
                        y--;
                    }
                    else{
                        direction = 0;
                        topBound++;
                        x++;
                    }
                }
                i++;
            }
            return a;
        }
        else{
            int[][] b = new int[0][0];
            return b;
        }
    }

    /**
     *
     * TODO 1
     *
     * Private helper method that prints the contents of a 1d array.
     * Used mainly for debugging purposes.
     *
     * @param array1d
     */
    private static void print1dArray(int[] array1d) {
        for(int i = 0; i < array1d.length; i++){
            System.out.print(array1d[i]);
        }
    }

    /**
     *
     * TODO 2
     *
     * Private helper method that prints the contents of a 2d array.
     * Used mainly for debugging purposes.
     *
     * @param array2d
     */
    private static void print2dArray(int[][] array2d) {
        for(int i = 0; i < array2d.length; i++){
            print1dArray(array2d[i]);
        }
    }

    /**
     *
     * TODO 3
     *
     * Private helper method that checks to see if a 1d array is of a length that is a perfect square.
     *
     * @param array1d
     * @return
     */
    private static boolean isPerfectSquare(int[] array1d) {
        if(array1d == null){
            return false;
        }
        int number = array1d.length;
        int x = (int) Math.sqrt(number);
        if(Math.pow(x,2) == number){
            return true;
        }
        return false;
    }


    /**
     *
     * TODO 4
     *
     * Private helper method that checks to see if a 2d array is a square.
     *
     * @param array2d
     * @return
     */
    private static boolean isPerfectSquare(int[][] array2d) {
        if(array2d == null){
            return false;
        }
        int height = array2d.length;
        for(int i = 0; i < height ;i++){
            if(array2d[i].length != height){
                return false;
            }
        }
        return true;
    }


}
