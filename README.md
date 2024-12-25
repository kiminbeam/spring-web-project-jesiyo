<h1 align="center">
  WEB프로젝트 (제시요)
</h1>


<div align="center">
  <img src="https://github.com/user-attachments/assets/19080314-fcf1-4447-91b2-b7d443ecb456" width="800">
</div>

## 개요 : 중고 거래 경매 사이트
<br>

<p align="center">
  불특정 다수의 입찰자들이 가격 경쟁을 통해 중고 물품을 쟁취할 수 있는 웹사이트 <br>
  실시간 경매를 통해 구입 및 판매 가능 <br>
  경매를 통한 구매 욕구 자극, 사용자의 높은 스릴감과 만족도 제공
</p>

<br>

---

## 프로젝트 특징
<br>
- 상세 검색 및 필터링, 각종 편의 서비스 :<br><br>
  다양한 검색 옵션과 필터를 제공하여 사용자가 원하는 상품을 쉽게 찾을 수 있게 합니다.<br><br>
- 더 안전한 거래 환경을 제공 :<br><br>
  최종 낙찰이 된 물품에 대해 판매자와 구매자가 모두 구매 확정 버튼을 눌러야 정상적으로 거래가 종료됩니다.<br><br>

## 시연 영상


<br><br>
https://youtu.be/jFeC4igBcF8?si=TA8P59SjZSkA2FJ4

<br><br>



