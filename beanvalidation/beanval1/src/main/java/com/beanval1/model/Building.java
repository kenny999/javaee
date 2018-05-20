package com.beanval1.model;

import javax.validation.constraints.NotNull;

import com.beanval1.rest.Examples;

public class Building {

	@NotNull(groups = Examples.Group1.class)
	private Wall leftWall;

	@NotNull(groups = Examples.Group2.class)
	private Wall rightWall;

	@NotNull(groups = Examples.Group3.class)
	private Wall frontWall;
	
	@NotNull(groups = Examples.Group4.class)
	private Wall backWall;

	public Wall getRightWall() {
		return rightWall;
	}

	public void setRightWall(Wall rightWall) {
		this.rightWall = rightWall;
	}

	public Wall getFrontWall() {
		return frontWall;
	}

	public void setFrontWall(Wall frontWall) {
		this.frontWall = frontWall;
	}

	public Wall getBackWall() {
		return backWall;
	}

	public void setBackWall(Wall backWall) {
		this.backWall = backWall;
	}

	public void setLeftWall(Wall wall) {
		this.leftWall = wall;
		
	}

	public Wall getLeftWall() {
		return leftWall;
	}

}
