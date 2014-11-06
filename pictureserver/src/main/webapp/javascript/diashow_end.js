//        var a = new Array(50);
//        var i = 0;
//        var res= "BilderService?album="+album;
//        $.getJSON(res, function(data) {
//            $.each(data, function(i, bild) {
//            var bildurl ="http://localhost:8087/pictureserver/rest/api/bild/"+bild.username+"/"+bild.title;
//           //$("#data").append("<li><a href=\"#\"><strong>"+bild.title+"</strong><img id=\"Bilder\" src=\""+bildurl+"\" style=\"height:200px;\" alt=\""+bildurl+"\" ></a></li>");
//
//                i++;
//                a[i] = bildurl;
//
//
//               alert(a [ 1 ]);
//                 }
//            });
//
//var bild1 = new Image();
//			bild1.src = 'bildurl';
//			var bild2 = new Image();
//			bild2.src = 'bilder/bild2.JPG';
//			var bild3 = new Image();
//			bild3.src = 'bilder/bild3.JPG';
//			var bild4 = new Image();
//			bild4.src = 'bilder/bild4.JPG';
//			var bild5 = new Image();
//			bild5.src = 'bilder/bild5.JPG';
//			var bild6 = new Image();
//			bild6.src = 'bilder/bild6.JPG';


			var bildoben = 0;
			var bildunten = 1;
			var op = 1;
			var op_ie = 100;

			var diebilder = new Array('bilder/bild1.JPG','bilder/bild2.JPG','bilder/bild3.JPG', 'bilder/bild4.JPG', 'bilder/bild5.JPG', 'bilder/bild6.JPG');
			var lang = diebilder.length;

			function slider() {
				var rahmen1 = document.getElementById('bild1');
				var rahmen2 = document.getElementById('bild2');

				rahmen1.src = diebilder[bildoben];
				rahmen2.src = diebilder[bildunten];
				rahmen1.style.opacity = '1';
				rahmen1.style.filter = 'alpha(opacity=100)';

				bildoben++;
				bildunten++;
				if((bildoben+1) == lang) {
					bildunten = 0;
				}
				if(bildoben == lang && bildunten == 1) {
					bildoben = 0;
					bildunten = 1;
				}
				window.setTimeout("slidemove()",3000);
			}
			function slidemove() {
				if(op > 0) {
					op = op - 0.1;
					op_ie = op_ie - 10;
					document.getElementById('bild1').style.opacity = op;
					document.getElementById('bild1').style.filter = 'alpha(opacity=' + op_ie + ')';
					window.setTimeout("slidemove()",100);
				} else {
					op = 1;
					op_ie = 100;
					window.setTimeout("slider()",0);
				}
			}
