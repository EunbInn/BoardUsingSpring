<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${path}/resources/css/index.css" rel="stylesheet" />
<link href="${path}/resources/css/board.css" rel="stylesheet" />
<link href="${path}/resources/css/oneBoard.css" rel="stylesheet" />
<script
  src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
  <div id="content-wrap">
    <a href="${path }/" id="back-index">&lt;&lt;게시판 목록</a>
    <h1>${board.title }</h1>
    <div id="find-box">
      <form method="POST">
        <select name="findType">
          <option value="title">제목</option>
          <option value="writer">작성자</option>
          <option value="title+writer">제목+작성자</option>
        </select> <input id="find" name="find" type="text" maxlength="30"
          placeholder="검색어 입력"> <input type="submit" id="submit"
          formaction="./oneBoard/${board.id }" value="검색">
      </form>
    </div>
    <table>
      <tr>
        <th>번호</th>
        <th id="title">제목</th>
        <th>작성자</th>
        <th>작성 일자</th>
      </tr>
      <c:set var="boardItems" value="${boardItems }" />
      <c:choose>
        <c:when test="${boardItems.size() == 0 }">
          <tr>
            <td colspan='4'>작성된 게시글이 없습니다</td>
          </tr>
        </c:when>
        <c:otherwise>
          <c:forEach var="boardItem" items="${boardItems }" varStatus="status">
            <tr>
              <td>${boardItems.size()-(status.count-1)}</td>
              <td><a href="${path}/oneView/${board.id}/${boardItem.id}">${boardItem.title }</a></td>
              <td>${boardItem.writer }</td>
              <td>${boardItem.date }</td>
            </tr>
          </c:forEach>
        </c:otherwise>
      </c:choose>
    </table>
    <button class="btn"
      onclick="location.href='${path }/write/write01/${board.id }'">글쓰기</button>
  </div>
</body>
</html>