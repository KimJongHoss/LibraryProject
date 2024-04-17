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
               
              <form method="post" id="frm" name="frm">
              
              <div class="col-md-6 mb-3">
              <label for="useremail">이메일</label>
              <input type="text" class="form-control" id="useremail" name="useremail" placeholder="Email" required>
              <div class="invalid-feedback">
                이메일을 입력해주세요.
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
               
               <button class="btn btn-primary" type="submit">아이디 찾기</button>
               <a href="/"><button type="button" class="btn btn-green">메인으로</button></a>
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
