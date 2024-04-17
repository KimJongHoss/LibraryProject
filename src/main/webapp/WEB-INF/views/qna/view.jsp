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
			<h2>Q&A 질문</h2>
			<table class="table">
			<tr>
				<td style="border-right: 1px solid #D5D5D5;"> 작성자 </td><td>${questionDTO.writer }</td>
			<tr>
			<tr>
				<td style="border-right: 1px solid #D5D5D5;"> 제목 </td><td>${questionDTO.title }</td>
			</tr>
			<tr style="height: 300px;">
				<td style="width: 100px; border-right: 1px solid #D5D5D5;"> 내용 </td><td>${questionDTO.content }</td>
			<tr>
            </table>
            </div>
            </section>
            
            <br>
            <section class="Answer_content">
	            <div>
            <c:if test="${questionDTO.etc==1}">
				<h2>Q&A 답변</h2>
					<table class="table table-bordered">
						<tr>
							<td style="border-right: 1px solid #D5D5D5;">번호 </td><td>${answer.question_num }</td><td style="border-right: 1px solid #D5D5D5; width: 100px "> 작성자 </td><td>${answer.writer }</td>
						<tr>
						<tr>
							<td style="border-right: 1px solid #D5D5D5;"> 작성일 </td><td colspan="3">${answer.regdate }</td>
						</tr>
						<tr style="height: 300px;">
							<td style="width: 100px; border-right: 1px solid #D5D5D5;"> 내용 </td><td colspan="3">${answer.content }</td>
						<tr>
		            </table>
		            </c:if>
			            <div class="detail_btn_box">
		            	<c:if test="${userid != null}">
          				<c:if test="${userid == questionDTO.writer}">
			            <c:if test="${questionDTO.etc!=1}">
						<a href="${contextPath }/qna/update?bno=${questionDTO.question_num}&writer=${questionDTO.writer }" role="button" class="btn btn-dark">수정</a>
						<a href="${contextPath }/qna/delete?bno=${questionDTO.question_num}" role="button" class="btn btn-dark">삭제</a>			
						</c:if>
						</c:if>
						</c:if>
			            <a href="/qna/list?page=1" class="btn btn-dark">목록</a>
			            </div>
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
