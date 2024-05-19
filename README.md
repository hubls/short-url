# 🍀short-url

<img  src="https://github.com/hubls/short-url/assets/18051516/da1e3b3f-dd9a-4d6a-a9d8-07971fd447bc" height="300px" width="300px"></p>

#### Java, Spring으로 개발하는 URL 단축 사이트

`URL 단축` 프로젝트는 RESTful 원칙에 기반하여 설계되었고, </br>
누구나 쉽게 사용할 수 있게 하기 위해, 매우 단순한 인터페이스로 구현했습니다.
</br>

## 🎯 프로젝트 기간
2024.04.13 ~ 2024.04.30

 </br>

## 🚀 프로젝트 주요 기능

**[URL 단축]**
- 클라이언트에게 Original URL을 입력받으면 단축된 URL을 반환하는 서비스.
- 기존 URL을 4자리 랜덤 값을 생성하여 Key 값으로 Mongo DB에 저장.
- 다른 사용자가 pojay.com/XXXX 와 같이 해당 key값을 입력받게 되면 기존 URL을 redirect 하여 반환.

**[무분별한 URL 생성 제한]**
- Ddos와 같은 공격에 방어하기 위해  Bucket4j를 활용.
- 사이트 새로고침과 같은 View 요청은 막지 않으며, URL 생성 과 같이 DB에 부하를 줄 수 있는 API 호출 제한.
- 1초에 2번 이상 요청하면 경고 1회, 1시간 이내 경고 10회 이상이 발생하면 해당 IP의 URL 단축 기능(기능 api 요청)을 막음.

## 📑 사용 기술 스택
- Java 17
- Spring boot 3.2.3
- MongoDB 7.0.8
- Spring Data JPA
- Ubuntu 22.04.3
- Docker 25.0.1
- Nginx 1.18.0
  <br></br>

## 🚀 배포 웹사이트 화면

### 1. **사이트 접속**

![사이트접속](https://github.com/hubls/short-url/assets/18051516/ccf9bd28-5e9a-443d-81b3-bdb4bb8ca2b1)

### 2. **URL 단축 기능**

![단축기능사용](https://github.com/hubls/short-url/assets/18051516/f1f03187-218a-47c7-8227-dcd8bda7f56f)

### 3. **사이트 구성**

![사이트구성](https://github.com/hubls/short-url/assets/18051516/ce914812-ba5f-44bd-8c84-ae53f62bcbf1)

### 4. **구글 노출**

![구글노출](https://github.com/hubls/short-url/assets/18051516/5c68fbd4-91ba-4bcb-8901-2cdcc95cf8e1)
