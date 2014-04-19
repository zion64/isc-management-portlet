<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*,javax.portlet.*"%>

<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href="/css/main.css">

<portlet:defineObjects />

<div id="isc-container">
	<div id="isc-header">이게 머지?</div>
	<div id="myCarousel"></div>
	<div id="smartsheet-delete-req-list"><div id="myRating"></div>
</div>

<aui:script>
	YUI().use(
	  'aui-rating',
	  function(Y) {
	    new Y.ThumbRating(
	      {
	        boundingBox: '#myRating'
	      }
	    ).render();
	  }
	);	
	YUI().use(
	  'aui-datatable',
	  function(Y) {
	    var columns = ['ID', '대리점코드', '대리점명칭', '요청자ID', '요청자이름', '고객명', '개통번호', '접수일시', '접수자'];
	
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

	YUI().use(
	  'aui-carousel',
	  function(Y) {
	    new Y.Carousel(
	      {
	        contentBox: '#myCarousel',
	      }
	    ).render();
	  }
	);
	
	YUI().use(
	  'aui-form-builder',
	  function(Y) {
	    new Y.FormBuilder(
	      {
	        availableFields: [
	          {
	            iconClass: 'form-builder-field-icon-text',
	            id: 'uniqueTextField',
	            label: 'Text',
	            readOnlyAttributes: ['name'],
	            type: 'text',
	            unique: true,
	            width: 75
	          },
	          {
	            hiddenAttributes: ['tip'],
	            iconClass: 'form-builder-field-icon-textarea',
	            label: 'Textarea',
	            type: 'textarea'
	          },
	          {
	            iconClass: 'form-builder-field-icon-checkbox',
	            label: 'Checkbox',
	            type: 'checkbox'
	          },
	          {
	            iconClass: 'form-builder-field-icon-button',
	            label: 'Button',
	            type: 'button'
	          },
	          {
	            iconClass: 'form-builder-field-icon-select',
	            label: 'Select',
	            type: 'select'
	          },
	          {
	            iconClass: 'form-builder-field-icon-radio',
	            label: 'Radio Buttons',
	            type: 'radio'
	          },
	          {
	            iconClass: 'form-builder-field-icon-fileupload',
	            label: 'File Upload',
	            type: 'fileupload'
	          },
	          {
	            iconClass: 'form-builder-field-icon-fieldset',
	            label: 'Fieldset',
	            type: 'fieldset'
	          }
	        ],
	        boundingBox: '#myFormBuilder',
	        fields: [
	          {
	            label: 'City',
	            options: [
	              {
	                label: 'Ney York',
	                value: 'new york'
	              },
	              {
	                label: 'Chicago',
	                value: 'chicago'
	              }
	            ],
	            predefinedValue: 'chicago',
	            type: 'select'
	          },
	          {
	            label: 'Colors',
	            options: [
	              {
	                label: 'Red',
	                value: 'red'
	              },
	              {
	                label: 'Green',
	                value: 'green'
	              },
	              {
	                label: 'Blue',
	                value: 'blue'
	              }
	            ],
	            type: 'radio'
	          }
	        ]
	      }
	    ).render();
	  }
	);

</aui:script>