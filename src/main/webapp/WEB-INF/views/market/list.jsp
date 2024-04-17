<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
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

</head>


<html lang="en">
    <head>
    <link href="/resources/css/infolist.css" rel="stylesheet">
    <script src="/resources/jQuery/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
    
function cartdelete(){
	var cnt = $("input[name=marketid]:checked").length;
	var arr = new Array();
	$("input[name='marketid']:checked").each(function(){
		arr.push($(this).attr('id'));
	});
	if(cnt === 0){
		alert('선택한 리스트가 없습니다.');
	} 
	else {
	$.ajax({
		async : true,
		url : "/market/delete",
		type : 'POST',
		data : "marketid=" + arr + "&CNT=" + cnt,
		dataType : 'json',
		success : function(data){
			if(data > 0){
				window.location.href = "/market/list";
			} else {
				alert('데이터 베이스 오류');
				return false;
			}
		}, error : function(error){
			alert("error" + JSON.stringify(error));
		}
		});
	}
}

function cart__bigorderbtn_right(){
	var cnt = $("input[name=marketid]:checked").length;
	var isbncode = new Array();
	var marketid = new Array();
	
	$("input[name='marketid']:checked").each(function(){
		marketid.push($(this).attr('id'));
		isbncode.push($(this).val());
	});
	if(cnt === 0){
		alert('선택한 리스트가 없습니다.');
	} else {
		window.location.href = "/market/loan?isbncode=" + isbncode + "&marketid=" + marketid + "&cnt=" + cnt + "&userid=" + ${userid};
	}
}

$(function(){
	$(".cart__list__optionbtn_all").click(function(){
		if($(".cart__list__optionbtn_all").is(":checked")){
			$("input[name=marketid]").prop("checked", true);
		} else {
			$("input[name=marketid]").prop("checked", false);
		}
	});
		
		$("input[name=marketid]").click(function(){
			var total = $("input[name=marketid]").length;
			var check = $("input[name=marketid]:checked").length;
			if(total != check){
				$(".cart__list__optionbtn_all").prop("checked", false);
			} else {
				$(".cart__list__optionbtn_all").prop("checked", true);
			}
		});
});

    </script>
    <%@ include file="../include/user/head.jsp" %>
    </head>
    
    
    <body id="page-top">
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
		    <%@ include file="../include/user/topnav.jsp" %>
        </nav>
        
        
        <!-- About-->
        <section class="about-section text-center" id="about">
		    <%@ include file="../include/user/about.jsp" %>
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
                   <section class="cart">
        <div class="cart__information">
            <ul>
                <li>장바구니 상품은 최대 30일간 저장됩니다.</li>
                <li>가격, 옵션 등 정보가 변경된 경우 주문이 불가할 수 있습니다.</li>
                <li>오늘출발 상품은 판매자 설정 시점에 따라 오늘출발 여부가 변경될 수 있으니 주문 시 꼭 다시 확인해 주시기 바랍니다.</li>
            </ul>
        </div>
            <form action="/market/loan" id="frm" name="frm" method="POST">
        <table class="cart__list">
                <thead>
                    <tr>
                        <td><input type="checkbox" class="cart__list__optionbtn_all"></td>
                        <td></td>
                        <td>도서명</td>
                        <td>책소개</td>
                        <td>발행일</td>
                        <td>발행자</td>
                    </tr>
                </thead>
                <c:forEach var="book" items="${list }">
                <tbody>
                    <tr class="cart__list__detail">
                        <td><input type="checkbox" value="${book.isbncode }" id="${book.marketid }" name="marketid" class="cart__list__optionbtn"></td>
                        <td width="110px;"><a><img src="/resources/assets/image/${book.image }" alt="magic keyboard"></a></td>
                        <td><a href="/book/detail?isbncode=${book.isbncode }&library_code=1&page=1">${book.book_name }</a><span class="cart__list__smartstore"></span>
                        </td>
                        <td class="cart__list__option">
                            <p >${book.introduction }</p>
                            <button class="cart__list__optionbtn">주문조건 추가/변경</button>
                        </td>
                        <td><span class="price">${book.published_date }</span><br>
                            <button class="cart__list__orderbtn">대출하기</button>
                        </td>
                        <td>${book.author }</td>
                    </tr>
                </tbody>
                </c:forEach>
                <tfoot>
                    <tr>
                        <td colspan="3"><button id="cart__list__optionbtn_delete" type="button" onclick="cartdelete()" class="cart__list__optionbtn_delete">선택상품 삭제</button>
                        </td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                </tfoot>
        </table>
        <div class="cart__mainbtns">
            <a href="/book/list?page=1"><button type="button" class="cart__bigorderbtn left">책 고르기</button></a>
            <c:if test="${rankid != 50}">
            <button type="button" onclick="cart__bigorderbtn_right()" class="cart__bigorderbtn right">대출 하기</button>
            </c:if>
        </div>
            </form>
    </section>

           
               
               
               
               
            </div>
        </section>
        
        
       
        <!-- Footer-->
        <footer class="yesterdayfooter">
		    <%@ include file="../include/user/footer.jsp" %>
		</footer>
        
        <!-- Bootstrap core JS-->
		    <%@ include file="../include/user/plug.jsp" %>
        
    </body>
</html>
