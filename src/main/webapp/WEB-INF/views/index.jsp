<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/main.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/index.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/index_banner.css">
<title>싸개싸개 - 대한민국 NO.1 애견용품 사이트</title>
</head>
<body>
    <div id="page">
		<%@ include file="include/header.jsp" %> 
	
			<content>
			<div id="slider-wrap">
			<ul id="slider">
				<li>
            <img src="${pageContext.request.contextPath }/resources/img/banner1.png" class="banner">
				</li>

				<li>
            <img src="${pageContext.request.contextPath }/resources/img/banner2.png" class="banner">
				</li>

				<li>
            <img src="${pageContext.request.contextPath }/resources/img/banner3.png" class="banner">
				</li>

				<li>
            <img src="${pageContext.request.contextPath }/resources/img/banner4.png" class="banner">
				</li> 
			</ul>

			<div class="slider-btns" id="next"><span>▶</span></div>
			<div class="slider-btns" id="previous"><span>◀</span></div>
			<div id="slider-pagination-wrap">
				<ul>
				</ul>
			</div>
		</div>
		</content>
		<script>
			//slide-wrap
			var slideWrapper = document.getElementById('slider-wrap');
			//current slideIndexition
			var slideIndex = 0;
			//items
			var slides = document.querySelectorAll('#slider-wrap ul li');
			//number of slides
			var totalSlides = slides.length;
			//get the slide width
			var sliderWidth = slideWrapper.clientWidth;
			//set width of items
			slides.forEach(function (element) {
				element.style.width = sliderWidth + 'px';
			})
			//set width to be 'x' times the number of slides
			var slider = document.querySelector('#slider-wrap ul#slider');
			slider.style.width = sliderWidth * totalSlides + 'px';

			// next, prev
			var nextBtn = document.getElementById('next');
			var prevBtn = document.getElementById('previous');
			nextBtn.addEventListener('click', function () {
				plusSlides(1);
			});
			prevBtn.addEventListener('click', function () {
				plusSlides(-1);
			});

			// hover
			slideWrapper.addEventListener('mouseover', function () {
				this.classList.add('active');
				clearInterval(autoSlider);
			});
			slideWrapper.addEventListener('mouseleave', function () {
				this.classList.remove('active');
				autoSlider = setInterval(function () {
					plusSlides(1);
				}, 3000);
			});


			function plusSlides(n) {
				showSlides(slideIndex += n);
			}

			function currentSlides(n) {
				showSlides(slideIndex = n);
			}

			function showSlides(n) {
				slideIndex = n;
				if (slideIndex == -1) {
					slideIndex = totalSlides - 1;
				} else if (slideIndex === totalSlides) {
					slideIndex = 0;
				}

				slider.style.left = -(sliderWidth * slideIndex) + 'px';
				pagination();
			}

			//pagination
			slides.forEach(function () {
				var li = document.createElement('li');
				document.querySelector('#slider-pagination-wrap ul').appendChild(li);
			})

			function pagination() {
				var dots = document.querySelectorAll('#slider-pagination-wrap ul li');
				dots.forEach(function (element) {
					element.classList.remove('active');
				});
				dots[slideIndex].classList.add('active');
			}

			pagination();
			var autoSlider = setInterval(function () {
				plusSlides(1);
			}, 3000);
			$(function(){
            $(".arctic_scroll").arctic_scroll({
                speed: 800
            });
        });
		
			$(document).ready(function(){ 
				$('selector').css('width', $(window).width()); 
				$('selector').css('height', $(window).height()); 
				$(window).resize(function() { 
					$('selector').css('width', $(window).width()); 
					$('selector').css('height', $(window).height()); 
				}); 
			});
		</script>
	
	
	
		
     <main class="">
        <article id="content"> 
            <section>
            	<table class="banner"><br><br>
					<tr>
						<td>
						<form action="go_explain" id="search1">
                			<input type="hidden" value="${product1.pId}" name="pid"> 
						<div class="bannerbox">
							<div class="imgbanner">
							<img src="${pageContext.request.contextPath }/resources/uploadfiles/${product1.imageurl}" alt="banner1" width=380 height=250 onclick="document.getElementById('search1').submit();">
							</div>
							<div class="imgtext">${product1.pName }</div>
						</div>
						<br></form></td>
						<td>
						<form action="go_explain" id="search2">
                			<input type="hidden" value="${product2.pId}" name="pid"> 
						<div class="bannerbox">
							
								<div class="imgbanner">
								<img src="${pageContext.request.contextPath }/resources/uploadfiles/${product2.imageurl}" alt="banner2" width=380 height=250 onclick="document.getElementById('search2').submit();">
								</div>
								<div class="imgtext">${product2.pName }</div>
							</div>
						<br></form></td>
					</tr> 
					
            		<tr>
						<td>
						<form action="go_explain" id="search3">
                			<input type="hidden" value="${product3.pId}" name="pid"> 
						<div class="bannerbox">
							<div class="imgbanner">
						
						<img src="${pageContext.request.contextPath }/resources/uploadfiles/${product3.imageurl}" alt="banner3" width=380 height=250 onclick="document.getElementById('search3').submit();">
						
						</div>
							<div class="imgtext">${product3.pName }</div></div>
						<br><br>
						
						</form>
						</td>
						
						
						<td>
						<form action="go_explain" id="search4">
                			<input type="hidden" value="${product4.pId}" name="pid"> 
						<div class="bannerbox">
							<div class="imgbanner">
						<img src="${pageContext.request.contextPath }/resources/uploadfiles/${product4.imageurl}" alt="banner4" width=380 height=250 onclick="document.getElementById('search4').submit();">
						</div>
							<div class="imgtext">${product4.pName }</div></div>
						<br><br>
						</form></td>
					</tr>
            	
            	</table> 
            </section>
 
        </article>
        
     	</main>
		<%@ include file="include/footer.jsp" %>
    </div>
</body>
</html>