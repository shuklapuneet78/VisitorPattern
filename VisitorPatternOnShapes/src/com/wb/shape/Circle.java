package com.wb.shape;

import java.math.BigDecimal;

import com.wb.visitor.Visitor;

public class Circle implements Shape {
	/* Shape Attributes */
	private BigDecimal radius;
	
	/* Constructor */
	public Circle (BigDecimal radius){
		this.radius = radius;
	}
	
	/* Getters */
	public BigDecimal getRadius(){
		return radius;
	}
	
	/* Visitor */
	@Override
	public BigDecimal accept(Visitor visitor) {
		return visitor.visitCircle(this);
	}
}
