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
                            <h6 class="m-0 font-weight-bold text-primary">배송 신청 목록</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                           <th>신청 번호</th>
                                           <th>신청자 이름</th>
                                           <th>신청자 연락처</th>
                                           <th>신청자 주소</th>
                                           <th>신청 날짜</th>
                                           <th>신청 상태</th>
                                           <th>기사님께 전하고 싶은 말</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                           <th>신청 번호</th>
                                           <th>신청자 이름</th>
                                           <th>신청자 연락처</th>
                                           <th>신청자 주소</th>
                                           <th>신청 날짜</th>
                                           <th>신청 상태</th>
                                           <th>기사님께 전하고 싶은 말</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <c:forEach var="delivery" items="${delivery}">
									    <tr>
									        <th>${delivery.deliveryid}</th>
									        <th><a href="librarianDeliveryListOne?deliveryid=${delivery.deliveryid}">${delivery.username}</a></th>
									        <th>${delivery.usernumber}</th>
									        <th>${delivery.useraddress}</th>
									        <th>${delivery.day}</th>
									        <th>${delivery.status}</th>
									        <th>${delivery.messages}</th>
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