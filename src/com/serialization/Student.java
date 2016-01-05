package com.serialization;

import java.io.Serializable;

public class Student implements Serializable {
	
	int id;
	String name;
	transient int Number;
	
	public Student(int id, String name, int Number){
		this.id=id;
		this.name=name;
		this.Number=Number;
		
	}

}
