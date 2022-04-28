package esn;
import java.lang.Math;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
//,float[][] wfb,float[] y

public class reseupdate {
    public static float[] update(float[] wu,int Nx,float[][] w,float[] xb,int b)
    {
    float[][] RX = new float[Nx][Nx];   //RX[20][20]    
    float[] dotwx = new float[Nx];      //dotwx[20]
    float[] xaf = new float[Nx];        //xaf[20]

    float[][] resx = new float[Nx][1];  //resx[20][1] 
    float[][] resx2 = new float[1][Nx]; //resx2[1][20]
    float[] resx3 = new float[Nx];      //resx3[20]

    
    for(int i=0;i<Nx;i++){
            resx[i][0] =xb[i];
    }

    for(int i=0;i<Nx;i++){
        for(int j=0;j<Nx;j++){
            RX[i][j] =w[i][j];
        }
    }

    INDArray X = Nd4j.create(resx);   //X[20][1]
    //System.out.println("X"+X);
    INDArray W = Nd4j.create(RX);     //W[20][20]
    //System.out.println("W"+W);
    INDArray WX = W.mmul(X);          //WX[20][1]
    INDArray WXt = WX.transpose();    //WXt[1][20]
    resx2 = WXt.toFloatMatrix();      //resx2[1][20]

    for(int i=0;i<Nx;i++){
        resx3[i] =resx2[0][i]; //resx3[20]
    }

    INDArray X_in = Nd4j.create(wu);  //X_in[20]
    INDArray WX2 = Nd4j.create(resx3);  //WX2[20]
    //INDArray WFB = Nd4j.create(wfb);  //X_in[20]
    //INDArray Y = Nd4j.create(y);  //WX2[20]
    //INDArray WY = WFB.mmul(Y);
    //System.out.println("WX"+WX2);
    //System.out.println("X_in"+h+"回目"+X_in);
    INDArray tanin = WX2.add(X_in);  //tanin[20]
    //INDArray tanin2 = tanin.add(WY);  //tanin[20]
    //System.out.println("tanin"+tanin);
    //System.out.println(tanin);
    dotwx = tanin.toFloatVector();  //dotwx[20]
    //dotwx = tanin2.toFloatVector();  //dotwx[20]
    float leac = 1.0f;


    for(int i=0;i<Nx;i++){
            //System.out.println("dotwx"+h+"回目"+dotwx[i][0]);
            xaf[i] = (float)((1.0-leac)*xb[i]+leac*Math.tanh(dotwx[i]));
    }

    return xaf;
    }
}
