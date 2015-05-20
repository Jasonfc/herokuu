/* SHARED VARS */
var firstrun = true,
    touch = false,
    clickEv = 'click';


var isMobile = {
    Android: function() {
        return navigator.userAgent.match(/Android/i);
    },
    BlackBerry: function() {
        return navigator.userAgent.match(/BlackBerry/i);
    },
    iOS: function() {
        return navigator.userAgent.match(/iPhone|iPad|iPod/i);
    },
    Opera: function() {
        return navigator.userAgent.match(/Opera Mini/i);
    },
    Windows: function() {
        return navigator.userAgent.match(/IEMobile/i);
    },
    any: function() {
        return (isMobile.Android() || isMobile.BlackBerry() || isMobile.iOS() || isMobile.Opera() || isMobile.Windows());
    }
};

/* Fucntion get width browser */
function getWidthBrowser() {
	var myWidth;

	if( typeof( window.innerWidth ) == 'number' ) { 
		//Non-IE 
		myWidth = window.innerWidth;
		//myHeight = window.innerHeight; 
	} 
	else if( document.documentElement && ( document.documentElement.clientWidth || document.documentElement.clientHeight ) ) { 
		//IE 6+ in 'standards compliant mode' 
		myWidth = document.documentElement.clientWidth; 
		//myHeight = document.documentElement.clientHeight; 
	} 
	else if( document.body && ( document.body.clientWidth || document.body.clientHeight ) ) { 
		//IE 4 compatible 
		myWidth = document.body.clientWidth; 
		//myHeight = document.body.clientHeight; 
	}
	
	return myWidth;
}

/* Function: Refresh Zoom */
function alwaysUpdateZoom(){
  if(touch == false){
    
    if($('.elevatezoom').length){
      
      var zoomImage = $('.elevatezoom .img-zoom');

      zoomImage.elevateZoom({
        gallery:'gallery_main', 
        galleryActiveClass: 'active', 
        zoomType: 'window',
        cursor: 'pointer',
        zoomWindowFadeIn: 300,
        zoomWindowFadeOut: 300,
        scrollZoom: true,
        easing : true,
        loadingIcon: '../images/loader.gif'
      });
      
      
        //pass the images to Fancybox
        $(".elevatezoom .img-zoom").bind("click", function(e) {  
          var ez =   $('.elevatezoom .img-zoom').data('elevateZoom');	
          $.fancybox(ez.getGalleryList(),{
            closeBtn  : false,
            helpers : {
              buttons	: {}
            }
          });
          return false;
        });
      
    }
    
  }
       // is touch
       else{
         
       }
}
      
// handle quickshop position
function positionQuickshop(){
  
  if(touch == false){
    var quickshops = $('.quick_shop');
    
    quickshops.each(function() {
      var parent = $(this).parents('.hoverBorder');
      $(this).css({
        'top': ((parent.height() / 2) - ($(this).outerHeight() / 2)) + 'px',
        'left': ((parent.width() / 2) - ($(this).outerWidth() / 2)) + 'px',
      });
    });
  }
}

   
// handle Animate
function handleAnimate(){
  if(touch == false){
    $('[data-animate]').each(function(){
      
      var $toAnimateElement = $(this);
      
      var toAnimateDelay = $(this).attr('data-delay');
      
      var toAnimateDelayTime = 0;
      
      if( toAnimateDelay ) { toAnimateDelayTime = Number( toAnimateDelay ); } else { toAnimateDelayTime = 200; }
      
      if( !$toAnimateElement.hasClass('animated') ) {
        
        $toAnimateElement.addClass('not-animated');
        
        var elementAnimation = $toAnimateElement.attr('data-animate');
        
        $toAnimateElement.appear(function () {
          
          setTimeout(function() {
            $toAnimateElement.removeClass('not-animated').addClass( elementAnimation + ' animated');
          }, toAnimateDelayTime);
          
        },{accX: 0, accY: -100},'easeInCubic');
        
      }
    });
  }
}
    
// handle scroll-to-top button
function handleScrollTop() {
  
  function totop_button(a) {
    var b = $("#scroll-to-top");
    b.removeClass("off on");
    if (a == "on") { b.addClass("on") } else { b.addClass("off") }
  }
  
  $(window).scroll(function() {
    var b = $(this).scrollTop();
    var c = $(this).height();
    if (b > 0) { 
      var d = b + c / 2;
    } 
    else { 
      var d = 1 ;
    }
    
    if (d < 1e3 && d < c) { 
      totop_button("off");
    } 
    else {
      
      totop_button("on"); 
    }
  });
  
  $("#scroll-to-top").click(function (e) {
    e.preventDefault();
    $('body,html').animate({scrollTop:0},800,'swing');
  });
}
      
