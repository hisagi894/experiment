package esn;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

public class lms2 {
    public static float[][] out(float[][] wout,float[] x,float d,int Nx,int yd){
        //float[][] wout = new float[yd][Nx];
        float[][] xreshape = new float[Nx][1];    //xreshape[20][1]
        float[][] wx = new float[yd][1];    //xreshape[20][1]
        float[][] ie = new float[yd][yd];
        float[][] xt = new float[1][Nx];    //xreshape[20][1]
        float ita = 0.12f;

        for(int i=0;i<Nx;i++){
            xreshape[i][0]=x[i];    
        }

        INDArray Wout = Nd4j.create(wout);
        INDArray X = Nd4j.create(xreshape);
        INDArray Xt = X.transpose();
        xt = Xt.toFloatMatrix();
        INDArray WX = Wout.mmul(X);
        wx = WX.toFloatMatrix();

        ie[0][0] = ita*(d - wx[0][0]);

        /*for(int i=0;i<Nx;i++){
            xt[0][i]=ita*xt[0][i];    
        }*/

        INDArray Xt2 = Nd4j.create(xt);
        INDArray IE = Nd4j.create(ie);
        INDArray IEXt = IE.mmul(Xt2);
        INDArray WOUT = Wout.add(IEXt);
        wout = WOUT.toFloatMatrix();        

        return wout;
    }
}
