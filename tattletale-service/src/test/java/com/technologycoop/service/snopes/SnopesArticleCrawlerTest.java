package com.technologycoop.service.snopes;

import org.junit.Test;

import java.util.Collection;

public class SnopesArticleCrawlerTest {

    @Test
    public void testCrawler() {
        new SnopesArticleCrawler().getArticles().forEach(article -> {
            System.out.println(article.getURL());
            System.out.println(article.getContent());
            System.out.println(article.getPublicationDate());

            System.out.println("\n");
        });
    }
}
