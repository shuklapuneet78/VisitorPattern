package com.wb.visitor;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.wb.shape.Circle;
import com.wb.shape.Rectangle;
import com.wb.shape.Shape;
import com.wb.shape.Triangle;

public class AreaVisitor implements Visitor {
	/* Constants */
	private static final BigDecimal PI = new BigDecimal(String.valueOf(Math.PI));
	private static final BigDecimal TWO = new BigDecimal("2");
	
	/* Enable Rounding with below details */
	private boolean roundingEnabled = true;
	private int scale = 2;
	
	public AreaVisitor() {
	}
	
    public String getArea(Shape shape) {
    	// Visit Shape Class and get area
    	BigDecimal area = shape.accept(this);
    	// Apply any formatting or rounding
    	area = applyRounding(area);
		String retString = getFormattedOutput(area);
		// return the results
		return retString;
    }
    
    /* Method Implementations - Specific to the Shape */
	@Override
	public BigDecimal visitCircle(Circle circle) {
		if (null == circle.getRadius())
			throw new IllegalArgumentException("Radius is NULL");
		
		return circle.getRadius().multiply(PI).multiply(TWO);
	}

	@Override
	public BigDecimal visitTriangle(Triangle triangle) {
		if (null == triangle.getBase() || null == triangle.getHeight())
			throw new IllegalArgumentException("Base or Height is NULL");
		
		return triangle.getBase().multiply(triangle.getHeight()).divide(TWO);
	}

	@Override
	public BigDecimal visitRectangle(Rectangle rectangle) {
		if (null == rectangle.getBreadth() || null == rectangle.getLength())
			throw new IllegalArgumentException("Base or Height is NULL");
		
		return rectangle.getBreadth().multiply(rectangle.getLength());
	}
	
	
	private BigDecimal applyRounding (BigDecimal area){
		return isRoundingEnabled()?
				area.setScale(scale, RoundingMode.HALF_UP) :
				area;
	}
	
	private String getFormattedOutput(BigDecimal area){
		StringBuffer sb = new StringBuffer("Area is: ");
		sb.append(area);
		return sb.toString();
	}

	public boolean isRoundingEnabled() {
		return roundingEnabled;
	}

	public void setRoundingEnabled(boolean roundingEnabled) {
		this.roundingEnabled = roundingEnabled;
	}

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		if (scale <= 0 || scale > 10)
			throw new IllegalArgumentException("Scale Not changed. Allowed values: 0 <= scale <=10");
		
		this.scale = scale;
	}
}