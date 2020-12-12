package INFO6205;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * This class is used to display the spread of Sars virus Stumulation
 */
public class Canvas extends JPanel{

    public void paintComponent(Graphics graphics) {
    	super.paintComponent(graphics);
//int i=0,j=0;

    	for(int i = 0; i< CanvasHelper.canvasSize; i++) {
    		for(int j = 0; j< CanvasHelper.canvasSize; j++) {
    			Position position = CanvasHelper.matrix[i][j];
    			int[] margins = new int[5];
    			if(position.place !=null) {
	    			if(i>0) margins[0]=((CanvasHelper.matrix[i-1][j].place != position.place)?1:0);
	    			if(j>0) margins[1]=(CanvasHelper.matrix[i][j-1].place != position.place ?1:0);
	    			if(i< CanvasHelper.canvasSize -1) margins[2]=(CanvasHelper.matrix[i+1][j].place ==null?1:0);
	    			if(j< CanvasHelper.canvasSize -1) margins[3]=(CanvasHelper.matrix[i][j+1].place ==null?1:0);
    			}
    			generatePosition(graphics, position.x*3, position.y*3,3,3, margins);
    		}
    	}
    	
    	for(People people : CanvasHelper.people) {
    		if(people.hasResistance) continue;
    		else if(people.isSars) graphics.setColor(Color.decode("#ff0000"));
    		else graphics.setColor(Color.decode("#ffffff"));
    		generatePeople(graphics,people.x*3,people.y*3,6,6);
    	}
    }

	public void generatePosition(Graphics graphics, int x, int y, int w, int h, int[] margins) {
		graphics.fillRect(x, y, w, h);
		graphics.setColor(new Color(0,0,0));
		if(margins[0]==1) graphics.fillRect(x, y, 2, h);
		if(margins[1]==1) graphics.fillRect(x, y, w, 2);
		if(margins[2]==1) graphics.fillRect(x+w-2, y, 2,h);
		if(margins[3]==1) graphics.fillRect(x, y+w-2,w, 2);
	}

	public void generatePeople(Graphics graphics, int x, int y, int w, int h) {
	    graphics.fillOval(x, y, w, h);
	    graphics.setColor(new Color(0,0,0));
	    graphics.drawOval(x, y, w, h);
	}


	public Canvas() {
		canvasSize = 350;
		this.setPreferredSize(new Dimension(canvasSize *3, canvasSize *3));
	}

	private static int canvasSize;
	
}
