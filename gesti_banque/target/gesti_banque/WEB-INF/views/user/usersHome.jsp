<!DOCTYPE html>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<html>

<head>
<style><%@include file="/WEB-INF/components/head/head.jsp"%></style>

</head>
<body>
<div class="container-fluid">
 
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
        <form name="absence" method="post" action="" enctype="multipart/form-data">
                    <fieldset class="absform">
                        <legend></legend><br />
                        <div class="row">
                            <div class="col-md-12 declaration">
                           
                                <label class="choix" for="absence"></label>
                                
                                <input type="radio" name="types" value="Absences" id="absence" onclick="">
                                <label class="choix" for="conges"></label>
                               
                                <input type="radio" name="types" value="Congés" id="conges" onclick="">
                            
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-12">
                        <label class="label date" for="dateAbsD"></label>
                        <br /><br />
                        <label class="label" for="dateAbsF"></label>
                        
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-12">
                        <label class="label motif" for="motif"></label>
                        <textarea class="input textarea"  name="motif" maxlength="255" id="motif"></textarea><br /><br />
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-12">
                                <div id="champ">
                                <label class="label justificatif" for="justificatif"></label><br />
                                <input class="input choisir" type="file" name="justificatif" id="justificatif"/><br /><br />
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-12">
                        <input class="envoyer" name="envoyer" type="submit" value="Envoyer" id="submit"/><br />
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
        <div class="col-md-4"></div>
    </div><br /><br /><br /><br />

</body>
</html>