package esn;
public class rmse {
    public static void prediction(double[][] Y,int[][] d){
        int T=100;
        double[][] e = new double[500][400];
        //double[][] dy = new double[400][300];
        double rmse = 0;

        for(int y=0;y<400;y++){
            for(int x=0;x<300;x++){
                e[y][x] = d[y][x] - Y[y][x];
            }
        }

        for(int y=0;y<500;y++){
            for(int x=0;x<400;x++){
                rmse = rmse + e[y][x];
            }
        }
        rmse = rmse / T;

        rmse = Math.sqrt(rmse);

        System.out.println("rmse="+rmse);
    }
}
