package com.technologycoop.service;

import java.net.URL;
import java.util.Date;


public interface Article {

    String getTitle();
    URL getURL();
    String getContent();
    Date getPublicationDate();
}
