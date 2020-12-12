package INFO6205;

import java.util.TimerTask;


public class DemoHelper extends TimerTask{
	public DemoHelper(Canvas canvas) {
		this.canvas = canvas;
		frequencyOriginal=0;
		frequencySimulator = 0;
	}
	
	@Override
	public void run() {
		if(count1) {
			frequencyOriginal++;
			if(frequencyOriginal%2==0) {
				frequencySimulator++;
				canvas.repaint();
				if(frequencySimulator>stopFrequency) endSim();
				CanvasHelper.canvasHelper.refreshCanvasHelper();
				if(frequencySimulator%100==0) {
					CanvasHelper.updateConsole();
					CanvasHelper.canvasHelper.spreadInfection(CanvasHelper.place1);
				}
			}
		}
	}
	public static void endSim() {
		count1 = false;
		end();
	}
	static void end()
	{
		System.exit(0);
	}

	static boolean count1 = false;
	public Canvas canvas;
	public int frequencyOriginal;
	public static int frequencySimulator;
	public int stopFrequency=15000;

}