/* Function update scroll product thumbs */
function updateScrollThumbs(){
  if($('#gallery_main').length){
    
    if(touch){
      $('#product-image .main-image').on('click', function() {
        var _items = [];
        var _index = 0;
        var product_images = $('#product-image .image-thumb');
        product_images.each(function(key, val) {
          _items.push({'href' : val.href, 'title' : val.title});
          if($(this).hasClass('active')){
            _index = key;
          }
        });
        $.fancybox(_items,{
          closeBtn: false,
          index: _index,
          openEffect: 'none',
          closeEffect: 'none',
          nextEffect: 'none',
          prevEffect: 'none',
          helpers: {
            buttons: {}
          }
        });
        return false;
      });
    }
    else{
      
    }

    $('#product-image').on('click', '.image-thumb', function() {

      var $this = $(this);
      var background = $('.product-image .main-image .main-image-bg');
      var parent = $this.parents('.product-image-wrapper');
      var src_original = $this.attr('data-image-zoom');
      var src_display = $this.attr('data-image');
      
      background.show();
      
      parent.find('.image-thumb').removeClass('active');
      $this.addClass('active');
      
      parent.find('.main-image').find('img').attr('data-zoom-image', src_original);
      parent.find('.main-image').find('img').attr('src', src_display).load(function() {
        background.hide();
      });
      
      return false;
    });
  }
}
    
/* Handle Carousel */
function handleCarousel(){
  
  /* Handle main slideshow */
  if($('#home-slider').length){
    $('#home-slider').responsiveSlider({
      autoplay: true,
      interval: 5000,
      transitionTime: 300
    });
  }
  
  
  /* Handle Banners */
  if($('#home_banners').length){
      $("#home_banners").owlCarousel({
        navigation : true,
        pagination: false,
        items: 4,
        itemsDesktop : [1199,4],
        itemsDesktopSmall : [979,4],
        itemsTablet: [768,3],
        itemsTabletSmall: [540,2],
        itemsMobile : [360,1],
        scrollPerPage: true,
        navigationText: ['<i class="fa fa-caret-left btooltip" title="Previous"></i>', '<i class="fa fa-caret-right btooltip" title="Next"></i>'],
        afterInit: function(elem){
          elem.find('.btooltip').tooltip();
        }
      });
  }
  
  /* Handle Featured Collections */
  if($("#home_collections").length){
    imagesLoaded('#home_collections', function() {
      $("#home_collections").owlCarousel({
        navigation : true,
        pagination: false,
        items: 4,
        itemsDesktop : [1199,4],
        itemsDesktopSmall : [979,4],
        itemsTablet: [768,3],
        itemsTabletSmall: [540,2],
        itemsMobile : [360,1],
        scrollPerPage: true,
        navigationText: ['<i class="fa fa-caret-left btooltip" title="Previous"></i>', '<i class="fa fa-caret-right btooltip" title="Next"></i>'],
        beforeMove: function(elem) {
          if(touch == false){
            var items = elem.find('.not-animated');
            items.removeClass('not-animated').unbind('appear');
          }
        },
        afterInit: function(elem){
          elem.find('.btooltip').tooltip();
        }
      });
    });
  }
  
  /* Handle Featured Products */
  
  
  
  if($("#home_products_1").length){
      $("#home_products_1").owlCarousel({
        navigation : true,
        pagination: false,
        items: 4,
        itemsDesktop : [1199,4],
        itemsDesktopSmall : [979,4],
        itemsTablet: [768,3],
        itemsTabletSmall: [540,2],
        itemsMobile : [360,1],
        scrollPerPage: true,
        navigationText: ['<i class="fa fa-caret-left btooltip" title="Previous"></i>', '<i class="fa fa-caret-right btooltip" title="Next"></i>'],
        afterUpdate: function() {
          positionQuickshop();
        },
        afterInit: function(elem){
          elem.find('.btooltip').tooltip();
        }
      });
  }
  
  /* Handle Partners Logo */
  if($('#partners').length){
    
      $("#partners").owlCarousel({
        navigation : true,
        pagination: false,
        items: 8,
        itemsDesktop : [1199,6],
        itemsDesktopSmall : [979,5],
        itemsTablet: [768,4],
        itemsTabletSmall: [540,2],
        itemsMobile : [360,1],
        scrollPerPage: true,
        navigationText: ['<i class="fa fa-caret-left btooltip" title="Previous"></i>', '<i class="fa fa-caret-right btooltip" title="Next"></i>'],
        afterInit: function(elem){
          elem.find('.btooltip').tooltip();
        }
      });
  }
   
  /* Handle product thumbs */
  if($("#gallery_main").length){
    $("#gallery_main").owlCarousel({
      navigation : true,
      pagination: false,
      items: 4,
      itemsDesktop : [1199,3],
      itemsDesktopSmall : [979,3],
      itemsTablet: [768,3],
      itemsMobile : [479,3],
      scrollPerPage: true,
      navigationText: ['<i class="fa fa-caret-left btooltip" title="Previous"></i>', '<i class="fa fa-caret-right btooltip" title="Next"></i>'],
      afterInit: function(elem){
        elem.find('.btooltip').tooltip();
      }
    });
  }
  
  /* Handle related products */
  if($(".prod-related").length){
    $(".prod-related").owlCarousel({
      navigation : true,
      pagination: false,
      items: 4,
      itemsDesktop : [1199,3],
      itemsDesktopSmall : [979,3],
      itemsTablet: [768,2],
      itemsTabletSmall: [540,2],
      itemsMobile : [360,1],
      scrollPerPage: true,
      navigationText: ['<i class="fa fa-caret-left btooltip" title="Previous"></i>', '<i class="fa fa-caret-right btooltip" title="Next"></i>'],
      afterUpdate: function() {
        positionQuickshop();
      },
      afterInit: function(elem){
        elem.find('.btooltip').tooltip();
      }
    });
  }
}

