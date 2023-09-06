import java.awt.Dimension;
import java.awt.Toolkit;

public class Model {
    public final int tam1,tam2,tamCelda;
    public boolean celdasModel[][];

    public Model(){
        tamCelda=24;
        Dimension t = Toolkit.getDefaultToolkit().getScreenSize();
        tam1=(int)t.getHeight()/tamCelda-10;
        tam2=(int)t.getWidth()/tamCelda-2;
        celdasModel=new boolean[tam1][tam2];
        celdasModel[20][23]=true;
        celdasModel[21][21]=true;
        celdasModel[21][23]=true;
        celdasModel[22][22]=true;
        celdasModel[22][23]=true;
    }

    public void proximaGeneracion(){
        boolean[][] temp = new boolean[tam1][tam2];
        for(int i=0;i<tam1;i++){
            for(int j=0;j<tam2;j++){
                int vecinos = contarVecinos(i,j);
                if(celdasModel[i][j]){
                    if(vecinos==2 || vecinos==3)
                        temp[i][j]=true;
                    else
                        temp[i][j]=false;
                }
                else if(vecinos==3)
                    temp[i][j]=true;
            }
        }
        celdasModel = temp;
    }
    public int contarVecinos(int y, int x){
        int suma=0;
        for(int i=y-1;i<y+2;i++){
            for(int j=x-1;j<x+2;j++){
                int v1=(i+tam1) % tam1,v2=(j+tam2) % tam2;
                    if(celdasModel[v1][v2])
                        suma++;
            }
        }
        if(celdasModel[y][x])
            suma--;
        return suma;
    }
    public void cambiarCelda(int y, int x){
        if(celdasModel[y][x])
            celdasModel[y][x]=false;
        else
            celdasModel[y][x]=true;
    }
    public void reiniciar(){
        for(int i=0;i<tam1;i++){
            for(int j=0;j<tam2;j++){
                celdasModel[i][j]=false;
            }
        }
    }
}
