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

    <title>도서 추가</title>
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
        $("#isbncodealready").css("display", "none");
        $("#isbncodeok").css("display", "none");
        $("#isbncodeCheck").css("display", "none");
        $("#isbncodePossible").css("display", "none");    	
        $("#listalready").css("display", "none");
        $("#listok").css("display", "none");
        $("#listCheck").css("display", "none");
        $("#listPossible").css("display", "none");
    });
    
    function isbncodeinput(){
    	 isbncodeCheck = 0;
    	 $("#isbncodeok").css("display", "none");
    	 $("#isbncodealready").css("display", "inline-block");
    	 $("#isbncodeCheck").css("display", "block");
    	 $("#isbncodePossible").css("display", "none");
    	};
    	
    function library_codeinput(){
    	listCheck = 0;
    	 $("#listeok").css("display", "none");
    	 $("#listalready").css("display", "inline-block");
    	 $("#listCheck").css("display", "block");
    	 $("#listPossible").css("display", "none");    	
    };
    
    	//isbncode 체크여부 확인 (isbncode가 잘못된 경우 = 0 , isbncode가 사용 가능한 경우 = 1 )
        var isbncodeCheck = 0;
        $(function() {
            //isbncodeCheck 버튼을 클릭했을 때 
            $(document).on('click', '#isbncodeCheck',function() {
            //isbncode를 param.
            var isbncode =  $("#isbncode").val(); 
            console.log(isbncode);
            if (!isbncode) {
                alert("isbncode");
                return;
            }
            var url = "/librarianisbncodeCheck";
            // isbncode 값을 포함한 데이터 객체 생성
            var paramdata = {
                "isbncode": isbncode
            };
                console.log(isbncode);
                console.log(url);
                $.ajax({               
                    type : 'POST',
                    data: paramdata,
                    url : url,
                    dataType : "json",                
                    success : function(data) {
                        if (data > 0) {
                        	
                        	$("#divInputisbncode").addClass("has-success")
                            $("#divInputisbncode").removeClass("has-error")
                            $("#isbncode").focus();
                            $("#isbncodeCheck").css("display", "none");
                            $("#isbncodePossible").css("display", "block");
                            $("#isbncodealready").css("display", "none");
                            $("#isbncodeok").css("display", "inline-block");
                            //isbncode가 중복하지 않으면  idck = 1 
                            isbncodeCheck = 1;
                            console.log(data); 
                            
                            
                        } else {
                        	alert("없는 도서입니다. 도서 정보를 확인하세요.");
                            //아이디가 존제할 경우 빨강으로 , 아니면 파랑으로 처리하는 디자인
                            $("#divInputisbncode").addClass("has-error")
                            $("#divInputisbncode").removeClass("has-success")
                            $("#isbncode").focus();
                            
                        }
                    },
                    error : function(error) {
                        
                        alert("error : " + JSON.stringify(error));
                    }
                });
            });
        });
  	
    	//list 체크여부 확인 (list가 잘못된 경우 = 0 , list가 사용 가능한 경우 = 1 )
        var listCheck = 0;
        $(function() {
            //listCheck 버튼을 클릭했을 때 
            $(document).on('click', '#listCheck',function() {
            //isbncode/library_code를 param
            var isbncode =  $("#isbncode").val();
            var library_code = $('input[name="library_code"]:checked').val();
            console.log(isbncode);
            console.log(library_code);
            if (!isbncode && !library_code) {
                alert("isbncode/library_code");
                
                return;
            }
            var url = "/librarianlistCheck";
            // isbncode 값을 포함한 데이터 객체 생성
            var paramdata = {
                "isbncode": isbncode,
                "library_code" : library_code
                
            };
                console.log(isbncode);
                console.log(library_code);
                console.log(url);
                $.ajax({               
                    type : 'POST',
                    data: paramdata,
                    url : url,
                    dataType : "json",                
                    success : function(data) {
                        if (data <= 0) {                        
                            $("#isbncode").focus();
                            $("#library_code").focus();
                            $("#listCheck").css("display", "none");
                            $("#listPossible").css("display", "block");
                            $("#listalready").css("display", "none");
                            $("#listok").css("display", "inline-block");1
                            console.log(data);
                            listCheck = 1;
                            
                            
                        } else {
                        	alert("목록에 있는 도서입니다. 도서 목록을 확인하세요.");
                            //list에 존제할 경우 빨강으로 , 아니면 파랑으로 처리하는 디자인
                           console.log(data);
                            $("#divInputlibrary_code").addClass("has-error")
                            $("#divInputlibrary_code").removeClass("has-success")
                            $("#isbncode").focus();
                            $("#library_code").focus();
                            
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
                                <h1 class="h4 text-gray-900 mb-4">도서관 소장 도서 추가</h1>
                            </div>
                            <form class="book" name="bookListInsert" id="bookListInsert" role="form" action="${contextPath }/librarian/booklistinsert" method="post">
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                    <script type="text/javascript">         
                                    </script>
                                    <input type="hidden" id="page" name="page" value="${page }" >
                                        <input type="text" class="form-control form-control-user" name="isbncode" id="isbncode" placeholder="isbncode" required oninput="isbncodeinput()">
                                            <button type="button" id="isbncodeCheck"  class="btn btn-warning btn-circle">
                                        <i class="fas fa-exclamation-triangle"></i>
                                    </button>
                                    <span id="isbncodealready" oninput="isbncodeready()">도서정보에 등록된 도서인지 확인해주세요.</span>
                                    <button type="button" id="isbncodePossible" class="btn btn-success btn-circle">
                                        <i class="fas fa-check"></i>
                                    </button>
                                    <span id="isbncodeok" oninput="isbncodeready()">도서 정보에 있는 도서 입니다</span>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                    	<label for="library_code">도서관</label>
                                    	<br>
                                        <input type="radio"  id="library_code" name="library_code" value="1" oninput="library_codeinput()">어젠
                                        <input type="radio"  id="library_code" name="library_code" value="2" oninput="library_codeinput()">한빛
                                        <input type="radio"  id="library_code" name="library_code" value="3" oninput="library_codeinput()">금빛
                                        <input type="radio"  id="library_code" name="library_code" value="4" oninput="library_codeinput()">은빛
                                        <button type="button" id="listCheck" class="btn btn-warning btn-circle">
                                        	<i class="fas fa-exclamation-triangle"></i>
                                        </button>     
                                        <span id="listalready" oninput="listready()">도서목록에 등록된 도서인지 확인해주세요.</span>
                                        	<button type="button" id="listPossible" class="btn btn-success btn-circle">
                                        	<i class="fas fa-check"></i>
                                        	</button>
                                        <span id="listok" oninput="listready()">도서목록에 없는 도서입니다.</span>	                               	
                                    </div>                                    
                                    <div class="col-sm-6">
                                        <input type="number" min="1" class="form-control form-control-user" id="loan_available" name="loan_available" placeholder="보유권수">                                    	
                                    </div>                                    
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" id="etc" name="etc" placeholder="비고">                                    	
                                    </div>
                                </div>
                               
                                <button tpye="submit" class="btn btn-primary btn-user btn-block" onclick="javascript:alret()" >도서 추가</button>
                                    
                                <hr>
                            </form>
                            <div class="text-center">
                                <a class="small" href="${contextPath }/librarianBooklist?page=${page }">목록</a>
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