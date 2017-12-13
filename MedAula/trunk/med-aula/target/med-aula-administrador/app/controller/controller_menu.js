app.controller('ctrl_menu', function ($scope, $rootScope, $timeout) {

    $scope.$on('onLastRepeat', function (scope, element, attrs) {
        $timeout(function () {
            if (!$rootScope.miniSidebarActive) {
                // activate current section
                $('#sidebar_main').find('.current_section > a').trigger('click');
            } else {
                // add tooltips to mini sidebar
                var tooltip_elem = $('#sidebar_main').find('.menu_tooltip');
                tooltip_elem.each(function () {
                    var $this = $(this);

                    $this.attr('title', $this.find('.menu_title').text());
                    UIkit.tooltip($this, {});
                });
            }
        })
    });


    $scope.sections = [
        {
            id: 0,
            titulo: 'Data Set',
            icone: '&#xE02F;',
            submenu: [
                {
                    titulo: 'Tweets',
                    link: 'restricted.cadastro.especialidade'
                    
                },
                {
                    titulo: 'Análises',
                    link: 'restricted.principal'
                    
                }

            ]
        }]
    
    
});