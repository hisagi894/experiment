package esn;
import java.util.Random;

public class batch {
    public static int[][] input(int Nu, int inrnd){
        int[][] batch = new int[1][Nu];
        Random rnd = new Random(1);

        for(int i=0;i<Nu;i++)
        {
            batch[0][i]=rnd.nextInt(inrnd);
            //System.out.println(batch[0][i]);
        }
        return batch;
    }

    public static int[][] output(int Nu,int Ny,int otrnd){
        int[][] batch = new int[1][Nu];
        int[][] out = new int[1][Ny];
        Random rnd = new Random(1);

        for(int i=0;i<Nu;i++)
        {
            batch[0][i]=rnd.nextInt(otrnd);
        }

        for(int i=2;i<Ny;i++)
        {
            out[0][i]=batch[0][i-1]^batch[0][i-2];
            //System.out.println(out[i-1]);
        }

        return out;
    }
    
    public static int[][] parity(int tau,int k){
        int[][] batch = new int[1][50];
        int check=0;
        int[][] out = new int[1][50];
        Random rnd = new Random(1);

        for(int i=0;i<50;i++)
        {
            batch[0][i]=rnd.nextInt(2);
        }

        for(int i=tau+2;i<52;i++)
        {
            check = batch[0][i-tau-2]+batch[0][i-tau-1]+batch[0][i-tau];
            if(check%2==0){
                out[0][i-tau-2] = 0;
            }
            else {
                out[0][i-tau-2] = 1;
            }
            //System.out.println(out[i-1]);
        }

        return out;
    }
    
}
