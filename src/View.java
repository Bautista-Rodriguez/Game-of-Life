import javax.swing.JFrame;

public class View extends JFrame{
    Model model;
    ViewPanel panel;
    public View(Model model, ViewPanel panel){
        this.model = model;
        this.panel = panel;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.repaint();
        this.revalidate();
        panel.repaint();
        panel.revalidate();
    }
}
