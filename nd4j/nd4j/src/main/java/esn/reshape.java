package esn;

public class reshape {
    public static float[][] input(float[][] re,int pi){
        float[][] u = new float[pi*pi][1];
        int ct=0;

        for(int i=0;i<pi;i++){
            for(int j=0;j<pi;j++){
                u[ct][0]=re[i][j];
                ct++;
            }
        }

        return u;

    }

    public static float[][] output(float[][] re,int pi){
        float[][] d = new float[pi*pi][1];
        int ct=0;

        for(int i=0;i<pi;i++){
            for(int j=0;j<pi;j++){
                d[ct][0]=re[i][j];
                ct++;
            }
        }

        return d;

    }

    public static float[] whiteout(double[][] re,int pi){
        float[] d = new float[pi*pi];
        int ct=0;

        for(int i=0;i<pi;i++){
            for(int j=0;j<pi;j++){
                d[ct]=(float)re[i][j];
                ct++;
            }
        }

        return d;

    }

    public static int[][] imageout(int[] re,int Ny){
        int[][] d = new int[Ny][Ny];
        int ct=0;

        for(int i=0;i<Ny;i++){
            for(int j=0;j<Ny;j++){
                d[i][j]=re[ct];
                ct++;
            }
        }

        return d;

    }
}
