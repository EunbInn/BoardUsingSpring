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
        <select name="keyType" id="keyType">
          <option value="title">제목</option>
          <option value="writer">작성자</option>
          <option value="title+writer">제목+작성자</option>
        </select> <input id="value" name="value" type="text" maxlength="30"
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
      <c:set var="boardItemList" value="${boardItems.getContent() }" />
      <c:set var="boardItemSize"
        value="${boardItems.getTotalElements() }" />
      <c:choose>
        <c:when test="${boardItemSize == 0 }">
          <tr>
            <td colspan='4'>작성된 게시글이 없습니다</td>
          </tr>
        </c:when>
        <c:otherwise>
          <c:forEach var="boardItem" items="${boardItemList }"
            varStatus="status">
            <tr>
              <td>${boardItemSize - (status.count - 1)}</td>
              <td><a
                href="${path}/oneView/${board.id}/${boardItem.id}">${boardItem.title }</a></td>
              <td>${boardItem.writer }</td>
              <td>${boardItem.date }</td>
            </tr>
          </c:forEach>
        </c:otherwise>
      </c:choose>
    </table>
    <button class="btn"
      onclick="location.href='${path }/write/write01/${board.id }'">글쓰기</button>
    <!-- paging block -->
    <div id="paging-box">
      <ul class="pagination justify-content-center">
        <!-- 이전 -->
        <c:choose>
          <c:when test="${ulist.first}"></c:when>
          <c:otherwise>
            <li class="page-item"><a class="page-link"
              href="/admin/userlist/?field=${param.field}&word=${param.word}&page=0">처음</a></li>
            <li class="page-item"><a class="page-link"
              href="/admin/userlist/?field=${param.field}&word=${param.word}&page=${ulist.number-1}">&larr;</a></li>
          </c:otherwise>
        </c:choose>

        <!-- 페이지 그룹 -->
        <c:forEach begin="${startBlockPage}" end="${endBlockPage}"
          var="i">
          <c:choose>
            <c:when test="${ulist.pageable.pageNumber+1 == i}">
              <li class="page-item disabled"><a class="page-link"
                href="/admin/userlist/?field=${param.field}&word=${param.word}&page=${i-1}">${i}</a></li>
            </c:when>
            <c:otherwise>
              <li class="page-item"><a class="page-link"
                href="/admin/userlist/?field=${param.field}&word=${param.word}&page=${i-1}">${i}</a></li>
            </c:otherwise>
          </c:choose>
        </c:forEach>

        <!-- 다음 -->
        <c:choose>
          <c:when test="${ulist.last}"></c:when>
          <c:otherwise>
            <li class="page-item "><a class="page-link"
              href="/admin/userlist/?field=${param.field}&word=${param.word}&page=${ulist.number+1}">&rarr;</a></li>
            <li class="page-item "><a class="page-link"
              href="/admin/userlist/?field=${param.field}&word=${param.word}&page=${ulist.totalPages-1}">마지막</a></li>
          </c:otherwise>
        </c:choose>
      </ul>

    </div>
  </div>
</body>
</html>