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
            
    <div class="container-fluid">

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">도서 상세</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                            <form method="post">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">                       
                                    <thead>
                                        <tr>                                       		
                                        	<th>표지</th>
                                        	<th>도서명</th>
                                        	<th>ISBN코드</th>
                                        	<th>작가</th>
                                        	<th>발행일</th>
                                        	<th>소개글</th>
                                        	<th>보유 도서관</th>
                                        	<th>보유권수/대출권수</th>
                                        </tr>
                                    </thead>
                                    <tbody>                                       
									    <tr>
									        <th><img src="${contextPath }/resources/assets/image/${book.image}" 
									        		onerror="this.src='${contextPath }/resources/assets/img/noimg.jpg'" 
									        		alt="200" width="300"/></th>
									        <th >${book.book_name}</th>
									        <th>${book.isbncode }</th>
									        <th>${book.author}</th>
									        <th>${book.published_date}</th>									        
									        <th>${book.introduction}</th>
									        <th>${book.name}</th>
									        <th>
									        	<br>보유권수 : ${book.loan_available }/
									       		<br>대출권수 : ${book.loan_status }</th>									       
									        </tr>	
									     <tr>
									        <th>							            							            									   
								            	<c:if test="${userid != null }">
								            		<button class="btn btn-primary" onclick="location.href='/book/marketin'">찜하기</button>
								            	</c:if>
								            	<c:if test="${userid == null }">
								            		<button class="btn btn-primary"  disabled>찜하기</button>
								            	</c:if>
								            	<c:if test="${book.loan_status != book.loan_available and userid != null}">
								            		<button type="submit" class="btn btn-primary" onclick="javascript: form.action='/book/loan?isbncode=${book.isbncode}&library_code=${book.library_code }&page=${page } '">대출하기</button>
								                </c:if>
								                <c:if test="${book.loan_status == book.loan_available or userid == null}">
									    			<button class="btn btn-primary" disabled>대출하기</button>
									    		</c:if>
												<c:if test="${book.loan_status != book.loan_available and userid != null}">
								                	<button type="button" class="btn btn-primary" onclick="location.href='${contextPath }/user/inter?isbncode=${book.isbncode }&library_code=${book.library_code }'">상호대차</button>							            									    			
									    		</c:if>
									    		<c:if test="${book.loan_status == book.loan_available or userid == null}">
								                	<button class="btn btn-primary" disabled>상호대차</button>						            
									    		</c:if>
									    		<c:if test="${book.loan_status != book.loan_available and userid != null}">
								                	<button type="button" class="btn btn-primary" onclick="location.href='${contextPath }/user/deliveryform?isbncode=${book.isbncode }&library_code=${book.library_code }'">책배송</button>							            									    			
									    		</c:if>
									    		<c:if test="${book.loan_status == book.loan_available or userid == null}">
								                	<button class="btn btn-primary" disabled>책배송</button>						            
									    		</c:if>
									    	</th>		
									    </tr>
									    
										
                                    </tbody>
                                </table>
                                </form>
                            </div>
                            <button class="btn btn-primary" onclick="location.href='/book/list?page=${page}'">목록</boutton>
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
        
    </body>
</html>
