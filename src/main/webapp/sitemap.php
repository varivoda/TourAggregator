<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Site Map</title>
<link href="css/styles.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script language="javascript" type="text/javascript" src="js/jquery.cycle.all.min.js"></script>
<!--below is the code to display the menu properly in ie6-->
<!--[if IE 6]>
<script defer type="text/javascript" src="js/pngfix.js"></script>
<style type="text/css"> 
.box_list li {
	width:254px;
	list-style:none;
	float:left;
	margin:0px;
	padding:0 10px 5px 0;

}</style>
<![endif]-->
<!--this script is for the slideshow-->
<script type="text/javascript" language="javascript">
$(window).ready(function(){
	$('#home_banner').cycle('fade');
});
</script>
<!--end slideshow script-->
</head>
<body>
<div id="wrapper">
  <!--end home banner-->
  <div id="header">
    <div id="header_logo"> <a href="#"><img src="images/logo.png" alt="Logo" width="241" height="125" border="0" /></a> </div>
  </div>
  <div id="side_menu_container">
    <ul id="side_menu">
      <li><a href="index.html">HOME</a></li>
      <li><a href="index.html">ABOUT</a></li>
      <li><a href="holidays.html">HOLIDAYS</a></li>
      <li><a href="index.html">FLIGHTS</a></li>
      <li><a href="index.html">NEWS BLOG</a></li>
      <li><a href="contact.html">CONTACT US</a></li>
    </ul>
    <!--start signup box-->
    <div class="side_menu_box" style="height:110px;">
      <div class="top">Newsletter Signup</div>
      <form action="" method="post">
        <input name="name" type="text" class="side_menu_box_field" id="name" value="Name" size="11" />
        <input name="email" type="text" class="side_menu_box_field" id="email" value="Email" size="11" />
          <input name="submit" type="image" class="side_menu_box_button" id="submit" src="images/button_submit.gif" />
      </form>
    </div>
    <!--end signup box-->
    <!--start info box-->
    <div id="info"> For Enquiries <br />
      <span class="size20">1300 555 555</span> info@website.com </div>
    <!--end info box-->
  </div>
  <!--start  main content-->
  <div id="content_body">
   <!--start site map code-->
<h1>Site Map</h1>
<ul>
  <?php
	$files = glob("*.html");
	$ignore_files = array( //add any file names of files you don't want to appear in the site map
		"formsubmit.php",
		"thankyou.html",
	);
	foreach($files as $f){ 
		if(in_array($f,$ignore_files))continue;
		$file_data = file_get_contents($f);
		if(preg_match('/<title>([^<]+)<\/title>/i',$file_data,$matches)){
		$page_title = $matches[1];
		}else{
		$page_title = $f;
		}
		
		?>
  <li><a href="<?=$f;?>">
    <?=$page_title;?>
    </a></li>
  <?
	}
	?>
</ul>
<!--end site map code-->
  </div>
  <!--end  main content-->
  <hr class="clear" />
</div>
<!--end wrapper-->
<div id="footer">
  <div class="left">&copy; Curvy &amp; Clean</div>
  <div class="right">
    <ul>
      <li><a href="http://themeforest.net/user/dtbaker?ref=dtbaker">Designed by dtbaker</a> </li>
      <li>| <a href="sitemap.php">Site map</a> </li>
      <li>| <a href="contact.html">Contact Us</a></li>
    </ul>
  </div>
</div>
</body>
</html>
