document.body.onload = adddiv;
document.onmousedown = recordobj;
document.ondblclick = dbclick;
document.onmouseup = showselect;
varstarobj, isdb = false, allow = true;
function isallow() {
	if (allow) {
		allow = false;
		alert('isclosed');
	} else {
		allow = true;
		alert('isopend');
		
	}
}
function dbclick() {
	isdb = true;
}
function recordobj() {
	starobj = event.srcElement;
}
function showselect() {
	varstr = "";
	if (event.srcElement.tagName != "A" && event.srcElement.tagName != "INPUT" && event.srcElement == starobj && !isdb && allow) {
		varoText = document.selection.createRange();
		if (oText.text.length > 0) {
			str = oText.text;
			oText.text = "BuB" + oText.text + "EuE";
		}
		oText.select();
		event.srcElement.innerHTML = event.srcElement.innerHTML.replace("BuB", "<ustyle='FONT-WEIGHT:bold;COLOR:#ff3366'>").replace("EuE", "</u>");
	}
	searchgoogle(str)
	isdb = false;
}
function searchgoogle(str) {
	varobj = document.getElementById("searchgoogle");
	if (str.length > 0) {
		obj.style.display = "block";
		obj.style.position = "absolute";
		obj.style.zindex = 999;
		obj.style.posTop = document.body.scrollTop + event.y - 25;
		obj.style.posLeft = document.body.scrollLeft + event.x + 5;
		obj.style.widht = 80;
		obj.innerHTML = "<atarget=_blankhref=http://www.google.com/search？ie=UTF-8&oe=UTF-8&q=" + str + "style='BORDER-RIGHT:royalbluethinsolid;BORDER-TOP:royalbluethinsolid;FONT-WEIGHT:bold;BORDER-LEFT:royalbluethinsolid;CLIP:rect(autoautoautoauto);COLOR:#ffffff;BORDER-BOTTOM:royalbluethinsolid;BACKGROUND-COLOR:inactivecaption;TEXT-DECORATION:none'>SearchIt！</a>";
	} else {
		obj.style.display = "none";
	}
}
function adddiv() {
	varmobj = document.createElement("div");
	mobj.id = "searchgoogle";
	document.body.appendChild(mobj);
}