<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
	<title>Student Registration Form</title>
</head>

<body>
	<form:form action="processForm" modelAttribute="student">
	
	First name: <form:input path="firstName" />
	
	<br><br>
	
	Last name: <form:input path="lastName" />
	
	<br><br>
	
	<form:select path="country">
<%-- 		<form:option value="Brazil" label="Brazil"/> --%>
<%-- 		<form:option value="France" label="France"/> --%>
<%-- 		<form:option value="Germany" label="Germay"/> --%>
<%-- 		<form:option value="India" label="India"/> --%>
<form:options items="${student.countryOptions}"/>
		
	</form:select>
	
	<br><br>
	Favourite Language:
	
	Java <form:radiobutton path="favouriteLanguage" value="Java"/>
	c# <form:radiobutton path="favouriteLanguage" value="C#"/>
	PHP <form:radiobutton path="favouriteLanguage" value="PHP"/>
	Ruby <form:radiobutton path="favouriteLanguage" value="Ruby"/>
	
	<br><br>
		
	Operating Systems:
	
	Linux <form:checkbox path="operatingSystems" value="Linux"/>
	Mac <form:checkbox path="operatingSystems" value="Mac"/>
	Windows <form:checkbox path="operatingSystems" value="Windows"/>
	
	
	<input type="submit" value="Submit" />
	
	</form:form>
</body>

</html>