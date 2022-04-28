package esn;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

public class transpose {
    public static float[][] tp(float[][] res,int Nu){
        float[][] t = new float[Nu][1];

        INDArray t_u = Nd4j.create(res);      //t_u[1][50]
        INDArray t_ut = t_u.transpose();    //t_ut[50][1]
        t = t_ut.toFloatMatrix();            //ru[50][1]
        return t;
    }
}
