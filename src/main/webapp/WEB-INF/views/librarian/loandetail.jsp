<!-- 도서 목록 페이지 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<c:set var="contextPath" value="${contextPath}"/>

<!DOCTYPE html>
<html lang="en">

	<style>
	.button-container {
			display: flex;
			flex-direction: column;
			gap: 10px; /* 버튼 사이의 여백 조절 */
		}
	</style>

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

                    <!-- Page Heading -->
                    <h1 class="h3 mb-1 text-gray-800">도서 정보 상세 보기</h1>
                    <p class="mb-4">                    
                    </p>

                    <!-- Content Row -->
                    <div class="container-fluid">

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">대출 상세</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">                       
                                    <thead>
                                        <tr>                                       		
                                        	<th>대출상세번호</th>
                                        	<th>유저아이디</th>
                                        	<th>대출일</th>
                                        	<th>반납예정일</th>
                                        	<th>반납일</th>
                                        	<th>연장 여부</th>
                                        	<th>ISBNCode</th>
                                        	<th>소장 도서관</th>
                                        	<th>책 배송</th>                                        	
                                        </tr>
                                    </thead>
                                    <tbody>                                       
									    <tr>
									        <th>${loandetail.loan_detail_num }</th>
									        <th>${loandetail.userid}</th>
									        <th>${loandetail.loan_date }</th>
									        <th>${loandetail.return_date}</th>
									        <th>${loandetail.actual_return_date}</th>									        
									        <th>${loandetail.extend}</th>
									        <th><a href="${contextPath }/librarianBookdetail?isbncode=${loandetail.isbncode }&library_code=${loandetail.library_code}&page=${page}">${loandetail.isbncode}</a></th>
									        <th>${loandetail.name }</th>
									       	<th>${loandetail.deliveryid }</th>									       								            							            
									    
									    </tr>
										
                                    </tbody>
                                </table>
                            </div>
                            <button class="btn btn-primary" onclick="location.href='${contextPath }/librarianLoanlist?page=${page}'">목록</boutton>
                        </div>
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