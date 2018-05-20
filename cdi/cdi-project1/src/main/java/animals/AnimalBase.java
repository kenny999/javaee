package animals;

import java.io.Serializable;

import javax.enterprise.context.Dependent;

public class AnimalBase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getA() {
		return "theA";
	}
}