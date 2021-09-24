package esn;
public class win {
    public static double[][][] wscale(double a,double b,int Nx,int Ny){
        //int ascale = 1;                         //一様分布の正の範囲
        //int bscale = -1;                        //一様分布の負の範囲
        //double[][] Wr= new double[Nx][Nu];   //一様分布の乱数
        double[][][] Win = new double[Nx][Nu][1];    //入力層の重み

        // 一様分布に従う乱数
        for(int i=0; i<Nx;i++){
            for(int j=0;j<Nx;j++){
                for(int k=0;k<Ny;k++){
                //入力層の重みの初期値
                Win[i][j][k] = a + (b - a)*Math.random();
                //System.out.println("縦"+i+"横"+j+"の乱数"+rand[i][j]);
            }
        }
    }        
        return Win;
    }
}
