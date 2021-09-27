package esn;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class boutimage {
    public static double[][] outblue(){
    int[][] b = new int[500][400];
    double[][] bd = new double[150][150];

    String inputname = Thread.currentThread().getContextClassLoader().getResource("Lennacolor.jpg").getPath();;

        try{ //画像の読み込み
            BufferedImage rinImage = ImageIO.read(new File(inputname));
            int inw = rinImage.getWidth();
            int inh = rinImage.getHeight();

            for(int y=0;y<inw;y++){
                for(int x=0;x<inh;x++){
                    int in = rinImage.getRGB(y, x);
                    b[y][x] = ImageUtility.b(in);
                    bd[y][x] = (double)b[y][x]/255.0;
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        //System.out.println(b[0][0]);
        return bd;
    } 
}


