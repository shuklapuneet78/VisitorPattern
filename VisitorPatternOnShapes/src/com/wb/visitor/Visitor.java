package com.wb.visitor;

import java.math.BigDecimal;

import com.wb.shape.Circle;
import com.wb.shape.Rectangle;
import com.wb.shape.Triangle;

public interface Visitor 
{
	BigDecimal visitCircle (Circle circle);
	BigDecimal visitTriangle (Triangle triangle);
	BigDecimal visitRectangle (Rectangle rectangle);
}