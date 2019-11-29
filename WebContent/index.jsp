
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
    
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Book Store Template, Free CSS Template, CSS Website Layout</title>
<meta name="keywords" content="Book Store Template, Free CSS Template, CSS Website Layout, CSS, HTML" />
<meta name="description" content="Book Store Template, Free CSS Template, Download CSS Website" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<c:if test="${list==null }">
<c:redirect url="ProductDatabaseController"></c:redirect>
</c:if>
<!--  Free CSS Templates from www.templatemo.com -->
<div id="templatemo_container">
<jsp:include page="Menu.jsp" />
    
   <jsp:include page="Header.jsp" />
    <div id="templatemo_content">
    	
        <div id="templatemo_content_left">
        	<div class="templatemo_content_left_section">
            	<h1>Categories</h1>
                <ul>
                    <c:forEach items="${categoryList}" var="category">
                    <li>
                    <a href="ProductDatabaseController?action=getAllCategoryByProductId&categoryId=${category.categoryId}">${category.categoryCode}-${category.categoryDescription}</a>
                    </li>
                    </c:forEach>
            	</ul>
            </div>
			<div class="templatemo_content_left_section">
            	<h1>Bestsellers</h1>
                <ul>
                    <li><a href="#">Vestibulum ullamcorper</a></li>
                    <li><a href="#">Maece nas metus</a></li>
                    <li><a href="#">In sed risus ac feli</a></li>
                    <li><a href="#">Praesent mattis varius</a></li>
                    <li><a href="#">Maece nas metus</a></li>
                    <li><a href="#">In sed risus ac feli</a></li>
                    <li><a href="http://www.flashmo.com" target="_parent">Flash Templates</a></li>
                    <li><a href="http://www.templatemo.com" target="_parent">CSS Templates</a></li>
                    <li><a href="http://www.webdesignmo.com" target="_parent">Web Design</a></li>
                    <li><a href="http://www.photovaco.com" target="_parent">Free Photos</a></li>
            	</ul>
            </div>
            
            <div class="templatemo_content_left_section">                
                <a href="http://validator.w3.org/check?uri=referer"><img style="border:0;width:88px;height:31px" src="http://www.w3.org/Icons/valid-xhtml10" alt="Valid XHTML 1.0 Transitional" width="88" height="31" vspace="8" border="0" /></a>
<a href="http://jigsaw.w3.org/css-validator/check/referer"><img style="border:0;width:88px;height:31px"  src="http://jigsaw.w3.org/css-validator/images/vcss-blue" alt="Valid CSS!" vspace="8" border="0" /></a>
			</div>
        </div> <!-- end of content left -->
        
        <div id="templatemo_content_right">
        <c:forEach  var="product" items="${list}"  varStatus="status">
        	<div class="templatemo_product_box">
            	<h1>${product.code}  <span>(by Best Author)</span></h1>
   	      <img src="images/templatemo_image_01.jpg" alt="image" />
                <div class="product_info">
                	<p>${product.description}</p>
                  <h3>${product.price}</h3>
                    <div class="buy_now_button"><a href="ProductDatabaseController?action=addToCart&productId=${product.id}">Buy Now</a></div>
                    <div class="detail_button"><a href="ProductDatabaseController?action=getProductDescritpion&productId=${product.id}">Detail</a></div>
                </div>
                <div class="cleaner">&nbsp;</div>
               
                </div>
                <c:if test="${status.index%2==0 }">
                <div class="cleaner_with_width">&nbsp;</div>
            </c:if>
            <c:if test="${status.index%2!=0 }">
             <div class="cleaner_with_height">&nbsp;</div>
             </c:if>
        </c:forEach>
            
            
           
            
            <a href="subpage.html"><img src="images/templatemo_ads.jpg" alt="ads" /></a>
        </div> <!-- end of content right -->
    
    	<div class="cleaner_with_height">&nbsp;</div>
    </div> <!-- end of content -->
    
   <jsp:include page="Footer.jsp" />
<!--  Free CSS Template www.templatemo.com -->
</div> <!-- end of container -->
<div align=center>This template  downloaded form <a href='http://all-free-download.com/free-website-templates/'>free website templates</a>
</div>
</body>
</html>