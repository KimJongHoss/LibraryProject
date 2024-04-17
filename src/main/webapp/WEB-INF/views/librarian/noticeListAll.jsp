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
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">공지사항 목록</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                           <th>공지사항 번호</th>
                                           <th>제목</th>
                                           <th>작성자</th>
                                           <th>내용</th>
                                           <th>작성일</th>
                                           <th>조회수</th>
                                           <th>비고</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                           <th>공지사항 번호</th>
                                           <th>제목</th>
                                           <th>작성자</th>
                                           <th>내용</th>
                                           <th>작성일</th>
                                           <th>조회수</th>
                                           <th>비고</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
									    
                                        <c:forEach var="notice" items="${list}">
									    <tr>
									        <th>${notice.notice_num}</th>
									        <th><a href="librarianNoticeListOne?notice_num=${notice.notice_num}">${notice.title}</a></th>
									        <th>${notice.writer}</th>
									        <th>${notice.content}</th>
									        <th>${notice.regdate}</th>
									        <th>${notice.count}</th>
									        <th>${notice.etc}</th>
									    </tr>
										</c:forEach>
                                    </tbody>
                                </table>
                            </div>
                             <!-- 공지사항 작성 버튼 -->
                            <a href="librarianNoticeAdd" class="btn btn-success btn-icon-split">
	                            <span class="icon text-white-50">
	                            	<i class="fas fa-check"></i>
	                            </span>
	                            <span class="text">공지사항 추가</span>
                            </a>
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