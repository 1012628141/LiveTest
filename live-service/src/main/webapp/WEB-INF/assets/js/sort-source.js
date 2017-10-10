$(function(){
	var $list=$(".table >tbody")
	$list.sortable({
		opacity: 0.6, //设置拖动时候的透明度
        revert: true, //缓冲效果
        cursor: 'move', //拖动的时候鼠标样式
        handle: 'td',  //可以拖动的部位，模块的标题部分
	})
})