package esn;

public class optimizer {
    public static float[][] linear(int[] d,float[] x,int Nx,int Ny,double[][] Xt)
    {
        float[][] xt = new float[Nx][Nx];
        float[][] dt = new float[Ny][Nx];
        float[][] wout = new float[Ny][Nx];

        //二次元配列に変換
        for(int i=0; i<Nx;i++){
            for(int j=0; j<Nx;j++){
                xt[i][j] = x[j];
                dt[i][j] = d[j];
            }
        }

        for(int i=0; i<Nx;i++){
            for(int j=0; j<Nx;j++){
                xt[i][j] += xt[i][j]*xt[j][i];
                dt[i][j] += dt[i][j]*xt[j][i];
            }
        }

        for(int i=0; i<Nx;i++){
            for(int j=0; j<Nx;j++){
                wout[i][j]=(float)(dt[i][j]*Xt[i][j]);
            }
        }

        return wout;
    }
    
}
