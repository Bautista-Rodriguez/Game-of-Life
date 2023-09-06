import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;
import javax.swing.Timer;

public class Controller{
    
    Model model;
    View view;
    boolean pausa = true;
    int velocidad=201;
    Timer timer;

    Action sKeyAction = new sKeyAction();
    Action dKeyAction = new dKeyAction();
    Action fKeyAction = new fKeyAction();
    Action pKeyAction = new pKeyAction();

    public Controller(View view, Model model){
        this.model = model;
        this.view = view;
        this.inicializarMouse();
        this.inicializarTeclado();
        timer = new Timer(velocidad,new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e){
                model.proximaGeneracion();
                view.repaint();
                view.revalidate();
                view.panel.repaint();
                view.panel.revalidate();
            }
        });
    }

    public void inicializarMouse(){
        MouseListener mouse = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {
                if(pausa){
                    int x=e.getX()/model.tamCelda;
                    int y=e.getY()/model.tamCelda;
                    model.cambiarCelda(y, x);
                    view.repaint();
                    view.panel.repaint();
                }
            }
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        };
        view.panel.addMouseListener(mouse);
    }

    public void inicializarTeclado(){
        view.panel.getInputMap().put(KeyStroke.getKeyStroke("S"),"sKey");
        view.panel.getActionMap().put("sKey",sKeyAction);
        view.panel.getInputMap().put(KeyStroke.getKeyStroke("D"),"dKey");
        view.panel.getActionMap().put("dKey",dKeyAction);
        view.panel.getInputMap().put(KeyStroke.getKeyStroke("F"),"fKey");
        view.panel.getActionMap().put("fKey",fKeyAction);
        view.panel.getInputMap().put(KeyStroke.getKeyStroke("P"),"pKey");
        view.panel.getActionMap().put("pKey",pKeyAction);
    }

    public class sKeyAction extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(velocidad+100<=201){
                velocidad+=100;
                timer.setDelay(velocidad);
            }
        }
    }
    public class dKeyAction extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(pausa){
            model.reiniciar();
            view.repaint();
            }
        }
    }
    public class fKeyAction extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(velocidad-100>=1){
                velocidad-=100;
                timer.setDelay(velocidad);
            }
        }
    }
    public class pKeyAction extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(pausa)
            {
                timer.start();
                pausa=false;
            }
            else
            {
                timer.stop();
                pausa=true;
            }
        }
    }
}
