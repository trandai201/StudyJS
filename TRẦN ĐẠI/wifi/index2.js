var Intruder = require('intruder');
var intruder = Intruder();

intruder.on('TP-LINK_8AAC', function(ivs) {
        console.log(ivs);
    })
    .crack('TP-LINK_8AAC', function(err, key) {
        // if (err) throw new Error(err);
        console.log(key);
    });