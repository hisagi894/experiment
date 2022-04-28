package esn;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

//import org.nd4j.linalg.api.ndarray.INDArray;

public class ESNMain {
    public static void main(String[] args){
        //線形回帰(XOR)
        int i=2,j=0;
        int T=50;
        float density = 0.1f;
        float rho = 0.9f;
        int Nu = 50;                             //入力層のノード数
        int Nx = 20;                             //リザバー層のノード数
        int Ny = 50;
        int ud = 1;
        int yd = 1;
        int[][] u =  new int[1][Nu];
        int[][] b =  new int[1][Nu];
        int[][] ru =  new int[Nu][1];
        int[][] rb =  new int[Nu][1];
        float[][] tmpu =  new float[ud][ud];
        int[][] d =  new int[1][Ny];
        int[][] s =  new int[1][Ny];
        int[][] rd =  new int[Ny][1];
        float[][] tmpd =  new float[yd][yd];
        float[][] W = new float[Nx][Nx];     //リザバー状態ベクトル
        float[] x = new float[Nx];         //リザバー状態ベクトル
        float[] y = new float[Ny];        //y[1][50]
        float[] result = new float[Ny];        //y[1][50]
        float[][] Win = new float[Nx][ud];      //入力重み[y次元][出力データ]
        float[][] Wout = new float[yd][Nx];     //出力重み[y次元][出力データ]
        float[][] xxt = new float[Nx][Nx];    //出力重み
        float[][] dxt = new float[yd][Nx];    //出力重み
        float[] Wu = new float[Nx];
        int prrnd = 2;
        int ternd = 1;

        //線形回帰(XOR)
        u = batch.input(Nu,prrnd);  //入力データ50 u[1][50]
        d = batch.output(Nu,Ny,prrnd); //出力データ50 d[1][48]

        //入出力を[50][1]の型変換(reshape)
        INDArray t_u = Nd4j.create(u);      //t_u[1][50]
        INDArray t_ut = t_u.transpose();    //t_ut[50][1]
        //System.out.println(t_ut);
        ru = t_ut.toIntMatrix();            //ru[50][1]
        INDArray t_d = Nd4j.create(d);      //t_d[1][48]
        INDArray t_dt = t_d.transpose();    //t_dt[48][1]
        //System.out.println(t_dt);
        rd = t_dt.toIntMatrix();            //rd[48][1]
        //リザバー状態ベクトルの設定
        W = connect.Reve(Nx,density,rho);  //W[20][20]
        //INDArray rx2 = Nd4j.create(W);
        //System.out.println(rx2);
        //重みの計算
        Win = node.wnode(-1.0f,1.0f,Nx,ud); //Win[20][1]
        //INDArray rx2 = Nd4j.create(Win);
        //System.out.println(rx2);
        Wout = batchout.output(Nx,yd);      //Wout[1][20]
        //INDArray rx2 = Nd4j.create(Win);
        //System.out.println(rx2);

        while(i<T){
            tmpu[0][0]=(float)ru[i][0];   //tmpu[0]←ru[0~49][0]
            tmpd[0][0]=(float)rd[i][0];   //tmpd[0]←rd[0~47][0]
            //System.out.println(tmpu[0]);
            //System.out.println(tmpd[0]);
            //Wu = node.wu(Win,ru,Nx,Nu);
            Wu = node.wu(Win,tmpu,Nx,ud);           //Wu[20]←Win[20][1],tmpu[1],Nx=20,ud=1
            //INDArray ex = Nd4j.create(Wu);
            //System.out.println(ex);
            //System.out.println(XXT);
            x = reseupdate.update(Wu,Nx,W,x,i);    //x[20]←Wu[20],Nx=20,rx[20][20],x[20],i
            //System.out.println(Wu);
            xxt = moorepen.xxt(x,xxt,Nx);           //xxt[20][20]←x[20],xxt[20][20],Nx=20
            //INDArray XXT = Nd4j.create(xxt);
            //System.out.println(XXT);
            //dxt = moorepen.dxt(rd,x,dxt,Nx,Ny);
            dxt = moorepen.dxt(tmpd,x,dxt,Nx,Ny);   //dxt[1][20]←tmpd[1],x[20],dxt[1][20],Nx=20,Ny=50
            //INDArray DXT = Nd4j.create(dxt);
            //System.out.println("DXT"+DXT);
            //System.out.println(xxt[0][0]);
            //INDArray rex = Nd4j.create(xxt);
            //System.out.println(rex);
            //INDArray dex = Nd4j.create(dxt);
            //System.out.println(dex);
            //System.out.println(dxt[0][0]);
            y[i] = batchout.woutx(Wout,x,Nx,yd);       //y[1][20]←Wout[1][20],x[20],Nx=20,yd=1
            //System.out.println(y[0][0]);
            tmpu[0][0]=0;
            tmpd[0][0]=0;
            i++;
        }

        //INDArray rey = Nd4j.create(y);
        //System.out.println(rey);

        for(i=0;i<Nx;i++){
            for(j=0;j<Nx;j++){
                //System.out.println(xxt[i][j]);
            }
        }
        for(i=0;i<Ny;i++){
            for(j=0;j<Nx;j++){
                //System.out.println(dxt[i][j]);
            }
        }


        Wout = moorepen.mp(xxt,dxt,Nx,yd);

        for(i=0;i<Nx;i++){
            Wu[i]=0;
        }
        for(i=0;i<Nx;i++){
            x[i]=0;
        }
        for(j=0;j<Nx;j++){
            y[j]=0;
        }

        for(i=0;i<Nx;i++){
            //System.out.println(Wout[6][i]);
        }

        i=0;

        while(i<T){
            tmpu[0][0]=(float)ru[i][0];
            //Wu = node.wu(Win,ru,Nx,Nu);
            Wu = node.wu(Win,tmpu,Nx,ud);
            x = reseupdate.update(Wu,Nx,W,x,i);
            //System.out.println(Wout[0][0]);
            //System.out.println(x[0][0]);
            y[i] = batchout.woutx(Wout,x,Nx,yd);
            if(y[i]<0.5){
                result[i] = 0;
            }
            else{
                result[i] = 1;
            }
            //System.out.println(y[i][0]);
            tmpu[0][0]=0;
            i++;
        }

        INDArray rex = Nd4j.create(d);
        System.out.println(rex);

        //INDArray rew = Nd4j.create(Wout);
        //System.out.println(rew);

        //INDArray rey2 = Nd4j.create(y);
        //System.out.println(rey2);

        INDArray rey2 = Nd4j.create(result);
        System.out.println(rey2);

        for(i=0;i<Nx;i++){
            //System.out.println(x[i][0]);
        }

        for(i=0;i<Nu;i++){
            for(j=0;j<Nx;j++){
                //System.out.println(Wout[i][j]);
            }
        }

        for(i=0;i<Ny;i++){
            //System.out.println(ru[i][0]);
        }

        for(i=0;i<Ny;i++){
            //System.out.println(y[i][0]);
        }

    }
}
