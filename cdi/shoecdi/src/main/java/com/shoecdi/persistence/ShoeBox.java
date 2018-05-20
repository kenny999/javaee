package com.shoecdi.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.shoecdi.util.Brand;
import com.shoecdi.util.Brand.BRAND;

@Entity
@Table(name =" SHOEBOX")
@SequenceGenerator(name = "ShoeBox_seq", sequenceName = "ShoeBox_seq")
public class ShoeBox  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ShoeBox_seq")
	private Integer id;
	
	public ShoeBox(Integer rgb, String text, Integer height, Integer width, Integer weight,
			Integer size, BRAND brand, Integer color, Integer shoeLaceLength) {
		super();
		this.rgb = rgb;
		this.text = text;
		this.height = height;
		this.width = width;
		this.weight = weight;
		this.size = size;
		this.brand = brand;
		this.color = color;
		this.shoeLaceLength = shoeLaceLength;
	}

	@ManyToOne
	private ShoeOwner shoeOwner;
	
	private Integer rgb;
	
	private String text;
	
	@Column(name="sb_height")
	private Integer height;
		
	@Column(name="sb_width")
	private Integer width;
	
	@Column(name="sb_weight")
	private Integer weight;

	@Column(name="size")
	private Integer size;
	
	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	@Enumerated(value = EnumType.STRING)
	private Brand.BRAND brand;
	
	private Integer color;
	
	private Integer shoeLaceLength;

	public Brand.BRAND getBrand() {
		return brand;
	}

	public void setBrand(Brand.BRAND brand) {
		this.brand = brand;
	}

	public Integer getColor() {
		return color;
	}

	public void setColor(Integer color) {
		this.color = color;
	}

	public Integer getShoeLaceLength() {
		return shoeLaceLength;
	}

	public void setShoeLaceLength(Integer shoeLaceLength) {
		this.shoeLaceLength = shoeLaceLength;
	}

	public ShoeBox(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ShoeOwner getShoeOwner() {
		return shoeOwner;
	}

	public void setShoeOwner(ShoeOwner shoeOwner) {
		this.shoeOwner = shoeOwner;
	}

	public Integer getRgb() {
		return rgb;
	}

	public void setRgb(Integer rgb) {
		this.rgb = rgb;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}	
}
