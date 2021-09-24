package esn;
import java.util.Random;

public class revec {
    public static double[][][] Revec(double[][][] rx,int Nx,int Ny){
        //int ct = 0;
        //double[][] x = new double[Nx1][Nx2];        //リザバー状態ベクトル 
        //リカレント結合重みの生成（ランダムグラフ）
        Random rand = new Random();
        double randvalue = rand.nextDouble();
        //System.out.println(randvalue);
        for(int i=0; i<Nx;i++){
            for(int j=0;j<Nx;j++){
                for(int k=0;k<Ny;k++){
                    //System.out.println(randvalue);
                    if(randvalue>=0.1) 
                    {
                        rx[i][j][k] = 0;
                        //System.out.println(x[i][j]);
                    }
                    else {
                        //if(ct<20)
                        rx[i][j][k] = randvalue;
                        //System.out.println(x[i][j]);
                        //ct++;
                    }
                    randvalue = rand.nextDouble();
                }
            }
        }
        //System.out.println(x[0][0]);
        return rx;
    }
}
