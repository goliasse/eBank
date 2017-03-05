var app = angular.module('app',[]);
app.controller('ctrl', function($scope){
});


app.directive('backImg', function(){
	return function(scope, element, attrs){
		var url = attrs.backImg;
		element.css({
			'background-image': 'url(' + url +')',
			'background-size' : 'cover'
		});
	};
});