/* Handle search box on mobile */
function callbackSearchMobile(){
  var button = $('.is-mobile .is-mobile-search i');
  var form = $('.is-mobile .is-mobile-search .search-form');
  button.mouseup(function(search) {
    form.show();
  });
  form.mouseup(function() { 
    return false;
  });
  $(this).mouseup(function(search) {
    if(!($(search.target).parent('.is-mobile .is-mobile-search').length > 0)) {
      form.hide();
    }
  });  
}
/* Handle search box on pc */
function handleBoxSearch(){
  if($('#header-search input').length){
    $('#header-search input').focus(function() {
      $(this).parent().addClass('focus');
    }).blur(function() {
      $(this).parent().removeClass('focus');
    });
  }
}
    
/* Handle Map with GMap */
function handleMap(){
  if(jQuery().gMap){
    if($('#contact_map').length){
      $('#contact_map').gMap({
        zoom: 17,
        scrollwheel: false,
        maptype: 'ROADMAP',
        markers:[
          {
            address: '249 Ung VÄƒn KhiÃªm, phÆ°á»ng 25, Ho Chi Minh City, Vietnam',
            html: '_address'
          }
        ]
      });
    }
  }
}
    
/* Handle Grid - List */
function handleGridList(){
  if($('#goList').length){
    $('#goList').on('click', function(e){
      $(this).parent().find('li').removeClass('active');
      $(this).addClass('active');
      
      $('#sandBox .element').addClass('full_width');
      $('#sandBox .element .row-left').addClass('col-md-6');
      $('#sandBox .element .row-left').addClass('col-sm-6');
      $('#sandBox .element .row-right').addClass('col-md-18');
      $('#sandBox .element .row-right').addClass('col-sm-18');
      
      $('#sandBox').isotope('reLayout');
      
      
      /* re-call handle position */
      positionQuickshop();
    });
  }
  
  if($('#goGrid').length){
    $('#goGrid').on('click', function(e){
      $(this).parent().find('li').removeClass('active');
      $(this).addClass('active');
      
      $('#sandBox .element').removeClass('full_width');
      $('#sandBox .element .row-left').removeClass('col-md-6');
      $('#sandBox .element .row-left').removeClass('col-sm-6');
      $('#sandBox .element .row-right').removeClass('col-md-18');
      $('#sandBox .element .row-right').removeClass('col-sm-18');
      
      $('#sandBox').isotope('reLayout');
      
      /* re-call handle position */
      positionQuickshop();
    });
  }
}

/* Handle detect platform */
function handleDetectPlatform(){
  /* DETECT PLATFORM */
  $.support.touch = 'ontouchend' in document;
  
  if ($.support.touch) {
    touch = true;
    $('body').addClass('touch');
    clickEv = 'touchstart';
  }
  else{
    $('body').addClass('notouch');
    if (navigator.appVersion.indexOf("Mac")!=-1){
      if (navigator.userAgent.indexOf("Safari") > -1){
        $('body').addClass('macos');
      }
      else if (navigator.userAgent.indexOf("Chrome") > -1){
        $('body').addClass('macos-chrome');
      }
        else if (navigator.userAgent.indexOf("Mozilla") > -1){
          $('body').addClass('macos-mozilla');
        }
    }
  }
}
    
