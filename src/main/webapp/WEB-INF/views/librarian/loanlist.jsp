<!-- 사서 목록 페이지 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<c:set var="contextPath" value="${contextPath}"/>

<!DOCTYPE html>
<html lang="en">

<head>

    <%@include file="../include/manager/head.jsp"  %>

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
       
       <%@include file="../include/manager/left_column.jsp"  %>
       
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
       <%@include file="../include/manager/header.jsp"  %>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- DataTales Example -->
                    <section class="signup-section" id="signup">
                <div class="col-md-10 col-lg-8 mx-auto text-center">
                        <i class="far fa-paper-plane fa-2x mb-2 text-white"></i>
                        <h2 class="text-white mb-5">유저아이디를 입력하요</h2>
                 
                        <form class="form-signup" action="${contextPath }/librarian/loansearch" id="search" method="GET">
                            <!-- Book Name input-->
                            <div class="row input-group-newsletter">
                                <div class="col"><input class="form-control" name="keyword" type="text" placeholder="유저아이디를 입력하세요." aria-label="유저아이디를 입력하세요." /></div>
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
   
                    
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">도서 목록</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                       		<th>대출목록번호</th>
                                        	<th>유저아이디</th>
                                        	<th>ISBNCode</th>
                                        	<th>보유 도서관</th>
                                        	<th>대출상세번호</th> 
                                        	<th>반납버튼</th>                                       	
                                        </tr>
                                    </thead>
                                    <tbody>
									    
                                        <c:forEach var="librarian" items="${loanlist}">                                        
									    <tr>
									        <td>${librarian.loan_num }</td>
									        <td>${librarian.userid }</td>
									        <td>${librarian.isbncode}</td>
									        <td>${librarian.name}</td> 										     								           
									        <td><a href="${contextPath }/librarian/loandetail?loan_detail_num=${librarian.loan_detail_num }&library_code=${librarian.library_code}&page=${page}">
									        ${librarian.loan_detail_num}</a></td>
				                            <!-- 도서 반납 버튼 -->
					                        <td><button class="btn btn-primary" onclick="location.href='${contextPath }/librarianReturn?loan_detail_num=${librarian.loan_detail_num }&isbncode=${librarian.isbncode}&library_code=${librarian.library_code }&page=${page } '">도서 반납</button></td>                          
									    </tr>
				                            
				                            
										</c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            
            
            
            <c:if test="${prev }">
               <span>
                  [ <a href="${contextPath }/librarian/loanlist?page=${startNum -1 }">이전</a> ]
               </span>
            </c:if>
            
            <c:forEach var="num" begin="${startNum }" end="${endNum }">
               <span>
                  <a href="${contextPath }/librarian/loanlist?page=${num }" > ${num }</a>
               </span>
            </c:forEach>
            
            <c:if test="${next }">
               <span>
                  [ <a href="${contextPath }/librarian/loanlist?page=${endNum + 1}" class="next">다음</a> ]
               </span>
            </c:if>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->
                    

            </div>                   
              <!-- End of Main Content -->

          
            <!-- Footer -->
		<%@include file="../include/manager/footer.jsp"  %>
            
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        
    	<%@include file="../include/manager/logout_modal.jsp"  %>

    </div>


    <%@include file="../include/manager/plugin.jsp"  %>

</body>

</html>