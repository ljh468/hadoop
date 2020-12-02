<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>난 1초마다 URL를 호출하여 로그를 생성하는 JSP 페이지이다.</title>

<script src="/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
   
   var logCnt = 0; //로그 찍은 획수 저장을 위한 변수
   
   // JSP 페이지가 완전히 로딩완료(</html> 태그까지 실행완료) 되면 1번만 자동실행함
   $(window).on("load", function(){
      
      // 화면 로딩이 완료되면 첫번째로 실행함
      doRequestURL();
      
      // 2번째부터 채팅방 전체리스트를 1초마다 로딩함
      // 컴퓨터는 밀리세컨드(10-3제곱) 단위로 처리하기 때문에 1000 => 1초를 의미함
      setInterval("doRequestURL();", 1000);      
      
      
  $(".test").on('click', function(){
	  alert("안녕하세요");
  });
  
  
  $("#test2").keyup(function(){
	  alert("안녕하세요2");
  });
  
      
      
   });
   
   
   
   // URL 호출하기
   function doRequestURL() {
      
      logCnt++; // 로그 호출수 1씩 증가
      
      // Ajax 호출
      $.ajax({
         url : "/log/result.jsp?logCnt="+ logCnt,
         type : "get",
         dataType : "JSON",
         contentType : "application/json; charset=UTF-8",
         // 프로토콜 번호 200번 받으면 ( 전송 성공 )
         success : function(json) {
            $("#LogView").html("My Create logMessage : " + json.logMessage);
         }
      })
   }
      
</script>   
</head>
<body>
   <hr />
   <br />
   <h2>난 1초마다 URL를 호출하여 로그를 생성하는 JSP 페이지이다.</h2>
   <br />
   <hr />
   <div id="LogView">[결과 표시]</div>
   <button class="test">눌러봐</button>
   <input type="text" id="test2"></input>
   
</body>
</html>