<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*,javax.portlet.*"%>

<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href="/css/main.css">

<portlet:defineObjects />

<div id="smartsheet-delete-req-list"></div>

<aui:script>
	YUI().use(
	  'aui-datatable',
	  function(Y) {
	    var columns = ['ID', '대리점코드', '대리점명칭', '요청자ID', '요청자이름', '고객명', '개통번호', 
					{
						key: '접수일시',
						name: '접수일시',
					}, 
				  '접수자'];
	
	    var data = [
	    <c:forEach items="${smartsheets}" var="sheet">
	    	{ID: '${sheet.id}', 대리점코드: '${sheet.agentcode}',대리점명칭: '${sheet.agentname}', 요청자ID: '${sheet.requestorid}', 요청자이름: '${sheet.requestorname}', 고객명: '${sheet.customername}', 접수일시: '${sheet.modifieddate}', 접수자: '${sheet.user.username}'}, 
	    </c:forEach>
	    ];
	
	    new Y.DataTable.Base(
	      {
	        columnset: columns,
	        recordset: data
	      }
	    ).render('#smartsheet-delete-req-list');
	  }
	);
</aui:script>