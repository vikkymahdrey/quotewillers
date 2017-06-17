<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html lang="en">

	<head>
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <meta name="description" content="">
	    <meta name="author" content="">

	    <title>Quotewillers</title>
	    <!-- Web Fonts -->
		<link href='http://fonts.googleapis.com/css?family=Roboto:400,900,700,500,300' rel='stylesheet' type='text/css'>
	    <!-- Flaticon CSS -->
	    <link href="fonts/flaticon/flaticon.css" rel="stylesheet">
	    <!-- font-awesome CSS -->
	    <link href="css/font-awesome.min.css" rel="stylesheet">
	    <!-- Offcanvas CSS -->
	    <link href="css/hippo-off-canvas.css" rel="stylesheet">
	    <!-- animate CSS -->
	    <link href="css/animate.css" rel="stylesheet">
	    <!-- owl.carousel CSS -->
	    <link href="css/owl.theme.css" rel="stylesheet">
	    <link href="css/owl.carousel.css" rel="stylesheet">
	    <!-- Bootstrap Core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet">
	    <!-- Custom CSS -->
	    <link href="css/style.css" rel="stylesheet">
	    <!-- Responsive CSS -->
	    <link href="css/responsive.css" rel="stylesheet">

	    <script src="js/vendor/modernizr-2.8.1.min.js"></script>
	    <!-- HTML5 Shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	    <!--[if lt IE 9]>
		    <script src="js/vendor/html5shim.js"></script>
		    <script src="js/vendor/respond.min.js"></script>
	    <![endif]-->
	    
	    <!-- jQuery -->
	    <script src="js/jquery.js"></script>
	    <!-- Bootstrap Core JavaScript -->
	    <script src="js/bootstrap.min.js"></script>
	    <!-- wow.min.js -->
	    <script src="js/wow.min.js"></script>
	    <!-- smoothscroll -->
	    <script src="js/smoothscroll.js"></script>
	    <!-- twitterFetcher_min -->
	    <script src="js/twitterFetcher_min.js"></script>
	    <!-- owl.carousel -->
	    <script src="js/owl.carousel.min.js"></script>
		<!-- Offcanvas Menu -->
		<script src="js/hippo-offcanvas.js"></script>
		<!-- inview -->
		<script src="js/jquery.inview.min.js"></script>
		<!-- stellar -->
		<script src="js/jquery.stellar.js"></script>
		<!-- countTo -->
		<script src="js/jquery.countTo.js"></script>
	    <!-- Scrolling Nav JavaScript -->
	    <script src="js/jquery.easing.min.js"></script>
		<!-- flickerPhoto -->
		<script src="js/flickerPhoto.min.js"></script>
		<!-- Shuffle.min js -->
		<script src="js/jquery.shuffle.min.js"></script>
	    <!-- GOGLE MAP -->
	    <script src="https://maps.googleapis.com/maps/api/js"></script>
	    <!-- Custom Script -->
	    <script src="js/scripts.js"></script>
	    <script type="text/javascript">
	    
	    function ajaxcall(){
	        var sel1 = document.getElementById("sel1").value;
		    var message = document.getElementById("message").value;

     		 $.ajax({
                  url: 'quoteSubmission',
                  type: "POST",
                  data: 'sel1='+sel1+'&message='+message,
                  success: function (data) {
                  alert(data);
                  //document.getElementById("message").innerHTML="<textarea id='message' name='message' class='form-control' required='' rows='6'  placeholder='Enter Message here'></textarea>";
                  location.reload();
               	                    	
                      },
     		 error: function(e){
     	     			        alert('Error: ' + e);
     	      }

                     
                  });
     	
     

	    }
	    
	   
	    /* function confirmValidate() {
		
	    var sel1 = document.getElementById("sel1");
	    var message = document.getElementById("message");
	   	var flag = true;
	   
		if(sel1=="0")
		{
		 document.getElementById("errortag1").innerHTML = "Please Select Quote!";
		 $('.validation-required').removeClass("validation-required").addClass("form-control");
		 $('.san').show();
		 document.getElementById("sel1").focus();
		  flag=false;
		
		}		
		else  if (message=="") {
			 document.getElementById("errortag1").innerHTML = "";
		 document.getElementById("errortag2").innerHTML = "Please Select Quote Message!";
		 $('.validation-required').removeClass("validation-required").addClass("form-control");
		 $('.san').show();
		 document.getElementById("message").focus();
		   flag=false;
		}
		    
		
			
		return flag;

	}  */
	    </script>
	</head>


<body id="page-top" data-spy="scroll"  data-target=".navbar" style="background-color:grey;">
				
  <div id="st-container" class="st-container">
    <div class="st-pusher">
        <div class="st-content">
            <div class="st-content-inner">

		        
				<section id="contact" class="footer-widget-wrapper" >
					<div class="container" >
					<div class="row">
							<div class="col-sm-12 text-right" style="margin-left:8%;">
								<a href="logout"><img src="images/logout_icon_header.png" />&nbsp;<b>Log Out</b></a>
							</div>
					
					</div>
					
					
					
						<div class="row">
							<div class="col-sm-12">
								<div class="footer-widget">
									<a class="feedback-modal" data-toggle="modal" data-target="#feedModal" href="#"><b>Quotes Writing</b></a>

									<!-- Modal -->
									<div class="modal fade" id="feedModal" tabindex="-1" role="dialog" aria-labelledby="feedModalLabel" aria-hidden="true">
									  <div class="modal-dialog modal-lg">
									    <div class="modal-content">
									      <div class="modal-header">
									        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
									        <h4 class="modal-title" id="feedModalLabel">Quotes Writing</h4>
									      </div>
									      <div class="modal-body">
											<form id="contactForm"   method="POST" onsubmit="ajaxcall()">
																								
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
														    <label for="name">Quote Type*</label>
														    <select class="form-control" id="sel1" name="sel1" required="" >
														    	<option value="Love">Love</option>
															    <option value="Emotional">Emotional</option>
															    <option value="Funny">Funny</option>
															    <option value="Inspirational">Inspirational</option>
															    <option value="For Friends">For Friends</option>
															    <option value="Romantic">Romantic</option>
															    
  															</select>
														</div>
													</div>
													 <div class="col-md-6">
													  <div class="form-group">
													   </div>
													</div> 
												</div>
												

												<div class="form-group text-area">
													<label for="message">About Selected Quote*</label>
													<textarea id="message" name="message" class="form-control" required="" rows="6"  placeholder="Enter Message here"></textarea>
												
												</div>

												<input type="submit" class="btn btn-primary" value="Send Message">
												
											</form>
									      </div>
									    </div>
									  </div>
									</div>
								</div><!-- /.footer-widget -->
							</div><!-- /.col-md-2 -->
							
							
						</div><!-- /.row -->
				
						 

					</div><!-- /.container -->
				</section>
				<!-- footer end -->
        </div> <!-- .st-content-inner -->
    </div> <!-- .st-content -->
    </div> <!-- .st-pusher -->

	</div><!-- /st-container -->
					<div class="row">
							<div class="col-xs-12 text-center">
								<div class="copyright" style="margin-top:20%;">
									<p>&copy; 2017 Quotewillers.  Design by : <a href="http://www.quotewillers.com" title="quotewillers"><b>http://www.quotewillers.com</b></a></p>
								</div>
							</div>
						</div> 


	    
	</body>
</html>
