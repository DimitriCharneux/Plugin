package plugin;

public class PluginDetector implements FileListener {
	private GraphicalDetector gd;

	public PluginDetector(GraphicalDetector gd){
		this.gd = gd;
	}
	
	
	@Override
	public void fileAdded(FileEvent e) {
			//System.out.printf("Nouveau .class %s détecté\n", e.getSource());
			
			gd.addMenuItem((String)e.getSource());
			 
	}

	@Override
	public void fileRemoved(FileEvent e) {
		//System.out.printf(".class %s supprimé detecté\n", e.getSource());
		
		gd.removeMenuItem((String)e.getSource());
	}

}