<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Car List</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>

	<style type="text/css">
		.my_content_container a {
			border-bottom: 1px solid #777777;
			border-left: 1px solid #000000;
			border-right: 1px solid #333333;
			border-top: 1px solid #000000;
			color: #000000;
			display: block;
			height: 2.5em;
			padding: 0 1em;
			width: 5em;
			text-decoration: none;
		}

	</style>


</head>

<body id="car_list_container">
<div style="width: 100%; height: 80px"></div>
	<div class="generic-container" >
		<%@include file="authheader.jsp" %>	
		<div class="panel panel-default">
			  <!-- Default panel contents -->

			<div class="panel-heading"><span class="lead">Search</span></div>

			<table class="table table-hover" id="car_search_table">
				<thead>
				<tr id="search_header_tr">
						<form:form modelAttribute="searchForm" action="/list" method="get" >
							<div  id="search_bar_span_container">
								<span>
									<form:select  path="color">
										<form:option value="ANY"> --Select Colors--</form:option>
										<form:options items="${colors}"></form:options>
									</form:select>
								</span>
								<span>
									<form:select  path="type">
										<form:option value="ANY"> --Select Type--</form:option>
										<form:options items="${types}"></form:options>
									</form:select>
								</span>
								<span>
									<form:input placeholder="Milage From" path="mileage_min"/>
								</span>
								<span>
									<form:input placeholder="Milage To" path="mileage_max"/>
								</span>
								<span>
									<input type="submit" value="Search" class="btn btn-primary btn-sm"/>
								</span>
								<span>
									<a href="<c:url value="/testDrives" />" type="submit" value="Search" class="btn btn-primary btn-sm">All Test Drives</a>
								</span>
							</div>
							<%--
							    private String mileage_min;
								private String mileage_max;
							--%>


						</form:form>
				</tr>
				</thead>
			</table>

		  	<div class="panel-heading"></div>
			<table class="table table-hover" id="car_table">
	    		<thead>
		      		<tr>
						<th>Car</th>
				        <th>Characteristics</th>
				        <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
				        	<th width="100"></th>
				        </sec:authorize>
				        <sec:authorize access="hasRole('ADMIN')">
				        	<th width="100"></th>
				        </sec:authorize>
				        
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${cars}" var="car">
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

								<tr>
									<sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
										<td height="100px"><a href="<c:url value='/test-drive-${car.id}' />" class="btn btn-success">Test Drive</a></td>
									</sec:authorize>
									<sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
										<td height="100px"><a href="<c:url value='/order-${car.id}' />" class="btn btn-danger custom-width">Order</a></td>
									</sec:authorize>
									<%--
									<sec:authorize access="hasRole('ADMIN')">
										<td height="50px"><a href="<c:url value='/order-${car.id}' />" class="btn btn-danger custom-width">Order</a></td>
									</sec:authorize>
									--%>
								</tr>

							</table>
						</td>
					</tr>
				</c:forEach>
	    		</tbody>
	    	</table>
		</div>
		<sec:authorize access="hasRole('ADMIN')">
		 	<div class="well">
		 		<a href="<c:url value='/logout' />">Return</a>
		 	</div>
	 	</sec:authorize>
   	</div>
</body>
</html>