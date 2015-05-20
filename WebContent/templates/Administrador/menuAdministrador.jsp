<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div class="nav-collapse">
  <ul class="nav">
    <li class="dashboard">
    	<a href="${pageContext.request.contextPath}/a_index"><span></span>Dashboard </a>
    </li>
    <s:property value="#session.objUsuarioMenus" escape="false"/> 
  </ul>
</div>