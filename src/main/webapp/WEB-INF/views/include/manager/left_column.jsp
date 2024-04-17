<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>    

<c:set var="contextPath" value="${contextPath}" />

       <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="${pageContext.request.contextPath}/managerMain">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">어젠 도서관 <br>관리 페이지</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" href="${contextPath}/librarianBooklist?page=1">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>도서 관리</span></a>
            </li>
            
            <li class="nav-item active">
                <a class="nav-link" href="${contextPath}/librarianLoanlist?page=1">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>대출 목록 및 반납</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                사서 권한 메뉴
            </div>

            <!-- 회원 관리 메뉴 -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwoMembers"
                    aria-expanded="true" aria-controls="collapseTwoMembers">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>회원 관리</span>
                </a>
                <div id="collapseTwoMembers" class="collapse" aria-labelledby="headingTwoMembers" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">세부사항:</h6>
                        <a class="collapse-item" href="${contextPath}/librarianRegularMemListAll">정회원 전환 신청</a>
                        <a class="collapse-item" href="${contextPath}/librarianSaveOverdueListAll">연체 구제 신청</a>
                        <a class="collapse-item" href="${contextPath}/librarianBlacklistListAll">블랙리스트 구제 신청</a>
                    </div>
                </div>
            </li>
            
            <!-- 게시판 관리 메뉴 -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwoBoards"
                    aria-expanded="true" aria-controls="collapseTwoBoards">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>게시판 관리</span>
                </a>
                <div id="collapseTwoBoards" class="collapse" aria-labelledby="headingTwoBoards" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">세부사항:</h6>
                        <a class="collapse-item" href="${pageContext.request.contextPath}/librarianQnaListAll">Q&A 게시판</a>
                        <a class="collapse-item" href="${pageContext.request.contextPath}/librarianNoticeListAll">공지사항</a>
                    </div>
                </div>
            </li>

            <!-- 서비스 관리 -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseServices"
                    aria-expanded="true" aria-controls="collapseServices">
                    <i class="fas fa-fw fa-wrench"></i>
                    <span>서비스 관리</span>
                </a>
                <div id="collapseServices" class="collapse" aria-labelledby="headingServices"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">세부 사항:</h6>
                        <a class="collapse-item" href="${contextPath}/librarianInterlibListAll">상호대차 신청 관리</a>
                        <a class="collapse-item" href="${contextPath}/librarianDeliveryListAll">배송 신청 관리</a>
                    </div>
                </div>
            </li>
            
            <!-- 예약 관리 -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseReserves"
                    aria-expanded="true" aria-controls="collapseReserves">
                    <i class="fas fa-fw fa-wrench"></i>
                    <span>예약 관리</span>
                </a>
                <div id="collapseReserves" class="collapse" aria-labelledby="headingReserves"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">세부 사항:</h6>
                        <a class="collapse-item" href="${contextPath}/librarianReadingRoomListAll">열람실 관리</a>
                    </div>
                </div>
            </li>
         
            <!-- Heading --> 
            <%
			if(session.getAttribute("rankid") != null && (int)session.getAttribute("rankid") == 30) {
			%>
			<div class="sidebar-heading">
			    관리자 권한 메뉴
			</div>
			
			<!-- 시설 관리 메뉴 -->
			<li class="nav-item">
			    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsefacilities"
			        aria-expanded="true" aria-controls="collapsefacilities">
			        <i class="fas fa-fw fa-folder"></i>
			        <span>시설 관리</span>
			    </a>
			    <div id="collapsefacilities" class="collapse" aria-labelledby="headingfacilities" data-parent="#accordionSidebar">
			        <div class="bg-white py-2 collapse-inner rounded">
			            <h6 class="collapse-header">세부 사항:</h6>
			            <a class="collapse-item" href="<%=request.getContextPath()%>/adminLibraryListAll">도서관 관리</a>
			        </div>
			    </div>
			</li>
			
			<!-- 인원 관리 메뉴 -->
			<li class="nav-item">
			    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapselibrarians"
			        aria-expanded="true" aria-controls="collapselibrarians">
			        <i class="fas fa-fw fa-folder"></i>
			        <span>인원 관리</span>
			    </a>
			    <div id="collapselibrarians" class="collapse" aria-labelledby="headinglibrarians" data-parent="#accordionSidebar">
			        <div class="bg-white py-2 collapse-inner rounded">
			            <h6 class="collapse-header">세부 사항:</h6>
			            <a class="collapse-item" href="<%=request.getContextPath()%>/adminLibrarianListAll">사서 관리</a>
			        </div>
			    </div>
			</li>
			<%
			}
			%>
            <!-- Nav Item - Charts -->
            <li class="nav-item">
                <a class="nav-link" href="underConstruction">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>Charts</span></a>
            </li>

            <!-- Nav Item - Tables -->
            <li class="nav-item">
                <a class="nav-link" href="underConstruction">
                    <i class="fas fa-fw fa-table"></i>
                    <span>Tables</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

        </ul>