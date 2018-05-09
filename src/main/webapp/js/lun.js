/**
 * Created by zhangyijie on 2017/8/5.
 */
var $bBox=$("#bBox");
var $sBox=$("#sBox");
var $img=$sBox.find("img");
var $ul=$bBox.find("ul");
var $lis=$ul.find("li");
var $right=$("#right");
var $left=$("#left");
var n=0;
var timer;
///////////////////////////////////1.�Զ��л�
timer=setInterval(autoMove,3000)
function autoMove(){
    if(n>=$img.length-1){
        n=0
        $sBox.css('left',0)
    }
    n++;
    $sBox.animate({'left':-1360*n},300);
  //  bindTip()
}
///////////////////////////////////2.�����Զ���
/*function bindTip(){
    var temp=(n>=$img.length-1?0:n)
    $.each($lis,function(index,item){
        item.className=index===temp?"on":null
    })
}*/
/////////////////////////////////�����Ƴ�
$bBox.mouseover(function(){
    clearInterval(timer)
    $right.show()
    $left.show()
})
$bBox.mouseout(function(){
    timer=setInterval(autoMove,3000)
    $right.hide()
    $left.hide()
})
//////////////////////////////////���
$right.click(function(){
    autoMove()
})
$left.click(function(){
    if(n<=0){
        n=$img.length-1
        $sBox.css('left',-n*1360)
    }
    n--;
    $sBox.animate({'left':-1360*n},300);
    bindTip()
})
/////////////////////////////�������ı�
//change()
//function change() {
//    $.each($lis, function (index, item) {
//         $(item).click(function(){
//             n=$(this).index()
//             $sBox.animate({'left':-830*n},300);
//             bindTip()
//         })
//    })
//}
/*change()
function change(){
    $.each($lis,function(index,item){
        $(item).click(function(){
            n=$(this).index()
            $sBox.animate({'left':-830*n},300)
            bindTip()
        })
    })
}
*/