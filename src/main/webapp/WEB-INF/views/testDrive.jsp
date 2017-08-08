<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Test Drive Registration Form</title>

	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="https://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css" rel="stylesheet"></link>


	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
        $( function() {
            $( "#date_picker1" ).datepicker() ;
        } );

        $( function() {
            $( "#date_picker2" ).datepicker();
        } );
	</script>
</head>

<body>
<div style="width: 100%; height: 100px"></div>
<div class="generic-container">
	<%--<%@include file="authheader.jsp" %>--%>

	<div class="well lead">Test Drive Registration Form</div>
	<form:form method="POST" modelAttribute="testDrive" class="form-horizontal">
		<form:input type="hidden" path="id" id="id"/>

<%--
		Date timeStart;
		Date timeFinish;
		Car car;
		Client client;
		Payment payment;
		--%>
		<table id="test_drive_reg_car_table">
		<tr>
			<td><img height="300px" width="300px" src="${car.imageLink}"/></td>
			<td>
				<table width="100%" id="car_list_unit">
					<tr>
						<th>Model:</th>
						<td>${car.carModel.modelName}</td>
					</tr>
					<tr>
						<th>Year:</th>
						<td>${car.carModel.yearOfRelease}</td>
					</tr>
					<tr>
						<th>Type:</th>
						<td>${car.carModel.type}</td>
					</tr>
					<tr>
						<th>Price:</th>
						<td>${car.recomendedPrice}</td>
					</tr>
					<tr>
						<th>Milage:</th>
						<td>${car.milage}</td>
					</tr>
					<tr>
						<th>Warranty:</th>
						<td>${car.warrantyTerm}</td>
					</tr>
				</table>
			</td>
		</tr>
		</table>


		<div style="margin: 20px">
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="timeStart">Start of the Test Drive</label>
					<div class="col-md-7">
						<form:input type="text" path="timeStart" id="date_picker1" placeholder="MM/DD/YYYY" class="form-control input-sm " disabled="false"/>
						<div class="has-error">
							<form:errors path="timeStart" class="help-inline"/>
						</div>
					</div>

				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="timeFinish">End of the Test Drive</label>
					<div class="col-md-7">
						<form:input type="text" path="timeFinish" id="date_picker2" placeholder="MM/DD/YYYY" class="form-control input-sm " disabled="false"/>
						<div class="has-error">
							<form:errors path="timeFinish" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>



			<div class="row">
				<div class="form-actions floatRight">
					<input type="submit" value="Create" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/' />">Cancel</a>
				</div>
			</div>
		</div>

	</form:form>
</div>
</body>
</html>