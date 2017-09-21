package Sample.View;

import javax.swing.JFrame;

import Sample.Controller.samplecontroller;

public class sampleframe extends JFrame {
	private samplepanel basePanel;
	
	public sampleframe(samplecontroller baseController)
	{
		basePanel = new samplepanel(baseController);
		setupFrame();
	}
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(500,500);
		this.setVisible(true);
	}
	

}
