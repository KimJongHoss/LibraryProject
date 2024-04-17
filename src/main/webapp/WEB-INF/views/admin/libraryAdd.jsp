<!-- 도서관 추가 페이지 -->

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

    <title>도서관 추가 정보 입력 양식</title>
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
                                <h1 class="h4 text-gray-900 mb-4">새로운 도서관 추가</h1>
                            </div>
                            <form class="user">
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user"
                                            id="name" placeholder="도서관 이름">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="address"
                                        placeholder="도서관 주소">
                                </div>
                                
                                <a href="javascript:void(0)" class="btn btn-primary btn-user btn-block"
                                onClick="javascript:goPost()">
                                    도서관 추가
                                </a>
                                <hr>
                            </form>
                            <div class="text-center">
                                <a class="small" href="adminLibraryListAll">도서관 목록으로 돌아가기</a>
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

// script에서 contextpath를 가져오기
sessionStorage.setItem("contextpath", "${pageContext.request.contextPath}");

// a태그를 사용해서 post로 보내고 각각 데이터를 추가해서 보내는 function
function goPost() {
    let contextPath = sessionStorage.getItem("contextpath");
    let url = contextPath + "adminLibraryAdd";
    
    let nameValue = document.getElementById("name").value; // 이름 입력 필드의 값 가져오기
    let addressValue = document.getElementById("address").value; // 주소 입력 필드의 값 가져오기
    
    let f = document.createElement('form');
    f.setAttribute('method', 'post');
    f.setAttribute('action', url);
    
    // name 데이터를 포함하는 hidden input 추가
    let nameInput = document.createElement('input');
    nameInput.setAttribute('type', 'hidden');
    nameInput.setAttribute('name', 'name');
    nameInput.setAttribute('value', nameValue);
    f.appendChild(nameInput);
    
    // address 데이터를 포함하는 hidden input 추가
    let addressInput = document.createElement('input');
    addressInput.setAttribute('type', 'hidden');
    addressInput.setAttribute('name', 'address');
    addressInput.setAttribute('value', addressValue);
    f.appendChild(addressInput);
    
    document.body.appendChild(f);
    f.submit();
}
</script>
</body>

</html>



