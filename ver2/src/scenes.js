Crafty.scene('Game', function(){
	this.occupied = new Array(Game.width());
	for (var x = 0; x < Game.width(); x++){
	    this.occupied[x] = new Array(Game.map_grid.height);
	    for (var y = 0; y < Game.map_grid.height; y++){
		this.occupied[x][y] = false;
		if (y == 0){
		    Crafty.e('Ceiling').at(x, y);
		    this.occupied[x][y] = true;
		}
		else if ( y == Game.map_grid.height / 2){
		    Crafty.e('Platform').at(x, y);
		    this.occupied[x][y] = true;
		}
		else if (y == Game.map_grid.height - 1){
		    Crafty.e('Bottom').at(x, y);
		    this.occupied[x][y] = true;
		}
	    }
	}

	this.player = Crafty.e('Player').at(5, Game.map_grid.height / 2);
	Crafty.viewport.follow(this.player, 0, 10);
	this.occupied[this.player.at().x][this.player.at().y] = true;
	for (var x = this.player.at().x + Game.map_grid.tile.width; x < Game.width() - Game.map_grid.tile.width; x ++){
	    if (Math.random() < 0.3){
		if (Math.random() < 0.5){
		    for (var y = 0; y < Game.map_grid.height / 2 + 2; y++){
			Crafty.e('Pipe').at(x, y);
			this.occupied[x][y] = true;
		    }
		}
		else {
		    for (var y = Game.map_grid.height / 2 - 2; y < Game.map_grid.height - 1; y++){
			Crafty.e('Pipe').at(x, y);
			this.occupied[x][y] = true;
		    }
		}
		x += 5;
	    }
	}
	Crafty.audio.play('Stronger');
	for (var y = 0; y < Game.map_grid.height; y++){
	    Crafty.e('Goal').at(Game.width() - 1, y);
	}
    });


Crafty.scene('Loading', function(){
	Crafty.e('2D, DOM, Text')
	    .text('Loading...')
	    .attr({x: 0, y: Game.height() / 2 - 24, w: Game.width()})
	    .css($text_css);
	
	Crafty.audio.add('Stronger', ['sounds/Stronger.mp3', 'sounds/Stronger.wav', 'sounds/Stronger.ogg']);
	
	Crafty.load(['assets/16x16_forest_1.gif'], function(){
		Crafty.sprite(16, 'assets/16x16_forest_1.gif', {
			spr_wall: [0, 1],
			spr_pipe: [0, 0],
		        spr_panda: [1, 1]
		});
		Crafty.scene('Game');
	    });
    });

Crafty.scene('Game Over', function(){
	Crafty.audio.stop();
	var gO = Crafty.e('2D, DOM, Text')
	    .text('Sorry, you lose! Press any key to restart.')
	    .attr({x: 0, y: Game.height() / 2, w: Game.width()})
	    .css($text_css)
	    .bind('KeyDown', function(e){
		    Crafty.enterScene('Loading');
		});
	Crafty.viewport.follow(gO, 0, 0);
    });	    

Crafty.scene('Victory', function(){
	Crafty.audio.stop();
	var winner = Crafty.e('2D, DOM, Text')
	    .text("YOU WIN!!! Press any key to restart.")
	    .attr({x: 0, y: Game.height() / 2, w: Game.width()})
	    .css($text_css)
	    .bind('KeyDown', function(e){
		    Crafty.enterScene('Loading');
		});
	Crafty.viewport.follow(winner, 0, 0);
    });