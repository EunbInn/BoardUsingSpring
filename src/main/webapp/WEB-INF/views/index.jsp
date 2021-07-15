<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link href="${path}/resources/css/index.css" rel="stylesheet"/>
<link href="${path}/resources/css/board.css" rel="stylesheet"/>
<style>
	#title {
		width: 650px;
	}
</style>
</head>
<body>
	<div id="content-wrap">
		<h1>게 시 판</h1>
		<table>
			<tr>
				<th>게시판 번호</th>
				<th id="title">제목</th>
				<th>관리</th>
			</tr>
            <c:set var="boardList" value="${boardList }" />
            <c:choose>
              <c:when test="${boardList.size()==0}">
                <tr><td colspan='3'>생성된 게시판이 없습니다</td></tr>
              </c:when>
              <c:otherwise>
                <c:forEach var="board" items="${boardList }" varStatus="status">
                  <tr>
                  <td> ${board.id }</td>
                  <td><a href="${path}/oneBoard?boardId=${board.id }&page=0">${board.title }</a></td>
                  <td><a href="${path}/update01?boardId=${board.id }">수정</a></td>
                  </tr>
                </c:forEach>
              </c:otherwise>
			</c:choose>
		</table>
		<button class="btn" onclick="location.href='${path}/newBoard'">게시판 생성</button>
	</div>
</body>
</html>