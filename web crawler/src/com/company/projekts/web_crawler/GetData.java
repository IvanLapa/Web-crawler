package com.company.projekts.web_crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class GetData {

	public int count;

	/**
	 * The method searches for matches on the page and counts their number. Accepts
	 * a URL and a search string as arguments.
	 */
	public int getData(String url, String seachWorld) {
		try {
			Document doc = Jsoup.connect(url).get();
			String htmlString = doc.toString();

			String[] subStr;
			String delimeter = " ";
			subStr = htmlString.split(delimeter);

			for (int i = 0; i < subStr.length; i++) {
				if (subStr[i].equals(seachWorld)) {
					count++;
				}
			}
		} catch (Exception ex) {
			System.err.println(ex);
		}
		return count;
	}
}