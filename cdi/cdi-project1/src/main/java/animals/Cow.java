package animals;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Alternative;

import annotations.Qualifier1;

@Dependent
@Qualifier1
@Alternative
public class Cow extends AnimalBase {
	@PostConstruct
	public void init() {
		System.out.println("PostConstruct " + this.getClass().getName());
	}
	public String getA() {
		return "theACow";
	}
	@PreDestroy
	public void destroy() {
		System.out.println("Destroy " + this.getClass().getName());
	}
}