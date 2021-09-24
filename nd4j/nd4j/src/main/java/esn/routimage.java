package esn;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class routimage {
    public static double[][] outred(){
    int[][] r = new int[500][400];
    int[][] in = new int[500][400];
    double[][] rd = new double[150][150];

    String inputname = "Lennacolor.jpg";

        try{ //画像の読み込み
            BufferedImage rinImage = ImageIO.read(new File(inputname));
            int inw = rinImage.getWidth();
            int inh = rinImage.getHeight();

            for(int y=0;y<inw;y++){
                for(int x=0;x<inh;x++){
                    in[y][x] = rinImage.getRGB(y, x);
                    r[y][x] = ImageUtility.r(in[y][x]);
                    rd[y][x] = (double)r[y][x]/255.0;
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        //System.out.println(in[0][0]);
        //System.out.println(Integer.toHexString(in[0][0]));
        return rd;
    } 
}


