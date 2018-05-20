package animals;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Dependent;

@Dependent
public class Bird implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PostConstruct
	public void init() {
		System.out.println("PostConstruct " + this.getClass().getName());
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Destroy " + this.getClass().getName());
	}

	public String toString() {
		return "I am " + this.getClass().getName();
	}
}