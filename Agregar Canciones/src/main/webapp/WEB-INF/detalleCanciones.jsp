<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Detalles de la canción</h1>
	<p>Título: ${cancion.titulo}</p>
	<p>Artista: ${cancion.artista}</p>
	<p>Álbum: ${cancion.album}</p>
	<p>Género: ${cancion.genero}</p>
	<p>Idioma: ${cancion.idioma}</p>
	<div> 
		<form action="/canciones/formulario/editar/${cancion.id}" method="GET">
        <button type="submit">Editar Canción</button>
    	</form>
	</div>
	<div> 
		<form action="/canciones/eliminar/${cancion.id}" method="POST">
        <input type="hidden" name="_method" value="DELETE" />
        <button type="submit">Eliminar Canción</button>
    	</form>
	</div>
	<a href="/canciones">Volver a lista de canciones</a>
</body>
</html>