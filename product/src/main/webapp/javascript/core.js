/**
 * Created by stevenma on 9/27/16.
 */
$(document).ready(function() {
    window.onload = function() {
        if (!window.location.hash) {
            window.location = window.location + '#loaded';
            window.location.reload(true);
        }
    }
});
