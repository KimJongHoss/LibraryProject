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
                            <h6 class="m-0 font-weight-bold text-primary">도서 상세</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
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
                                        	<th>보유권수</th>
                                        	<th>대출권수</th>
                                        	<th>도서 비고</th>
                                        </tr>
                                    </thead>
                                    <tbody>                                       
									    <tr>
									        <td><img src="${contextPath }/resources/assets/image/${book.image}" 
									        		onerror="this.src='${contextPath }/resources/assets/img/noimg.jpg'" 
									        		alt="200" width="300"/></td>
									        <td>${book.book_name}</td>
									        <td>${book.isbncode }</td>
									        <td>${book.author}</td>
									        <td>${book.published_date}</td>									        
									        <td>${book.introduction}</td>
									        <td>${book.name}</td>
									        <td>${book.loan_available }</td>
									       	<td>${book.loan_status }</td>									       
									        <td>${book.etc}</td>								            							            
									    
									    </tr>
										
                                    </tbody>
                                </table>
                            </div>
                            <button class="btn btn-primary" onclick="location.href='${contextPath }/librarianBooklist?page=${page}'">목록</boutton>
                        </div>
                    </div>

                </div>
     
                        
                        <div class="button-container">							
						    	<button class="btn btn-primary" onclick="location.href='${contextPath }/librarian/booklistupdate?isbncode=${book.isbncode }&library_code=${book.library_code }&page=${page}'">도서 목록 수정</button>														
						    	<button class="btn btn-primary" onclick="location.href='${contextPath }/librarian/booklistdelete?book_list_num=${book.book_list_num }&page=${page}'">도서 목록 삭제</button>
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