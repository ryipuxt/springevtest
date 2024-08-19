<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp"%>

<div class="container p-5">

	<table class="table table-striped">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성자</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="board" items="${PostList}">
				<tr>
					<td>${board.id}</td>
					<td>${board.title}</td>
					<td>${board.content}</td>
					<td>${board.author}</td>
					<td>
						<div class="d-flex">
							<form action="/board/${board.id}/delete" method="post">
								<button class="btn btn-danger">삭제</button>
							</form>
							<form action="/board/${board.id}/updateForm" method="get">
								<button class="btn btn-warning">수정</button>
							</form>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="d-flex justify-content-center">
		<ul class="pagination">
			<!-- Previous Page Link -->
			<li class="page-item  <c:if test='${currentPage == 1}'>disabled</c:if>"><a class="page-link" href="?type=${type}&page=${currentPage - 1}&size=${size}">Previous</a></li>

			<!-- Page Numbers -->
			<!-- [Previous]  1 2 3 4 5 6 7 8   [Next] -->
			<c:forEach begin="1" end="${totalPages}" var="page">
				<li class="page-item  <c:if test='${page == currentPage}'>active </c:if>"><a class="page-link" href="?type=${type}&page=${page}&size=${size}">${page}</a></li>
			</c:forEach>

			<!-- Next Page Link  -->
			<li class="page-item <c:if test='${currentPage == totalPages}'>disabled</c:if>"><a class="page-link" href="?type=${type}&page=${currentPage + 1}&size=${size}">Next</a></li>
		</ul>

	</div>


</div>

<%@ include file="layout/footer.jsp"%>

</body>
</html>
