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

public class GraphicalDetector extends JFrame{
	protected JPanel panel;
	protected JPanel panelMenu;
	protected JMenuBar menuBar;
	protected JMenu menu;
	protected List<JMenuItem> listMenuItem;
	protected JTextArea textArea;
	protected FileChecker checker;

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

	private void settingsFrame() {
		this.setTitle("Plugin");
		this.setSize(400,300);
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

	public void addMenuItem(String s) {
		JMenuItem item = new JMenuItem(s);
		if (!listMenuItem.contains(item)) {
			menu.add(item);
			listMenuItem.add(item);
			item.addActionListener(new ActionMenuItemListener(this));
		}
	}
	
	public void addFileListener(FileListener fl){
		checker.addFileListener(fl);
	}
	
	public void start(){
		checker.startTimer();
	}

	public void removeMenuItem(String s){
		for(int i=0; i<listMenuItem.size(); i++){
			if(listMenuItem.get(i).getText().equals(s)){
				menu.remove(listMenuItem.remove(i));
			}
		}
	}
	
	public String getText(){
		return textArea.getText();
	}
	
	public void setText(String str){
		textArea.setText(str);
	}

	public static void main(String[] args) {
		GraphicalDetector gd = new GraphicalDetector();
		FileListener listener = new PluginDetector(gd);
		gd.addFileListener(listener);
		gd.start();
	}
}
