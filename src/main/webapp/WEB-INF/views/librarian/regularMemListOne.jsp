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
                    <h1 class="h3 mb-1 text-gray-800">정회원 전환 신청 정보 상세 보기</h1>
                    <p class="mb-4">
                    	${regular.userid }님 정회원 전환 신청 세부 사항
                    </p>

                    <!-- Content Row -->
                    <div class="row">

                        <div class="col-lg-6">

                            <!-- 왼쪽 메뉴1 -->
                            <div class="card mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">신청 번호</h6>
                                </div>
                                <div class="card-body">
                                    ${regular.apply_code }
                                </div>
                            </div>
                            
                             <!-- 왼쪽 메뉴2 -->
                            <div class="card mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">신청 날짜</h6>
                                </div>
                                <div class="card-body">
                                   ${regular.write_date }
                                </div>
                            </div>
                            
                             <!-- 왼쪽 메뉴3 -->
                            <div class="card mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">신청자 아이디</h6>
                                </div>
                                <div class="card-body">
                                   ${regular.userid }
                                </div>
                            </div>
                            
                        </div>

                        <div class="col-lg-6">

                            <!-- 오른쪽 메뉴1 -->
                            <div class="card">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">신청 내용</h6>
                                </div>
                                <div class="card-body">
                                   ${regular.apply_reason }
                                </div>
                            </div>
                            
                            <br>
                            <!-- 오른쪽 메뉴2 -->
                            <div class="card">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">비고</h6>
                                </div>
                                <div class="card-body">
                                     ${regular.etc }
                                </div>
                            </div>
                            
                            <br>
                            <!-- 오른쪽 메뉴3 -->
                            <div class="card">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">신청자 이메일</h6>
                                </div>
                                <div class="card-body">
                                     ${regular.useremail }
                                </div>
                            </div>
                            
                        </div>
                        
                        <div class="button-container">
						    <!-- 수정 버튼 -->
						    <a href="javascript:void(0)" class="btn btn-primary btn-icon-split"
						    	onClick="javascript:goPostYes()">
						        <span class="icon text-white-50">
						            <i class="fas fa-flag"></i>
						        </span>
						        <span class="text">정회원 전환 수락</span>
						    </a>
						
						    <!-- 삭제 버튼 -->
						    <a href="javascript:void(0)" class="btn btn-danger btn-icon-split"
						    	onClick="javascript:goPostNo()">
                                   <span class="icon text-white-50">
						            <i class="fas fa-trash"></i>
						        </span>
						        <span class="text">정회원 전환 거절</span>
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
    
    <script>

// script에서 contextpath를 가져오기
sessionStorage.setItem("contextpath", "${pageContext.request.contextPath}");

// a태그를 사용해서 post로 보내고 각각 데이터를 추가해서 보내는 function(수락)
function goPostYes() {
    let contextPath = sessionStorage.getItem("contextpath");
    let url = contextPath + "/librarianRegularMemOk";
    
    let apply_codeValue = "${regular.apply_code }"; // 주소 입력 필드의 값 가져오기
    
    let f = document.createElement('form');
    f.setAttribute('method', 'post');
    f.setAttribute('action', url);
    
    //  apply_code 데이터를 포함하는 hidden input 추가
    let apply_codeInput = document.createElement('input');
    apply_codeInput.setAttribute('type', 'hidden');
    apply_codeInput.setAttribute('name', 'apply_code');
    apply_codeInput.setAttribute('value', apply_codeValue);
    f.appendChild(apply_codeInput);
    
    document.body.appendChild(f);
    f.submit();
}

//a태그를 사용해서 post로 보내고 각각 데이터를 추가해서 보내는 function(거절)
function goPostNo() {
    let contextPath = sessionStorage.getItem("contextpath");
    let url = contextPath + "/librarianRegularMemNo";
    
let apply_codeValue = "${regular.apply_code }"; // 주소 입력 필드의 값 가져오기
    
    let f = document.createElement('form');
    f.setAttribute('method', 'post');
    f.setAttribute('action', url);
    
    //  apply_code 데이터를 포함하는 hidden input 추가
    let apply_codeInput = document.createElement('input');
    apply_codeInput.setAttribute('type', 'hidden');
    apply_codeInput.setAttribute('name', 'apply_code');
    apply_codeInput.setAttribute('value', apply_codeValue);
    f.appendChild(apply_codeInput);
    
    document.body.appendChild(f);
    f.submit();
}
</script>

</body>

</html>