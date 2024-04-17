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
                            <form method="post">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">                       
                                    <tbody>
                                        <c:forEach var="book" items="${allBook}">
									    <tr>
									    <input type="hidden" value="${book.isbncode }" />
									    <input type="hidden" value="${book.library_code }"/>
									    <input type="hidden" value="${page }" />
									        <th><img src="${contextPath }/resources/assets/image/${book.image}" 
									        		onerror="this.src='${contextPath }/resources/assets/img/noimg.jpg'" 
									        		alt="100" width="200"/></th>
									        <th><a href="${contextPath }/book/detail?isbncode=${book.isbncode }&library_code=${book.library_code}&page=${page}">
									        	${book.book_name}</a></th>
									        <th>${book.author}/${book.published_date}</th>
									        <th>${book.name }</th>
									        <th>
									        	<br>보유권수 : ${book.loan_available }/
									       		<br>대출권수 : ${book.loan_status }</th> 										     
								            <th>
								            	<c:if test="${userid != null }">
								            		<button type="button" class="btn btn-primary" onclick="location.href='/book/marketin?page=1&isbncode=${book.isbncode}'">찜하기</button>
								            	</c:if>
								            	<c:if test="${userid == null }">
								            		<button class="btn btn-primary"  disabled>찜하기</button>
								            	</c:if>
								            	<c:if test="${book.loan_status != book.loan_available and userid != null}">
								            		<button type="submit" class="btn btn-primary" onclick="javascript: form.action='${contextPath }/book/loan?isbncode=${book.isbncode}&library_code=${book.library_code }&page=${page } '">대출하기</button>
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
										</c:forEach>
                                    </tbody>
                                </table>
                                </form>
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
        
      
        <!-- Footer-->
        <footer class="yesterdayfooter">
		    <%@ include file="../include/user/footer.jsp" %>
		</footer>
        
        <!-- Bootstrap core JS-->
		    <%@ include file="../include/user/plug.jsp" %>
        
    </body>
</html>
