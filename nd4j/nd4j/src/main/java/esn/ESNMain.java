package esn;
public class ESNMain {
    public static void main(String[] args){
        int i=0;
        int T=100;
        double elms = 0;
        double ganma = 0;
        double it = 0.5;
        double maxeigen=0;
        int Nu = 150;                             //入力層のノード数
        int Nx = 15;                             //リザバー層のノード数
        int Ny = 225;                             //出力層のノード数
        double[][] r = new double[Nu][Nu];              //rニューロン
        double[][] g = new double[Nu][Nu];              //gニューロン
        double[][] b = new double[Nu][Nu];              //bニューロン
        double[][] dr = new double[Nu][Nu];             //drニューロン
        double[][] dg = new double[Nu][Nu];             //dgニューロン
        double[][] db = new double[Nu][Nu];             //dbニューロン
        //double[][] rer = new double[Nx][Nx];        //リザバー状態ベクトル
        //double[][] reg = new double[Nx][Nx];        //リザバー状態ベクトル
        //double[][] reb = new double[Nx][Nx];        //リザバー状態ベクトル
        double[][][] rx = new double[Nx][Nx][Ny];     //リザバー状態ベクトル
        double[][] xr = new double[Nx][Nx];        //リザバー状態ベクトル 
        double[][] xg = new double[Nx][Nx];        //リザバー状態ベクトル 
        double[][] xb = new double[Nx][Nx];        //リザバー状態ベクトル  
        double[][] x2 = new double[Nx][Nx];         //リザバー状態ベクトル 
        //double[][] y = new double[Nx][Ny];          //正規分布の乱数   
        double[][] e = new double[Nx][Nx];
        double[][][] wout = new double[Nx][Nx][Ny];
        double[][][] Win = new double[Nx][Nx][Ny];      //入力重み
        double[][][] W = new double[Nx][Nx][Ny];        //リザバー重み
        double[][][] Wout = new double[Nx][Nx][Ny];    //出力重み
        double[][][] Wfb = new double[Nx][Nx][Ny];      //フィードバック重み
        double[] Wu = new double[Ny];       //wu(r)
        //double[][][] wg = new double[Nx][Nx][22500];       //wu(g)
        //double[][][] wb = new double[Nx][Nx][22500];       //wu(b)
        double[] wrx = new double[Ny];       //wx(r)
        double[] wgx = new double[Ny];       //wx(b)
        double[] wbx = new double[Ny];       //wx(b)
        double[] wy = new double[Ny];       //wx(b)
        double[][] wrwx= new double[Nx][Nx];      //xr
        double[][] wgwx= new double[Nx][Nx];      //xg
        double[][] wbwx= new double[Nx][Nx];      //xb
        double[][] yr = new double[Nx][Nx];       //yr
        double[][] yg = new double[Nx][Nx];       //yg
        double[][] yb = new double[Nx][Nx];       //yb
        double[][][] Lmsr = new double[Nx][Nx][Ny];     //Wout(r)
        double[][][] Lmsg = new double[Nx][Nx][Ny];     //Wout(g)
        double[][][] Lmsb = new double[Nx][Nx][Ny];     //Wout(b)
        int[][] rgb = new int[Nu][Nu];            //Wout(b)
        //double[][] pr = new double[15][10];

        //入力データの呼び出し
        r = rimage.red();
        g = gimage.green();
        b = bimage.blue();
        //System.out.println(r[0][0]);
        //System.out.println(g[0][0]);
        //System.out.println(b[0][0]);

        //出力データの呼び出し
        dr = routimage.outred();
        dg = goutimage.outgreen();
        db = boutimage.outblue();
        //System.out.println(dr[0][0]);
        //System.out.println(dg[0][0]);
        //System.out.println(db[0][0]);

        //リザバー状態ベクトルの設定
        rx = revec.Revec(rx,Nx,Ny);
        //xr = x;
        //xg = x;
        //xb = x;
        //System.out.println(x[0][0]);
        //System.out.println(x[0][1]);
        //System.out.println(x[0][2]);

        //Winの重みの計算
        Win = win.wscale(0.5,-0.5,Nx,Ny);
        W = win.wscale(1,-1,Nx,Ny);
        Wout = win.wscale(0,0,Nx,Ny);
        Wfb = win.wscale(0.8,-0.8,Nx,Ny);
        //System.out.println(Win[0][0]);
        //System.out.println(W[0][0]);
        //System.out.println(Wout[0][0]);
        //System.out.println(Wfb[0][0]);

        //Woutの重みの計算
        Lmsr = Wout;
        Lmsg = Wout;
        Lmsb = Wout;
        //System.out.println(Lmsr[0][0]);
        //System.out.println(Lmsg[0][0]);
        //System.out.println(Lmsb[0][0]);

        //スペクトル半径
        //maxeigen = rou.spectrum(W,pr);
        maxeigen =0.9;

        for(int v=0; v<Nx;v++){
            for(int j=0;j<Nx;j++){
                //入力層の重みの初期値
                yr[v][j] = 0;
                yg[v][j] = 0;
                yb[v][j] = 0;
                xr[v][j] = 0.5;
                xg[v][j] = 0.5;
                xb[v][j] = 0.5;
                //System.out.println("縦"+i+"横"+j+"の乱数"+rand[i][j]);
            }
        }

        while(i<T){
            //rgb入力層の計算
            //wr = inputlayer.rlayer(Win,r,Nu,Nx,wr);
            //wg = inputlayer.rlayer(Win,g,Nu,Nx,wg);
            //wb = inputlayer.rlayer(Win,b,Nu,Nx,wb);
            //System.out.println(wr[0][0]);
            //System.out.println(wg[0][0]);
            //System.out.println(wb[0][0]);

            //入力データとリザバー結合重みを送ってリザバー結合重みを得る
            if(i==0){
                //スペクトル半径
                //maxeigen = rou.spectrum(W,pr);
                wrwx = reserverLayer.Reserver(Win,r,Wu,wrx,wy,rx,xr,x2,yr,W,Wfb,Nx,Ny,0,maxeigen,ganma);
                wgwx = reserverLayer.Reserver(Win,g,Wu,wgx,wy,rx,xg,x2,yg,W,Wfb,Nx,Ny,0,maxeigen,ganma);
                wbwx = reserverLayer.Reserver(Win,b,Wu,wbx,wy,rx,xb,x2,yb,W,Wfb,Nx,Ny,0,maxeigen,ganma);
                xr=wrwx;
                xg=wgwx;
                xb=wbwx;
                //System.out.println(xr[0][0]);
                //System.out.println(xg[0][0]);
                //System.out.println(xb[0][0]);
                //System.out.println(maxeigen);
            }
            else{
                //スペクトル半径
                //maxeigen = rou.spectrum(W,pr);
                wrwx = reserverLayer.Reserver(Win,r,Wu,wrx,wy,rx,xr,x2,yr,W,Wfb,Nx,Ny,i,maxeigen,ganma);
                wgwx = reserverLayer.Reserver(Win,g,Wu,wgx,wy,rx,xg,x2,yg,W,Wfb,Nx,Ny,i,maxeigen,ganma);
                wbwx = reserverLayer.Reserver(Win,b,Wu,wbx,wy,rx,xb,x2,yb,W,Wfb,Nx,Ny,i,maxeigen,ganma);
                xr=wrwx;
                xg=wgwx;
                xb=wbwx;
                //System.out.println(xr[0][0]);
                //System.out.println(maxeigen);
            }

            //System.out.println(wrwx[0][0]);

            //リザバー結合重みを送って、出力結果を得る
            yr = outputlayer.outlayer(r,yr,wrwx,Nx,Ny,Lmsr);
            yg = outputlayer.outlayer(g,yg,wgwx,Nx,Ny,Lmsg);
            yb = outputlayer.outlayer(b,yb,wbwx,Nx,Ny,Lmsb);
            //System.out.println(yr[0][0]);
            //System.out.println(yg[0][0]);
            //System.out.println(yb[0][0]);
            i++;

            //LMS法
            Lmsr = lms.Elms(yr,dr,wout,e,Lmsr,wrwx,elms,it,Nx,Ny);
            Lmsg = lms.Elms(yg,dg,wout,e,Lmsg,wgwx,elms,it,Nx,Ny);
            Lmsb = lms.Elms(yb,db,wout,e,Lmsb,wbwx,elms,it,Nx,Ny);
            //System.out.println(yr[0][0]);
            //System.out.println(yg[0][0]);
            //System.out.println(yb[0][0]);
            //System.out.println("wout"+Lmsr[0][0]);

            //r = yr;
            //g = yg;
            //b = yb;
        }

        //System.out.println(Wout[0][0]);
        //System.out.println(Lmsr[0][0]);
        //System.out.println(Lmsg[0][0]);
        //System.out.println(Lmsb[0][0]);
        //System.out.println(r[0][0]);
        //System.out.println(g[0][0]);
        //System.out.println(b[0][0]);
        //System.out.println(dr[0][0]);
        //System.out.println(dg[0][0]);
        //System.out.println(db[0][0]);

        //System.out.println(yr[0][0]);
        //System.out.println(yg[0][0]);
        //System.out.println(yb[0][0]);


        //画像出力
        rgb = change.rgb(yr,yg,yb,Nx,Nu);
        //System.out.println(rgb[0][0]);
        //System.out.println(rgb[0][1]);
        //System.out.println(rgb[0][2]);
        //System.out.println(Integer.toHexString(rgb[0][0]));

        //画像出力
        output.routput(rgb);
        //output.routput(rgb);
        //output.routput(rgb);
        
        //System.out.println("yr="+yr[0][0]);
        //System.out.println("yg="+yg[0][0]);
        //System.out.println("yb="+yb[0][0]);

        //System.out.println("Lmsr="+Lmsr[0][0]);
        //System.out.println("Lmsg="+Lmsg[0][0]);
        //System.out.println("Lmsb="+Lmsb[0][0]);

        //線形回帰
        //linear.linear1(data3);

        //予測性能の評価
        //rmse.prediction(yr,dr);
        //rmse.prediction(yg,dg);
        //rmse.prediction(yb,db);
        //System.out.println(data2[0][0]);

    }
}
