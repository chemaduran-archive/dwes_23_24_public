<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Rellenar la matrícula</title>
    <jsp:include page="bootstrap.jsp"></jsp:include>
</head>
<body>
<jsp:include page="barra.jsp"></jsp:include>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-6">
            <form method="post">
                <label class="form-label" for="nombre">Nombre:</label>
                <input class="form-control" type="text" name="nombre" id="nombre" required/>
                <label class="form-label mt-3" for="apellidos">Apellidos:</label>
                <input class="form-control" type="text" name="apellidos" id="apellidos" required/>
                <label class="form-label mt-3" for="email">Email:</label>
                <input class="form-control mb-3" name="email" type="email" id="email" required/>
                <label>
                    Primer curso:
                        <input class="form-check-input" type="radio" name="curso" value="primero" checked required/>
                </label>
                <label class="form-check-label" for="curso">1º DAW</label>
                <input class="form-check-input" type="radio" name="curso" id="curso"  value="segundo" required/>
                <label class="form-check-label" for="curso">2º DAW</label>
                <select name="modulos" class="form-select mt-3" multiple required>
                    <option>Lenguaje de Marcas</option>
                    <option>Base de Datos</option>
                    <option>Programación</option>
                    <option>Entornos de Desarrollo</option>
                    <option>Sistemas</option>
                    <option>FOL</option>
                    <option>Empresa</option>
                    <option>Servidor</option>
                    <option>Cliente</option>
                    <option>Despliegue</option>
                    <option>Diseño</option>
                </select>
                <input class="btn btn-primary w-100 mt-3" type="submit" value="MATRICULAR"/>
            </form>
        </div>
    </div>
</div>

</body>
</html>