/* Handle tooltip */
function handleToolTip(){
  if(touch == false){
    if($('.btooltip').length){
      $('.btooltip').tooltip();
    }
  }
}
    
/* Handle product quantity */
function handleQuantity(){
  if($('body .quantity-wrapper').length){
    $('body').on(clickEv, '.quantity-wrapper .qty-up', function() {
      var $this = $(this);
      
      var qty = $this.data('src');
      $(qty).val(parseInt($(qty).val()) + 1);
    });
    $('body').on(clickEv, '.quantity-wrapper .qty-down', function() {
      var $this = $(this);
      
      var qty = $this.data('src');
      
      if(parseInt($(qty).val()) > 1)
        $(qty).val(parseInt($(qty).val()) - 1);
    });
  }
}
    
/* Handle sidebar */
function handleSidebar(){
  /* Add class first, last in sidebar */
  if($('.sidebar').length){
    $('.sidebar').children('.row-fluid').first().addClass('first');
    $('.sidebar').children('.row-fluid').last().addClass('last');
  }
}
    
/* Handle sort by */
function handleSortBy(){
  if($('#sortForm li.sort').length){
    $('#sortForm li.sort').click(function(){
      
      var button = $('#sortButton');
      var box = $('#sortBox');
      
      $('#sortButton .name').html($(this).html());
      
      button.removeClass('active');
      box.hide().parent().removeClass('open');
    });
  }
}
    
/* Handle dropdown box */
function handleDropdown(){
  if($('.dropdown-toggle').length){
    $('.dropdown-toggle').parent().hover(function (){
      if(touch == false && getWidthBrowser() > 768 ){
        $(this).find('.dropdown-menu').stop(true, true).slideDown(300);
      }
    }, function (){
      if(touch == false && getWidthBrowser() > 768 ){
        $(this).find('.dropdown-menu').hide();
      }
    });
  }
  
  $('nav .dropdown-menu').each(function(){
    $(this).find('li').last().addClass('last');
  });
  
  $('.dropdown').on('click', function() {
      if(touch == false && getWidthBrowser() > 768 ){
        var href = $(this).find('.dropdown-link').attr('href');
        window.location = href;
    }
  });
  
  $('.cart-link').on('click', function() {
      if(touch == false && getWidthBrowser() > 768 ){
        var href = $(this).find('.dropdown-link').attr('href');
        window.location = href;
    }
  });
}
    
/* Handle collection tags */
function handleCollectionTags(){
  if($('#collection_tags').length){
    $('#collection_tags').on('change', function() {
      window.location = $(this).val();
    });
  }
}
   
/* Handle menu with scroll*/
function handleMenuScroll(){
  var scrollTop = $(this).scrollTop();
  var heightNav = $('#top').outerHeight();
  
  if(touch == false && getWidthBrowser() >= 1024){
    if(scrollTop > heightNav){
      if(!$('#top').hasClass('on')){
        $('<div style="min-height:'+heightNav+'px"></div>').insertBefore('#top');
        $('#top').addClass('on').addClass('animated');
      }
    }
    else{
      if($('#top').hasClass('on')){
        $('#top').prev().remove();
        $('#top').removeClass('on').removeClass('animated');
      }
    }
  }
}

/* Handle when window resize */
$(window).resize(function() {

  /* re-call position quickshop */
  positionQuickshop();
  
  /* reset menu with condition */
  if(touch == true || getWidthBrowser() < 1024){
    if($('#top').hasClass('on')){
      $('#top').prev().remove();
      $('#top').removeClass('on').removeClass('animated');
    }
    
    $('#goGrid').trigger('click');
  }
});


