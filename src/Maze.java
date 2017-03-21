import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;

/**
 * Created by S199756066 on 3/21/2017.
 */
public class Maze {

    public Point[][] points;
    public int xSize, ySize;
    public boolean[][] blockedX, blockedY;
//    public Point aa, ab, ac, ad, ae, af, ag;
//    public Point ba, bb, bc, bd, be, bf, bg;
//    public Point ca, cb, cc, cd, ce, cf, cg;
//    public Point da, db, dc, dd, de, df, dg;

    public Maze(int xS, int yS, boolean[][] blockedX, boolean[][] blockedY){
        this.xSize = xS;
        this.ySize = yS;
        points = new Point[xSize][ySize];
        for(int i = 0;i < points.length;i++){
            for(int j = 0;j < points[i].length;j++){
                points[i][j] = new Point(i,j);
            }
        }

        this.blockedX = blockedX;
        this.blockedY = blockedY;


    }

    public void assignBlock(){
        for(int i = 0;i < ySize;i++) {
            if (blockedX[0][i]) {
                points[0][i].canMoveE = false;
            }

            if(blockedX[xSize - 2][i]){
                points[xSize - 1][i].canMoveW = false;
            }
        }

        for(int i = 1;i < xSize - 1;i++){
            for(int j = 0;j < ySize;j++){
                if(blockedX[i][j]){
                    points[i][j].canMoveE = false;
                    points[i+1][j].canMoveW = false;
                }
            }
        }

        for(int i = 0;i < xSize;i++){
            if(blockedY[i][0]){
                points[i][0].canMoveS = false;
            }

            if(blockedY[i][ySize - 2]){
                points[i][ySize - 1].canMoveN = false;
            }
        }

        for(int i = 1;i < ySize - 1;i++){
            for(int j = 0;j < xSize;j++){
                if(blockedX[i][j]){
                    points[i][j].canMoveN = false;
                    points[i][j+1].canMoveS = false;
                }
            }
        }
    }

    public void solve(){

    }

    @Override
    public String toString(){
        for(int i = 0;i < ySize * 2 - 1;i++){
            if(i % 2 == 0){
                for(int j = 0;j < xSize - 1;j++){
                    System.out.print("O");

                    if(blockedX[i/2][j]){
                        System.out.print("--X--");
                    } else {
                        System.out.print("-----");
                    }
                }
                System.out.println("O");
            } else {
                for(int k = 0;k < 3;k++) {
                    for (int j = 0; j < xSize - 1; j++) {
                        if(k == 1) {
                            if(blockedY[i/2][j]) {
                                System.out.print("X     ");
                            } else {
                                System.out.print("|     ");
                            }
                        } else {
                            System.out.print("|     ");
                        }
                    }
                    System.out.println("|");
                }
            }
        }


        return "";
    }

}
