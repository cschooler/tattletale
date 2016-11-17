package com.technologycoop.service.snopes;


import com.technologycoop.service.Article;
import com.technologycoop.service.ArticleCrawler;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.LinkedList;

public class SnopesArticleCrawler implements ArticleCrawler {

    private static final URL SNOPES_BASE_URL;
    private static final int TIMEOUT_SECONDS = 5;

    static {
        try {
            SNOPES_BASE_URL = new URL("http://www.snopes.com/category/fact-politics/");
        } catch (MalformedURLException e) {
            throw new IllegalStateException(e);
        }
    }

    public Collection<? extends Article> getArticles() {
        try {
            final Document document = Jsoup.parse(SNOPES_BASE_URL, TIMEOUT_SECONDS * 1000);
            final Elements titleLinks = document.select("[itemprop=headline] a");

            final Collection<SnopesArticle> articles = new LinkedList<>();

            titleLinks.stream().forEach(titleLink -> {
                try {
                    final URL articleURL = new URL(titleLink.absUrl("href"));
                    articles.add(new SnopesArticle(articleURL));
                } catch (MalformedURLException e) {
                    throw new IllegalStateException(e);
                }
            });
            return articles;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
