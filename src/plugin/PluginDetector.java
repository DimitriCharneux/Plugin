package plugin;

public class PluginDetector implements FileListener {
	private GraphicalDetector gd;

	public PluginDetector(GraphicalDetector gd){
		this.gd = gd;
	}
	
	
	@Override
	public void fileAdded(FileEvent e) {
		String fileName = (String)e.getSource();
		gd.addMenuItem(fileName.substring(0,fileName.lastIndexOf(".class")));
	}

	@Override
	public void fileRemoved(FileEvent e) {
		String fileName = (String)e.getSource();
		gd.removeMenuItem(fileName.substring(0,fileName.lastIndexOf(".class")));
	}

}