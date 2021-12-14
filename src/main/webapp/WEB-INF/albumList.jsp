<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Albums</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/water.css@2/out/water.min.css">
</head>
<body>
	<h1>Albums from </h1> 
	<ul>
		<c:forEach items="${ albums }" var="album">
			<li>
				<c:out value="${ album.getTitle() }"></c:out>
			</li>
		</c:forEach>
	</ul>
</body>
</html>