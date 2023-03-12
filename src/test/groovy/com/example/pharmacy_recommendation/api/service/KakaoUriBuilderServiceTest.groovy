package com.example.pharmacy_recommendation.api.service

import org.apache.tomcat.util.buf.UDecoder
import spock.lang.Specification

import java.nio.charset.StandardCharsets

class KakaoUriBuilderServiceTest extends Specification {

    private KakaoUriBuilderService kakaoUriBuilderService

    // setup : 모든 메서드가 시작되기 전에 처음으로 시작되는 메서드
    def setup(){
        kakaoUriBuilderService = new KakaoUriBuilderService()
    }

    def "buildUriByAddressSearch - 한글 파라미터일 때 정상적으로 인코딩 되는지 확인"(){

        given: // 테스트 데이터 입력
        String address = "서울 성북구"
        def charset = StandardCharsets.UTF_8

        when: // 테스트 실행 동작 입력
        def uri = kakaoUriBuilderService.buildUriByAddressSearch(address)
        def decodeResult = URLDecoder.decode(uri.toString(), charset) // uri를 utf-8로 디코딩해서 내가 입력한 주소가 맞는지 확인

        then: // when을 실행했을 때 결과값 출력
        println(uri)
        decodeResult == "https://dapi.kakao.com/v2/local/search/address.json?query=서울 성북구"
    }





}
