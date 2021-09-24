package esn;
//入力層
public class inputlayer {
    public static double[][][] rlayer(double[][][] win,double[][] r,int Nu,int Nx,double[][][] wi){
        //System.out.println(Integer.toHexString(data[0][0]));

        //Win*u
        for(int k=0; k<22500;k++){
            for(int i=0;i<Nu;i++){
                for(int j=0;j<Nu;j++){   //シグマの役割
                    wi[i][j][k] = wi[i][j][k] + win[i][j][k]*r[i][j];
                    //System.out.println(Win[i][j]); 
                }
            }
        }
        return wi;
    } 
}
