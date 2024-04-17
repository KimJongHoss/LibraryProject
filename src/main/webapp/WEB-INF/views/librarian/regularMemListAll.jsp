<!-- 도서 목록 페이지 -->

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
                            <h6 class="m-0 font-weight-bold text-primary">정회원 전환 신청 목록</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                           <th>신청 번호</th>
                                           <th>신청 내용</th>
                                           <th>신청 날짜</th>
                                           <th>신청자 아이디</th>
                                           <th>신청자 이메일</th>
                                           <th>비고</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                           <th>신청 번호</th>
                                           <th>신청 내용</th>
                                           <th>신청 날짜</th>
                                           <th>신청자 아이디</th>
                                           <th>신청자 이메일</th>
                                           <th>비고</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
									    
                                        <c:forEach var="regular" items="${regular}">
									    <tr>
									        <th><a href="librarianRegularMemListOne?apply_code=${regular.apply_code}">${regular.apply_code}</a></th>
									        <th>${regular.apply_reason}</th>
									        <th>${regular.write_date}</th>
									        <th>${regular.userid}</th>
									        <th>${regular.useremail}</th>
									        <th>${regular.etc}</th>
									    </tr>
										</c:forEach>
                                    </tbody>
                                </table>
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