Crafty.c('Grid', {
	init: function(){
	    this.attr({
		    w: Game.map_grid.tile.width,
		    h: Game.map_grid.tile.height
	    })
	},

	at: function(x, y){
	    if (x === undefined && y === undefined){
		return {x: this.x/Game.map_grid.tile.width,
			y: this.y/Game.map_grid.tile.height};
	    }
	    else {
		this.attr({x: x * Game.map_grid.tile.width,
			   y: y * Game.map_grid.tile.height});
		return this;
	    }
	}
});

Crafty.c('Actor', {
	init: function(){
	    this.requires('2D, Canvas, Grid');
	}
    });


Crafty.c('Goal', {
	init: function(){
	    this.requires('Actor, Solid, spr_wall');
	}
    });

Crafty.c('Ceiling', {
	init: function(){
	    this.requires('Actor, Solid, Collision, spr_wall');
	}
    });

Crafty.c('Platform', {
	init:function(){
	    this.requires('Actor, Collision, Floor, spr_wall');
	}
    });

Crafty.c('Bottom', {
	init:function(){
	    this.requires('Actor, Solid, Collision, Floor, spr_wall');
	}
    });

Crafty.c('Pipe', {
	init: function(){
	    this.requires('Actor, Solid, spr_pipe');
	}

    });

Crafty.c('Player', {
	init:function(){
	    this.requires('Actor, Collision, Gravity, Multiway, spr_panda')
		.multiway(10, {UP_ARROW: -90, DOWN_ARROW: 90})
		.gravity('Floor')
		.stopOnSolids();
	    this.bind('EnterFrame', function(){
		    this.x += 1;
		});
	},

	stopOnSolids: function(){
	    this.onHit('Ceiling', this.stopY);
	    this.onHit('Bottom', this.stopY);
	    this.onHit('Pipe', this.stopMovement, this.dead);
	    this.onHit('Goal', this.win);
	    return this;
	},

	stopY: function(){
	    if (this._movement){
		this.y -= this._movement.y;
	    }
	},

	stopMovement: function(){
	    this._speed = 0;
	    if (this._movement){
		this.x -= this._movement.x;
		this.y -= this._movement.y;
	    }
	},
	
        dead: function(){
	    Crafty.scene('Game Over');
	},
	    
	win: function(){
	    Crafty.scene('Victory');
	}

    });

