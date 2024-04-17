<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="en">
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
    
    <script src="/resources/jQuery/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
    $(function(){
  		  $("#passwordok").css("display", "none");
    });
       	function passwordcheck(){
      	  if($("#userpassword").val() != $("#pw").val()){
      		  $("#passwordok").css("display", "inline-block");
      	  } else {
      		  $("#passwordok").css("display", "none");
      	  }
        }
     </script>
     
     
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
               <h2>비밀번호 변경</h2>
               
              <form action="/user/updatepassword" method="post" id="frm" name="frm">
              
              <div class="mb-3">
            <label for="userid">아이디</label>
            <input type="text" class="form-control" id="userid" name="userid" placeholder="ID" required readonly="readonly" value="${userid }">
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
               
               <button class="btn btn-primary">비밀번호 변경</button>
               <a href="/"><button type="button" class="btn btn-green">취소</button></a>
            </form>
               
               
            </div>
        </section>
        
       
        <!-- Footer-->
        <footer class="yesterdayfooter">
		    <%@ include file="../include/user/footer.jsp" %>
		</footer>
        
        <!-- Bootstrap core JS-->
		    <%@ include file="../include/user/plug.jsp" %>
        
    </body>
</html>
