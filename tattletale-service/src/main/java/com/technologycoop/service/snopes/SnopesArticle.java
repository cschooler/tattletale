package com.technologycoop.service.snopes;

import com.technologycoop.service.Article;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SnopesArticle implements Article {

    private static final int TIMEOUT_SECONDS = 5;
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

    private final URL url;
    private final String content;
    private final Date publicationDate;

    public SnopesArticle(final URL url) {


        final Document document;
        try {
            document = Jsoup.parse(url, TIMEOUT_SECONDS * 1000);

            Elements articles = document.select("[itemprop=articleBody]");
            assert articles.size() == 1;

            Elements publicationDate = document.select("[itemprop=datePublished]");
            assert publicationDate.size() == 1;

            this.url = url;
            this.content = articles.first().text();
            this.publicationDate =  DATE_FORMAT.parse(publicationDate.first().attr("content")); //Instant.parse(publicationDate.first().attr("content"));

        } catch (IOException | ParseException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public URL getURL() {
        return url;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public Date getPublicationDate() {
        return publicationDate;
    }
}