## 팀원
- 박무현(팀장) [![박무현](https://img.shields.io/badge/GitHub-박무현-orange)](https://github.com/MooHyunPark)
- 송승현 [![송승현](https://img.shields.io/badge/GitHub-송승현-blue)](https://github.com/seunghyeon22)
- 조세은 [![조세은](https://img.shields.io/badge/GitHub-조세은-red)](https://github.com/SeeunJoe)
- 김인범 [![김인범](https://img.shields.io/badge/GitHub-김인범-green)](https://github.com/kiminbeam)
- 이나겸 [![이나겸](https://img.shields.io/badge/GitHub-이나겸-yellow)](https://github.com/NakyeomLee)
<br>





## 통합 구현 기능



### 유저 관련 기능
- 로그인, 회원가입, 아이디 비밀번호 찾기, 내 정보 수정, 입금과 출금(약식)
### 경매 관련 기능
- 입찰, 재입찰, 취소, 물품 등록
### 신고 기능
- 판매자 / 구매자 신고
### 관리자 
- 카테고리 관리, 거래 관련 내역 확인, 신고 내용 처리
<br>

<br>

## 내가 구현한 내용
- 프로젝트를 진행하면서 나온 내용 문서화
- 목록페이지 베이스 구현
- 상세페이지 기능 구현
- 입찰, 재입찰 기능 구현
- 경매 시간 종료 시 진행되는 비즈니스 로직 구현
  
  
<br>
<br>

## 보완할 점

<br>
초기 비즈니스 로직을 설계하고 검토하는 과정에서 누락된 내용 :
<br><br>

- 초기 버전에서 입찰 로직을 구현하면서 경매에 등록되는 금액만 생각하고 사용자의 잔고를 계산하지 못한 점.
- 이로인해 다음 버전에서 종료시 진행되는 비즈니스 로직을 구현하는데 시간이 걸렸음.
- 초기에 조금더 상세하게 검토하는 습관을 들여야겠다고 생각했다.

<br><br><br>

## 트러블슈팅
<br><br>

※ 경매 종료 시 서버에 보내는 데이터들을 제대로 검토하지 못하고, 2시간 가량 소비했었다.

1. 경매가 종료되면 진행되는 비즈니스 로직이 4개가 있었습니다. 
2. 이 과정에서 순차적으로 일어나야 하는 로직이어서 await / async를 사용했었고, 빠르게 만들어야한다는 생각에 매몰되어 구현에만 신경을 쓰게 됐습니다.
3. 4개의 로직을 만들고, 실제 페이지에서 test 한 결과, 비즈니스 로직이 진행되고 있는 시점에서 오류가 발생했었습니다. 
4. 어느 과정에서 오류가 발생하는지, tool에서는 찾아낼 수 없었고, 1시간 정도 지난 뒤 브라우저 콘솔을 통해 파악할 수 있었습니다.
5. 콘솔을 통해 오류 발생지점을 파악하고 그 부분에서 보내야하는 필수 데이터가 누락이 된 것을 확인해 고칠 수 있었습니다.

<br><br>

위의 문제가 발생한 이유 : <br>
tool에만 의존을 하여 실제 페이지에서 실행되는 로직들이 실행이 잘 되는지 빠르게 파악하지 못해서.. 

<br>

프로젝트 종료 이후 생각 : <br>
한 페이지에서 여러 로직들이 순차적으로 진행될 경우<br>
back에서 구현을 하고 test를 거치더라도 <br>
실제 로직들이 잘 진행되는 지 빠르게 파악하기 위해서는 브라우저의 콘솔 확인도 중요하다고 생각되었습니다.

<br><br>


## 느낀점
<br>
1. 규칙은 처음에는 따라가기 불편하지만 시간이 지나면 왜 규칙이 생겼는지 알게 된다 : <br>
   단순한 로직을 구현하더라도 Controller, Service, Repository 등 각 역할에 맞게 구현하고, 반환할 때 DTO를 반드시 반환하게 하는 등 <br>
   이런 규칙들은 기존에 몸에 배지 않은 사람에게는 불편할 수 있습니다.<br>
   저는 DTO를 잘 사용하지 않았었고, <br>
   이번에 제대로 컨벤션을 지켜서 개발을 진행해보니 가독성도 좋아지고 특히 문제가 발생했을 때 디버깅을 하는 과정이 엄청 빨라진 것을 느낄 수 있었습니다.
<br><br>


2. 문서화가 중요하다 : <br>
   2주라는 짧은 프로젝트 기간 속에서 프로그램을 구현하는데 트러블이 잘 발생하지 않도록 하기위해서는<br>
   초기 회의, 화면 구현 일정 동안 나오는 의견, 구현 방향들을 파악하면서, 문서로 잘 정리해야 한다고 생각했습니다.<br>
   그래서 저는 이번 프로젝트를 시작하면서, 나오는 의견 및 제시 방안 등을<br>
   DB테이블 표, 요구사항 명세서, 화면구현 그림 등을 최대한 정리하여 팀원들에게 공유하였습니다.<br>
   팀원들과 공유한 문서들을 통해 프로젝트를 구현하면서<br>
   이전 과정보다 더 상세하게 구현할 수 있었고, 트러블 발생이 현저히 적어지게 되어 빠른 시간안에 완성도 있게 구현해낼 수 있게 됐습니다.

<br>
<br>


## 기타

---

## 프로젝트 업무 관리
<br>

- 업무 진행 과정은 업무 보드를 통해 관리하고 확인

<div align="center">
  <img src="https://github.com/user-attachments/assets/fcc350f9-dd29-4561-8896-636f8a71fec4" width="800">
</div>

<br><br><br>

- 진행 중 어려웠던 부분은 한곳에 모아서 서로 공유할 수 있도록 관리
  
<div align="center">
  <img src="https://github.com/user-attachments/assets/f842822b-27c8-4d01-8edc-c0da6d2e37b9" width="800">
</div>
<br><br>


## 프로젝트 기간
<br>

- 2024년 12월 2일 ~ 2024년 12월 18일 (16일간)

<br>
<br>

## ERD
<div align="center">
  <img src="https://github.com/user-attachments/assets/656f46cb-c897-4376-9022-ac4ab7292d2f" width="800">
</div>
<br>
<br><br><br><br>


## 기술 스택
### Backend
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
<img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)

### Frontend
![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E)
![Bootstrap](https://img.shields.io/badge/bootstrap-%238511FA.svg?style=for-the-badge&logo=bootstrap&logoColor=white)

### IDE
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)

### 협업도구
![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)
![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)
![Notion](https://img.shields.io/badge/Notion-%23000000.svg?style=for-the-badge&logo=notion&logoColor=white)
![Slack](https://img.shields.io/badge/Slack-4A154B?style=for-the-badge&logo=slack&logoColor=white)

### 데이터베이스
<img src="https://img.shields.io/badge/H2DB-31A8FF?style=for-the-badge&logo=H2DB&logoColor=white">
<br><br>





### Dependencies
```
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
implementation 'org.springframework.boot:spring-boot-starter-mustache'
implementation 'org.springframework.boot:spring-boot-starter-security'
implementation 'org.springframework.boot:spring-boot-starter-validation'
implementation 'org.springframework.boot:spring-boot-starter-web'
compileOnly 'org.projectlombok:lombok'
developmentOnly 'org.springframework.boot:spring-boot-devtools'
runtimeOnly 'com.h2database:h2'
annotationProcessor 'org.projectlombok:lombok'
testImplementation 'org.springframework.boot:spring-boot-starter-test'
testImplementation 'org.springframework.security:spring-security-test'
testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
implementation group: 'com.google.code.gson', name: 'gson', version: '2.11.0'
implementation 'net.minidev:json-smart:2.4.1'
```
<br><br>






