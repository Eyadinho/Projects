// Global variables
var gameContainer = document.getElementById("game-container");
var cannon = document.getElementById("cannon");
var target = document.getElementById("target");
var targetPieces = document.getElementsByClassName("target-piece");
var blocker = document.getElementById("blocker");
var cannonball = document.getElementById("cannonball");
var timer = document.getElementById("timer");
var score = document.getElementById("score");

var timeLeft = 10;
var shotsFired = 0;
var targetsHit = 0;

// Add event listener for clicking on the game container
gameContainer.addEventListener("click", function(event));{
	// Calculate the angle and distance from the click to the center of the cannon
	var angle = Math.atan2(event.clientY - cannon.offsetTop, event.clientX - cannon.offsetLeft) * 180 / Math.PI;
	var distance = Math.sqrt(Math.pow(event.clientY - cannon.offsetTop, 2) + Math.pow(event.clientX - cannon.offsetLeft, 2));

	// Fire the cannon if there is not already a cannonball on the screen
	if (!cannonball.classList.contains("on-screen")) {
		cannonball.style.left = (cannon.offsetLeft + cannon.offsetWidth / 2) + "px";
		cannonball.style.top = (cannon.offsetTop + cannon.offsetHeight / 2) + "px";
		cannonball.style.transform = "rotate(" + angle + "deg)";
		cannonball.classList.add("on-screen");
		shotsFired++;
		playSound("fire");
	}

	// Move the cannonball and check for collisions
	var intervalId = setIntervalfunction(); {
		cannonball.style.left = (cannonball.offsetLeft + Math.cos(angle * Math.PI / 180) * 10) + "px";
		cannonball.style.top = (cannonball.offsetTop - Math.sin(angle * Math.PI / 180) * 10) + "px";

		// Check for collision with the target
		for (var i = 0; i < targetPieces.length; i++) {
			if (checkCollision(cannonball, targetPieces[i])) {
				targetPieces[i].style.display = "none";
				cannonball.classList.remove("on-screen");
				targetsHit++;
				playSound("break");
				if (targetsHit == targetPieces.length) {
					winGame();
				}
				timeLeft += 3;
				updateTimer();
				break;
			}
		}

		// Check for collision with the blocker
		if (checkCollision(cannonball, blocker)) {
			cannonball.style.transform += "rotate(180deg)"
		}
	}
}