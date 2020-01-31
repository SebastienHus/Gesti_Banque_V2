
<!DOCTYPE html>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<html>

<head>
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">	

<style><%@include file="WEB-INF/components/head/head.jsp"%>
<%@include file="/WEB-INF/assets/css/main.css"%> 
</style>

</head>
	
	<body>

	 <jsp:include page="/WEB-INF/components/headers/header.jsp">
            <jsp:param name="" value=""/>
        </jsp:include>
	
	
	
    
    <div class="row  justify-content-center" id="logfield">
        <fieldset id="logfield" class="col-md-6 align-self-center f1">
                <legend id="textInput">Gesti banque</legend>               
                 
                    <div id="logfield" class="row">
                        <div class="col-md-6">      
          
                <a href="connexion"><button type="button" id="button3" class="btn btn-secondary btn-lg btn-block my-4">Connexion</button></a><br>
                 
                <a href="index.jsp"><button type="button" id="button" class="btn btn-secondary btn-lg btn-block my-4">Retour</button></a>
                
            			</div>
            		</div>             
            <br>
        </fieldset>	
    </div>  
    
    
    
	 <jsp:include page="/WEB-INF/components/footers/footer.jsp">
	            <jsp:param name="" value=""/>
	        </jsp:include>

	</body>	
	
</html>