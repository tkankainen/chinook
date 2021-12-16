<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/water.css@2/out/water.min.css">
</head>
<body>
	<h1>Search artist or album</h1>
	<form method="post" action="/searchResults">
		<input name="searchTerm" type="text" required placeholder="type here..." autofocus /> 
		<input type="submit" value="Search" />
	</form>
	<p>
	<a href="/artists">All artists</a>
	</p>
</body>
</html>