package esn;

public class batchresult {
    public static float[] learn(double[][] wout,float[] x,int Nx,int Ny)
    {
        float[] learn = new float[Ny];
        for(int i=0; i<Ny;i++){
            for(int j=0;j<Nx;j++){
                learn[i] += wout[0][0] *= x[j];
            }
        }

        return learn;
    }
}
