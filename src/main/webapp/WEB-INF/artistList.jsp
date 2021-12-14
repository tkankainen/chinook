<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Artists</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/water.css@2/out/water.min.css">
</head>
<body>
	<h1>All artists</h1>
	<form method="post">
		<input name="artist" type="text" required placeholder="type here..." autofocus /> 
		<input type="submit" value="Add artist" />
	</form>
	<ol>
		<c:forEach items="${ artists }" var="artist">
			<li>
				<a href="albums?artistId=<c:out value="${ artist.getArtistId() }" />">
				<c:out value="${ artist.getName() }" /></a>
			</li>
		</c:forEach>
	</ol>
</body>
</html>