package com.company.projekts.web_crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WebSpider {
	private final Set<String> links;

	public Set<String> getLinks() {
		return this.links;
	}

	public WebSpider(String startURL) {// private
		this.links = new HashSet<>();
		crawl(initURLS(startURL));
	}

	/**
	 * The method searches for links on the source page at the given URL
	 */
	private void crawl(final Set<String> urls) {
		urls.removeAll(this.links);
		if (!urls.isEmpty()) {
			final Set<String> newURLS = new HashSet<>();
			try {
				this.links.addAll(urls);
				for (final String url : urls) {
					final Document document = Jsoup.connect(url.toString()).get();
					final Elements linksOnPage = document.select("a[href]");
					for (final Element element : linksOnPage) {
						final String urlText = element.attr("abs:href");
						final String discoveredURL = new String(urlText);
						newURLS.add(discoveredURL);
					}
				}
			} catch (final Exception | Error ignored) {
			}
			crawl(newURLS);
		}
	}

	private Set<String> initURLS(final String startURL) {
		return Collections.singleton(startURL);
	}
}