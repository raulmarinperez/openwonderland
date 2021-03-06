<%-- 
    Document   : snapshots
    Created on : Jan 4, 2009, 11:33:13 AM
    Author     : jkaplan
--%>

<%@page contentType="text/html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c" %>
<%@ taglib uri="/WEB-INF/tlds/fmt.tld" prefix="fmt" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link href="/wonderland-web-front/css/base.css" rel="stylesheet" type="text/css" media="screen" />
        <link href="/wonderland-web-front/css/module.css" rel="stylesheet" type="text/css" media="screen" />
        <title>Manage Worlds</title>
    </head>
    <body>
        <h2>Manage Worlds</h2>

        <c:set var="currentRoot" value="${requestScope['currentroot']}"/>

        <table class="installed" id="currentSnapshot">
            <caption>
                <span class="heading">Current Snapshot</span>
            </caption>
             <c:forEach var="r" items="${requestScope['roots']}">
                 <c:choose>
                     <c:when test="${currentroot == r}">
                        <tr class="header">
                            <td class="installed">World Name</td>
                            <td class="installed">Path</td>                            
                            <td class="installed">Actions</td>
                        </tr>
                        <tr>
                            <td>${currentroot.name}</td>                                                                       
                            <td>${currentroot.rootPath}</td>
                            <td>Current <a href="?action=restore&root=worlds/${currentroot.name}">restore</a></td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <c:forEach var="s" items="${requestScope['snapshots']}">
                <c:choose>
                    <c:when test="${currentroot == s}">
                        <tr class="header">
                            <td class="installed">Name</td>
                            <td class="installed">Date</td>
                            <td class="installed">Description</td>
                            <td class="installed">Actions</td>
                        </tr>
                        <tr>
                            <td>${currentroot.name}</td>
                            <td><fmt:formatDate value="${currentroot.timestamp}" type="both"/></td>
                            <td>${currentRoot.description}</td>
                            <td>Current <a href="?action=restore&root=snapshots/${currentroot.name}">restore</a>
                                        <a href="?action=edit&root=snapshots/${currentroot.name}">edit</a>
                                        <a href="?action=remove&root=snapshots/${currentroot.name}">remove</a>
                            </td>
                        </tr>                                                                                                
                    </c:when>
                    <c:otherwise>
                    </c:otherwise>
                </c:choose>                
            </c:forEach>
        </table>
        <a href="?action=snapshot">Create snapshot</a> 
        <br/><br/>
        
        
        <table class="installed" id="runnerTable">
            <caption>
              <span class="heading">Initial Worlds</span>
            </caption>
            <tr class="header">
                <td class="installed">World Name</td>
                <td class="installed">Path</td>
                <td class="installed">Actions</td>
            </tr>
            <c:forEach var="root" items="${requestScope['roots']}">
                <tr>
                    <td class="installed">${root.name}</td>
                    <td class="installed">${root.rootPath}</td>
                    <td class="installed">
                        <c:choose>
                            <c:when test="${currentroot == root}">
                                Current <a href="?action=restore&root=worlds/${root.name}">restore</a>
                            </c:when>
                            <c:otherwise>
                                <a href="?action=current&root=worlds/${root.name}">make current</a>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <br>

        <table class="installed" id="runnerTable">
            <caption>
              <span class="heading">Snapshots</span>
            </caption>
            <tr class="header">
                <td class="installed">Name</td>
                <td class="installed">Date</td>
                <td class="installed">Description</td>
                <td class="installed">Actions</td>
            </tr>
            <c:forEach var="snapshot" items="${requestScope['snapshots']}">
                <tr>
                    <td class="installed">${snapshot.name}</td>
                    <td class="installed"><fmt:formatDate value="${snapshot.timestamp}" type="both"/></td>
                    <td class="installed">${snapshot.description}</td>
                    <td class="installed">
                        <c:choose>
                            <c:when test="${currentroot == snapshot}">
                                Current <a href="?action=restore&root=snapshots/${snapshot.name}">restore</a>
                            </c:when>
                            <c:otherwise>
                                <a href="?action=current&root=snapshots/${snapshot.name}">make current</a>
                            </c:otherwise>
                        </c:choose>
                        <a href="?action=edit&root=snapshots/${snapshot.name}">edit</a>
                        <a href="?action=remove&root=snapshots/${snapshot.name}">remove</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div id="actionLinks">
            <a href="?action=snapshot">Create snapshot</a>
        </div>
    </body>
</html>
