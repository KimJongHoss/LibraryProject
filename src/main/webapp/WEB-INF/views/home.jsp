<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="en">
    <head>
    <%@ include file="./include/user/head.jsp" %>
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
          <%@ include file="./include/user/topnav.jsp" %>
        </nav>
        
        
        <!-- About-->
        <section class="about-section text-center" id="about">
          <%@ include file="./include/user/about.jsp" %>
        </section>
        
        
        <!-- Projects-->
        <section class="projects-section bg-light" id="projects">
        <div class="container px-4 px-lg-5">
        
               <!-- 
               여기에 내용 입력 
               ----------------------------------------------------------
               -                                          -
               -                                          -
               -               Insert Content                  -
               -                                          -
               -                                          -
               ----------------------------------------------------------
               -->
               
 	
				<!-- 팝업 -->
				
				<jsp:include page="popup.jsp"/>
               <!-- Featured Project Row-->
                <div class="row gx-0 mb-4 mb-lg-5 align-items-center" style="margin-bottom: 180px !important;">
                    <div class="col-xl-8 col-lg-7"><img class="img-fluid mb-3 mb-lg-0" src="${contextPath }/resources/assets/img/book2.png" alt="..." /></div>
                    <div class="col-xl-4 col-lg-5">
                        <div class="featured-text text-center text-lg-left" style="margin-left: 30px; width: 440px;">
                            <h4>Catalyst</h4>
                            <p class="text-black-50 mb-0">책은 새로운 세계를 열어주며 우리에게 끝없는</p> <p class="text-black-50 mb-0" style="margin-bottom: 5px !important;">상상력의 선물을 안겨줍니다.</p> <p class="text-black-50 mb-0">그 안에는 미래에 대한 희망과 꿈이 자리하고 있으며,</p><p class="text-black-50 mb-0"> 이를 통해 우리의 삶은 변화의 깊은 강으로 흘러갑니다.</p>
                        </div>
                    </div>
                </div>
                
                <div class="row gx-0 mb-4 mb-lg-5 align-items-center" style="margin-bottom: 180px !important;">
                    <div class="col-xl-4 col-lg-5">
                        <div class="featured-text text-center text-lg-left" style="border-right: 8px solid rgb(100, 161, 157); border-left: none; padding: 0 32px 70px 0; margin-right: 30px;">
                            <h4>Serenity</h4>
                            <p class="text-black-50 mb-0">도서관 속 커피 향이 퍼지며, 여유롭게 책을 읽는 그 시간. 이 곳은 마음의 평온을 찾는 곳이다. </p>
                        </div>
                    </div>
                    <div class="col-xl-8 col-lg-7"><img class="img-fluid mb-3 mb-lg-0" src="${contextPath }/resources/assets/img/book4.png" alt="..." /></div>
                </div>
                
                <!-- Project One Row-->
                <div class="row gx-0 mb-5 mb-lg-0 justify-content-center">
                    <div class="col-lg-6"><img class="img-fluid" src="${contextPath }/resources/assets/img/book1.png" alt="..." /></div>
                    <div class="col-lg-6">
                        <div class="bg-black text-center h-100 project">
                            <div class="d-flex h-100">
                                <div class="project-text w-100 my-auto text-center text-lg-left">
                                    <h4 class="text-white">Exploration</h4>
                                    <p class="mb-0 text-white-50">독서는 우리를 전에 없던 곳으로 이끕니다. 여기는 탐험가들을 위한 문헌의 세계입니다.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Project Two Row-->
                <div class="row gx-0 justify-content-center">
                    <div class="col-lg-6"><img class="img-fluid" src="${contextPath }/resources/assets/img/book3.png" alt="..." /></div>
                    <div class="col-lg-6 order-lg-first">
                        <div class="bg-black text-center h-100 project">
                            <div class="d-flex h-100">
                                <div class="project-text w-100 my-auto text-center text-lg-right">
                                    <h4 class="text-white">Journey</h4>
                                    <p class="mb-0 text-white-50">향기로 가득한 도서관에서 지식의 여정을 시작하세요. 그 여정은 인생을 더욱 풍요롭게 만들 것입니다.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        
       
        
        <!-- Footer-->
         
        <footer class="yesterdayfooter">
    <%@ include file="./include/user/footer.jsp" %>
</footer>
        
        <!-- Bootstrap core JS-->
          <%@ include file="./include/user/plug.jsp" %>
        
    </body>
</html>