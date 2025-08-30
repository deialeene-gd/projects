function Letter(char, x, y) {
    this.char = char;
    this.x = x;
    this.y = y;
    
    this.dx = -ctx.measureText(char).width / 2;
    this.dy = +opts.charSize/ 2;
    
    this.fireworkDy = this.y - hh;
    
    var hue = (x/calc.totalWidth) * 360;
    
    this.color = "hsl(hue, 88%, 50%)".replace("hue", hue);
    this. lightColor = "hsl (hue, 80%, light%)".replace("hue", hue);
    this.alphaColor = "hsla (hue, 80%, 50%,alp)".replace("hue", hue);
    
    this.reset();
}
    
Letter.prototype.reset = function () {
    this.phase = "firework";
    this.tick = 0;
    this.spawned = false;
    this.spawningTime = (opts.fireworkSpawnTime * Math.random())| 0;
};