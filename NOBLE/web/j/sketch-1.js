var walkvillano = 3;
var mode = 1;

var villano;
var villano2;

var darko;
var frank;
var animacionDarko;
var animacionFrank;

var sceneCount = 1;
var phase = 0.0;
var phaseInc = 1.0 / 64.0;

var noble;
var animNob;
var backgroundN1;
var y=0;
var x=0;
var ground = 0;

var quimi;

var psx=0;
var psy=0;

var score=0;


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
var spr16;
var spr17;
var spr18;
var spr19;
var spr20;
var spr21;
var spr22;
var spr23;
var spr24;
var spr25;
var spr26;
var spr27;
var spr28;
var spr29;
var spr30;
var spr31;
var spr32;
var spr33;
var spr34;
var spr35;
var spr36;
var spr37;
var spr38;
var spr39;
var spr40;
var spr41;
var spr42;
var spr43;
var spr44;
var spr45;
var spr46;
var spr47;





var tri;
var moves;

var GRAVITY = 8;
var WALKGRAVITY = 1;
var JUMP = 4;
var canjump = false;


function preload(){
   fuente = loadFont('sources/TinyPixy.ttf');
 
    
}

function setup(){

    
    //Canvas NIVEL 1
    backgroundN1=loadImage('images/Nivel1re.png');
    createCanvas(974,611);

//Sprite NOBLE :D
    animNob = createSprite(20,40,0,0);
    
    
    animNob.addAnimation("stand", "images/pas1.png");
    animNob.addAnimation("walk", "images/pas1.png","images/pas2.png","images/pas3.png");
    animNob.addAnimation("jump", "images/jump.png");
    animNob.addAnimation("muerto", "images/die.png");
    animNob.offY=0;
    animNob.scale = .8;    
	//animNob.animation.frameDelay = 1;
    animNob.position.x = 420; //80
	animNob.position.y =500;
    
    
    
    
    /*darko.position.x=200;
    darko.position.y=height/2;*/
   /*darko.offY=0;
    
    //Sprite Frank
    
    /*animacionFrank.position.x = width/2;
    animacionFrank.position.y = 100;*/
    /*frank.offY=0;
    frank.scale = .8;*/

  animacionDarko = createSprite(0,0,0,0); animacionDarko.addAnimation("baila","images/dark1.png","images/dark2.png","images/dark3.png","images/dark4.png","images/dark5.png","images/dark6.png","images/dark7.png","images/dark8.png","images/dark9.png","images/dark10.png","images/dark11.png","images/dark12.png","images/dark13.png","images/dark14.png","images/dark15.png","images/dark16.png","images/dark17.png","images/dark18.png","images/dark19.png","images/dark20.png","images/dark21.png","images/dark22.png","images/dark23.png","images/dark24.png","images/dark25.png","images/dark26.png","images/dark27.png","images/dark28.png");
        animacionDarko.scale = .2;
        
villano2 = animacionDarko;
      

  animacionFrank = createSprite(0,0,0,0); animacionFrank.addAnimation("canta","images/f1.png","images/f2.png","images/f3.png","images/f4.png","images/f5.png","images/f6.png","images/f7.png","images/f8.png","images/f9.png","images/f10.png","images/f11.png");
        animacionFrank.scale = .2;
villano = animacionFrank;
       
 
   
    coins = new Group();
  for (var i = 0; i < 10; i++) {
    quimi = createSprite(600,130,0,0);
    quimi.addAnimation('red', 'images/quimi.png');
    quimi.scale = .15;
    coins.add(quimi);
  }
    /*for (var i = 0; i < 10; i++) {
    quimi = createSprite(600,130,0,0);
    quimi.addAnimation('red', 'images/quimi.png');
    quimi.scale = .15;
    quimi.onMouseOver = removeAndScore;
  }*/
    
    
    
//Creacion de sprites rectangulares para delimitar plataformas
    
    /*tri = createSprite(40,570,10,150);
    tri.rotation=-50;
    */
    //bloque central
    spr1 = createSprite(487,590,180,100,10);
    //bloque derecho
    spr2 = createSprite(940,590,70,170);
    //bloque izquierdo
    spr3 = createSprite(10,590,25,80);
    spr4 = createSprite(390,590,25,80);
    //del bloque central a la izquierda
    spr5 = createSprite(365,590,25,70);
    spr6 = createSprite(345,590,25,50);
    spr7 = createSprite(325,590,25,30);
    spr8 = createSprite(300,600,25,20);
    //parte del bloque izquierdo
    spr9 = createSprite(30,590,25,60);
    spr10 = createSprite(50,590,25,40);
    spr11 = createSprite(70,590,25,20);
    spr12 = createSprite(90,600,25,20);
    spr13 = createSprite(110,600,25,10);
    spr14 = createSprite(120,605,25,10);
    //Limite inferior
    spr15 = createSprite(200,615,1550,20);
    //parte del bloque central a la derecha
    spr16 = createSprite(730,605,140,45);
    
    spr17 = createSprite(590,600,28,105);
    spr45 = createSprite(615,600,25,88);
    spr46 = createSprite(640,600,25,68);
    spr47 = createSprite(663,600,23,50);
    //Limite derecho
    spr18 = createSprite(970,450,10,900);
    
    //BLOQUE DERECHO
    spr48 = createSprite(803,605,20,66);
    spr49 = createSprite(823,605,20,86);
    spr50 = createSprite(842,605,20,106);
    spr51 = createSprite(862,605,20,136);
    spr52 = createSprite(882,605,20,165);
    spr53 = createSprite(902,605,20,184);
    
    //limite superior
    spr19 = createSprite(479,-10,974,10);
    
    spr20 = createSprite(565,415,30,20);
    spr21 = createSprite(600,409,40,40);
    spr22 = createSprite(650,390,55,60);
    spr23 = createSprite(699,380,100,60);
    spr24 = createSprite(750,390,50,60);
    spr25 = createSprite(790,400,50,60);
    spr26 = createSprite(820,420,50,60);
    /*spr27 = createSprite(370,410,0,0);*/
    /*spr28 = createSprite(330,400,50,5);*/
    spr29 = createSprite(300,389,50,50);
    spr30 = createSprite(230,379,100,50);
    spr31 = createSprite(189,365,60,50);
    spr32 = createSprite(150,350,50,50);
    spr33 = createSprite(120,320,50,50);
    spr34 = createSprite(50,300,100,50);
    spr35 = createSprite(170,200,40,50);
    spr36 = createSprite(200,185,40,50);
    spr37 = createSprite(250,175,75,50);
    spr38 = createSprite(290,190,45,50);
    spr39 = createSprite(325,205,60,50);
    spr40 = createSprite(650,180,250,50);
    spr41 = createSprite(785,195,30,50);
    spr42 = createSprite(890,260,50,50);
    spr43 = createSprite(920,240,50,50);
    spr44 = createSprite(940,225,45,50);
//Transparencia de los sprites
    
    spr1.shapeColor = color(0,0,0,0);
    spr2.shapeColor = color(0,0,0,0);
    spr3.shapeColor = color(0,0,0,0);
    spr4.shapeColor = color(0,0,0,0);
    spr5.shapeColor = color(0,0,0,0);
    spr6.shapeColor = color(0,0,0,0);
    spr7.shapeColor = color(0,0,0,0);
    spr8.shapeColor = color(0,0,0,0);
    spr9.shapeColor = color(0,0,0,0);
    spr10.shapeColor = color(0,0,0,0);
    spr11.shapeColor = color(0,0,0,0);
    spr12.shapeColor = color(0,0,0,0);
    spr13.shapeColor = color(0,0,0,0);
    spr13.shapeColor = color(0,0,0,0);
    spr14.shapeColor = color(0,0,0,0);
    spr15.shapeColor = color(0,0,0,0);
    spr16.shapeColor = color(0,0,0,0);     
    spr17.shapeColor = color(0,0,0,0);
    spr45.shapeColor = color(0,0,0,0);
    spr46.shapeColor = color(0,0,0,0);
    spr47.shapeColor = color(0,0,0,0);
    
    spr18.shapeColor = color(0,0,0,0);
    spr19.shapeColor = color(0,0,0,0);
    spr20.shapeColor = color(0,0,0,0);
    spr21.shapeColor = color(0,0,0,0);
    spr22.shapeColor = color(0,0,0,0);
    spr23.shapeColor = color(0,0,0,0);
    spr24.shapeColor = color(0,0,0,0);
    spr25.shapeColor = color(0,0,0,0);
    spr26.shapeColor = color(0,0,0,0);
    spr29.shapeColor = color(0,0,0,0);
    spr30.shapeColor = color(0,0,0,0);
    spr31.shapeColor = color(0,0,0,0);
    spr32.shapeColor = color(0,0,0,0);
    spr33.shapeColor = color(0,0,0,0);
    spr34.shapeColor = color(0,0,0,0);
    spr35.shapeColor = color(0,0,0,0);
    spr36.shapeColor = color(0,0,0,0);
    spr37.shapeColor = color(0,0,0,0);
    spr38.shapeColor = color(0,0,0,0);
    spr39.shapeColor = color(0,0,0,0);
    spr40.shapeColor = color(0,0,0,0);
    spr41.shapeColor = color(0,0,0,0);
    spr42.shapeColor = color(0,0,0,0);
    spr43.shapeColor = color(0,0,0,0);
    spr44.shapeColor = color(0,0,0,0);
    spr45.shapeColor = color(0,0,0,0);
    spr46.shapeColor = color(0,0,0,0);
    spr47.shapeColor = color(0,0,0,0);
    spr48.shapeColor = color(0,0,0,0);
    spr49.shapeColor = color(0,0,0,0);
    spr50.shapeColor = color(0,0,0,0);
    spr51.shapeColor = color(0,0,0,0);
    spr52.shapeColor = color(0,0,0,0);
    spr53.shapeColor = color(0,0,0,0);

    
    
    
}
function die() {
  if (animNob.overlap(villano))
    animNob.changeAnimation("muerto");
    scene3()=true; 
  updateSprites(false);}
