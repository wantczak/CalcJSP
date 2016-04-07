<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  	<link rel="stylesheet" href="./style.css" TYPE="text/css">
<title>Kalkulator JSP + Servlet</title>
</head>

<body>
<jsp:useBean class="calc.Calc" id="kalkulator" scope="session"/>
<form action="" method="GET">
	<table>
		<tr>
			<!--  <td colspan=4> <jsp:getProperty property="resultText" name="kalkulator"/>	 </td> -->
			<td colspan=4> <input type="text" name ="result" value="<%=kalkulator.getResultText()%>">	 </td>
			<td> <input type="submit" name ="btn" value="C"> </td>				
		</tr>
	
		<tr>
			<td> <input type="submit" name ="btn" value="7"> </td>
			<td> <input type="submit" name ="btn" value="8"> </td>
			<td> <input type="submit" name ="btn" value="9"> </td>
			<td> <input type="submit" name ="btnParam" value="/"> </td>
			<td> <input type="submit" name ="btn" value="sqrt"> </td>
		</tr>
		
		<tr>
			<td> <input type="submit" name ="btn" value="4"> </td>
			<td> <input type="submit" name ="btn" value="5"> </td>
			<td> <input type="submit" name ="btn" value="6"> </td>
			<td> <input type="submit" name ="btnParam" value="*"> </td>
			<td> <input type="submit" name ="btn" value="%"> </td>
		</tr>
		
		<tr>
			<td> <input type="submit" name ="btn" value="1"> </td>
			<td> <input type="submit" name ="btn" value="2"> </td>
			<td> <input type="submit" name ="btn" value="3"> </td>
			<td> <input type="submit" name ="btnParam" value="-"> </td>
			<td rowspan=2> <input type="submit" name ="btnResult" value="="> </td>
		</tr>
		
		<tr>
			<td> <input type="submit" name ="btn" value="0"> </td>
			<td> <input type="submit" name ="btn" value="."> </td>
			<td> <input type="submit" name ="btn" value="+/-"> </td>
			<td> <input type="submit" name ="btnParam" value="+"> </td>
		</tr>
	</table>	
</form>

</body>
</html>