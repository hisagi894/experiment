package esn;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class bimage {
    public static double[][] blue(){
    int[][] b = new int[150][150];
    double[][] b2 = new double[150][150];

    String inputname = Thread.currentThread().getContextClassLoader().getResource("lennamono.jpg").getPath();

        try{ //画像の読み込み
            BufferedImage rinImage = ImageIO.read(new File(inputname));
            int inw = rinImage.getWidth();
            int inh = rinImage.getHeight();

            for(int y=0;y<inw;y++){
                for(int x=0;x<inh;x++){
                    int in = rinImage.getRGB(y, x);
                    b[y][x] = ImageUtility.b(in);
                    b2[y][x] = (double)b[y][x]/255.0f;
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        //System.out.println(b[0][0]);
        return b2;
    } 
}

