package esn;
import java.util.Random;

public class parinode {
    public static float[][] wnode(float a,float b,int Nx,int Nu){
        //int ascale = 1;                         //一様分布の正の範囲
        //int bscale = -1;                        //一様分布の負の範囲
        //double[][] Wr= new double[Nx][Nu];   //一様分布の乱数
        float[][] W = new float[Nx][Nu];    //入力層の重み 

        for(int i=0; i<Nx;i++){
            for(int j=0; j<Nu;j++){
            //入力層の重みの初期値
            W[i][j] = (float)(a + (b - a)*Math.random());
            //Win[i][j][k] = Win[i][j][k]/255;
            //System.out.println("縦"+i+"横"+j+"の乱数"+rand[i][j]);
            }
        }
        return W;
    }

    public static float[][] wu(float[][] w,int[][] u,int Nx,int Nu){
        //int ascale = 1;                         //一様分布の正の範囲
        //int bscale = -1;                        //一様分布の負の範囲
        //double[][] Wr= new double[Nx][Nu];   //一様分布の乱数
        float[][] wu = new float[Nx][1];    //入力層の重み 

        for(int i=0; i<Nx;i++){
            for(int j=0; j<Nu;j++){
            //入力層の重みの初期値
            wu[i][0] = wu[i][0] + w[i][j]*u[j][0];
            //Win[i][j][k] = Win[i][j][k]/255;
            //System.out.println("縦"+i+"横"+j+"の乱数"+rand[i][j]);
            }
            //System.out.println(wu[i]);
            //System.out.println(wu[i][0]);
        }
        return wu;
    }
}