/* Handle Related Product Tabs */
function handleTabsRelated(){
	//  When user clicks on tab, this code will be executed
	$(".head_tabs").on('click', function() {
	  
	  if(!$(this).parent().hasClass('active')) {

		//  First remove class "active" from currently active tab
		$(".head_tabs").parent().removeClass("active");
		
		//  Here we get the data-src(parent) value of the selected tab
		var $src_tab = $(this).attr("data-src");
		
		//  Now add class "active" to the selected/clicked tab
		$($src_tab).parent().addClass("active");
		
		//  Hide all tab content
		$(".content_tabs").addClass('hide');
		
		//  Here we get the href value of the selected tab
		var $selected_tab = $(this).attr("href");
		
		//  Show the selected tab content
		$($selected_tab).removeClass('hide');
		
		// Scroll to content
		$('html, body').animate({
		  scrollTop: $($selected_tab).offset().top - 170
		}, 300, function() {
			// re-call position quickshop
			positionQuickshop();
		});
	  }
	  
	  //  At the end, we add return false so that the click on the link is not executed
	  return false;
	});
	
	initTabs();
	function initTabs(){
	  $('#tabs-content li').find('h2').removeClass('active');
	  $('#tabs-content li').first().find('h2').addClass('active');
	}
}

/* Handle Quickshop */
function handleQuickshop(){
	$('body').on('click','.quick_shop',function(e){
		var action = $(this).attr('data-href');
		var target = $(this).attr('data-target')
		$(target).load(action, function() {
			$('#top').addClass('z-idx');
			
			$('.btooltip').tooltip();
			var zoomImage = $('.elevatezoom_qs .img-zoom');
			
			zoomImage.elevateZoom({
			  gallery:'gallery_main_qs', 
			  galleryActiveClass: 'active', 
			  zoomType: 'window',
			  cursor: 'pointer',
			  zoomWindowFadeIn: 300,
			  zoomWindowFadeOut: 300,
			  scrollZoom: true,
			  easing : true,
			  loadingIcon: './assets/images/loader.gif'
			});
			
			//pass the images to Fancybox
			$(".elevatezoom_qs .img-zoom").bind("click", function(e) {  
			  var ez =   $('.elevatezoom_qs .img-zoom').data('elevateZoom');	
			  $.fancybox(ez.getGalleryList(),{
				closeBtn  : false,
				helpers : {
				  buttons	: {}
				}
			  });
			  return false;
			});
			
			$("#gallery_main_qs").show().owlCarousel({
			  navigation : true,
			  pagination: false,
			  items: 4,
			  itemsDesktop : [1199,3],
			  itemsDesktopSmall : [979,3],
			  itemsTablet: [768,3],
			  itemsMobile : [479,3],
			  scrollPerPage: true,
			  navigationText: ['<i class="fa fa-angle-left" title="Previous"></i>', '<i class="fa fa-angle-right" title="Next"></i>']
			});
		});
		
		e.preventDefault();
	});
  
	$('body').on('hidden.bs.modal', '.modal', function() {
		$(this).empty();
		$('.zoomContainer').css('z-index', '1');
		$('#top').removeClass('z-idx');
	});
}

/* Handle when window scroll */
$(window).scroll(function() {
  /* re-call handle menu when scroll */
  handleMenuScroll();
});

// handle when window loaded 
$(window).load(function() {
  //if(touch == false){
    //skrollr.init();
  //}

  /* re-call position quickshop */
  positionQuickshop();
});

jQuery(document).ready(function($) {

  /* DETECT PLATFORM */
  handleDetectPlatform();
  
  /* Handle Animate */
  handleAnimate();
  
  /* Handle Carousel */
  handleCarousel();
  
  /* Handle search box on pc */
  handleBoxSearch();
  
  /* Handle search box on mobile */
  callbackSearchMobile();
  
  /* Handle position quickshop */
  positionQuickshop();

  /* Handle scroll to top */
  handleScrollTop();
  
  /* Handle dropdown box */
  handleDropdown();
  
  /* handle menu when scroll */
  handleMenuScroll();
  
  /* Handle tooltip */
  handleToolTip();
  
  /* Handle Map with GMap */
  handleMap();
  
  /* Handle sidebar */
  handleSidebar();
  
  /* Handle Quickshop */
  handleQuickshop();
  
  /* Handle zoom for product image */
  alwaysUpdateZoom();
  
  /* Handle quantity */
  handleQuantity();
  
  /* Handle Related Product Tabs */
  handleTabsRelated();
  
  /* Handle product thumbs */
  if(touch){
    updateScrollThumbs();
  }

  /* Handle sort by */
  handleSortBy();
     
  /* Handle grid - list */
  handleGridList();
  
  /* Handle collection tags */ 
  handleCollectionTags();
     
  $('.dropdown-menu').on(clickEv, function (e) {
    e.stopPropagation();
  });
  $('.dropdown-menu').on('click', function (e) {
    e.stopPropagation();
  });
  $('.btn-navbar').on('click', function() {
    return true;
  });
});