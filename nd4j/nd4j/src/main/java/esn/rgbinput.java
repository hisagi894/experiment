package esn;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class rgbinput {
    public static float[][] red(int Nu){
        int[][] r = new int[Nu][Nu];
        float[][] r2 = new float[Nu][Nu];
    
        String inputname = Thread.currentThread().getContextClassLoader().getResource("sample.jpg").getPath();   //150*150
    
            try{ //画像の読み込み
                BufferedImage rinImage = ImageIO.read(new File(inputname));
                int inw = rinImage.getWidth();     
                int inh = rinImage.getHeight();
                //System.out.println(inw);
                //System.out.println(inh);
    
                for(int y=0;y<inh;y++){
                    for(int x=0;x<inw;x++){
                        int in = rinImage.getRGB(y, x);
                        r[y][x] = ImageUtility.r(in);
                        r2[y][x] = r[y][x]/255.0f;
                    }
                }
            } catch(Exception e){
                e.printStackTrace();
            }
            //System.out.println(r[0][0]);
            return r2;
        } 

    public static float[][] green(int Nu){
        int[][] g = new int[Nu][Nu];
        float[][] g2 = new float[Nu][Nu];
        
        String inputname = Thread.currentThread().getContextClassLoader().getResource("sample.jpg").getPath();
        
            try{ //画像の読み込み
                BufferedImage rinImage = ImageIO.read(new File(inputname));
                int inw = rinImage.getWidth();
                int inh = rinImage.getHeight();
        
                for(int y=0;y<inh;y++){
                    for(int x=0;x<inw;x++){
                        int in = rinImage.getRGB(y, x);
                        g[y][x] = ImageUtility.g(in);
                        g2[y][x] = g[y][x]/255.0f;
                    }
                }
                } catch(Exception e){
                    e.printStackTrace();
                }
                //System.out.println(g[0][0]);
                return g2;
            } 

    public static float[][] blue(int Nu){
        int[][] b = new int[Nu][Nu];
        float[][] b2 = new float[Nu][Nu];
    
        String inputname = Thread.currentThread().getContextClassLoader().getResource("sample.jpg").getPath();
    
            try{ //画像の読み込み
                BufferedImage rinImage = ImageIO.read(new File(inputname));
                int inw = rinImage.getWidth();
                int inh = rinImage.getHeight();
    
                for(int y=0;y<inh;y++){
                    for(int x=0;x<inw;x++){
                        int in = rinImage.getRGB(y, x);
                        b[y][x] = ImageUtility.b(in);
                        b2[y][x] = b[y][x]/255.0f;
                    }
                }
            } catch(Exception e){
                e.printStackTrace();
            }
            //System.out.println(b[0][0]);
            return b2;
        }
}
