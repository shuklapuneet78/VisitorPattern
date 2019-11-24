package com.wb.application;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import com.wb.shape.Circle;
import com.wb.shape.Rectangle;
import com.wb.shape.Triangle;
import com.wb.visitor.AreaVisitor;

public class AreaCalculatorMainTest extends AreaVisitor {

	@Test
	public void testSuccessForRectangleWithValidInputs() {
		AreaVisitor av = new AreaVisitor();
		Rectangle r = new Rectangle(new BigDecimal("10"), new BigDecimal("20"));
		assertEquals("Area is: 200.00", av.getArea(r));		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFailureForRectangleWithValidInputs() {
		AreaVisitor av = new AreaVisitor();
		Rectangle r = new Rectangle(null, new BigDecimal("20"));
		av.getArea(r);
	}

	@Test
	public void testSuccessForTriangleWithValidInputs() {
		AreaVisitor av = new AreaVisitor();
		Triangle t = new Triangle(new BigDecimal("20"), new BigDecimal("30"));
		assertEquals("Area is: 300.00", av.getArea(t));	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFailureForTriangleWithValidInputs() {
		AreaVisitor av = new AreaVisitor();
		Triangle t = new Triangle(null, new BigDecimal("30"));
		av.getArea(t);
	}
	
	
	@Test
	public void testSuccessForCircleWithValidInputs() {
		AreaVisitor av = new AreaVisitor();
		Circle c = new Circle(new BigDecimal("10"));
		assertEquals("Area is: 62.83", av.getArea(c));		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFailureForCircleWithValidInputs() {
		AreaVisitor av = new AreaVisitor();
		Circle c = new Circle(null);
		av.getArea(c);
	}
	
	@Test
	public void testSetScaleWithValidInputs() {
		AreaVisitor av = new AreaVisitor();
		int origScale = av.getScale();
		av.setScale(7);
		assertNotEquals(origScale, av.getScale());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetScaleWithInvalidInputs() {
		AreaVisitor av = new AreaVisitor();
		av.setScale(-1);
	}
	
	@Test
	public void testSetScaleForAreaWithValidInputs() {
		AreaVisitor av = new AreaVisitor();
		assertEquals(2L, av.getScale());
		
		Circle c = new Circle(new BigDecimal("10"));
		assertEquals("Area is: 62.83", av.getArea(c));
		
		av.setScale(4);
		assertEquals(4L, av.getScale());
		assertEquals("Area is: 62.8319", av.getArea(c));
	}
	
	@Test
	public void testSetScaleWithRoundingDisabledForAreaWithValidInputs() {
		AreaVisitor av = new AreaVisitor();

		// Confirm default behavior
		assertEquals(2L, av.getScale());
		assertEquals(true, av.isRoundingEnabled());
		
		Circle c = new Circle(new BigDecimal("10"));
		assertEquals("Area is: 62.83", av.getArea(c));
		
		// Set scale and Switch Off Rounding
		av.setRoundingEnabled(false);
		assertEquals(false, av.isRoundingEnabled());
		assertNotNull(av.getArea(c));
	}
}
