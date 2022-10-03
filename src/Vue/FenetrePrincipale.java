package Vue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class FenetrePrincipale {
	private JFrame framePpl;
	JMenuBar barre_de_menu = new JMenuBar();
	JMenu User_menu = new JMenu("Utilisateur");
	JMenu Livre_menu = new JMenu("Livres");
	
	
	public FenetrePrincipale() {
		framePpl = new JFrame();
		barre_de_menu.add(User_menu);
		barre_de_menu.add(Livre_menu);
		framePpl.add(barre_de_menu);
		framePpl.setSize(1080, 720);
		framePpl.setResizable(false);
		framePpl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePpl.setLocationRelativeTo(null);
		framePpl.setVisible(true);
	}
}
