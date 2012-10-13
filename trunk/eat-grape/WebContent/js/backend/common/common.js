/* 消息提示框 */
function showMsg(msg, time)
{
	art.dialog({
		title : "温馨提示",
		content : msg,
		left : '50%',
		top : '50%',
		icon : 'face-sad',
		time : time,
	    drag : false,
	    fixed : true,
		close : function(){
			art.dialog.close();
		}
	}).lock();
}