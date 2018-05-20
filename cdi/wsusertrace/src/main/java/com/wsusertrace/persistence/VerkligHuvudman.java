package com.wsusertrace.persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "VerkligHuvudman_seq", sequenceName = "VerkligHuvudman_seq")
public class VerkligHuvudman implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VerkligHuvudman_seq")
	private Integer id;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	private String fornamn;
	private String efternamn;
	private String personnummer;
	private String orgnummer;
	public String getOrgnummer() {
		return orgnummer;
	}
	public void setOrgnummer(String orgnummer) {
		this.orgnummer = orgnummer;
	}
	public String getFornamn() {
		return fornamn;
	}
	public void setFornamn(String fornamn) {
		this.fornamn = fornamn;
	}
	public String getEfternamn() {
		return efternamn;
	}
	public void setEfternamn(String efternamn) {
		this.efternamn = efternamn;
	}
	public String getPersonnummer() {
		return personnummer;
	}
	public void setPersonnummer(String personnummer) {
		this.personnummer = personnummer;
	}
}
