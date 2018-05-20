package animals;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Dependent;

import annotations.Qualifier1;

@Dependent
@Qualifier1
public class Elk extends AnimalBase {
	@PostConstruct
	public void init() {
		System.out.println("PostConstruct " + this.getClass().getName());
	}
	public String getA() {
		return "theAElk";
	}
	@PreDestroy
	public void destroy() {
		System.out.println("Destroy " + this.getClass().getName());
	}
}