package com.technologycoop.service.snopes;

import com.technologycoop.service.Article;
import org.junit.Test;

import java.util.Collection;

public class SnopesArticleCrawlerTest {

    @Test
    public void testCrawler() {
        final Collection<? extends Article> articles = new SnopesArticleCrawler().getArticles();
        System.out.println("Count: " + articles.size());
        articles.forEach(article -> {
            System.out.println(article.getTitle());
            System.out.println(article.getURL());
            System.out.println(article.getContent());
            System.out.println(article.getPublicationDate());
            System.out.println("\n");
        });
    }
}
