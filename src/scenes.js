
//loading scene 
Crafty.defineScene("loading", function() {
    Crafty.background("#000");
    Crafty.e("2D, DOM, Text")
          .attr({ w: 100, h: 20, x: 150, y: 120 })
          .text("Loading")
          .css({ "text-align": "center"})
          .textColor("#FFFFFF");
});

// An example of an init function which accepts arguments, in this case an object.
Crafty.defineScene("square", function(attributes) {
    Crafty.background("#000");
    Crafty.e("2D, DOM, Color")
          .attr(attributes)
          .color("red");

});

//---------------------------------
//Core Gameplay
//---------------------------------
Crafty.scene('Game', function() {
  // A 2D array to keep track of all occupied tiles
  this.occupied = new Array(Game.map_grid.width);
  for (var i = 0; i < Game.map_grid.width; i++) {
    this.occupied[i] = new Array(Game.map_grid.height);
    for (var y = 0; y < Game.map_grid.height; y++) {
      this.occupied[i][y] = false;
    }
  }

	// Player character, placed at 5, 5 on our grid
	this.player = Crafty.e('PlayerCharacter').at(5, 5);
	this.occupied[this.player.at().x][this.player.at().y] = true;
 
	// Place a pipe at every edge square on our grid of 16x16 tiles
	for (var x = 0; x < Game.map_grid.width; x++) {
		for (var y = 0; y < Game.map_grid.height; y++) {
			var at_edge = x == 0 || x == Game.map_grid.width - 1 || y == 0 || y == Game.map_grid.height - 1;
 
			if (at_edge) {
				// Place a tree entity at the current tile
				Crafty.e('Tree').at(x, y)
				this.occupied[x][y] = true;
			} else if (Math.random() < 0.06 && !this.occupied[x][y]) {
				// Place a bush entity at the current tile
				var bush_or_rock = (Math.random() > 0.3) ? 'Bush' : 'Rock'
				Crafty.e(bush_or_rock).at(x, y)
				this.occupied[x][y] = true;
			}
		}
	}

});


//Victory Scene
Crafty.scene('Victory', function() {
  Crafty.e('2D, DOM, Text')
    .attr({ x: 0, y: 0 })
    .text('Victory!');
 
  this.restart_game = this.bind('KeyDown', function() {
    Crafty.scene('Game');
  });
}, function() {
  this.unbind('KeyDown', this.restart_game);
});
	   
//Game Over Scene
Crafty.scene('Game Over', function() {
  Crafty.e('2D, DOM, Text')
    .attr({ x: 0, y: 0 })
    .text('Game Over!');
 
  this.restart_game = this.bind('KeyDown', function() {
    Crafty.scene('Game');
  });
}, function() {
  this.unbind('KeyDown', this.restart_game);
});