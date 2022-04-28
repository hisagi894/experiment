package esn;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class rgboutput {
    public static float[][] outred(int Ny){
        int[][] r = new int[Ny][Ny];
        float[][] rd = new float[Ny][Ny];
    
        String inputname = Thread.currentThread().getContextClassLoader().getResource("lena_std.png").getPath();;
    
            try{ //画像の読み込み
                BufferedImage rinImage = ImageIO.read(new File(inputname));
                int inw = rinImage.getWidth();
                int inh = rinImage.getHeight();
    
                for(int y=0;y<inh;y++){
                    for(int x=0;x<inw;x++){
                        int in = rinImage.getRGB(y, x);
                        r[y][x] = ImageUtility.r(in);
                        rd[y][x] = r[y][x]/255.0f;
                    }
                }
            } catch(Exception e){
                e.printStackTrace();
            }
            //System.out.println(in[0][0]);
            //System.out.println(Integer.toHexString(in[0][0]));
            return rd;
        } 

        public static float[][] outgreen(int Ny){
            int[][] g = new int[Ny][Ny];
            float[][] gd = new float[Ny][Ny];
        
            String inputname = Thread.currentThread().getContextClassLoader().getResource("lena_std.png").getPath();;
                try{ //画像の読み込み
                    BufferedImage rinImage = ImageIO.read(new File(inputname));
                    int inw = rinImage.getWidth();
                    int inh = rinImage.getHeight();
        
                    for(int y=0;y<inh;y++){
                        for(int x=0;x<inw;x++){
                            int in = rinImage.getRGB(y, x);
                            g[y][x] = ImageUtility.g(in);
                            gd[y][x] = g[y][x]/255.0f;
                        }
                    }
                } catch(Exception e){
                    e.printStackTrace();
                }
                //System.out.println(g[0][0]);
                return gd;
            } 

            public static float[][] outblue(int Ny){
                int[][] b = new int[Ny][Ny];
                float[][] bd = new float[Ny][Ny];
            
                String inputname = Thread.currentThread().getContextClassLoader().getResource("lena_std.png").getPath();;
            
                    try{ //画像の読み込み
                        BufferedImage rinImage = ImageIO.read(new File(inputname));
                        int inw = rinImage.getWidth();
                        int inh = rinImage.getHeight();
            
                        for(int y=0;y<inh;y++){
                            for(int x=0;x<inw;x++){
                                int in = rinImage.getRGB(y, x);
                                b[y][x] = ImageUtility.b(in);
                                bd[y][x] = b[y][x]/255.0f;
                            }
                        }
                    } catch(Exception e){
                        e.printStackTrace();
                    }
                    //System.out.println(b[0][0]);
                    return bd;
                } 
}
