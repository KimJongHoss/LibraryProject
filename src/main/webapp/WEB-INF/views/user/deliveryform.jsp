<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="en">
<head>

<style>
		  .yesterdayfooter {
		    background-color: #2FA599;
		    padding: 80px 0px;
		    color: white;
		    text-align: center;
			}
			}
			
          .featured-text {
		    padding-right: 20px; /* 사진과 글귀 사이의 간격을 조절합니다 */
			}
			
			.project {
			    padding-left: 20px; /* 사진과 글귀 사이의 간격을 조절합니다 */
			}
		</style>

<%@ include file="../include/user/head.jsp"%>
    <link rel='stylesheet' href='/stylesheets/style.css' />
    <!-- jquery -->
    <script type="text/javascript" src="/js/jquery-1.11.3.min.js"></script>
    <script src="/javascript/popup_2.js"></script>
    <script>
        function showAlert() {
        alert("배송 신청이 완료되었습니다.\n사서에게 승인요청으로 잠시 기다려주시기 바랍니다.\n이용해주셔서감사합니다.");
    }
        function sample6_execDaumPostcode() {
            new daum.Postcode({
                oncomplete: function(data) {
                    // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                    // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                    // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                    var addr = ''; // 주소 변수
                    var extraAddr = ''; // 참고항목 변수

                    //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                    if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                        addr = data.roadAddress;
                    } else { // 사용자가 지번 주소를 선택했을 경우(J)
                        addr = data.jibunAddress;
                    }

                    // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                    if(data.userSelectedType === 'R'){
                        // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                        // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                        if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                            extraAddr += data.bname;
                        }
                        // 건물명이 있고, 공동주택일 경우 추가한다.
                        if(data.buildingName !== '' && data.apartment === 'Y'){
                            extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                        }
                        // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                        if(extraAddr !== ''){
                            extraAddr = ' (' + extraAddr + ')';
                        }
                        // 조합된 참고항목을 해당 필드에 넣는다.
                        document.getElementById("sample6_extraAddress").value = extraAddr;
                    
                    } else {
                        document.getElementById("sample6_extraAddress").value = '';
                    }

                    // 우편번호와 주소 정보를 해당 필드에 넣는다.
                    document.getElementById('sample6_postcode').value = data.zonecode;
                    document.getElementById("sample6_address").value = addr;
                    // 커서를 상세주소 필드로 이동한다.
                    document.getElementById("sample6_detailAddress").focus();
                }
            }).open();
        }
        function setAddress() {
            var postcode = document.getElementById("sample6_postcode").value;
            var address = document.getElementById("sample6_address").value;
            var detailAddress = document.getElementById("sample6_detailAddress").value;
            var extraAddress = document.getElementById("sample6_extraAddress").value;
            
            // 주소와 상세주소, 참고항목을 합쳐서 youraddress 필드에 설정합니다.
            var fullAddress = address + " " + detailAddress + " " + extraAddress;
            document.getElementById("youraddress").value = fullAddress;
        }
        var username = '<%=(String) session.getAttribute("username")%>';
        
</script>
    
 <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  <style>
    .wrong_text{font-size:1rem;color:#f44e38;letter-spacing:-.2px;font-weight:300;margin:8px 0 2px;line-height:1em;display:none}
  </style>

</head>

<body id="page-top">
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-light fixed-top"
		id="mainNav">
		<%@ include file="../include/user/topnav.jsp"%>
	</nav>


	<!-- About-->
	<section class="about-section text-center" id="about">
		<%@ include file="../include/user/about.jsp"%>
	</section>


	<!-- Projects-->
	<section class="projects-section bg-light" id="projects">
		<div class="container px-4 px-lg-5">

			<!-- 
               여기에 내용 입력 
               ----------------------------------------------------------
               -														-
               -														-
               -					Insert Content						-
               -														-
               -														-
               ----------------------------------------------------------
               -->
               	<div>
			        <h1>도서 배송 시스템</h1>
			        <p>
			            도서 배송 시스템은 온라인 서점이나 도서관 등에서 독서가들이 주문한 도서를 효율적으로 배송하는 시스템입니다.
			        </p>
			        <p>
			            이 시스템은 독서가들이 주문한 도서를 빠르고 정확하게 배송하여 독서의 편의성을 높이고, 서비스 품질을 향상시킵니다.
			        </p>
			        <p>
			            사용자는 이 시스템을 통해 주문한 도서의 배송 상태를 실시간으로 확인할 수 있으며, 배송 예상 일정을 파악하여 편리하게 이용할 수 있습니다.
			        </p>
			    </div>
			    <hr>
               <form action="deliveryform" method="post">
               <table>
                <tr>
               		<td>받으시는 분 ID</td>
               		<td><input type="text" name=etc value="${bb.etc }" readonly="readonly"></td>
               	</tr>
		        <tr>
				    <td>받으시는 분</td>
    				<td><input type="text" name="receiver" value="${bb.username}"readonly="readonly"required></td>
				</tr>
				<tr>
    				<td>받으시는 분 주소</td>
    				<td>	
					    <input type="text" id="sample6_postcode" placeholder="우편번호"required>
					    <input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"required><br>
					    <input type="text" id="sample6_address" placeholder="주소" name="useraddress"required><br>
					    <input type="text" id="sample6_detailAddress" placeholder="상세주소" name="detailjuso"required>
					    <input type="text" id="sample6_extraAddress" placeholder="참고항목" name="ckjuso"required>
					    <input type="hidden" id="youraddrees" name="useraddress">
				    </td>
				</tr>				<tr>
				    <td>받으시는 분 번호</td>
				    <td><input type="text" name="usernumber"value="${bb.usernumber}"required></td>
				</tr>
				<tr>
               		<td>기사님께(비고)</td>
               		<td><input type="text" name="messages"></input></td>
               	</tr>
               	<tr>
               		<td><input type="hidden" name="isbncode" value="${isbncode } "></td><!-- ${allBook.isbncode } -->
               	</tr>
               	<tr>
               		<td><input type="hidden" name="library_code" value="${library_code }"></td>
               	</tr>
               	<tr>
               		<td>
               			<input type="submit" onclick="showAlert()" value="배송">
               		</td>
               	</tr>
               </table>
               </form>
		</div>
	</section>

	<!-- Footer-->
	<footer class="yesterdayfooter">
		<%@ include file="../include/user/footer.jsp"%>
	</footer>

	<!-- Bootstrap core JS-->
	<%@ include file="../include/user/plug.jsp"%>

</body>
</html>
