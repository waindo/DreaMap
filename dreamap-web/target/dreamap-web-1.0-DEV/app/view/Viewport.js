Ext.define('app.view.Viewport', {
    extend: 'Ext.container.Viewport',
    requires: [
        'Ext.layout.container.Fit',
        'app.view.GridListKontrak',
        'app.view.DetailKontrak',
        'app.view.GridDigitasiOrder',
        'app.view.AssignmentDigitasiOrder',
        'app.view.VerifikasiData',
        'app.view.security.usergroup.list',

        'app.view.WestPane',
        'app.view.CenterPane',
    ],

    layout: {
        type: 'border',
        padding: '3 3 3 3'
    },

    items: [{
            region: 'north',
            dockedItems: [{
                dock: 'top',
                xtype: 'toolbar',
                style: 'background-color: lightgrey;',
                items: [{
                    xtype: 'panel',
                    frame: true,
                    border: false,
                    html: '<img src="resources/img/dreamap_logo.png" width="120px" height="31px">'
                }, {
                    xtype: 'splitbutton',
                    //text: 'Menu Button',
                    scale:'large',
                    iconCls:'menu',
                    menu: [{
                       
                        text: 'Prototype Grid List Kontrak',
                        handler: function(){
                            var glk = Ext.create('app.view.GridListKontrak', {
                                width: 500,
                                height: 350,
                        });
                            glk.show();
                        }
                    },{
                         text: 'Prototype Detail Kontrak',
                        handler: function(){
                            var dk = Ext.create('app.view.DetailKontrak', {
                                width: 525,
                                height: 360,
                        });
                            dk.show();
                        }
                    },{
                       
                        text: 'Prototype Grid List Digitasi Order',
                        handler: function(){
                            var gldo = Ext.create('app.view.GridDigitasiOrder', {
                                width: 600,
                                height: 350,
                        });
                            gldo.show();
                        }
                    },{
                         text: 'Prototype Assigment Digitasi Order',
                        handler: function(){
                            var ado = Ext.create('app.view.AssignmentDigitasiOrder', {
                                width: 375,
                                height: 210,
                        });
                            ado.show();
                        }
                    },{
                         text: 'Prototype Verifikasi Data',
                        handler: function(){
                            var ado = Ext.create('app.view.VerifikasiData', {
                                width: 650,
                                height: 570,
                        });
                            ado.show();
                        }
                    },{
                        text: 'Prototype User Group',
                        handler: function(){
                            var ugroup = Ext.create('app.view.security.usergroup.list', {
                                width: 650,
                                height: 570
                            });
                            ugroup.show();
                        }
                    }
                    ]
                }, '->', {
                    //text: 'Log Out',
                    scale:'large',
                    iconCls:'lock',
                    handler: function() {
                        window.location = app.config.logoutUrl;
                    }
                }]
            }]
        },
        {
             region: 'west',
             xtype: 'west',
             width: 250
        },
        {
            region: 'center',
            //frame: true,
            //html: "<div id='map' style='height:100%; width:100%;z-index=: 1000;'></div>",
            xtype: 'center'
        }
    ]
});