
package INFO6205;

import java.util.Timer;
import javax.swing.JFrame;

public class UIController {
	public static void main(String args[]) {
		new UIstats();
		while(!SimProperties.start12)
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		    new SimProperties();
			new CanvasHelper();
		CanvasHelper.canvasHelper.spreadCanavas(false, 10,5,1);
		CanvasHelper.canvasHelper.spreadCanavas(true,50 , 5,1 );
		int peopleCount=1000;
		CanvasHelper.canvasHelper.populatePeople(peopleCount);
		CanvasHelper.canvasHelper.initaiatingDisease();

        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas c = new Canvas();
        jFrame.add(c);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        if (SimProperties.showGUI) jFrame.setVisible(true);

		DemoHelper s = new DemoHelper(c);
		new Timer().schedule(s, 10, 15);
	}
}
