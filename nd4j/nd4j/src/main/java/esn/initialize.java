package esn;

public class initialize {
    public static float[] uini(float[] u, int Nx){

        for(int i=0;i<Nx;i++){
            u[i]=0;
        }

        return u;
    }

    public static float[] xini(float[] x, int Nx){

        for(int i=0;i<Nx;i++){
            x[i]=0;
        }

        return x;
    }
    
    public static float[] yini(float[] y, int Nx){

        for(int i=0;i<Nx;i++){
            y[i]=0;
        }

        return y;
    }

    public static float[][] xxtini(float[][] xxt, int Nx){

        for(int i=0;i<Nx;i++){
            for(int j=0;j<Nx;j++){
                xxt[i][j]=0;
            }
        }

        return xxt;
    }

    public static float[][] dxtini(float[][] dxt, int yd,int Nx){

        for(int i=0;i<Nx;i++){
            dxt[yd-1][i]=0;
        }

        return dxt;
    }
}
