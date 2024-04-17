<!-- 사서 목록 페이지 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<c:set var="contextPath" value="${contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<script src="/resources/jQuery/jquery-3.4.1.min.js" ></script>
<head>

    <%@include file="../include/manager/head.jsp"  %>
	<meta charset="utf-8">

<script type="text/javascript">

	
	function delect(){
		var isbncode =  $("#isbncode").val();			
		var url = "/bookListCheck";
		var paramdata = {
				"isbncode" : isbncode,
			};
		console.log(isbncode);
		console.log(url);
		$.ajax({
			url : url,
			type : 'POST',
			data : paramdata,
			dataType : "json",
			success : function(result) {
				if (result <= 0) {
						
					bookdelete(isbncode);
				} else {
					alert("목록에 있는 도서입니다. 목록에 있는 도서 먼저 삭제해 주세요.");
					console.log(result);
				}
					
					
					
				},
				error : function(error){
					alert("error : " + JSON.stringify(error));
				}
				
			});
	};
			
	function bookdelete(isbncode){
		var url = "/librarian/bookdelete";
		var paramdata = {
				"isbncode" : isbncode
		};
		$.ajax({
			url : url,
			type :'POST',
			data : paramdata,
			dataType : "json",
			success : function(data){
				if(data > 0){
					alert("삭제되었습니다.");
					location.reload();
				}
			},
			error : function(data){
				alert("error : " + data);
			}
		});
	};		
			
			
			
		
		
		
	
</script>
</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
       
       <%@include file="../include/manager/left_column.jsp"  %>
       
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
       <%@include file="../include/manager/header.jsp"  %>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- DataTales Example -->
                    <section class="signup-section" id="signup">
                <div class="col-md-10 col-lg-8 mx-auto text-center">
                        <i class="far fa-paper-plane fa-2x mb-2 text-white"></i>
                        <h2 class="text-white mb-5">찾는 도서명을 입력하요</h2>
                 
                        <form class="form-signup" action="${contextPath }/librarian/bookinfosearch" id="search" method="GET">
                            <!-- Book Name input-->
                            <div class="row input-group-newsletter">
                                <div class="col"><input class="form-control" name="keyword" type="text" placeholder="도서명을 입력하세요." aria-label="도서명을 입력하세요." /></div>
                                <input type="hidden" name="page" value="1">
                                <div class="col-auto"><button class="btn btn-primary" type="submit">검색</button></div>
                     		</div>
                    	</form>
                </div>
                    </section>
    
                     <hr>
                     &emsp;
                     &emsp;
                     &emsp;&emsp;&emsp;&emsp;
   
                    
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">도서 목록</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                        	<th>표지</th>
                                        	<th>ISBNCode</th>
                                        	<th>도서명</th>
                                        	<th>소개글</th>
                                        	<th>작가</th>
                                        	<th>발행일</th>                                        	
                                        	<th>비고</th>
                                        	<th>도서삭제버튼</th>
                                        	<th>도서수정버튼</th>
                                        </tr>
                                    </thead>
                                    <tbody>
									    
                                        <c:forEach var="librarian" items="${bookinfolist}">
									   	<input type="hidden" id="isbncode" value="${librarian.isbncode }" >								  
									    <tr>
									        <td><img src="${contextPath }/resources/assets/image/${librarian.image}" 
									        		onerror="this.src='${contextPath }/resources/assets/img/noimg.jpg'" 
									        		alt="100" width="200"/></td>
									        <td>${librarian.isbncode }</td>
									        <td>${librarian.book_name}</td>
									        <td>${librarian.introduction }</td>	
									        <td>${librarian.author}</td>
									        <td>${librarian.published_date}</td>
									       	<td>${librarian.etc}</td>
									       	<td><button id="delect" class="btn btn-primary" onclick="javascript:delect()">삭제</button></td>
									       	<td><button id="update" class="btn btn-primary" onclick="location.href='${contextPath }/librarian/bookupdate?isbncode=${librarian.isbncode }&page=${page}'">수정</button></td> 										     								           
									    </tr>
										</c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            
                            <!-- 도서 추가 버튼 -->
                            <a href="${contextPath }/librarian/bookinsert?page=${page }" class="btn btn-success btn-icon-split">
	                            <span class="icon text-white-50">
	                            	<i class="fas fa-check"></i>
	                            </span>
	                            <span class="text">도서 정보 추가</span>
                            </a>                       
            
            
            <c:if test="${prev }">
               <span>
                  [ <a href="${contextPath }/librarian/bookinfolist?page=${startNum -1 }">이전</a> ]
               </span>
            </c:if>
            
            <c:forEach var="num" begin="${startNum }" end="${endNum }">
               <span>
                  <a href="${contextPath }/librarian/bookinfolist?page=${num }" > ${num }</a>
               </span>
            </c:forEach>
            
            <c:if test="${next }">
               <span>
                  [ <a href="${contextPath }/librarian/bookinfolist?page=${endNum + 1}" class="next">다음</a> ]
               </span>
            </c:if>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->
                    

            </div>                   
              <!-- End of Main Content -->

          
            <!-- Footer -->
		<%@include file="../include/manager/footer.jsp"  %>
            
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        
    	<%@include file="../include/manager/logout_modal.jsp"  %>

    </div>


    <%@include file="../include/manager/plugin.jsp"  %>

</body>

</html>