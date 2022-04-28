package esn;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

public class rls {
    public static float[][] out(float[][] wout,float[] x,float d,int Nx,int yd){
        //float[][] wout = new float[yd][Nx];
        float[][] xreshape = new float[Nx][1];    //xreshape[20][1]
        float[][] wx = new float[yd][1];    //xreshape[20][1]
        float[][] p = new float[Nx][Nx];
        float[][] v = new float[yd][yd];
        float[][] g = new float[Nx][yd];
        float[][] px = new float[Nx][yd];
        float[][] xtpx = new float[yd][yd];
        float[][] gxtp = new float[Nx][Nx];
        float delta = 6f;
        float lam = 0.995f;

        for(int i=0;i<Nx;i++){
            for(int j=0;j<Nx;j++){
                p[i][j]=1/delta;    
            }   
        }

        
        INDArray P = Nd4j.eye(Nx);        //単位行列
        INDArray del = Nd4j.create(p);
        INDArray PX = del.mmul(P);
        px = PX.toFloatMatrix();


        for(int i=0;i<Nx;i++){
            xreshape[i][0]=x[i];    
        }

        for(int i=0;i<1;i++){
            INDArray Wout = Nd4j.create(wout);
            INDArray X = Nd4j.create(xreshape);
            INDArray WX = Wout.mmul(X);
            wx = WX.toFloatMatrix();

            v[0][0] = d - wx[0][0];

            INDArray Xt = X.transpose();
            INDArray XtP = Xt.mmul(P);
            INDArray XtPX = XtP.mmul(X);
            xtpx = XtPX.toFloatMatrix();
            
            for(int j=0;j<Nx;j++){
                g[j][0] = (1/lam*px[j][0]);
                g[j][0] = g[j][0]/(1+1/lam*xtpx[0][0]);
            }

            INDArray G = Nd4j.create(g);
            INDArray GXt = G.mmul(Xt);
            INDArray GXtP = GXt.mmul(P);
            gxtp = GXtP.toFloatMatrix();

            for(int j=0;j<Nx;j++){
                for(int k=0;k<Nx;k++){
                    p[j][k] = 1/lam*(p[j][k]-gxtp[j][k]);
                }
            }

            INDArray V = Nd4j.create(v);
            INDArray Gt = G.transpose();
            INDArray VGt = V.mmul(Gt);
            INDArray WOUT = Wout.add(VGt);
            wout = WOUT.toFloatMatrix();
        }

        return wout;
    }

}
