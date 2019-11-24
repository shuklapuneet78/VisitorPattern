package com.wb.shape;

import java.math.BigDecimal;

import com.wb.visitor.Visitor;

public class Triangle implements Shape {
	/* Shape Attributes */
	private BigDecimal height;
	private BigDecimal base; 
	
	/* Constructor */
	public Triangle(BigDecimal height, BigDecimal base) {
		this.height = height;
		this.base = base;
	}
	
	/* Getters */
	public BigDecimal getHeight() {
		return height;
	}

	public BigDecimal getBase() {
		return base;
	}

	/* Visitor */
	@Override
	public BigDecimal accept(Visitor visitor) {
		return visitor.visitTriangle(this);
	}
}
