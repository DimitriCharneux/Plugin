package plugin;

import java.awt.Event;

public class FileEvent extends Event{
	protected String nom;
	public FileEvent(Object target, int id, Object arg) {
		super(target, id, arg);
		nom = (String) target;
	}
	
	public String getNom(){
		return nom;
	}

}
