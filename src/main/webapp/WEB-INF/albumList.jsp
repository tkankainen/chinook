<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Albums</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/water.css@2/out/water.min.css">
</head>
<body>
	<h1>Albums from <c:out value="${ artist.getName() }" /></h1> 
	<c:choose>
		<c:when test="${ albums.isEmpty() }">
			<p>No albums found</p>
		</c:when>
		<c:otherwise>
			<ul>
			<c:forEach items="${ albums }" var="album">
				<li>
					<c:out value="${ album.getTitle() }" />
				</li>
			</c:forEach>
			</ul>
		</c:otherwise>
	</c:choose>
	<p>
	<form method="post">
		<input name="album" type="text" required placeholder="type here..." autofocus /> 
		<input type="submit" value="Add album" />
	</form>
	<p><a href="/artists">All artists</a></p>
	<p><a href="/">Search</a></p>
</body>
</html>