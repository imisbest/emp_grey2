<%@ page pageEncoding="UTF-8" contentType="text/html; charset=utf-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%
    request.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE HTML>
<html>
<head>
    <title>emplist</title>
    <link rel="stylesheet" type="text/css" href="${path}/css/style.css"/>
</head>
<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">
                <p>
                    <%@ page import="java.text.SimpleDateFormat" %>
                    <%@ page import="java.util.Calendar" %>
                    <% String datetime = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()); /*//获取系统时间*/%><%=datetime%>
                    <br/> <br/>
                    <br/>
                </p>
            </div>
            <div id="topheader">
                <h1 id="title">
                    <a href="#">main</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                Welcome!
            </h1>
            <table class="table">
                <tr class="table_header">
                    <td>
                        ID
                    </td>
                    <td>
                        Name
                    </td>
                    <td>
                        Salary
                    </td>
                    <td>
                        Age
                    </td>
                    <td>
                        Birthday
                    </td>
                    <td>
                        Operation
                    </td>
                </tr>
                <c:forEach items="${empList}" var="p">
                    <tr class="row1">
                        <td>
                                ${p.id}
                        </td>
                        <td>
                                ${p.name}
                        </td>
                        <td>
                                ${p.salary}
                        </td>
                        <td>
                                ${p.age}
                        </td>
                        <td>
                            <f:formatDate value="${p.birthday}" pattern="yyyy/MM/dd"/>
                        </td>
                        <td>
                            <a href="${path}/emp/delete?id=${p.id}">delete emp</a>&nbsp;
                            <a href="${path}/emp/updateBy?id=${p.id}">update emp</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <p>
                <input type="button" class="button" value="Add Employee" onclick="location='${path}/addEmp.jsp'"/>
            </p>
            <!--分页导航开始-->
            <!-- //首页 -->
            <center style="text-decoration: none">
                <a
                        href="${path }/emp/queryAndPage?currPage=1" style="text-decoration: none">
                    <input type="button" value="首页"> &nbsp;&nbsp;&nbsp;&nbsp;
                </a>

                <!-- //上一页 -->

                <a
                        href="${path }/emp/queryAndPage?currPage=${currPage-1}" style="text-decoration: none">
                    <input type="button" value="上一页"> &nbsp;&nbsp;&nbsp;&nbsp;
                </a>

                <!-- //当前页 -->

                <%-- <c:forEach begin="1" end="${countPage}" var="i"> --%>
                <a
                        href="${path }/emp/queryAndPage?currPage=${currPage}"
                        style="text-decoration: none">当前第${currPage}/${countPage}页</a>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <%-- </c:forEach> --%>


                <!-- //下一页 -->

                <a
                        href="${path }/emp/queryAndPage?currPage=${currPage+1}" style="text-decoration: none">
                    <input type="button" value="下一页">&nbsp;&nbsp;&nbsp;&nbsp;
                </a>

                <!-- //最后一页 -->
                <a href="${path }/emp/queryAndPage?currPage=${countPage}" style="text-decoration: none">
                    <input type="button" value="尾页">&nbsp;&nbsp;&nbsp;&nbsp;
                </a>
                <!--分页导航结束-->
        </div>
    </div>
    <div id="footer">
        <div id="footer_bg">
            ABC@126.com
        </div>
    </div>
</div>
</body>
</html>
