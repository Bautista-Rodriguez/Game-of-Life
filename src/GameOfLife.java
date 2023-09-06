public class GameOfLife{
    View view;
    Model model;
    Controller controller;

    public GameOfLife(){
        this.model = new Model();
        View v2=new View(model, new ViewPanel(model));
        this.view=v2;
        this.controller= new Controller(v2,model);
    }
    public static void main(String[] args) throws Exception {
        new GameOfLife();
    }
}