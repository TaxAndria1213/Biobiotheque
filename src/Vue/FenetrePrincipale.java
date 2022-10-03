package Vue;

import javax.swing.JFrame;

public class FenetrePrincipale {
	private JFrame framePpl;
	
	
	public FenetrePrincipale() {
		framePpl = new JFrame();
		
		
		framePpl.setSize(1080, 720);
		framePpl.setResizable(false);
		framePpl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePpl.setLocationRelativeTo(null);
		framePpl.setVisible(true);
	}
}
