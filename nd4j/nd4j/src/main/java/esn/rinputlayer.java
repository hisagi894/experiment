package esn;
//入力層
public class rinputlayer {
    public static double[][] rlayer(double[][] win,double[][] r,int Nu,int Nx,double[][] wr){
    //System.out.println(Integer.toHexString(data[0][0]));

    //Win*u
    for(int i=0; i<Nx;i++){
        for(int j=0;j<Nu;j++){
            wr[i][j] = win[i][j]*r[i][j];
            //System.out.println(Win[i][j]); 
        }
    }
    return wr;
} 
}
