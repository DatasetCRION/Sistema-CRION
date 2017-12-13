<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="http://fonts.googleapis.com/css?family=Roboto:300,400,500" rel='stylesheet' type='text/css'>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ taglib uri="http://jawr.net/tags" prefix="jwr"%>

        <jwr:style src="/bundle/auth.css" />

        <meta charset="UTF-8">
        <meta name="viewport" content="initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- Remove Tap Highlight on Windows Phone IE -->
        <meta name="msapplication-tap-highlight" content="no"/>

        <script>
    CONTEXT_PATHT = "<%=request.getContextPath()%>";
        </script>
        <title>Med Aula - Administração</title>
    </head>
    <body class="login_page">
        <div class="login_page_wrapper">
            <div class="md-card" id="login_card">
                <div class="md-card-content large-padding" id="login_form">
                    <div class="login_heading">
                        <div class="logo" style="background-image: url('');">
                            <img style="max-height: 150px;" src="../auth/img/logo.png">
                        </div>
                    </div>
                    <form action="<%= request.getContextPath()%>/login" method="post">


                        <%if (request.getParameter("auth") != null && request.getParameter("auth").trim().toLowerCase().equals("fail")) {
                        %>
                        <div class="uk-alert uk-alert-danger uk-text-center">Usuário e/ou senha incorretos</div>
                        <%
                        %>
                        <%}%>


                        <div class="uk-form-row">
                            <label for="login_username">E-mail</label>
                            <input class="md-input md-input-login" type="text" id="login_username" name="username" />
                        </div>
                        <div class="uk-form-row">
                            <label for="login_password">Senha</label>
                            <input class="md-input md-input-login" type="password" id="login_password" name="password" />
                        </div>
                        <div class="uk-margin-medium-top">
                            <button type="submit" class="md-btn md-btn-login md-btn-block md-btn-large">Entrar</button>
                        </div>
                        <div class="uk-margin-top uk-text-center">
                        </div>
                    </form>
                </div>
                <div class="md-card-content large-padding" id="login_password_reset" style="display: none">
                    <button type="button" class="uk-position-top-right uk-close uk-margin-right uk-margin-top back_to_login"></button>
                    <h2 class="heading_a uk-margin-large-bottom">Receuperar Senha</h2>
                    <form>
                        <div class="uk-form-row">
                            <label for="login_email_reset">Seu endereço de e-mail</label>
                            <input class="md-input" type="text" id="login_email_reset" name="login_email_reset" />
                        </div>
                        <div class="uk-margin-medium-top">
                            <a href="index.html" class="md-btn md-btn-primary md-btn-block">Confirmar</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <jwr:script src="/bundle/js/auth.js" />
    </body>
</html>