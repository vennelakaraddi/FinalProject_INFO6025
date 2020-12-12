
package INFO6205;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;


public class UIstats{

	protected JFrame jFrame;

	public UIstats() {
		fristframe();
		spreadframe();
	}
	public void fristframe() {
		jFrame = new JFrame();
		jFrame.setResizable(false);
		jFrame.setSize(new Dimension(1400, 800));
		jFrame.getContentPane().setLayout(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JComboBox<String> typeOfVirus = new JComboBox<>();
		typeOfVirus.setModel(new DefaultComboBoxModel<String>(new String[] {"SARS-CoV", "SARS-CoV-2"}));
		typeOfVirus.setSelectedIndex(0);
		typeOfVirus.setBounds(120, 32, 146, 22);
		jFrame.getContentPane().add(typeOfVirus);

		JLabel label1 = new JLabel("Virus type");
		label1.setBounds(25, 32, 84, 14);
		jFrame.getContentPane().add(label1);

		JLabel label3 = new JLabel("Graph before ");
		label3.setBounds(25,230, 700, 14);
		jFrame.getContentPane().add(label3);

		JLabel label = new JLabel( );
		label.setBounds(25, 250, 750,450);
		//src/main/src/main/java/INFO6205/SarsGraph.png
		label.setIcon(new ImageIcon("src/main/src/java/INFO6205/SarsGraph.png"));
		jFrame.getContentPane().add(label);

		JLabel label4 = new JLabel("Graphs After");
		label4.setBounds(700,230, 1000, 14);
		jFrame.getContentPane().add(label4);

		JLabel label5 = new JLabel( );
		label5.setBounds(700, 250, 750,450);

		label5.setIcon(new ImageIcon("src/main/src/java/INFO6205/SarsGraph2.png"));
		jFrame.getContentPane().add(label5);

		JLabel label2 = new JLabel("Properties that will effect the spread of virus ");
		label2.setBounds(25, 110, 800, 14);
		jFrame.getContentPane().add(label2);

		JToggleButton stopbutton = new JToggleButton("Stop");
		stopbutton.setEnabled(false);
		stopbutton.setBounds(100, 80, 70, 20);
		jFrame.add(stopbutton);
		stopbutton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent eve) {
				DemoHelper.endSim();
			}
		});

		JToggleButton startbutton = new JToggleButton("Start");
		startbutton.setEnabled(false);
		startbutton.setBounds(25, 80, 70, 20);
		jFrame.add(startbutton);
		startbutton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent eve) {
				if (startbutton.isSelected()) {
					startbutton.setText("Pause");
					DemoHelper.count1 = true;
				}
				else  {
					startbutton.setText("Start");
					DemoHelper.count1 = false;
				}
			}
		});

		JToggleButton lockdown_button = new JToggleButton("lockdown");
		lockdown_button.setEnabled(false);
		lockdown_button.setBounds(25, 140, 250, 20);
		jFrame.getContentPane().add(lockdown_button);
		lockdown_button.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent eve) {
				if (lockdown_button.isSelected()) {
					SimProperties.lockdownplace1 =true;
					CanvasHelper.canvasHelper.lockdownPlace(CanvasHelper.place1);
				}
				else {
					SimProperties.lockdownplace1 =false;
					CanvasHelper.canvasHelper.removeLockdown(CanvasHelper.place1);
				}
			}
		});

		JToggleButton trackingToQuarantine = new JToggleButton("tracking to quarantine");
		trackingToQuarantine.setEnabled(false);
		trackingToQuarantine.setBounds(25, 170, 250, 20);
		jFrame.getContentPane().add(trackingToQuarantine);
		trackingToQuarantine.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent eve) {
				if (trackingToQuarantine.isSelected())
					SimProperties.contactTrace = true;
				else
					SimProperties.contactTrace = false;
			}
		});

		JToggleButton socialDistanceButton = new JToggleButton("Social Distancing");
		socialDistanceButton.setEnabled(false);
		socialDistanceButton.setBounds(25, 200, 250, 20);
		jFrame.getContentPane().add(socialDistanceButton);
		socialDistanceButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent eve) {
				if (socialDistanceButton.isSelected())
					SimProperties.socialDistance = true;
				else
					SimProperties.socialDistance = false;
			}
		});

		JToggleButton runButton = new JToggleButton("Run");
		runButton.setBounds(25, 55, 100, 20);
		jFrame.getContentPane().add(runButton);
		runButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				SimProperties.typeOfVirus = (String) typeOfVirus.getSelectedItem();
				typeOfVirus.setEnabled(false);
				runButton.setEnabled(false);
				socialDistanceButton.setEnabled(true);
				trackingToQuarantine.setEnabled(true);
				lockdown_button.setEnabled(true);
				stopbutton.setEnabled(true);
				startbutton.setEnabled(true);
				SimProperties.start12 =true;
			}
		});
	}

	public void spreadframe() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				jFrame.setVisible(true);
			}
		});

	}
}