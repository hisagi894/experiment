package esn;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import javax.imageio.ImageIO;

public class rgbchange {
        public static int[] rgb(float[] r,float[] g,float[] b,int T){
        int[] rt = new int[T];
        int[] gt = new int[T];
        int[] bt = new int[T];
        int[] ot = new int[T];

            try{ //画像の読み込み
                for(int y=0;y<T;y++){
                                r[y] = r[y]*255;
                                rt[y] = (int)r[y];
                                g[y] = g[y]*255;
                                gt[y] = (int)g[y];
                                b[y] = b[y]*255;
                                bt[y] = (int)b[y];
                                ot[y] = ImageUtility.rgb(rt[y],gt[y],bt[y]);
                                //System.out.println(Integer.toHexString(ot[y]));
                }
            } catch(Exception e){
                e.printStackTrace();
        }
        return ot;
    }

    public static int[] noise(float[] r,float[] g,float[] b,int T){
        int[] rt = new int[T];
        int[] gt = new int[T];
        int[] bt = new int[T];
        int[] ot = new int[T];

            try{ //画像の読み込み
                for(int y=0;y<T;y++){
                                r[y] = r[y]*255;
                                rt[y] = (int)r[y];
                                g[y] = g[y]*255;
                                gt[y] = (int)g[y];
                                b[y] = b[y]*255;
                                bt[y] = (int)b[y];
                                ot[y] = ImageUtility.rgb(rt[y],gt[y],bt[y]);
                                //System.out.println(Integer.toHexString(ot[y]));
                }
            } catch(Exception e){
                e.printStackTrace();
        }
        return ot;
    } 
}
