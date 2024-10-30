function serachbutton() {
   var serach=document.getElementById('serach');
   if(serach.value=="") {
       alert("请输入搜索关键字");
       serach.focus();
       return false;
   }  else {
    return true; 
   }
}

function move() {
	var week=document.getElementById('week');
	week.style.backgroundColor="white";
	week.style.color="black";
}
function movein() {
	var week=document.getElementById('week');
    week.style.backgroundColor="#0f6bac";
	week.style.color="white";
}