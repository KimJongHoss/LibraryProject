<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<html>
<script src="/resources/jQuery/jquery-3.4.1.min.js" ></script>
<script>
// opener관련 오류가 발생하는 경우 아래 주석을 해지하고, 사용자의 도메인정보를 입력합니다. ("팝업API 호출 소스"도 동일하게 적용시켜야 합니다.)
//document.domain = "abc.go.kr";

function noSpace(obj){ //공백사용못하게
	var str_space = /\s/; //공백 체크
	if(str_space.exec(obj.value)){ //공백체크
		alert("아이디에는 공백을 사용할수 없습니다."); 
		obj.focus();
		obj.value = obj.value.replace(' ',''); //공백제거
		return false;
	}
}

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

$(function(){
    $("#idalready").css("display", "none");
    $("#idok").css("display", "none");
    $("#passwordok").css("display", "none");
 });
 
var pwck = 0;		 
function passwordcheck(){
	if($("#userpassword").val() === $("#pw").val()){
		$("#passwordok").css("display", "none");
		pwck = 1;
	} else {
		$("#passwordok").css("display", "inline-block");
		pwck = 0;
	}
}
 
function idinput(){
 idck = 0;
 $("#idok").css("display", "none");
 $("#idalready").css("display", "inline-block");
};
 
var idck = 0;
$(function(){
 
 //idck 버튼을 클릭했을 때
 $("#idck").click(function(){
 var id = $("#userid").val();
 
 console.log(id);
 $.ajax({
    async : true,
    type : 'POST',
    data : {"id" : id},
    url : "/user/idcheck",
    dataType : "json",
    //contentType : "application/json; charset=UTF-8",
    success : function(data){
       if(data > 0){
          alert("아이디가 존재 합니다");
          $("#divInputId").addClass("has-error")
          $("#divInputId").removeClass("has-success")
          $("#userid").focus();
       } else if(data === -1) {
          alert("사용 불가능한 아이디 입니다");
       } else {
          alert("사용 가능합니다");
          $("#divInputId").addClass("has-success")
          $("#divInputId").removeClass("has-error")
          $("#userid").focus();
          $("#idalready").css("display", "none");
          $("#idok").css("display", "inline-block");
          
          //아이디가 중복하지 않으면 idck = 1
          idck = 1;
       }
    },
    error : function(error){
       alert("erorr : " + JSON.stringify(error));
    }
    });
 });
 
 $("#submit1").click(function(e){
    var idinput = $("#userid").val();
    
    if(confirm("회원가입을 하시겠습니까")){
       if(idck == 0){
          alert("아이디 중복체크를 해주세요");
          return false;
       }else if(pwck == 0) {
          alert("비밀번호 중복 확인을 해주세요");
    	   return false;
       } else {
          alert("회원가입을 축하합니다");
          $("#form").submit();
       }
    }
 });
 
});

</script>
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
        <h4 class="mb-3">회원가입</h4>
        <form class="validation-form" novalidate name="form" id="form" method="post">
          <div class="row">
          <div class="mb-3">
            <label for="userid">아이디</label>
            <input type="text" class="form-control" id="userid" name="userid" placeholder="ID" required oninput="idinput()"
                   onkeyup="noSpace(this);" onchange="noSpace(this);">
            <button type="button" id="idck">중복 체크</button>
            <span id="idok" oninput="idready()">아이디 사용 가능</span>
            <span id="idalready" oninput="idready()">중복 확인해주세요</span>
            <div class="invalid-feedback">
           		아이디을 입력해주세요.
            </div>
          </div>
          
          <div class="mb-3">
            <label for="userpassword">비밀번호</label>
            <input type="password" class="form-control" id="userpassword" name="userpassword" placeholder="Password" required oninput="passwordcheck()">
            <div class="invalid-feedback">
           		비밀번호를 입력해주세요.
            </div>
          </div>
          
          <div class="mb-3">
            <label for="userpassword">비밀번호 확인</label>
            <input type="password" class="form-control" id="pw" name="pw" placeholder="Password" required oninput="passwordcheck()">
            <span id="passwordok">비밀번호 확인해주세요</span>
            <div class="invalid-feedback">
           		비밀번호를 입력해주세요.
            </div>
          </div>
          
          
            <div class="col-md-6 mb-3">
              <label for="useremail">이메일</label>
              <input type="text" class="form-control" id="useremail" name="useremail" placeholder="Email" required>
              <div class="invalid-feedback">
                이메일을 입력해주세요.
              </div>
            </div>
            <div class="col-md-3 mb-3">
              <label for="juso">이메일 주소</label>
              <select class="custom-select d-block w-100" id="juso" name="juso">
                <option value="" disabled="disabled">이메일 선택</option>
                <option>@naver.com</option>
                <option>@google.com</option>
              </select>
              </div>
            </div>
          </div>

          <div class="mb-3">
            <label for="username">이름</label>
            <input type="text" class="form-control" id="username" name="username" placeholder="Name" required>
            <div class="invalid-feedback">
              이름을 입력해주세요.
            </div>
          </div>

          <div class="mb-3">
            <label for="userphonenum">휴대폰 번호</label>
            <input type="number" class="form-control" id="userphonenum" name="userphonenum" placeholder="Phonenum" required>
            <div class="invalid-feedback">
              휴대폰 번호를 입력해주세요.
            </div>
          </div>
          
          <div class="mb-3">
          <input type="radio" name="usergender" value="M" checked="checked">남성
          <input type="radio" name="usergender" value="F">여성
          </div>

          <div class="mb-3">
            <label for="userbirth">생년월일<span class="text-muted"></span></label><!-- &nbsp;(필수 아님) -->
            <input type="date" class="form-control" id="userbirth" name="userbirth" required="required">
          </div>
          
          <div id="list"></div>
			<div id="callBackDiv">
			<label for="userbirth">주소<span class="text-muted"></span></label>
				<input type="text" class="form-control" required="required" id="roadFullAddr"  name="useraddress" placeholder="Address" />
			<input type="button" onClick="goPopup();" value="주소 찾기"/>
			</div>

          <hr class="mb-4">
          <div class="custom-control custom-checkbox">
            <input type="checkbox" class="custom-control-input" id="aggrement" required>
            <label class="custom-control-label" for="aggrement">개인정보 수집 및 이용에 동의합니다.</label>
          </div>
          <div>
			<button type="button" class="btn btn-primary" id="submit1">가입</button>
			<a href="/" ><button class="btn btn-success">메인으로</button></a>
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