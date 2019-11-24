package com.wb.application;

import java.math.BigDecimal;

import com.wb.shape.Circle;
import com.wb.shape.Rectangle;
import com.wb.shape.Triangle;
import com.wb.visitor.AreaVisitor;

public class AreaCalculatorMain {

	public static void main(String[] args) {
		Circle c = new Circle(new BigDecimal("10"));
		Rectangle r = new Rectangle(new BigDecimal("10"), new BigDecimal("20"));
		Triangle t = new Triangle(new BigDecimal("20"), new BigDecimal("30"));
		
		AreaVisitor av = new AreaVisitor();
		System.out.println(av.getArea(t));
		System.out.println(av.getArea(r));
		System.out.println(av.getArea(c));
	}

}
