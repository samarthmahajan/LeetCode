class Solution {
    public int minimumArea(int[][] grid) {
        int rowMin = 0, colMin = 0, rowMax = 0, colMax = 0;
        boolean any1 = false;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                     if(any1 == false){
                        rowMin = row;
                        colMin = col;
                        rowMax= row;
                        colMax = col;
                    }
                    any1 = true;
                    if (row < rowMin) {
                        rowMin = row;
                    } else if (row > rowMax) {
                        rowMax = row;
                    }
                    if (col < colMin) {
                        colMin = col;
                    } else if (col > colMax) {
                        colMax = col;
                    }
                }

            }
        }
        if (any1 == false) {
            return 0;
        }
        int calRow = rowMax - rowMin  +1;
        int calCol= colMax - colMin +1;
        return calRow * calCol;

    }
}