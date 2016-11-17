package com.technologycoop.service;

import java.util.Collection;

public interface ArticleCrawler {
    Collection<? extends Article> getArticles();
}
