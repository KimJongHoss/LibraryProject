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
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">사서 목록</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                       		<th>번호</th>
                                        	<th>사서 ID</th>
                                        	<th>사서 이름</th>
                                        	<th>사서 성별</th>
                                        	<th>사서 주소</th>
                                        	<th>사서 생일</th>
                                        	<th>사서 이메일</th>
                                        	<th>사서 연락처</th>
                                        </tr>
                                    </thead>
                                    <tbody>
									    
                                        <c:forEach var="librarian" items="${librarian}">
                                        <c:set var="i" value="${i+1 }"/>
									    <tr>
									    	<th>${i} </th>
									        <th>${librarian.id} </th>
									        <th><a href="adminLibrarianListOne?id=${librarian.id}">${librarian.name}</a></th>
									        <th>${librarian.gender} </th>
									        <th>${librarian.address} </th>
									        <th>${librarian.birth} </th>
									        <th>${librarian.email} </th>
									        <th>${librarian.phone} </th>
									    </tr>
										</c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            
                            <!-- 사서 추가 버튼 -->
                            <a href="adminLibrarianAdd" class="btn btn-success btn-icon-split">
	                            <span class="icon text-white-50">
	                            	<i class="fas fa-check"></i>
	                            </span>
	                            <span class="text">사서 추가</span>
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