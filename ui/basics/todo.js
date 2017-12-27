var all = document.querySelectorAll("li");

for (var i =0; i < all.length; i++) {

	all[i].addEventListener("mouseover", function () {
	this.classList.add("selected");
	});

	all[i].addEventListener("mouseout", function () {
	this.classList.remove("selected");
	});

	all[i].addEventListener("click", function () {
	this.classList.toggle("done");
	});
}

