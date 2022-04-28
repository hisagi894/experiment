package esn;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

public class rmse {
    public static void prediction(float[] y,float[][] d,int T,int yd){
        float[][] yre = new float[T][yd];
        float[][] dy = new float[T][yd];
        float[] dyre = new float[T]; 
        //double[][] dy = new double[400][300];
        double rmse = 0;

        for(int i=0;i<T;i++){
            yre[i][0] = y[i];
        }

        INDArray Y = Nd4j.create(yre);
        INDArray D = Nd4j.create(d);
        INDArray DY = D.sub(Y);
        dy = DY.toFloatMatrix();

        for(int i=0;i<T;i++){
            dyre[i] = dy[i][0];
        }

        for(int i=0;i<T;i++){
            rmse += dyre[i];
        }

        rmse = rmse / T;

        rmse = Math.sqrt(rmse);

        System.out.println("rmse="+rmse);
    }
}
