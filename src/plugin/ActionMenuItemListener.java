package plugin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class ActionMenuItemListener implements ActionListener {
	protected GraphicalDetector gd;
	
	public ActionMenuItemListener(GraphicalDetector gd){
		this.gd = gd;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String className = ((JMenuItem)arg0.getSource()).getText();
		Plugin plugin;
		try {
			plugin = (Plugin) Class.forName("plugins." +className ).newInstance();
		} catch (Exception e) {
			System.out.println("erreur lors du chargement de la classe");
			return;
		}
		gd.setText(plugin.transform(gd.getText()));
	}

}
