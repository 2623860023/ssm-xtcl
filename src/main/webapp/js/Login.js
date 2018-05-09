/*普通登录*/
    Btn=document.getElementsByClassName('C-R-Btn')[0];
    Lists=Btn.getElementsByTagName('li');
    var Tbox=document.getElementById("T-box");
    Cinput=Tbox.getElementsByTagName('div');
    for(var i=0;i<Lists.length;i++) {
        Lists[i].index = i;
        Lists[i].onclick = function () {
            for (var j = 0; j < Lists.length; j++) {
                Lists[j].className = "";
                Cinput[j].id = "";
            }
            this.className = "btn-on";
            Cinput[this.index].id = "C-R-show";
        }
    }



























































