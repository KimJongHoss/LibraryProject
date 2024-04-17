<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>

<head>

<style>
		  .yesterdayfooter {
		    background-color: #2FA599;
		    padding: 80px 0px;
		    color: white;
		    text-align: center;
			}
			}
			
          .featured-text {
		    padding-right: 20px; /* 사진과 글귀 사이의 간격을 조절합니다 */
			}
			
			.project {
			    padding-left: 20px; /* 사진과 글귀 사이의 간격을 조절합니다 */
			}
		</style>

</head>
<html>
<script src="/resources/jQuery/jquery-3.4.1.min.js" ></script>
<script>
// opener관련 오류가 발생하는 경우 아래 주석을 해지하고, 사용자의 도메인정보를 입력합니다. ("팝업API 호출 소스"도 동일하게 적용시켜야 합니다.)
//document.domain = "abc.go.kr";

function goPopup(){
	// 주소검색을 수행할 팝업 페이지를 호출합니다.
	// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://business.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
	var pop = window.open("/popup/jusoPopup","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
	
	// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://business.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
    //var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
}


function jusoCallBack(roadFullAddr){
		// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
		document.form.roadFullAddr.value = roadFullAddr;
		
}


</script>
    <head>
    <%@ include file="../include/user/head.jsp" %>
    
    </head>
    
    
    <body id="page-top">
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
		    <%@ include file="../include/user/topnav.jsp" %>
        </nav>
        
        <!-- About-->
        <section class="about-section text-center" id="about">
		    <%@ include file="../include/user/about.jsp" %>
        </section>
        
        
        
        <!-- Projects-->
        <section class="projects-section bg-light" id="projects">
		  <div class="container px-4 px-lg-5">
		  
               <!-- 
               여기에 내용 입력 
               ----------------------------------------------------------
               -														-
               -														-
               -					Insert Content						-
               -														-
               -														-
               ----------------------------------------------------------
               -->
               
            <div class="container">
    <div class="input-form-backgroud row">
      <div class="input-form col-md-12 mx-auto">
        <h4 class="mb-3">회원 정보</h4>
        <form action="/info/update" class="validation-form" novalidate name="form" id="form" method="post">
          <div class="row">
          <div class="mb-3">
            <label for="userid">아이디</label>
            <input type="text" value="${userid }" class="form-control" id="userid" name="userid" placeholder="ID" required readonly="readonly">
          </div>
          
            <div class="col-md-6 mb-3">
              <label for="useremail">이메일</label>
              <input type="text" value="${info.useremail }" class="form-control" id="useremail" name="useremail" placeholder="Email" required>
              <div class="invalid-feedback">
                이메일을 입력해주세요.
              </div>
            </div>

          <div class="mb-3">
            <label for="username">이름</label>
            <input type="text" value="${info.username }" class="form-control" id="username" name="username" placeholder="Name" required>
            <div class="invalid-feedback">
              이름을 입력해주세요.
            </div>
          </div>

          <div class="mb-3">
            <label for="userphonenum">휴대폰 번호</label>
            <input type="number" value="${info.userphonenum }" class="form-control" id="userphonenum" name="userphonenum" placeholder="Phonenum" required>
            <div class="invalid-feedback">
              휴대폰 번호를 입력해주세요.
            </div>
          </div>
          
          <div class="mb-3">
            <label for="userbirth">생년월일<span class="text-muted"></span></label><!-- &nbsp;(필수 아님) -->
            <input type="date" value="${info.userbirth }" class="form-control" id="userbirth" name="userbirth" required="required">
          </div>
          
          <div id="list"></div>
			<div id="callBackDiv">
			<label for="userbirth">주소<span class="text-muted"></span></label>
				<input type="text" value="${info.useraddress }" class="form-control" required="required" id="roadFullAddr"  name="useraddress" placeholder="Address" />
			<input type="button" onClick="goPopup();" value="주소 찾기"/>
			</div>

          <div>
			<button class="btn btn-primary">정보 수정</button>
			<a href="/info/infoupdatepassword"><button type="button" class="btn">비밀번호 수정</button></a>
			 <c:if test="${rankid != 40}">
			 <c:if test="${rankid != 50}">
			<a href="/info/remove"><button type="button" class="btn">회원 탈퇴</button></a>
			</c:if>
			</c:if>
			<a href="/" ><button type="button" class="btn btn-success">메인으로</button></a>
			</div>
        </form>
      </div>
    </div>
               
               
               
               
</div>
</section>               
        
        
        <!-- Footer-->
        <footer class="yesterdayfooter">
		    <%@ include file="../include/user/footer.jsp" %>
		</footer>
        
        <!-- Bootstrap core JS-->
		    <%@ include file="../include/user/plug.jsp" %>
        	<%@ include file="../include/user/bootplugin.jsp" %>
    </body>

</html>