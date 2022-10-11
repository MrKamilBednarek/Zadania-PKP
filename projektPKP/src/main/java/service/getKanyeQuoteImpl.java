package service;

import model.OneQuote;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class getKanyeQuoteImpl implements getKanyeQuote {
    private final RestTemplate restTemplate;

    public getKanyeQuoteImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public OneQuote getOneQuote() {
        OneQuote cytat=restTemplate.exchange("https://api.kanye.rest/", HttpMethod.GET, HttpEntity.EMPTY, OneQuote.class).getBody();
        return cytat;
    }
}

