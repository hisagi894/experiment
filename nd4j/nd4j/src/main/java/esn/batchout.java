package esn;
import java.util.Random;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

public class batchout {
    public static float[][] output(int Nx,int yd)
    {
        float[][] wout = new float[yd][Nx];
        Random rnd = new Random();

        for(int i=0; i<yd;i++){
            for(int j=0;j<Nx;j++){
                wout[i][j]=(float)rnd.nextGaussian();
                //System.out.println(wout[i][j]);
            }
        }

        return wout;
    }

    public static float woutx(float[][] wout,float[] x,int Nx,int yd)
    {
        float[][] Y = new float[1][1];    //Y[20]
        float[][] xreshape = new float[Nx][1];    //xreshape[20][1]
        float[] yreshape = new float[1];    //xreshape[20][1]

        for(int i=0;i<Nx;i++){
            xreshape[i][0]=x[i];            
        }

        INDArray WOUT = Nd4j.create(wout);  //WOUT[1][20]
        //System.out.println(WOUT);
        INDArray X = Nd4j.create(xreshape);        //X[20][1]
        //System.out.println(X);
        INDArray WX = WOUT.mmul(X);         //WX[1][1]
        //System.out.println(WX);
        Y = WX.toFloatMatrix();

        yreshape[0]=Y[0][0];            

        return yreshape[0];
    }

    public static float regular(float[][] wout,float[] x,float[][] u,int Nx,int yd)
    {
        float[][] Y = new float[1][1];    //Y[20]
        float[][] xreshape = new float[Nx][1];    //xreshape[20][1]
        float[][] ux = new float[Nx][1];    //xreshape[20][1]
        float[] yreshape = new float[1];    //xreshape[20][1]

        for(int i=0;i<Nx;i++){
            ux[i][0] = u[0][0]+x[i];            
        }

        INDArray WOUT = Nd4j.create(wout);  //WOUT[1][20]
        INDArray UX = Nd4j.create(ux);  //WOUT[1][20]
        //System.out.println(WOUT);
        //INDArray X = Nd4j.create(xreshape);        //X[20][1]
        //System.out.println(X);
        INDArray WUX = WOUT.mmul(UX);         //WX[1][1]
        //System.out.println(WX);
        Y = WUX.toFloatMatrix();

        yreshape[0]=Y[0][0];            

        return yreshape[0];
    }
}
