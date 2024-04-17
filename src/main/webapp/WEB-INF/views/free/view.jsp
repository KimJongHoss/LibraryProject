<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
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
    
    <%@ include file="../include/user/head.jsp" %>
    <script src = "/resources/jQuery/jquery-3.4.1.min.js" ></script>     
    <script>
    //ajax를 통한 댓글(쓰기)
    $(document).ready(function(){
       console.log("ajax Test");
       
       //댓글 목록 불러오는 ajax 함수 작성
       replylist();
       
        //댓글 저장버튼 클릭이벤트 (댓글쓰기)
          
        //$('#btnReplySave').click(fuction(){
        //$('#btnReplySave').on('click',function(){
             
          $(document).on('click','#btnReplySave', function(){ 
             var content = $("#content").val(); // $()=> 문서 객체를 생성함
             var writer = $("#writer").val();
             
             var url = "${pageContext.request.contextPath}/free/reply"; //아작스 쓰기
             var paramData = {
                   "writer" : writer,
                   "content" : content,
                   "free_board_num" : '${freeDTO.free_board_num}'
             }; // 추가데이터
             
             $.ajax({
                type: "POST",
                url: url,
                data : paramData,
                dataType : 'json',
                success:function(result){ // result<=>data <=> log
                   replylist();
                  
                   $("#content").val('') ;
                   $("#writer").val('');
                },

                error : function(data){
                   console.log(data);
                   alert("에러가 발생햇습니다.");
                }
             });         
             
          });
       
       
       
    });//end of $(document).ready()
     // 댓글 목록 불러오기 : ajax
	function replylist(){
		var url = "${pageContext.request.contextPath}/free/replylist";
		var paramData = {
				"free_board_num" : "${freeDTO.free_board_num}"
		}
		$.ajax({
			url : url,          // 주소 : 매핑주소
			data : paramData,   // 요청데이터
			dataType : 'json',  // 데이터타입
			type : 'POST',      // 전송방식
			success : function(result){
				var htmls = "";
                if(result.length < 1){
                   htmls = htmls + "<h3>등록된 댓글이 없습니다.</h3>";
                }
                else{
                   $(result).each(function(){
                      htmls = htmls + '<div class="" id="comment_num' +this.comment_num + '">';
                                       //<div id="reno12"> <div id="reno13">
                      htmls += '<span class="d-block">';
                      htmls += this.comment_num + ' - ';
                     htmls += '<strong class="text-gray-dark">' + this.writer + '</strong>';
                      htmls += '<span style="padding-left: 7px; font-size: 9pt">';
                      htmls += '<a href="javascript:void(0)" onclick="replyupdateForm(' + this.comment_num + ', \'' + this.writer + '\', \''  + this.content + '\' )" style="padding-right:5px">수정</a>';
                      htmls += '<a href="javascript:void(0)" onclick="replyDelete(' + this.comment_num + ')" >삭제</a>';
                      htmls += '</span>';
                      htmls += '</span><br>';
                      htmls += this.content;
                      htmls += '</p>';
                      htmls += '</div>';   
                   });  // each End
                }
                $("#replylist").html(htmls);
                console.log("성공");
				
			},
			error : function(data){
				alert("에러가 발생했어요." + data);
			}
		});		
	}// end of replylist()

	
	//댓글수정하기(form)
	function replyupdateForm(comment_num, writer, content){
		var htmls = "";
		htmls = htmls + '<div class="" id="comment_num' +comment_num + '">';
		htmls += '<span class="d-block">';
		htmls += comment_num + ' - ';
		htmls += '<strong class="text-gray-dark">' + writer + '</strong>';
		htmls += '<span style="padding-left: 7px; font-size: 9pt">';
		htmls += '<a href="javascript:void(0)" onclick="replyupdate(' + comment_num + ', \'' + writer + '\', \'' + content + '\' )" style="padding-right:5px">저장</a>';
		htmls += '<a href="javascript:void(0)" onclick="replylist()" >취소</a>';
		htmls += '</span>';
		htmls += '</span><br>';
		htmls += '<textarea name="editmemo" id="editmemo" class="form-control" rows="3">'
		htmls += content;
		htmls += '</textarea>'
		htmls += '</p>';
		htmls += '</div>'; 
		// 선택한 요소를 다른것으로 변경합니다.
		$('#comment_num'+comment_num).replaceWith(htmls);
		$('#comment_num'+comment_num+'#editmemo').focus();
		
	} // end of fn_editReply()
	
	function replyupdate(comment_num,writer,content){
		var editmemo = $('#editmemo').val();	
		var url = "/free/replyupdate";
		var paramData = {
				"comment_num" : comment_num,
				"writer" : writer,
				"content" : editmemo
		};//수정데이터
		
		$.ajax({
	         url : url,
	         data : paramData,
	         dataType : 'json',
	         type : 'POST',
	         success : function(result){
	            replylist(); //댓글목록 호출
	         },
	         error : function(data){
	            alert("에러가 발생했습니다.");
	         }
	      });
		
	}// end of fn_updateReply()
	//삭제
	function replyDelete(comment_num){
		var editmemo = $('#editmemo').val();	
		var url = "/free/replyDelete";
		var paramData = {
				"comment_num" : comment_num,
				
		};
		
		$.ajax({
	         url : url,
	         data : paramData,
	         dataType : 'json',
	         type : 'POST',
	         success : function(result){
	            replylist(); //댓글목록 호출
	         },
	         error : function(data){
	            alert("에러가 발생했습니다.");
	         }
	      });
		
	}
		
	</script>
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
		  
		  <section class="content">
		<div>
			<h2>상세보기</h2>
			<table class="table">
			<tr>
				<td style="border-right: 1px solid #D5D5D5;"> 작성자 </td><td>${freeDTO.writer }</td>
			<tr>
			<tr>
				<td style="border-right: 1px solid #D5D5D5;"> 제목 </td><td>${freeDTO.title }</td>
			</tr>
			<tr style="height: 300px;">
				<td style="width: 100px; border-right: 1px solid #D5D5D5;"> 내용 </td><td>${freeDTO.content }</td>
			<tr>
            </table>
            
            <c:if test="${userid != null}">
            <c:if test="${userid == freeDTO.writer}">
			<a href="${contextPath }/free/update?free_board_num=${freeDTO.free_board_num}&writer=${freeDTO.writer }" role="button" class="btn btn-dark btn-sm">수정</a>
			<a href="${contextPath }/free/delete?bno=${freeDTO.free_board_num}" role="button" class="btn btn-dark btn-sm">삭제</a>			
            </c:if>
            </c:if>
            <a href="/free/list?page=1" class="btn btn-dark btn-sm">목록</a>
            </div>
            </section>
            
		<div class="box-footer">
			<div class="box-body">
         <table>
         <tr>
         <td rowspan="10" width="100%">
         <input class="form-control" name="content" id="content" placeholder="댓글을 입력하세요"></input>
         <input class="form-control" name="writer" id="writer" placeholder="작성자" />
         </td>
         </tr>
         <tr>
            <td><button type="button" id="btnReplySave">저장</button></td>
         </tr>
      </table>
       
         </div>
         <hr><p></p>
         <div id="replylist"></div>
         
		</div>
		
         </div>
        </section>
        
       
        <!-- Footer-->
        <footer class="yesterfooter">
		    <%@ include file="../include/user/footer.jsp" %>
		</footer>
        
        <!-- Bootstrap core JS-->
		    <%@ include file="../include/user/plug.jsp" %>
        
    </body>
</html>
