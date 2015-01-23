Ext.define('app.view.GridDigitasiOrder', {
    extend: 'Ext.window.Window',
    requires: ['Ext.window.Window'],
    layout: 'fit',
    autoShow: true,
    title: 'List Digitasi Order',
    constrain: true,
    tbar:[
        '->'
    ,{
        text: 'Approve',
        iconCls: 'approve'
    },{
        text: 'Refresh',
        iconCls: 'reload',
    }],
    items:[{
        xtype: 'grid',
        viewConfig: {
            stripeRows: true,
            enableTextSelection: true
        },
        selType: 'checkboxmodel',
        columns:[{
            text:'Kode DO',
            width: 100
        },{
            text: 'Jenis Aset',
            flex: 1
        },{
            text: 'Nama Aset',
            flex: 1
        },{
            text:'Status',
            width: 100
        },{
            text: 'Assign',
            width :100
        },{
                menuDisabled: true,
                sortable: false,
                xtype: 'actioncolumn',
                width: 50,
                items: [{
                    iconCls: 'view-col',
                    tooltip: 'view',
                }]
        }],
        bbar: {
                xtype: 'pagingtoolbar',
                id:'gridlistdigitasiorderpager',
                pageSize: 10,
                displayInfo: true,
                emptyMsg: "Daftar kontrak tidak tersedia !",
            }
    }]


  
});