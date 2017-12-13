<%@ taglib uri="http://jawr.net/tags" prefix="jwr"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="app" ng-controller="ctrl_init" document-events ng-click="onClick($event)" ng-keyup="onKeyUp($event)" ng-class="{ 'page_loading': pageLoading, 'page_loaded': pageLoaded, 'app_initialized': appInitialized && (!$state.is('login') && !$state.includes('error'))}">
<head>
<base href="<%=request.getContextPath()%>/">
 <meta charset="UTF-8">
 <meta name="viewport" content="initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <!-- Remove Tap Highlight on Windows Phone IE -->
 <meta name="msapplication-tap-highlight" content="no"/>
 
 <jwr:style src="/bundle/all.css" />

<title>Med Aula - Administração</title>

</head>

<body class="sidebar_main_open sidebar_main_swipe app_theme_medaula" data-uk-observe ng-class="{
    'sidebar_main_active': primarySidebarActive && !miniSidebarActive && !topMenuActive && (!$state.is('login') && !$state.includes('error')),
    'sidebar_main_open': primarySidebarOpen && !miniSidebarActive && !topMenuActive && largeScreen && (!$state.is('login') && !$state.includes('error')),
    'sidebar_mini': miniSidebarActive && largeScreen && (!$state.is('login') && !$state.includes('error')),
    'sidebar_main_hiding': primarySidebarHiding,
    'sidebar_secondary_active': secondarySidebarActive && (!$state.is('login') && !$state.includes('error')),
    'top_bar_active': toBarActive && (!$state.is('login') && !$state.includes('error')),
    'page_heading_active': pageHeadingActive && (!$state.is('login') && !$state.includes('error')),
    'header_double_height': headerDoubleHeightActive && (!$state.is('login') && !$state.includes('error')),
    'main_search_active': mainSearchActive && (!$state.is('login') && !$state.includes('error')),
    'header_full': fullHeaderActive && (!$state.is('login') && !$state.includes('error')),
    'boxed_layout': boxedLayoutActive && (!$state.is('login') && !$state.includes('error')),
    'login_page': $state.is('login'),
    'error_page': $state.includes('error'),
    'uk-height-1-1': page_full_height
}" content-sidebar>


	<div id="page_preloader" ng-hide="hidePreloader"><img src="resources/img/loader.gif" alt=""/></div>

	<div ui-view="main_header"></div>
    <div ui-view id="main_view" ng-class="{'uk-height-1-1': page_full_height }"></div>
    <div ui-view="main_sidebar"></div>


     <jwr:script src="/bundle/js/all.js" />
    
</body>
</html>