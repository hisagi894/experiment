package esn;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

public class nrmse {
    public static void prediction(float[] y,float[][] d,int T,int yd){
        float[][] yre = new float[T][yd];
        float[][] dy = new float[T][yd];
        float[][] ddb = new float[T][yd];
        float db = 0;
        double ddb2 = 0;
        float[] dyre = new float[T]; 
        //double[][] dy = new double[400][300];
        double rmse = 0;
        double nrmse = 0;

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

        for(int i=0;i<T;i++){
            db += d[i][0]/T;
        }

        for(int i=0;i<T;i++){
            ddb[i][0] -= d[i][0]-db;
            ddb2 += ddb[i][0];
        }

            ddb2 = ddb2/T;
            ddb2 = Math.sqrt(ddb2);

            nrmse = rmse/ddb2;

        System.out.println("nrmse="+nrmse);
    }
}
