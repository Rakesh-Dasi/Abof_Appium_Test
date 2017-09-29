package com.sanalmarket.mobile.merve;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DemoList {

	public static void main(String[] args) {
		//List using generics
		//Generics lets us to store objects of certain type in a collection
		//Generics should match R.H.S and L.H.S
		List<String> myToDoList = new ArrayList<String>();
		myToDoList.add("Selenium");
		myToDoList.add("Cucumber");
		myToDoList.add("Protractor");
		
		//There are two ways to print this list
		//Using ForEach construct to iterate over a collection
		//ON R.H.S of the : put the name of the collection
		//On L.H.S of the : put the name of the object
		
		//Using for each and is the most recommended form
		for (String eachIteminList : myToDoList){
			System.out.println(eachIteminList);
		}
		System.out.println();
		
		
		//Access using Index
		
	for (int i=0; i<myToDoList.size(); ++i) {
		System.out.println(myToDoList.get(i));
	}
	
	System.out.println();
	
	Iterator<String> myIter = myToDoList.iterator();
	while (myIter.hasNext()) {
		System.out.println(myIter.next());
		
	}
		
		
		
	}

}

