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
		  
		  <script type="text/javascript">
		     function checkform() {
		         if (! (document.fr.title.value.length >= 5 && document.fr.title.value.length <= 10)) {
		            alert("제목은 5~10자 내외로 입력해주세요");
		            document.fr.title.value = "";
		            document.fr.title.select();
		         } else if (! (document.fr.content.value.length >= 8 && document.fr.content.value.length <= 1000)) {
		            alert("내용은 8~1000자 내외로 입력해주세요");
		            document.fr.content.value = "";
		            document.fr.content.select();

		      }
		     </script>
		  <section class="content container-fluid">
				<div class="box-header">
					<h3 class="box-title">자유게시판 글수정</h3>
				</div>
			
				<form class="fr"role="form" method="post">
					<div class="box-body">
						<div class="form-group">
							<label>제목</label> 
							<input type="text" name='title' class="form-control" value="${freeDTO.title }"required>
						</div>
						<div class="form-group">
							<label>내용</label>
							<input class="form-control" name="content" value="${freeDTO.content}" style="height: 300px;" required></input>
						</div> 
						<div class="box-footer">
						<button type="submit" id="write">수정완료</button>
					</div>
					
			
					
					</div>
				</form>
		    </section>
               
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
