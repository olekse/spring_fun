<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Car List</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body id="car_list_container">
<div style="width: 100%; height: 80px"></div>
<div class="generic-container" >
    <%@include file="authheader.jsp" %>
    <div class="panel panel-default">
        <!-- Default panel contents -->

        <%--

		Client client = clientService.findBySSO(getPrincipal());

		List<TestDrive> testDrives = testDriveService.findTestDrivesOfAClient(client);


		model.addAttribute("testDrives", testDrives);
		model.addAttribute("loggedinuser", getPrincipal());
		return "test_drive_list";

		    int id;
            Date timeStart;
            Date timeFinish;
            Car car;
            Client client;
            Payment payment;

            //car
            private int recomendedPrice;
            private int mileage;
            private int warrantyTerm;
            private CarSalon carSalon;
            private Model carModel;
            private String imageLink;
            private int id;

            int yearOfRelease,
                 int enginePowerHP,
                 String modelName,
                 boolean isOpenRoof,
                 String type,
                 double powerKw,
                 double chargeTime,
                 CarManufacturer manufacturer
		--%>


        <div class="panel-heading"><span class="lead">Your TestDrives</span></div>
        <table class="table table-hover" id="car_table">

            <tbody>
            <c:forEach items="${testDrives}" var="tdrive">
                <tr>
                    <td><img height="150px" width="150px" src="${tdrive.car.imageLink}"/></td>
                    <td>
                        <table width="100%" id="car_list_unit">
                            <tr>
                                <th>Beginning date:</th>
                                <td>${tdrive.timeStart}</td>
                            </tr>
                            <tr>
                                <th>End date:</th>
                                <td>${tdrive.timeFinish}</td>
                            </tr>
                            <tr>
                                <th>Car:</th>
                                <td>${tdrive.car.carModel.modelName}</td>
                            </tr>

                            <tr>
                                <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
                                    <td height="100px"><a href="<c:url value='/testDrives/delete-${tdrive.id}' />" class="btn btn-success">Cancel</a></td>
                                </sec:authorize>
                                <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
                                    <td height="100px"><a href="<c:url value='/'/>" class="btn btn-danger custom-width">Re-Book</a></td>
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
            <a href="<c:url value='/list' />">Return</a>
        </div>
    </sec:authorize>
</div>
</body>
</html>