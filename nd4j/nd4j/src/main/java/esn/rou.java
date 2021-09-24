package esn;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.eigen.Eigen;
import java.lang.Math;

public class rou {
    public static double spectrum(double[][] w,double[][] pr){
        INDArray matrix  = Nd4j.create(w); 
        INDArray values = Eigen.symmetricGeneralizedEigenvalues(matrix);    //wの固有値の計算
        INDArray matrix2 = values.reshape(15,10);
        pr = matrix2.toDoubleMatrix();
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
                        }
                    }
                }
            }
            emax = 0.9;
            return emax;
    }
}
