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
            
    <div class="container-fluid">

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">도서 대출증</h6>
                        </div>
                        <div class="card-body"> 
                        
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">                       
                                    <thead>
                                        <tr>                                       		
                                        	<th>대출 번호</th>
                                        	<th>표지</th>
                                        	<th>도서명</th>
                                        	<th>ISBN코드</th>
                                        	<th>대출한 도서관</th>
                                        	<th>대출일</th>
                                        	<th>반납일</th>
                                        </tr>
                                    </thead>
                                    <tbody>                                     
									    <tr>
									        <th>${loanDetail.loan_detail_num}</th>									        									      
									        <th><img src="${contextPath }/resources/assets/image/${book.image}" 
									        		onerror="this.src='${contextPath }/resources/assets/img/noimg.jpg'" 
									        		alt="200" width="300"/></th>
									        <th >${book.book_name}</th>
									        <th>${book.isbncode }</th>								        
									        <th>${book.name}</th>
									        <th>${loanDetail.loan_date }</th>									        									      
									        <th>${loanDetail.return_date }</th>									        									      
									    </tr>										
                                    </tbody>
                                </table>
                            </div>
                            
                            <button class="btn btn-primary" onclick="location.href='/book/list?page=${page}'">목록</boutton>
                        </div>
                    </div>

                </div>
        <div>
                    
            </div>
        </section>
        
        
        <!-- Signup-->
        <section class="signup-section" id="signup">
		    <%@ include file="../include/user/signup.jsp" %>
        </section>
        
        <!-- Contact-->
        <section class="contact-section bg-black">
		    <%@ include file="../include/user/contact.jsp" %>
        </section>
        <!-- Footer-->
        <footer class="footer bg-black small text-center text-white-50">
		    <%@ include file="../include/user/footer.jsp" %>
		</footer>
        
        <!-- Bootstrap core JS-->
		    <%@ include file="../include/user/plug.jsp" %>
        
    </body>
</html>
