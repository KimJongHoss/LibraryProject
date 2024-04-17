<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />

<style>
    /* 이미지가 헤더에 꽉 차게 표시되도록 스타일을 지정합니다. */
    #header {
        width: 100%;
        height: auto;
        overflow: hidden;
        position: relative;
        margin: 0;
      	padding: 0;
    }
    
    #header img {
        width: 100%;
        height: auto;
        display: block;
    }

    /* 이미지를 감싸는 div 요소에 대한 스타일 */
    #header .image-wrapper {
        display: inline-block; /* 이미지를 감싸는 div 요소를 인라인 블록 요소로 설정합니다. */
        overflow: hidden; /* 내부 내용이 넘치는 경우에 대비하여 오버플로우를 숨깁니다. */
    }
</style>

<!-- header -->
<div id="header">
  		<c:if test="${rankid != 40}">
        <img src="/resources/assets/LIbrary_main_view2.png" />
        </c:if>
       	<c:if test="${rankid == 40}">
       	 <img src="/resources/assets/LIbrary_main_forBlacklist.png" />
       	</c:if>
</div>
