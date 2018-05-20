package com.shoecdi;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.shoecdi.persistence.ShoeBox;
import com.shoecdi.persistence.ShoeOwner;
import com.shoecdi.qualifiers.RandomShoeowner;
import com.shoecdi.qualifiers.ShoeDatabase;
import com.shoecdi.util.Brand.BRAND;

@Dependent
public class ShoeProducers {

	@PersistenceContext
	EntityManager em;

	private List<String> shoeBoxTexts;
	private List<String> firstNames;
	private List<String> lastNames;

	@PostConstruct
	public void init() {
		shoeBoxTexts = Arrays.asList(new String[] { "A text", "Another text", "Some text", "My text" });
		firstNames = Arrays.asList(new String[] { "Klara", "Olga", "Siif", "Erik", "Pelle", "Olle" });
		lastNames = Arrays
				.asList(new String[] { "Rudingen", "Nilsson", "Eriksson", "Andersson", "Westhagen", "Winterbottom" });
	}

	@Produces
	@ShoeDatabase
	public EntityManager getShoeDatbase() {
		return em;
	}

	@Produces
	@RandomShoeowner
	public ShoeOwner getShoeowner() {

		ShoeOwner shoeOwner = new ShoeOwner();
		shoeOwner.setFirstName(firstNames.get(ThreadLocalRandom.current().nextInt(0, firstNames.size())));
		shoeOwner.setLastName(lastNames.get(ThreadLocalRandom.current().nextInt(0, lastNames.size())));

		int numShoeBoxes = ThreadLocalRandom.current().nextInt(0, 5);
		for (int i = 0; i < numShoeBoxes; i++) {
			ShoeBox shoeBox = createRandomShoeBox();
			shoeBox.setShoeOwner(shoeOwner);
			shoeOwner.addShoeBox(shoeBox);
		}
		return shoeOwner;
	}

	private ShoeBox createRandomShoeBox() {
		Integer rgb = ThreadLocalRandom.current().nextInt(4, 77);
		String text = shoeBoxTexts.get(ThreadLocalRandom.current().nextInt(0, shoeBoxTexts.size()));
		Integer height = ThreadLocalRandom.current().nextInt(4, 77);
		Integer width = ThreadLocalRandom.current().nextInt(4, 77);
		Integer weight = ThreadLocalRandom.current().nextInt(4, 77);
		Integer size = ThreadLocalRandom.current().nextInt(4, 77);
		BRAND brand = BRAND.values()[ThreadLocalRandom.current().nextInt(0, BRAND.values().length)];
		Integer color = ThreadLocalRandom.current().nextInt(4, 77);
		Integer shoeLaceLength = ThreadLocalRandom.current().nextInt(4, 77);
		return new ShoeBox(rgb, text, height, width, weight, size, brand, color, shoeLaceLength);
	}
}
