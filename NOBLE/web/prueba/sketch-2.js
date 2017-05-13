var walkvillano = .9;
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
var quimi2;
var quimi3;
var quimi4;

var psx=0;
var psy=0;

var score=0;

var GRAVITY = 8;
var WALKGRAVITY = 1;
var JUMP = 4;
var canjump = false;

var centro ;
var centroverde;

function preload(){
       fuente = loadFont('sources/TinyPixy.ttf');
}

function setup(){
    backgroundN1=loadImage('images/fondo2.png');
    createCanvas(974,611);
    
    animNob = createSprite(20,100,0,0);
    animNob.addAnimation("stand", "images/pas1.png");
    animNob.addAnimation("walk", "images/pas1.png","images/pas2.png","images/pas3.png");
    animNob.addAnimation("jump", "images/jump.png");
    animNob.addAnimation("muerto", "images/die.png");
    animNob.offY=0;
    animNob.scale = 1;    
    animNob.position.x = 80;
	animNob.position.y =500;

    animacionDarko = createSprite(800,400,0,0); animacionDarko.addAnimation("baila","images/dark1.png","images/dark2.png","images/dark3.png","images/dark4.png","images/dark5.png","images/dark6.png","images/dark7.png","images/dark8.png","images/dark9.png","images/dark10.png","images/dark11.png","images/dark12.png","images/dark13.png","images/dark14.png","images/dark15.png","images/dark16.png","images/dark17.png","images/dark18.png","images/dark19.png","images/dark20.png","images/dark21.png","images/dark22.png","images/dark23.png","images/dark24.png","images/dark25.png","images/dark26.png","images/dark27.png","images/dark28.png");
    animacionDarko.scale = .2;
        villano2 = animacionDarko;
  
      
    animacionFrank = createSprite(800,500,0,0); animacionFrank.addAnimation("canta","images/f1.png","images/f2.png","images/f3.png","images/f4.png","images/f5.png","images/f6.png","images/f7.png","images/f8.png","images/f9.png","images/f10.png");
    animacionFrank.scale = .2;
        villano = animacionFrank;
    centro = createSprite(0,0,0,0);

    quimi = createSprite(600,130,0,0);
        quimi.addAnimation('red', 'images/quimi.png');
        quimi.scale = .15;
    
    quimi2 = createSprite(450,130,0,0);
        quimi2.addAnimation('red', 'images/quimi2.png');
        quimi2.scale = .15;
    
    quimi3 = createSprite(350,130,0,0);
        quimi3.addAnimation('red', 'images/quimi3.png');
        quimi3.scale = .15;
    
    quimi4 = createSprite(250,130,0,0);
        quimi4.addAnimation('red', 'images/quimi4.png');
        quimi4.scale = .15;
    
    
    coins = new Group();
    
    for (var i = 0; i < 10; i++) {
        
        coins.add(quimi);
        coins.add(quimi2);
        coins.add(quimi3);
        coins.add(quimi4);
    }
}

var draw = function() {

    background(backgroundN1);
    
    if (animNob.position.y >= 530) {
        animNob.position.y = 530;
    }
    if (animNob.position.x >= 955){
        animNob.position.x =955;
    }
    if (animNob.position.x <= 55){
        animNob.position.x = 55;
    }
    if (animNob.position.y <= 85){
        animNob.position.y = 85;
    }
    
    villano.velocity.x = -walkvillano;
    villano2.velocity.x = -.4;
    villano.velocity.y = GRAVITY;
    villano2.velocity.y = GRAVITY;
    
    if (villano.position.x <= 55){
        villano.position.x = 55;
        villano.mirrorX(-1);
        villano.visible.x = -5;
    }
    if (villano.position.x >= 955){
        villano.position.x =955;
        villano.mirrorX(-1);
    }
    
    if (villano2.position.x <= 55){
        villano2.position.x = 55;
        villano2.mirrorX(-1);

    }
    if (villano2.position.x >= 955){
        villano2.position.x =955;
        villano2.mirrorX(-1);
    }
    
    if (villano.position.y >= 510) {
        villano.position.y = 510;
    }
    if (villano2.position.y >= 510) {
        villano2.position.y = 510;
    }
    
    if(keyIsDown(LEFT_ARROW)) {
        animNob.changeAnimation("walk");
        animNob.mirrorX(1);
        animNob.velocity.x = - 2.3;
        animNob.velocity.y = WALKGRAVITY;
    }
    else if(keyIsDown(RIGHT_ARROW)) {
        animNob.changeAnimation("walk");
        animNob.mirrorX(-1);
        animNob.velocity.x = 2.3;
        animNob.velocity.y = WALKGRAVITY;

    }
    else  if (keyIsDown(UP_ARROW)){
        animNob.changeAnimation("jump");
		canjump = true;
		animNob.position.y=animNob.position.y -= JUMP;
        if (animNob.position.y >= 300) {
            animNob.velocity.y -= 0;
        }
    }
    else {
        animNob.position.y += GRAVITY;
        animNob.changeAnimation("stand");
        animNob.velocity.x = 0;
    }
    
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
    
    if (villano.overlap(animNob) || villano2.overlap(animNob) ) {
        die();
        mode = 3;
    }
  
     phase += phaseInc;
    if (phase >= 1.0) {
        phase -= 1.0;
    }
    
    drawSprites();
    
    if(sceneCount === 1){
        scene1();   
    }
    else if(sceneCount === 3){
        scene3();   
    }

}

function getCoin(player, coin) {
  coin.remove();
  score += 1;
}

function die() {
    if (animNob.overlap(villano) || (animNob.overlap(villano2))){
        scene3()=true; 
            updateSprites(false);
    }  
}

var scene1 = function(){
    background(0);
    
    textAlign(CENTER, CENTER);
    fill(255 * phase, 255, 255);
    textSize(85);
    text("NOBLE", width/2, 200);
    textSize(40);
    text("V1", width/2, 276);
    //text("NO MORIREMOS!!!!", width/2, 460);
    text("Haz click y \n Usa las flechas para moverte", width/2, 500);
    //text("Usa las flechas para moverte", width/2, 300);
    text("Diviertete", width/2, 406);
};
var scene2 = function(){
        draw () = drawSprites();

}
    

var scene3 = function(){
    
    background(0);
    textAlign(CENTER, CENTER);
    fill(255 * phase, 255, 255);
    textSize(55);
    text("Tu puntaje es " + score, width/2, 300);
    textSize(45);
    //text("¡ K A W A I I !", width/2, 380);
    text("Click para repetir", width/2, 380);
};

mouseClicked = function(){
    if(sceneCount === 1){
        sceneCount = 2;  
    }
    if(sceneCount === 3){
       score = 0;
       sceneCount = 2;   
    }
};

