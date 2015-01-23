Ext.define('app.view.GridListKontrak', {
    extend: 'Ext.window.Window',
    requires: ['Ext.window.Window'],
    layout: 'fit',
    autoShow: true,
    title: 'List Kontrak',
    constrain: true,
    tbar:[
        '->'
    ,{
        text: 'Refresh',
        iconCls: 'reload'
    }],
    items:[{
        xtype: 'grid',
        viewConfig: {
            stripeRows: true,
            enableTextSelection: true
        },
        columns:[{
            text:'Kode WO',
            width: 100
        },{
            text: 'Jenis Aset',
            flex: 1
        },{
            text: 'Assign',
            width :100
        },{
                menuDisabled: true,
                sortable: false,
                xtype: 'actioncolumn',
                width: 50,
                items: [{
                    iconCls: 'edit-col',
                    tooltip: 'edit',
                }, {
                    iconCls: 'view-col',
                    tooltip: 'view',
                }]
        }],
        bbar: {
                xtype: 'pagingtoolbar',
                id:'gridlistkontrakpager',
                pageSize: 10,
                displayInfo: true,
                emptyMsg: "Daftar kontrak tidak tersedia !",
            }
    }]


  
});