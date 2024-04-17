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

<script>
var userid = '<%=(String) session.getAttribute("userid")%>';
var username = '<%=(String) session.getAttribute("username")%>';

function showAlert() {
    var selectedLibrary = document.querySelector('input[name="library_code"]:checked');
    if (selectedLibrary) {
        var libraryCode = selectedLibrary.value;
        var libraryName = document.querySelector('input[name="library_code"][value="' + libraryCode + '"] + label').textContent;

        alert("선택하신 도서관은 "
            + libraryName
            + "도서관 입니다.\n현재 사서의 승인요청으로 잠시 기다려 주시기 바랍니다.\n이용해주셔서 감사합니다.");
    } else {
        alert("도서관을 선택해주세요.");
        event.preventDefault();
    }
}

</script>
<%@ include file="../include/user/head.jsp"%>
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
			        <h1>도서관 상호대차 시스템</h1>
			        <p>
			            도서관 상호대차 시스템은 독서가들이 서로 도서를 교환하고 공유하는 플랫폼입니다.
			        </p>
			        <p>
			            사용자는 이 시스템을 통해 자신의 도서를 등록하고, 다른 사용자의 도서를 검색하여 대여할 수 있습니다.
			        </p>
			        <p>
			            이를 통해 독서가들은 다양한 도서를 접하고, 자신이 가진 도서를 다른 이용자들과 공유할 수 있습니다.
			        </p>
			    </div>
               <hr>
	<form action="inter" method="post">
    <h2>도서관 선택</h2>
    <table>
        <thead>
            <tr>
                <th style="padding-right: 20px;">도서관 이름</th>
                <th style="padding-right: 20px;">도서관 주소</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="library" items="${library}" varStatus="status" begin="0">
            <!-- FOR문 -->
            <tr>
                <c:if test="${library.library_code ne library_code}">
                    <td>
                        <input type="radio" name="library_code" value="${library.library_code}">
                        <label>${library.name}</label>
                    </td>
                    <td>
                        <label>${library.address}</label>
                    </td>
                </c:if>
            </tr>
        </c:forEach>    
        </tbody>
    </table>
    <input type="hidden" name="isbncode" value="${isbncode }">
    <div>
        <input type="submit" onclick="showAlert()" value="신청"></input>
    </div>
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
