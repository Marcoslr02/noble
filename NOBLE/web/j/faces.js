function faces()
{
    var backgroundStart;
    var start;
    
    var menu;
    var deshboard;
    var status;
    
    var backgroundAnimation;
    var characterPersonaAnimation;
    var characterZombieAnimation;
    var item1Animation;
    var item2Animation;
    var item3Animation;
    var item4Animation;
    var item5Animation;
    var item6Animation;
    
    this.init = function()
    {
        
        backgroundStart=loadImage('','');
        start=loadImage('','');
        
        menu=loadImage('','');
        deshboard=loadImage('','');
        status=loadImage('','');
        
        backgroundAnimation=loadAnimation('','');
        characterPersonaAnimation=loadAnimation('','');
        characterZombieAnimation=loadAnimation('','');
        item1Animation=loadAnimation('','');
        item2Animation=loadAnimation('','');
        item3Animation=loadAnimation('','');
        item4Animation=loadAnimation('','');
        item5Animation=loadAnimation('','');
        item6Animation=loadAnimation('','');
        
        backgroundAnimation.frameDelay = 0;
        characterPersonaAnimation.frameDelay = 0;
        characterZombieAnimation.frameDelay = 0;
        item1Animation.frameDelay = 0;
        item2Animation.frameDelay = 0;
        item3Animation.frameDelay = 0;
        item4Animation.frameDelay = 0;
        item5Animation.frameDelay = 0;
        item6Animation.frameDelay = 0;
        
    }
    
    this.getBackgroundStart = function()
    {
        return backgroundStart;
    }
    
    this.getStart = function()
    {
        return start;
    }
    
    this.getMenu = function()
    {
        return menu;
    }
    
    this.getDeshboard = function()
    {
        return deshboard;
    }
    
    this.getStatus = function()
    {
        return status;
    }
    
    this.getBackgroundAnimation = function()
    {
        return backgroundAnimation;
    }
    
    this.getCharacterPersonaAnimation = function()
    {
        return characterPersonaAnimation;
    }
    
    this.getItem1Animation = function()
    {
        return item1Animation;
    }
    
    this.getItem2Animation = function()
    {
        return item2Animation;
    }
    
    this.getItem3Animation = function()
    {
        return item3Animation;
    }
    
    this.getItem4Animation = function()
    {
        return item4Animation;
    }
    
    this.getItem5Animation = function()
    {
        return item5Animation;
    }
    
    this.getItem6Animation = function()
    {
        return item6Animation;
    }
    
}