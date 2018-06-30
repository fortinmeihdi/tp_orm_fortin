package fileattente.modele;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class FileAttentePleineException extends Exception {

	private static final long serialVersionUID = 7974420835408306845L;

}
