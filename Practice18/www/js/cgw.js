$("a.MapOfMetal").on("click", function() {
    window.open('http://mapofmetal.com/#/home', '_blank');
});
$("a.MetalArchives").on("click", function() {
    window.open('https://www.metal-archives.com', '_blank');
});
//===
function MapOfMetal(url) {
  var win = window.open('http://mapofmetal.com/#/home', '_blank');
  win.focus();
}