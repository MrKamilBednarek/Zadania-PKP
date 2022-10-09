package com.kamil.projektPKP.Service;

import com.kamil.projektPKP.model.Cytat;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class getKanyeQuoteImpl implements getKanyeQuote {
    private final RestTemplate restTemplate;

    public getKanyeQuoteImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Cytat getOneQuote() {
        Cytat cytat=restTemplate.exchange("https://api.kanye.rest/", HttpMethod.GET, HttpEntity.EMPTY,Cytat.class).getBody();
        return cytat;
    }
}
