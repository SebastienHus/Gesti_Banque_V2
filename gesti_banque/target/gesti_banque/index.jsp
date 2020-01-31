
<!DOCTYPE html>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<html>

<head>
<style><%@include file="WEB-INF/components/head/head.jsp"%></style>

</head>
	
	<body>

	 <jsp:include page="/WEB-INF/components/headers/header.jsp">
            <jsp:param name="" value=""/>
        </jsp:include>
	
	
<div id="logfield" class="containerfluid">
    
    <div class="row  justify-content-center" id="logfield">
        <fieldset id="logfield" class="col-md-6 align-self-center f1">
                <legend id="textInput">Gesti banque</legend>
               
                 <!--  <form name="formlog" id="logfield" class="border border-success p-5" method="POST" name="Connexion" action="login.jsp" required>-->
                    <div id="logfield" class="row">
                        <div class="col-md-6">
               
                <!--<input class="btn btn-success btn-block my-4" id="button3" type="submit" value="Connexion">-->
                
                 <a href="connexion"><button type="button" id="button3" class="btn btn-secondary btn-lg btn-block my-4">Connexion</button></a><br>
                 
                <button type="button" id="button" class="btn btn-secondary btn-lg btn-block my-4"><a href="index.jsp">Retour</a></button>
            </div>
            </div>
          
            <br>
            
            </div>
        </fieldset>	
    </div>    


	</body>
	
	 <jsp:include page="/WEB-INF/components/footers/footer.jsp">
            <jsp:param name="" value=""/>
        </jsp:include>
</html>