var WiFiControl = require('wifi-control');

  WiFiControl.init({
    debug: true
  });
 
  //  Try scanning for access points:
  WiFiControl.scanForWiFi( function(err, response) {
    if (err) console.log(err);
    console.log(response);
  });