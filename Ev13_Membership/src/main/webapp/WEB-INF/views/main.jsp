<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
    
    <!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>Document</title>
		<link rel="stylesheet" href="/style/style.css">
		<style>
		
		</style>
	</head>
	<body>
		<div id="wrap">
		<h1></h1>
		<hr>
<div id="goodsListArea">

			<div class="columnArea headerArea dFlex">
				<span>번호</span> 
				<span>아이디</span> 
				<span>회원이름</span> 
				<span>나이</span> 
				<span>가입시간</span>
				<span>삭제</span>

			</div>

				<c:forEach var="goods" items="${memberList}">
			<div class="columnArea rowArea dFlex">
					<span>${goods.num}</span>
					<span>${goods.userID}</span>
					<span>${goods.userID}</span>
					<span>${goods.userAge}</span>
					<fmt:formatDate var="tm" value="${goods.joinTM}" 
								pattern="yyyy-MM-dd" />
						<span>${tm}</span>
					<form action="/delete" method="post">
						<input type="hidden" name="userID" value="${goods.userID}">
						<button type="submit">탈퇴</button>
						
					</form>
						
					
			</div>
				</c:forEach>
				
			<form action="/search" method="post" >
				<div id="serchID">ID 조회 
					<input type="text" name="searchID">
					<button type="submit" >제출</button>
				</div>
			</form>
					
		</div>

	</div>
		<!-- div#wrap -->
		<script src="/script/jquery-3.6.4.min.js"></script>
        <script src="/script/script.js"></script>	
	</body>
</html>
   
 