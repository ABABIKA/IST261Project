// Author: Aeden Vogt
package gameprogresstracker;

//Connects the view and the model.
public class ProgressController {
    private ProgressManager manager;
    private ProgressView view;

    public ProgressController() {
        manager = new ProgressManager();
        view = new ProgressView();
    }

    public void run() {
        view.menu(manager);
    }
}