
package ActividadCompletar;

import java.util.List;

public class Metodo {
    int cantidad=0;
    public boolean BusquedaAnchura(int[][] mapa, int x, int y, List<Integer> camino)
    {
        if (mapa[y][x] == 9)
        {
            return true;
        }
        if (mapa[y][x] == 0)
        {
            cantidad++;
            mapa[y][x] = 6;
            int Nodox = 1;
            int Nodoy = 0;
            if (BusquedaAnchura(mapa, x + Nodox, y + Nodoy, camino))
            {
                camino.add(x);
                camino.add(y);
                return true;
            }
            Nodox = 0;
            Nodoy = 1;
            if (BusquedaAnchura(mapa, x + Nodox, y + Nodoy, camino))
            {
                camino.add(x);
                camino.add(y);
                return true;
            }
            Nodox = 1;
            Nodoy = 0;
            if (BusquedaAnchura(mapa, x - Nodox, y + Nodoy, camino))
            {
                camino.add(x);
                camino.add(y);
                return true;
            }
            Nodox = 0;
            Nodoy = 1;
            if (BusquedaAnchura(mapa, x + Nodox, y - Nodoy, camino))
            {
                camino.add(x);
                camino.add(y);
                return true;
            }
        }
        return false;
    }
    public int Visitados(){
        return cantidad;
    }
    public void BusquedaProfundida(int[][] mapa, int x, int y, List<Integer> camino,String opc)
    {
        if (mapa[y][x] == 9)
        {
            return;
        }
        if (mapa[y][x] == 0)
        {
            mapa[y][x] = 6;
        }
        int i=80;
        while(i>1){
            cantidad++;
            switch(opc){
                //Caso derecha
                case "derecha": 
                    if(mapa[y-1][x] == 0 ||mapa[y-1][x] == 6){
                        mapa[y-1][x] = 6;
                        y = y-1;
                        opc = "arriba";
                    }else{
                        if(mapa[y][x+1] == 0 || mapa[y][x+1] == 6){
                            mapa[y][x+1] = 6;
                            x = x+1;
                        }else{
                            if(mapa[y+1][x] == 0 || mapa[y+1][x] == 6){
                                mapa[y+1][x] = 6;
                                y = y+1;
                                opc = "abajo";
                            }else{
                                mapa[y][x-1] = 6;
                                x = x-1;
                                opc = "izquierda";
                            }
                        }
                    }
                    break;
                //Caso arriba
                case "arriba":
                    if(mapa[y][x-1] == 0 || mapa[y][x-1] == 6){
                        mapa[y][x-1] = 6;
                        x = x-1;
                        opc = "izquierda";
                    }else{
                        if(mapa[y-1][x] == 0 || mapa[y-1][x] == 6){
                            mapa[y-1][x] = 6;
                            y = y-1;
                        }else{
                            if(mapa[y][x+1] == 0 || mapa[y][x+1] == 6){
                                mapa[y][x+1] = 6;
                                x = x+1;
                                opc = "derecha";
                            }else{
                                mapa[y+1][x] = 6;
                                y = y+1;
                                opc = "abajo";
                            }
                        }
                    }
                    break;
                //Caso izquierdo
                case "izquierda":
                    if(mapa[y+1][x] == 0 || mapa[y+1][x] == 6){
                        mapa[y+1][x] = 6;
                        y = y+1;
                        opc = "abajo";
                    }
                    else{
                        if(mapa[y][x-1] == 0 || mapa[y][x-1] == 6){
                            mapa[y][x-1] = 6;
                            x = x-1;
                        }else{
                            if(mapa[y-1][x] == 0 || mapa[y-1][x] == 6){
                                mapa[y-1][x] = 6;
                                y = y-1;
                                opc = "arriba";
                            }else{
                                mapa[y][x+1] = 6;
                                x = x+1;
                                opc = "derecha";
                            }
                        }
                    }
                    break;
                //Caso abajo
                case "abajo":
                    if(mapa[y][x+1] == 0 || mapa[y][x+1] == 6){
                            mapa[y][x+1] = 6;
                            x = x+1;
                            opc = "derecha";
                    }
                    else{
                        if(mapa[y+1][x] == 0 || mapa[y+1][x] == 6){
                                mapa[y+1][x] = 6;
                                y = y+1;
                        }else{
                            if(mapa[y][x-1] == 0 || mapa[y][x-1] == 6){
                                mapa[y][x-1] = 6;
                                x = x-1;
                                opc = "izquierda";
                            }
                            else{
                                mapa[y-1][x] = 6;
                                y = y-1;
                                opc = "arriba";
                            }
                        }
                    }
                    break;
                
            }//Fin de switch
            i--;
            camino.add(x);
            camino.add(y);
        }//Fin del while
    }//Fin de la función
}
