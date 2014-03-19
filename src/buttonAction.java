
import java.awt.event.*;

public class buttonAction implements ActionListener {
	AlienModule aModule;
	public buttonAction(AlienModule _alienModule){
		aModule = _alienModule;
		
	}

    public void actionPerformed(ActionEvent e){
        if ("pulse".equals(e.getActionCommand())) {
        	aModule.AlienPulse();        	
        } else {
        	System.out.println("------");
        }
    }
}
