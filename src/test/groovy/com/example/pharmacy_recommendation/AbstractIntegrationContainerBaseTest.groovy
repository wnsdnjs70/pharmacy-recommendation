package com.example.pharmacy_recommendation

import org.springframework.boot.test.context.SpringBootTest
import org.testcontainers.containers.GenericContainer
import spock.lang.Specification

@SpringBootTest
class AbstractIntegrationContainerBaseTest extends Specification{

    static final GenericContainer MY_REDIS_CONTAINER  // 한번만 실행되도록

    static {
        MY_REDIS_CONTAINER = new GenericContainer<>("redis:6") // 컨테이너 이미지 설정
                .withExposedPorts(6379)

        MY_REDIS_CONTAINER.start()

        // spring에게 레디스의 호스트, 포트 번호를 알려줌
        System.setProperty("spring.redis.host",MY_REDIS_CONTAINER.getHost())
        System.setProperty("spring.redis.port",MY_REDIS_CONTAINER.getMappedPort(6379).toString())
    }
}

