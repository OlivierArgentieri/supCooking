// Carousel Functions
$(document).ready(function() {
  $('#media').carousel({
    pause: true,
    interval: false,
  });
});

// Navigation Functions
function openNav() {
  document.getElementById("mySidenav").style.width = "70%";
  // document.getElementById("flipkart-navbar").style.width = "50%";
  document.body.style.backgroundColor = "rgba(0,0,0,0.4)";
}

function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
  document.body.style.backgroundColor = "rgba(0,0,0,0)";
}