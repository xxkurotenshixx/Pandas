Crafty.c('Grid', {
  init: function(){
    this.attr({
      w: Game.map_grid.tile.width,
      h: Game.map_grid.tile.height
    });
  },
  
  //locate this entity on the grid
  at: function(x, y){
    if (x === undefined && y === undefined){
      return { x: this.x/Game.map_grid.tile.width, y:this.y/Game.map_grid.tile.height };
    } else {
      this.attr({ x: x * Game.map_grid.tile.width, y: y * Game.map_grid.tile.height });
      return this;
    }
  }
});

//an actor is an entity tht is drawn in 2d on canvas
//via coordinate grid
Crafty.c('Actor', {
  init: function(){
    this.requires('2D, Canvas, Grid');
  }
});

Crafty.c('Pipe', {
  init: function() {
    this.requires('Actor, Solid, Color');
    //this.requires('Actor, Solid, pipe sprite file');
    this.color('rgb(20, 125, 40)');
  },
  hit: function() {
    Crafty.trigger('PipeHit', this);
  }
});

Crafty.c('PlayerCharacter', {
  init: function() {
    this.requires('Actor, Fourway, Collision, Color')
    //this.requires('Actor, Fourway, Collision, panda sprite file, SpriteAnimation')
      .fourway(2)
      .stopOnSolids()
      .onHit('Pipe', this.runIntoPipe);
      this.color('rgb(100, 20, 80)')
  },
  //causes it to stop moving when it hits an entity w/ the solid component
  stopOnSolids: function() {
    this.onHit('Solid', this.stopMovement);
    return this;
  },
  //Stops movement
  stopMovement: function() {
    this._speed = 0;
    if (this._movement) {
      this.x -= this._movement.x;
      this.y -= this._movement.y;
    }
  },
  //responds to player hitting a pipe
  runIntoPipe: function(data){
    pippe = data[0].obj;
    pippe.hit();
  }
});
      
Crafty.c('Goal', {
  init: function() {
    this.requires('Actor, Solid, Color');
    //this.requires('Actor, Solid, pipe sprite file');
    this.color('rgb(20, 125, 40)');
  },
  hit: function() {
    Crafty.trigger('EndGoal', this);
  }
});
