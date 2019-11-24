package com.wb.shape;

import java.math.BigDecimal;

import com.wb.visitor.Visitor;

public interface Shape {
	BigDecimal accept(Visitor visitor);	
}
