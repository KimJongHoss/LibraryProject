# 도서관 프로젝트 
도서관의 여러 가지 기능을 담고 있는 웹사이트를 만들어보았습니다.


---

# 구현한 기능
![도서관프로젝트joblist1](https://github.com/KimJongHoss/libraryProject/assets/162934165/72291205-cae1-4166-86df-baaa43c2fab2)
![도서관프로젝트joblist2](https://github.com/KimJongHoss/libraryProject/assets/162934165/a842c40a-6e2b-47a2-8c21-10d2884040e9)



1) 정회원 전환 신청 기능 (회원이 이용하는 기능)
2) 블랙리스트 구제 신청 기능 (회원이 이용하는 기능)
3) 정회원 전환 신청 수락/거부 기능 (관리자가 이용하는 기능)
4) 연체 구제 신청 수락/거부 기능 (관리자가 이용하는 기능)
5) 블랙리스트 구제 신청 수락/거부 기능 (관리자가 이용하는 기능)
6) Q&A 답변 기능 (관리자가 이용하는 기능)
7) 공지사항 CRUD (관리자가 이용하는 기능)
8) 배송 신청 수락/거부 기능 (관리자가 이용하는 기능)
9) 상호대차 신청 수락/거부 기능 (관리자가 이용하는 기능)
10) 도서관 CRUD (관리자가 이용하는 기능)
11) 사서 CRUD (관리자가 이용하는 기능)



  





---
# 웹 페이지    

1) index
![index1](https://github.com/KimJongHoss/libraryProject/assets/162934165/dd6d28a2-35a5-432b-afaa-19223e69bc7d)
![index2](https://github.com/KimJongHoss/libraryProject/assets/162934165/d28aacd1-89f6-44b8-93c9-47289c784552)
![index3](https://github.com/KimJongHoss/libraryProject/assets/162934165/5f04b55e-1523-4035-8e9b-9350a45bd693)
![index4](https://github.com/KimJongHoss/libraryProject/assets/162934165/7969d390-edaa-4c84-a1a0-1fc199216572)
![index5](https://github.com/KimJongHoss/libraryProject/assets/162934165/0f028108-4cf9-4635-9255-459168ed3c36)

어젠도서관 홈페이지 기본 화면입니다.

---

2) 권한 별 index

![login](https://github.com/KimJongHoss/libraryProject/assets/162934165/d487a49b-89d6-4725-a7ae-53abd6b7ca90)

우측 상단에 있는 로그인 버튼을 눌러서 로그인을 할 수 있습니다. 

로그인으로 인해 생성되는 세션에 따라서 index에 출력되는 내용이 조금씩 달라지게 됩니다.

![semiMemberIndex](https://github.com/KimJongHoss/libraryProject/assets/162934165/3babcefc-7231-4d5e-9e42-853ccae55ea2)

준회원 index 화면입니다. 우측 상단에 '정회원 전환 신청' 배너가 추가됩니다.

![regularMemberIndex](https://github.com/KimJongHoss/libraryProject/assets/162934165/a847a94a-a026-4c85-9b39-893842df1b27)

정회원 index 화면입니다. 가장 기본적인 화면입니다.

![overdueMemberIndex](https://github.com/KimJongHoss/libraryProject/assets/162934165/e5909b4c-6805-458e-808b-be7ac4d84687)

연체 회원 index 화면입니다. 우측 상단에 '연체 회원 구제 신청' 배너가 추가됩니다.

![blacklistMemberIndex](https://github.com/KimJongHoss/libraryProject/assets/162934165/59215903-c47a-4001-8097-28cd6c50f313)

블랙리스트 회원 index 화면입니다. 우측 상단에 '블랙리스트 구제 신청' 배너가 추가됩니다.

![adminMemberIndex](https://github.com/KimJongHoss/libraryProject/assets/162934165/68d82b1f-bf74-4f40-8edf-30825765cdad)

사서/관리자 index 화면입니다. 우측 상단에 '관리자 모드' 배너가 추가됩니다.

![adminIndex](https://github.com/KimJongHoss/libraryProject/assets/162934165/0803f6c9-7c0e-4110-9004-7d15add0c3af)

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
                

