/**
 * Created by stevenma on 9/28/16.
 */
function openPage(evt, pageName) {

    // If same page clicked, return
    if (evt.currentTarget.className.indexOf("active") != -1) {
        return;
    }

    // Get all elements with class="pagecontent" and hide them
    $('.pagecontent').each(function() {
        this.style.display = "none";
    });

    // Get all elements with class="pagelinks" and remove the class "active"
    $(".pagelinks").each(function() {
        this.className = this.className.replace(" active", "");
    });

    // Show the current page, and add an "active" class to the link that opened the page
    var loadTarget = document.getElementById(pageName);
    loadTarget.style.display = "block";
    evt.currentTarget.className += " active";
    $(loadTarget).load("views/" + pageName.toLowerCase() + ".html");

}

function closePage() {

}
