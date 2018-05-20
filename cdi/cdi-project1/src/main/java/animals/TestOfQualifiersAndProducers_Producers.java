package animals;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

public class TestOfQualifiersAndProducers_Producers {
	@Produces
	public Bird makeBird() {
		System.out.println("Entering " + Thread.currentThread().getStackTrace()[1].getMethodName());
		return new Bird();
	}

	public void disposeBird(@Disposes Bird bird) {
		System.out.println("Entering " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}
}