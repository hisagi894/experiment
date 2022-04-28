package esn;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import javax.imageio.ImageIO;

public class change {
        public static int[][] rgb(double[][] r,double[][] g,double[][] b,int Nx,int Ny){
        int[][] rt = new int[150][150];
        int[][] gt = new int[150][150];
        int[][] bt = new int[150][150];
        int[][] ot = new int[150][150];
        int t=0;
        int k=0;
        //System.out.println(r[0][0]);
        //System.out.println(g[0][0]);
        //System.out.println(b[0][0]);

            try{ //画像の読み込み
                for(int y=0;y<150;y++){
                    for(int x=0;x<150;x++){
                        //while(k<10){
                            //while(t<10){
                                //if(t==0){
                                r[y][x] = r[y][x]*255;
                                //}
                                rt[y][x] = (int)r[y][x];
                                //if(t==0){
                                g[y][x] = g[y][x]*255;
                                //}
                                gt[y][x] = (int)g[y][x];
                                //if(t==0){
                                b[y][x] = b[y][x]*255;
                                //}
                                bt[y][x] = (int)b[y][x];
                                ot[y][x] = ImageUtility.rgb(rt[y][x],gt[y][x],bt[y][x]);
                                //ot[y][x] = ImageUtility.rout(rt[y][x]);
                                //ot[y][x] = ImageUtility.gout(gt[y][x]);
                                //ot[y][x] = ImageUtility.bout(bt[y][x]);
                                //System.out.println(Integer.toHexString(ot[y][x]));
                                //t++;
                            //}
                            //t=0;
                            //k++;
                        //}
                        //k=0;
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
