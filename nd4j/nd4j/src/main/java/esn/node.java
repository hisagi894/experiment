package esn;
import java.util.Random;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

public class node {
    public static float[][] wnode(float a,float b,int Nx,int ud){
        //int ascale = 1;                         //一様分布の正の範囲
        //int bscale = -1;                        //一様分布の負の範囲
        //double[][] Wr= new double[Nx][Nu];   //一様分布の乱数
        float[][] W = new float[Nx][ud];    //入力層の重み 

        for(int i=0; i<Nx;i++){
            for(int j=0; j<ud;j++){
            //入力層の重みの初期値
            W[i][j] = (float)(a + (b - a)*Math.random());
            //Win[i][j][k] = Win[i][j][k]/255;
            //System.out.println("縦"+i+"横"+j+"の乱数"+rand[i][j]);
            }
        }
        return W;
    }

    public static float[] wu(float[][] w,float[][] u,int Nx,int ud){
        //int ascale = 1;                         //一様分布の正の範囲
        //int bscale = -1;                        //一様分布の負の範囲
        //double[][] Wr= new double[Nx][Nu];      //一様分布の乱数
        float[][] wu = new float[Nx][1];               //wu[20]
        INDArray win = Nd4j.create(w);   //win[20][1]
        INDArray U = Nd4j.create(u);     //U[1]
        //System.out.println("W"+W);
        INDArray Wu = win.mmul(U);          //WX[20][1] 
        wu = Wu.toFloatMatrix();      //wu[20][1]

        /*for(int i=0; i<Nx;i++){
            for(int j=0; j<ud;j++){
            //入力層の重みの初期値
            wu[i] = wu[i] + w[i][j]*u[j];          //wu[20]←w[20][1]*u[1]
            //Win[i][j][k] = Win[i][j][k]/255;
            //System.out.println("縦"+i+"横"+j+"の乱数"+rand[i][j]);
            }
            //System.out.println(wu[i]);
            //System.out.println(wu[i][0]);
        }*/

        float[] xreshape = new float[Nx];    //xreshape[20][1]

        for(int i=0;i<Nx;i++){
            xreshape[i]=wu[i][0];
        }
        return xreshape;
    }
}
