package esn;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class rimage {
    public static double[][] red(){
    int[][] r = new int[150][150];
    double[][] r2 = new double[150][150];

    String inputname = "lennamono.jpg";   //150*150

        try{ //画像の読み込み
            BufferedImage rinImage = ImageIO.read(new File(inputname));
            int inw = rinImage.getWidth();     
            int inh = rinImage.getHeight();
            //System.out.println(inw);
            //System.out.println(inh);

            for(int y=0;y<inw;y++){
                for(int x=0;x<inh;x++){
                    int in = rinImage.getRGB(y, x);
                    r[y][x] = ImageUtility.r(in);
                    r2[y][x] = (double)r[y][x]/255.0;
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        //System.out.println(r[0][0]);
        return r2;
    } 
}

