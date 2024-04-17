<!-- 사서 추가 페이지 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<c:set var="contextPath" value="${contextPath}"/>



<!DOCTYPE html>
<html lang="en">
<script src="/resources/jQuery/jquery-3.4.1.min.js" ></script>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>사서 추가 정보 입력 양식</title>
    <link rel="icon" type="image/x-icon" href="${contextPath }/resources/assets/favicon_manager.png" />

    <!-- Custom fonts for this template-->
    <link href="${contextPath }/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${contextPath }/resources/css/sb-admin-2.min.css" rel="stylesheet">
    
    <script type="text/javascript">
    sessionStorage.setItem("contextpath", "${pageContext.request.contextPath}");
    
    //시작했을때 각각 요소들이 안보이게 하는 함수
    $(function(){
        $("#idalready").css("display", "none");
        $("#idok").css("display", "none");
        $("#idCheck").css("display", "none");
        $("#idPossible").css("display", "none");
        $("#passwordok").css("display", "none");
    });
    
    var pwck = 0;		 
    function passwordcheck(){
    	if($("#password").val() == $("#passwordCheck").val()){
    		$("#passwordok").css("display", "none");
    		pwck = 1;
    	} else {
    		$("#passwordok").css("display", "inline-block");
    		pwck = 0;
    	}
    }
    
    function idinput(){
    	 idCheck = 0;
    	 $("#idok").css("display", "none");
    	 $("#idalready").css("display", "inline-block");
    	 $("#idCheck").css("display", "block");
    	 $("#idPossible").css("display", "none");
    	};
    
  	//아이디 체크여부 확인 (아이디가 잘못된 경우 = 0 , 아이디가 사용 가능한 경우 = 1 )
    var idCheck = 0;
    $(function() {
        //idCheck 버튼을 클릭했을 때 
        $("#idCheck").click(function() {
        //id 를 param.
        var id =  $("#id").val(); 
        console.log(id);
        if (!id) {
            alert("아이디를 입력해주세요.");
            return;
        }
        
        // 아이디 값을 포함한 데이터 객체 생성
        var data = {
            "id": id
        };
        
        let contextPath = sessionStorage.getItem("contextpath");
        let url = contextPath + "/librarianIdCheck";
            console.log(id);
            console.log(url);
            $.ajax({
                async: true,
                type : 'POST',
                data: {"id" : id},
                url : url,
                dataType : "json",
                //contentType: "application/json; charset=UTF-8",
                success : function(data) {
                    if (data > 0) {
                        
                        alert("존재하는 아이디입니다. 다른 아이디를 입력해주세요.");
                        //아이디가 존제할 경우 빨강으로 , 아니면 파랑으로 처리하는 디자인
                        $("#divInputId").addClass("has-error")
                        $("#divInputId").removeClass("has-success")
                        $("#id").focus();
                        
                    } else if(data === -1) {
                        alert("사용 불가능한 아이디 입니다");
                    } else {
                        alert("사용가능한 아이디입니다.");
                        //아이디가 존제할 경우 빨강으로 , 아니면 파랑으로 처리하는 디자인
                        $("#divInputId").addClass("has-success")
                        $("#divInputId").removeClass("has-error")
                        $("#id").focus();
                        $("#idCheck").css("display", "none");
                        $("#idPossible").css("display", "block");
                        $("#idalready").css("display", "none");
                        $("#idok").css("display", "inline-block");
                        //아이디가 중복하지 않으면  idck = 1 
                        idCheck = 1;
                        
                    }
                },
                error : function(error) {
                    
                    alert("error : " + JSON.stringify(error));
                }
            });
        });
    });
  	
    </script>

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
                                <h1 class="h4 text-gray-900 mb-4">새로운 사서 추가</h1>
                            </div>
                            <form class="user" name="frm" id="frm">
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                    <script type="text/javascript">
                                    console.log(idCheck);
                                    </script>
                                    	<label>아이디</label>
                                        <input type="text" class="form-control form-control-user"
                                        	name="id" id="id" placeholder="ID" required oninput="idinput()">
                                            <button type="button" id="idCheck"  class="btn btn-warning btn-circle">
                                        <i class="fas fa-exclamation-triangle"></i>
                                    </button>
                                    <span id="idalready" oninput="idready()">중복 확인해주세요</span>
                                            <button type="button" id="idPossible" class="btn btn-success btn-circle">
                                        <i class="fas fa-check"></i>
                                    </button>
                                    <span id="idok" oninput="idready()">아이디 사용 가능</span>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                    <label>비밀번호</label>
                                        <input type="password" class="form-control form-control-user"
                                            id="password" name="password" placeholder="비밀번호"
                                            required oninput="passwordcheck()">
                                    </div>
                                    <div class="col-sm-6">
                                    <label>비밀번호 확인  </label>
                                        <input type="password" class="form-control form-control-user"
                                            id="passwordCheck" name="passwordCheck" 
                                            placeholder="비밀번호 확인" required oninput="passwordcheck()">
                                    	<span id="passwordok">비밀번호 확인해주세요</span>
                                    </div>
                                </div>
                                <br>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                    <label>이름</label>
                                        <input type="text" class="form-control form-control-user"
                                            id="name" placeholder="이름" required>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                    	<label for="gender">성별</label><br>
                                        <input type="radio" value="남자" name="gender" id="gender">남성
                                        <input type="radio" value="여자" name="gender" id="gender">여성
                                    </div>
                                </div>
                                <div class="form-group">
                                	<label>주소</label>
                                    <input type="text" class="form-control form-control-user" id="address"
                                        placeholder="주소">
                                </div>
                                <div class="form-group">
                                	<label>생년월일</label>
                                    <input type="date" class="form-control form-control-user" id="birth"
                                        name="birth" placeholder="생일">
                                </div>
                                 <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                    <input type="text" class="form-control form-control-user" id="emailId"
                                        placeholder="이메일 아이디" name="emailId" placeholder="이메일">
                                </div>
                                <div class="col-sm-6">
					              <select class="custom-select d-block w-100" id="emailAddress" name="emailAddress">
					                <option value="" disabled="disabled">이메일 선택</option>
					                <option>@naver.com</option>
					                <option>@gmail.com</option>
					              </select>
                                </div>
					            </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                    	<label>연락처</label>
                                        <input type="text" class="form-control form-control-user"
                                            id="phone" placeholder="연락처">
                                    </div>
                                </div>
                                                                <a href="javascript:void(0)" class="btn btn-primary btn-user btn-block"
                                onClick="javascript:goPost()">
                                    사서 추가
                                </a>
                                <hr>
                            </form>
                            <div class="text-center">
                                <a class="small" href="adminLibrarianListAll">사서 목록으로 돌아가기</a>
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
    let url = contextPath + "adminLibrarianAdd";
    
    let idValue = document.getElementById("id").value; // 아이디 입력 필드의 값 가져오기
    let passwordValue = document.getElementById("password").value; // 비밀번호 입력 필드의 값 가져오기
    let nameValue = document.getElementById("name").value; // 이름 입력 필드의 값 가져오기
    let genderValue = document.getElementById("gender").value; // 성별 입력 필드의 값 가져오기
    let addressValue = document.getElementById("address").value; // 주소 입력 필드의 값 가져오기
    let birthValue = document.getElementById("birth").value; // 생일 입력 필드의 값 가져오기
    let emailIdValue = document.getElementById("emailId").value; // 이메일 아이디 입력 필드의 값 가져오기
    let emailAddressValue = document.getElementById("emailAddress").value; // 이메일 주소 입력 필드의 값 가져오기
    let emailValue = emailIdValue + emailAddressValue; //이메일 전체 값으로 합치기
    let phoneValue = document.getElementById("phone").value; // 연락처 입력 필드의 값 가져오기
    
//	이름이 없으면 사서 추가 못하도록
    if (!nameValue.trim()) {
        alert("이름을 입력해주세요.");
        return;
    }
    
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
    
    document.body.appendChild(f);
    if(confirm("사서 추가 하시겠습니까")){
        if(idCheck == 0){
           alert("아이디 중복체크를 해주세요");
           return false;
        }else if(pwck == 0) {
            alert("비밀번호 중복 확인을 해주세요");
     	   return false;
        }else {
           alert("성공적으로 사서 추가하셨습니다.");
           f.submit();
        }
     }
    
}
</script>

</body>

</html>