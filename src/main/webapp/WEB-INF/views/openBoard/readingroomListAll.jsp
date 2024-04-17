<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="en">
    <head>
    <%@ include file="../include/user/head.jsp" %>
    </head>
    
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
			<table>  
					<c:forEach var="seatroom" items="${list}" >
						<tr>
						
						<c:if test="${seatroom.seat_status == 0 }">
							<!-- <button class="btn btn-secondary" onclick="location.href='/openBoard/reservation?seat_no=${seatroom.seat_no}'">${seatroom.seat_no}</button> -->
							<button class="btn btn-secondary" onclick="location.href='/underConstruction_user?seat_no=${seatroom.seat_no}'">${seatroom.seat_no}</button>
							</c:if>
							<c:if test="${seatroom.seat_status != 0 }">
							<button class="btn btn-primary">${seatroom.seat_no}</button>
							</c:if>
							
						</tr>	
					</c:forEach>
               </table>
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
