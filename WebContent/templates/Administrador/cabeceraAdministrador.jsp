<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div class="pull-right">
  <ul class="nav navbar-nav pull-right">       
    <li class="dropdown settings hidden-xs"><a class="dropdown-toggle" data-toggle="dropdown" href="widgets.html#"><span>Settings</span></a>
      <ul class="dropdown-menu">
        <li><a class="settings-link blue" href="javascript:chooseStyle('none', 30)"><span></span> Blue </a></li>
        <li><a class="settings-link green" href="javascript:chooseStyle('green-theme', 30)"><span></span> Green </a></li>
        <li><a class="settings-link orange" href="javascript:chooseStyle('orange-theme', 30)"><span></span> Orange </a></li>
        <li><a class="settings-link magenta" href="javascript:chooseStyle('magenta-theme', 30)"><span></span> Magenta </a></li>
        <li><a class="settings-link gray" href="javascript:chooseStyle('gray-theme', 30)"><span></span> Gray </a></li>
      </ul>
    </li>
    <li class="dropdown user hidden-xs">
    	<a class="dropdown-toggle" data-toggle="dropdown" href="widgets.html#">
      		<img alt="Avatar male" height="34" src="verImagenEmpleado?idCodigo=<s:property value="#session.objEmp.idEmpleado"/>" width="34"/>
      		<s:property value="#session.objEmp.nombre"/><b class="caret"></b>
    	</a>
      	<ul class="dropdown-menu">
        	<li><a href="#"><i class="icon-user"></i> My Account </a></li>
        	<li><a href="#"><i class="icon-gear"></i> Account Settings </a></li>
        	<li><a href="${pageContext.request.contextPath}/logoutAdmin"><i class="icon-signout"></i> Logout </a></li>
      	</ul>
    </li>
  </ul>
</div>
<a class="logo" href="index.html">se7en</a>
