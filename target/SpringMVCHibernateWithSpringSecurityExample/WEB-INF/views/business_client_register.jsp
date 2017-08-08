<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Business Client Register</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
<div style="width: 100%; height: 100px"></div>
<div class="generic-container">
    <%--
     private Client client;
    private Business business;

    businessForm
    <%@include file="authheader.jsp" %>--%>



    <div class="well lead">Business Client Register</div>
    <form:form method="POST" modelAttribute="businessForm" class="form-horizontal">

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="business.nameOfTheBusiness">Business Name</label>
                <div class="col-md-7">
                    <form:input type="text" path="business.nameOfTheBusiness" id="ssoId" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="business.nameOfTheBusiness" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="business.adress">Company Adress</label>
                <div class="col-md-7">
                    <form:input type="text" path="business.adress" id="ssoId" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="business.adress" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="business.website">WebSite</label>
                <div class="col-md-7">
                    <form:input type="text" path="business.website" id="ssoId" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="business.website" class="help-inline"/>
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

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="firstName">First Name</label>
                <div class="col-md-7">
                    <form:input type="text" path="firstName" id="firstName" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="firstName" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="lastName">Last Name</label>
                <div class="col-md-7">
                    <form:input type="text" path="lastName" id="lastName" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="lastName" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

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