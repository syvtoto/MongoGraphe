function draw(){
	var canvas = document.getElementById('canvasTrajet');
	var width = canvas.width  = window.innerWidth;
	var height = canvas.height = window.innerHeight;
	if (canvas.getContext) {
		var ctx = canvas.getContext('2d');
		ligne(ctx);
	    
	    point(ctx);
	    
	} else {
		// code pour le cas où canvas ne serait pas supporté
	}
}


function ligne(ctx){
	ctx.beginPath();
	ctx.lineWidth = 10;
    ctx.moveTo(50, 500);
    ctx.lineTo(ctx.canvas.width/2, 500);
    ctx.lineTo(ctx.canvas.width-50, 500);
    ctx.stroke();
}


function point(ctx){
	ctx.fillStyle = 'red';
    ctx.arc(50, 500, 20, 0, 2 * Math.PI);
    ctx.arc(ctx.canvas.width/2, 500, 20, 0, 2 * Math.PI);
    ctx.arc(ctx.canvas.width-50, 500, 20, 0, 2 * Math.PI);
    ctx.fill();
}