package esn;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import javax.imageio.ImageIO;

public class change {
        public static int[][] rgb(double[][] r,double[][] g,double[][] b,int Nx,int Nu){
        int[][] rt = new int[Nu][Nu];
        int[][] gt = new int[Nu][Nu];
        int[][] bt = new int[Nu][Nu];
        int[][] ot = new int[Nu][Nu];
        int t=0;
        //System.out.println(r[0][0]);
        //System.out.println(g[0][0]);
        //System.out.println(b[0][0]);
            try{ //画像の読み込み
                for(int y=0;y<Nu;y=y+10){
                    for(int x=0;x<Nu;x=x+10){
                        while(t>10){
                            r[y+t][x+t] = r[y+t][x+t]*255;
                            rt[y+t][x+t] = (int)r[y+t][x+t];
                            g[y+t][x+t] = g[y+t][x+t]*255;
                            gt[y+t][x+t] = (int)g[y+t][x+t];
                            b[y+t][x+t] = b[y+t][x+t]*255;
                            bt[y+t][x+t] = (int)b[y+t][x+t];
                            ot[y+t][x+t] = ImageUtility.rgb(rt[y+t][x+t],gt[y+t][x+t],bt[y+t][x+t]);
                            //ot[y][x] = ImageUtility.rout(rt[y][x]);
                            //ot[y][x] = ImageUtility.gout(gt[y][x]);
                            //ot[y][x] = ImageUtility.bout(bt[y][x]);
                            t++;
                        }
                        t=0;
                    }
                }
                //System.out.println(rt[0][0]);
                //System.out.println(gt[0][0]);
                //System.out.println(bt[0][0]);
                //System.out.println(ot[0][0]);
                //System.out.println(Integer.toHexString(ot[0][0]));
                //System.out.println(r[1].length);
            } catch(Exception e){
                e.printStackTrace();
        }
        return ot;
    } 
}
