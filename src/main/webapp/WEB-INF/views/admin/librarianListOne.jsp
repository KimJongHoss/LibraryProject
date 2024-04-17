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
                    <h1 class="h3 mb-1 text-gray-800">사서 정보 상세 보기</h1>
                    <p class="mb-4">
                    	${librarian.name }사서님
                    </p>

                    <!-- Content Row -->
                    <div class="row">

                        <div class="col-lg-6">

                            <!-- 왼쪽 메뉴1 -->
                            <div class="card mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">사서 ID</h6>
                                </div>
                                <div class="card-body">
                                    ${librarian.id }
                                </div>
                            </div>
                            
                             <!-- 왼쪽 메뉴2 -->
                            <div class="card mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">사서 성별</h6>
                                </div>
                                <div class="card-body">
                                   ${librarian.gender }
                                </div>
                            </div>
                            
                             <!-- 왼쪽 메뉴3 -->
                            <div class="card mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">사서 생일</h6>
                                </div>
                                <div class="card-body">
                                   ${librarian.birth }
                                </div>
                            </div>
                            
                             <!-- 왼쪽 메뉴4 -->
                            <div class="card mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">사서 연락처</h6>
                                </div>
                                <div class="card-body">
                                   ${librarian.phone }
                                </div>
                            </div>


                        </div>

                        <div class="col-lg-6">

                            <!-- 오른쪽 메뉴1 -->
                            <div class="card">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">사서 비밀번호</h6>
                                </div>
                                <div class="card-body">
                                    ${librarian.password }
                                </div>
                            </div>
                            
                            <br>
                            <!-- 오른쪽 메뉴2 -->
                            <div class="card">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">사서 주소</h6>
                                </div>
                                <div class="card-body">
                                     ${librarian.address }
                                </div>
                            </div>
                            
                            <br>
                            <!-- 오른쪽 메뉴3 -->
                            <div class="card">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">사서 이메일</h6>
                                </div>
                                <div class="card-body">
                                     ${librarian.email }
                                </div>
                            </div>
                        </div>
                        <div class="button-container">
                         <%
						if(session.getAttribute("rankid") == "30") {
						%>
						    <!-- 수정 버튼 -->
						    <a href="adminLibrarianUpdate?id=${librarian.id}" class="btn btn-primary btn-icon-split">
						        <span class="icon text-white-50">
						            <i class="fas fa-flag"></i>
						        </span>
						        <span class="text">사서 정보 수정</span>
						    </a>
						
						    <!-- 삭제 버튼 -->
						    <a href="javascript:void(0)" class="btn btn-danger btn-icon-split"
						    	onClick="javascript:goPost()">
                                   <span class="icon text-white-50">
						            <i class="fas fa-trash"></i>
						        </span>
						        <span class="text">사서 정보 삭제</span>
                                </a>
                                 <%
						}
						%>
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
    
    <script>

// script에서 contextpath를 가져오기
sessionStorage.setItem("contextpath", "${pageContext.request.contextPath}");

// a태그를 사용해서 post로 보내고 각각 데이터를 추가해서 보내는 function
function goPost() {
    let contextPath = sessionStorage.getItem("contextpath");
    let url = contextPath + "/adminLibrarianDelete";
    
    let idValue = "${librarian.id}"; // 주소 입력 필드의 값 가져오기
    
    let f = document.createElement('form');
    f.setAttribute('method', 'post');
    f.setAttribute('action', url);
    
    //  id 데이터를 포함하는 hidden input 추가
    let idInput = document.createElement('input');
    idInput.setAttribute('type', 'hidden');
    idInput.setAttribute('name', 'id');
    idInput.setAttribute('value', idValue);
    f.appendChild(idInput);
    
    document.body.appendChild(f);
    f.submit();
}
</script>

</body>

</html>