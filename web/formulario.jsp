<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<form action="EnviarMailConfirmacion" method="get">
	<table align="center" border="0">
		<tbody>
			<tr>
				<td align="left" width="100">Nombres:</td>
				<td align="center" width="150"><input gtbfieldid="103"
					maxlength="25" name="nombre" type="TEXT"></td>
			</tr>
			<tr>
				<td align="left" width="100">Usuario:</td>
				<td align="center" width="150"><input gtbfieldid="104"
					maxlength="25" name="usuario" type="TEXT"></td>
			</tr>
			<tr>
				<td align="left" width="100">Contraseña:</td>
				<td align="center" width="150"><input maxlength="25"
					name="contra" type="password"></td>
			</tr>
			<tr>
				<td align="left" width="100">Email:</td>
				<td align="center" width="150"><input gtbfieldid="105"
					maxlength="25" name="mail" type="TEXT"></td>
			</tr>
			<tr>
				<td widht="100"></td>
				<td align="right" width="150"><input maxlength="25"
					name="boton" value="Enviar" type="submit"></td>
			</tr>
		</tbody>
	</table>
</form>