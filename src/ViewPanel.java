import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ViewPanel extends JPanel{
    Model model;
    int tamPanelX, tamPanelY, tamCelda;
    public ViewPanel(Model model){
        this.tamCelda=model.tamCelda;
        tamPanelX=model.tam2*tamCelda;
        tamPanelY=model.tam1*tamCelda;
        this.model=model;
        this.setPreferredSize(new Dimension(tamPanelX,tamPanelY));
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        this.setVisible(true);
        this.setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        grid(g);
        mostrarCeldas(g);
    }

    private void grid(Graphics g){
        g.setColor(Color.DARK_GRAY);
        for(int i=0;i<tamPanelY/tamCelda;i++){
            g.drawLine(0,i*tamCelda,tamPanelX,i*tamCelda);
        }
        for(int j=0;j<tamPanelX/tamCelda;j++){
            g.drawLine(j*tamCelda,tamPanelY,j*tamCelda,0);
        }
    }

    private void mostrarCeldas(Graphics g){
        g.setColor(Color.GREEN);
        for(int i=0;i<tamPanelY/tamCelda;i++){
            for(int j=0;j<tamPanelX/tamCelda;j++){
                if(model.celdasModel[i][j])
                    g.fillRect(j*tamCelda+1, i*tamCelda+1, tamCelda-2, tamCelda-2);
            }
        }
    }
}