package com.wb.shape;

import java.math.BigDecimal;

import com.wb.visitor.Visitor;

public class Rectangle implements Shape {
	/* Shape Attributes */
	private BigDecimal length;
	private BigDecimal breadth;
	
	/* Constructor */
	public Rectangle(BigDecimal length, BigDecimal breadth) {
		this.length = length;
		this.breadth = breadth;
	}
	
	/* Getters */
	public BigDecimal getLength() {
		return length;
	}

	public BigDecimal getBreadth() {
		return breadth;
	}

	/* Visitor */
	@Override
	public BigDecimal accept(Visitor visitor) {
		return visitor.visitRectangle(this);
	}
}
