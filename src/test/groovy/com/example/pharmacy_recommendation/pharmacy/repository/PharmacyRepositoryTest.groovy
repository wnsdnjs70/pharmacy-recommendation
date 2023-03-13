package com.example.pharmacy_recommendation.pharmacy.repository

import com.example.pharmacy_recommendation.AbstractIntegrationContainerBaseTest
import com.example.pharmacy_recommendation.pharmacy.entity.Pharmacy
import org.springframework.beans.factory.annotation.Autowired

class PharmacyRepositoryTest extends AbstractIntegrationContainerBaseTest {

    @Autowired
    private PharmacyRepository pharmacyRepository

    // 싱글턴을 사용하기 때문에 매번 테스트 케이스가 다를 수 있음. 따라서 setup()으로 db 초기화를 해줘야됨
    def setup(){
        pharmacyRepository.deleteAll()
    }


    def "PharmacyRepository Save"(){
        given:
        String address = "서울 특별시 성북구 종암동"
        String name = "은혜 약국"
        double latitude = 36.11
        double longitude = 128.11

        def pharmacy = Pharmacy.builder()
            .pharmacyAddress(address)
            .pharmacyName(name)
            .latitude(latitude)
            .longitude(longitude)
            .build()

        when:
        def result = pharmacyRepository.save(pharmacy)

        then:
        result.getPharmacyAddress() == address
        result.getPharmacyName() == name
        result.getLatitude() == latitude
        result.getLongitude() == longitude

    }

}
