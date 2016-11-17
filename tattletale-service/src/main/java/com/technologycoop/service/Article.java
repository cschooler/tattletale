package com.technologycoop.service;

import java.net.URL;
import java.util.Date;


public interface Article {

    // todo: add title

    URL getURL();
    String getContent();
    Date getPublicationDate();
}
