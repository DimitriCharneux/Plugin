package plugin;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import filters.PluginFilter;

import listeners.ActionMenuItemListener;
import listeners.FileListener;

/**
 * Class representing a graphical part of this aplication.
 * 
 * @author dimitri marion
 * 
 */
public class GraphicalDetector extends JFrame {
	protected JPanel panel;
	protected JPanel panelMenu;
	protected JMenuBar menuBar;
	protected JMenu menu;
	protected List<JMenuItem> listMenuItem;
	protected JTextArea textArea;
	protected FileChecker checker;

	/**
	 * Constructor of this class.
	 */
	public GraphicalDetector() {
		panel = new JPanel();
		panelMenu = new JPanel();
		menuBar = new JMenuBar();
		menu = new JMenu("Plugin");
		textArea = new JTextArea();
		checker = new FileChecker(new PluginFilter());
		listMenuItem = new ArrayList<JMenuItem>();
		settingsFrame();
	}

	/**
	 * Method from set a parameter of the component.
	 */
	private void settingsFrame() {
		this.setTitle("Plugin");
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panelMenu.add(menuBar);
		panel.add(panelMenu);
		menuBar.add(menu);
		panel.add(textArea);
		this.setContentPane(panel);
		this.setVisible(true);
	}

	/**
	 * Method from add a item in a MenuBar.
	 * 
	 * @param s
	 *            title of the {@link JMenuItem}
	 */
	public void addMenuItem(String s) {
		JMenuItem item = new JMenuItem(s);
		if (!listMenuItem.contains(item)) {
			menu.add(item);
			listMenuItem.add(item);
			item.addActionListener(new ActionMenuItemListener(this));
		}
	}

	/**
	 * Method from remove a item in a MenuBar.
	 * 
	 * @param s
	 *            title of the {@link JMenuItem}
	 */
	public void removeMenuItem(String s) {
		for (int i = 0; i < listMenuItem.size(); i++) {
			if (listMenuItem.get(i).getText().equals(s)) {
				menu.remove(listMenuItem.remove(i));
			}
		}
	}

	/**
	 * Method from add a {@link FileListener} to the application.
	 * 
	 * @param fl
	 */
	public void addFileListener(FileListener fl) {
		checker.addFileListener(fl);
	}

	/**
	 * Method from start a detection of file appearance
	 */
	public void start() {
		checker.startTimer();
	}

	/**
	 * Method from get a text from the frame.
	 * 
	 * @return text from a frame
	 */
	public String getText() {
		return textArea.getText();
	}

	/**
	 * Method from set a text from the frame.
	 * 
	 * @param text
	 *            from a frame
	 */
	public void setText(String str) {
		textArea.setText(str);
	}

	/**
	 * Method whether a list of plugin is empty.
	 * 
	 * @return true if a list of plugin is empty
	 */
	public boolean listMenuItemIsEmpty() {
		return listMenuItem.isEmpty();
	}

	/**
	 * Method know the list of plugin size.
	 * 
	 * @return the list of plugin size
	 */
	public int listMenuItemSize() {
		return listMenuItem.size();
	}
}
