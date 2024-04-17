<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />



<div class="container px-4 px-lg-5">
    <a class="navbar-brand" href="/">어젠 도서관</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-bs-toggle="collapse"
        data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false"
        aria-label="Toggle navigation">
        Menu
        <i class="fas fa-bars"></i>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ms-auto">
         	<c:if test="${rankid != 40}">
            <li class="nav-item"><a class="nav-link" href="${contextPath }/book/list?page=1">도서 검색</a></li>
            <li class="nav-item dropdown"><!-- 드롭다운 메뉴를 위해 dropdown 클래스 추가 -->
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                    data-bs-toggle="dropdown" aria-expanded="false">
                    게시판 <!-- 드롭다운 메뉴 제목 -->
                </a>
                <ul class="dropdown-menu" aria-labelledby="navbarDropdown"><!-- 드롭다운 메뉴 아이템 목록 -->
                    <li><a class="dropdown-item" href="/free/list?page=1">자유 게시판</a></li>
                    <li><a class="dropdown-item" href="/notice/list?page=1">공지사항</a></li>
                    <li><a class="dropdown-item" href="/qna/list?page=1">Q&A</a></li>
                </ul>
            </li>
            <li class="nav-item"><a class="nav-link" href="${contextPath }/openBoard/readingroomListAll">열린 마당</a></li>
            <li class="nav-item"><a class="nav-link" href="${contextPath }/market/list">장바구니</a></li>
            </c:if>
            <c:if test="${userid == null}">
                <c:if test="${etc!='내가바로사서다'}">
                    <li class="nav-item"><a class="nav-link" href="${contextPath }/user/login">로그인</a></li>
                </c:if>
            </c:if>
            <c:if test="${userid != null || etc=='내가바로사서다'}">
                <li class="nav-item"><a class="nav-link" href="${contextPath }/info/auth">마이페이지</a></li>
                <li class="nav-item"><a class="nav-link" href="${contextPath }/user/logout">로그아웃</a></li>
            </c:if>
            <c:if test="${etc=='내가바로사서다'||rankid == 30}">
                <li class="nav-item"><a class="nav-link" href="${contextPath }/managerMain">관리자모드</a></li>
            </c:if>
             <c:if test="${rankid == 10}">
                <li class="nav-item"><a class="nav-link" href="${contextPath }/toRegular">정회원 전환 신청</a></li>
            </c:if>
            <c:if test="${rankid == 40}">
                <li class="nav-item"><a class="nav-link" href="${contextPath }/blacklistHelp">블랙리스트 구제 신청</a></li>
            </c:if>
            <c:if test="${rankid == 50}">
                <li class="nav-item"><a class="nav-link" href="${contextPath }/overdueHelp">연체 구제 신청</a></li>
            </c:if>
        </ul>
    </div>
</div>