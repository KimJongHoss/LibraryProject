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
    <section class="signup-section" id="signup">
                <div class="col-md-10 col-lg-8 mx-auto text-center">
                        <i class="far fa-paper-plane fa-2x mb-2 text-white"></i>
                        <h2 class="text-white mb-5">찾는 도서명을 입력하요</h2>
                 
                        <form class="form-signup" action="${contextPath }/book/search" id="search" method="GET">
                            <!-- Book Name input-->
                            <div class="row input-group-newsletter">
                                <div class="col"><input class="form-control" name="keyword" type="text" placeholder="도서명을 입력하세요." aria-label="도서명을 입력하세요." /></div>
                                <input type="hidden" name="page" value="1">
                                <div class="col-auto"><button class="btn btn-primary" type="submit">검색</button></div>
                     		</div>
                    	</form>
                </div>
    </section>
    
                     <hr>
                     &emsp;
                     &emsp;
                     &emsp;&emsp;&emsp;&emsp;
    
    <div class="container-fluid">

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">도서 목록</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">                       
                                    <tbody>
                                        <c:forEach var="search" items="${search}">
									    <tr>
									    <input type="hidden" value="${search.isbncode }" />
									    <input type="hidden" value="${search.library_code }"/>
									    <input type="hidden" value="${page }" />
									        <th><img src="${contextPath }/resources/assets/image/${search.image}" 
									        		onerror="this.src='${contextPath }/resources/assets/img/noimg.jpg'" 
									        		alt="100" width="200"/></th>
									        <th><a href="${contextPath }/book/detail?isbncode=${search.isbncode }&library_code=${search.library_code}&page=${page}">
									        	${search.book_name}</a></th>
									        <th>${search.author}/${search.published_date}</th>
									        <th>${search.name }</th>
									        <th>
									        	<br>보유권수 : ${search.loan_available }/
									       		<br>대출권수 : ${search.loan_status }</th> 										     
								            <th>
								            	<c:if test="${userid != null }">
								            		<button class="btn btn-primary" onclick="location.href='${contextPath }/market/list'">찜하기</button>
								            	</c:if>
								            	<c:if test="${userid == null }">
								            		<button class="btn btn-primary"  disabled>찜하기</button>
								            	</c:if>
								            	<c:if test="${search.loan_status != search.loan_available and userid != null}">
								            		<button type="submit" class="btn btn-primary" onclick="javascript: form.action='/book/loan?isbncode=${search.isbncode}&library_code=${search.library_code }&page=${page } '">대출하기</button>
								                </c:if>
								                <c:if test="${search.loan_status == search.loan_available or userid == null}">
									    			<button class="btn btn-primary" disabled>대출하기</button>
									    		</c:if>
									    		<c:if test="${search.loan_status != search.loan_available and userid != null}">
								                	<button class="btn btn-primary" onclick="location.href='${contextPath }/user/inter?isbncode=${search.isbncode }&library_code=${search.library_code }'">상호대차</button>							            									    			
									    		</c:if>
									    		<c:if test="${search.loan_status == search.loan_available or userid == null}">
								                	<button class="btn btn-primary" disabled>상호대차</button>						            
									    		</c:if>
									    		<c:if test="${search.loan_status != search.loan_available and userid != null}">
								                	<button class="btn btn-primary" onclick="location.href='${contextPath }/user/inter?isbncode=${search.isbncode }&library_code=${search.library_code }'">책배송</button>							            									    			
									    		</c:if>
									    		<c:if test="${search.loan_status == search.loan_available or userid == null}">
								                	<button class="btn btn-primary" disabled>책배송</button>						            
									    		</c:if>
									    		
									    	</th>	
									    </tr>
										</c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
        <div>
           <c:if test="${prev }">
               <span>
                  [ <a href="${contextPath }/book/list?page=${startNum -1 }">이전</a> ]
               </span>
            </c:if>
            
            <c:forEach var="num" begin="${startNum }" end="${endNum }">
               <span>
                  <a href="${contextPath }/book/list?page=${num }" > ${num }</a>
               </span>
            </c:forEach>
            
            <c:if test="${next }">
               <span>
                  [ <a href="${contextPath }/book/list?page=${endNum + 1}" class="next">다음</a> ]
               </span>
            </c:if>
           
               
               
               
               
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
