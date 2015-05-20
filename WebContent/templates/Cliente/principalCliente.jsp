<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8" />
  
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />
  <link rel="canonical" href="/" />
  
  <meta name="description" content="" />
  
  <title><s:text  name="global.titulo" /></title>
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,500,600,700,800" rel="stylesheet" type="text/css" />
  <link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet" type="text/css" />
  <link href="https://fonts.googleapis.com/css?family=Droid+Sans:400,700" rel="stylesheet" type="text/css" />
  
  <link href="Cliente/assets/stylesheets/cs.animate.css" rel="stylesheet" type="text/css" media="all" />
  <link href="Cliente/assets/stylesheets/application.css" rel="stylesheet" type="text/css" media="all" />
  <link href="Cliente/assets/stylesheets/bootstrap.min.3x.css" rel="stylesheet" type="text/css" media="all" />
  <link href="Cliente/assets/stylesheets/cs.bootstrap.3x.css" rel="stylesheet" type="text/css" media="all" />
  <link href="Cliente/assets/stylesheets/owl.carousel.css" rel="stylesheet" type="text/css" media="all" />
  <link href="Cliente/assets/stylesheets/responsive-slider.css" rel="stylesheet" type="text/css" media="all" />
  <link href="Cliente/assets/stylesheets/fancybox-buttons.css" rel="stylesheet" type="text/css" media="all" />
  <link href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all" />
  <link href="Cliente/assets/stylesheets/cs.global.css" rel="stylesheet" type="text/css" media="all" />
  <link href="Cliente/assets/stylesheets/cs.style.css" rel="stylesheet" type="text/css" media="all" />
  <link href="Cliente/assets/stylesheets/cs.media.3x.css" rel="stylesheet" type="text/css" media="all" />
  <!--[if IE 8 ]> 
<link href="./assets/stylesheets/ie8.css" rel="stylesheet" type="text/css" media="all">
<![endif]-->
</head>
<body  class="templateIndex" itemscope="" itemtype="http://schema.org/WebPage">
<header id="top" class="fadeInDownBig clearfix">
<tiles:insertAttribute	name="cabecera" />	    
</header>
<nav>
<tiles:insertAttribute	name="nav" />	    
</nav>
<div id="content-wrapper-parent">
<tiles:insertAttribute	name="central" />    
</div>	
<div id="bottom">
<tiles:insertAttribute	name="bottom" />	
</div>
<footer id="footer">
<tiles:insertAttribute	name="footer" />	
</footer>
  
<script src="Cliente/assets/javascripts/jquery-1.8.2.min.js" type="text/javascript"></script>
<script src="Cliente/assets/javascripts/bootstrap.min.3x.js" type="text/javascript"></script>
<script src="Cliente/assets/javascripts/modernizr.js" type="text/javascript"></script>
<script src="Cliente/assets/javascripts/application.js" type="text/javascript"></script>
<script src="Cliente/assets/javascripts/cs.global.js" type="text/javascript"></script>
<script src="Cliente/assets/javascripts/owl.carousel.js" type="text/javascript"></script>
<script src="Cliente/assets/javascripts/jquery.fancybox-buttons.js" type="text/javascript"></script>
<script src="Cliente/assets/javascripts/jquery.responsive-slider.min.js" type="text/javascript"></script>
<script src="Cliente/assets/javascripts/jquery.imagesloaded.min.js" type="text/javascript"></script>
<script src="Cliente/assets/javascripts/cs.script.js" type="text/javascript"></script>
</body>
</html>