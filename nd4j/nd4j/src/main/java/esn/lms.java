package esn;
//import java.lang.*;
public class lms {
    public static float[] Elms(double[][] Y,double[][] wy,double[][] d,float[] wout,double[][] e,float[] wbe,double[][] xt,double elms,double it,int Nx,int Ny){
        //double elms = 0;
        //double it = 0.1;
        //double[][] e = new double[500][400];
        //double[][] wout = new double[500][400];

        for(int y=0;y<Nx;y++){
            for(int x=0;x<Nx;x++){
                for(int a=0;a<Ny;a++){
                    wy[y][x] = wy[y][x] + wout[a]*xt[y][x];
                }
            }
        }

        for(int y=0;y<Nx;y++){
            for(int x=0;x<Nx;x++){
                e[y][x] = d[y][x] - Y[y][x];
                //System.out.println(e[y][x]);
            }
        }

        //System.out.println("最小平均二乗法"+e[0][0]);

        for(int y=0;y<Nx;y++){
            for(int x=0;x<Nx;x++){
                elms = elms + e[y][x]*e[y][x];
            }
        }

        elms = elms/2;

        //System.out.println("xt"+xt[0][0]);
        //System.out.println("elms"+elms);

        for(int a=0;a<Ny;a++){
            for(int i=0;i<Nx;i++){
                for(int j=0;j<Nx;j++){   //シグマの役割
                    wout[a] = (float)(wbe[a] + it*e[i][j]*xt[j][i]);
                }
            }
        }
        //System.out.println(wout[0]);

        elms = 0;
        return wout;
    }
}
