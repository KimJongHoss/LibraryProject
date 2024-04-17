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

    <title>사서 수정 정보 입력 양식</title>
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
                                <h1 class="h4 text-gray-900 mb-4">${librarian.name }사서 정보 수정</h1>
                            </div>
                            <form class="user">
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user"
                                            id="id" placeholder="ID" value="${librarian.id }" readonly>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user"
                                            id="name" placeholder="이름" value="${librarian.name }">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user"
                                            id="gender" placeholder="성별" value="${librarian.gender }">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="address"
                                        placeholder="주소" value="${librarian.address }">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="birth"
                                        placeholder="생일" value="${librarian.birth }">
                                </div>
                                <div class="form-group">
                                    <input type="email" class="form-control form-control-user" id="email"
                                        placeholder="이메일" value="${librarian.email}">
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user"
                                            id="phone" placeholder="연락처" value="${librarian.phone }">
                                    </div>
                                </div>
                                        <input type="hidden" class="form-control form-control-user"
                                            id="password" placeholder="비밀번호" value="${librarian.password }">
                                        <input type="hidden" class="form-control form-control-user"
                                            id="passwordCheck" placeholder="비밀번호 확인" value="${librarian.password }">
                                <a href="javascript:void(0)" class="btn btn-primary btn-user btn-block"
                                onClick="javascript:goPost()">
                                    사서 정보 수정
                                </a>
                                <hr>
                            </form>
                            <div class="text-center">
                                <a class="small" href="adminLibrarianListOne?id=${librarian.id}">${librarian.name }사서 상세 정보로 돌아가기</a>
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
    let url = contextPath + "adminLibrarianUpdate";
    
    let idValue = document.getElementById("id").value; // 아이디 입력 필드의 값 가져오기
    let passwordValue = document.getElementById("password").value; // 비밀번호 입력 필드의 값 가져오기
    let nameValue = document.getElementById("name").value; // 이름 입력 필드의 값 가져오기
    let genderValue = document.getElementById("gender").value; // 성별 입력 필드의 값 가져오기
    let addressValue = document.getElementById("address").value; // 주소 입력 필드의 값 가져오기
    let birthValue = document.getElementById("birth").value; // 생일 입력 필드의 값 가져오기
    let emailValue = document.getElementById("email").value; // 이메일 입력 필드의 값 가져오기
    let phoneValue = document.getElementById("phone").value; // 연락처 입력 필드의 값 가져오기
    let etcValue = document.getElementById("etc").value; // 비고 입력 필드의 값 가져오기
    
    let f = document.createElement('form');
    f.setAttribute('method', 'post');
    f.setAttribute('action', url);
    
    // id 데이터를 포함하는 hidden input 추가
    let idInput = document.createElement('input');
    idInput.setAttribute('type', 'hidden');
    idInput.setAttribute('name', 'id');
    idInput.setAttribute('value', idValue);
    f.appendChild(idInput);
    
    // password 데이터를 포함하는 hidden input 추가
    let passwordInput = document.createElement('input');
    passwordInput.setAttribute('type', 'hidden');
    passwordInput.setAttribute('name', 'password');
    passwordInput.setAttribute('value', passwordValue);
    f.appendChild(passwordInput);
    
    // name 데이터를 포함하는 hidden input 추가
    let nameInput = document.createElement('input');
    nameInput.setAttribute('type', 'hidden');
    nameInput.setAttribute('name', 'name');
    nameInput.setAttribute('value', nameValue);
    f.appendChild(nameInput);
    
    // gender 데이터를 포함하는 hidden input 추가
    let genderInput = document.createElement('input');
    genderInput.setAttribute('type', 'hidden');
    genderInput.setAttribute('name', 'gender');
    genderInput.setAttribute('value', genderValue);
    f.appendChild(genderInput);
    
    // address 데이터를 포함하는 hidden input 추가
    let addressInput = document.createElement('input');
    addressInput.setAttribute('type', 'hidden');
    addressInput.setAttribute('name', 'address');
    addressInput.setAttribute('value', addressValue);
    f.appendChild(addressInput);
    
    // birth 데이터를 포함하는 hidden input 추가
    let birthInput = document.createElement('input');
    birthInput.setAttribute('type', 'hidden');
    birthInput.setAttribute('name', 'birth');
    birthInput.setAttribute('value', birthValue);
    f.appendChild(birthInput);
    
    // email 데이터를 포함하는 hidden input 추가
    let emailInput = document.createElement('input');
    emailInput.setAttribute('type', 'hidden');
    emailInput.setAttribute('name', 'email');
    emailInput.setAttribute('value', emailValue);
    f.appendChild(emailInput);
    
    // phone 데이터를 포함하는 hidden input 추가
    let phoneInput = document.createElement('input');
    phoneInput.setAttribute('type', 'hidden');
    phoneInput.setAttribute('name', 'phone');
    phoneInput.setAttribute('value', phoneValue);
    f.appendChild(phoneInput);
    
    // etc 데이터를 포함하는 hidden input 추가
    let etcInput = document.createElement('input');
    etcInput.setAttribute('type', 'hidden');
    etcInput.setAttribute('name', 'etc');
    etcInput.setAttribute('value', etcValue);
    f.appendChild(etcInput);
    
    document.body.appendChild(f);
    f.submit();
}
</script>

</body>

</html>