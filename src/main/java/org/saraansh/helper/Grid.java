package org.saraansh.helper;

import java.util.ArrayList;

public class Grid {
    public int rows;
    public int columns;

    public Object[][] array2d;

    public <T> Grid(int r, int c){
        rows = r;
        columns = c;
        array2d = new Object[r][c];
    }

    public Grid(int r, int c, Object[] items){
        this(r, c);

        int cur_row = 0;
        int cur_col = 0;
        for (Object item: items){
            array2d[cur_row][cur_col] = item;
            if ((cur_col + 1) % c == 0){
                cur_row += 1;
            }
            cur_col = (cur_col + 1) % c;
        }
    }

    public boolean isValidXIndex(int x){
        return 0 <= x && x < rows;
    }

    public boolean isValidYIndex(int y){
        return 0 <= y && y < columns;
    }

    public boolean areValidIndices(int x, int y){
        return isValidXIndex(x) && isValidYIndex(y);
    }

    public Object[] getMooreNeighbors(int x, int y){
        ArrayList<Object> mooreNeighbors = new ArrayList<Object>();
        for (int xShift = -1; xShift < 2; xShift++){
            for (int yShift = -1; yShift < 2; yShift++){
                if (xShift != 0 && yShift != 0){
                    if (areValidIndices(x + xShift, y + yShift)){
                        mooreNeighbors.add(array2d[x+xShift][y + yShift]);
                    }
                }
            }
        }
        return mooreNeighbors.toArray();
    }

    public Object[] getNeumannNeighbors(int x, int y){
        ArrayList<Object> neumannNeighbors = new ArrayList<Object>();
        if (areValidIndices(x + 1, y)){
            neumannNeighbors.add(array2d[x+1][y]);
        }
        if (areValidIndices(x - 1, y)){
            neumannNeighbors.add(array2d[x-1][y]);
        }
        if (areValidIndices(x, y+1)){
            neumannNeighbors.add(array2d[x][y+1]);
        }
        if (areValidIndices(x, y-1)){
            neumannNeighbors.add(array2d[x][y-1]);
        }

        return neumannNeighbors.toArray();
    }
}
