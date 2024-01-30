
function duck(){
	document.getElementById('duck').style.fontSize = document.getElementsByName('test')[0].value + "em";
}

function action(a){
	if (a == 1){
		document.getElementById("ghostface").style.opacity = "50%";	
    document.getElementById("gift").style.rotate = "-20deg";
    
    
	} else{
		document.getElementById("ghostface").style.opacity = "100%";
    document.getElementById("gift").style.rotate = "-10deg";
   

	}
}

var i = 0;

function gift(){
  animation = ["😶","😐","🙂","😀","😃","😄","😁","😂", "😶", "😐", "😕", "🙁", "😦", "😧", "😞", "😔", "😟", "😭"]
  document.getElementById("face").innerHTML = animation[i];
  i += 1; if (i == animation.length){i=0;}
}

var startghostface = function(){var i=0;while(i < 999){(function(i) {setTimeout(function() {action(i%2);}, 300 * i)})(i++)}};
startghostface();

var startemoji = function(){var i=0;while(i < 999){(function(i) {setTimeout(function() {gift();}, 1000 * i)})(i++)}};
startemoji();