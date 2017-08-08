<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: OleksandrSerediuk
  Date: 14.06.2017
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        #content {
            position: absolute;
            left: 0;
            right: 0;
            top: 0;
            bottom: 0;
            margin: auto;
            width: 1200px; /* Need a specific value to work */
        }



        #active_business{
            height: 500px;
            background-size: contain;
            background-repeat:   no-repeat;
            background-position: center center;
            background-image: url("../../static/business-active.jpg")
        }

        #active_private{
            height: 500px;
            background-size: contain;
            background-repeat:   no-repeat;
            background-position: center center;
            background-image: url("../../static/private-active.jpg")
        }

        #active_business:hover{
            height: 500px;
            background-size: contain;
            background-repeat:   no-repeat;
            background-position: center center;
            background-image: url("../../static/business.jpg")
        }

        #active_private:hover{
            height: 500px;
            background-size: contain;
            background-repeat:   no-repeat;
            background-position: center center;
            background-image: url("../../static/private.jpg")
        }

        #active_private a {
            display: block;
            height:100%;
        }

        #active_business a {
            display: block;
            height:100%;
        }

    </style>
</head>
<body style="background: lightgray">
<div>
    <table id="content">
        <td><%-- <a> element inside the <div> and set it to display: block and height: 100% --%>
            <div id="active_private">
                <a href="<c:url value="/registerPrivate" />"></a>
            </div>
        </td>
        <td>
            <div id="active_business">
                <a href="<c:url value="/registerBusiness" />"></a>
            </div>
        </td>
    </table>
</div>
</body>
</html>
