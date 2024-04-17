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
		  
              <section class="content">
		<div>
			<h2>공지사항</h2>
			<table class="table">
			<tr>
				<td style="border-right: 1px solid #D5D5D5;"> 작성자 </td><td>${noticeDTO.writer }</td>
			<tr>
			<tr>
				<td style="border-right: 1px solid #D5D5D5;"> 제목 </td><td>${noticeDTO.title }</td>
			</tr>
			<tr style="height: 300px;">
				<td style="width: 100px; border-right: 1px solid #D5D5D5;">  내용 </td><td>${noticeDTO.content }</td>
			<tr>
            </table>
            		
            <a href="/notice/list?page=1" class="btn btn-dark">목록</a>
            </div>
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
