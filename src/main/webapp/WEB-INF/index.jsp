<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Tracker</title>
        
    <link rel="stylesheet" href='<c:url value="/web-resources/css/bootstrap.min.css"/>'>
    <link rel="stylesheet" href='<c:url value="/web-resources/css/font-awesome.min.css"/>'>
    <link rel="stylesheet" href='<c:url value="/web-resources/tagmanager/tagmanager.css"/>'>       
    
    <!--[if lt IE 9]>
    	<script src='<c:url value="/web-resources/js/html5shiv.js"/>' ></script>
    	<script src='<c:url value="/web-resources/js/respond.min.js"/>' ></script>
    <![endif]-->
    
</head><!--/head-->

<body data-spy="scroll" data-target="#navbar" data-offset="0">
    <header id="header" role="banner">
        <div class="container">
            <div id="navbar" class="navbar navbar-default">
                <div class="navbar-header">                    
                    <a class="navbar-brand" href=""><img src="http://biznomy.com/images/logo.png"></a>
                </div>                
            </div>
        </div>
    </header><!--/#header-->

    <section id="movepoints">
        <div class="container">
            <div class="box last">
                <div class="gap"></div>
                <div id="team-scroller">
                    <div class="carousel-inner">
                        <div class="item active">
                            <div class="row">
                                <div class="col-sm-6">
                                    <form method="post" action="v1/api/points" enctype="multipart/form-data">
			                            <div class="row">
			                                <div class="col-sm-12">
			                                    <div class="form-group">
			                                        <label for="file">Ednomy co-ordinate Json File</label>
  													<input type="file" id="file" name="file" required="required" accept=".json"/>
			                                    </div>
			                                </div>			                                			                                
			                            </div>
			                            <div class="row">
			                                <div class="col-sm-offset-6 col-sm-6">
			                                    <div class="form-group">
			                                        <input class="btn btn-info btn-lg" type="submit" value="submit"/>
			                                    </div>
			                                </div>			                                
			                            </div>			                            
			                        </form>
                                </div>
                                <div class="col-sm-6">
                                	<img src="http://biznomy.com/images/logo.png" width="100%" height="100%">
                                </div>
                            </div>
                        </div>                        
                    </div>                    
                </div><!--/.carousel-->
            </div><!--/.box-->
        </div><!--/.container-->
    </section><!--/#request-->
    
    <section id="loadlocation" style="border: 1px solid #868686; padding: 20px;">
        <div class="container">
            <div class="box last">
                <div class="gap"></div>
                <div id="team-scroller">
                    <div class="carousel-inner">
                        <div class="item active">
                            <div class="row">
                                <div class="col-sm-6">
                                    <form method="get" action="scrapper">
			                            <div class="row">
			                                <div class="col-sm-12">
			                                    <div class="form-group">
			                                        <label for="keyword">keyword</label>
  													<input type="text" name="keyword" />
			                                    </div>
			                                </div>			                                			                                
			                            </div>
			                            <div class="row">
			                                <div class="col-sm-12">
			                                    <div class="form-group">
			                                        <label for="apikey">google api key</label>
  													<input type="text" name="apikey" />
			                                    </div>
			                                </div>			                                			                                
			                            </div>
			                            <div class="row">
			                                <div class="col-sm-12">
			                                    <div class="form-group">
			                                        <label for="latlng">latlng</label>
  													<input type="text" name="latlng" />
			                                    </div>
			                                </div>			                                			                                
			                            </div>
			                            <div class="row">
			                                <div class="col-sm-12">
			                                    <div class="form-group">
			                                        <label for="radius">radius</label>
  													<input type="text" name="radius" />
			                                    </div>
			                                </div>			                                			                                
			                            </div>			                          
			                            
			                            <div class="row">
			                                <div class="col-sm-offset-6 col-sm-6">
			                                    <div class="form-group">
			                                        <input class="btn btn-info btn-lg" type="submit" value="submit"/>
			                                    </div>
			                                </div>			                                
			                            </div>			                            
			                        </form>
                                </div>                               
                            </div>
                        </div>                        
                    </div>                    
                </div><!--/.carousel-->
            </div><!--/.box-->
        </div><!--/.container-->
    </section><!--/#request-->
    
    

    <footer id="footer" style="position: absolute; left: 0; right: 0; bottom: 0; padding: 20px;">
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    &copy; 2013 <a target="_blank" href="http://biznomy.com/" title="free your education app">biznomy.com</a>. All Rights Reserved.
                </div>                
            </div>
        </div>
    </footer><!--/#footer-->

	<script src='<c:url value="/web-resources/js/jquery.js"/>' ></script>
	<script src='<c:url value="/web-resources/js/bootstrap.min.js"/>' ></script>
	<script src='<c:url value="/web-resources/tagmanager/tagmanager.js"/>' ></script>
	<script>
		$("#keywords").tagsManager({
			hiddenTagListName: 'keywords'			
		});
	</script>
		
</body>
</html>