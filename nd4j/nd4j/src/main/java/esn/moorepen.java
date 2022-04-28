package esn;
import java.util.Random;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.eigen.Eigen;
import org.nd4j.linalg.factory.ops.NDMath;
import org.nd4j.linalg.inverse.InvertMatrix;

public class moorepen {
    public static float[][] mp(float[][] xxt,float[][] dxt,int Nx,int yd){
        float[][] wout = new float[yd][Nx];
        /*double ad,bc;

        ad =xxt[0][0]*xxt[1][1];
        bc =xxt[0][19]*xxt[1][18];

        for(int i=2;i<Nx;i++){
            ad *=xxt[i][i];
        }

        for(int i=2;i<Nx;i++){
            bc *=xxt[i][19-i];
        }

        System.out.println(ad-bc);*/

        INDArray XXT2 = Nd4j.create(xxt);        //xxt[20][20]
        //System.out.println(XXT2);
        //System.out.println(XXT.rows());
        //System.out.println(XXT.columns());
        INDArray XXtiv = InvertMatrix.invert(XXT2, false);
        //System.out.println(X);
        INDArray DXT = Nd4j.create(dxt);    //dxt[1][20]
        //System.out.println(D);
        //System.out.println(DXT);
        //System.out.println(XXtiv);

        INDArray Wout1 = DXT.mmul(XXtiv);       //xxt[1][20]
        //System.out.println(Wout);
        //INDArray Dt = D.transpose();
        INDArray WOUT = Wout1.reshape(yd,Nx);
        //System.out.println(WOUT);
        wout = WOUT.toFloatMatrix();

        return wout;
    }

    public static float[][] xxt(float[] x,float[][] sum,int Nx){
        float[][] xp = new float[Nx][Nx];         //xp[20][20]
        float[][] xreshape = new float[Nx][1];    //xreshape[20][1]

        for(int i=0;i<Nx;i++){
            xreshape[i][0]=x[i];    
        }

        INDArray X = Nd4j.create(xreshape);     //X[20][1]
        //System.out.println(X);
        INDArray Xt = X.transpose();            //Xt[1][20]
        INDArray XXt = X.mmul(Xt);              //XXt[20][20]
        INDArray Sum = Nd4j.create(sum);        //Sum[20][20]
        Sum = Sum.add(XXt);
        //System.out.println(Sum);
        xp = Sum.toFloatMatrix();              //xp[20][20]
        /*for(int i=0;i<Nx*Nx;i++){
            for(int j=0;j<Nx*Nx;j++){
                System.out.println(xp[i][j]);
                ct++;
            }
        }*/

        return xp;      //xp[20][20]
    }

    public static float[][] dxt(float[][] rd,float[] x,float[][] sum,int Nx,int Ny){
        float[][] dp = new float[1][Nx];          //dp[1][20]
        float[][] RX = new float[1][1];           //RX[1][1]
        float[][] xreshape = new float[Nx][1];    //xreshape[20][1]

        RX[0][0] =rd[0][0];

        for(int i=0;i<Nx;i++){
                xreshape[i][0]=x[i];            
        }

        INDArray X = Nd4j.create(xreshape);     //X[20][1]
        //System.out.println(X);
        INDArray Xt = X.transpose();            //Xt[1][20]
        INDArray D = Nd4j.create(RX);           //D[1][1]
        INDArray DXt = D.mmul(Xt);              //DXt[1][20]
        //q = DXt.toDoubleMatrix();

        /*for(int i=0;i<1;i++){
            for(int j=0;j<Nx*Nx;j++){
                qreshape[j]=q[0][j]; //qreshape[400]
            }
        }*/
        //INDArray qre = Nd4j.create(qreshape);   //D[400]
        INDArray Sum = Nd4j.create(sum);            //Sum[1][20]
        //System.out.println(Xt);
        //System.out.println(D);
        Sum = Sum.add(DXt);
        //System.out.println(Sum);
        dp = Sum.toFloatMatrix();                  //dp[1][20]

        return dp;
    }
}
