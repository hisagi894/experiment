package esn;

//入力層
public class binputlayer {
    public static double[][] blayer(double[][] win,double[][] b){
    int Nx = 150;                             //入力層のノード数
    int Nu = 150;                             //リザバー層のノード数
    double[][] Wb= new double[Nx][Nu];   //一様分布の乱数
    
    //System.out.println(Integer.toHexString(data[0][0]));

    //Win*u
    for(int i=0; i<Nx;i++){
        for(int j=0;j<Nu;j++){
            Wb[i][j] = win[i][j]*b[i][j];
            //System.out.println(Win[i][j]); 
        }
    }
    return Wb;
} 
}