function dies() {
  if (animNob.overlap(villano2))
    animNob.changeAnimation("muerto");
    scene3()=true; 
  updateSprites(false);}
  //mode = 2;
 /*else (animNob.overlap(villano2)){
    animNob.changeAnimation("muerto");
    scene3()=true; 
  updateSprites(false);}
  //mode = 2;*/


function draw(){
    villano.visible = true;
    animacionDarko.position.x = width/2;
    animacionDarko.position.y = 475;
    animacionFrank.position.x = 675;
    animacionFrank.position.y = 300;
    villano.velocity.x = walkvillano;
    villano.velocity.x = walkvillano;
    

    if (villano.overlap(animNob)) {
    die();
    mode = 3;
  }
    if (villano2.overlap(animNob)) {
    dies();
    mode = 3;
  }
    
    
    
   
//MOSTRAR CANVAS CON IMAGEN
    background(backgroundN1);
    animNob.overlap(coins, getCoin);
    fill(128 + sin(frameCount*0.1) * 128);
    textFont(fuente);
    textSize(50);
    textAlign(CENTER, CENTER);
  if (coins.length > 0) {
    text(score, 850, 25);
  }
  else {
    text("ahuevo", 850, 25);
      sceneCount = 3; 
  }
    /*textSize(72);
  textAlign(CENTER, CENTER);
 
    if (score < 10) {
    text(score, width/2, height/2);
  }
  else {
    text("you win!", width/2, height/2);
  }*/

    
   /* animNob.velocity.y += GRAVITY;
    animNob.position.y = height;*/
    
    
    
//MOVIMIENTOS    
    if(keyIsDown(LEFT_ARROW)) {
        animNob.changeAnimation("walk");
    //flip horizontally
        animNob.mirrorX(1);
    //negative x velocity: move left
        animNob.velocity.x = - 2.3;
        animNob.velocity.y = WALKGRAVITY;
    }
    else if(keyIsDown(RIGHT_ARROW)) {
        animNob.changeAnimation("walk");
    //unflip 
        animNob.mirrorX(-1);
        animNob.velocity.x = 2.3;
        animNob.velocity.y = WALKGRAVITY;

    }
    /*else if(keyIsDown (CONTROL)) {
        the rotation is not part of the spinning animation
        animNob.rotation -= 10;
        animNob.changeAnimation("jump");
    else if{
        animNob.rotation = 0;
        }*/
    
    else  if (keyIsDown(UP_ARROW)){
        animNob.changeAnimation("jump");
		canjump = true;
		animNob.position.y=animNob.position.y -= JUMP
        //animNob.maxforce = 0.5; 
        //animNob.limitSpeed (2);
        if (animNob.position.y >= 300) {
            animNob.velocity.y -= 0;
        }
    }
    
    
    else {
    //Si no se aprieta ninguna tecla...
        animNob.position.y += GRAVITY;
        animNob.changeAnimation("stand");
        animNob.velocity.x = 0;
    }
    
   
    
    	
    /*else if {
    //Si no se aprieta ninguna tecla...
        animNob.changeAnimation("stand");
        animNob.velocity.x = 0;
    }
     else if(keyIsDown (CONTROL)) {
        //the rotation is not part of the spinning animation
        animNob.rotation -= 10;
        animNob.changeAnimation("jump");
    }
    else
        animNob.rotation = 0;
    
    if(keyIsDown(ESCAPE)){
        animNob.scale += 0.05;
    }
    if(keyIsDown(SHIFT)){
        animNob.scale -= 0.05;
    }
*/
    
//Pa delimitar carnal
    animNob.collide(spr19);

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
    animNob.collide(spr17);
    animNob.collide(spr18);
    animNob.collide(spr19);
    
    animNob.collide(spr20);
    animNob.collide(spr21);
    animNob.collide(spr22);
    animNob.collide(spr23);
    animNob.collide(spr24);
    animNob.collide(spr25);
    animNob.collide(spr26);
    animNob.collide(spr29);
    animNob.collide(spr30);
    animNob.collide(spr31);
    animNob.collide(spr32);
    animNob.collide(spr33);
    animNob.collide(spr34);
    animNob.collide(spr35);
    animNob.collide(spr36);
    animNob.collide(spr37);
    animNob.collide(spr38);
    animNob.collide(spr39);
    animNob.collide(spr40);
    animNob.collide(spr41);
    animNob.collide(spr42);
    animNob.collide(spr43);
    animNob.collide(spr44);
    animNob.collide(spr45);
    animNob.collide(spr46);
    animNob.collide(spr47);
    animNob.collide(spr48);
    animNob.collide(spr49);
    animNob.collide(spr50);
    animNob.collide(spr51);
    animNob.collide(spr52);
    animNob.collide(spr53);
    /*animNob.collide(spr54);
    animNob.collide(spr55);*/
    
    
  
    
    
//triangle(pos,pix,pos,pix,pos,pix)    
   //triangle(0,550,0,610,160,611);
    
    
 
    
   drawSprites();
    
    if(sceneCount === 1){
        scene1();   
    }else if(sceneCount === 2){
        scene2();   
    }else if(sceneCount === 3){
        scene3();   
    }

    
    
//LINEA CHINGONA
    
    stroke(226,204,0);
    line(0,y,width,y);
    y++;
    if(y> height){
        y=0;
    }
    phase += phaseInc;
    if (phase >= 1.0) {
        phase -= 1.0;
    }
}
    /*
    line(0,x,height,x);
    x++;
    if(x>width){
        x=0
    }
    */
    
    
    
   
    

function getCoin(player, coin) {
  coin.remove();
  score += 1;
}
/*function score() {
  score += 1;
  this.remove();
}*/
var scene1 = function(){
    background(0);
    textAlign(CENTER, CENTER);
    fill(255 * phase, 255, 255);
    textSize(85);
    text("NOBLE", width/2, 200);
    textSize(40);
    text("V1", width/2, 300);
    text("NO MORIREMOS!!!!", width/2, 460);
    text("Haz click", width/2, 500);
    text("", width/2, 276);
    text("", width/2, 306);
};
var scene2 = function(){
    /*background(0,0,0,0);*/
    
    };
var scene3 = function(){
    background(0);
    textAlign(CENTER, CENTER);
    fill(255 * phase, 255, 255);
    textSize(55);
    text("Tu puntaje es " + score, width/2, 300);
    textSize(45);
    text("¡ K A W A I I !", width/2, 380);
    /*text("Click para repetir \n salu2", 800, 550);*/
};
mouseClicked = function(){
    if(sceneCount === 1){
        sceneCount = 2;   
    }
    if(sceneCount === 3){
        animNob.position.x = width/2;
        animNob.position.y = height/2;
        
        score = 0;
        sceneCount = 2;   
    }
};