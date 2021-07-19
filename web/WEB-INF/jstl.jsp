
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Date" %>
<%--Fragment--%>
<jsp:include page="header.jsp">
    <jsp:param name="titre" value="Je suis le header"/>
</jsp:include>
    <body>
        <div name="core">
            <!--Documentation
            https://www.tutorialspoint.com/jsp/jsp_standard_tag_library.htm-->
            <p>Condition</p>
            <c:if test="${true!=true}">
                <p>C'est vrai</p>
            </c:if>

            <p>Switch</p>
            <c:choose>
                <c:when test="${'a'=='b'}">
                    a=b est faux
                </c:when>
                <c:when test="${'a'=='a'}">
                    a=a est vrai
                </c:when>
                <c:otherwise>
                    valeur si aucun cas n'est vrai
                </c:otherwise>
            </c:choose>

            <p>Boucle FOR incrémentée</p>
            <p>
                <c:forEach var="item" begin="0" end="5" step="1">
                    ${item}
                </c:forEach>
            </p>

            <p>Boucle sur liste d'élément</p>
            <p>
                <c:forEach var="item" items="${liste}">
                    ${item}
                </c:forEach>
            </p>
        </div>
        <div name="jstl">
            <c:set var="localPage" value="${pageContext.request.locale.language}_FR"/>
            <p>Internationalisation</p>
            <%--Locale forcée--%>
            <fmt:setLocale value="en_US"/>
            <fmt:setBundle basename="_50_Internalisation.i18n.index" var="usBundle"/>
            <fmt:setLocale value="en_EN"/>
            <fmt:setBundle basename="_50_Internalisation.i18n.index" var="enBundle"/>
            <fmt:message bundle="${usBundle}" key="bonjour"/>
            <fmt:message bundle="${enBundle}" key="bonjour"/>

            <%--Méthode à utiliser--%>
            <fmt:setLocale value="${locale}"/>
            <fmt:setBundle basename="_50_Internalisation.i18n.index" var="bundle"/>
            <fmt:message bundle="${bundle}" key="bonjour"/>

            <p>Format Date
                <fmt:formatDate
                    value="${Date()}"
                    dateStyle="long"
                    type="date"/>
                <fmt:formatDate
                    value="${Date()}"
                    pattern="dd.MM.yyyy"
                    type="date"/>
            </p>

            <p>Affichage d'un nombre
                <fmt:formatNumber
                        type="number"
                        value="${12/5}"
                        maxFractionDigits="2"
                        minFractionDigits="0"
                />
            </p>
        </div>
    </body>
</html>
