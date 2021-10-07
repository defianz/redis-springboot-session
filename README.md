# 스프링 부트에서 redis 통해 세션 관리하기
##  redis 실행 (docker)
```
# cd redis 
# docker-compose up -d
```

- standalone 구성
- port listening : 6389
- password : changeme
- file save (60초 마다) : ./master/data:/data
- 세션 확인
```
# redis-cli -a changeme
# keys *
```


## 스프링 부트
- Interceptor 통해 session 저장
- 로그인 시, 세션 생성하여 redisDB에 저장
- logback, spring-session-data-redis, spring-boot-starter-data-redis(LettuceConnectionFactory) 사용
- defian / defian 으로 로그인 

## 추후 진행해볼 내용
- 어플리케이션 클러스터 구성하여 세션 끊김현상 있는지 확인

### 참고
- https://ecsimsw.tistory.com/entry/Spring-Interceptor-Spring-boot
- https://romeoh.tistory.com/entry/Spring-Boot-Logback-%EC%84%A4%EC%A0%95%ED%95%98%EA%B8%B0
- https://gblee1987.tistory.com/158
- https://jaehun2841.github.io/2018/12/03/2018-12-03-docker-10/#node-%EC%A0%9C%EA%B1%B0
