<!-- 사서 추가 페이지 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<c:set var="contextPath" value="${contextPath}"/>



<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>도서관 소장 도서 수정</title>
    <link rel="icon" type="image/x-icon" href="${contextPath }/resources/assets/favicon_manager.png" />

    <!-- Custom fonts for this template-->
    <link href="${contextPath }/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${contextPath }/resources/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

    <div class="container">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">도서관 소장 도서 정보 수정</h1>
                            </div>
                            <form class="user" action="${contextPath }/librarian/booklistupdate" method="POST">
                                <input type="hidden" name="page" value="${page }">
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        도서목록번호<input type="text" class="form-control form-control-user" id="book_list_num" name="book_list_num" value="${listupdate.book_list_num }" readonly>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        ISBNCode<input type="text" class="form-control form-control-user" id="isbncode" name="isbncode" value="${listupdate.isbncode }" readonly>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">                                       
                                    	<label for="library_code">도서관</label>
                                    	<br>
                                        <input type="radio" id="library_code1" name="library_code" value="1">어젠
                                        <input type="radio" id="library_code2" name="library_code" value="2">한빛
                                        <input type="radio" id="library_code3" name="library_code" value="3">금빛
                                        <input type="radio" id="library_code4" name="library_code" value="4">은빛
                                    </div>
                                </div>
                                <div class="form-group">
                                    보유권수<input type="number" class="form-control form-control-user" id="loan_available" name="loan_available" value="${listupdate.loan_available }">
                                </div>
                                <div class="form-group">
                                    대출권수<input type="text" class="form-control form-control-user" id="loan_status" name="loan_status" value="${listupdate.loan_status }">
                                </div>
                                <div class="form-group">
                                    비고<input type="text" class="form-control form-control-user" id="etc" name="etc" value="${listupdate.etc }">
                                </div>
                                                                     
                                <button type="submit" class="btn btn-primary btn-user btn-block" onclick="javascript:alret()">정보 수정</button>                                    
                                <hr>
                            </form>
                            <div class="text-center">
                                <a class="small" href="${contextPath }/librarianBookdetail?isbncode=${listupdate.isbncode}&page=${page}&library_code=${library_code}">${listupdate.book_name }도서 상세 정보</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="${contextPath }/resources/vendor/jquery/jquery.min.js"></script>
    <script src="${contextPath }/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="${contextPath }/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="${contextPath }/resources/js/sb-admin-2.min.js"></script>

<script>

    function alret(){
    	if(confirm("도서 추가 하시겠습니까")){
            if(isbncodeCheck == 0){
               alert("ISBNCode 중복체크를 해주세요");
               event.preventDefault(); 
               return false;                	
            } else if(listCheck == 0){
            	alert("도서목록 중복체크를 해주세요.");
            	event.preventDefault(); 
            	return false;      
            } else if($.trim($("#loan_available").val())=='' || $.trim($("#loan_available").val()) <= 0){
            	alert("보유권수를 확인해주세요.");
            	event.preventDefault(); 
            	return false;
            }else {
               alert("성공적으로 도서 추가하셨습니다.");
               this.submit();
        }
     }
    }

</script>

</body>

</html>