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
		  
		  <h2>어젠 도서관 공지사항</h2>
			<table class="table table-hover">
			    <tr>
			        <th>번호</th>
			        <th width="400">제목</th>
			        <th>작성일</th>
			        <th>조회수</th>
			    </tr>
    <c:forEach var="row" items="${list}">
    <tr>
        <td>${row.notice_num}</td>
        <td><a href="view?notice_num=${row.notice_num}">${row.title}</a></td>
        <td>${row.regdate}</td>
        <td><span class="">${row.count}</span></td>
    </tr>    
    </c:forEach>
</table>
		  <!-- 페이징시 -->
			   <div style="display: flex; justify-content: center;">
				   <c:if test="${prev}">
				      <span>[ <a href="${contextPath }/notice/listPage?page=${startNum - 1}">이전</a> ] </span>
				   </c:if>

				   <c:forEach begin="${startNum}" end="${endNum}" var="num">
				       <span style="margin: 0px 10px 0px 0px;">
				         <a href="${contextPath }/notice/list?page=${num}">${num}</a> 
				      </span>
				   </c:forEach>
				
				   <c:if test="${next}">
				      <span>[ <a href="${contextPath }/notice/list?page=${endNum + 1}">다음</a> ] </span>
				   </c:if>
				  </div>
		<!-- 페이징 끝 -->
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
