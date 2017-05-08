var animNob

function AnimacionJuanito(){
    this.y = height/2;
    this.x = 64;
    
    this.gravity = 1;
    this.velocity = 0;
    this.animNob = createSprite;
    this.anima = 0;
    
    this.display = function(){
        spriteMode=(CENTER);
        createSprite(this.x,this.y,0,0);
        this.anima = this.animNob.addAnimation("stand", "pas1min.png");
    
        this.anima.offY=0;
        this.animNob.addAnimation("walk", "pas1min.png","pas2min.png","pas3min.png");
    }
    this.show = function(){
        this.anima = this.animNob.addAnimation("stand", "pas1min.png");
    
        this.anima.offY=0;
        this.animNob.addAnimation("walk", "pas1min.png","pas2min.png","pas3min.png");
    
    }
    this.update = function (){
        this.velocity += this.gravity;
        this.y += this.velocity;
    
    }
}