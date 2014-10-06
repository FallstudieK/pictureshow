var wo = null; //damit wir wissen wo wir uns befinden und welches Bild als nächstes geöffnet werden soll
function oeffnefenster(w) {
document.getElementById('weisseflaeche').style.display = 'block';
document.getElementById('pfeillinks').style.display = 'block';
document.getElementById('pfeilrechts').style.display = 'block';
document.getElementById('xbutton').style.display = 'block';
if(w == 1) {
wo = 1;
document.getElementById('fst1').style.display = 'block';
document.getElementById('fst2').style.display = 'none';
document.getElementById('fst3').style.display = 'none';
document.getElementById('fst4').style.display = 'none';
}
if(w == 2) {
wo = 2;
document.getElementById('fst1').style.display = 'none';
document.getElementById('fst2').style.display = 'block';
document.getElementById('fst3').style.display = 'none';
document.getElementById('fst4').style.display = 'none';
}
if(w == 3) {
wo = 3;
document.getElementById('fst1').style.display = 'none';
document.getElementById('fst2').style.display = 'none';
document.getElementById('fst3').style.display = 'block';
document.getElementById('fst4').style.display = 'none';
}
if(w == 4) {
wo = 4;
document.getElementById('fst1').style.display = 'none';
document.getElementById('fst2').style.display = 'none';
document.getElementById('fst3').style.display = 'none';
document.getElementById('fst4').style.display = 'block';
}
}
function closeall() {
document.getElementById('weisseflaeche').style.display = 'none';
document.getElementById('pfeillinks').style.display = 'none';
document.getElementById('pfeilrechts').style.display = 'none';
document.getElementById('xbutton').style.display = 'none';
document.getElementById('fst1').style.display = 'none';
document.getElementById('fst2').style.display = 'none';
document.getElementById('fst3').style.display = 'none';
document.getElementById('fst4').style.display = 'none';
}
function back() {
wo--;
if(wo == 0) {
setTimeout("oeffnefenster('4')",0);
}
if(wo == 1) {
setTimeout("oeffnefenster('1')",0);
}
if(wo == 2) {
setTimeout("oeffnefenster('2')",0);
}
if(wo == 3) {
setTimeout("oeffnefenster('3')",0);
}
}
function next() {
wo++;
if(wo == 5) {
setTimeout("oeffnefenster('1')",0);
}
if(wo == 2) {
setTimeout("oeffnefenster('2')",0);
}
if(wo == 3) {
setTimeout("oeffnefenster('3')",0);
}
if(wo == 4) {
setTimeout("oeffnefenster('4')",0);
}
}