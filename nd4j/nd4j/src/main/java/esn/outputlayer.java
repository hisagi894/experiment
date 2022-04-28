package esn;
public class outputlayer {
    public static double[][] outlayer(double[][] u,double[][] y,double[][] x2,int Nx,int Ny,float[] wout){
        //int Nx = 150;                             //リザバー層のノード数
        //int Ny = 150;                             //出力層のノード数
        //int ascale = 1;                         //正規分布の正の範囲
        //int bscale = 0;                         //正規分布の負の範囲
        //double[][] wout = new double[Nx][Ny];   //正規分布の乱数
        //double[][] y = new double[Nx][Ny];   //正規分布の乱数
        //int a=0;

        /*// 正規分布に従う乱数
        for(int i=0; i<Nx;i++){
            for(int j=0;j<Ny;j++){
                //入力層の重みの初期値
                wout[i][j] = ascale + (bscale - ascale)*Math.random();
                //System.out.println("縦"+i+"横"+j+"の乱数"+rand[i][j]);
            }
        }*/

        //System.out.println(wout[0][0][0]);
        //System.out.println(u[0][0]);
        //System.out.println(x2[0][0]);

        //出力状態ベクトルの更新
        int a=0;
            for(int i=0;i<Nx;i++){
                for(int j=0;j<Nx;j++){   //シグマの役割
                    //y[i][j] = 0;
                    y[i][j] = y[i][j] + wout[a]*(u[i][j]+x2[i][j]);
                    //System.out.println(y[i][j]);
                }
                a++;
            }
        System.out.println("y="+y[0][0]);

        //リザバー状態ベクトルの更新
        /*for(int i=0; i<Nx;i++){
            for(int j=0;j<Ny;j++){
                wout[i][j] = wout[i][j]*x2[i][j]-d[i][j];
            }
        }*/

        //System.out.println(wout[0][0][0]);

        //System.out.println(Integer.toHexString(data[0][0]));
        
        return y;
    }
    
}
