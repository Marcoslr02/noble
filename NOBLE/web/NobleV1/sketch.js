var noble;
var animNob;
var backgroundN1;
var y=0;
var x=0;
var anima;
var spr1;
var spr2;
var spr3;
var spr4;
var spr5;
var spr6;
var spr7;
var spr8;
var spr9;
var spr10;
var spr11;
var spr12;
var spr13;
var spr14;
var spr15;



var tri;
var moves;


function preload(){

}

function setup(){
//Canvas NIVEL 1
    backgroundN1=loadImage('images/Nivel1re.png');
    createCanvas(974,611);

//Sprite NOBLE :D
    animNob = createSprite(x,y,0,0);
    spriteMode=(CENTER);
    
    
    anima = animNob.addAnimation("stand", "pas1min.png");
    
    anima.offY=0;
    animNob.addAnimation("walk", "pas1min.png","pas2min.png","pas3min.png");
    
    
//Primer objeto para delimitar
    
    spr1 = createSprite(width/2,590,180,100,10);
    
    //spr1.shapeColor = color(0,0,0,0);
    
    spr2 = createSprite(940,590,70,170);
    
    /*tri = createSprite(40,570,10,150);
    tri.rotation=-50;
    */
    spr3 = createSprite(10,590,30,60);
    spr4 = createSprite(390,590,30,90);
    spr5 = createSprite(365,590,30,70);
    spr6 = createSprite(345,590,30,50);
    spr7 = createSprite(325,590,30,30);
    
    spr8 = createSprite(300,600,30,20);
    
    
    spr3 = createSprite(10,590,20,80);
    spr9 = createSprite(30,590,20,60);
    spr10 = createSprite(50,590,20,45);
    spr11 = createSprite(70,590,20,25);
    spr12 = createSprite(90,600,20,18);
    spr13 = createSprite(110,600,20,10);
    spr14 = createSprite(120,600,20,5);
    spr15 = createSprite(200,615,300,20);

    spr16 = createSprite(700,605,300,20);
    spr17 = createSprite(600,605,30,100)

    
    
    
}
function draw(){
//MOSTRAR CANVAS CON IMAGEN
    background(backgroundN1);
    
    if (animNob.position.y >= height) {
    //animNob.velocity.y *= -1.45;
    
        // set to height to prevent "tunneling"
    animNob.position.y = height;
  }
  // constant downward speed
  // (i.e., gravity)
  animNob.addSpeed(0.50, 90);
    
    
    
    
//MOVIMIENTOS    
    if(keyIsDown(LEFT_ARROW)) {
    animNob.changeAnimation("walk");
    //flip horizontally
    animNob.mirrorX(1);
    //negative x velocity: move left
    animNob.velocity.x = - 2.3;
  }
  else if(keyIsDown(RIGHT_ARROW)) {
    animNob.changeAnimation("walk");
    //unflip 
    animNob.mirrorX(-1);
    animNob.velocity.x = 2.3;
  }
  else {
    //if close to the mouse, don't move
    animNob.changeAnimation("stand");
    animNob.velocity.x = 0;
  }
  

  if(keyIsDown (UP_ARROW)) {
    //the rotation is not part of the spinning animation
    animNob.rotation -= 10;
    animNob.changeAnimation("walk");
  }
  else
    animNob.rotation = 0;

  
  //up and down keys to change the scale
  //note that scaling the image quality deteriorates
  //and scaling to a negative value flips the image
/*

  if(keyIsDown(UP_ARROW))
    animNob.scale += 0.05;
    if(keyIsDown(DOWN_ARROW))
    animNob.scale -= 0.05;
*/

    
//Pa delimitar carnal
    animNob.collide(spr1);
    animNob.collide(spr2);
    animNob.collide(spr3);
    animNob.collide(spr4);
    animNob.collide(spr5);
    animNob.collide(spr6);
    animNob.collide(spr7);
    animNob.collide(spr8);
    animNob.collide(spr9);
    animNob.collide(spr10);
    animNob.collide(spr11);
    animNob.collide(spr12);
    animNob.collide(spr13);
    animNob.collide(spr14);
    animNob.collide(spr15);
    animNob.collide(spr16);
    //animNob.collide(spr17);
    
    //animNob.collide(spr9);
    
  
    
    
//triangle(pos,pix,pos,pix,pos,pix)    
   //triangle(0,550,0,610,160,611);
    
    

    
   drawSprites();
    
    
    
//LINEA CHINGONA
    
    stroke(226,204,0);
    line(0,y,width,y);
    y++;
    if(y> height){
        y=0;
    }
    
    /*
    line(0,x,height,x);
    x++;
    if(x>width){
        x=0
    }
    */
    
    
    
   
    
}
