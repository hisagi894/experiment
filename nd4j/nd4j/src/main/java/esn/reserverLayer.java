package esn;
import java.lang.Math;
import java.net.IDN;

//import java.lang.Object;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
//import java.util.Arrays;
import org.nd4j.linalg.eigen.Eigen;
import org.nd4j.linalg.factory.ops.NDMath;
//import java.util.Random;

public class reserverLayer {
    public static double[][] Reserver(double[][][] win,double[][] r,double[][][] wu,double[][][] wx,double[][][] wy,double[][][] rx,double[][] x,double[][] xx,double[][] y,double[][][] w,double[][][] wfb,int Nx,int Ny,int count,double emax,double ganma){
        //int ascale = 1;                         //一様分布の正の範囲
        //int bscale = -1;                        //一様分布の負の範囲
        //double max;
        //double row[][] = new double[150][150];
        //double x2[][] = new double[Nx][Nx];
        //double rou[][] = new double[Nx1][Nx2];
        //System.out.println(wu[0][0]);
        //System.out.println(x[0][0]);
        //System.out.println(y[0][0]);
        //System.out.println(w[0][0]);
        //System.out.println(wfb[0][0]);

        /*//スペクトル半径の計算
        if(count!=0){
            INDArray matrix  = Nd4j.create(w); 
            //INDArray values2 = Nd4j.create(w);
            INDArray element = Nd4j.create(w);
            INDArray values3 = Nd4j.create(new double[]{1}, new int[]{1,1});
            //INDArray values4 = Nd4j.create(new double[]{0}, new int[]{1,1});
            INDArray values = Eigen.symmetricGeneralizedEigenvalues(matrix);    //wの固有値の計算
            INDArray matrix2 = values.reshape(15,10);
            //double[][] pr = new double[15][10];
            pr = matrix2.toDoubleMatrix();
            //System.out.println(values);
            //System.out.println(pr[0][0]);
            //pr = values.getDouble(1);
            //NDMath math = new NDMath();
            double emax=0;
            for(int i=0;i<15;i++){
                for(int j=0;j<10;j++){
                    pr[i][j] = Math.abs(pr[i][j]);
                }
            }
            for(int i=0;i<15;i++){
                for(int j=0;j<10;j++){
                    if(pr[i][j]<1.0){
                        if(emax < pr[i][j]){
                            emax = pr[i][j];
                            //pr = element.getDouble(1,1);
                        }
                    }
            //if(element[1]{1,1} <= 1)
            //break
                }
            }*/
            //System.out.println(emax);
            //pr = maxNumber(values);
            //System.out.println(pr);

            /*for(int i=0; i<150;i++){
                values2 = math.amax(values);
                if(values2.get(values2) == values3) 
                values2 = values4;
            }*?
         
            double[] c = values2.toDoubleVector();                             //行列を配列に変換
            double ganma = c[0];
            System.out.println(ganma);

            /*for(int i=0; i<150;i++){
                for(int j=0;j<150;j++){
                    if(ganma<c[i][j])
                        ganma = c[i][j];
                }
            }*/

            //INDArray matrix2 = matrix.reshape(20,20);
            //double ganma2 = 1/ganma;
            //double ganma2 = 0.8;        
            //NDMath math = new NDMath();
            //values = math.amax(values);                      //固有値の最大値
            //System.out.println(values);
            //INDArray scale1 = values;
            //double[][] cscale = values.toDoubleMatrix();     //行列を配列に変換
            //System.out.println(cscale);
            //values = values.mul(-1);                         //一様分布の正の範囲
            //INDArray scale2 = values;                        //一様分布の負の範囲
            //double[][] dscale = scale2.toDoubleMatrix();     //行列を配列に変換
            //INDArray scale3 = scale2.sub(scale1);
            //scale3 = scale3.add(scale3);

            //wのスケーリング
            ganma = 0.5;
            for(int i=0; i<Nx;i++){
                for(int j=0;j<Nx;j++){
                    for(int k=0;k<Ny;k++){
                        //入力層の重みの初期値
                        w[i][j][k] = w[i][j][k]*ganma;
                        //System.out.println("縦"+i+"横"+j+"の乱数"+rand[i][j]);
                    }
                }
            }

        //System.out.println(w[0][0]);

        /*//リカレント結合重みの生成（ランダムグラフ）
        Random rand = new Random();
        double randvalue = rand.nextDouble();
        for(int i=0; i<Nx1;i++){
            for(int j=0;j<Nx2;j++){
                if(randvalue>0.05)
                {
                    x[i][j] = 0;
                }
                else {
                    x[i][j] = randvalue;
                }
            }
        }*/

        //System.out.println(wu[0][0]);
        //System.out.println(w[0][0]);
        //System.out.println(x[0][0]);

        //Win*u
        for(int k=0; k<Ny;k++){
            for(int i=0;i<Nx;i++){
                for(int j=0;j<Nx;j++){   //シグマの役割
                    wu[i][j][k] = wu[i][j][k] + win[i][j][k]*r[i][j];
                    //System.out.println(Win[i][j]); 
                }
            }
        }

        //W*x
        for(int k=0; k<Ny;k++){
            for(int i=0;i<Nx;i++){
                for(int j=0;j<Nx;j++){   //シグマの役割
                    wx[i][j][k] = wx[i][j][k] + w[i][j][k]*x[i][j];
                    //System.out.println(Win[i][j]); 
                }
            }
        }

        //Win*y
        for(int k=0; k<Ny;k++){
            for(int i=0;i<Nx;i++){
                for(int j=0;j<Nx;j++){   //シグマの役割
                    wy[i][j][k] = wy[i][j][k] + wfb[i][j][k]*y[i][j];
                    //System.out.println(Win[i][j]); 
                }
            }
        }

        //リザバー状態ベクトルの更新
        for(int i=0; i<Nx;i++){
                for(int j=0;j<Nx;j++){
                    for(int k=0; k<Ny;k++){
                    //if(rx[i][j][k] != 0)
                    xx[i][j] = Math.tanh(wu[i][j][k] + wx[i][j][k]+wy[i][j][k]);
                    //xx[i][j] = Math.tanh(wu[i][j] + w[i][j][k]*x[i][j]+wfb[i][j][k]*y[i][j]);
                    //x2[i][j] = Math.tanh(xu[i][j] + w[i][j]*x[i][j] + wfb[i][j]*y[i][j]);
                    //System.out.println(p[i][j]);
                    //System.out.println(xx[i][j]); 
                }
            }
        }
        //System.out.println(x2[0][0]); 
        //System.out.println(x2[0][1]); 
        //System.out.println(x2[0][2]); 

        return xx;
    }
}
