package client;

import javax.ejb.Remote;

@Remote
public interface ArchiverRemote {
	public String enregistrer();
}
