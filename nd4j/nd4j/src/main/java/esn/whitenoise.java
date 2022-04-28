package esn;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

import checkers.units.quals.g;

public class whitenoise {
    public static void gaussian(int T,int Nu,int Ny){
        int[][] r = new int[Nu][Nu];
        double[][] r2 = new double[Nu][Nu];
        int[][] g = new int[Nu][Nu];
        double[][] g2 = new double[Nu][Nu];
        int[][] b = new int[Nu][Nu];
        double[][] b2 = new double[Nu][Nu];
        float[] yr = new float[T];
        float[] yg = new float[T];
        float[] yb = new float[T];
        int[] cyr = new int[T];
        int[] cyg = new int[T];
        int[] cyb = new int[T];
        int[] rgb = new int[T];
        Random random = new Random();
        double sd = 60; //標準偏差
        int i=0;
        int[] z = new int[T];
        int[][] last = new int[Ny][Ny];
    
        String inputname = Thread.currentThread().getContextClassLoader().getResource("Lennacolor.jpg").getPath();   //150*150
        String outputname = Thread.currentThread().getContextClassLoader().getResource("experiment2.png").getPath();;

            try{ //画像の読み込み
                BufferedImage rinImage = ImageIO.read(new File(inputname));
                BufferedImage routImage = ImageIO.read(new File(outputname));
                int inw = rinImage.getWidth();     
                int inh = rinImage.getHeight();
                //System.out.println(inw);
                //System.out.println(inh);
                BufferedImage wImage = new BufferedImage(inh, inw, BufferedImage.TYPE_INT_RGB);
    
                for(int y=0;y<inh;y++){
                    for(int x=0;x<inw;x++){
                        int in = rinImage.getRGB(y, x);
                        r[y][x] = ImageUtility.r(in);
                        g[y][x] = ImageUtility.g(in);
                        b[y][x] = ImageUtility.b(in);
                        r2[y][x] = r[y][x]+random.nextGaussian() * sd;
                        g2[y][x] = g[y][x]+random.nextGaussian() * sd;
                        b2[y][x] = b[y][x]+random.nextGaussian() * sd;
                        if(r2[y][x]>255){
                            r2[y][x]=255;
                        }
                        else if(r2[y][x]<0){
                            r2[y][x]=0;
                        }
                        if(g2[y][x]>255){
                            g2[y][x]=255;
                        }
                        else if(g2[y][x]<0){
                            g2[y][x]=0;
                        }
                        if(b2[y][x]>255){
                            b2[y][x]=255;
                        }
                        else if(b2[y][x]<0){
                            b2[y][x]=0;
                        }
                    }
                }
                yr = reshape.whiteout(r2,Nu);
                yg = reshape.whiteout(g2,Nu);
                yb = reshape.whiteout(b2,Nu);

                for(int y=0;y<T;y++){
                    cyr[y] = (int)yr[y];
                    cyg[y] = (int)yg[y];
                    cyb[y] = (int)yb[y];
                    rgb[y] = ImageUtility.rgb(cyr[y],cyg[y],cyb[y]);
                }

                last = reshape.imageout(rgb,Ny);

                for(int y=0;y<inh;y++){
                    for(int x=0;x<inw;x++){
                        wImage.setRGB(y,x,last[y][x]);
                    }
                }

                ImageIO.write(wImage, "png", new File("whitenoise2.png"));
            } catch(Exception e){
                e.printStackTrace();
            }


}


}
