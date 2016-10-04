/**
 * Created by stevenma on 9/27/16.
 */
$(document).ready(function() {

    // Open homepage
    var loadTarget = document.getElementById("home");
    var targetTab = document.getElementById("home-tab");
    loadTarget.style.display = "block";
    targetTab.className += " active";
    $(loadTarget).load("views/home.html");

});
