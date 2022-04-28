package esn;
import java.util.Random;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.eigen.Eigen;
import org.nd4j.linalg.factory.ops.NDMath;

public class connect {
    public static float[][] Reve(int Nx,float density,float rho){
        float[][] con = new float[Nx][Nx];
        float[][] pr = new float[1][Nx];
        float scale = 1.0f;
        int m = 20;
        int count = 0;
        m = (int)(Nx*(Nx-1)*density/2);
        //System.out.println(m);

        //リカレント結合重みの生成（ランダムグラフ）
        Random rand = new Random();
        double randvalue = rand.nextDouble();

        do {
            for(int i=0; i<Nx;i++){
                for(int j=0;j<Nx;j++){
                    if(count<m)
                    {
                        if(con[i][j] == 0)
                        {
                            if(randvalue<=0.1) 
                            {
                                con[i][j] = (float)(-scale + (scale + scale)*Math.random());
                                con[j][i] = (float)(-scale + (scale + scale)*Math.random());
                                count++;                  
                            }
                                randvalue = rand.nextDouble();
                        }
                    }
                }
            }
        }while(count<m);

        //スペクトル半径の計算
        INDArray matrix  = Nd4j.create(con); 
        //INDArray values2 = Nd4j.create(w);
        //INDArray element = Nd4j.create(con);
        //INDArray values3 = Nd4j.create(new double[]{1}, new int[]{1,1});
        //INDArray values4 = Nd4j.create(new double[]{0}, new int[]{1,1});
        INDArray values = Eigen.symmetricGeneralizedEigenvalues(matrix);    //wの固有値の計算
        INDArray matrix2 = values.reshape(1,Nx);
        //System.out.println(values);
        //double[][] pr = new double[15][10];
        pr = matrix2.toFloatMatrix();
        //System.out.println(values);
        //System.out.println(pr[0][0]);
        //pr = values.getdouble(1);
        //NDMath math = new NDMath();
        double emax=0;
        //pr[1][20](W)の絶対値を求める
        for(int i=0;i<1;i++){
            for(int j=0;j<Nx;j++){
                pr[i][j] = Math.abs(pr[i][j]);
            }
        }
        //pr[1][20](W)の絶対値の最大を求める
        for(int i=0;i<1;i++){
            for(int j=0;j<Nx;j++){
                if(pr[i][j]<1.0){
                    if(emax < pr[i][j]){
                        emax = pr[i][j];
                            //pr = element.getdouble(1,1);
                    }
                }
            //if(element[1]{1,1} <= 1)
            //break
            }
        }
        //System.out.println(emax);

        for(int i=0; i<Nx;i++){
            for(int j=0;j<Nx;j++){
                con[i][j] *= rho / emax;
                //if(con[i][j]!=0)
                //System.out.println(con[i][j]); 
            }
        }
        return con;
    }
}
