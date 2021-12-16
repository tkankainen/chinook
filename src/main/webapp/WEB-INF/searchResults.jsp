<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Search results</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/water.css@2/out/water.min.css">
</head>
<body>
	<h1>Search results</h1>
	<form method="post">
		<input name="searchTerm" type="text" required placeholder="type here..." autofocus /> 
		<input type="submit" value="Search" />
	</form>
	
	<h2>Artists</h2>
	<c:choose>
		<c:when test="${ artists.isEmpty() }">
			No artists found
		</c:when>
		<c:otherwise>
			<ul>
				<c:forEach items="${ artists }" var="artist">
					<li>
						<a href="albums?artistId=<c:out value="${ artist.getArtistId() }" />">
						<c:out value="${ artist.getName() }" /></a>
					</li>
				</c:forEach>
			</ul>
		</c:otherwise>
	</c:choose>
	
	<h2>Albums</h2>
	<c:choose>
		<c:when test="${ albums.isEmpty() }">
			No albums found
		</c:when>
		<c:otherwise>
			<ul>
				<c:forEach items="${ albums }" var="album">
					<li>
						<a href="albums?artistId=<c:out value="${ album.getArtistId() }" />">
						<c:out value="${ album.getTitle() }" /></a>
					</li>
				</c:forEach>
			</ul>
		</c:otherwise>
	</c:choose>
	<p><a href="/artists">All artists</a></p>
</body>
</html>