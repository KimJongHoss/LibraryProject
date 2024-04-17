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

    <title>도서 수정 정보 입력</title>
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
                                <h1 class="h4 text-gray-900 mb-4">${update.book_name } 정보 수정</h1>
                            </div>
                            <form class="user" action="${contextPath }/librarian/bookupdate" method="POST">  
                                <input type="hidden" id="page" name="page" value="${page }">
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">ISBNCode
                                        <input type="text" class="form-control form-control-user" id="isbncode" name="isbncode" value="${update.isbncode }" readonly>
                                    </div>
                                </div>
                                <div class="form-group row">도서명
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="book_name" name="book_name" value="${update.book_name }">
                                    </div>
                                </div>
                                <div class="form-group row">소개글
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="introduction" name="introduction" value="${update.introduction }">
                                    </div>
                                </div>
                                <div class="form-group">발행일
                                    <input type="number" class="form-control form-control-user" id="published_date" name="published_date" value="${update.published_date }">
                                </div>
                                <div class="form-group">작가
                                    <input type="text" class="form-control form-control-user" id="author" name="author" value="${update.author }">
                                </div>
                                <div class="form-group">표지
                                    <input type="file" class="form-control form-control-user" id="image" name="image" accept=".jpg" value="c:\fakepath\kmg\project\library2\src\main\webapp\resources\assets\image\${update.image }">
                                </div>
                                <div class="form-group">비고
                                    <input type="text" class="form-control form-control-user" id="etc" name="etc" value="${update.etc }">
                                </div>
                                                                     
                                <button type="submit" class="btn btn-primary btn-user btn-block" onclick="javascript:alret()" >정보 수정</button>                                    
                                <hr>
                            </form>
                            <div class="text-center">
                                <a class="small" href="${contextPath }/librarian/bookdetail?isbncode=${update.isbncode }&page=${page}">${update.book_name }도서 상세 정보</a>
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
        }else {
           alert("성공적으로 도서 추가하셨습니다.");
           this.submit();
        }
     }
    }

</script>

</body>

</html>