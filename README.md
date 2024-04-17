# 도서관 프로젝트 
도서관의 여러 가지 기능을 담고 있는 웹사이트를 만들어보았습니다.


---

# 구현한 기능
![joblist1](https://github.com/KimJongHoss/LibraryProject/assets/162934165/39b2dd39-19b7-4d56-acc8-9ddbbbf04f1d)
![joblist2](https://github.com/KimJongHoss/LibraryProject/assets/162934165/2afc27f3-8829-4bd0-98d5-f5d58a45b207)


- [x] 정회원 전환 신청 기능 (회원이 이용하는 기능)
- [x] 블랙리스트 구제 신청 기능 (회원이 이용하는 기능)
- [x] 정회원 전환 신청 수락/거부 기능 (관리자가 이용하는 기능)
- [x] 연체 구제 신청 수락/거부 기능 (관리자가 이용하는 기능)
- [x] 블랙리스트 구제 신청 수락/거부 기능 (관리자가 이용하는 기능)
- [x] Q&A 답변 기능 (관리자가 이용하는 기능)
- [x] 공지사항 CRUD (관리자가 이용하는 기능)
- [x] 배송 신청 수락/거부 기능 (관리자가 이용하는 기능)
- [x] 상호대차 신청 수락/거부 기능 (관리자가 이용하는 기능)
- [x] 도서관 CRUD (관리자가 이용하는 기능)
- [x] 사서 CRUD (관리자가 이용하는 기능)
- [ ] 열람실 관리 CRUD (관리자가 이용하는 기능)
- [ ] 회원 검색 기능(관리자가 이용하는 기능)
- [ ] 연체 회원 연체 등급 부여 기능 (관리자가 이용하는 기능)
- [ ] 블랙리스트 회원 블랙리스트 등급 부여 기능 (관리자가 이용하는 기능)
- [ ] 사서 추가 기능에 주소 API 삽입 및 프로필 사진 이미지 추가 기능 (관리자가 이용하는 기능)
- [ ] 도서관 일정 기능 (관리자가 이용하는 기능)
- [ ] 분실물 CRUD (관리자가 이용하는 기능)
- [ ] 사서에게 하고 싶은 말 기능 (회원이 이용하는 기능)
- [ ] 사서에게 하고 싶은 말에 대한 알림 기능 (처리 시 해당 알림이 사라질 수 있도록) (사서가 이용하는 기능)
- [ ] 사서에게 하고 싶은 말 답변 기능 (사서가 이용하는 기능)
- [ ] 모든 신청 관련 데이터 표와 그래프로 표현하는 기능 (관리자 모드에서 열람 가능한 기능)


---
# 웹 페이지    

1) index

![index1](https://github.com/KimJongHoss/LibraryProject/assets/162934165/4296a057-9632-4d64-b647-3f782580d81a)
![index2](https://github.com/KimJongHoss/LibraryProject/assets/162934165/c9a65522-a4bf-4627-b03d-c7c868958223)
![index3](https://github.com/KimJongHoss/LibraryProject/assets/162934165/7b02c8d9-5cb8-4458-8616-b54745888cde)
![index4](https://github.com/KimJongHoss/LibraryProject/assets/162934165/cb636df8-4c65-401d-8744-5d178ea421ef)
![index5](https://github.com/KimJongHoss/LibraryProject/assets/162934165/5499a02b-c81c-4856-b232-25e1690a1682)



어젠도서관 홈페이지 기본 화면입니다.

---

2) 권한 별 index

![login](https://github.com/KimJongHoss/LibraryProject/assets/162934165/b05b1524-7313-45ad-8dd8-6597b8938cdb)


우측 상단에 있는 로그인 버튼을 눌러서 로그인을 할 수 있습니다. 

로그인으로 인해 생성되는 세션에 따라서 index에 출력되는 내용이 조금씩 달라지게 됩니다.

![semiMemberIndex](https://github.com/KimJongHoss/LibraryProject/assets/162934165/a541fbc3-acda-4b80-b029-ae896285f5a2)


준회원 index 화면입니다. 우측 상단에 '정회원 전환 신청' 배너가 추가됩니다.

![regularMemberIndex](https://github.com/KimJongHoss/LibraryProject/assets/162934165/edd5bdd6-70ae-4d2f-9cdf-8fa4d9eb86fa)

정회원 index 화면입니다. 가장 기본적인 화면입니다.

![overdueMemberIndex](https://github.com/KimJongHoss/LibraryProject/assets/162934165/e37a6f9f-b0cb-4f37-af56-151759d3ce5f)

연체 회원 index 화면입니다. 우측 상단에 '연체 회원 구제 신청' 배너가 추가됩니다.

![blacklistMemberIndex](https://github.com/KimJongHoss/LibraryProject/assets/162934165/eb3a1a5c-ef69-4722-8d93-0d4623f7eb2b)

블랙리스트 회원 index 화면입니다. 우측 상단에 '블랙리스트 구제 신청' 배너가 추가됩니다.

![adminMemberIndex](https://github.com/KimJongHoss/LibraryProject/assets/162934165/4042c638-c673-4006-a33e-7bcbe8874325)

사서/관리자 index 화면입니다. 우측 상단에 '관리자 모드' 배너가 추가됩니다.

![adminIndex](https://github.com/KimJongHoss/LibraryProject/assets/162934165/9a7b9e66-ba5e-497a-865c-6ee9dc2879b3)

관리자 모드를 누르시게 되면 adminIndex 화면으로 진입하실 수 있습니다.


---


# 구성원
```swift
public Enginner YesterdayLibrary() {
  public Enginner JongHo;
  public Enginner MinKyung;
  public Enginner Gahyeon;
  public Enginner DooHyun;
  public Enginner TaeGeon;
  public Enginner Sebin;
  ...
}
```


---

# 사용 도구

<img src="https://img.shields.io/badge/spring 3.9.17.RELEASE -6DB33F?style=for-the-badge&logo=springboot&logoColor=white">

<img src="https://img.shields.io/badge/java 11 -007396?style=for-the-badge&logo=java&logoColor=white">

<img src="https://img.shields.io/badge/mysql 8.0.28 -4479A1?style=for-the-badge&logo=mysql&logoColor=white">

<img src="https://img.shields.io/badge/tomcat 9.0-F05032?style=for-the-badge&logo=apachetomcat&logoColor=white">

<img src="https://img.shields.io/badge/mybatis 3.5.6-181717?style=for-the-badge&logo=mybatis&logoColor=white">

<img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white">

<img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white">

<img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black">

<img src="https://img.shields.io/badge/jquery 3.4.1 -0769AD?style=for-the-badge&logo=jquery&logoColor=white">

  
  ---


### 정리내용
<a href="https://jinco.tistory.com/category/libraryProject" target="_blank">
                   <img src="https://img.shields.io/badge/tistory-181717?style=for-the-badge&logo=tistory&logoColor=#000000">
                </a>
                

