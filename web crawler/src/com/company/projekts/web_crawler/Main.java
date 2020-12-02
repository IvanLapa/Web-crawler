package com.company.projekts.web_crawler;

import java.io.IOException;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		System.out.println("Start crawling process...\n");
		
		WebSpider webSpider = new WebSpider("https://en.wikipedia.org/wiki/Elon_Musk");
		
		Set<String> links = webSpider.getLinks();
		
		System.out.println("Total crawling links - " + links.size() + "\n");

		for (String s : links) {

			GetData getData = new GetData();
			
			int countMusk = getData.getData(s, "Musk");
			int countTesla = getData.getData(s, "Tesla");
			int countGigafactory = getData.getData(s, "Gigafactory");
			int countElonMask = getData.getData(s, "Elon Mask");
			int countTotal = countMusk + countTesla + countGigafactory + countElonMask;
			
			System.out.println(s + " " + countTesla + " " + countMusk + " " + countGigafactory + " " + countGigafactory);
			System.out.println("Numbers are:");
			System.out.println("Tesla - " + countTesla);
			System.out.println("Musk - " + countMusk);
			System.out.println("Gigafactory - " + countGigafactory);
			System.out.println("Elon Mask - " + countElonMask);
			System.out.println("Total - " + countTotal + "\n");
		}
	}
}