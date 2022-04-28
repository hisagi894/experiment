package esn;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class goutimage {
    public static double[][] outgreen(){
    int[][] g = new int[500][400];
    double[][] gd = new double[150][150];

    String inputname = Thread.currentThread().getContextClassLoader().getResource("Lennacolor.jpg").getPath();;
        try{ //画像の読み込み
            BufferedImage rinImage = ImageIO.read(new File(inputname));
            int inw = rinImage.getWidth();
            int inh = rinImage.getHeight();

            for(int y=0;y<inw;y++){
                for(int x=0;x<inh;x++){
                    int in = rinImage.getRGB(y, x);
                    g[y][x] = ImageUtility.g(in);
                    gd[y][x] = (double)g[y][x]/255.0f;
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        //System.out.println(g[0][0]);
        return gd;
    } 
}

