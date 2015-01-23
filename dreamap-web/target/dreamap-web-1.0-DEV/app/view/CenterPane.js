/**
 * Created by UwieSilent on 1/11/2015.
 */
Ext.define('app.view.CenterPane', {
    extend: 'Ext.panel.Panel',
    xtype: 'center',
    frame: true,
    html: "<div id='map' style='height:100%; width:100%;z-index=: 1000;'></div>"
});
