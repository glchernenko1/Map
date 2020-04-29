package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	 	House home1= new House();

	 	home1.addApartment(new Flat(1,14));
		home1.addApartment(new Flat(1,24));
		home1.addApartment(new Flat(1,34));
		home1.addApartment(new Flat(1,14));
		home1.addApartment(new Flat(1,14));
		home1.addApartment(new Flat(2,14));
		home1.addApartment(new Flat(2,14));
		home1.addApartment(new Flat(2,14));
		home1.addApartment(new Flat(2,14));
		home1.addApartment(new Flat(2,14));
		home1.addApartment(new Flat(2,14));
		home1.addApartment(new Flat(1,14));
		home1.addApartment(new Flat(1,24));
		home1.addApartment(new Flat(2,14));
		home1.addApartment(new Flat(2,14));
		home1.addApartment(new Flat(2,14));
		home1.addApartment(new Flat(2,14));
		home1.addApartment(new Flat(2,14));
		home1.addApartment(new Flat(3,14));
		home1.addApartment(new Flat(1,24));
		home1.addApartment(new Flat(2,14));
		home1.addApartment(new Flat(2,14));
		home1.addApartment(new Flat(2,14));
		home1.addApartment(new Flat(2,14));
		home1.addApartment(new Flat(2,14));
		home1.addApartment(new Flat(1,14));
		home1.addApartment(new Flat(1,24));


		System.out.println(home1.count().toString());
		ArrayList<Flat> tmp= home1.getGreatestInAreaFlats(5);
		System.out.print(tmp.toString());

    }
}
