package esn;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class imageoutput {
    public static void rgbout(int[][] i){
        //int[][] inImage = new int[500][400];
        //int[][] outImage = new int[500][400];
        //int[][] h = new int[500][400];
    
        //String inputname = "rena400300.jpg";
        String outputname = Thread.currentThread().getContextClassLoader().getResource("experiment2.png").getPath();;
    
            try{ //画像の読み込み
                //BufferedImage rinImage = ImageIO.read(new File(inputname));
                BufferedImage routImage = ImageIO.read(new File(outputname));
                int inw = routImage.getWidth();
                int inh = routImage.getHeight();
                //int outw = routImage.getWidth();
                //int outh = routImage.getHeight();
                BufferedImage wImage = new BufferedImage(inh, inw, BufferedImage.TYPE_INT_RGB);
    
                for(int y=0;y<inh;y++){
                    for(int x=0;x<inw;x++){
                        //int in = rinImage.getRGB(y, x);
                        //inImage[y][x] = in;
                        //System.out.println(Integer.toHexString(in));
                        //wImage.setRGB(x,y,inImage[y][x]);
                        //int out = routImage.getRGB(y, x);
                        //outImage[y][x] = out;
                        //System.out.println(Integer.toHexString(out));
                        //h[y][x] = Imageout.r(i[y][x]);
                        //h[y][x] = (int)i[y][x];
                        wImage.setRGB(y,x,i[y][x]);
                        //System.out.println(i[y][x]);
                    }
                }
                //System.out.println(i[0][0]);
                ImageIO.write(wImage, "png", new File("experiment3.png"));
            } catch(Exception e){
                e.printStackTrace();
            }
            //System.out.println(Integer.toHexString(i[0][0]));
        } 
    }
