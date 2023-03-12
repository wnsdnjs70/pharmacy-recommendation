package com.example.pharmacy_recommendation.api.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@Service
public class KakaoUriBuilderService {

    private static final String KAKAO_LOCAL_SEARCH_ADDRESS_URL =  "https://dapi.kakao.com/v2/local/search/address.json";

    public URI buildUriByAddressSearch(String address){

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(KAKAO_LOCAL_SEARCH_ADDRESS_URL);
        uriComponentsBuilder.queryParam("query", address);

        URI uri = uriComponentsBuilder.build().encode().toUri(); // 한글이나 공백, 특수문자 등을 위해 반드시 인코딩 해줘야됨.
        log.info("Request Address : {} , Built URI : {}", address, uri);

        return uri;
    }

}
