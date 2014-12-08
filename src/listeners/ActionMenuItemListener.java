package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import plugin.GraphicalDetector;
import plugin.Plugin;

/**
 * Class to listen the menuItem event. Content instance of
 * {@link GraphicalDetector} from change this text.
 * 
 * @author dimitri marion
 * 
 */
public class ActionMenuItemListener implements ActionListener {
	protected GraphicalDetector gd;

	/**
	 * Constructor of this class.
	 * 
	 * @param gd
	 *            {@link GraphicalDetector}
	 */
	public ActionMenuItemListener(GraphicalDetector gd) {
		this.gd = gd;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String className = ((JMenuItem) arg0.getSource()).getText();
		Plugin plugin;
		try {
			plugin = (Plugin) Class.forName("plugins." + className)
					.newInstance();
		} catch (Exception e) {
			System.out.println("erreur lors du chargement de la classe");
			return;
		}
		gd.setText(plugin.transform(gd.getText()));
	}

}
