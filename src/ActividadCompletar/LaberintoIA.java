
package ActividadCompletar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class LaberintoIA extends JFrame implements ActionListener{

    Escenario ob;
    Metodo ob2;
    Scanner lector = new Scanner(System.in);
    int opc;
    String direccion = "derecha";
    int mod = 0;
    int nodos=0;
    private final List<Integer> camino = new ArrayList<Integer>();
    int[][] mapa;
    public LaberintoIA()
    {
        int x = 1;
        int y = 1;
        this.setBounds(10, 10, 700, 695);
        this.setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        ob=new Escenario();
        mapa=ob.getMapa();
        ob2=new Metodo();
        System.out.println("1 Laberinto Profundidad");
        System.out.println("2 Laberinto Anchura");
        System.out.println("0  Salir");
        System.out.print("opcion ->");
        opc = lector.nextInt();
            
        if (opc == 1) {
            ob2.BusquedaProfundida(ob.getMapa(), x, y, camino,direccion);
            nodos = ob2.Visitados();
            System.out.println("Nodos recorridos:");
            System.out.println(nodos);
            
        }
        if (opc == 2) {
            ob2.BusquedaAnchura(ob.getMapa(), x, y, camino);
            nodos = ob2.Visitados();
            System.out.println("Nodos recorridos:");
            System.out.println(nodos);
        }
    }

    @Override
    public void paint(Graphics g)
    {
        try {
            super.paint(g);
            g.translate(0, 25);
            for (int row = 0; row < mapa.length; row++)
            {
                for (int col = 0; col < mapa[0].length; col++)
                {
                    Color color;
                    switch (mapa[row][col])
                    {
                        case 1:
                            color = Color.BLACK;
                            break;
                        case 6:
                            color = Color.GREEN;
                            break;
                        case 9:
                            color = Color.red;
                            break;
                        default:
                            color = Color.white;
                    }
                    g.setColor(color);
                    g.fillRect(30 * col, 30 * row, 30, 30);
                    g.setColor(Color.red);
                    g.drawRect(30 * col, 30 * row, 30, 30);
                            
                }
            }
            int tiempo=800;
            sleep(tiempo);
            for (int i = 0; i < camino.size(); i += 2)
            {
                int caminoX = camino.get(i);
                int caminoY = camino.get(i + 1);
                g.setColor(Color.ORANGE);
                g.fillRect(caminoX * 30, caminoY * 30, 30, 30);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(LaberintoIA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        repaint();
    }
    public static void main(String[] args)
    {
        new LaberintoIA().show();
        
    }
}

