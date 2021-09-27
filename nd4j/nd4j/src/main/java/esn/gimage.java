package esn;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class gimage {
    public static double[][] green(){
    int[][] g = new int[150][150];
    double[][] g2 = new double[150][150];

    String inputname = Thread.currentThread().getContextClassLoader().getResource("lennamono.jpg").getPath();

        try{ //画像の読み込み
            BufferedImage rinImage = ImageIO.read(new File(inputname));
            int inw = rinImage.getWidth();
            int inh = rinImage.getHeight();

            for(int y=0;y<inw;y++){
                for(int x=0;x<inh;x++){
                    int in = rinImage.getRGB(y, x);
                    g[y][x] = ImageUtility.g(in);
                    g2[y][x] = (double)g[y][x]/255.0;
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        //System.out.println(g[0][0]);
        return g2;
    } 
}

