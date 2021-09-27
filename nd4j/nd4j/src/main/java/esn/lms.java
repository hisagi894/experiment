package esn;
//import java.lang.*;
public class lms {
    public static double[][][] Elms(double[][] Y,double[][] d,double[][][] wout,double[][] e,double[][][] wbe,double[][] xt,double elms,double it,int Nx,int Ny){
        //double elms = 0;
        //double it = 0.1;
        //double[][] e = new double[500][400];
        //double[][] wout = new double[500][400];

        for(int y=0;y<Nx;y++){
            for(int x=0;x<Nx;x++){
                e[y][x] = d[y][x] - Y[y][x];
                //System.out.println(e[y][x]);
            }
        }

        //System.out.println("最小平均二乗法"+e[0][0]);

        /*for(int y=0;y<150;y++){
            for(int x=0;x<150;x++){
                elms = Math.sqrt(elms + e[y][x]);
            }
        }

        elms = elms*elms;

        elms = elms/2;*/

        //System.out.println("xt"+xt[0][0]);

        for(int k=0; k<Ny;k++){
            for(int i=0;i<Nx;i++){
                for(int j=0;j<Nx;j++){   //シグマの役割
                    wout[i][j][k] = wbe[i][j][k] + it*e[i][j]*xt[j][i];
                }
            }
        }
        //System.out.println(wout[0][0]);

        elms = 0;
        return wout;
    }
}
