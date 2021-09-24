package esn;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class io {
    public static Object[] input(){
    int[][] r = new int[500][400];
    int[][] g = new int[500][400];
    int[][] b = new int[500][400];
    Object [] rgb = {r,g,b};
    //int[][] outImage = new int[500][400];

    String inputname = "rena400300.jpg";
    //String outputname = "experiment1.png";

        try{ //画像の読み込み
            BufferedImage rinImage = ImageIO.read(new File(inputname));
            //BufferedImage routImage = ImageIO.read(new File(outputname));
            int inw = rinImage.getWidth();
            int inh = rinImage.getHeight();
            //int outw = routImage.getWidth();
            //int outh = routImage.getHeight();
            //BufferedImage wImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

            for(int y=0;y<inw;y++){
                for(int x=0;x<inh;x++){
                    int in = rinImage.getRGB(y, x);
                    r[y][x] = ImageUtility.r(in);
                    g[y][x] = ImageUtility.g(in);
                    b[y][x] = ImageUtility.b(in);
                    //System.out.println(Integer.toHexString(in));
                    //wImage.setRGB(x,y,inImage[y][x]);
                    //int out = routImage.getRGB(y, x);
                    //outImage[y][x] = out;
                    //System.out.println(Integer.toHexString(out));
                    //wImage.setRGB(x,y,inImage[y][x]);
                }
            }
            //ImageIO.write(wImage, "png", new File(outputname));
        } catch(Exception e){
            e.printStackTrace();
        }
        return rgb;
    } 
}
