var login = {
    login:function(content,length,scbf,ecbf){
        length = length || 3000;
        return cordova.exec(scbf,ecbf,"LoginPlugin","login",[content,length]);
    },
    finish:function(content,length,scbf,ecbf){
        length = length || 3000;
        return cordova.exec(scbf,ecbf,"LoginPlugin","finish",[content,length]);
    }
}
module.exports = login;
