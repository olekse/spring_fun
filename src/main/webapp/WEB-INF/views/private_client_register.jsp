<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Private Client Register</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
<div style="width: 100%; height: 100px"></div>
<div class="generic-container">
    <%--
    private Client client;
    private Person person;


    //client
    protected String firstName;
    protected String middleName;
    protected String lastName;
    protected Date dateOfBirth;

    protected Gender gender;
    protected Passport passport;

    privateForm
    <%@include file="authheader.jsp" %>


    --%>



    <div class="well lead">Private Client Register</div>
    <form:form method="POST" modelAttribute="privateForm" class="form-horizontal">


        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="person.firstName">First Name</label>
                <div class="col-md-7">
                    <form:input type="text" path="person.firstName" id="ssoId" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="person.firstName" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="person.lastName">Surname</label>
                <div class="col-md-7">
                    <form:input type="text" path="person.lastName" id="ssoId" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="person.lastName" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>



        <%--

    protected String nameOfTheBusiness;
    protected String adress;
    protected String postCode;
    protected int primaryPhoneNumber;
    protected int secondaryPhoneNumber;
    protected String website;
    protected BusinessType businessType;

  --%>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="client.ssoId">Login</label>
                <div class="col-md-7">
                    <form:input type="text" path="client.ssoId" id="ssoId" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="client.ssoId" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="client.email">Email</label>
                <div class="col-md-7">
                    <form:input type="text" path="client.email" id="email" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="client.email" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="client.password">Password</label>
                <div class="col-md-7">
                    <form:input type="password" path="client.password" id="password" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="client.password" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>


        <div class="row" >
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="client.userProfiles">Roles</label>
                <div class="col-md-7">
                    <form:select path="client.userProfiles" items="${roles}" multiple="true" itemValue="id" itemLabel="type" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="client.userProfiles" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>




        <div class="row">
            <div class="form-actions floatRight">
                <c:choose>
                    <c:when test="${edit}">
                        <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list' />">Cancel</a>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list' />">Cancel</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>